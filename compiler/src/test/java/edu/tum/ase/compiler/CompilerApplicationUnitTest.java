package edu.tum.ase.compiler;

import edu.tum.ase.compiler.controller.CompilerController;
import edu.tum.ase.compiler.model.SourceCode;
import edu.tum.ase.compiler.service.CompilerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


    @RunWith(SpringRunner.class)
    public class CompilerApplicationUnitTest {

        @Autowired
        //private ProjectController systemUnderTest;
        private CompilerController compilerController;

        @MockBean
        //private ProjectRepository projectRepository;
        CompilerService compilerService;

        @Test
        public void should_ReturnStdErr_When_CompilingWrongSourceCode() throws IOException, InterruptedException {
            // given
            SourceCode sourceCode = new SourceCode();
            sourceCode.setStderr("Compilation_error");

            SourceCode wrongSourceCode = new SourceCode();
            wrongSourceCode.setCompilable(false);
            given(compilerService.compile(wrongSourceCode)).willReturn(sourceCode);

            // when
            SourceCode result = compilerController.compile(wrongSourceCode);

            // then
            then(result.getStderr()).isEqualTo(sourceCode.getStderr());
        }

        @Test
        public void should_ReturnStdOut_When_CompilingCorrectSourceCode() throws IOException, InterruptedException {
            // given
            SourceCode sourceCode = new SourceCode();
            sourceCode.setStdout("compilation_successful!");

            SourceCode correctSourceCode = new SourceCode();
            correctSourceCode.setCompilable(true);
            given(compilerService.compile(correctSourceCode)).willReturn(sourceCode);
            // when
            SourceCode result = compilerController.compile(correctSourceCode);

            // then
            then(result.getStdout()).isEqualTo(sourceCode.getStdout());
        }

        @TestConfiguration
        static class ProjectControllerTestsConfiguration {

            @Bean
            public CompilerController compilerController() {
                return new CompilerController();
            }
        }
    }



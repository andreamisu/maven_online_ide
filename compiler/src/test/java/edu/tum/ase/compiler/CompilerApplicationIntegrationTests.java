package edu.tum.ase.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import edu.tum.ase.compiler.model.SourceCode;
import edu.tum.ase.compiler.service.CompilerService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompilerApplicationIntegrationTests {

	@Autowired
	private CompilerService compilerService;

	@Test
	public void should_ReturnNotEmptyStderr_When_GivenANotCompilableCode() throws IOException, InterruptedException {

		// given
		SourceCode mock = new SourceCode("not compilable code", "mock.c", "", "", false);

		// when
		SourceCode result = this.compilerService.compile(mock);
		// then

		assertEquals(false, result.isCompilable());
		assertEquals(true, result.getStderr() != null);

	}

}
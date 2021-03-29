package edu.tum.ase.compiler;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tum.ase.compiler.model.SourceCode;
import edu.tum.ase.compiler.service.CompilerService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompilerApplicationE2ETests {
	private final String URL = "/compile";
	@Autowired
	private MockMvc systemUnderTest;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void should_ReturnNotCompilableSourceCode_When_PostWithANotCompilableSourceCode() throws Exception {
		// given
		SourceCode mock = new SourceCode("not compilable code", "mock.c", "", "", false);


		// when
		ResultActions result = systemUnderTest.perform(post(URL)
				.content(objectMapper.writeValueAsString(mock))
				.contentType(MediaType.APPLICATION_JSON));

		// then
		result
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.filename").value(mock.getFilename()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.compilable").value(false));
	}

	@Test
	public void should_ReturnCompilableSourceCode_When_PostWithACompilableSourceCode() throws Exception {
		// given
		SourceCode mock = new SourceCode("#include <stdio.h> \n main() { printf(\"Hello World!\"); }", "mock.c", "", "", false);


		// when
		ResultActions result = systemUnderTest.perform(post(URL)
				.content(objectMapper.writeValueAsString(mock))
				.contentType(MediaType.APPLICATION_JSON));

		// then
		result
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.filename").value(mock.getFilename()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.compilable").value(true));
	}
}
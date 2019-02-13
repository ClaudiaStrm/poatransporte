package com.example.poatransporte;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class PoatransporteApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

	protected final double DELTA = 0.1d;

	protected MockMvc restMockMvc;

	@Autowired
	protected MappingJackson2HttpMessageConverter jacksonMessageConverter;

	@Autowired
	protected ObjectMapper objectMapper;

	@Autowired
	protected PageableHandlerMethodArgumentResolver pageableArgumentResolver;

}


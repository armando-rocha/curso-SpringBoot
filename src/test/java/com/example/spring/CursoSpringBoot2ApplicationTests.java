package com.example.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.modelo.Persona;
import com.example.spring.util.StringUtil;

@SpringBootTest
class CursoSpringBoot2ApplicationTests {

	@Test
	void contextLoads() {
		Persona p1= Persona.builder().nombre("Armando").build();
		System.out.println(p1.getNombre());
		
		
		String res = StringUtil.aplicarSHA256("ABCD");
		System.out.println(res);
	}

}

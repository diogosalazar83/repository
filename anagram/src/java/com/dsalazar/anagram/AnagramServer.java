package com.dsalazar.anagram;


import java.awt.PageAttributes.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsalazar.anagram.exceptions.BadRequestException;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController
@Configuration
@EnableSwagger2
@RequestMapping(value = "/api/anagrams", produces = MediaType.APPLICATION_JSON_VALUE)
@SpringBootApplication
public class AnagramServer {


	@GetMapping("/{string1}/{string2}")
	public Anagrammer areAnagrams(@PathVariable String string1, @PathVariable String string2) {
		
		try {
			Anagrammer a = new Anagrammer();
			a.areAnagrams(string1, string2);
			return a;
		} catch (IllegalArgumentException e) {
			throw new BadRequestException(e);
		}
	}
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis( RequestHandlerSelectors.basePackage( "com.dsalazar.anagram" ) )
	        .paths(PathSelectors.any())
	        .build();
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AnagramController.class, args);
	}
	
}
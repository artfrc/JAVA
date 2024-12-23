package br.com.artfc.first_project_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.artfc")
public class FirstProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectSpringApplication.class, args);
	}

}

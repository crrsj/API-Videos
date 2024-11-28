package br.com.videos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - para Vídeos",
				version = "1.0",
				description = "Documentando uma API que cadastra videos",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class MyVideosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyVideosApplication.class, args);
	}

}

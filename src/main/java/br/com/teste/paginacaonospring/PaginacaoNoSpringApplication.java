package br.com.teste.paginacaonospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.teste.paginacaonospring.model.Course;
import br.com.teste.paginacaonospring.repository.CourseRepository;

@SpringBootApplication
public class PaginacaoNoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginacaoNoSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository repository) {
		return args -> {
			repository.deleteAll();
			for (int i = 0; i < 20; i++) {
				Course course = new Course();
				course.setName("Angular-" + i);
				course.setCategory("Front-End-" + i);
				repository.save(course);
			}

		};
	}

}
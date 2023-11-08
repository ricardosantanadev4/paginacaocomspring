package br.com.teste.paginacaonospring.dto;

import org.springframework.stereotype.Component;

import br.com.teste.paginacaonospring.model.Course;

@Component
public class CourseMapper {
	public CourseDto toDto(Course course) {
		return new CourseDto(course.getId(), course.getName(), course.getCategory());
	}
}
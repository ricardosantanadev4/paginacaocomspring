package br.com.teste.paginacaonospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.paginacaonospring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
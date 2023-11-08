package br.com.teste.paginacaonospring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;

import br.com.teste.paginacaonospring.dto.CourseDto;
import br.com.teste.paginacaonospring.dto.CourseMapper;
import br.com.teste.paginacaonospring.dto.CoursePageDTO;
import br.com.teste.paginacaonospring.model.Course;
import br.com.teste.paginacaonospring.repository.CourseRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Validated
@org.springframework.stereotype.Service
public class CourseService {
	private final CourseRepository repository;
	private final CourseMapper mapper;

	public CourseService(CourseRepository repository, CourseMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	/*
	 * como a classe CourseService e public outra classe Controller pode utlizar
	 * essa classe por isso as validacoes da Controller tambem foram adicionadas na
	 * Service.
	 * 
	 * para ultizar a paginacao e necessario utlizar findAll(Pageable pageble) do
	 * tipo Page<Course>
	 * 
	 * PageRequest.of(pageNumber, pageSize) contem os parametros pageNumber que e o
	 * numero da pagina e pageSize que e a quantidade elementos por pagina
	 * 
	 * necessario converter o objeto Page<Course> para List<CourseDto> nao expor a
	 * entidade
	 * 
	 * necessario retornar um CoursePageDTO para o metodo nao ficar prezo somente a
	 * um framework fazendo que a api possa ser utlizada por qualquer framework
	 * 
	 * page.get() e do tipo Stream<Course> com isso tem a mesma funcao do .Stream()
	 */
	public CoursePageDTO list(@PositiveOrZero int pageNumber, @Positive @Max(10) int pageSize) {
		Page<Course> page = repository.findAll(PageRequest.of(pageNumber, pageSize));
		List<CourseDto> courses = page.get().map(mapper::toDto).collect(Collectors.toList());
		return new CoursePageDTO(courses, page.getTotalElements(), page.getTotalPages());

	}

//	metodo list() antes da refatoracao 
//	public List<CourseDto> list() {
//		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
//	}

}
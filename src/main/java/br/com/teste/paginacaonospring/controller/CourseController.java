package br.com.teste.paginacaonospring.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.paginacaonospring.dto.CoursePageDTO;
import br.com.teste.paginacaonospring.service.CourseService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

// @Validated necessario para as valdacoes poderem funcionar no metodo
@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

	private final CourseService service;

	public CourseController(CourseService service) {
		this.service = service;
	}

	/*
	 * @RequestParam(defaultValue = "") define um valor padrao para os parametros,
	 * se nao for passado nenhum parametro como valor na url a api vai trabalhar com
	 * valor defull.
	 * 
	 * @PositiveOrZero permite que seja passado 0 ou numeros maiores que zero,
	 * numeros negativos nao e permitido.
	 * 
	 * @Positive permite numeros a partir de 1
	 * 
	 * @Max(10) define que o valor maximo passado no pametro e de 10, se passar o
	 * valor maior vai ser aparesentado um erro.
	 * 
	 * 
	 */
	@GetMapping
	public CoursePageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int pageNumber,
			@RequestParam(defaultValue = "10") @Positive @Max(10) int pageSize) {
		return service.list(pageNumber, pageSize);
	}
}
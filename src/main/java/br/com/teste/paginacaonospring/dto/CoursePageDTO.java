package br.com.teste.paginacaonospring.dto;

import java.util.List;

// como essa record vai ser utlizada somente para leitura, nao precisa adicionar as validacoes
public record CoursePageDTO(List<CourseDto> course, long totalElements, int totalPages) {

}
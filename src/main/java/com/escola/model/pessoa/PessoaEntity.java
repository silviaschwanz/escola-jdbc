package com.escola.model.pessoa;

import java.time.LocalDate;

public record PessoaEntity(
		Long codigo,
		String nome,
		String cpf,
		LocalDate dataNascimento,
		String endereco,
		String telefone
		) {

}

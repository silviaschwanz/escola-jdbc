package com.escola.model.pessoa.aluno;

import java.time.LocalDate;

public record DadosAluno(
		String nome,
		String cpf,
		LocalDate dataNascimento,
		String endereco,
		String telefone,
		Long numeroMatricula,
		LocalDate dataMatricula,
		boolean alunoEspecial
		) {
    
}

package com.escola.model.pessoa.aluno;

import java.time.LocalDate;

public record AlunoEntity(
    Long codigo,
    Long codigo_pessoa,
    Long numeroMatricula,
    LocalDate data_matricula,
    boolean aluno_especial
    ) {
    
}

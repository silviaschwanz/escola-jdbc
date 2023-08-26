package com.escola.model.curso.turma;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.escola.model.curso.Curso;
import com.escola.model.curso.Status;

public class Turma {
    
    private Long codigo;

    private Curso curso;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private LocalDateTime horario;

    private String local;

    private Status status;
    
}

package com.escola.model.pessoa.aluno;

import java.time.LocalDate;

import com.escola.model.pessoa.Pessoa;

public class Aluno extends Pessoa{
    
   	private Long numeroMatricula;

    private LocalDate dataMatricula;

    private boolean alunoEspecial;
    
    
    public Aluno(DadosAluno dadosAluno) {
		  super(dadosAluno);
      this.numeroMatricula = dadosAluno.numeroMatricula();
      this.dataMatricula = dadosAluno.dataMatricula();
      this.alunoEspecial = dadosAluno.alunoEspecial();
	}


    public Long getNumeroMatricula() {
      return numeroMatricula;
    }


    public LocalDate getDataMatricula() {
      return dataMatricula;
    }


    public boolean isAlunoEspecial() {
      return alunoEspecial;
    }  
    
}

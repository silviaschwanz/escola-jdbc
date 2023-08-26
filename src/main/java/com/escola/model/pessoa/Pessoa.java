package com.escola.model.pessoa;

import java.time.LocalDate;

import com.escola.model.pessoa.aluno.DadosAluno;

public class Pessoa {
    
    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

    private String endereco;
    
    private String telefone;
    
    public Pessoa(DadosAluno dadosAluno) {
    	this.nome = dadosAluno.nome();
    	this.cpf = dadosAluno.cpf();
    	this.dataNascimento = dadosAluno.dataNascimento();
    	this.endereco = dadosAluno.endereco();
    	this.telefone = dadosAluno.telefone();
    }

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}
    
    
}

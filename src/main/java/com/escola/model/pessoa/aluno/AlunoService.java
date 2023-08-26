package com.escola.model.pessoa.aluno;

import java.util.Optional;

import com.escola.MysqlConnection;
import com.escola.model.pessoa.PessoaDAO;
import com.escola.model.pessoa.PessoaEntity;

public class AlunoService {
    
	private MysqlConnection connectionService; 
 
            
    public AlunoService() {
		this.connectionService = new MysqlConnection();
	}
    

	public Aluno matricular(DadosAluno dadosAluno) {
		PessoaEntity pessoaEntity = cadastrarPessoa(dadosAluno);
		
		AlunoDAO alunoDAO = new AlunoDAO(connectionService.openConnection());
		Optional<AlunoEntity> alunoOptional = alunoDAO.salvar(dadosAluno, pessoaEntity.codigo());

		if(alunoOptional.isPresent()){
			return new Aluno(dadosAluno);
		}
		throw new RuntimeException("Aluno não matriculado");	
    	
    }

	private PessoaEntity cadastrarPessoa(DadosAluno dadosAluno) {
		PessoaDAO pessoaDAO = new PessoaDAO(connectionService.openConnection());
		Optional<PessoaEntity> pessoaOptional = pessoaDAO.salvar(dadosAluno);
		if(pessoaOptional.isPresent()){
			return pessoaOptional.get();
		}
		throw new RuntimeException("Pessoa não cadastrada!");
	}
	
	public void editar(DadosAluno dadosAluno) {
		
	}
	
	public void listarAlunos() {
		
	}
	
	public void listarTurmas() {
		
	}
	
	public void buscarDisciplinasDoCurso() {
		
	}
    
}

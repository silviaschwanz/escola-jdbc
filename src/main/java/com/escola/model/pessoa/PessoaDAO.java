package com.escola.model.pessoa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.escola.model.pessoa.aluno.DadosAluno;
import com.escola.model.pessoa.professor.DadosProfessor;

public class PessoaDAO {

	private Connection connection;


	public PessoaDAO(Connection connection) {
		this.connection = connection;
	}

	public Optional<PessoaEntity> salvar(DadosAluno dadosAluno) {

		String sql = "INSERT INTO pessoa(nome, cpf, data_nascimento, endereco, telefone) VALUES(?, ?, ?, ?, ?); ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dadosAluno.nome());
			preparedStatement.setString(2, dadosAluno.cpf());
			preparedStatement.setDate(3, Date.valueOf(dadosAluno.dataNascimento()));
			preparedStatement.setString(4, dadosAluno.endereco());
			preparedStatement.setString(5, dadosAluno.telefone());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			return buscarPeloNome(dadosAluno.nome());

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void salvar(DadosProfessor dadosProfessor) {
		
	}
	
	public Optional<PessoaEntity> buscarPeloNome(String nome) {
		String sql = "SELECT * FROM pessoa WHERE nome = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			ResultSet resultSet = preparedStatement.executeQuery();

			Optional<PessoaEntity> pessoaOptional = Optional.empty();

			preparedStatement.close();

			if(resultSet.next()){
				pessoaOptional = Optional.ofNullable(new PessoaEntity(
					resultSet.getLong("codigo"), 
					resultSet.getString("nome"), 
					resultSet.getString("cpf"), 
					resultSet.getDate("data_nascimento").toLocalDate(), 
					resultSet.getString("endereco"),
					resultSet.getString("telefone")
					));
			}

			resultSet.close();
			return pessoaOptional ;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}

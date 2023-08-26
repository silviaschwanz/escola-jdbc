package com.escola.model.pessoa.aluno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class AlunoDAO {
	
	private Connection connection;
	
	public AlunoDAO(Connection connection) {
		this.connection = connection;
	}
	


    public Optional<AlunoEntity> salvar(DadosAluno dadosAluno, Long codigoPessoa) {
    	
    	String sql = "INSERT INTO aluno(codigo_pessoa, numero_matricula, data_matricula, aluno_especial) VALUES(?, ?, ?, ?); ";
    	
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, codigoPessoa);
			preparedStatement.setLong(2, dadosAluno.numeroMatricula());
			preparedStatement.setDate(3, Date.valueOf(dadosAluno.dataMatricula()));
			preparedStatement.setBoolean(4, dadosAluno.alunoEspecial());
			preparedStatement.executeUpdate();
			preparedStatement.close();

			return buscarPorNumeroMatricula(dadosAluno.numeroMatricula());
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

	public Optional<AlunoEntity> buscarPorNumeroMatricula(Long numeroMatricula) {
		String sql = "SELECT * from aluno WHERE numero_matricula = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, numeroMatricula);
			ResultSet resultSet = preparedStatement.executeQuery();

			Optional<AlunoEntity> alunoOptional = Optional.empty();
			preparedStatement.close();

			if(resultSet.next()){
				alunoOptional = Optional.ofNullable(
					new AlunoEntity(
						resultSet.getLong("codigo"),
						resultSet.getLong("codigo_pessoa"),
						resultSet.getLong("numero_matricula"),
						resultSet.getDate("data_matricula").toLocalDate(),
						resultSet.getBoolean("aluno_especial")
					)
				);
			}
			resultSet.close();
			return alunoOptional;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
    
    public void editar() {
    	
    }
    
    public void listarTodos() {
    	
    }
    
    
}

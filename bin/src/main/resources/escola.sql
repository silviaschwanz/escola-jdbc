
CREATE TABLE pessoa(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(codigo),
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL,
    data_nascimento DATE NOT NULL,
    endereco VARCHAR(250) NOT NULL,
    telefone CHAR(15)
);

ALTER TABLE pessoa MODIFY COLUMN codigo BIGINT NOT NULL AUTO_INCREMENT;


CREATE TABLE disciplina(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    ementa TEXT NOT NULL,
    carga_horaria FLOAT NOT NULL,
    porcentagem_teoria FLOAT,
    porcentagem_pratica FLOAT,
    status ENUM('ATIVO', 'INATIVO') NOT NULL,
    PRIMARY KEY(codigo)
);

ALTER TABLE disciplina MODIFY COLUMN codigo BIGINT NOT NULL AUTO_INCREMENT;

CREATE TABLE curso(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    categoria ENUM('APERFEICOAMENTO', 'CAPACITACAO', 'OFICINA', 'TREINAMENTO') NOT NULL,
    data_criacao DATE,
    status ENUM('ATIVO', 'INATIVO') NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE aluno(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    codigo_pessoa BIGINT NOT NULL,
    numero_matricula BIGINT NOT NULL,
    data_matricula DATE NOT NULL,
    aluno_especial TINYINT(1) NOT NULL,
    PRIMARY KEY(codigo),
    FOREIGN KEY(codigo_pessoa) REFERENCES pessoa(codigo)
);

CREATE TABLE professor(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    codigo_pessoa BIGINT NOT NULL,
    numero_funcionario VARCHAR(9) NOT NULL,
    data_contratacao DATE NOT NULL,
    dedicacao_exclusiva TINYINT(1) NOT NULL,
    PRIMARY KEY(codigo),
    FOREIGN KEY(codigo_pessoa) REFERENCES pessoa(codigo)
);

CREATE TABLE turma(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    codigo_curso BIGINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    horario TIME NOT NULL,
    local VARCHAR(100),
    status ENUM('ATIVO', 'INATIVO'),
    PRIMARY KEY(codigo),
    FOREIGN KEY(codigo_curso) REFERENCES curso(codigo)
);

CREATE TABLE ministrante(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    codigo_professor BIGINT NOT NULL,
    codigo_disciplina BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    FOREIGN KEY(codigo_professor) REFERENCES professor(codigo),
    FOREIGN KEY(codigo_disciplina) REFERENCES disciplina(codigo)    
);

CREATE TABLE matricula(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    codigo_aluno BIGINT NOT NULL,
    codigo_turma BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    FOREIGN KEY(codigo_aluno) REFERENCES aluno(codigo),
    FOREIGN KEY(codigo_turma) REFERENCES turma(codigo)
);

CREATE TABLE grade(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    codigo_turma BIGINT NOT NULL,
    codigo_ministrante BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    FOREIGN KEY(codigo_turma) REFERENCES turma(codigo),
    FOREIGN KEY(codigo_ministrante) REFERENCES ministrante(codigo)
);
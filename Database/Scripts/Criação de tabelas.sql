

-- CRIADO POR MAILSON DENNIS 



CREATE TABLE usuario(
	email TEXT PRIMARY KEY,
	senha TEXT NOT NULL,
	admin BOOLEAN NOT NULL,
	nome TEXT NOT NULL,
	foto VARCHAR(100),
	nascimento DATE NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    telefone VARCHAR(15)
);

CREATE TABLE aluno(
	email TEXT PRIMARY KEY, 
	FOREIGN KEY (email) REFERENCES usuario(email) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE professor(
	email TEXT PRIMARY KEY,
	FOREIGN KEY (email) REFERENCES usuario(email) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE turma_virtual(
	nome VARCHAR(30) PRIMARY KEY,
	descricao TEXT,
	professor_email TEXT NOT NULL,
	FOREIGN KEY (professor_email) REFERENCES professor(email) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE podcast(
	audio VARCHAR(100) PRIMARY KEY,
	titulo VARCHAR(30) NOT NULL,
	categoria TEXT NOT NULL,
	descricao TEXT,
	criador TEXT NOT NULL,
	nome_turma VARCHAR(30),
    data_criacao DATE,
	hora_criacao TIME,
	FOREIGN KEY (criador) REFERENCES usuario(email) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (nome_turma) REFERENCES turma_virtual(nome) ON DELETE CASCADE
);

CREATE TABLE avalia_podcast(
	usuario TEXT NOT NULL,
	podcast VARCHAR(100) NOT NULL,
	comentario TEXT NOT NULL,
	PRIMARY KEY (usuario,podcast),
	FOREIGN KEY (usuario) REFERENCES usuario(email) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (podcast) REFERENCES podcast(audio) ON DELETE CASCADE
);

CREATE TABLE participa_turma(
	aluno_email TEXT,
	turma VARCHAR(30),
	PRIMARY KEY (aluno_email,turma),
	FOREIGN KEY (aluno_email) REFERENCES aluno(email) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (turma) REFERENCES turma_virtual(nome) ON DELETE CASCADE
)


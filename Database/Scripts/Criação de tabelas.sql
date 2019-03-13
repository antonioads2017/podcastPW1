

-- CRIADO POR MAILSON DENNIS 


CREATE TABLE usuario(
	email TEXT PRIMARY KEY,
	senha TEXT NOT NULL,
	admin BOOLEAN,
	nome TEXT,
	foto VARCHAR(50),
	nascimento DATE,
    tipo VARCHAR(15),
    sexo VARCHAR(10),
    telefone VARCHAR(15)
);

CREATE TABLE aluno(
	email TEXT PRIMARY KEY, 
	FOREIGN KEY (email) REFERENCES usuario(email)
);

CREATE TABLE professor(
	email TEXT PRIMARY KEY,
	FOREIGN KEY (email) REFERENCES usuario(email)
);

CREATE TABLE turma_virtual(
	nome VARCHAR(30) PRIMARY KEY,
	descricao TEXT,
	professor TEXT,
	FOREIGN KEY (professor) REFERENCES professor(email)
);

CREATE TABLE podcast(
	audio VARCHAR(50) PRIMARY KEY,
	titulo VARCHAR(30),
	categoria TEXT,
	descricao TEXT,
	criador TEXT,
	nome_turma VARCHAR(30),
	FOREIGN KEY (criador) REFERENCES usuario(email),
	FOREIGN KEY (nome_turma) REFERENCES turma_virtual(nome)
);

CREATE TABLE avalia_podcast(
	usuario TEXT,
	podcast VARCHAR(50),
	comentario TEXT,
	PRIMARY KEY (usuario,podcast),
	FOREIGN KEY (usuario) REFERENCES usuario(email),
	FOREIGN KEY (podcast) REFERENCES podcast(audio)
);

CREATE TABLE participa_turma(
	aluno TEXT,
	turma VARCHAR(30),
	PRIMARY KEY (aluno,turma),
	FOREIGN KEY (aluno) REFERENCES aluno(email),
	FOREIGN KEY (turma) REFERENCES turma_virtual(nome)
)

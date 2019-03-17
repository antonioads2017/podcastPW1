-- Povoando a relação usuario
INSERT INTO usuario VALUES('elucas.crispim@gmail.com', '01234567', TRUE, 'Eduardo Lucas', '', '1999-12-15', 'Masculino', '(83)99161-1506');
INSERT INTO usuario VALUES('mailsondennis@gmail.com', 'mailsongod', TRUE, 'Mailson Dennis', '', '1999-12-12', 'Masculino', '(83)99889-6835');
INSERT INTO usuario VALUES('camilacarwalho@gmail.com', 'lindaincrivel', TRUE, 'Camila Carvalho', '', '1999-08-05', 'Feminino', '(83)99181-4472');
INSERT INTO usuario VALUES('antoniofilho@gmail.com', 'afinformatica', TRUE , 'Antônio Filho', '', '1998-04-28', 'Masculino', '(83)99917-7011');
INSERT INTO usuario VALUES('icarolins@gmail.com', 'curitibano', FALSE , 'Ícaro Lins', '', '1997-08-13', 'Masculino', '(41)99796-5365');
INSERT INTO usuario VALUES('teofanesferreira@gmail.com', 'ilysm', FALSE , 'Teofanes Ferreira', '', '1998-12-20', 'Masculino', '(83)99620-7635');
INSERT INTO usuario VALUES('lucasformiga.com', 'dornalombar', FALSE , 'Lucas Formiga', '', '1998-12-16', 'Masculino', '(83)98181-1612');
INSERT INTO usuario VALUES('lucascarlos@gmail.com', 'sodepressive', FALSE , 'Lucas Carlos', '', '1997-07-12', 'Masculino', '(83)99312-8420');
INSERT INTO usuario VALUES('daviddeso@gmail.com', 'tartaruga', FALSE , 'David Deso', '', '1997-07-26', 'Masculino', '(83)99415-1601');
INSERT INTO usuario VALUES('lucaslacerda@gmail.com', 'theuss2', FALSE , 'Lucas Lacerda', '', '1996-06-25', 'Masculino', '(83)99415-1601');
INSERT INTO usuario VALUES('lethiciacartaxo@gmail.com', 'portuga', FALSE , 'Lethicia Cartaxo', '', '1997-05-30', 'Feminino', '(83)99415-1601');
INSERT INTO usuario VALUES('marinamang@gmail.com', 'lubs', FALSE , 'Marina Mangueira', '', '2000-01-19', 'Feminino', '(83)99415-1601');

-- Povoando a relação aluno
INSERT INTO aluno VALUES('icarolins@gmail.com');
INSERT INTO aluno VALUES('teofanesferreira@gmail.com');
INSERT INTO aluno VALUES('lucasformiga.com');
INSERT INTO aluno VALUES('lucascarlos@gmail.com');
INSERT INTO aluno VALUES('daviddeso@gmail.com');
INSERT INTO aluno VALUES('lucaslacerda@gmail.com');
INSERT INTO aluno VALUES('lethiciacartaxo@gmail.com');
INSERT INTO aluno VALUES('marinamang@gmail.com');

-- Povoando a relação professor
INSERT INTO professor VALUES('elucas.crispim@gmail.com');
INSERT INTO professor VALUES('mailsondennis@gmail.com');
INSERT INTO professor VALUES('camilacarwalho@gmail.com');
INSERT INTO professor VALUES('antoniofilho@gmail.com');

-- Povoando a relação turma_virtual
INSERT INTO turma_virtual VALUES('POO', 'Grupo de estudos de podcasts', 'elucas.crispim@gmail.com');
INSERT INTO turma_virtual VALUES('PW1', 'Grupo de estudos de podcasts', 'mailsondennis@gmail.com');

-- Povoando a relação participa_turma
INSERT INTO participa_turma VALUES('icarolins@gmail.com', 'POO');
INSERT INTO participa_turma VALUES('teofanesferreira@gmail.com', 'POO');
INSERT INTO participa_turma VALUES('lucasformiga.com', 'POO');
INSERT INTO participa_turma VALUES('lucascarlos@gmail.com', 'POO');
INSERT INTO participa_turma VALUES('daviddeso@gmail.com', 'PW1');
INSERT INTO participa_turma VALUES('lucaslacerda@gmail.com', 'PW1');
INSERT INTO participa_turma VALUES('lethiciacartaxo@gmail.com', 'PW1');
INSERT INTO participa_turma VALUES('marinamang@gmail.com', 'PW1');

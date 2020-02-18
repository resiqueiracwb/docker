CREATE TABLE usuario (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    telefone VARCHAR(128) NOT NULL,
    senha VARCHAR(200) NOT NULL,
	grupo_id INTEGER,
	ativo integer,
    PRIMARY KEY (id)
);

CREATE TABLE GRUPO(

id   INTEGER      NOT NULL AUTO_INCREMENT,
name VARCHAR(128) NOT NULL,
CHAVE VARCHAR(128) NOT NULL,
PRIMARY KEY (id)

);

ALTER TABLE usuario ADD FOREIGN KEY (grupo_id) REFERENCES GRUPO(id);

CREATE TABLE TOKEN(

id   INTEGER      NOT NULL AUTO_INCREMENT,
token VARCHAR(128) NOT NULL,
EMAIL VARCHAR(128) NOT NULL,
active integer,
dt_insercao timestamp,
dt_expiracao timestamp,
PRIMARY KEY (id)

);


CREATE TABLE application (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    nome VARCHAR(128) NOT NULL,
    nome_responsavel VARCHAR(128) NOT NULL,
    email_responsavel VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE predio(
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    qtde_andares Integer,
    cor  VARCHAR(128),
    tipo_padrao  VARCHAR(128),
    is_portaria integer,
    qtde_elevadores integer,
    nome_sindico varchar(200),
    vagas_cobertas integer,
    qtde_apartamentos integer,
    salao_festas integer ,
    PRIMARY KEY (id)
);
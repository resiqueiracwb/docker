CREATE TABLE country (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
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
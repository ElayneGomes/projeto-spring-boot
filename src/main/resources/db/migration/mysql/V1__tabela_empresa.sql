CREATE TABLE empresa
(
    id               int PRIMARY KEY AUTO_INCREMENT,
    cnpj             varchar(255) NOT NULL,
    data_atualizacao datetime     NOT NULL,
    data_criacao     datetime     NOT NULL,
    razao_social     varchar(255) NOT NULL
);

CREATE TABLE funcionario
(
    id                     int PRIMARY KEY AUTO_INCREMENT,
    nome                   varchar(255) NOT NULL,
    email                  varchar(255) NULL,
    senha                  varchar(255) NOT NULL,
    cpf                    varchar(255) NOT NULL,
    valor_hora             BIGINT       NOT NULL,
    qtd_horas_trabalho_dia float        NULL,
    qtd_horas_almoco       float        NULL,
    perfil                 varchar(255) NOT NULL,
    data_criacao           datetime     NOT NULL,
    data_atualizacao       datetime     NOT NULL,
    id_empresa             int,
    FOREIGN KEY (id_empresa)
    REFERENCES empresa (id)
);

CREATE TABLE lancamento
(
    id               int PRIMARY KEY AUTO_INCREMENT,
    data             datetime     NOT NULL,
    descricao        varchar (255) NULL,
    localizacao      varchar(255) NULL,
    data_criacao     datetime     NOT NULL,
    data_atualizacao datetime     NOT NULL,
    tipo             varchar(255) NOT NULL,
    id_funcionario   int,
    FOREIGN KEY (id_funcionario)
    REFERENCES funcionario (id)
);

CREATE TABLE usuario
(
    id               int PRIMARY KEY AUTO_INCREMENT,
    email            varchar(255) NOT NULL,
    senha            varchar(255) NOT NULL,
    perfil           varchar(255) NOT NULL
);

create table medicos (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    expertise varchar(100) not null,
    patio varchar(100) not null,
    neighborhood varchar(100) not null,
    zipcode varchar(8) not null,
    complement varchar(100),
    numero varchar(20),
    uf char(2) not null,
    city varchar(100) not null,

    primary key(id)

);
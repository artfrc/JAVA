create table pacientes (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    phone varchar(20) not null,
    patio varchar(100) not null,
    neighborhood varchar(100) not null,
    zipcode varchar(8) not null,
    complement varchar(100),
    numero varchar(20),
    uf char(2) not null,
    city varchar(100) not null,

    primary key(id)

);
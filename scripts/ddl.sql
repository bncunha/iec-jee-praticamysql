create table categoria (codigo int primary key auto_increment, nome varchar(100));

CREATE TABLE Produtos (
    id int NOT NULL auto_increment,
    nome varchar(100) NOT NULL,
    preco float not null,
    idCategoria int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (idCategoria) REFERENCES categoria(codigo)
);
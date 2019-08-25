DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS Usuario_perfis;
CREATE TABLE usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome varchar(255),
  email varchar(40),
  senha varchar(255)
);

CREATE TABLE perfil (
  id INT  PRIMARY KEY,
  nome varchar(255),
  role varchar(25)
);
create table Usuario_perfis (
    usuario_id int not null,
    perfis_id int not null
);

INSERT INTO perfil (id,nome,role)
    VALUES (1,'Dependentes','DEPENDENTES'),
       (2,'Representantes','REPRESENTANTES'),
       (3,'Parceiros','PARCEIROS');


insert into usuario(nome, email, senha)
VALUES ('admin','boali@email.com','$2a$10$/74tck4CWNp8oWGNJvVNreMB7NJGiXI62R7HkA13DJcQLSLn3qpfW');

insert into Usuario_perfis(usuario_id,perfis_id)
values(1,2);

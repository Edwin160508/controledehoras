CREATE TABLE `usuario` (
 
`id` INT PRIMARY KEY auto_increment,
`nome` VARCHAR(250) NOT NULL,
`login` VARCHAR(250) NOT NULL,
`senha` VARCHAR(250) NOT NULL,
`email` VARCHAR(250) NOT NULL
 
) ENGINE = innodb;

CREATE TABLE `hora_lancada` (
 
`id` INT PRIMARY KEY auto_increment,
`data` DATE NOT NULL,
`hora_inicial` VARCHAR(250) NOT NULL,
`hora_final` VARCHAR(250) NOT NULL,
`usuario_id` INT NOT NULL
 
) ENGINE = innodb;

ALTER TABLE hora_lancada ADD CONSTRAINT id_fk_usuario
FOREIGN KEY(usuario_id) REFERENCES usuario (id);
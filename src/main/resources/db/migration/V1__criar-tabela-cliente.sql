create table cliente(

id bigint NOT NULL AUTO_INCREMENT,
 nome varchar(100) DEFAULT NULL,
 telefone varchar(20) DEFAULT NULL,
 email varchar(100) DEFAULT NULL,
 status varchar(20) NOT NULL,
PRIMARY KEY (id)
);
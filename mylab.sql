-- drop database mylab;
-- create database mylab;
use mylab;

insert into pais (id, nome) values (1, 'Brasil');
insert into pais (id, nome) values (2, 'Argentina');
insert into pais (id, nome) values (3, 'Alemanha');
insert into pais (id, nome) values (4, 'Franca');
insert into pais (id, nome) values (5, 'Italia');
insert into pais (id, nome) values (6, 'Inglaterra');

insert into estado (id, nome, idpais) values (1, 'Santa Catarina', 1);
insert into estado (id, nome, idpais) values (2, 'Sao Paulo', 1);
insert into estado (id, nome, idpais) values (3, 'Rio de Janeiro', 1);
insert into estado (id, nome, idpais) values (4, 'Parana', 1);
insert into estado (id, nome, idpais) values (5, 'Rio Grande do Sul', 1);
insert into estado (id, nome, idpais) values (6, 'Bahia', 1);
insert into estado (id, nome, idpais) values (7, 'Ceara', 1);

insert into cidade (id, nome, idestado) values (1, 'Florianopolis', 1);
insert into cidade (id, nome, idestado) values (2, 'Sao Jose', 1);
insert into cidade (id, nome, idestado) values (3, 'Palhoca', 1);
insert into cidade (id, nome, idestado) values (4, 'Sao Paulo', 2);
insert into cidade (id, nome, idestado) values (5, 'Guarulhos', 2);
insert into cidade (id, nome, idestado) values (6, 'Biguacu', 1);
insert into cidade (id, nome, idestado) values (7, 'Imbituba', 1);

insert into endereco (id, cep, complemento, logradouro, numero, idcidade) values (1, '88070-320', 'casa', 'Rua do Kevin', '37', 1);
insert into endereco (id, cep, complemento, logradouro, numero, idcidade) values (2, '88070-400', 'apt 301', 'Rua do Moda', '10', 1);
insert into endereco (id, cep, complemento, logradouro, numero, idcidade) values (3, '88070-500', 'apt 100 A', 'Rua do Jony', '20', 2);
insert into endereco (id, cep, complemento, logradouro, numero, idcidade) values (4, '88600-320', 'casa praia', 'Rua do Juliann', '30', 3);

insert into pessoa (idpessoa, dt_nascimento, email, nome, telefone, idendereco) values (1, '2019-11-26', 'kevin@senac.br', 'Kevin Guimaraes', '984210016', 1);
insert into pessoa (idpessoa, dt_nascimento, email, nome, telefone, idendereco) values (2, '2015-10-10', 'jonyb@senac.br', 'Jony boy', '123456786', 2);
insert into pessoa (idpessoa, dt_nascimento, email, nome, telefone, idendereco) values (3, '2001-06-16', 'julian@senac.br', 'Juliann moda', '986540316', 3);
insert into pessoa (idpessoa, dt_nascimento, email, nome, telefone, idendereco) values (4, '2012-01-15', 'kevin2@senac.br', 'Khomp', '989845016', 4);
insert into pessoa (idpessoa, dt_nascimento, email, nome, telefone, idendereco) values (5, '2011-03-03', 'kevin3@senac.br', 'Senac', '884240324', 2);

insert into pessoajuridica (cnpj, fantasia, idpessoa) values ('32165761321/2', 'Khomp ind e comercio', 4);
insert into pessoajuridica (cnpj, fantasia, idpessoa) values ('2346541/2', 'Faculdade Senac', 5);

insert into pessoafisica (cpf, genero, idpessoa) values ('0881586958', 'M', 1);
insert into pessoafisica (cpf, genero, idpessoa) values ('132456798', 'M', 2);
insert into pessoafisica (cpf, genero, idpessoa) values ('987654213', 'M', 3);

insert into equipamento (id, fw_version, hw_version, nome, serial) values (1, '1.2', '1.0', 'Turbidimetro', 'ML0001');
insert into equipamento (id, fw_version, hw_version, nome, serial) values (2, '2.0', '2.0', 'pHMetro', 'ML0002');
insert into equipamento (id, fw_version, hw_version, nome, serial) values (3, '1.5', '3.0', 'Condutivimetro', 'ML0003');
insert into equipamento (id, fw_version, hw_version, nome, serial) values (4, '1.0', '4.0', 'Fotocolorimetro', 'ML0004');

insert into calibracao (id, dt_calibracao, valor, idequipamento) values (1, '2019-11-27', 1.3, 1);
insert into calibracao (id, dt_calibracao, valor, idequipamento) values (2, '2010-02-10', 10.3, 2);
insert into calibracao (id, dt_calibracao, valor, idequipamento) values (3, '2015-06-05', 5.3, 3);
insert into calibracao (id, dt_calibracao, valor, idequipamento) values (4, '2013-01-03', 6.3, 4);

insert into cliente (id, codigo, idpessoa) values (1, '123456', 1);
insert into cliente (id, codigo, idpessoa) values (2, '124556', 2);
insert into cliente (id, codigo, idpessoa) values (3, '123216', 3);
insert into cliente (id, codigo, idpessoa) values (4, '789456', 4);
insert into cliente (id, codigo, idpessoa) values (5, '113136', 5);

insert into amostra (id, codigo, dt_amostra, observacao, idcliente, idendereco) values (1, '123', '2015-11-30', 'Coletada com o pote', 1, 1);
insert into amostra (id, codigo, dt_amostra, observacao, idcliente, idendereco) values (2, '456', '2019-10-10', 'Coletada com o balde', 2, 2);
insert into amostra (id, codigo, dt_amostra, observacao, idcliente, idendereco) values (3, '789', '2018-08-20', 'Coletada com o jarra', 3, 3);
insert into amostra (id, codigo, dt_amostra, observacao, idcliente, idendereco) values (4, '987', '2017-06-15', 'Coletada com o mao', 4, 4);
insert into amostra (id, codigo, dt_amostra, observacao, idcliente, idendereco) values (5, '987', '2019-12-09', 'Coletada com o pe', 4, 4);

insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (1, '2019-01-11', 'mg/l', 8.48, 1, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (2, '2014-01-08', 'pH', 2.10, 2, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (3, '2019-02-03', 'ppm', 1.20, 3, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (4, '2019-03-16', 'uS/cm', 7.00, 4, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (5, '2019-03-11', 'mg/l', 10.2, 1, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (6, '2019-03-02', 'mg/l', 1.2, 1, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (7, '2019-04-02', 'mg/l', 4.2, 2, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (8, '2019-05-02', 'mg/l', 8.2, 1, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (9, '2019-06-02', 'mg/l', 1.2, 2, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (10, '2019-06-01', 'mg/l', 2.2, 3, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (11, '2019-06-29', 'mg/l', 3.2, 4, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (12, '2019-06-15', 'mg/l', 4.2, 1, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (13, '2019-07-05', 'mg/l', 5.2, 1, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (14, '2019-08-20', 'mg/l', 6.2, 2, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (15, '2019-09-01', 'mg/l', 7.2, 3, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (16, '2019-09-01', 'mg/l', 8.2, 4, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (17, '2019-10-01', 'mg/l', 9.2, 1, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (18, '2019-10-01', 'mg/l', 1.2, 2, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (19, '2019-11-01', 'mg/l', 9.2, 3, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (20, '2019-11-01', 'mg/l', 8.2, 4, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (21, '2019-11-01', 'mg/l', 7.2, 1, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (22, '2019-11-01', 'mg/l', 5.2, 2, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (23, '2019-12-10', 'mg/l', 9.2, 3, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (24, '2019-12-09', 'mg/l', 8.2, 4, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (25, '2019-12-09', 'mg/l', 9.2, 1, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (26, '2019-12-09', 'mg/l', 9.2, 2, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (27, '2019-12-08', 'mg/l', 4.2, 2, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (28, '2019-12-08', 'mg/l', 6.2, 3, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (29, '2019-12-07', 'mg/l', 9.2, 4, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (30, '2019-12-07', 'mg/l', 8.2, 1, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (31, '2019-12-06', 'mg/l', 7.2, 2, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (32, '2019-12-05', 'mg/l', 5.2, 3, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (33, '2019-12-05', 'mg/l', 6.2, 4, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (34, '2019-12-05', 'mg/l', 3.2, 1, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (35, '2019-12-04', 'mg/l', 4.2, 2, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (36, '2019-12-04', 'mg/l', 0.2, 3, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (37, '2019-12-03', 'mg/l', 2.2, 4, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (38, '2019-12-02', 'mg/l', 6.2, 1, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (39, '2019-12-01', 'mg/l', 1.2, 2, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (40, '2019-12-01', 'mg/l', 3.2, 3, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (41, '2019-12-01', 'mg/l', 7.2, 4, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (42, '2019-12-01', 'mg/l', 9.2, 1, 3);

insert into tela (id, nome) values (1, 'Dashboard');
insert into tela (id, nome) values (2, 'Cadastro cliente');
insert into tela (id, nome) values (3, 'Cadastro amostra');
insert into tela (id, nome) values (4, 'Visualizar amostra');
insert into tela (id, nome) values (5, 'Visualizar cliente');

insert into perfil (id, nome) values (1, 'Admin');
insert into perfil (id, nome) values (2, 'Gerente');
insert into perfil (id, nome) values (3, 'Tecnico');

insert into perfilacesso(id, idperfil, idtela) values (1, 1, 1);
insert into perfilacesso(id, idperfil, idtela) values (2, 1, 2);
insert into perfilacesso(id, idperfil, idtela) values (3, 1, 3);
insert into perfilacesso(id, idperfil, idtela) values (4, 1, 4);
insert into perfilacesso(id, idperfil, idtela) values (5, 1, 5);
insert into perfilacesso(id, idperfil, idtela) values (6, 2, 2);
insert into perfilacesso(id, idperfil, idtela) values (7, 2, 3);
insert into perfilacesso(id, idperfil, idtela) values (8, 3, 4);
insert into perfilacesso(id, idperfil, idtela) values (9, 3, 5);

insert into usuario (id, cargo, login, password, idperfil, idpessoa) values (1, 'CEO', 'kevin', '123456', 1, 1);
insert into usuario (id, cargo, login, password, idperfil, idpessoa) values (2, 'Gerente', 'juliann', '654321', 2, 2);
insert into usuario (id, cargo, login, password, idperfil, idpessoa) values (3, 'Tecnico', 'jonatan', '123654', 3, 3);

create view vw_weekMed as
select (select count(id) from medicao where dt_medicao = (adddate(curdate(), INTERVAL -6 DAY))) as day6,
(select count(id) from medicao where dt_medicao = (adddate(curdate(), INTERVAL -5 DAY))) as day5,
(select count(id) from medicao where dt_medicao = (adddate(curdate(), INTERVAL -4 DAY))) as day4,
(select count(id) from medicao where dt_medicao = (adddate(curdate(), INTERVAL -3 DAY))) as day3,
(select count(id) from medicao where dt_medicao = (adddate(curdate(), INTERVAL -2 DAY))) as day2,
(select count(id) from medicao where dt_medicao = (adddate(curdate(), INTERVAL -1 DAY))) as day1,
(select (select count(id) from medicao where dt_medicao = curdate())) as day0;

create view vw_monthMedicoes as
select (select count(id) from medicao where dt_medicao between (adddate(curdate(), INTERVAL -4 WEEK)) and (adddate(curdate(), INTERVAL -3 WEEK))) as week3,
(select count(id) from medicao where dt_medicao between (adddate(curdate(), INTERVAL -3 WEEK)) and (adddate(curdate(), INTERVAL -2 WEEK))) as week2,
(select count(id) from medicao where dt_medicao between (adddate(curdate(), INTERVAL -2 WEEK)) and (adddate(curdate(), INTERVAL -1 WEEK))) as week1,
(select count(id) from medicao where dt_medicao between (adddate(curdate(), INTERVAL -1 WEEK)) and curdate()) as week0;

create view vw_yearMedicoes as
select (select count(id) from medicao where ((month(dt_medicao) = 1)) and (year(dt_medicao) = year(curdate())))  as jan,
	(select count(id) from medicao where ((month(dt_medicao) = 2)) and (year(dt_medicao) = year(curdate())))  as fev,
	(select count(id) from medicao where ((month(dt_medicao) = 3)) and (year(dt_medicao) = year(curdate())))  as mar,
	(select count(id) from medicao where ((month(dt_medicao) = 4)) and (year(dt_medicao) = year(curdate())))  as abr,
    (select count(id) from medicao where ((month(dt_medicao) = 5)) and (year(dt_medicao) = year(curdate())))  as mai,
	(select count(id) from medicao where ((month(dt_medicao) = 6)) and (year(dt_medicao) = year(curdate())))  as jun,
	(select count(id) from medicao where ((month(dt_medicao) = 7)) and (year(dt_medicao) = year(curdate())))  as jul,
	(select count(id) from medicao where ((month(dt_medicao) = 8)) and (year(dt_medicao) = year(curdate())))  as ago,
	(select count(id) from medicao where ((month(dt_medicao) = 9)) and (year(dt_medicao) = year(curdate())))  as stm,
	(select count(id) from medicao where ((month(dt_medicao) = 10)) and (year(dt_medicao) = year(curdate())))  as otb,
	(select count(id) from medicao where ((month(dt_medicao) = 11)) and (year(dt_medicao) = year(curdate())))  as nov,
	(select count(id) from medicao where ((month(dt_medicao) = 12)) and (year(dt_medicao) = year(curdate())))  as dez;

create view vw_amostraWithOutMedicao as
select count(a.id) from amostra as a left join medicao as m on m.idamostra = a.id where m.idamostra is null;

create view vw_clienteMaxMedicoes as
select p.nome, count(m.id) as max from medicao as m inner join amostra as a on m.idamostra = a.id inner join cliente as c on a.idcliente = c.id inner join pessoa as p on c.idpessoa = p.idpessoa group by p.nome order by max desc limit 1;

create view vw_amostraThisMonth as
select count(id) from amostra where month(dt_amostra) = month(curdate());







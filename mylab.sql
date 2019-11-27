drop database mylab;
create database mylab;
use mylab;

show tables;
select * from pessoa;
select * from endereco;
select * from pais;
select * from estado;
select * from cidade;
select * from pessoajuridica;
select * from pessoafisica;
select * from equipamento;
select * from calibracao;
select * from amostra;
select * from cliente;
select * from tela;
select * from perfil;
select * from perfilacesso;
select * from usuario;

insert into pais (id, nome) values (1, 'Brasil');
insert into pais (id, nome) values (2, 'Argentina');
insert into pais (id, nome) values (3, 'Alemanha');
insert into pais (id, nome) values (4, 'França');
insert into pais (id, nome) values (5, 'Italia');
insert into pais (id, nome) values (6, 'Inglaterra');

insert into estado (id, nome, idpais) values (1, 'Santa Catarina', 1);
insert into estado (id, nome, idpais) values (2, 'São Paulo', 1);
insert into estado (id, nome, idpais) values (3, 'Rio de Janeiro', 1);
insert into estado (id, nome, idpais) values (4, 'Parana', 1);
insert into estado (id, nome, idpais) values (5, 'Rio Grande do Sul', 1);
insert into estado (id, nome, idpais) values (6, 'Bahia', 1);
insert into estado (id, nome, idpais) values (7, 'Ceara', 1);

insert into cidade (id, nome, idestado) values (1, 'Florianopolis', 1);
insert into cidade (id, nome, idestado) values (2, 'São José', 1);
insert into cidade (id, nome, idestado) values (3, 'Palhoça', 1);
insert into cidade (id, nome, idestado) values (4, 'São Paulo', 2);
insert into cidade (id, nome, idestado) values (5, 'Guarulhos', 2);
insert into cidade (id, nome, idestado) values (6, 'Biguaçu', 1);
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
insert into amostra (id, codigo, dt_amostra, observacao, idcliente, idendereco) values (4, '987', '2017-06-15', 'Coletada com o mão', 4, 4);

insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (1, '2019-04-11', 'mg/l', 8.48, 1, 1);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (2, '2014-07-08', 'pH', 2.10, 2, 2);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (3, '2019-09-03', 'ppm', 1.20, 3, 3);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (4, '2019-02-16', 'uS/cm', 7.00, 4, 4);
insert into medicao (id, dt_medicao, unidade, valor, idamostra, idequipamento) values (5, '2019-01-11', 'mg/l', 10.2, 1, 1);

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






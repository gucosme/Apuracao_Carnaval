CREATE DATABASE carnaval
GO
USE carnaval

/* CRIAÇÃO DE TABELAS */

CREATE TABLE escola(id_escola INT IDENTITY(1,1),
nome VARCHAR(100) NOT NULL,
total_pts DECIMAL(4, 1),
PRIMARY KEY(id_escola))

CREATE TABLE quesito(id_quesito INT IDENTITY(1,1),
nome VARCHAR(100) NOT NULL,
PRIMARY KEY(id_quesito))

CREATE TABLE jurado(id_jurado INT IDENTITY(1,1),
nome VARCHAR(100) NOT NULL,
PRIMARY KEY(id_jurado))

go
CREATE TABLE notas(id_escola INT ,
id_quesito int,
nota1 DECIMAL(3, 1) CHECK(nota1 >= 5.0 AND nota1 <= 10.0),
nota2 DECIMAL(3, 1) CHECK(nota2 >= 5.0 AND nota2 <= 10.0),
nota3 DECIMAL(3, 1) CHECK(nota3 >= 5.0 AND nota3 <= 10.0),
nota4 DECIMAL(3, 1) CHECK(nota4 >= 5.0 AND nota4 <= 10.0),
nota5 DECIMAL(3, 1) CHECK(nota5 >= 5.0 AND nota5 <= 10.0),
nota_total DECIMAL(3, 1),
nota_maior decimal(3,1),
nota_menor decimal(3,1),
PRIMARY KEY(id_quesito, id_escola),
FOREIGN KEY(id_quesito) REFERENCES quesito,
FOREIGN KEY(id_escola) REFERENCES escola)

CREATE TABLE quesito_jurado(id_quesito INT,
id_jurado INT,
posicao INT NOT NULL CHECK(posicao >= 1 AND posicao <= 5),
PRIMARY KEY(id_quesito, id_jurado),
FOREIGN KEY(id_quesito) REFERENCES quesito,
FOREIGN KEY(id_jurado) REFERENCES jurado)

/* INSERT DAS TABELAS*/

insert into escola values
('Acadêmicos do Tatuapé', 0.0 ),
('Rosas de Ouro', 0.0 ),
('Mancha Verde', 0.0 ),
('Vai-Vai', 0.0 ),
('X-9 Paulistana', 0.0 ),
('Dragões da Real', 0.0 ),
('Águia de Ouro', 0.0 ),
('Nenê de Vila Matilde', 0.0 ),
('Gaviões da Fiel', 0.0 ),
('Mocidade Alegre', 0.0 ),
('Tom Maior', 0.0 ),
('Unidos de Vila Maria', 0.0 ),
('Acadêmicos do Tucuruvi', 0.0 ),
('Império de Casa Verde', 0.0 )

insert into quesito values
('Comissão de Frente' ),
('Evolução'),
('Fantasia'),
('Bateria'),
('Alegoria'),
('Harmonia'),
('Samba-Enredo'),
('Mestre-Sala'),
('Porta-Bandeira')

insert into jurado values
('Renan Azevedo Fernandes' ),
('Alex Carvalho Dias'),
('Felipe Santos Goncalves'),
('Letícia Costa Pinto'),
('João Souza Rodrigues'),
('Letícia Ferreira Pereira'),
('Kaua Almeida Fernandes'),
('Luis Gomes Goncalves'),
('Isabela Ribeiro Alves'),
('Lara Gomes Cardoso'),
('Ana Barbosa Azevedo'),
('Marlene I. Brandon'),
('Sandra M. Campbell'),
('Sarah P. Bohannon'),
('Jason S. Schmidt'),
('Erick Oliveira Lima'),
('Luan Oliveira Rocha'),
('Marcos Sousa Melo'),
('Marcos Gomes Ferreira'),
('Bruno Azevedo Lima'),
('Bruno Castro Goncalves'),
('Igor Lima Souza'),
('Vítor Goncalves Gomes'),
('Luis Rodrigues Ferreira'),
('Tomás Ferreira Cardoso'),
('Fábio Almeida Ferreira'),
('Erick Ribeiro Goncalves'),
('Tiago Carvalho Fernandes'),
('Leonardo Oliveira Ribeiro'),
('Enzo Lima Fernandes'),
('Vinícius Gomes Carvalho'),
('André Silva Fernandes'),
('Fábio Cunha Lima'),
('Breno Pinto Correia'),
('Alex Sousa Oliveira'),
('André Lima Cardoso'),
('Kaua Araujo Ribeiro'),
('Matheus Barros Dias'),
('Marina Martins Rocha'),
('Livia Souza Melo'),
('Victor Costa Rodrigues'),
('Davi Gomes Cavalcanti'),
('Isabella Pereira Gomes'),
('Antônio Almeida Rocha'),
('Vitor Cavalcanti Castro')

insert into quesito_jurado values
(1,1,1),
(1,2,2),
(1,3,3),
(1,4,4),
(1,5,5),
(2,6,1),
(2,7,2),
(2,8,3),
(2,9,4),
(2,10,5),
(3,11,1),
(3,12,2),
(3,13,3),
(3,14,4),
(3,15,5),
(4,16,1),
(4,17,2),
(4,18,3),
(4,19,4),
(4,20,5),
(5,21,1),
(5,22,2),
(5,23,3),
(5,24,4),
(5,25,5),
(6,26,1),
(6,27,2),
(6,28,3),
(6,29,4),
(6,30,5),
(7,31,1),
(7,32,2),
(7,33,3),
(7,34,4),
(7,35,5),
(8,36,1),
(8,37,2),
(8,38,3),
(8,39,4),
(8,40,5),
(9,41,1),
(9,42,2),
(9,43,3),
(9,44,4),
(9,45,5)

/* SELECT DAS TABELAS */

select * from escola

select * from jurado

select * from quesito

select * from notas

select * from quesito_jurado


/* DROP DAS TABELAS =) */

drop table escola

drop table jurado

drop table quesito
go
drop table notas

drop table quesito_jurado



/* CRIAÇÃO DE PROCEDURES */

create procedure sp_insereNota(@escola int, @quesito int, @posicao int, @nota decimal(3,1)) as
declare @coluna char(8)
declare @total decimal(3,1)
declare @query varchar(max)
declare @descartados decimal(3,1)
set @coluna = 'nota' + CONVERT(char(1),@posicao)

			if(@coluna='nota1') begin
					set @total=@nota
					
				 insert into notas(id_escola,id_quesito, nota1,nota_total) values (@escola ,@quesito,@nota,@total)
			end
				else begin
					set @descartados = dbo.fn_retornaDescartados(@escola, @quesito)
					set @query = 'update notas set ' + @coluna + ' = ' +CONVERT(char(5),@nota)  + ' where id_escola=' + CONVERT(char(2),@escola) +' and id_quesito=' +CONVERT(char(1),@quesito)
					exec(@query)
					exec sp_descartaNota @escola, @quesito,@nota,@posicao
					exec sp_somaPontosQuesito @escola,@quesito,@nota,@descartados
					
				end
				
create procedure sp_descartaNota( @escola int,@quesito int, @nota decimal(3,1),@posicao int) as  
declare @menor decimal(3,1) set @menor = (select nota_menor from notas where id_escola=@escola and id_quesito=@quesito)
declare @maior decimal(3,1) set @maior = (select nota_maior from notas where id_escola=@escola and id_quesito=@quesito)
declare @n1 decimal(3,1)
declare @n2 decimal(3,1)
declare @cont int set @cont = @posicao

	if(@cont=3) begin
		set @n1 = (select nota1 from notas where id_escola=@escola and id_quesito=@quesito)
		set @n2 = (select nota2 from notas where id_escola=@escola and id_quesito=@quesito)
			if(@n1<@n2) begin
				set @menor = @n1 set @maior = @n2
			end	
				else begin
					set @menor = @n1 set @maior = @n2
				end	
		set @cont = @cont + 1			
	end 
	 if(@cont>3) begin 
			if(@nota<@menor) begin
				set @menor = @nota
			end
			if(@nota>@maior)begin
				set @maior = @nota
			end		
	end		
	update notas set nota_maior=@maior, nota_menor=@menor where id_escola=@escola and id_quesito=@quesito
	
create procedure sp_somaPontosQuesito(@escola int, @quesito int, @nota decimal(3,1),@descarta decimal(3,1))as
declare @retorna decimal(3,1)
declare @sub decimal(3,1)
declare @total decimal(5,1) set @total = (Select nota_total from notas where id_escola=@escola and id_quesito=@quesito)
set @sub = (Select SUM((nota_maior + nota_menor)) from notas where id_escola = @escola and id_quesito=@quesito)

	if (@sub is null) begin
		set @retorna = @total + @nota
	end	
		else begin
			set @retorna = @nota + @total + @descarta - @sub
		end
		
update notas set nota_total=@retorna where id_escola = @escola and id_quesito=@quesito

create procedure sp_somaPontosEscola as 
declare @soma decimal(5,1)
declare @contador int set @contador=1

while(@contador<=14)begin 
	set @soma = (Select SUM(nota_total) from notas where id_escola=@contador)
	update escola set total_pts = @soma where id_escola=@contador
	set @contador = @contador + 1
end	
select * from escola order by  total_pts desc

/* CRIAÇÃO DE FUNCTION */

create function fn_retornaDescartados(@quesito int, @escola int) returns decimal(3,1) as begin
declare @descarta decimal(3,1)
set @descarta = (Select SUM((nota_maior + nota_menor)) from notas where id_escola = @escola and id_quesito=@quesito)
	
	if(@descarta is null)begin
		Set @descarta = '0.0'
	end	
	return @descarta
	
end


/* DROP DAS PROCEDURES E FUNCTIONS =) */

drop procedure sp_insereNota
drop procedure sp_descartaNota
drop procedure sp_somaPontosQuesito
drop procedure sp_somaPontosEscola
drop function fn_retornaDescartados



/* EXECUÇÃO DAS PROCEDURES */

exec sp_insereNota 1,1,1,8.5
exec sp_insereNota 1,1,2,9.0
exec sp_insereNota 1,1,3,7.0
exec sp_insereNota 1,1,4,10.0
exec sp_insereNota 1,1,5,6.9

exec sp_somaPontosEscola 

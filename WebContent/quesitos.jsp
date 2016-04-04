<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="entity.Notas"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="persistencia.NotasDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Notas" %>
<%@ page import="controller.*" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<title>Apuração</title>
	
	<link rel="icon" href="<%=request.getContextPath()%>/imagens/favicon.png">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"/>
	
	<style>
		.conteiner{
			padding-left: 5%;
			padding-right: 5%;
			padding-bottom: 5%;
		}
		
	</style>
</head>
<body>
	<div class="navbar navbar-default">
		<a class="navbar-brand" href="/apuracao">Apuração das Escolas de Samba</a>
	</div>
	
	<div class="conteiner">
		<div class="panel panel-default">
		  <div class="panel-heading">
		  	<%
		  		String quesito = URLDecoder.decode(request.getParameter("quesito"));
		  	%>
		    <h2 class="panel-title"><strong>Quesito:</strong> <%=quesito %></h2> 
		  </div>
		  <div class="panel-body">
			  <div class="table-responsive">
			  	<table class="table table-hover">
				<thead>
					<tr>
						<th>Escola</th>
						<th>1° Nota</th>
						<th>2° Nota</th>
						<th>3° Nota</th>
						<th>4° Nota</th>
						<th>5° Nota</th>
						<th>Maior Nota</th>
						<th>Menor Nota</th>
						<th>Total de Pts.</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Notas> listaNotas = new NotasDAO().selectNotas(quesito);
						for(Notas n: listaNotas){
					%>
					<tr>
						<th><%=n.getIdEscola() %></th>
						<th><%=n.getNota1() %></th>
						<th><%=n.getNota2() %></th>
						<th><%=n.getNota3() %></th>
						<th><%=n.getNota4() %></th>
						<th><%=n.getNota5() %></th>
						<th><%=n.getMaior() %></th>
						<th><%=n.getMenor() %></th>
						<th><%=n.getTotaPontos() %></th>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			  </div>
		  </div>
		</div>
		<a href="/apuracao/quesitos.jsp" class="btn btn-primary disabled">Ver quesitos</a>
		<a href="/apuracao/total.jsp" class="btn btn-primary">Ver Total</a>
	</div>
	
</body>
</html>
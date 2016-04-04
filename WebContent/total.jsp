<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="persistencia.EscolaDAO"%>
<%@page import="entity.Escola"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="persistencia.EscolaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Escola" %>
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
		    <h2 class="panel-title">Total</h2> 
		  </div>
		  <div class="panel-body">
			  <div class="table-responsive">
			  	<table class="table table-hover">
				<thead>
					<tr>
						<th>Escola</th>
						<th>Total de Pts.</th>
					</tr>
				</thead>
				<tbody>
					<% 
						List<Escola> escolas = new EscolaDAO().selectEscola();
						for(Escola e: escolas){
					%>
					<tr>
						<th><%=e.getNome() %></th>
						<th><%=e.getTotalPontos() %></th>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			  </div>
		  </div>
		</div>
		<%
		  		String quesito = (String) session.getAttribute("quesito");
				quesito = URLEncoder.encode(quesito, "UTF-8");
		  	%>
		<a href="quesitos.jsp?quesito=<%=quesito%>" class="btn btn-primary">Ver quesitos</a>
		<a href="total.jsp" class="btn btn-primary disabled">Ver Total</a>
	</div>
	
</body>
</html>
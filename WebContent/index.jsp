<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.Util"%>
<%@ page import="java.util.List" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%
		Util.setLists();
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<title>Apuração</title>
	
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
	
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
		<a class="navbar-brand" href="#">Apuração das Escolas de Samba</a>
	</div>
	
	
	<div class="conteiner">
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h2 class="panel-title">Notas</h2> 
		  </div>
		  <form action="./homectrl" method="post">
		  	<div class="panel-body">
	    	
    			<div class="form-group">
				    <label>Escola</label>
					<select class="form-control" name="escola" required="required">

						<option value="" disabled>Selecione uma escola</option>
						<%
							for(String escola: Util.escolas){
						%>
						<option><%=escola %></option>
						<%
							}
						%>
						
					</select>
				</div>
    		
    			<div class="form-group">
				    <label>Jurado</label>
					<select class="form-control" name="jurado" required="required">

						<option value="" disabled>Selecione um jurado</option>
						<%
							for(String jurado: Util.jurados){
								
						%>
						<option><%=jurado %></option>
						<%
							}
						%>
					</select>
				</div>
    		
    			<div class="form-group">
				    <label>Quesito</label>
					<select class="form-control" name="quesito" required="required">

				      	<!-- JSP CODE HERE-->

						<option value="" disabled>Select your option</option>
						<%
							for(String quesito: Util.quesitos){
						%>
						<option><%=quesito%></option>
						<%
							}
						%>
					</select>
				</div>
		 	</div>
			  <div class="panel-footer">
			  	
			  		<div class="form-group">
			  			<label>Nota</label>
			  			<div class="row">
			  			<div class="col-lg-6">
						    <div class="input-group">
						      <input type="decimal" name="nota" class="form-control" placeholder="10.0" required="required" autofocus="autofocus">
						      <span class="input-group-btn">
						        <button class="btn btn-primary" type="submit" name="inserir">Inserir</button>
						      </span>
						    </div>
						  </div>
						</div>
			  		</div>
			  	
			  </div>
		  </form>
		</div>
		<%
			
			String quesito = Util.quesitos.get(0);
			session.setAttribute("quesito", quesito);
			quesito = URLEncoder.encode(quesito, "UTF-8");
		%>
		<a href="quesitos.jsp?quesito=<%=quesito %>" class="btn btn-primary" name="ver_quesitos">Ver quesitos</a>
		<a href="total.jsp" class="btn btn-primary" name="ver_total">Ver Total</a>
	</div>
	
	<script src="bootstrap/js/bootstrap.min.js"/>
</body>
</html>
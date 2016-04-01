<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<%String a = (String) request.getAttribute("a"),
		teste = (String) request.getAttribute("teste");
	
		
	
		String b = "juri"; %>
	<div class="navbar navbar-default">
		<a class="navbar-brand" href="#">Apuração das Escolas de Samba</a>
	</div>
	
	
	<div class="conteiner">
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h2 class="panel-title">Notas</h2>
		  </div>
		  <form action="./HomeCtrl" method="post">
		  	<div class="panel-body">
	    	
    			<div class="form-group">
				    <label>Escola</label>
					<select class="form-control" name="escola" required="required">

				      	<!-- JSP CODE HERE-->

						<option value="" disabled selected>Selecione uma escola</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
				</div>
    		
    			<div class="form-group">
				    <label>Jurado</label>
					<select class="form-control" name="jurado" required="required">

				      	<!-- JSP CODE HERE-->

						<option value="" disabled selected>Select your option</option>
						
						<option><%=a %></option>
						<option><%=b %></option>
						<option><%=teste %></option>
					</select>
				</div>
    		
    			<div class="form-group">
				    <label>Quesito</label>
					<select class="form-control" name="quesito" required="required">

				      	<!-- JSP CODE HERE-->

						<option value="" disabled selected>Select your option</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
				</div>
		 	</div>
			  <div class="panel-footer">
			  	
			  		<div class="form-group">
			  			<label>Nota</label>
			  			<div class="row">
			  			<div class="col-lg-6">
						    <div class="input-group">
						      <input type="decimal" name="nota" class="form-control" placeholder="10.0" required="required">
						      <span class="input-group-btn">
						        <button class="btn btn-primary" type="submit">Inserir</button>
						      </span>
						    </div>
						  </div>
						</div>
			  		</div>
			  	
			  </div>
		  </form>
		</div>
		
		<button class="btn btn-primary">Ver quesitos</button>
		<button class="btn btn-primary">Ver Total</button>
	</div>
	
	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"/>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Sistema de horas</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
</head>
<body>
	<header>
		<div class="container">
			<nav>
				<ul class="nav nav-tabs">
					<li><a href="${linkTo[IndexController].index()}">Home</a></li><!-- Verepator urls absolutas linkTo[Controller].metodo -->
					<li><a href="${linkTo[UsuarioController].lista()}">Usuarios</a></li>
					<li><a href="${linkTo[UsuarioController].form()}">Cadastro</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="container">
		<main class="col-sm-8">
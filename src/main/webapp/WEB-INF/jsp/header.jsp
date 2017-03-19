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
					<li><a href="${linkTo[HoraLancadaController].form()}">Lançar Hora</a></li>
					<li><a href="${linkTo[HoraLancadaController].relatorioDeHoras()}">Relatórios de Horas</a></li>
					
					<c:if test="${usuarioLogado.logado}">
						<li><a href="${linkTo[LoginController].desloga()}">Deslogar</a></li>
						<li><p class="form-control-static">Bem vindo ${usuarioLogado.usuario.nome}</p></li>
					</c:if>
					<c:if test="${!usuarioLogado.logado}">
						
					</c:if>
				</ul>
			</nav>
		</div>
	</header>
	<div class="container">
		<main class="col-sm-8">
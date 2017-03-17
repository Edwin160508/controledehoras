<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Importando tag validationMessage tag uma criada -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="vm" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
	<h3>Cadastro de Usuário</h3>
	<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">
		<div class="form-group">
			<label for="nome">Nome:*</label>
			<input type="text" name="usuario.nome" id="nome" class="form-control" value="${usuario.nome}" />
			<vm:validationMessage name="usuario.nome" />
		</div>
		
		<div class="form-group">
			<label for="email">E-mail:*</label>
			<input type="text" name="usuario.email" id="email" class="form-control" value="${usuario.email}" />
			<!--  <span class="validation-error text-danger">
				${errors.from("usuario.email")}
			</span> -->
			<vm:validationMessage name="usuario.email" />
		</div>
		
		<div class="form-group">
			<label for="login">Login:*</label>
			<input type="text" name="usuario.login" id="login" class="form-control" value="${usuario.login}" />
			<!--  <span class="validation-error text-danger">
				${errors.from("usuario.login")}
			</span>-->
			<vm:validationMessage name="usuario.login" />
		</div>
		
		<div class="form-group">
			<label for="senha">Senha:*</label>
			<input type="password" name="usuario.senha" id="senha" class="form-control" />
			<!--  <span class="validation-error text-danger">
				${errors.from("usuario.senha")}
			</span> -->
			<vm:validationMessage name="usuario.senha" />
		</div>
		
		<input type="submit" value="Cadastrar" class="btn btn-default" />
	</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />
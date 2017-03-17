<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
	<h3>Cadastro de Usuário</h3>
	<form action="" method="post">
		<label for="nome">Nome:*</label>
		<input type="text" name="usuario.nome" id="nome" class="form-control" value="${usuario.nome}" />
		
		
		<label for="email">E-mail:*</label>
		<input type="text" name="usuario.email" id="email" class="form-control" value="${usuario.email}" />
	
		
		<label for="login">Login:*</label>
		<input type="text" name="usuario.login" id="login" class="form-control" value="${usuario.login}" />
		
		
		<label for="senha">Senha:*</label>
		<input type="password" name="usuario.senha" id="senha" class="form-control" />
		
		
		<input type="submit" value="Cadastrar" class="btn btn-default" />
	</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />
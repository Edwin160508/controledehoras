<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="vm" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<form action="${linkTo[LoginController].autentica(null, null)}" method="post">
		<vm:validationMessage name="login_invalido" />
		<div class="form-group">
			<label for="login">Login:*</label>
			<input type="text" name="login" id="login" class="form-control" value="${usuario.login}" />
			
		</div>
		
		<div class="form-group">
			<label for="senha">Senha:*</label>
			<input type="password" name="senha" id="senha" class="form-control" />
			
		</div>
		
		<input type="submit" value="Autenticar" class="btn btn-default" />
</form>

<c:import url="/WEB-INF/jsp/footer.jsp"/>
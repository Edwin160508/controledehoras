<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="vm" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<form action="${linkTo[HoraLancadaController].adiciona(null)}" method="post">
		
		<div class="form-group">
			<label for="data">Data:*</label>
			<input type="text" name="horaLancada.data" id="data" class="form-control" />
			<vm:validationMessage name="horaLancada.data" />
		</div>
		
		<div class="form-group">
			<label for="horaInicial">Hora Inicial:*</label>
			<input type="text" name="horaLancada.horaInicial" id="horaInicial" class="form-control" />
			<vm:validationMessage name="horaLancada.horaInicial" />
		</div>
		
		<div class="form-group">
			<label for="horaFinal">Hora Final:*</label>
			<input type="text" name="horaLancada.horaFinal" id="horaFinal" class="form-control" />
			<vm:validationMessage name="horaLancada.horaFinal" />
		</div>
		
		<input type="submit" value="Lançar hora" class="btn btn-default" />
</form>

<c:import url="/WEB-INF/jsp/footer.jsp"/>
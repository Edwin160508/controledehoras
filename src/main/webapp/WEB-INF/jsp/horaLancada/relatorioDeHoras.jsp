<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="vm" %>
<c:import url="/WEB-INF/jsp/header.jsp" />

<table class="table table-hover">
	<thead>
		  <tr>
		  	<th>Data</th>
		    <th>Horas Normais</th>
		    <th>Horas Extras</th>
		  </tr>
	</thead>
	<tbody>
		<c:forEach items="${relatorio.horasPorDia}" var="h">
		  <tr>
		    <td>${h.data.time}</td>
		    <td>${h.horasNormais}</td>
		    <td>${h.horasExtras}</td>
		  </tr>
		</c:forEach>  
	</tbody>
</table>


<c:import url="/WEB-INF/jsp/footer.jsp" />
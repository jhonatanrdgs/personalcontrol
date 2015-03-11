<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
			<div class="row container-center_60 navbar-default">
				<h4>Gastos Por Categoria</h4>
					<fmt:formatDate value="${inicio}" var="inicioFormatada" pattern="dd/MM/yyyy" />
					<input type="text" value="${inicioFormatada}" class="form-control date" id="inicio"/>
					
					<fmt:formatDate value="${fim}" var="fimFormatada" pattern="dd/MM/yyyy" />
					<input type="text" value="${fimFormatada}" class="form-control date" id="fim"/>
				
				<div id="gastosPorCategoria" style="width:600px;height:260px;"></div>
				
			</div>
		 <script src="<c:url value="/resources/js/relatorios.js" />" type="text/javascript"> </script>
	</tiles:putAttribute>
    </tiles:insertDefinition>
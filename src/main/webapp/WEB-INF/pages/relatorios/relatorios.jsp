<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
			<div class="row container-center_60 navbar-default">
				<h4>Gastos Por Categoria</h4>
				
				<div id="gastosPorCategoria" style="width:600px;height:260px;"></div>
				
			</div>
		 <script src="<c:url value="/resources/js/relatorios.js" />" type="text/javascript"> </script>
	</tiles:putAttribute>
    </tiles:insertDefinition>
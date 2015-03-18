<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="row container-center_60 navbar-default">
			<h4>Per�odo dos Relat�rios</h4>
			<div class="col-lg-7 div-center">
				<br />
				<div class="form-group">
					<label class="col-md-2 control-label" for="inicio">Per�odo:</label>
					<div class="col-md-4">
						<fmt:formatDate value="${inicio}" var="inicioFormatada"	pattern="dd/MM/yyyy" />
						<input type="text" value="${inicioFormatada}" class="form-control date" id="inicio" name="inicio" />
					</div>
					
					<label class="col-md-2 control-label" for="fim">�</label>
					<div class="col-md-4">
						<fmt:formatDate value="${fim}" var="fimFormatada" pattern="dd/MM/yyyy" />
						<input type="text" value="${fimFormatada}" class="form-control date" id="fim" name="fim" />
					</div>
				</div>
				<br />
				<div class="form-group">
					<div class="col-md-12" style="text-align:center">
						<button id="reload" class="btn btn-primary">Atualizar</button>
					</div>
				</div>
				
				<br/>
				<br/>
			</div>
		</div>
		<br/>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos por categoria</p>
			<div id="gastosPorCategoria" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<script src="<c:url value="/resources/js/relatorios.js" />"	type="text/javascript">
			
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

	<div class="container">
		<div class="col-md-12">
		<input type="hidden" value="${mesAtual}" id="mes"/>
		<input type="hidden" value="${anoAtual}" id="ano"/>
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Resumo Mês atual</p>
			<div id="resumo" style="width: 600px; position: relative;margin:auto;">
				<div>
					<label>Total de Gastos no Período:</label>
					<span id="totalGastosPeriodo"></span>
				</div>
				<div>
					<label>Rendimentos no Período:</label>
					<span id="rendimentoPeriodo"></span>
				</div>
				<div>
					<label>Sobra:</label>
					<span id="sobra"></span>
				</div>
				<div>
					<label>Total de Gastos Variáveis no Período:</label>
					<span id="totalGastosVariaveisPeriodo"></span>
				</div>
				<div>
					<label>Total de Gastos Fixos:</label>
					<span id="totalGastosFixos"></span>
				</div>
				<div>
					<label>Renda Comprometida:</label>
					<span id="rendaComprometida"></span>
				</div>
			</div>
		</div>
		
		<div class="form-group" style="width: 1000px;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos por Mês (Fixos + Variáveis)</p>
			<div id="gastosPorMes" style="width: 1000px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 1100px;margin:0 auto;text-align: center;">
			<p class="bg-primary">Rendimentos x Gastos (Fixos + Variáveis)</p>
			<div id="rendimentosGastos" style="width: 1100px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		</div>
	</div>
	
	<script src="<c:url value="/resources/js/index.js" />"	type="text/javascript"></script>
	
	</tiles:putAttribute>
	</tiles:insertDefinition>

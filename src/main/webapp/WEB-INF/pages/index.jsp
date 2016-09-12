<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="container">
			<div class="col-md-12">
			
				<input type="hidden" value="${mesAtual}" id="mes" /> 
				<input type="hidden" value="${anoAtual}" id="ano" />
				
				<div class="form-group" style="width: 50%; margin: 0 auto; text-align: center;">
					<p id="resumoMes" class="bg-primary">Resumo Mês atual</p>
					<div id="resumo" >
						<p>
							<span class="col1">Rendimentos no Período</span>
							<span class="col2" id="rendimentoPeriodo"> </span>
						</p>
						<p>
							<span class="col1">Total de Gastos Fixos</span> 
							<span class="col2" id="totalGastosFixos"></span>
						</p>
						<p>
							<span class="col1">Total de Gastos Variáveis no Período</span> 
							<span class="col2" id="totalGastosVariaveisPeriodo"></span>
						</p>
						<p>
							<span class="col1">Total de Gastos no Período</span>
							 <span class="col2" id="totalGastosPeriodo"></span>
						</p>
						<p>
							<span class="col1">Rendimentos - Gastos</span> 
							<span class="col2" id="sobra"></span>
						</p>
						<p>
							<span class="col1">Percentual Comprometido</span> 
							<span class="col2" id="rendaComprometida"></span>
						</p>
					</div>
				</div>

				<div class="form-group" style="width: 1100px; margin: 0 auto; text-align: center;">
					<p class="bg-primary">Rendimentos x Gastos (Fixos + Variáveis)</p>
					<div id="rendimentosGastos" style="width: 1100px; height: 350px; position: relative; margin: auto;"></div>
				</div>

				<div class="form-group" style="width: 1000px; margin: 0 auto; text-align: center;">
					<p class="bg-primary">Percentual Comprometido 12 Meses</p>
					<div id="graficoPercentual12Meses" style="width: 1000px; height: 350px; position: relative; margin: auto;"></div>
				</div>

			</div>
		</div>

		<script src="<c:url value="/resources/js/index.js" />" type="text/javascript"></script>

	</tiles:putAttribute>
</tiles:insertDefinition>

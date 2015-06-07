<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
					
					<label class="col-md-1 control-label" for="fim">�</label>
					<div class="col-md-4">
						<fmt:formatDate value="${fim}" var="fimFormatada" pattern="dd/MM/yyyy" />
						<input type="text" value="${fimFormatada}" class="form-control date" id="fim" name="fim" />
					</div>
				</div>
				<br />
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
			<p class="bg-primary">Resumo</p>
			<div id="resumo" style="width: 600px; position: relative;margin:auto;">
				<div>
					<label>Total de Gastos no Per�odo:</label>
					<span id="totalGastosPeriodo"></span>
				</div>
				<div>
					<label>Total de Gastos Vari�veis no Per�odo:</label>
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
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos (Vari�veis - parcelados e n�o parcelados) por categoria </p>
			<div id="gastosPorCategoria" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos (Vari�veis - parcelados e n�o parcelados) por m�todo de pagamento</p> 
			<div id="gastosPorMetodoPagamento" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Compras Parceladas</p>
			<div id="comprasParceladas" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 95%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos vari�veis</p>
			<div id="gastosVariaveis" style="width: 95% height: 450px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos fixos</p>
			<div id="gastosFixos" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<script src="<c:url value="/resources/js/relatorios.js" />"	type="text/javascript">
			
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>
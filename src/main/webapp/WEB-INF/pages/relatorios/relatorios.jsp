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
						<label class="col-md-1 control-label" for="mes">M�s:</label>
						<div class="col-md-5">
							<select class="form-control" id="mes">
								<option value="" label="Selecione"/>
								<c:forEach items="${meses}" var="item" varStatus="it">
									<c:choose>
										<c:when test="${mesAtual == it.index + 1}">
											<option value="${it.index + 1}" selected="selected">${item}</option>
										</c:when>
										<c:otherwise>
											<option value="${it.index + 1}" >${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						
						<label class="col-md-1 control-label" for="ano">Ano:</label>
						<div class="col-md-5">
							<select class="form-control" id="ano">
								<option value="" label="Selecione"/>
								<c:forEach items="${anos}" var="item">
									<c:choose>
										<c:when test="${anoAtual == item}">
											<option value="${item}" selected="selected">${item}</option>
										</c:when>
										<c:otherwise>
											<option value="${item}" >${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
				<br />
				<br />
				
				
				<br/>
				<br/>
			</div>
		</div>
		<br/>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p id="resumoMes" class="bg-primary">Resumo</p>
			<div id="resumo" >
						<p>
							<span class="col1">Rendimentos no Per�odo</span>
							<span class="col2" id="rendimentoPeriodo"> </span>
						</p>
						<p>
							<span class="col1">Total de Gastos Fixos</span> 
							<span class="col2" id="totalGastosFixos"></span>
						</p>
						<p>
							<span class="col1">Total de Gastos Vari�veis no Per�odo</span> 
							<span class="col2" id="totalGastosVariaveisPeriodo"></span>
						</p>
						<p>
							<span class="col1">Total de Gastos no Per�odo</span>
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
		
		<div class="form-group" style="width: 95%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos (Vari�veis - parcelados e n�o parcelados) por categoria </p>
			<div id="gastosPorCategoria" style="width: 95%; height: 450px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos (Vari�veis - parcelados e n�o parcelados) por m�todo de pagamento</p> 
			<div id="gastosPorMetodoPagamento" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 95%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Compras Parceladas</p>
			<div id="comprasParceladas" style="width: 95%; height: 450px; position: relative;margin:auto;"></div>
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
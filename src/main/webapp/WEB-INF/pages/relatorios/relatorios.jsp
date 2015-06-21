<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="row container-center_60 navbar-default">
			<h4>Período dos Relatórios</h4>
			<div class="col-lg-7 div-center">
				<br />
				<div class="form-group">
						<label class="col-md-1 control-label" for="mes">Mês:</label>
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
					<label>Total de Gastos no Período:</label>
					<span id="totalGastosPeriodo"></span>
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
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos (Variáveis - parcelados e não parcelados) por categoria </p>
			<div id="gastosPorCategoria" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos (Variáveis - parcelados e não parcelados) por método de pagamento</p> 
			<div id="gastosPorMetodoPagamento" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 50%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Compras Parceladas</p>
			<div id="comprasParceladas" style="width: 600px; height: 350px; position: relative;margin:auto;"></div>
		</div>
		
		<div class="form-group" style="width: 95%;margin:0 auto;text-align: center;">
			<p class="bg-primary">Gastos variáveis</p>
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
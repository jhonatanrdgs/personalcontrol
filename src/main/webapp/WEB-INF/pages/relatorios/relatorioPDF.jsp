<html xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="imprimirGastosMensais" method="get" commandName="relatorioForm">
			<div class="row container-center_60 navbar-default">
				<h4>Relatório Gastos Mensais</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1 control-label" for="mes">Mês:</label>
						<div class="col-md-5">
							<form:select path="mes" class="form-control">
								<form:option value="" label="Selecione"/>
								<c:forEach items="${meses}" var="item" varStatus="it">
									<form:option value="${it.index}" label="${item}" />
								</c:forEach>
							</form:select>
						</div>
						
						<label class="col-md-1 control-label" for="ano">Ano:</label>
						<div class="col-md-5">
							<form:select path="ano" class="form-control">
								<form:option value="" label="Selecione"/>
								<c:forEach items="${anos}" var="item">
									<form:option value="${item}" label="${item}" />
								</c:forEach>
							</form:select>
						</div>
					</div>
					
					<div class="form-group" style="text-align: center;">
						<input type="submit" value="Gerar Gastos Mensais" class="btn btn-primary"/>
						
					</div>
				</div>
			</div>
		
		</form:form>
		
		<form action="<c:url value="/relatorioPDF/imprimirDespesasCarro" />">
			<div class="row container-center_60 navbar-default">
				<h4>Relatório Despesas Carro</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group" style="text-align: center;">
						<input type="submit" value="Gerar Despesas Carro" class="btn btn-primary" name="despesasCarro"/>
					</div>
				</div>
			</div>
		</form>
		 <script src="<c:url value="/resources/js/relatorioPDF.js" />" type="text/javascript"> </script>
	</tiles:putAttribute>
</tiles:insertDefinition>
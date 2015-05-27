<html xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="relatorioPDF/imprimir" method="get" commandName="relatorioForm">
			<div class="row container-center_60 navbar-default">
				<h4>Relatório de despesas mensais (PDF)</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Mês:</label>
						<div class="col-md-8">
							<form:select path="mes" class="form-control">
								<form:option value="" label="Selecione"/>
								<c:forEach items="${meses}" var="item" varStatus="it">
									<form:option value="${it.index}" label="${item}" />
								</c:forEach>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" value="Gerar" class="btn btn-primary"/>
					</div>
				</div>
			</div>
		
		</form:form>
		
	</tiles:putAttribute>
</tiles:insertDefinition>
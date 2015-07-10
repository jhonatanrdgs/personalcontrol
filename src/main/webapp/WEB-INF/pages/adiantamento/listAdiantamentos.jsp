<html xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="get" commandName="despesaForm">
			<div class="row container-center_60 navbar-default">
				<h4>Consulta de Categorias</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Despesas:</label>
						<div class="col-md-8">
							<form:select  path="id" class="form-control" >
								<form:option value="" label="Selecione" />
								<form:options items="${despesas}" itemValue="id" itemLabel="descricao" />
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Pesquisar" class="btn btn-primary"/>
						</div>
					</div>
					
					<c:if test="${not empty resultado}">
						<table class="table table-bordered">
							<thead>
							<tr>
								<th class="info">
									<label>Data de Vencimento</label>
								</th>
								
								<th class="info">
									<label>Valor</label>
								</th>
							
								<th class="info">
									<label>Ações</label>
								</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${resultado}" var="it">
								<tr class="active">
									<td width="40%">
										<span><fmt:formatDate value="${it.dataParcela}" pattern="dd/MM/yyyy" /></span>
									</td>
									<td width="40%">
										<span>${it.valorParcela}</span>
									</td>
									<td style="text-align:center;width:20%">
										<a href="<c:url value="/adiantamento/adiantar?idParcela=${it.id}" />" class="btn btn-success">Adiantar</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div style="text-align: center;">
							<a href="<c:url value="/adiantamento/adiantarTodas?idDespesa=${idDespesa}" />" class="btn btn-success">Adiantar Todas</a>
						</div>
					</c:if>
				</div>
			</div>
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
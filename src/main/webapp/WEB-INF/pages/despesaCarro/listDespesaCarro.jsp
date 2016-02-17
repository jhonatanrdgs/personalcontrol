<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="get" commandName="form">
			<div class="row container-center_80 navbar-default">
				<h4>Consulta de Despesas do carro</h4>
				
				<div class="col-lg-7 div-center">
					<br/>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Início:</label>
						<div class="col-md-3 input-icon">
							<form:input type="text" path="inicio" class="form-control mask_date" />
						</div>
					
						<label class="col-md-2 control-label" for="nome">Fim:</label>
						<div class="col-md-3 input-icon">
							<form:input type="text" path="fim" class="form-control mask_date" />
						</div>
					</div>
					
					
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Pesquisar" class="btn btn-primary"/>
							<a href="<c:url value="/despesaCarro/newDespesaCarro" />" class="btn btn-success">Nova</a>
						</div>
					</div>
					
					<c:if test="${not empty resultado}">
						<table class="table table-bordered paginated">
							<thead>
							<tr>
								<th class="info">
									<label>Valor total</label>
								</th>
								<th class="info">
									<label>Data</label>
								</th>
								<th class="info">
									<label>KM</label>
								</th>
								<th class="info">
									<label>Ações</label>
								</th>
								<th class="info">
									<label>Ações</label>
								</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${resultado}" var="it">
								<tr class="active">
									<td width="30%">
										<span>${it.valorTotal}</span>
									</td>
									<td width="30%">
										<span><fmt:formatDate value="${it.data}" pattern="dd/MM/yyyy" /></span>
									</td>
									<td width="20%">
										<span>${it.km}</span>
									</td>
									
									<td  style="text-align:center;width:20%">
										<a href="<c:url value="/despesaCarro/edit?despesaCarroId=${it.id}" />" class="btn btn-success">Editar</a>
									</td>
									<td>
										<a href="<c:url value="/despesaCarro/delete?despesaCarroId=${it.id}" />" class="btn btn-success"
										  onclick="return confirm('Deseja realmente excluir o registro?')">Excluir</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
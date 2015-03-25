<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="get" commandName="rendimentoForm">
			<div class="row container-center_60 navbar-default">
				<h4>Consulta de Rendimentos</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Nome:</label>
						<div class="col-md-8">
							<form:input type="text" path="nomePessoa" class="form-control" id="nome"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Pesquisar" class="btn btn-primary"/>
							<a href="<c:url value="/rendimento/newRendimento" />" class="btn btn-success">Novo</a>
						</div>
					</div>
					
					<c:if test="${not empty resultado}">
						<table class="table table-bordered">
							<th class="info">
								<label>Nome Pessoa</label>
							</th>
							<th class="info">
								<label>Valor</label>
							</th>
							<th class="info">
								<label>Ações</label>
							</th>
							<c:forEach items="${resultado}" var="it">
								<tr class="active">
									<td width="40%">
										<span>${it.nomePessoa}</span>
									</td>
									<td width="40%">
										<span>${it.valor}</span>
									</td>
									<td  style="text-align:center;width:20%">
										<a href="<c:url value="/rendimento/edit?rendimentoId=${it.id}" />" class="btn btn-success">Editar</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
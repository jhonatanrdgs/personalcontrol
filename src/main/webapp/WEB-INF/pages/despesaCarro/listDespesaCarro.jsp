<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="get" commandName="despesaCarroForm">
			<div class="row container-center_80 navbar-default">
				<h4>Consulta de Despesas do carro</h4>
				
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Nome:</label>
						<div class="col-md-8">
							<form:input type="text" path="descricao" class="form-control" id="nome"/>
						</div>
					</div>
					
					
					
					
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Pesquisar" class="btn btn-primary"/>
							<a href="<c:url value="/despesaCarro/newDespesaCarro" />" class="btn btn-success">Nova</a>
						</div>
					</div>
					
					<c:if test="${not empty resultado}">
						<table class="table table-bordered">
							<th class="info">
								<label>Descrição</label>
							</th>
							<th class="info">
								<label>Categoria</label>
							</th>
							<th class="info">
								<label>Método Pagamento</label>
							</th>
							<th class="info">
								<label>Data</label>
							</th>
							<th class="info">
								<label>Ações</label>
							</th>
							<c:forEach items="${resultado}" var="it">
								<tr class="active">
									<td width="20%">
										<span>${it.descricao}</span>
									</td>
									<td width="20%">
										<span>${it.categoria.descricao}</span>
									</td>
									<td width="20%">
										<span>${it.metodoPagamento.descricao}</span>
									</td>
									<td width="20%">
										<span><fmt:formatDate value="${it.data}" pattern="dd/MM/yyyy" /></span>
									</td>
									<td  style="text-align:center;width:20%">
										<a href="<c:url value="/despesaCarro/edit?despesaCarroId=${it.id}" />" class="btn btn-success">Editar</a>
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
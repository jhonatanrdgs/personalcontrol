<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="get" commandName="despesaForm">
			<div class="row container-center_80 navbar-default">
				<h4>Consulta de Despesas</h4>
				
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Nome:</label>
						<div class="col-md-8">
							<form:input type="text" path="descricao" class="form-control" id="nome" maxlength="100"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Categoria:</label>
						<div class="col-md-8 input-icon">
							<form:select path="categoriaId" class="form-control">
								<form:option value="" label="Selecione"/>
								<form:options items="${categorias}" itemLabel="descricao" itemValue="id"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Método de Pagamento:</label>
						<div class="col-md-8 input-icon">
							<form:select path="metodoPagamentoId" class="form-control" >
								<form:option value="" label="Selecione"/>
								<form:options items="${metodosPagamento}" itemLabel="descricao" itemValue="id"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Início:</label>
						<div class="col-md-3 input-icon">
							<form:input type="text" path="inicio" class="form-control date" />
						</div>
					
						<label class="col-md-2 control-label" for="nome">Fim:</label>
						<div class="col-md-3 input-icon">
							<form:input type="text" path="fim" class="form-control date" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Pesquisar" class="btn btn-primary"/>
							<a href="<c:url value="/despesa/newDespesa" />" class="btn btn-success">Nova</a>
						</div>
					</div>
					
					<c:if test="${not empty resultado}">
						<table class="table table-bordered paginated">
							<thead>
							<tr>
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
								<th class="info">
									<label>Ações</label>
								</th>
							</tr>
							</thead>
							<tbody>
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
										<a href="<c:url value="/despesa/edit?despesaId=${it.id}" />" class="btn btn-success">Editar</a>
									</td>
									<td>
										<a href="<c:url value="/despesa/delete?despesaId=${it.id}" />" class="btn btn-success"
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
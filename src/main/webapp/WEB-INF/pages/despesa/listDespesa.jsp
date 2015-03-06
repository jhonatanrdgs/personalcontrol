<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="get" commandName="despesaForm">
			<div class="row container-center_60 navbar-default">
				<h4>Consulta de Despesas</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Nome:</label>
						<div class="col-md-8">
							<form:input type="text" path="descricao" class="form-control" id="nome"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Categoria:</label>
						<div class="col-md-8 input-icon">
							<form:select path="categoriaId" class="form-control">
								<form:options items="${categorias}" itemLabel="descricao" itemValue="id"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Método de Pagamento:</label>
						<div class="col-md-8 input-icon">
							<form:select path="metodoPagamentoId" class="form-control" >
								<form:options items="${metodosPagamento}" itemLabel="descricao" itemValue="id"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Início:</label>
						<div class="col-md-8 input-icon">
							<form:input type="text" path="inicio" class="form-control date" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Fim:</label>
						<div class="col-md-8 input-icon">
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
						<table class="table table-bordered">
							<th class="info">
								<label>Descrição</label>
							</th>
							<th class="info">
								<label>Ações</label>
							</th>
							<c:forEach items="${resultado}" var="it">
								<tr class="active">
									<td width="80%">
										<span>${it.descricao}</span>
									</td>
									<td  style="text-align:center;width:20%">
										<a href="<c:url value="/despesa/edit?despesaId=${it.id}" />" class="btn btn-success">Editar</a>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="get" commandName="categoriaForm">
			<div class="row container-center_60 navbar-default">
				<h4>Consulta de Categorias</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Nome:</label>
						<div class="col-md-8">
							<form:input type="text" path="descricao" class="form-control" id="nome"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-1 control-label" for="ativa">Ativa:</label>
						<div class="col-md-8">
							<form:checkbox path="ativo" id="ativa"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Pesquisar" class="btn btn-primary"/>
							<a href="<c:url value="/categoria/newCategoria" />" class="btn btn-success">Nova</a>
						</div>
					</div>
					
					<c:if test="${not empty resultado}">
						<table class="table table-bordered">
							<tr>
								<th class="info">
									<label>Descrição</label>
								</th>
							
								<th class="info" colspan="2">
									<label>Ações</label>
								</th>
							</tr>
							<c:forEach items="${resultado}" var="it">
								<tr class="active">
									<td width="70%">
										<span>${it.descricao}</span>
									</td>
									<td style="text-align:center;width:15%">
										<a href="<c:url value="/categoria/edit?categoriaId=${it.id}" />" class="btn btn-success">Editar</a>
									</td>
									<td style="text-align:center;width:15%">
										<c:choose>
											<c:when test="${it.ativo}">
												<a href="<c:url value="/categoria/delete?categoriaId=${it.id}" />" 
												class="btn btn-success" onclick="return confirm('Deseja realmente inativar o registro?')">Inativar</a>
											</c:when>
											<c:otherwise>
												<a href="<c:url value="/categoria/ativar?categoriaId=${it.id}" />" 
												class="btn btn-success"  onclick="return confirm('Deseja realmente ativar o registro?')">Ativar</a>
											</c:otherwise>
										</c:choose>
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
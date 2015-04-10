<html xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
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
					

					<c:if test="${not empty page}">
						<table class="table table-bordered">
							<tr>
								<th class="info">
									<label>Descrição</label>
								</th>
							
								<th class="info" colspan="2">
									<label>Ações</label>
								</th>
							</tr>
							<c:forEach items="${page.content}" var="it">
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
						
														<!-- Pagination Bar -->
<div th:fragment='paginationbar'>
  <div class='pagination pagination-centered'>
    <ul>
      <li th:class='${page.firstPage}? 'disabled' : '''>
        <span th:if='${page.firstPage}'> First</span>
        <a th:if='${not page.firstPage}' th:href='@{${page.url}(page.page=1,page.size=${page.size})}'> First</a>
      </li>
      <li th:class='${page.hasPreviousPage}? '' : 'disabled''>
        <span th:if='${not page.hasPreviousPage}'>«</span>
        <a th:if='${page.hasPreviousPage}' th:href='@{${page.url}(page.page=${page.number-1},page.size=${page.size})}' title='Go to previous page'>«</a>
      </li>
      <li th:each='item : ${page.items}' th:class='${item.current}? 'active' : '''>
        <span th:if='${item.current}' th:text='${item.number}'>1</span>
        <a th:if='${not item.current}' th:href='@{${page.url}(page.page=${item.number},page.size=${page.size})}'><span th:text='${item.number}'>1</span></a>
      </li>
      <li th:class='${page.hasNextPage}? '' : 'disabled''>
        <span th:if='${not page.hasNextPage}'>»</span>
        <a th:if='${page.hasNextPage}' href="/personalControl/categoria/search?page.page=${page.number+1}&page.size=${page.size}" title='Go to next page'>»</a>
        
        

      </li>
      <li th:class='${page.lastPage}? 'disabled' : '''>
        <span th:if='${page.lastPage}'>Last </span>
        <a th:if='${not page.lastPage}' th:href='@{${page.url}(page.page=${page.totalPages},page.size=${page.size})}'>Last </a>
      </li>
    </ul>
  </div>
</div>
						
					</c:if>
				</div>
			</div>
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
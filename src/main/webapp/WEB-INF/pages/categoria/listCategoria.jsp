<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
		<form:form class="form-horizontal" action="search" method="post" commandName="categoriaForm">

			<div class="row container-center well">
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1" for="nome">Nome:</label>
						<div class="col-md-8">
							<form:input type="text" path="descricao" class="form-control" id="nome"/>
						</div>
					</div>
					<input type="submit" value="Pesquisar" class="btn btn-primary"/>
					<a href="<c:url value="/categoria/newCategoria" />" class="btn btn-success">Nova</a>
				</div>
			</div>
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
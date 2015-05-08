<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<form:form class="form-horizontal" action="save" method="post" commandName="categoriaForm" id="formCategoria">
			<form:hidden  path="id" class="form-control"  />
			<div class="row container-center_80 well">
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1 control-label" for="descricao">Nome:</label>
						<div class="col-md-8 input-icon">
							<form:input type="text" path="descricao" class="form-control" maxlength="100" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-1 control-label" for="descricao">Ativa:</label>
						<div class="col-md-8 input-icon">
							<form:checkbox path="ativo"  />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Salvar" class="btn btn-primary"/>
							<a href="<c:url value="/categoria/listCategoria" />" class="btn btn-default">Voltar</a>
						</div>
					</div>
				</div>
			</div>
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
    <script src="<c:url value="/resources/js/categoria.js" />" type="text/javascript"> </script>
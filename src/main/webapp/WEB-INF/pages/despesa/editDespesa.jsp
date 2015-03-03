<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<form:form class="form-horizontal" action="save" method="post" commandName="despesaForm" id="formDespesa">
			<form:hidden  path="id" class="form-control"  />
			<div class="row container-center_80 well">
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-1 control-label" for="nome">Nome:</label>
						<div class="col-md-8 input-icon">
							<form:input type="text" path="descricao" class="form-control"  />
						</div>
					</div>
					<input type="submit" value="Salvar" class="btn btn-primary"/>
				</div>
			</div>
			
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
    <script src="<c:url value="/resources/js/despesa.js" />" type="text/javascript"> </script>
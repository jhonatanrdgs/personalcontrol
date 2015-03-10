<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<form:form class="form-horizontal" action="save" method="post" commandName="metodoPagamentoForm" id="formMetodoPagamento">
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
					
					<div class="form-group">
						<label class="col-md-1 control-label" for="descricao">Ativo:</label>
						<div class="col-md-8 input-icon">
							<form:checkbox path="ativo"  />
						</div>
					</div>
					
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Salvar" class="btn btn-primary"/>
							<a href="<c:url value="/metodoPagamento/listMetodosPagamento" />" class="btn btn-default">Voltar</a>
						</div>
					</div>
				</div>
			</div>
			
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
    <script src="<c:url value="/resources/js/metodoPagamento.js" />" type="text/javascript"> </script>
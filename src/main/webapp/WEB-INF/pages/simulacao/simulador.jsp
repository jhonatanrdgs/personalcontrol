<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<form:form class="form-horizontal" action="simular" method="post" commandName="simuladorForm" id="formSimulacao">
			<div class="row container-center_80 well">
			<h4>Simulação de Despesas</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-2 control-label" for="descricao">Nome:</label>
						<div class="col-md-8 input-icon">
							<form:input type="text" path="descricao" class="form-control" maxlength="100" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="categoria.id">Categoria:</label>
						<div class="col-md-8 input-icon">
							<form:select path="categoria.id" class="form-control" name="categoriaId">
								<form:option value="" label="Selecione"/>
								<form:options items="${categorias}" itemLabel="descricao" itemValue="id"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Método de Pagamento:</label>
						<div class="col-md-8 input-icon">
							<form:select path="metodoPagamento.id" class="form-control" >
								<form:option value="" label="Selecione"/>
								<form:options items="${metodosPagamento}" itemLabel="descricao" itemValue="id"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">Valor Total:</label>
						<div class="col-md-2 input-icon">
							<form:input type="text" path="valorTotal"  class="form-control money"/>
						</div>
					
						<label class="col-md-1 control-label" for="nome">Qtd Par:</label>
						<div class="col-md-1 input-icon">
							<form:input type="number" path="totalParcelas" class="form-control" />
						</div>
					
						<label class="col-md-2 control-label" for="nome">Data da despesa:</label>
						<div class="col-md-2 input-icon">
							<form:input type="text" path="data" class="form-control mask_date" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Simular" class="btn btn-primary"/>
						</div>
					</div>
					
				</div>
			</div>
			
			
			<div class="form-group" style="width: 90%;margin:0 auto;text-align: center;">
				<p class="bg-primary">Simulação Rendimentos x Gastos</p>
				<div id="simulacaoRendimentosGastos" style="width: 1100px; height: 500px; position: relative;margin:auto;"></div>
			</div>
			
			</div>
			
		</form:form>
		<script src="<c:url value="/resources/js/simulador.js" />" type="text/javascript"> </script>
	</tiles:putAttribute>
    </tiles:insertDefinition>
	
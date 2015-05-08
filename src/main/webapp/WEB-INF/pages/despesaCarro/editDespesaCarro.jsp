<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<form:form class="form-horizontal" action="save" method="post" commandName="despesaCarroForm" id="formDespesa">
			<form:hidden  path="id" class="form-control"  />
			<form:hidden path="usuario.id" class="form-control" />
			<div class="row container-center_80 well">
			<h4>Cadastro de Despesas</h4>
				<div class="col-lg-7 div-center">
					<br/>
					<div class="form-group">
						<label class="col-md-2 control-label" for="descricao">Nome:</label>
						<div class="col-md-8 input-icon">
							<form:input type="text" path="descricao" class="form-control" maxlength="100"/>
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
					
						<label class="col-md-1 control-label" for="totalParcelas">Qtd Par:</label>
						<div class="col-md-1 input-icon">
							<form:input type="number" path="totalParcelas" class="form-control" />
						</div>
					
						<label class="col-md-2 control-label" for="data">Data da despesa:</label>
						<div class="col-md-2 input-icon">
							<form:input type="text" path="data" class="form-control date" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="km">Km:</label>
						<div class="col-md-8 input-icon">
							<form:input type="text" path="km" class="form-control numeric" maxlength="6" />
						</div>
					</div>
				
				<div style="background-color: #f5f5f5; border: 1px solid #e3e3e3; margin-bottom:20px;">
					<label>Itens</label>
					<div class="form-group">
						<label class="col-md-2 control-label" for="desc">Descrição:</label>
						<div class="col-md-8 input-icon">
							<input type="text" id="desc" class="form-control" maxlength="100"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label" for="val">Valor:</label>
						<div class="col-md-8 input-icon">
							<input type="text" id="val" class="form-control money"/>
						</div>
					</div>	
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<a href="#" id="add" class="btn btn-default">Adicionar Item</a>
						</div>
					</div>
					
					<div id="tableItens" style="width:80%; margin:auto" ></div>
					
				</div>
					
					<div class="form-group">
						<div class="col-md-12" style="text-align:center">
							<input type="submit" value="Salvar" class="btn btn-primary"/>
							<a href="<c:url value="/despesaCarro/listDespesaCarro" />" class="btn btn-default">Voltar</a>
						</div>
					</div>
					
				</div>
			</div>
			
		</form:form>
		
	</tiles:putAttribute>
    </tiles:insertDefinition>
    <script src="<c:url value="/resources/js/despesaCarro.js" />" type="text/javascript"> </script>
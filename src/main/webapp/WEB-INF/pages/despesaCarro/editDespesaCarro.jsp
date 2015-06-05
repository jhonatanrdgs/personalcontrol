<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<form:form class="form-horizontal" action="save" method="post" commandName="despesaCarroForm" id="formDespesa" >
			<form:hidden  path="id" class="form-control"  />
			<div class="row container-center_80 well">
			<h4>Cadastro de despesas do carro</h4>
				<div class="col-lg-7 div-center">
					<br/>
					
					<div class="form-group">
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		
		<div class="row container-center well" style="width: 40% !important;">
				<div class="col-lg-4 div-center">
		<h1>Bem vindo!</h1>
		<div id="login-box">

			<h3>Entre com seu usuário e senha</h3>

			<c:if test="${not empty error}">
				<p class="bg-danger">${error}</p>
			</c:if>
			<c:if test="${not empty msg}">
				<p class="bg-success">${msg}</p>
			</c:if>

			<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST' class="form-horizontal">

				<div class="form-group">
					<label class="col-md-2" for="usuario">Usuário:</label>
					<div class="col-md-10">
						<input type='text' name='username' value='' id="usuario" class="form-control">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2" for="pw">Senha:</label>
					<div class="col-md-10">
						<input type='password' name='password' id="pw" class="form-control"/>
					</div>
				</div>
				<div class="form-group">
					<input name="submit" type="submit" class="btn btn-primary" value="Login" />
				</div>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</form>
		</div>
</div>
</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
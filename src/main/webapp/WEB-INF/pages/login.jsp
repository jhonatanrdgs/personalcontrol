<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		
		<div class="row container-center_80 navbar-default" style="width: 40% !important;">
				<div class="col-lg-4 div-center">
		<h1>Bem vindo!</h1>
		<div id="login-box">

			<h3>Entre com seu usuário e senha</h3>

			<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST' class="form-horizontal">

				<div class="form-group">
					<label class="col-md-2 control-label" for="usuario">Usuário:</label>
					<div class="col-md-10">
						<input type='text' name='username' value='' id="usuario" class="form-control">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label" for="pw">Senha:</label>
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
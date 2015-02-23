<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
	<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

	<div class="page-header">
		<h1>Página Inicial</h1>
		<small>Message : ${bemVindo}</small>
	</div>
	<p class="text-muted">bbb</p>
	<div class="container">
		<div class="col-md-12">
			aaa
		</div>
	</div>
	
	</tiles:putAttribute>
	</tiles:insertDefinition>

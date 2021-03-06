<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/images/icon.ico" />" rel="Shortcut Icon" type="image/ico" />
    <title>Personal Control</title>
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
    <script src="<c:url value="/resources/js/jquery-ui.min.js" />" > </script>
    <script src="<c:url value="/resources/js/bootstrap.js" />" > </script>
    <script src="<c:url value="/resources/js/jquery.mask.min.js" />" > </script>
    <script src="<c:url value="/resources/js/maskmoney.min.js" />" > </script>
    <script src="<c:url value="/resources/js/masks.js" />" > </script>
    <script src="<c:url value="/resources/js/jquery.jqplot.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jqplot.barRenderer.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jqplot.categoryAxisRenderer.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jqplot.pointLabels.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jqplot.canvasAxisTickRenderer.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jqplot.dateAxisRenderer.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jqplot.canvasTextRenderer.min.js" />" > </script>
    <script src="<c:url value="/resources/js/dateFormat.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jquery-dateFormat.min.js" />" > </script>
    <script src="<c:url value="/resources/js/jquery.numeric.min.js" />" > </script>
     <script src="<c:url value="/resources/js/pagination.js" />" > </script>
     <script src="<c:url value="/resources/js/bootstrap-datepicker.min.js" />" > </script>
     <script src="<c:url value="/resources/js/bootstrap-datepicker.pt-BR.min.js" />" > </script>
     <script src="<c:url value="/resources/js/autoNumeric-min.js" />" > </script>
     <script>
     $.fn.datepicker.defaults.language = 'pt-BR';
     </script>
    <script src="http://cdn.datatables.net/1.10.6/js/jquery.dataTables.min.js" ></script>
    
    <link type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <link type="text/css" href="<c:url value="/resources/css/custom.css" />" rel="stylesheet" />
    <link type="text/css" href="<c:url value="/resources/css/jquery.jqplot.min.css" />" rel="stylesheet" />
    <link type="text/css" href="http://cdn.datatables.net/1.10.6/css/jquery.dataTables.min.css" rel="stylesheet" />
    <link type="text/css" href="<c:url value="/resources/css/bootstrap-datepicker.min.css" />" rel="stylesheet" />
    
</head>
<body>
	
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content">
        	<sec:authorize access="isAuthenticated()">
            	<tiles:insertAttribute name="menu" />
            </sec:authorize>
            
            	<c:if test="${sucesso != null}">
            		<div style="width: 50%; margin: 0 auto; text-align: center;">
						<p class="bg-success" style="line-height:50px;">${sucesso}</p>
					</div>
				</c:if>
				<c:if test="${alerta != null}">
					<div style="width: 50%; margin: 0 auto; text-align: center;">
						<p class="bg-warning" style="line-height:50px;">${alerta}</p>
					</div>
				</c:if>
				<c:if test="${erro != null}">
					<div style="width: 50%; margin: 0 auto; text-align: center;">
						<p class="bg-danger" style="line-height:50px;">${erro}</p>
					</div>
				</c:if>
            
            <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>
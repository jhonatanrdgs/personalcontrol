<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/images/icon.ico" />" rel="Shortcut Icon" type="image/ico" />
    <title>Personal Control</title>
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />" > </script>
    <script src="<c:url value="/resources/js/jquery.mask.min.js" />" > </script>
        <script src="<c:url value="/resources/js/maskmoney.min.js" />" > </script>
    <script src="<c:url value="/resources/js/masks.js" />" > </script>
    <link type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <link type="text/css" href="<c:url value="/resources/css/custom.css" />" rel="stylesheet" />
    
</head>
<body>
	
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content">
        	<sec:authorize access="isAuthenticated()">
            	<tiles:insertAttribute name="menu" />
            </sec:authorize>
            <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>
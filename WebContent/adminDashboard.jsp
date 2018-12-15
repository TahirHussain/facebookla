<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facebookla</title>
<style>
.abc {
	background-color: #3b5998;
	height: 82px;
	margin-left: 0px;
	padding: 0;
	font-weight: 600px;
	color: white;
}

#adminInfo{
	position: absolute;
	left: 454px;
    top: 209px;
}

#vb {

    background: #1453ba;
    border: solid #1453ba;
    margin-left: 290px;

}
#unauth{
    position: absolute;
    top: 187px;
    left: 473px;
    color: red;
}
#logo {
	margin: 0;
	line-height: 2.2;
	margin-left: 150px;
	font-weight: bold;
	font-size: 40px;
	color: EBEEF4;
}
body {
	margin: 0;
	background: #FAFBFC;
}
</style>
<link rel="icon" type="image/gif/png" href="resources/imgs/fico.png">
</head>
<body>
	<c:if test="${sessionScope.userId == 6}">
		<div class="abc">
			<h1 id="logo" >Admin Dashboard</h1>
			
		</div>
		<div id="adminInfo">
			<h3>No. of Users Registered: ${count}</h3>
			
			<c:url var="viewusersURL" value="${request.getServletContext()}/admin/viewusers"></c:url>
			<a href="${viewusersURL}" id="vb"> <button>View Users</button></a>
		</div>
	</c:if>
	<c:if test="${sessionScope.userId != 6}">
		<div id="unauth">
			<h1>UnAuthorized Access!</h1>
		</div>
	</c:if>
</body>
</html>
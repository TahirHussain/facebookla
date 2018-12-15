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

#userlist {
    position: absolute;
    top: 140px;
    left: 201px;
}

#usertable{
	position:absolute;
    width: 850px;
    line-height: 32px;
    border: double;
    border-color: powderblue;
    color: navy;
    font-size: larger;
    font-family: helvetica;
}

#headId{
	color: maroon;
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
		<div id="userlist">
			<table id="usertable">
				<thead id="headId">
					<tr style="outline: thin solid">
						<td>First Name</td><td>Surname</td><td>Email</td><td>Gender</td>
					</tr>
				</thead>
				<c:url var="deluserurl" value="${request.getServletContext()}/admin/deleteuser"></c:url>
				<c:forEach var="l" items="${listOfUsers}">
				<tr>
					
					<td>${l.fName}</td><td>${l.surname}</td><td>${l.emailId}</td><td>${l.gender}</td>
					<td>
						<a href="${deluserurl}?uid=${l.id}" id="db" > <button style="color: red;">delete</button></a>
					</td>
					<!-- <td>Tahir</td><td>Mir</td><td>tahirchamp@gmail.com</td><td>Male</td> -->
				</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<c:if test="${sessionScope.userId != 6}">
		<div id="unauth">
			<h1>UnAuthorized Access!</h1>
		</div>
	</c:if>
</body>
</html>
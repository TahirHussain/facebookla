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

#b1 {
	height: 40px;
	width: 75px;
	color: red;
	font-size: 24px;
}

#logo {
	margin: 0;
	line-height: 2.2;
	margin-left: 150px;
	font-weight: bold;
	font-size: 40px;
	color: EBEEF4;
}

#b1:hover {
	color: green;
	background: pink;
}

#b1:visited {
	background: pink;
}

#b1:active {
	background: pink;
}

#emailLabel {
	position: absolute;
	top: 14px;
	left: 745px;
	font-size: small;
	font-weight: bold;
}

#passLabel {
	position: absolute;
	top: 14px;
	left: 910px;
	font-size: small;
	font-weight: bold;
}

#emailId {
	position: absolute;
	top: 35px;
	left: 745px;
}

#passId {
	position: absolute;
	top: 35px;
	left: 910px;
}

#submitId {
	position: absolute;
	border: 0px;
	top: 35px;
	left: 1065px;
	width: 52px;
	text-align: center;
	background: #1453ba;
	color: white;
}
.leftPart{
	width:100%;
	margin-left: 150px;
	margin-top: 0px;
	background: #FAFBFC;
	height: 164px;
	margin-left: 0px;
	padding: 0;
}
#taglineId{
	color:#0E385F;
	width: 500px;
	position: absolute;
	top:107px;
	left:142px;
}
#tagImageId{
	top: 200px;
	width: 540px;
	position: absolute;
	left:142px;
}

#submitId:HOVER {
	background: #3b5998;
	cursor: pointer;
}
#rightPart{
	position: absolute;
	left:720px;
	top: 80px;
	
}
.halfInputClass{
	height:37px;
	width:77%;
	border: thin;
	border-style: solid;
	border-color: #BDC7D8;
	border-radius: 5px;
	position: relative;
	font-size: large;
	padding-left: 9px;
	
}
.halfInputClass2{
	height:37px;
	width:77%;
	border: thin;
	border-style: solid;
	border-color: #BDC7D8;
	border-radius: 5px;
	position: absolute;
	left: 85%;
	font-size: large;
	padding-left: 9px;
	
}
.fullInputClass{
	height:37px;
	width:162%;
	border: thin;
	border-style: solid;
	border-color: #BDC7D8;
	border-radius: 5px;
	position: absolute;
	top:106%;
	left:0px;
	font-size: large;
	padding-left: 9px;
	
}
.fullInputClass2{
	height:37px;
	width:162%;
	border: thin;
	border-style: solid;
	border-color: #BDC7D8;
	border-radius: 5px;
	position: absolute;
	top:137%;
	left:0px;
	font-size: large;
	padding-left: 9px;
	
}
/* #birthdayId{
	position: absolute;
	top: 160%
} */
#femaleId{
	position: absolute;
	top: 175%;
	left: 0px;
}
#femaleLabel{
	position: absolute;
	top: 175%;
	left: 27px;
	font-size: large;
}
#maleId{
	position: absolute;
	top: 175%;
	left: 105px;
}
#maleLabel{
	position: absolute;
	top: 175%;
	left: 132px;
	font-size: large;
}
#submitId2{
	position: absolute;
	color:white;
	top: 200%;
	left: 0px;
	font-size: large;
	height:37px;
	width:77%;
	background-color: #71B05D;
}
#rightPart2{
    position: absolute;
    left: 860px;
    top: 198px;
    color: #0E385F;
}
#wrongInfoLabel{
    color: white;
    position: absolute;
    left: 745px;
    top: 57px;
    text-decoration: beige;
    font-size: 19px;
}
body {
	margin: 0;
	background: #FAFBFC;
}
</style>
<link rel="icon" type="image/gif/png" href="resources/imgs/fico.png">
</head>
<body>
	<div class="abc">
		<h1 id="logo" >facebookla</h1>
		<label id="emailLabel">Email or Phone</label> <label id="passLabel">Password</label>
		<form action="login" method="post">
			<input id="emailId" type="text" name="emailId">
			<input id="passId"
				type="password" name="password"> 
			<input id="submitId" type="submit"
				value="Log In">
				
			<c:if test="${requestScope.wrongLoginStatus}">	
			<label id="wrongInfoLabel">Email id or password is wrong!</label>
			</c:if>

		</form>
	</div>
	<div class="leftPart">
		
	</div>
	<h2 id="taglineId">Facebook helps you connect and share with the people in your life.</h2>
	<img id="tagImageId" alt="tagImage" src="resources/imgs/tagImage.png">
	<c:choose>
	
		<c:when test="${not requestScope.signedUp}">
			<div id="rightPart">
				<h1 style="font-weight: bolder; font-size: xx-large;">Create an account</h1>
				<h3 style="font-weight: normal;">It's free and always will be.</h3>
				<form action="reg" method="post">
					<input placeholder="First Name" class="halfInputClass" type="text" name="firstName" >
					<input placeholder="Surname" class="halfInputClass2" type="text" name="surname">
					<input placeholder="Mobile Number or Email Address" class="fullInputClass" type="text" name="emailId">
					<input placeholder="New Password" class="fullInputClass2" type="password" name="password">
					<!-- <h3 id="birthdayId" style="font-weight: normal;">Birthday</h3> -->
					<input id="femaleId" type="radio" name="gender" value="Female"><label id="femaleLabel">Female</label>
					<input id="maleId" type="radio" name="gender" value="Male"><label id="maleLabel">Male</label>
					<input id="submitId2" type="submit" value="Sign Up">
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<div id="rightPart2">
				<h2> Viola! You are signed Up.</h2>
				<p>Please login to continue!</p>
			</div>
		</c:otherwise>
		
		
		<%-- <c:otherwise>
			
		</c:otherwise> --%>
	</c:choose>
	
	

</body>
</html>
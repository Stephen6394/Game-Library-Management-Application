<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<%@include file="/resources/include/includeCSS.jsp"%>
<!-- <link rel="stylesheet" type="text/css" href="CaseStudyFinal03/resources/css/style.css">
 -->
<!-- <style>
* {
	color: white;
}

.bg {
	background: url('resources/images/bg.png') no-repeat;
	width: 100%;
	height: 100vh;
}

.form-container {
	border: 0px solid blue;
	padding: 50px 60px;
	margin-top: 20vh;
	-webkit-box-shadow: -1px 3px 32px 0px rgba(0, 0, 0, 0.75);
	-moz-box-shadow: -1px 3px 32px 0px rgba(0, 0, 0, 0.75);
	box-shadow: -1px 3px 32px 0px rgba(0, 0, 0, 0.75);
}
</style> -->
</head>
<body>
	<header style="background-color: #00CBC5" class="navbar">
		<h1>Case Study Application</h1>
	</header>
	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<form class="form-container" action="VerifyUser" method="post">
					<h1>Login Form</h1>
					<div class="form-group">
						<label for="name">Username:</label> <input type="text"
							class="form-control" name="name" placeholder="Username">
					</div>
					<div class="form-group">
						<label for="passsword">Password</label> <input type="password"
							class="form-control" name="password" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-success btn-block">Login</button><br><br> 
					<div style="color: black">
					${messageResult}
					</div>
				</form>
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
			</div>
		</div>
	</div>
	<footer>
		<h3 style="color: black">Copyright Landry Productions LLC</h3>
	</footer>
</body>
</html>
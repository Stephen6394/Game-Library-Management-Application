<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<style>
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
</style>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand"></a>
		<span class="navbar-text"></span>
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="Home">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="ViewLibrary">My Library</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="AccountSettings">Account Settings</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="LogoutUser">Logout</a>
			</li>
		</ul>
	</nav>	
	<div class="container-fluid bg">
		<div>
			Welcome! User: ${suser.getName()}<br><br>
			Your Library Size: ${librarySize}
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
<title>Index Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
	<!-- <nav>
		<div class="logo">
			<h4>The Nav</h4>
		</div>
		<ul class="nav-links">
			<li><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Work</a></li>
			<li><a href="#">Projects</a></li>
		</ul>
		<div class="burger">
			<div class="line1"></div>
			<div class="line2"></div>
			<div class="line3"></div>
		</div>
	</nav> -->
<!--  	<header class="navbar" style="background-color: #28A745">
		<h1>Case Study Application</h1>
	</header> -->
	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-container">
					<form action="VerifyUser" method="post">
						<div class="text-center ">
							<h1>User Login</h1>
							<div class="text-warning">${messageResult}</div>
						</div>
						<div class="form-group">
							<label for="name">Username:</label> 
							<input type="text" class="form-control" name="name" placeholder="Username">
						</div>
						<div class="form-group">
							<label for="passsword">Password</label> 
							<input type="password" class="form-control" name="password" placeholder="Password">
						</div>
						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-12"></div>
							<div class="col-md-4 col-sm-4 col-xs-12">
								<div class="form-group">
									<button type="submit" class="btn btn-success btn-block">Login</button>
								</div>
							</div>
							<div class="col-md-4 col-sm-4 col-xs-12"></div>
						</div>
					</form>		
					<form action="RegisterUser" method="post">
						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-12"></div>
							<div class="col-md-4 col-sm-4 col-xs-12">
								<div class="form-group">
									<button type="submit" class="btn btn-success btn-block">Register</button>
								</div>
							</div>
							<div class="col-md-4 col-sm-4 col-xs-12"></div>
						</div>
					</form>
				</div>		
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
			</div>
		</div>
	</div>
<!-- 	<footer>
		<h3 style="color: black">Copyright Landry Productions LLC</h3>
	</footer> -->
</body>
</html>
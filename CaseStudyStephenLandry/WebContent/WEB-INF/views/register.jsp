<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- <header class="navbar">
		<h1>Case Study Application</h1>
	</header> -->
	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-container">
					<form:form action="AddUser" method="post" modelAttribute="user">
						<h1 class="text-center">User Registration</h1>
						<div class="form-group">
								<form:errors class="text-warning" path="name"/><br>
							<label for="name">Username:</label> 
							<form:input type="text" class="form-control" path="name" placeholder="Username"/>
						</div>
						<div class="form-group">
							<div class="text-warning">
								${messageResult}
								<form:errors class="text-warning" path="password" />
							</div>
							<label for="password">Password:</label>
							<form:input type="password" path="password" placeholder="Password" class="form-control" />
						</div>
						<div class="form-group">
							<label for="verPassword">Verify Password:</label> 
							<input type="password" class="form-control" name="verPassword" placeholder="Verify password">
						</div>
						<div class="form-group">
							<label for="email">Email:</label> 
							<input type="email" class="form-control" name="email" placeholder=example@example.com>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success btn-block">Register</button>
						</div>
						<div class="form-group">
							<button type="reset" class="btn btn-success btn-block">Reset</button>
						</div>
					</form:form>
					<form action="index" method="post">
						<div class="form-group">
							<button type=submit class="btn btn-success btn-block">Login</button>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
		</div>
	</div>
	<!-- <footer>
		<h3 style="color: black">Copyright Landry Productions LLC</h3>
	</footer> -->
</body>
</html>
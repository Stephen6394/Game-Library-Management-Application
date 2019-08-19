<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Setting</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="resources/css/style.css" rel="stylesheet">
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
	<!-- 	<header>
		<h1>Case 
		Study Application</h1>
	</header> -->
	<!-- 	<nav>
		<a href="Home"><button>Home</button></a>
		<a href="ViewLibrary"><button>My Library</button></a>
		<a href="AccountSettings"><button>Account Settings</button></a>
		<a href="LogoutUser"><button>Logout</button></a>
	</nav> -->

	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-container">
					<h1 class="text-center">Account Settings</h1>
					<form action="UpdateEmail" method="post">
						${emailMessageResult}
						<div class="form-group">
							<label for="newEmail">Update Email:</label> 
							<input type="email" class="form-control" name="newEmail" placeholder="example@example.com">
						</div>
						<button type="submit" class="btn btn-success btn-block">Update Email</button>
						<br>
					</form>
					<form action="UpdatePassword" method="post">
						${passwordMessageResult}
						<div class="form-group">
							<label for="newPasssword">Update password:</label> 
							<input type="password" class="form-control" name="newPassword" placeholder="Enter password">
						</div>
						<div class="form-group">
							<label for="verPasssword">Verify password:</label> 
							<input type="password" class="form-control" name="verPassword" placeholder="Verify password">
						</div>
						<button type="submit" class="btn btn-success btn-block">Update Password</button>
						<br>
					</form>
					<form action="DeleteAccountWarning" method="post">
						<div class="form-group">
							<button type="submit" class="btn btn-danger btn-block">Delete Account</button>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
		</div>
	</div>
<%-- 	<div>
		Welcome! User: ${suser.getName()}<br>
		<br> <a href="ViewLibrary"><button>My Library</button></a><br>
		<br> <a href="AccountSettings"><button>Account
				Settings</button></a><br>
		<br> <a href="LogoutUser"><button>Logout</button></a>


	</div> --%>

	<%-- <div>
		${emailMessageResult}
		<form action="UpdateEmail" method="post">
			Update Email: <input required="required" type="email" name="newEmail" placeholder="example@example.com"><br>
			<button type="submit">Update</button>
			<br>
			<br>
		</form>

		${passwordMessageResult}
		<form action="UpdatePassword" method="post">
			Update Password: <input type="password" name="newPassword" placeholder="Enter password"><br> 
			Verify Password: <input type="password" name="verPassword" placeholder="Verify password"><br>
			<button type="submit">Update</button>
			<br>
			<br>
		</form>
		<a href="DeleteAccountWarning"><button>Delete Account</button></a>
	</div>
	<footer>
		<h3>Copyright Landry Productions LLC</h3>
	</footer> --%>
</body>
</html>
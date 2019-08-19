<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account Wrning</title>
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
	<div class="container-fluid darkerbg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-container">
					<h1 class="text-center">Delete Account</h1>
					<div class="form-group ">
						<h3 class="text-center text-danger font-weight-bold">WARNING: YOU ARE ABOUT TO DELETE YOUR ACCOUNT</h3>
						<h3 class="text-center text-danger font-weight-bold">THIS ACTION IS IRREVERSIBLE</h3>
						<h5 class="text-center text-danger font-weight-bold">Would you like to continue?</h5>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-12">
								<form action="AccountSettings" method="post">
									<button type="submit" class="btn btn-success btn-block">No. Keep my account</button>
								</form>
							</div>
							<div class="col-md-4 col-sm-4 col-xs-12"></div>
							<div class="col-md-4 col-sm-4 col-xs-12">
								<form action="DeleteUser" method="post">
									<button type="submit" class="btn btn-danger btn-block">Yes. Delete my account</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
		</div>
	</div>
	<h1>WARNING: YOU ARE ABOUT TO DELETE YOUR ACCOUNT</h1>
	<h1>THIS ACTION IS NOT REVERSIBLE</h1>
	
	<h3>Would you like to continue?</h3>
	${messageResult}
	<a href="DeleteUser"><button>Yes. Delete my account</button></a>	<a href="AccountSettings"><button>No. Keep my account</button></a>
</body>
</html>
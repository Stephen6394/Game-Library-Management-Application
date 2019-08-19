<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-container">
					<h1 class="text-center">Game Catalog</h1><br>
					<c:forEach var="game" items="${gameCatalog}">
						<h4 class="text-center">${game.getName()}</h4>
						<div class="form-group">
							<h6>Platform:</h6> ${game.getPlatform()}
						</div>
						<div class="form-group">
							<h6>Value:</h6>$${game.getPrice()}
						</div>
						<div class="form-group">
							<h6>Rating:</h6>${game.getRating()}
						</div>
						<form action="${pageContext.request.contextPath}/AddGameFromCatalog/${game.getName()}" method="post">
							<div class="form-group">
								<button type="submit" class="btn btn-success btn-sm">Add to Library</button>
							</div>
						</form>
						<hr>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
		</div>
	</div>

	<div>
		Welcome! User: ${suser.getName()}<br><br> 
		<a href="AddToLibrary"><button>Add to Library</button></a><br><br>
		${messageResult}
	</div>
	<c:forEach var="game" items="${gameCatalog}">
		<p>${game.getName()}</p>
		<p>${game.getPlatform()}</p>
		<p>$${game.getPrice()}</p>
		<p>${game.getRating()}</p>
		<a href="${pageContext.request.contextPath}/AddGameFromCatalog/${game.getName()}">Add to Library</a> 
		<hr>
	</c:forEach>

	<footer>
		<h3>Copyright Landry Productions LLC</h3>
	</footer>
</body>
</html>
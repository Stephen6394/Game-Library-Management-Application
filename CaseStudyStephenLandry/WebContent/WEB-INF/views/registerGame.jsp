<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <script>
	var gameList = ${gameArchive};
	<c:forEach var="game" items="${gameArchive}">
  		gameList[]=${game.getName()};
    </c:forEach>
</script> -->
<title>Add To Library</title>
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
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<form class="form-container" action="AddGameToUser" method="post">
					<div class="text-center">
						<h1>Game Registration Form</h1>
						${messageResult}
					</div>
					<div class="form-group">
						<label for="name">Title:</label> <input type="text"
							class="form-control" name="name" placeholder="Enter Title Here">
					</div>
					<div class="form-group">
						<label for="platform">Platform:</label> <select
							style="color: black" class="form-control" name="platform">
							<option style="color: black" value="Playstation">PlayStation</option>
							<option style="color: black" value="Playstation2">PlayStation
								2</option>
							<option style="color: black" value="Playstation3">PlayStation
								3</option>
							<option style="color: black" value="Playstation4">PlayStation
								4</option>
							<option style="color: black" value="NES">Nintendo
								Entertainment System</option>
							<option style="color: black" value="SNES">Super Nintendo
								Entertainment System</option>
							<option style="color: black" value="N64">Nintendo 64</option>
							<option style="color: black" value="GameCube">Nintendo
								Gamecube</option>
							<option style="color: black" value="Wii">Nintendo Wii</option>
							<option style="color: black" value="WiiU">Nintendo WiiU</option>
							<option style="color: black" value="Switch">Nintendo
								Switch</option>
							<option style="color: black" value="Xbox">Xbox</option>
							<option style="color: black" value="Xbox">Xbox</option>
							<option style="color: black" value="XboxOne">XboxOne</option>
						</select>
					</div>
					<button type="submit" class="btn btn-success btn-block">Add To Library</button>
				</form>
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
			</div>
		</div>
	</div>
<!-- 	<footer>
		<h3 style="color: black"yy>Copyright Landry Productions LLC</h3>
	</footer> -->
</body>
</html>
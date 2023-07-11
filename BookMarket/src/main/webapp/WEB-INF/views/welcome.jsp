<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navar-brand" href="./home">Home</a>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1 class="dsiplay-3">${greeting }</h1>
		</div>
	</div>
	<div class="container">
		<div class="text-centet">
			<h3>${strapline }</h3>
		</div>
	</div>
	<footer class ="container">
		<hr>
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>
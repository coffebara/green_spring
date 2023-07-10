<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<meta charset="UTF-8">
<title>도서 목록</title>
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
			<h1 class="dsiplay-3">도서 목록</h1>
		</div>
	</div>
	<div class="container">
		<div class="text-centet">
			<c:forEach items="${bookList }" var="book">
				<div class="col-md-4">
					<h3>${book.name }</h3>
					<p>${book.author }</p>
					<br> ${book.publisher} | ${book.releaseDate }
					<p align=left>${fn:substring(book.description, 0, 100)}...</p>
					<p>${book.unitPrice }원</p>
				</div>
				<hr>
			</c:forEach>
		</div>
	</div>
	<footer class="container">
		<hr>
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>
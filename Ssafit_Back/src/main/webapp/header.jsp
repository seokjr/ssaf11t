<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav>
			<!-- 로그인 안 되어있을 때  -->
			<c:if test="${empty sessionScope.loginUser}">
				<div class="header-left">
					<a href="login.jsp">SSAFIT</a>
				</div>
				<div class="header-right">
					<ul class="nav justify-content-end">
						<li class="nav-item"><a class="nav-link active"
							href="login.jsp">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="signUp.jsp">회원가입</a>
						</li>
					</ul>
				</div>
			</c:if>
			<c:if test="${not empty sessionScope.loginUser}">
				<div class="header-left">
					<a href="index.jsp">SSAFIT</a>
				</div>
				<div class="header-right">
					<ul class="nav justify-content-end">
						<!-- 여기는 뭔가 장치가 더 필요하다. -->
						<li class="nav-item"><a class="nav-link active"
							href="user?action=logout">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link"
							href="infoChange.jsp">마이페이지</a></li>
					</ul>
				</div>
			</c:if>
		</nav>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
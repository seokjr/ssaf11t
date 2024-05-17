<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport
	content="width=device-width, initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="css/header.css">
<title>SSAFIT - 로그인</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="header.jsp"%>
	<!-- <div class="page-hdr"> 로그인</div> -->
	<main>
		<div class="page-body">
			<div class="scetion pad-24 mtop-30">
				<form method="post" action="user">
					<input type="hidden" name="action" value="login">
					<input type="text" name="id" id="id" placeholder="Email address"> 
					<input type="password" name="pw" id="pw" class="mtop-10" placeholder="PassWord">
					<input type="submit" class="mtop-20" value="로그인하기">
						<!-- onclick="login()" -->
				</form>
			</div>

			<div class="section pad-24 mtop-30">
				<div class="desc mtop-20 mbot-20">
					아이디가 없으세요?<br> 간단한 가입 절차를 통해 SSAFIT의 회원이 되실 수 있습니다.
				</div>
				<a href="signUp.jsp"><div class="button">회원가입하기</div></a>
			</div>
		</div>
	</main>
	<div class="page-footer">CopyRight : 석재륜 하상진</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>

<script src="js/jquery-3.7.0.min.js"></script>
<script src="js/core.js"></script>
<script>
	function login() {
		var id = $("#id").val().trim();
		if (id == "") {
			alert("아이디를 입력해 주세요.");
			$("#id").focus();
			return;
		}
		var ps = $("#pw").val().trim();
		if (ps == "") {
			alert("패스워드를 입력해 주세요.");
			$("#pw").focus();
			return;
		}

		if (id == "test" && ps == "1234") {
			alert("로그인에 성공하였습니다.");
			window.location.href = "index.jsp";
		} else {
			alert("아이디 또는 비밀번호가 틀렸습니다.");
			return;
		}

		// }

		// var url= "../jsp/login.jsp?id=" + id + "&pw=" + ps;
		// AJAX.call(url,null,function(data){
		// 	var code = data.trim();
		// 	if(code =="NE"){
		// 		alert("아이디가 존재하지 않습니다.");
		// 	}else if(code=="PE"){
		// 		alert("패스워드가 일치하지 않습니다.");
		// 	}else{
		// 		window.location.href="main.html";
		// 	}
		// });

	}
</script>
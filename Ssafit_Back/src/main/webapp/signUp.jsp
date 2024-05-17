<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport
	content="width=device-width, initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="css/header.css">
<title>SSAFIT - 회원가입</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>
	<%@include file="header.jsp"%>

	<main>
		<div class="page-body">
			<div class="section pad-24 mtop-30">
				<form method="post" action="user">
					<input type="hidden" name="action" value="regist">
					<input id="id" type="text" placeholder="아이디 (이메일주소)" name="id"> <input
						id="pw" type="password" class="mtop-10" placeholder="패스워드" name="pw">
					<input id="pw2" type="password" class="mtop-10"
						placeholder="패스워드(확인)" name="pw2"> <input id="name" type="text"
						class="mtop-10" placeholder="이름(닉네임)" name="name"> <input
						type="submit" class="mtop-20" value="회원가입하기" onclick="signup()">
						<!--   -->
				</form>
			</div>
		</div>
	</main>
	<div class="page-footer">CopyRight : 석재륜 하상진</div>
</body>
</html>

<script src="js/jquery-3.7.0.min.js"></script>
<script src="js/core.js"></script>
<script>
	function signup() {
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

		var ps2 = $("#pw2").val().trim();
		if (ps != ps2) {
			alert("입력된 두 개의 패스워드가 일치하지 않습니다.");
			$("#pw2").focus();
			return;
		}
		var name = $("#name").val().trim();
		if (name == "") {
			alert("이름을 입력해 주세요.");
			$("#name").focus();
			return;
		}

		var url = "../login.html";
		alert("회원가입이 완료되었습니다.");
		/* window.location.href = "login.jsp"; */
	}
</script>
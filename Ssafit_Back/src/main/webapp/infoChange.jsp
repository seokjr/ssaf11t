<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport content="width=device-width, initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="css/header.css">
<title>SSAFIT - 정보수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="a1">
        <a href="infoChange.html"><h2>정보 수정</h2></a>
        <a style="text-decoration: none;" href="jjim.jsp"><h2>찜 목록</h2></a>
        <a style="text-decoration: none;" href="comment.jsp"><h2>내가 쓴 댓글</h2></a>
        <a style="text-decoration: none;" href="follow.jsp"><h2>팔로우한 유저</h2></a>
    </div>
	<!-- <div class="page-hdr"> 로그인</div> -->
	<main>
	<div class="page-body">
		<div class="scetion pad-24 mtop-30">변경 할 아이디<br>
			 <input type="text" id ="id" placeholder="Email address">
			변경 할 비밀번호<input type="password" id="pw" class="mtop-10" placeholder="PassWord">

			<input type="submit" class="mtop-20" value="정보 변경하기" onclick="login1()">
		</div>
		
	</div>
</main>
	<div class="page-footer">CopyRight : 석재륜 하상진</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

<script src="js/jquery-3.7.0.min.js"></script>
<script src="js/core.js"></script>
<script>
function login1(){
	var id= $("#id").val().trim();
	if(id==""){
		alert("변경할 아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}
	var ps = $("#pw").val().trim();
	if(ps==""){
		alert("변경할 패스워드를 입력해 주세요.");
		$("#pw").focus();
		return;
	}

        alert("변경에 성공하였습니다.");
        window.location.href="login.jsp";

       
       
        
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport content="width=device-width, initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/table.css">
<title>SSAFIT - 내가 쓴 댓글</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
   <%@include file="header.jsp"%>

    <div class="a1">
        <a style="text-decoration: none;" href="infoChange.jsp"><h2>정보 수정</h2></a>
        <a style="text-decoration: none;" href="jjim.jsp"><h2>찜 목록</h2></a>
        <a href="comment.jsp"><h2>내가 쓴 댓글</h2></a>
        <a style="text-decoration: none;" href="follow.jsp"><h2>팔로우한 유저</h2></a>
    </div>
	<!-- <div class="page-hdr"> 로그인</div> -->
	<main>
        <table>
            <thead>
              <tr>
                <th style="text-align: center;">영상 제목</th>
                <th style="text-align: center;">댓글</th>
                <th style="text-align: center;">날짜</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td><a href="https://www.youtube.com/embed/gMaB-fG4u4g">전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]</a></td>
                <td><b>1빠!!!!! 추천점</b></td>
                <td>2024-02-23 05:53</td>
              </tr>
              <tr>
                <td><a href="https://www.youtube.com/embed/u5OgcZdNbMo">저는 하체 식주의자 입니다</a></td>
                <td><b>김종국 폼 미쳤다~~</b></td>
                <td>2024-02-22 07:55</td>
              </tr>
              <tr>
                <td><a href="https://www.youtube.com/embed/u5OgcZdNbMo">저는 하체 식주의자 입니다</a></td>
                <td><b>[대댓글] 김종국 욕하지마라</b></td>
                <td>2024-02-22 07:50</td>
              </tr>
              <tr>
                <td><a href="https://www.youtube.com/embed/7TLk7pscICk">(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)</a></td>
                <td><b>2주 동안 따라했더니 식욕이 더욱 좋아져 5키로가 더 쪘습니다.</b></td>
                <td>2024-02-21 12:50</td>
              </tr>
              <tr>
                <td><a href="https://www.youtube.com/embed/PjGcOP-TQPE">11자복근 복부 최고의 운동 [복근 핵매운맛]</a></td>
                <td><b>부부가 같이 운동하는 모습이 너무 보기 좋습니다 ^^</b></td>
                <td>2024-02-15 15:33</td>
              </tr>
              <tr>
                <td><a href="https://www.youtube.com/embed/tzN6ypk6Sps">하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]</a></td>
                <td><b>땅크부부 보는 낙에 삽니다</b></td>
                <td>2024-02-14 16:22</td>
              </tr>
              <tr>
                <td><a href="https://www.youtube.com/embed/tzN6ypk6Sps">하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]</a></td>
                <td><b>[대댓글] 너나 잘해</b></td>
                <td>2024-02-14 16:22</td>
              </tr>
              <tr>
                <td><a href="https://www.youtube.com/embed/54tTYO-vU2E">상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]</a></td>
                <td><b>엄 준 식</b></td>
                <td>2015-05-25 18:44</td>
              </tr>
            </tbody>
          </table>  
</main>
	<div class="page-footer">CopyRight : 이서영 하상진</div>

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

    }
</script>
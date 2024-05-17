<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/reviews.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="header.jsp"%>

	<main>
		<section>
			<h2>댓글 등록</h2>
			<form action="board" method="post">
				<input type="hidden" name="action" value="write">
				<div class="form-group">
					<label for="exampleFormControlInput1">제목</label> <input type="text"
						class="form-control" name="title" id="exampleFormControlInput1">
				</div>
				<div class="form-group">
					<label for="exampleFormControlInput1">글쓴이</label> <input
						type="text" class="form-control" name="writer"
						id="exampleFormControlInput1">
				</div>
				<div class="form-group">
					<label for="exampleFormControlSelect2">리뷰할 영상</label> <select
						multiple class="form-control" id="exampleFormControlSelect2"
						name="videotitle">
						<option>전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]</option>
						<option>하루 15분! 전신 칼로리 불태우는 다이어트 운동</option>
						<option>상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]</option>
						<option>상체비만 다이어트 최고의 운동 [상체 핵매운맛]</option>
						<option>하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]</option>
						<option>저는 하체 식주의자 입니다</option>
						<option>11자복근 복부 최고의 운동 [복근 핵매운맛]</option>
						<option>(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)</option>
					</select>
				</div>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">글 내용</label>
					<textarea class="form-control" name="content"
						id="exampleFormControlTextarea1" rows="13"></textarea>
				</div>
				<div class="d-grid gap-2">
					<button class="btn btn-primary" type="submit">글쓰기</button>
				</div>
			</form>
		</section>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
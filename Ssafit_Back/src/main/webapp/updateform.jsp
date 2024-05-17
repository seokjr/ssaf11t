<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 수정</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main>
		<h2>댓글 수정</h2>
		<form action="board" method="post">
			<input type="hidden" name="action" value="update"> <input
				type="hidden" name="id" value="${board.id }">
			<div class="form-group">
				<label for="exampleFormControlInput1">글 제목 : </label> <input
					type="text" class="form-control" name="title"
					id="exampleFormControlInput1" value="${board.title }">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">글쓴이</label> <input type="text"
					class="form-control" name="writer" id="exampleFormControlInput1"
					value="${board.writer }" readonly>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">글 내용</label>
				<textarea class="form-control" name="content"
					id="exampleFormControlTextarea1" rows="13">${board.content }</textarea>
			</div>
			<div class="d-grid gap-2">
				<button class="btn btn-primary" type="submit">수정</button>
			</div>

		</form>
	</main>

</body>
</html>
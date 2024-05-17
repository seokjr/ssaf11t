<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%@include file="header.jsp"%>

	<main>
		<div>
			<form action="#" method="get" id="searchForm" class="input-group">
				<div class="input-group-btn search-panel">
					<select name="search_param" id="search_ param"
						class="btn btn-default dropdown-toggle" data-bs-toggle="dropdown">
						<option value="all">All</option>
						<option value="username">유저이름</option>
						<option value="type">운동부위</option>
					</select>
				</div>
				<input type="text" class="form-control" name="x"
					placeholder="Search term...">
				<button type="button" class="btn btn-outline-primary"
					data-mdb-ripple-init>검색</button>
			</form>
			<!-- end form -->
		</div>
		<hr />
		<div class="video trend">
			<p>새로운 영상</p>
			<div class="cards">
				<div class="row text-center" id="videoArea"></div>
				 <input type="hidden" id="videoidInput" name="videoid">
			</div>
			<hr />
			<div class="video types">
				<p>
					<select class="bootstrap-select" onchange="changePart()"
						id="mySelect">
						<option value="전신" selected="selected" class="partOption">전신</option>
						<option value="상체" class="partOption">상체</option>
						<option value="하체" class="partOption">하체</option>
						<option value="복부" class="partOption">복부</option>
					</select>
				</p>
				<div class="cards">
					<div class="row text-center" id="videoArea2"></div>
				</div>

			</div>



			<!-- Modal -->
			<div class="modal fade" id="exampleModalCenter" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalCenterTitle"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-body">
							<iframe src="" id="myIFrame" width="500px" height="380px"></iframe>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary">좋아요</button>
							<button type="button" class="btn btn-primary"
								onclick="location.href='board?action=reviews'">댓글</button>
						</div>
					</div>
				</div>
			</div>

		</div>
		</div>

	</main>
	<div class="page-footer">CopyRight : 석재륜 하상진</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="js/main.js"></script>
</body>
</html>
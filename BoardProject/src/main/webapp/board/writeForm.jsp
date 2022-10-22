<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<style>
* {
	box-sizing: border-box;
}

div {
	border: 1px solid black;
}

.header {
	text-align: center;
}

#inputTitle {
	width: 300px;
}

.container {
	margin: auto;
	width: 500px;
}

.btns {
	overflow: hidden;
}

.btns button {
	float: right;
}
</style>
</head>
<body>
	<form action="/writeForm.board" id="frm">
		<div class="container">
			<div class="header">자유게시판 글 작성하기</div>
			<div>
				<input placeholder="글 제목 입력하세요" id="inputTitle" name="inputTitle">
			</div>
			<div>
				<textarea rows="10" cols="67" id="inputText" name="inputText"></textarea>
			</div>
			<div class="btns">
				<button type="button" id="toBoardList">목록으로</button>
				<button id="writeComplete">작성완료</button>
				<script>
					$("#toBoardList").on("click",function(){
						location.href="/board/boardList.jsp";
					})
				</script>
			</div>
		</div>
	</form>
</body>
</html>
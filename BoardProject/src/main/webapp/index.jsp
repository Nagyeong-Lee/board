<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
<style>
* {
	box-sizing: border-box;
	text-align: center;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 16px;
}

.header {
	font-size: 18px;
	font-weight: bold;
}

.container {
	width: 350px;
	margin: auto;
}

.container>div {
	border: 1px solid black;
}

.id {
	width: 100%;
	overflow: hidden;
}

#textId {
	float: left;
	width: 35%;
}

#inputId {
	float: left;
	width: 65%;
}

#inputId>input {
	width: 100%;
}

.pw {
	width: 100%;
	overflow: hidden;
}

#textPw {
	float: left;
	width: 35%;
}

#inputPw {
	float: left;
	width: 65%;
}

#inputPw>input {
	width: 100%;
}

.btn {
	width: 100%;
}
</style>
</head>

<body>
	<c:choose>
		<c:when test="${loginID != null}">
					${loginID}님 안녕하세요.<br>
			<button type="button" id="logout">로그아웃</button>
			<button type="button" id="delAccount">탈퇴하기</button>
			<button type="button" id="myPage">마이페이지</button>
			<button type="button" id="toBoard">게시판으로</button>
			<script>
				$("#toBoard").on("click", function() {
					location.href = "/list.board?cpage=1";
				})
				$("#logout").on("click", function() {
					location.href = "/logout.mem";
				})
				$("#delAccount").on("click", function() {
					let result = confirm("탈퇴하시겠습니까?");
					if (result) {
						location.href = "/deleteAccount.mem";
					}
				});
				$("#myPage").on("click", function() {
					location.href = "/myPage.mem";
				});
			</script>
		</c:when>
		<c:otherwise>
			<form action="/login.mem">
				<div class=container>
					<div class="header">Login Box</div>
					<div class="input">
						<div class="id">
							<div id="textId">아이디 :</div>
							<div id="inputId">
								<input type="text" placeholder="input your id" id="loginID"
									name="loginID">
							</div>
						</div>
						<div class="pw">
							<div id="textPw">패스워드 :</div>
							<div id="inputPw">
								<input type="password" placeholder="input your pw" id="loginPW"
									name="loginPW">
							</div>
						</div>
					</div>
					<div class="btn">
						<button>로그인</button>
						<a href="/member/signUp.jsp"><button type="button">회원가입</button></a>
						<br>
						<!-- "member/signUp.jsp" : 상대경로   -->
						<!-- "/member/signUp.jsp" : 절대경로(맨앞에 /있으면) 절대경로 추천-->
						<!-- localhost,/ : webapp -->
						<!-- ../ : 현재 폴더 기준으로 하나 나가서 있는 것 -->
						<input type="checkbox">ID기억하기
					</div>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</body>

</html>
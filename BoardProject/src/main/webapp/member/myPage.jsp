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
<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.11"></script>
<style>
* {
	box-sizing: border-box;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 16px;
}

.header {
	font-size: 18px;
	font-weight: bold;
	text-align: center;
}

.container {
	width: 500px;
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
	width: 30%;
	float: left;
}

#inputId {
	width: 70%;
	float: left;
}

#inputId>input {
	margin-left: 20px;
}

.pw {
	width: 100%;
	overflow: hidden;
}

#textPw {
	width: 30%;
	float: left;
}

#inputPw {
	width: 70%;
	float: left;
}

#inputPw>input {
	margin-left: 20px;
}

.checkPw {
	width: 100%;
	overflow: hidden;
}

#checkPw {
	width: 30%;
	float: left;
}

#inputCheckPw {
	width: 70%;
	float: left;
}

#inputCheckPw>input {
	margin-left: 20px;
}

.name {
	width: 100%;
	overflow: hidden;
}

#textName {
	width: 30%;
	float: left;
}

#inputName {
	width: 70%;
	float: left;
}

#inputName>input {
	margin-left: 20px;
}

.phone {
	width: 100%;
	overflow: hidden;
}

#textPhone {
	width: 30%;
	float: left;
}

#inputPhone {
	width: 70%;
	float: left;
}

#inputPhone>input {
	margin-left: 20px;
}

.email {
	width: 100%;
	overflow: hidden;
}

#textEmail {
	width: 30%;
	float: left;
}

#inputEmail {
	width: 70%;
	float: left;
}

#inputEmail>input {
	margin-left: 20px;
}

.zipCode {
	width: 100%;
	overflow: hidden;
}

#textZipCode {
	width: 30%;
	float: left;
}

#inputZipCode {
	width: 70%;
	float: left;
}

#inputZipCode>input {
	margin-left: 20px;
}

.address1 {
	width: 100%;
	overflow: hidden;
}

#textAddress1 {
	width: 30%;
	float: left;
}

#inputAddress1 {
	width: 70%;
	float: left;
}

#inputAddress1>input {
	margin-left: 20px;
}

.address2 {
	width: 100%;
	overflow: hidden;
}

#textAddress2 {
	width: 30%;
	float: left;
}

#inputAddress2 {
	width: 70%;
	float: left;
}

#inputAddress2>input {
	margin-left: 20px;
}

#textId, #textPw, #checkPw, #textName, #textPhone, #textEmail,
	#textZipCode, #textAddress1, #textAddress2 {
	text-align: right;
	line-height: 25px;
}

.btn {
	text-align: center;
}
</style>
</head>
<body>
	<script>
		$(function() {
			$("#updateInfoBtn").on("click", function() {
				$("input").removeAttr("readonly");
				$("#updateInfoBtn,#toHomeBtn").css("display", "none");

				let btnModify = $("<button>");
				btnModify.text("수정완료");

				let btnCancel = $("<button>");
				btnCancel.attr("type", "button");
				btnCancel.text("취소");
				btnCancel.on("click", function() {
					location.reload();//f5
				})

				$("#btns").append(btnModify);
				$("#btns").append(btnCancel);
			})
		})
	</script>
	<form action="/update.mem" method="post">
		<div class=container>
			<div class="header">마이페이지</div>

			<div class="id">
				<div id="textId">아이디</div>
				<div id="inputId">
					<input type="text" id="id" name="id" disabled="disabled"
						value="${list[0].id}"><span id=idEmo></span>
				</div>
			</div>
			<div class="pw">
				<div id="textPw">패스워드</div>
				<div id="inputPw">
					<input type="text" id="password" name="password"
						readonly="readonly" value="${list[0].pw}"> <span
						id="comment"></span>
				</div>
			</div>
			<div class="name">
				<div id="textName">이름</div>
				<div id="inputName">
					<input type="text" id="name" name=name readonly="readonly"
						value="${list[0].name}"><span id="comment2"></span>
				</div>
			</div>
			<div class="phone">
				<div id="textPhone">전화번호</div>
				<div id="inputPhone">
					<input type="text" id="phone" name="phone" readonly="readonly"
						value="${list[0].phone}"><span id="comment3"></span>
				</div>
			</div>
			<div class="email">
				<div id="textEmail">이메일</div>
				<div id="inputEmail">
					<input type="text" id="email" name="email" readonly="readonly"
						value="${list[0].email}"> <span id="comment4"></span>
				</div>
			</div>
			<div class="zipCode">
				<div id="textZipCode">우편번호</div>
				<div id="inputZipCode">
					<input type="text" id="zonecode" name="zonecode"
						readonly="readonly" value="${list[0].zipcode}">
				</div>
			</div>
			<div class="address1">
				<div id="textAddress1">주소1</div>
				<div id="inputAddress1">
					<input type="text" id="roadAddress" name="roadAddress"
						readonly="readonly" value="${list[0].address1}">
				</div>
			</div>
			<div class="address2">
				<div id="textAddress2">주소2</div>
				<div id="inputAddress2">
					<input type="text" id="jibunAddress" name="jibunAddress"
						readonly="readonly" value="${list[0].address2}">
				</div>
			</div>
			<div id="btns">
				<button id="updateInfoBtn" type="button">정보 수정</button>
				<button id="toHomeBtn" type="button">홈으로</button>
				<script>
					$("#toHomeBtn").on("click",function(){
						location.href="/index.jsp";
					})
				</script>
			</div>
		</div>
	</form>
</body>
</html>
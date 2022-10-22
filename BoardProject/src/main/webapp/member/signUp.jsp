<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.11"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
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
	<form action="/signup.mem" id="frm" method="post">
		<div class=container>
			<div class="header">회원 가입 정보 입력</div>

			<div class="id">
				<div id="textId">아이디</div>
				<div id="inputId">
					<input type="text" id="id" name="id" placeholder="첫글자 대문자,6~10글자">
					<span id=idEmo></span> <input type="button" id="duplCheck"
						value="중복확인">
				</div>
			</div>
			<div class="pw">
				<div id="textPw">패스워드</div>
				<div id="inputPw">
					<input type="text" id="password" name="password"
						placeholder="@$%!포함가능,8~12글자"> <span id="comment"></span>
				</div>
			</div>
			<div class="checkPw">
				<div id="checkPw">패스워드 확인</div>
				<div id="inputCheckPw">
					<input type="text" id="checkPassword" name="checkPassword">
					<span id=comment1></span>
				</div>
			</div>
			<div class="name">
				<div id="textName">이름</div>
				<div id="inputName">
					<input type="text" id="name" name=name placeholder="3~5글자">
					<span id="comment2"></span>
				</div>
			</div>
			<div class="phone">
				<div id="textPhone">전화번호</div>
				<div id="inputPhone">
					<input type="text" id="phone" name="phone" placeholder=".-또는 생략 가능">
					<span id="comment3"></span>
				</div>
			</div>
			<div class="email">
				<div id="textEmail">이메일</div>
				<div id="inputEmail">
					<input type="text" id="email" name="email"> <span
						id="comment4"></span>
				</div>
			</div>
			<div class="zipCode">
				<div id="textZipCode">우편번호</div>
				<div id="inputZipCode">
					<input type="text" id="zonecode" name="zonecode"> <input
						type="button" id=findAddressBtn value="찾기">
				</div>
			</div>
			<div class="address1">
				<div id="textAddress1">주소1</div>
				<div id="inputAddress1">
					<input type="text" id="roadAddress" name="roadAddress">
				</div>
			</div>
			<div class="address2">
				<div id="textAddress2">주소2</div>
				<div id="inputAddress2">
					<input type="text" id="jibunAddress" name="jibunAddress">
				</div>
			</div>
			<div class="btn">
				<button id="signup">회원가입</button>
				<button type="button" id="reset">다시입력</button>
			</div>
		</div>
	</form>

	<script>
		//id 중복체크
		document.getElementById("duplCheck").onclick = function() { //서블릿으로
			let id = document.getElementById("id").value; // 서블릿으로 값 전달
			window.open("/duplCheck.mem?id=" + id, "", "width=400,height=300"); //팝업 띄우기 window.open("서블릿","이름(안붙여도됨)","옵션");
		};
	</script>

	<script>
		//유효성 검사
		let result1 = true;
		let regexID = /^[A-Z][a-zA-Z0-9!@#$%^~&]{5,9}$/;
		document.getElementById("id").onkeyup = function() {
			let id = document.getElementById("id");
			if (regexID.test(id.value)) {
				document.getElementById("idEmo").innerHTML = "O";
				document.getElementById("idEmo").style.color = "green";
				result1 = true;
			} else {
				document.getElementById("idEmo").innerHTML = "X";
				document.getElementById("idEmo").style.color = "red";
				result1 = false;
			}
		}

		let result2 = true;
		let regexPW = /^[a-zA-Z0-9@$%!]{8,12}$/;
		let comment = document.getElementById("comment");
		document.getElementById("password").onkeyup = function() {
			let password = document.getElementById("password");
			if (regexPW.test(password.value)) {
				comment.innerHTML = "유효한 비밀번호 형식"
				comment.style.color = "green";
				result2 = true;
			} else {
				comment.innerHTML = "유효하지않은 비밀번호 형식"
				comment.style.color = "red";
				result2 = false;
			}
		}

		//pw 확인 유효성
		let result3 = true;
		let comment1 = document.getElementById("comment1");
		document.getElementById("checkPassword").onkeyup = function() {
			let checkPassword = document.getElementById("checkPassword");
			if (checkPassword.value == password.value) {
				comment1.innerHTML = "비밀번호 일치";
				comment1.style.color = "green";
				result3 = true;
			} else {
				comment1.innerHTML = "비밀번호 불일치";
				comment1.style.color = "red";
				result3 = false;
			}
		}

		//이름 유효성
		let result4 = true;
		let comment2 = document.getElementById("comment2");
		let regexNAME = /^[가-힣]{2,5}$/;
		document.getElementById("name").onkeyup = function() {
			let name = document.getElementById("name");
			if (!(regexNAME.test(name.value))) {
				comment2.innerHTML = "잘못된 이름 형식.";
				comment2.style.color = "red";
				result4 = false;
			} else {
				comment2.innerHTML = "올바른 이름 형식.";
				comment2.style.color = "green";
				result4 = true;
			}
		}

		// 전화번호 유효성
		let result5 = true;
		let comment3 = document.getElementById("comment3");
		let regexPHONE = /^\d{3}[-.\s]?\d{4}[-.\s]?\d{4}$/;
		document.getElementById("phone").onkeyup = function() {
			let phone = document.getElementById("phone");
			if (regexPHONE.test(phone.value)) {
				comment3.innerHTML = "올바른 전화번호 형식"
				comment3.style.color = "green";
				result5 = true;
			} else {
				comment3.innerHTML = "잘못된 전화번호 형식";
				comment3.style.color = "red";
				result5 = false;
			}
		}

		//이메일 유효성
		let result6 = true;
		let regexEMAIL = /^.+\@.+\.com$/;
		let comment4 = document.getElementById("comment4");
		document.getElementById("email").onkeyup = function() {
			let email = document.getElementById("email");
			if (regexEMAIL.test(email.value)) {
				comment4.innerHTML = "올바른 이메일 형식"
				document.getElementById("comment4").style.color = "green";
				result6 = true;
			} else {
				comment4.innerHTML = "잘못된 이메일 형식";
				document.getElementById("comment4").style.color = "red";
				result6 = false;
			}
		}

		//아이디 중복확인이 제대로 되었는가 readonly
		$("#id").on("input", function() {
			idCheck = false;
			//window.idCheck와 같음.전역변수
			//let은 지역변수 설정
			console.log(idCheck);
		});

		document.getElementById("frm").onsubmit = function() {
			//아이디에 빈값 넣을때
			if ($("#id").val() == "") {
				alert("아이디를 먼저 입력해주세요.");
			} else if (!idCheck) {
				alert("아이디 중복체크를 먼저 수행해주세요.");
			} else if (result1 == false) {
				alert("잘못된 아이디 형식입니다.");
				document.getElementById("idEmo").innerHTML = "";
				document.getElementById("id").value = "";
			}
			if (result2 == false) {
				alert("잘못된 비밀번호 형식입니다.");
				document.getElementById("comment").innerHTML = "";
				document.getElementById("password").value = "";
			}
			if (result3 == false)//패스워드가 일치하는가
			{
				alert("비밀번호가 일치하지 않습니다.");
				document.getElementById("comment1").innerHTML = "";
				document.getElementById("checkPassword").value = "";
			}
			if (result4 == false) {
				alert("잘못된 이름 형식입니다.");
				document.getElementById("comment2").innerHTML = "";
				document.getElementById("name").value = "";
			}
			if (result5 == false) {
				alert("잘못된 전화번호 형식입니다.");
				document.getElementById("comment3").innerHTML = "";
				document.getElementById("phone").value = "";
			}
			if (result6 == false) {
				alert("잘못된 이메일 형식입니다.");
				document.getElementById("comment4").innerHTML = "";
				document.getElementById("email").value = "";
			}
			if ((password.value == "") || (checkPassword.value == "")
					|| (name.value == "") || (phone.value == "")
					|| (email.value == "")) {
				alert("필수 항목을 입력해주세요");
			} else {
				return true;
			}
			return false;
		}
	</script>

	<script>
		//주소 찾기
		document.getElementById("findAddressBtn").onclick = function() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							var roadAddr = data.roadAddress; // 도로명 주소 변수
							var roadAddr = data.roadAddress;
							var roadAddr = data.roadAddress;
							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById("zonecode").value = data.zonecode;
							document.getElementById("roadAddress").value = roadAddr;
							document.getElementById("jibunAddress").value = data.jibunAddress;

						}
					}).open();
		}

		//다시입력
		document.getElementById("reset").onclick = function() {
			document.getElementById("id").value = "";
			document.getElementById("password").value = "";
			document.getElementById("checkPassword").value = "";
			document.getElementById("name").value = "";
			document.getElementById("zonecode").value = "";
			document.getElementById("phone").value = "";
			document.getElementById("email").value = "";
			document.getElementById("roadAddress").value = "";
			document.getElementById("jibunAddress").value = "";

			document.getElementById("idEmo").innerHTML = "";
			document.getElementById("comment").innerHTML = "";
			document.getElementById("comment1").innerHTML = "";
			document.getElementById("comment2").innerHTML = "";
			document.getElementById("comment3").innerHTML = "";
			document.getElementById("comment4").innerHTML = "";
		};
	</script>
</body>

</html>
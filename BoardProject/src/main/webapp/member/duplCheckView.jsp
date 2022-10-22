<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.11"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<style>
table {
	width: 100%;
	height: 90vh;
	/*    브라우저의 90퍼센트 */
}

table>* {
	text-align: center;
}

.result {
	height: 70%
}
</style>
</head>
<body>

	<table border="1">
		<tr>
			<th>조회 결과
		</tr>

		<c:choose>
			<c:when test="${result}">
				<tr>
					<td class="result">이미 사용중인 ID입니다</td>
				</tr>
				<tr>
					<td><button id="close">닫기</button> <script>
                  document.getElementById("close").onclick = function() {
                     opener.document.getElementById("id").value = "";
                     window.close();
                  }
               </script>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td class="result">"${id}"<br>은(는)사용 가능한 ID입니다
					</td>
				</tr>
				<tr>
					<td><button id="use">사용</button>
						<button id="cancle">취소</button></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>

	<script>
		document.getElementById("use").onclick = function() {
			opener.idCheck=true;
			//opener객체에 변수를 줌
			//idCheck는 변수임 (js는 변수를 알아서 만들어줌)
			window.close();
		}
		document.getElementById("cancle").onclick = function() {
			opener.document.getElementById("id").value = "";
			//팝업창이 아니라 회원가입정보입력 창의 id값이 지워짐
			window.close();
		}
	</script>
</body>
</html>
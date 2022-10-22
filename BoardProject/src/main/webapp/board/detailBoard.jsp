<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.11"></script>
<style>
* {
	box-sizing: border-box;
	text-align: center;
}

div {
	border: 1px solid black;
}

.container {
	margin: auto;
	width: 700px;
}

.title {
	width: 500px;
}

.textInfo {
	width: 500px;
	overflow: hidden;
}

.textInfo div {
	float: left;
}

#writer {
	width: 30%;
}

#write_date {
	width: 60%;
}

#view_count {
	width: 10%;
}

.content {
	width: 100%;
}
</style>
<script>
	$(function() {
		$("#updateBtn").on("click", function() {

			$("#inputTitle,#inputText").attr("contenteditable", "true");
			/*contenteditalble","true : div로 수정하는데 submit이안됨*/
			/*submit 안되니까 input hidden에 넣고 그걸 submit */
			$("#delBtn,#updateBtn,#toBoardList").css("display", "none");

			let btnModify = $("<button>");
			btnModify.attr("type", "button");
			btnModify.text("수정완료");
			btnModify.addClass("btn");
			btnModify.css("margin-right", "5px");

			let btnCancel = $("<button>");
			btnCancel.attr("type", "button");
			btnCancel.text("취소");
			btnCancel.addClass("btn");
			btnCancel.on("click", function() {
				location.reload();
			});
			btnModify.on("click", function() {

				$("#input_contents").val($("#inputText").text());
				$("#input_title").val($("#inputTitle").text());
				$("#detailFrm").submit();
			});

			$("#btns").append(btnModify);
			$("#btns").append(btnCancel);

		});
	});
</script>
</head>

<body>
	<form action="/updatePost.board" method="post" id="detailFrm">
		<input id="input_title" name="inputTitle"> <input
			id="input_contents" name="inputText">
		<div class="container">
			<c:choose>
				<c:when test="${not empty list}">
					<c:forEach var="i" items="${list}">
						<div class="title" id="inputTitle">${i.title}</div>
						<div class="textInfo">
							<div id="writer">${i.writer}</div>
							<div id="write_date">${i.write_date}</div>
							<div id="view_count">${i.view_count}</div>
						</div>
						<div class="content">
							<div id="inputText">${i.contents}</div>
						</div>
						<div class="footer" id="btns">
							<c:choose>
								<c:when test="${loginID == list[0].writer}">
									<a href="/deletePost.board?seq=${i.seq}"><button
											type="button" id="delBtn">삭제하기</button></a>
									<input type="text" name="seq" value="${i.seq}" readonly
										style="display: none;">
									<button type="button" id="updateBtn">수정하기</button>
								</c:when>
							</c:choose>
							<button type="button" id="back">목록으로</button>
						</div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</form>

	<script>
		$("#back").on("click", function() {
			history.back(); /*뒤로가기 효과 (보고 있는 페이지)*/
		})
	</script>
</body>

</html>
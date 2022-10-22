<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	text-align: center;
}

div {
	border: 1px solid black;
}

.container {
	margin: auto;
	width: 700px;
}

.header, .contents_container {
	width: 100%;
	height: 30px;
	overflow: hidden;
}

.header div, .contents_container div {
	float: left;
	height: 100%;
}

#write_num, #contents_write_num {
	width: 10%;
}

#title, #contents_title {
	width: 40%;
}

#writer, #contents_writer {
	width: 10%;
}

#date, #contents_date {
	width: 30%;
}

#search, #contents_search {
	width: 10%;
}

.contents {
	width: 100%;
	float: left;
}

#btn {
	overflow: hidden;
}

#writeBtn {
	float: right;
}
</style>
</head>

<body>
	<div class="container">
		<div>자유게시판</div>
		<div class="header">
			<div id="write_num"></div>
			<div id="title">제목</div>
			<div id="writer">작성자</div>
			<div id="date">날짜</div>
			<div id="search">조회</div>
		</div>
		<div class="contents">
			<c:choose>
				<c:when test="${not empty list}">
					<c:forEach var="i" items="${list}">
						<div class="contents_container">
							<div id="contents_write_num">${i.seq}</a>
							</div>
							<div id="contents_title">
								<a href="/detail.board?seq=${i.seq}">${i.title }</a>
							</div>
							<div id="contents_writer">${i.writer}</div>
							<div id="contents_date">${i.write_date}</div>
							<div id="contents_search">${i.view_count}</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					출력할 내용이 없습니다.
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			${navi}
		</div>
		<div id="btn">
			<button type="button" id="writeBtn">작성하기</button>
		</div>
	</div>

	<script>
		$("#writeBtn").on("click", function() {
			location.href = "/board/writeForm.jsp";
		})
	</script>
</body>

</html>
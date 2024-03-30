<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>insertBook.jsp</title>
<style>
	.top{padding:20px; text-align:center; background:#333; color:#fff;}
	nav{background:#000; padding:10px;}
	nav a{display:inline-block; margin:0 20px; color:#fff;}
	.container{background:#eee;}
	label{display:inline-block; width:100px;}
</style>
</head>
<body>
<div class="top">
	<h3>도서대여관리</h3>
</div>
<nav>
	<a href="/mb/insertBookForm">도서등록</a>
	<a href="/mb/getBook">도서목록조회/수정</a>
	<a href="/mb/getRent">대여현황조회</a>
	<a href="/mb">홈으로</a>
</nav>
<body>
<h3>도서 등록</h3>
<form name="frm" method="post" action="insertBook">
	<div>
		<label>도서번호</label>
		<input type="text" name="bookNo" value="${bookNo}">
	</div>
	<div>
		<label>도서명</label>
		<input type="text" name="bookName">
	</div>
	<div>
		<label>도서표지</label>
		<input type="text" name="bookCoverimg">
	</div>	
	<div>
		<label>출판일자</label>
		<input type="text" name="bookDate">
	</div>	
	<div>
		<label>금액</label>
		<input type="text" name="bookPrice">
	</div>	
	<div>
		<label>출판사</label>
		<input type="text" name="bookPublisher">
	</div>	
	<div>
		<label>도서소개</label>
		<textarea name="bookInfo"></textarea>
	</div>	
	<div>	
		<input id="saveBtn" type="button" value="등록"/>
		<input id="infos" type="button" value="조회"/>
	</div>
</form>
<script>
	saveBtn.addEventListener("click", () => {
		if(frm.bookName.value == "") {
			alert("도서명이 입력되지 않았습니다.")
			return;
		}
		
		if(frm.bookPublisher.value == "") {
			alert("출판사가 입력되지 않았습니다.")
			return;
		}
		alert("도서등록이 완료되었습니다.");
		frm.submit(); // 폼 제출
	})
</script>
</body>
</html>
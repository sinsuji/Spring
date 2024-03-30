<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<style>
	.top{padding:20px; text-align:center; background:#333; color:#fff;}
	nav{background:#000; padding:10px;}
	nav a{display:inline-block; margin:0 20px; color:#fff;}
	.container{background:#eee;}
	.bookimg{width:50px;}
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
	<h3>도서 조회/수정</h3>
	<table border="1">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="book">
				<tr>
					<td>${book.bookNo}</td>
					<td>${book.bookName}</td>
					<td><img src="${pageContext.request.contextPath}/resources/images/${book.bookCoverimg}" alt="" class="bookimg"></td>
					<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd"/></td>
					<td><fmt:formatNumber value="${book.bookPrice}" type="currency" /></td>
					<td>${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
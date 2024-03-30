<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<style>
	.top{padding:20px; text-align:center; background:#333; color:#fff;}
	nav{background:#000; padding:10px;}
	nav a{display:inline-block; margin:0 20px; color:#fff;}
	.container{background:#eee;}
</style>
</head>
<body>
<div class="top">
	<h3>도서별 대여관리</h3>
</div>
<nav>
	<a href="/mb/insertBookForm">도서등록</a>
	<a href="/mb/getBook">도서목록조회/수정</a>
	<a href="/mb/getRent">대여현황조회</a>
	<a href="/mb">홈으로</a>
</nav>
	<h3>도서별 대여매출현황</h3>
	<table border="1">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.no}</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
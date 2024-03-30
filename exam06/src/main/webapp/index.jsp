<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.top{padding:20px; text-align:center; background:#333; color:#fff;}
	nav{background:#000; padding:10px;}
	nav a{display:inline-block; margin:0 20px; color:#fff;}
	.container{background:#eee;}
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
<div class="container">
	<p>도서대여관리 프로그램</p>
	<p>국제 대여점의 도서등록, 대여정보 데이터베이스를 구축하고, 도서 DVD 대여관리를 위한 프로그램이다.<br> 프로그램 작성 순서</p>
	<ul>
		<li>1. 도서정보 테이블을 생성한다.</li>
		<li>2. 대여정보 테이블을 생성한다.</li>
		<li>3. 도서정보, 대여정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</li>
		<li>4. 도서정보 입력 화면프로그램을 작성한다.</li>
		<li>5. 도서정보 조회 프로그램을 작성한다.</li>
		<li>6. 대여 정보 조회 프로그램을 작성한다.</li>
	</ul>
</div>
</body>
</html>
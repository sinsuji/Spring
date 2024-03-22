<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>부서목록</h3>
	<c:forEach items="${departmentsList}" var="depart">
		<div style="border: 1px solid blue;">
			<span>${depart.departmentId}</span>
			<span>${depart.departmentName}</span>
			<span>${depart.managerId}</span>
			<span>${depart.locationId}</span>
		</div>
	</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.firstRow{color:yellowgreen;}
	.oddRow{color:cyan;}
	.backColor{background:#eee;}
</style>
<script th:inline="javascript">
	let emplist = [[${empList}]]
	
	function gopage(p){
		frmSearch.page.value = p;
		frmSearch.submit();	
		// location.href ='empList?page=' + p // 페이지만 넘겨줄 때
	}
	
	function init(){
		frmSearch.departmentId.value=""
		frmSearch.firstName.value=""
		frmSearch.managerId.value=""
	}
	
	function move(empId){
		frmSearch.action = '/info/' + empId
		frmSearch.submit();
	}
</script>
</head>
<body>
	<div layout:fragment="content">
		사원수<span th:text="${#lists.size(empList)}">10</span>명 <!--/* list의 전체갯수를 알려줌 */-->
		회사명<span th:utext="${companyName}">허허</span> <!--/* utext -> innerHtml, text -> innerText */-->
		
		<!-- 검색 폼 시작 -->
		<form name="frmSearch" th:object="${empVO}" action="empList">
			<input type="hidden" name="page">
			<select name="departmentId" th:value="*{departmentId}">
				<option value="">선택</option>
				<option value="40" th:selected="*{departmentId}=='40'">Human Resources</option>
				<option value="10" th:selected="*{departmentId}=='10'">Administration</option>
				<option value="20" th:selected="*{departmentId}=='20'">Marketing</option>
				<option value="50" th:selected="*{departmentId}=='50'">Shipping</option>
				<option value="60" th:selected="*{departmentId}=='60'">IT</option>
				<option value="80" th:selected="*{departmentId}=='80'">Sales</option>
				<option value="190" th:selected="*{departmentId}=='190'">Contracting</option>
			</select>
			firstName<input name="firstName" th:value="*{firstName}"> <!--/* object에서 필드를 꺼내쓸때 *를 사용 */-->
			managerId<input name="managerId" th:value="*{managerId}">
			<button type="button" onclick="gopage(1)">검색</button>
			<button type="button" onclick="init()">초기화</button>
		</form>
		<!-- 검색 폼 끝 -->
		
		<table>
			<tr>
				<th>No</th>
				<th>employee_id</th>
				<th>name</th>
				<th>hire_date</th>
				<th>salary</th>
				<th>보너스</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach items="${}" var="emp" varStatus="stat"></c:forEach>
			<tr>
				<td class="backColor ${stat.first ? 'firstRow' : stat.odd ? 'oddRow' : _ }">${stat.count}</td>
				<td>${emp.employeeId}</td>
				<td th:text="${emp.firstName} + ' ' + ${emp.lastName}">길동</td>
				<!--/* <td th:text="|${emp.firstName} ${emp.lastName}|">길동</td>
				<td> [[ ${emp.firstName} ]] [[ ${emp.lastName} ]] </td> */-->
				<td>${emp.hireDate, 'yyyy-MM-dd'}</td>
				<td>${emp.salary}</td>
				<td>
					<button th:if="${emp.salary < 10000}">신청</button>
					<button th:unless="${emp.salary < 10000}">미신청</button>
				</td>
				<td> <!--/* localhost:8081/update/100 */--> <!--/* @PathVariable  */-->
					<!--  <a th:href="@{/update/{id}(id=${emp.employeeId})}">수정</a> -->
					<button type="button" th:onclick="move([[${emp.employeeId}]])">조회</button>
					<!--/* localhost:8081/delete?employeeId=100&name=xxx */--> <!--/* queryString, 파라미터 값이 같아야함 */-->
					<a href="/delete?employeeId=${emp.employeeId}">삭제</a>
				</td>
			</tr>
		</table>
		
		<!-- 페이징 시작 -->
		<nav aria-label="...">
		  <ul class="pagination">
		    <li class="page-item" th:if="${paging.startPage} > 1 ">
		        <a class="page-link" th:href="|javascript:gopage(${paging.startPage-1})|">Previous</a></li>
	
		    <li th:each="num : *{#numbers.sequence(paging.startPage, paging.endPage)}" 
		        class="page-item" 
		        th:addclass="${num} == ${paging.page} ? active">
		        <a class="page-link" th:href="|javascript:gopage(${num})|"  th:text="${num}">2</a></li>
		    
		    <li class="page-item" th:classappend="${paging.endPage} <= ${paging.lastPage} ? disabled">
		        <a class="page-link" th:href="|javascript:gopage(${paging.endPage+1})|">Next</a></li>
		  </ul>
		</nav>
		<!-- 페이징 종료 -->
		
		<!--/* <div class="footer" th:insert="~{footer}"> */--> <!--/* {폴더명/footer}라면 footer.html을 가져옴 */-->
		<div class="footer" th:replace="~{footer :: copy}"> <!--/* {폴더명/footer}라면 footer.html을 가져옴 */-->
			여기에 삽입
		</div>
	</div>	
	
</body>
</html>
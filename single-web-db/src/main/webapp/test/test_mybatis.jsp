<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Webapp MyBatis</h1>
	<a href="testMyBatis.action">
		<button>Test</button>
	</a><br>
<%-- 	<h3>${obj}</h3> --%>
	<c:if test="${list.size()>0}">
		<table border="5">
			<tr>
				<td>Name</td>
			</tr>
			<c:forEach var="v" items="${list}">
				<tr>
					<td>${v}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
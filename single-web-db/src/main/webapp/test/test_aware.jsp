<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test Struts 2 Aware</h1>
	<a href="testReq.action">Req</a><br>
	<hr>
	<form action="testReq.action" method="get">
		Name: <input type="text" name="name" value="${name}"><br>
		<input type="submit" value="Req">
	</form>
</body>
</html>
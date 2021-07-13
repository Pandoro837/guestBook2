<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String no = (String)request.getAttribute("no");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "/guestbook2/gbc" method = "get">
		<input type = "hidden" name = "action" value ="delete">
		<input type = "hidden" name = "no" value ="<%=no%>">
		비밀번호 <input type = "password" name = "pw" value="">
		<button type = "submit">확인</button>
	</form>
</body>
</html>
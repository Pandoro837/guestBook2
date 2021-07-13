<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.GuestBookVo" %>

<%
	List<GuestBookVo> guestBookList = (List<GuestBookVo>)request.getAttribute("guestBookList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		margin-bottom: 15px;
	}
	textarea.content {
		resize: none;
		width: 490px;
		height: 100px;
	}
	button.sign {
		width: 75px;
	}
	
	.tr{
		text-align: center;
	}
	
</style>
</head>
<body>
	<form action = "/guestbook2/gbc" method ="post">
		<input type = "hidden" name = "action" value = "insert">
		<table border="1">
		<colgroup>
                <col width="75px">
                <col width="125px">
                <col width="75px">
                <col width="125px">
        </colgroup>
			<tr>
				<td class = tr>이름</td>
				<td><input type = "text" name = "name" value = ""></td>
				<td class = tr>비밀번호</td>
				<td><input type = "password" name = "pw" value = ""></td>
			</tr>
			<tr>
				<td colspan = "4"><textarea class = content name = "content"></textarea></td>
			</tr>
			<tr>
				<td><button class = sign type = "submit">확인</button></td>
			</tr>
		</table>
	</form>
	<%
		for(GuestBookVo guestBookInfo : guestBookList ) {
	%>
		<table border = "1">
			<tr>
				<td style="width: 35px"><%=guestBookInfo.getNo() %></td>
				<td style="width: 100px"><%=guestBookInfo.getName() %></td>
				<td style="width: 280px"><%=guestBookInfo.getDate() %></td>
				<td style="width: 65px; text-align: center;">
						<form action = "/guestbook2/gbc" method = "get">
							<input type = "hidden" name = "action" value = "deleteForm">
							<input type = "hidden" name = "no" value = "<%=guestBookInfo.getNo() %>">
							<button type = "submit">
								삭제
							</button> 
						</form>
				</td>
			</tr>
			<tr>
				<td colspan = "4"><%=guestBookInfo.getContent() %></td>
			</tr>
		</table>
	<%
		}
	%>
</body>
</html>
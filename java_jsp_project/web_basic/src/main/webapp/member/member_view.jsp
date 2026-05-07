<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String id=request.getParameter("t_id");
	MemberDao dao= new MemberDao();
	MemberDto dto = dao.getMemberView(id);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 회원상세 조회</title>
</head>
<body>
	<h2>황희원 회원관리</h2>
	<table width="500" border="1">
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tr>
			<th>ID</th>
			<td><%=dto.getId() %></td>
		</tr>
		<tr>
			<th>성명</th>
			<td><%=dto.getName() %></td>
		</tr>
		<tr>
			<th>지역</th>
			<td><%
				if(dto.getArea()!=null)	out.print(dto.getArea());
			%></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=dto.getAge() %> </td>
		</tr>
		<tr>
			<th colspan="2">
				<a href="member_list.jsp"> <input type="button" value="목록" > </a>
				&nbsp;
				<a href="member_update.jsp"> <input type="button" value="수정" > </a>
				&nbsp;
				<a href="member_delete.jsp"> <input type="button" value="삭제" > </a>
			</th>
		</tr>
	</table>
</body>
</html>
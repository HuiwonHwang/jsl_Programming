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
<script type="text/javascript">
	function goUpdateForm(){
		mem.method="post";
		mem.action="member_update.jsp";
		mem.submit();
	}
	function goDelete(){
		var tf = confirm("정말 삭제하시겠습니까?");
		if(tf){
			mem.method="post";
			mem.action="db_member_delete.jsp";
			mem.submit();
		}
		
		
	}
</script>
</head>
<body>
	<form name="mem">
		<input type="hidden" name="t_id" value="<%=id%>">
	</form>
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
				<a href="member_update.jsp?t_id=<%=id%>"> <input type="button" value="수정get" > </a>
				<a href="javascript:goUpdateForm()"> <input type="button" value="수정post" > </a>
				&nbsp;
				<input type="button" onclick="goDelete();" value="삭제" > 
			</th>
		</tr>
	</table>
</body>
</html>
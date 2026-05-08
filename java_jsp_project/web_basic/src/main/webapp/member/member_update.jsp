<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("t_id");
	MemberDao dao= new MemberDao();
	MemberDto dto = dao.getMemberView(id);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 회원등록</title>
<script type="text/javascript">
	function goUpdate(){
		mem.method="post";
		mem.action="db_member_update.jsp";
		mem.submit();
	}
</script>
</head>
<body>
	<form action="" name = "mem">
		<input type="hidden" name="t_id" value="<%=id%>">
	<h2>황희원 회원관리</h2>
	<table width="500" border="1">
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tr>
			<th>ID</th>
			<td><%=dto.getId() %> </td>
		</tr>
		<tr>
			<th>성명</th>
			<td><input type="text" name="t_name" size="8" value="<%=dto.getName()%>"> </td>
		</tr>
		<tr>
			<th>지역</th>
			<td>
			<%
			if(dto.getArea()==null){
			%>	
				<select name="t_area">
				<option value="" selected>=없음=</option>
				<option value="서울">서울</option>
				<option value="대전">대전</option>
				<option value="대구">대구</option>
				<option value="부산">부산</option>
			</select>
				
			<%	
			} else{%>
			<select name="t_area">
				<option value="">=없음=</option>
				<option value="서울" <%if(dto.getArea().equals("서울"))out.print("selected"); %>>서울</option>
				<option value="대전" <%if(dto.getArea().equals("대전"))out.print("selected"); %>>대전</option>
				<option value="대구" <%if(dto.getArea().equals("대구"))out.print("selected"); %>>대구</option>
				<option value="부산" <%if(dto.getArea().equals("부산"))out.print("selected"); %>>부산</option>
			</select></td><%} %>
		</tr>
		<tr>
			<th>나이</th>
			<td><input name="t_age" type="text" size="3" value="<%=dto.getAge()%>"> </td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" onclick="goUpdate()" value="변경사항 저장" > 
				&nbsp;
				<a href="member_list.jsp"> <input type="button" value="목록" > </a>
			</th>
		</tr>
	</table>
</form>
</body>
</html>
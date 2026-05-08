<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDao dao = new MemberDao();
	ArrayList<MemberDto> dtos= dao.getMemberList();
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 회원관리</title>
<script type="text/javascript">
	function goView(id){
		mem.t_id.value=id;
		mem.method="post";
		mem.action="member_view.jsp";
		mem.submit();
		
	}
</script>
</head>
<body>
	<form action="" name = mem>
		<input type="hidden" name="t_id" >
	</form>
	<h2>황희원 회원관리</h2>
	<p>총 회원수: <%=dtos.size() %>명</p>
	<table width="500" border="1">
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tr>
			<th>ID</th>
			<th>성명</th>
		</tr>
<%
	for(MemberDto dto: dtos){
%>
		<tr>
			<td>
			<a href="member_view.jsp?t_id=<%=dto.getId()%>"><%=dto.getId()%></a>
			</td>
			<td><a href="javascript:goView(<%=dto.getId()%>)"> <%out.print(dto.getName()); %></a></td>
		</tr>
<%
	}
%>
		<tr>
			<th colspan="2">
				<a href="member_write.jsp"> <input type="button" value="회원등록" > </a>
			</th>
		</tr>
	</table>

</body>
</html>
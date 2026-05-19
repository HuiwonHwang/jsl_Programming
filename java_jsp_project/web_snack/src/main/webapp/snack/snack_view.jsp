<%@page import="java.util.ArrayList"%>
<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	SnackDao dao=new SnackDao();
	String pcode=request.getParameter("t_pcode");
	ArrayList<SnackDto> dtos = dao.getSearching("4", pcode);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 제품 관리</title>
<script type="text/javascript">
	function goUpdate(){
		sna.method="post";
		sna.action="snack_update.jsp";
		sna.submit();	
	}
	function goDelete(){
		sna.method="post";
		sna.action="db_snack_delete.jsp";
		sna.submit();
	}
</script>
</head>
<body>
<form action="" name="sna">
	<table >
	<tr>
	<th>코드번호</th>
	<td><%=dtos.get(0).getPcode() %></td>
	</tr>
	<tr>
	<th>제품명</th>
	<td><%=dtos.get(0).getPname() %></td>
	</tr>
	<tr>
	<th>제조사</th>
	<td><%out.print(dtos.get(0).getCompany_name()+"["+dtos.get(0).getCompany()+"]" );%></td>
	</tr>
	<tr>
	<th>가격</th>
	<td><%=dtos.get(0).getPrice() %></td>
	</tr>
	<tr>
	<th>제조날짜</th>
	<td><%=dtos.get(0).getMakedate() %></td>
	</tr>
	</table>
	<table>
		<tr><th>
		<input type="button" onclick="location.href='snack_list.jsp'" value="목록">
		<input type="button" onclick="goUpdate()" value="수정">
		<input type="button" onclick="goDelete()" value="삭제">
		</th></tr>
	</table>
	<input type="hidden" name="t_pcode" value="<%=dtos.get(0).getPcode() %>">
</form>
</body>
</html>
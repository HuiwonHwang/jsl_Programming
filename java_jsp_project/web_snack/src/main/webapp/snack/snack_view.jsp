<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	SnackDao dao=new SnackDao();
	String pcode=request.getParameter("t_pcode");
	SnackDto dto=null;
	if(pcode!=null){
		 dto = dao.getSearchingPcode(pcode);
		
	}
	DecimalFormat df = new DecimalFormat("###,###");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 제품 관리</title>
<link href="../css/layout.css" rel="stylesheet">
<script type="text/javascript">
	function goUpdate(){
		sna.method="post";
		sna.action="snack_update.jsp";
		sna.submit();	
	}
	function goDelete(){
		var tf=confirm("정말 삭제하시겠습니까?");
		if(tf){
			sna.method="post";
			sna.action="db_snack_delete.jsp";
			sna.submit();	
		}
		
	}
</script>
</head>
<body>
<h3>황희원 제품상세정보</h3>
<%if(dto==null){%>
<h3>잘못된 접근입니다.</h3>
<table><tr><th><input type="button" onclick="location.href='snack_list.jsp'" value="되돌아가기">
</th></tr></table>
<%}else{%>
<form action="" name="sna">
	
	<table class="tablelist">
	<col width="20%">
	<col width="*">
	<tr>
	<th>코드번호</th>
	<td><%=dto.getPcode() %></td>
	</tr>
	<tr>
	<th>제품명</th>
	<td><%=dto.getPname() %></td>
	</tr>
	<tr>
	<th>제조사</th>
	<td><%out.print(dto.getCompany_name()+"["+dto.getCompany()+"]" );%></td>
	</tr>
	<tr>
	<th>가격</th>
	<td> <%String price=df.format(dto.getPrice());out.print(price);    %></td>
	</tr>
	<tr>
	<th>제조날짜</th>
	<td><%=dto.getMakedate() %></td>
	</tr>
	</table>
	<table>
		<tr><th>
		<input type="button" onclick="location.href='snack_list.jsp'" value="목록">
		<input type="button" onclick="goUpdate()" value="수정">
		<input type="button" onclick="goDelete()" value="삭제">
		</th></tr>
	</table>
	<input type="hidden" name="t_pcode" value="<%=dto.getPcode() %>">
</form>
<%}%>
</body>
</html>
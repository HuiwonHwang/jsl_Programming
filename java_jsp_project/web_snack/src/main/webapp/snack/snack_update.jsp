<%@page import="dao.SnackDao"%>
<%@page import="dto.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pcode=request.getParameter("t_pcode");
	SnackDao dao=new SnackDao();
	SnackDto dto = dao.getSearchingPcode(pcode);
	ArrayList<CompanyDto> comDtos=dao.getCompanyList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goSave(){
		sna.method="post";
		sna.action="db_snack_update.jsp";
		sna.submit();
	}
</script>
</head>
<body>
<form name="sna">
<input type="text" value="<%=dto.getMakedate()%>">
	<table>
	<tr><th>제품코드</th>
	<td><%=dto.getPcode() %></td></tr>
	<tr><th>제품명</th>
	<td><input type="text" name="t_pname" value="<%=dto.getPname() %>"></td></tr>
	<tr><th>제조사</th>
	<td><%for(CompanyDto comdto:comDtos){ %><input type="radio" name="t_pcompany" value="<%=comdto.getCompany_code() %>" <%if(dto.getCompany().equals(comdto.getCompany_code())) out.print("checked"); %>> <%=comdto.getCompany_name() %><%} %></td></tr>
	<tr><th>가격</th>
	<td><input type="text" name="t_price" value="<%=dto.getPrice() %>"></td></tr>
	<tr><th>제조날짜</th>
	<td><input type="text" name="t_pdate" value="<%=dto.getMakedate()%>"></td></tr>
	</table>
	<table><tr><td>
	<input type="button" onclick="goSave()" value="저장">
	  </td></tr></table>
	  <input type="hidden" name="t_pcode" value="<%=dto.getPcode() %>">
</form>
</body>
</html>
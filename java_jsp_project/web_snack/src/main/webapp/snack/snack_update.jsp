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
<link href="../css/layout.css" rel="stylesheet">
<script type="text/javascript">
	function goUpdate(){
		if(isEmpty(sna.t_pname,"제품명 입력!")) return;
		if(isEmpty(sna.t_price,"제품가격 입력!")) return;
		if(isEmpty(sna.t_pdate,"제조일자 입력!")) return;
		sna.method="post";
		sna.action="db_snack_update.jsp";
		sna.submit();
	}
</script>
</head>
<body>
<form name="sna">
	<h3>황희원 제품수정</h3>
	<table>
	<tr><th>제품코드</th>
	<td><%=dto.getPcode() %></td></tr>
	<tr><th>제품명</th>
	<td><input type="text" name="t_pname" value="<%=dto.getPname() %>"></td></tr>
	<tr><th>제조사</th>
	<td><%for(CompanyDto comdto:comDtos){ %><input type="radio" name="t_pcompany" value="<%=comdto.getCompany_code() %>" <%if(dto.getCompany().equals(comdto.getCompany_code())) out.print("checked"); %>> <%=comdto.getCompany_name() %><%} %></td></tr>
	<tr><th>가격</th>
	<td><input type="text" name="t_price" value="<%=dto.getPrice() %>"></td></tr>
	<tr><th>제조일자</th>
	<td><input type="date" name="t_pdate" value="<%=dto.getMakedate()%>"></td></tr>
	</table>
	<table><tr><th>
	<input type="button" onclick="goUpdate()" value="저장">
	<input type="button" onclick="location.href='snack_list.jsp'" value="목록">
	  </th></tr></table>
	  <input type="hidden" name="t_pcode" value="<%=dto.getPcode() %>">
</form>
</body>
</html>
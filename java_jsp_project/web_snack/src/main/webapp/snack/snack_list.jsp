<%@page import="dto.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	SnackDao dao = new SnackDao();
	ArrayList<SnackDto> dtos = new ArrayList<>();
	ArrayList<CompanyDto> comDtos=dao.getCompanyList();	
	String select=request.getParameter("t_gubun");
	String searching=request.getParameter("t_searching");
	if(select==null){
		select="";searching="";
	}
	if(select.equals("")){
		dtos=dao.getSearching("2", searching);
	}else{
		dtos=dao.getSearchingCompany(select, searching);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 제품관리</title>
<link href="../css/layout.css" rel="stylesheet">
<script type="text/javascript">
	function goView(pcode){
		sna.t_pcode.value=pcode;
		sna.method="post";
		sna.action="snack_view.jsp"
		sna.submit();
	}
	function goSearch(){
		sna.method="post";
		sna.action="snack_list.jsp"
		sna.submit();
	}
</script>
</head>
<body>
<form name="sna">
	<h3 >황희원 제품관리</h3>
	<table>
	<tr><td class="tdright">제조사 <select name="t_gubun">
		<option value="">=전체=</option>
		<%for(CompanyDto dto:comDtos){ %>
		<option value="<%=dto.getCompany_code()%>"  <%if(select.equals(dto.getCompany_code())) out.print("selected"); %>><%=dto.getCompany_name() %></option>
		<%} %>
	</select>
	제품명 <input type="text" name="t_searching" value="<%=searching %>" > <input type="button" onclick="goSearch()" value="검 색">
	</td></tr>
	</table>
	
	<table  class="tablelist" >
	<col width="20%">
	<col width="*">
	<col width="20%">
	<tr><th>제품코드</th><th>제품명</th><th>제조사</th></tr>
	<%
	for(SnackDto dto: dtos){
%>
	<tr><td class="tdCenter"><a href="javascript:goView('<%=dto.getPcode()%>')" ><%=dto.getPcode() %></a></td><td><%=dto.getPname() %></td><td><%out.print(dto.getCompany_name()+"["+dto.getCompany()+"]" ); %></td></tr>
	<%} %>
	</table>
	<table >
	<tr><th><input type="button" onclick="location.href='snack_write.jsp'" value="등 록"> </th></tr>
	</table>
	<input type="hidden" name="t_pcode" value="">
</form>
</body>
</html>
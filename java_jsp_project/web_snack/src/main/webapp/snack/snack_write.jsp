<%@page import="dto.CompanyDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SnackDao dao=new SnackDao();
ArrayList<CompanyDto> comDtos=dao.getCompanyList();
String maxcode=dao.getMaxCode();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 제품등록</title>
<link href="../css/layout.css" rel="stylesheet">
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript">
function goSave(){
	//var check=isEmpty(sna.t_pcode,"제품코드 입력!");
	if(isEmpty(sna.t_pcode,"제품코드 입력!")) return;
	if(isEmpty(sna.t_pname,"제품명 입력!")) return;
	if(isEmpty(sna.t_pcompany,"제조사 입력!")) return;
	if(isEmpty(sna.t_price,"제품가격 입력!")) return;
	if(isEmpty(sna.t_pdate,"제조일자 입력!")) return;
	/*
	var pcode=sna.t_pcode.value;
	var name=sna.t_pname.value;
	var company=sna.t_pcompany.value;
	var price=sna.t_price.value;
	var date=sna.t_pdate.value;
	if(pcode==""){
		alert("제품코드 입력");
		snack.t_pcode.focus();
		return;
	}
	if(name==""){
		alert("제품명 입력");
		sna.t_pname.focus();
		return;
	}
	if(company==""){
		alert("제조자 입력");
		sna.t_pcompany.focus();
		return;
	}
	if(price==""){
		alert("가격 입력");
		sna.t_price.focus();
		return;
	}
	if(date==""){
		alert("제조일자 입력");
		sna.t_pdate.focus();
		return;
	}
	*/
	sna.method="post";
	sna.action="db_snack_write.jsp";
	sna.submit();
}


</script>
</head>
<body>
<form name="sna">
	<h3>황희원 제품등록</h3>
	<table class="tablelist tablelist_500">
	<tr><th>제품코드</th>
	<td><input type="text" name="t_pcode" class="inputTd" value="<%=maxcode%>"></td></tr>
	<tr><th>제품명</th>
	<td><input type="text" name="t_pname" ></td></tr>
	<tr><th>제조사</th>
	<td><%for(CompanyDto comdto:comDtos){ %><input type="radio" name="t_pcompany" value="<%=comdto.getCompany_code() %>"> <%=comdto.getCompany_name() %><%} %></td></tr>
	<tr><th>가격</th>
	<td><input type="text" name="t_price" ></td></tr>
	<tr><th>제조날짜</th>
	<td><input type="date" name="t_pdate" ></td></tr>
	</table>
	<table><tr><th>
	<input type="button" onclick="goSave()" value="저장">
	<input type="button" onclick="location.href='snack_list.jsp'" value="목록">
	  </th></tr></table>
</form>
</body>
</html>
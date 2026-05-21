<%@page import="java.util.ArrayList"%>
<%@page import="dto.CompanyDto"%>
<%@page import="dao.SnackDao"%>
<%@page import="dto.SnackDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pcode= request.getParameter("t_pcode");
	String pname= request.getParameter("t_pname");
	String company= request.getParameter("t_pcompany");
	String price= request.getParameter("t_price");
	String makedate= request.getParameter("t_pdate");
	SnackDao dao = new SnackDao();
	int result=dao.insert(pcode, pname, company,Integer.parseInt(price) , makedate);
	String msg="저장 실패";
	String url="snack_write.jsp";
	if(result==1){
		msg="저장 성공";
		url="snack_list.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
</head>
<body>

</body>
</html>
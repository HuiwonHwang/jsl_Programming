<%@page import="java.util.ArrayList"%>
<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	SnackDao dao=new SnackDao();
	String pcode=request.getParameter("t_pcode");
	String pname = request.getParameter("t_pname");
	String company=request.getParameter("t_pcompany");
	String price = request.getParameter("t_price");
	String makedate=request.getParameter("t_pdate");
	String url="snack_update.jsp";
	String msg="수정 실패";
	int result=dao.snackUpdate(pcode, pname, company,Integer.parseInt(price) , makedate);
	if(result==1){
		url="snack_list.jsp";
		msg="수정 성공";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="snack_list.jsp";
</script>
</head>
<body>

</body>
</html>
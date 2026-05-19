<%@page import="dto.SnackDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	SnackDao dao = new SnackDao();
	String pcode = request.getParameter("t_pcode");
	int result = dao.delete(pcode);
	String msg="저장 실패";
	String url="";
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
	location.href="snack_list.jsp";
</script>
</head>
<body>

</body>
</html>
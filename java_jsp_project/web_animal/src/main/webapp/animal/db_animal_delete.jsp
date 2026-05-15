<%@page import="dto.AnimalDto"%>
<%@page import="dao.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("t_id");
	AnimalDao dao = new AnimalDao();
	int result=dao.AnimalDelete(id);
	String msg="";
	String url="";
	if(result==1){
		msg="삭제 성공";
		url="animal_list.jsp";
	}else{
		msg="삭제 실패";
		url="animal_view.jsp";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("삭제 성공");
	location.href="animal_list.jsp"
</script>
</head>
<body>

</body>
</html>
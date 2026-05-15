<%@page import="dao.AnimalDao"%>
<%@page import="dto.AnimalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	AnimalDao dao =new AnimalDao();
	String id= request.getParameter("t_id");
	String name= request.getParameter("t_name");
	String gubun= request.getParameter("t_gubun");
	String weight= request.getParameter("t_weight");
	String msg="";
	String url="";
	int result= dao.AnimalUpadte(id, name.trim(), gubun, Integer.parseInt(weight.trim()));
	if(result==1){
		msg="수정 성공";
		url="animal_list.jsp";
	}else{
		msg="수정 실패";
		url="animal_update.jsp";
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 수정성공</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
</head>
<body>

</body>
</html>
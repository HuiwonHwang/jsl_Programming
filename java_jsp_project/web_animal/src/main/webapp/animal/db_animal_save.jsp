<%@page import="dto.AnimalDto"%>
<%@page import="dao.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	AnimalDao dao=new AnimalDao();
	String id= request.getParameter("t_id");
	String name= request.getParameter("t_name");
	String gubun= request.getParameter("t_gubun");
	String weight= request.getParameter("t_weight");
	String msg="";
	String url="";
	int result= dao.animalInsert(id, name, gubun,Integer.parseInt(weight));
	if(result==1){
		msg="저장 성공";
		url="animal_list.jsp";
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
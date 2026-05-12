<%@page import="dto.StudentDto"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	StudentDao dao = new StudentDao();
	String syear=request.getParameter("t_syear");
	String sclass=request.getParameter("t_sclass");
	String sno=request.getParameter("t_sno");
	String name=request.getParameter("t_name");
	String kor=request.getParameter("t_kor");
	String eng=request.getParameter("t_eng");
	String mat=request.getParameter("t_mat");
	StudentDto dto = new StudentDto(syear,sclass,sno,name,Integer.parseInt(kor),Integer.parseInt(eng),Integer.parseInt(mat));
	String msg ="";
	String url="";
	int result=dao.studentUpdate(dto);
	msg=result==1?"수정 성공":"수정 실패";
	url=result==1?"student_list.jsp":"student_update.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 회원관리</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
</head>
<body>

</body>
</html>
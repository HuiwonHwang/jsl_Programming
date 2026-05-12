<%@page import="dao.StudentDao"%>
<%@page import="dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String syear=request.getParameter("t_syear");
	String sclass=request.getParameter("t_sclass");
	String sno=request.getParameter("t_sno");
	String name=request.getParameter("t_name");
	String kor=request.getParameter("t_kor");
	String eng=request.getParameter("t_eng");
	String mat=request.getParameter("t_mat");
	StudentDto dto= new StudentDto(syear,sclass,sno,name,Integer.parseInt(kor),Integer.parseInt(eng),Integer.parseInt(mat));
	StudentDao dao=new StudentDao();
	int count=dao.checkStudent(syear, sclass, sno);
	int result=0;
	String msg="";
	String url="student_list.jsp";
	if(count==0){
		result=dao.studentSave(dto);
		msg=result==1? "저장성공":"등록실패";
		url=result==1?"student_list.jsp":"student_write.jsp";
	}else{
		 msg="중복된 학년,반,번호 입니다.";
		
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저장 성공</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
	
</script>
</head>
<body>

</body>
</html>
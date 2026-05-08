<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	MemberDao dao= new MemberDao();
	String id = request.getParameter("t_id");
	String name = request.getParameter("t_name");
	String area = request.getParameter("t_area");
	String age = request.getParameter("t_age");
	if(age.equals(""))age="0";
	MemberDto dto = new MemberDto(id,name,area,Integer.parseInt(age));
	int result = dao.memberUpdate(dto);
	//String msg = "수정완료";
	//if(result!=1)msg="수정실패";
	String msg = result == 1 ? "수정 성공":" 수정실패";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="member_list.jsp";
</script>
</head>
<body>

</body>
</html>
<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	String id=request.getParameter("t_id");
	String name=request.getParameter("t_name");
	String area=request.getParameter("t_area");
	String age=request.getParameter("t_age") ;
	if(age.equals(""))age="0";
	String url="member_list.jsp";
	MemberDto dto = new MemberDto(id,name,area,Integer.parseInt(age));
	int result=dao.memberSave(dto);
	String msg="저장 성공";
	if(result!=1){
		msg="저장실패";
		url= "member_write.jsp";
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
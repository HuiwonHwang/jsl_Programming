<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDao dao = new MemberDao();
	String id = request.getParameter("t_id");
	int result = dao.memberdelete(id);
	
	String msg = result==1? "삭제 성공":"삭제 실패";
	
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
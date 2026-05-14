<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDao dao = new MemberDao();
	String id = request.getParameter("t_id");
	int result=dao.checkId(id);
	if(result==1){
		out.print("사용불가");	
	}else {
		out.print("사용가능");
	}
	
	
%>

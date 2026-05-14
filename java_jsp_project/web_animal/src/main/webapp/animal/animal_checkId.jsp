<%@page import="dao.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id= request.getParameter("t_id");
	AnimalDao dao = new AnimalDao();
	int result=dao.checking(id);
	if(result==0)out.print("사용가능");
	else out.print("사용불가");
%>
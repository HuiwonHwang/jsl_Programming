<%@page import="dao.StudentDao"%>
<%@page import="dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");
String syear=request.getParameter("t_syear");
String sclass=request.getParameter("t_sclass");
String sno=request.getParameter("t_sno");

StudentDao dao=new StudentDao();
int count=dao.checkStudent(syear, sclass, sno);
if(count==1){out.print("중복");}else{out.print("사용가능");} %>
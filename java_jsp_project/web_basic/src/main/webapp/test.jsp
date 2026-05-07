<%@page import="dto.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
  		String name = "홍길동";
    	int age = 25;
    	MemberDto dto1 = new MemberDto("401","제갈길동","대전",25);
    	MemberDto dto2 = new MemberDto("501","박길동","서울",26);
    	ArrayList<MemberDto> dtos = new ArrayList<>();
    	dtos.add(dto1);
    	dtos.add(dto2);
    	for(MemberDto dto: dtos){
    		out.print(dto.getId()+"&nbsp");
    		out.print(dto.getName()+"&nbsp");
    		out.print(dto.getArea()+"&nbsp");
    		out.print(dto.getAge()+"<br>");
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>이름: <%=name %></p>
<p>나이: <%=age %></p>
</body>
</html>
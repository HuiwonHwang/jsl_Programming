<%@page import="java.util.ArrayList"%>
<%@page import="dto.StudentDto"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDao dao = new StudentDao();
	String syear=request.getParameter("t_syear");
	String sclass=request.getParameter("t_sclass");
	String sno=request.getParameter("t_sno");
	StudentDto dto= dao.getSearchingSpecific(syear, sclass, sno);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<table width="500" border="1">
		<col width="20%">
		<col width="20%">
		<col width="20%">
		<col width="20%">
		<col width="20%">
			<tr>
				<th>
					/
				</th>
				<th>
					학년
				</th>
				<th>
					반
				</th>
				<th>
					번호
				</th>
				<th>
					이름
				</th>
			</tr>
			
			<tr>
				<td>
					<%
						out.print("1");
				
					%>
				</td>
				<td><%=dto.getSyear() %></td>
				<td><%=dto.getSclass() %></td>
				<td><%=dto.getSno() %></td>
				<td><%=dto.getName() %></td>
			</tr>
			
			<tr>
				<th colspan="5">
					<input type="button" value="회원 목록">
					<input type="button" value="회원 수정">
					<input type="button" value="회원 삭제">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>
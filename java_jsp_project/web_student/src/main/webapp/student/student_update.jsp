<%@page import="dto.StudentDto"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDao dao=new StudentDao();
	String syear=request.getParameter("t_syear");
	String sclass=request.getParameter("t_sclass");
	String sno=request.getParameter("t_sno");
	StudentDto dto = dao.getSearchingSpecific(syear, sclass, sno);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 회원관리</title>
<script type="text/javascript">
	function goUpdate(){
		stu.method="post";
		stu.action="db_student_update.jsp";
		stu.submit();
	}
</script>
</head>
<body>
<form name="stu">
<table width="500" border="1">
		<col width="30%">
		<col width="*">
			<tr>
				<th>
					학년
				</th>
				<td>
					<%=dto.getSyear() %>
				</td>
			</tr>
			<tr>
				<th>
					반
				</th>
				<td>
					<%=dto.getSclass() %>
				</td>
			</tr>
			<tr>
				<th>
					번호
				</th>
				<td>
					<%=dto.getSno() %>
				</td>
			</tr>
			<tr>
				<th>
					이름
				</th>
				<td>
					<input type="text" name="t_name" size="5" value="<%=dto.getName() %>">
				</td>
			</tr>
			<tr>
				<th>
					국어점수
				</th>
				<td>
					<input type="text" name="t_kor" size="4" value="<%=dto.getKor() %>">
				</td>
			</tr>
			<tr>
				<th>
					영어점수
				</th>
				<td>
					<input type="text" name="t_eng" size="4" value="<%=dto.getEng() %>">
				</td>
			</tr>
			<tr>
				<th>
					수학점수
				</th>
				<td>
					<input type="text" name="t_mat" size="4" value="<%=dto.getMat() %>">
				</td>
			</tr>
		</table>
		<table width="500" border="0">
		<tr>
				<th >
					<input onclick="goUpdate();" type="button" value="회원 수정">
					<input onclick="location.href='student_list.jsp'" type="button" value="회원 목록">
				</th>
			</tr></table>
			<input type="hidden" name="t_syear" value="<%=dto.getSyear() %>">
			<input type="hidden" name="t_sclass" value="<%=dto.getSclass() %>">
			<input type="hidden" name="t_sno" value="<%=dto.getSno() %>">
	</form>
</body>
</html>
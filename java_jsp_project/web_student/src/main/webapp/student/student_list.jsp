<%@page import="java.util.ArrayList"%>
<%@page import="dto.StudentDto"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	
	StudentDao dao = new StudentDao();
	ArrayList<StudentDto> dtos = new ArrayList<>();
	
	String gubun=request.getParameter("t_year");
	String name = request.getParameter("t_name");
	if(gubun==null)gubun="";
	if(name==null)name="";
	if(gubun.equals("")){
		dtos=dao.getSearchingName(name);
	} else{
		dtos=dao.getSearchingGrade(Integer.parseInt(gubun),name);
	}
	
	int i=1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 성적관리</title>
<script type="text/javascript">
	function goSearch(){
		stu.method="post";
		stu.action="student_list.jsp";
		stu.submit();
	}
	
	function goView(syear,sclass,sno){
		stu.t_syear.value=syear;
		stu.t_sclass.value=sclass;
		stu.t_sno.value=sno;
		stu.method="post";
		stu.action="student_view.jsp";
		stu.submit();
	}
	
	function goWriteForm(){
		location.href="student_write.jsp";
	}
</script>
</head>
<body>
	<form action="" name="stu">
	<p>
		검색:
		<select name="t_year">
			<option value="">=전체=</option>
			<option <%if(gubun.equals("1")) out.print("selected"); %> value="1">1학년</option>
			<option <%if(gubun.equals("2")) out.print("selected"); %> value="2">2학년</option>
			<option <%if(gubun.equals("3")) out.print("selected"); %> value="3">3학년</option>
		</select>
		<input type="text" size="5" name="t_name" value="<%=name%>">
		<input type="button" onclick="goSearch()" value="검 색">
	</p>
	
	총원 <%=dtos.size() %>명
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
			<%
				for(StudentDto dto : dtos){
			%>
			<tr>
				<td>
					<%
						out.print(i++);
					%>
				</td>
				<td><%=dto.getSyear() %></td>
				<td><%=dto.getSclass() %></td>
				<td><%=dto.getSno() %></td>
				<td><a href="javascript:goView(<%=dto.getSyear() %>,<%=dto.getSclass() %>,<%=dto.getSno() %>)" name="t_sname" ><%=dto.getName() %></a> </td>
			</tr>
			<%
				}
				if(dtos.size()==0){
				
			%>
				<tr><th col span="5">데이터 없음</th></tr>	
				
			<%
				}
			%>
			<tr>
				<th colspan="5">
					<input type="button" onclick="goWriteForm()" value="회원 등록">
				</th>
			</tr>
		
		</table>
		<input type="hidden" name="t_syear">
		<input type="hidden" name="t_sclass">
		<input type="hidden" name="t_sno">
	</form>
</body>
</html>
<%@page import="dao.AnimalDao"%>
<%@page import="dto.AnimalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("t_id");
	AnimalDao dao = new AnimalDao();
	AnimalDto dto=dao.searchingByNumber(id);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 동물수정</title>
<script type="text/javascript">
	function goSave(){
		ani.method="post";
		ani.action="db_animal_update.jsp";
		ani.submit();
	}
</script>
</head>
<body>
<form name="ani">
<table width="500" border="1">
		<col width="20%"/>
		<col width="*"/>
		<tr>
			<th>
				번호
			</th>	
			<td>
				<%=dto.getNo() %>
			</td>
		</tr>
		<tr>
			<th>
				동물명
			</th>	
			<td>
				<input type="text" size="5" name="t_name" value="<%=dto.getName()%>">
			</td>
		</tr>
		<tr>
			<th>
				분류
			</th>	
			<td>
				<input type="radio" name="t_gubun" value="l" <%if(dto.getKind().equalsIgnoreCase("l"))out.print("checked"); %> >지상동물
				<input type="radio" name="t_gubun" value="o" <%if(dto.getKind().equalsIgnoreCase("o"))out.print("checked"); %> >해상동물
			</td>
		</tr>
		<tr>
			<th>
				무게
			</th>	
			<td>
				<input type="text" size="4" name="t_weight" value="<%=dto.getWeight()%>"> kg
			</td>
		</tr>
	</table>
	<table width="500" border="0">
		<tr><th><input type="button" onclick="goSave()" value="저장">&nbsp;<input type="button" onclick="location.href='animal_list.jsp'" value="목록">  
		</th></tr>
	</table>
	
	<input type="hidden" name="t_id" value="<%=dto.getNo()%>">
</form>
</body>
</html>
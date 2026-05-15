<%@page import="dao.AnimalDao"%>
<%@page import="dto.AnimalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AnimalDao dao=new AnimalDao();
	String id= request.getParameter("t_id");
	AnimalDto dto=dao.searchingByNumber(id);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 동물 상세정보</title>
<script type="text/javascript">
	function goUpdate(){
		ani.method="post";
		ani.action="animal_update.jsp";
		ani.submit();
	}
	function goDelete(){
		var tf=confirm("정말 삭제하시겠습니까?")
		if(tf){ani.method="post";
		ani.action="db_animal_delete.jsp";
		ani.submit();
		}
	}
</script>
</head>
<body>
<form name=ani>
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
				<%=dto.getName() %>
			</td>
		</tr>
		<tr>
			<th>
				분류
			</th>	
			<td>
				<%if(dto.getKind().equalsIgnoreCase("l"))out.print("지상동물");else out.print("해상동물"); %>
			</td>
		</tr>
		<tr>
			<th>
				무게
			</th>	
			<td>
				<%=dto.getWeight() %> kg
			</td>
		</tr>
	</table>
	<table width="500" border="0">
		<tr><th>
		<input type="button" onclick="location.href='animal_list.jsp'" value="목록"> &nbsp; 
		<input type="button" onclick="goUpdate()" value="수정"> &nbsp; 
		<input type="button" onclick="goDelete()" value="삭제"></th></tr>
	</table>
	<input type="hidden" name="t_id" value="<%=dto.getNo()%>">
</form>
</body>
</html>
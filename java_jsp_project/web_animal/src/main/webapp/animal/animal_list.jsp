<%@page import="java.util.ArrayList"%>
<%@page import="dto.AnimalDto"%>
<%@page import="dao.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	AnimalDao dao = new AnimalDao();
	ArrayList<AnimalDto> dtos= new ArrayList<>();
	String searching=request.getParameter("t_sgubun");
	String name = request.getParameter("t_sname");
	if(searching==null){
		searching="";
		name="";
	}
	if(searching.equals("")){
		dtos=dao.searchingByName(name);
	}else{
		dtos=dao.getAnimalListGubun(searching,name);
	}
	
	int i=1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 동물목록</title>
<script type="text/javascript">
	function goView(id){
		ani.t_id.value=id;
		ani.method="post"
		ani.action="animal_view.jsp";
		ani.submit();
	}
	function goSave(){
		location.href="animal_write.jsp"
	}
	function goSearching(){
		ani.method="post"
		ani.action="animal_list.jsp";
		ani.submit();
	}
</script>
</head>
<body>
<form action="" name="ani">
	<p>검색
	<select name=t_sgubun>
		<option value=""  >=전체=</option>
		<option value="l" <%if(searching.equalsIgnoreCase("l"))out.print("selected"); %> >지상동물</option>
		<option value="o" <%if(searching.equalsIgnoreCase("o"))out.print("selected"); %>>해상동물</option>
	</select> <input type="text" placeholder="이름검색" name="t_sname" value="<%=name%>"> <input type="button"  onclick="goSearching()" value="검색"> </p>
	총 <%=dtos.size() %> 마리
	<table width="500" border="1">
		<col width="8%"/>
		<col width="15%"/>
		<col width="37%"/>
		<col width="25%"/>
		<col width="15%"/>
		<tr>
			<th>/</th>
			<th>
				id
			</th>
			<th>
				동물명
			</th>
			<th>
				분류
			</th>
			<th>
				무게
			</th>
		</tr>
		<%for(AnimalDto dto:dtos){ %>
			<tr>
			<th><%=i++ %></th>
			<td>
				<a href="javascript:goView(<%=dto.getNo() %>)"><%=dto.getNo() %></a> 
			</td>
			<td>
				<%=dto.getName() %>
			</td>
			<td>
				<%if(dto.getKind().equalsIgnoreCase("l")){
					out.print("지상동물");
				}else{
					out.print("해상동물");
				}
					%>
			</td>
			<td>
				<%=dto.getWeight() %> kg
			</td>
		</tr>
		<%} %>
	</table>
	<table width="500" border="0">
		<tr>
			<th>
				<input type="button" onclick="goSave()" name="" value="저장">
			</th>
		</tr>
			<input type="hidden" name="t_id" value="">
			<input type="hidden" name="t_gubun" value="">
	</table>
	
</form>
</body>
</html>
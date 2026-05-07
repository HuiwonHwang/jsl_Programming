<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 회원등록</title>
<script type="text/javascript">
	function goSave(){
		var id=mem.t_id.value;
		var name=mem.t_name.value;
		var area=mem.t_area.value;
		var age=mem.t_age.value;
		if(id==""){
			alert("아이디를 입력하시오");
			mem.t_id.focus();
			return;
		}	
		if(mem.t_name.value==""){
			alert("이름을 입력하시오")
			mem.t_name.focus();
			return;
		}
		
		mem.method="post";
		mem.action="db_member_save.jsp";
		mem.submit();
		
		
		
	}
</script>
</head>
<body>
	<h2>황희원 회원등록</h2>
	<form action="" name="mem">
	<table width="500" border="1">
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tr>
			<th>ID</th>
			<td><input type="text" size="5" name="t_id"> </td>
		</tr>
		<tr>
			<th>성명</th>
			<td><input type="text" size="8" name="t_name"> </td>
		</tr>
		<tr>
			<th>지역</th>
			<td><select name="t_area">
				<option value="">=없음=</option>
				<option value="서울">서울</option>
				<option value="대전">대전</option>
				<option value="대구">대구</option>
				<option value="부산">부산</option>
			</select></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" size="3" name="t_age"> </td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" onclick="goSave()" value="저장" >
				&nbsp;
				<a href="member_list.jsp"> <input type="button" value="목록" > </a>
			</th>
		</tr>
	</table>
	</form>
</body>
</html>
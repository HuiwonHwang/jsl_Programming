<%@page import="java.util.ArrayList"%>
<%@page import="dto.AnimalDto"%>
<%@page import="dao.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AnimalDao dao= new AnimalDao();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 동물등록</title>
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	function goSave(){
		var id=ani.t_id.value;
		var name=ani.t_name.value;
		var gubun=ani.t_gubun.value;
		var weight=ani.t_weight.value;
		if(id==""){
			alert("등록하실 번호를 입력하세요");
			ani.t_id.focus();
			return;
		}
		if(ani.t_id_check.value==""){
			alert("중복검사를 실행하세요");
			ani.t_id.focus();
			return;	
		}
		if(ani.t_id_check.value!="사용가능"){
			alert("중복되는 id입니다.");
			ani.t_id.focus();
			return;	
		}
		if(name==""){
			alert("동물명을 입력하세요");
			ani.t_name.focus();
			return;
		}
		if(gubun==""){
			alert("동물타입을 정하세요");
			return;
		}
		if(weight==""){
			alert("무게를 입력하세요");
			ani.t_weight.focus();
			return;
		}
		ani.method="post";
		ani.action="db_animal_save.jsp";
		ani.submit();
	}
	function goCheck(){
		var id=ani.t_id.value;
		if(id==""){
			alert("id를 입력하세요");
			ani.t_id.focus();
			return;
		}
		
		$.ajax({
			type :"POST",
			url : "animal_checkId.jsp",
			async:false,
			data: "t_id="+id,
			dataType : "text",
			error : function(){
				alert('통신 실패!!!!!');
			},
			success : function(data){
				var result=$.trim(data);
				
				//alert("=="+result+"==");
				ani.t_id_check.value= result;
			}
		});	
	}
	function goinput(){
		ani.t_id_check.value="";
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
				<input type="text" oninput="goinput()" size="4" name="t_id">
				<input type="button" onclick="goCheck()" value="중복 확인">
				<input type="text" readonly size="5" name="t_id_check">
			</td>
		</tr>
		<tr>
			<th>
				동물명
			</th>	
			<td>
				<input type="text" size="5" name="t_name">
			</td>
		</tr>
		<tr>
			<th>
				분류
			</th>	
			<td>
				<input type="radio" name="t_gubun" value="l">지상동물
				<input type="radio" name="t_gubun" value="o">해상동물
			</td>
		</tr>
		<tr>
			<th>
				무게
			</th>	
			<td>
				<input type="text" size="4" name="t_weight">
			</td>
		</tr>
	</table>
	<table width="500" border="0">
		<tr><th><input type="button" onclick="goSave()" value="저장">
		<input type="button" onclick="location.href='animal_list.jsp'" value="목록"></th></tr>
	</table>
</form>
</body>
</html>
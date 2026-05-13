<%@page import="dto.StudentDto"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDao dao = new StudentDao();

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황희원 성적관리</title>
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	function goSave(){
		if(stu.t_sclass.value==""){
			alert("반을 선택하시오");
			return;
			
		}
		if(stu.t_sno.value==""){
			alert("번호를 입력하시오");
			stu.t_sno.focus();
			return;
		}
		var syear=stu.t_syear.value;
		var sclass=stu.t_sclass.value;
		var sno=stu.t_sno.value;
		var goIng="yes";
		$.ajax({
			type :"POST",
			url : "check_info.jsp",
			async:false,
			data: "t_syear="+syear+"&t_sclass="+sclass+"&t_sno="+sno,
			dataType : "text",
			error : function(){
				alert('통신 실패!!!!!');
			},
			success : function(data){
				var result=$.trim(data);
				if(result=="중복"){
					goIng="no";
				}
				//alert("=="+result+"==");
			}
		});	
				
		if(goIng=="no"){
			alert("학년 반 번호 중복");
			return;
		}
		
		
		if(stu.t_name.value==""){
			alert("이름을 입력하시오");
			stu.t_name.focus();
			return;
		}
		var kor=stu.t_kor.value;
		var tf= isNaN(kor);
		if(tf){
			alert("점수는 정수만 입력해주세요");
			stu.t_kor.focus();
			return;
		}
		if(kor>100||kor<0){
			alert("점수는 0점 이상 100점 이하로 입력하세요");
			stu.t_kor.focus();
			return;
		}
		if(stu.t_kor.value==""){
			alert("국어 점수를 입력하시오");
			stu.t_kor.focus();
			return;
		}
		var eng=stu.t_eng.value;
		if(stu.t_eng.value==""){
			alert("영어 점수를 입력하시오");
			stu.t_eng.focus();
			return;
		}
		var tf=isNaN(eng);
		if(tf){
			alert("영어점수는 정수로 입력해주세요");
			stu.t_eng.focus();
			return;
		}
		if(eng>100||eng<0){
			alert("영어점수는 0점 이상 100점 이하로 입력해주세요");
			stu.t_eng.focus();
			return;
		}
		var mat=stu.t_mat.value;
		if(stu.t_mat.value==""){
			alert("수학점수를 입력하시오");
			stu.t_mat.focus();
			return;
		}
		var tf=isNaN(mat);
		if(tf){
			alert("수학점수는 정수로만 입력해주세요");
			stu.t_mat.focus();
			return;
		}
		if(mat>100||mat<0){
			alert("수학점수는 0점이상 100점 이하로 입력해주세요");
			stu.t_mat.focus();
			return;
		}
		stu.method="post";
		stu.action="db_student_save.jsp";
		stu.submit();
	
	}
</script>
</head>
<body>
<form action="" name="stu">
	<h3>황희원 성적관리</h3>
		<table width="500" border="1">
		<col width="30%">
		<col width="*%">

			<tr>
				<th>학년</th>
				<td>
					<select name="t_syear">
						<option value="1">1학년</option>
						<option value="2">2학년</option>
						<option value="3">3학년</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>반</th>
				<td><input type="radio" name="t_sclass" value="1">1반
					<input type="radio" name="t_sclass" value="2">2반
					<input type="radio" name="t_sclass" value="3">3반
					<input type="radio" name="t_sclass" value="4">4반
					<input type="radio" name="t_sclass" value="5">5반
				 </td>
			</tr>
			<tr>
				<th>번호</th>
				<td><input type="text" name="t_sno" size="2" > </td>
			</tr>
			<tr>
				<th>성명</th>
				<td><input type="text" name="t_name" size="5" ></td>
			</tr>
			<tr>
				<th>국어 점수</th>
				<td><input type="text" name="t_kor" size="4" ></td>
			</tr>
			<tr>
				<th>영어 점수</th>
				<td><input type="text" name="t_eng" size="4" ></td>
			</tr>
			<tr>
				<th>수학 점수</th>
				<td><input type="text" name="t_mat" size="4" ></td>
			</tr>
		
		
		</table>
		<table width="500" border="0">
			<tr>
				<th>
					<input type="button" onclick="goSave()" value="회원 저장">
					<input type="button" onclick="location.href='student_list.jsp'" value="목록">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>
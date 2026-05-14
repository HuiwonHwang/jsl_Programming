<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" language="javascript">

		$.ajax({
			type :"POST",
			url : "abc.jsp",
			async:false,
			data: "t_id="+id,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				alert("=="+data+"==");
			}
		});	






    $(document).ready(function(){
    	$("#btnOK").click(function(){  
    	    var urlLocation="aaa.jsp";  
    	    var params="t_id=aaa";  
			$.ajax({
				type : "POST",
				url : urlLocation,
				data: params,
				dataType : "text",
				error : function(){
					alert('통신실패!!');
				},
				success : function(data){
					alert("통신데이터 값 : " + data);
				}
			});
    	});
 
    });
 
</script>













<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业卡激活页面</title>
<style type="text/css">
.content{
	border:0px solid blue;
	width:100%;
	
	padding:0px;
	
}
.warpCentent{
	width:50%;
	height:50%;
	margin-top:10%;
	margin-left:25%;
	text-align:center;
	border:0px solid red;
}
.col-sm-12{
padding-bottom: 10%;
}
.btn-activate{
	width:70%;
	line-height:170%;
	font-size:20px;
	background-color:#E83F14;
	color: #ffffff;	
}
.help-block{
	text-align: left;
	color: red;
}
</style>
</head>
<body>
<div class="content">
	<div class="warpCentent">
		<form id="form" method="post" role="form" onsubmit="return false;">
		  <div class="col-sm-12">
			    <div class="col-md-3 padding0L padding5T">卡号：</div>
			  <div class="col-md-8">
	             <input id="card" name="card" class="form-control input-lg" type="text"  placeholder="请输入卡号">
	         </div>
		  </div>
		  <div class="col-sm-12">
			    <div class="col-md-3 padding0L padding5T">激活码：</div>
			  <div class="col-md-8">
	             <input id="activateNum" name="activateNum" class="form-control input-lg" type="text" placeholder="请输入激活码">
	         </div>
		  </div>
		   <div class="col-sm-12">
		     <div id="errorInfo">错误</div>
		   </div>
		  <div class="col-sm-12">
		     <button type="button" class="btn btn-activate" onclick="activate();">
		     激活企业卡</button> 
		  </div>
		     
		</form>
	</div>
</div>
<script type="text/javascript">
  $(document).ready(function(){
	  $("#form").bootstrapValidator({
		  fields:{
			  card:{
				  validators:{
					  notEmpty:{
							message:'卡号必填'
					  }
				  }
			  },
			  activateNum:{
				  validators:{
					  notEmpty:{
							message:'激活码必填'
					  }
				  }
			  }
		  }
	  });
  });
function activate(){
	<%-- $('#form').data('bootstrapValidator').validate();  
	if(!$('#form').data('bootstrapValidator').isValid()){ 
	      return ;  
	}
	var card = $("#card").val();
	var activateNum = $("#activateNum").val();
    var t=new Date().valueOf();
    $.ajax({
    	url:'<%=path%>/activate/confirmActive',
    	type:'post',
    	dataType:'json',
    	data:{
    		cardNum:card,
    		activeNum:activateNum,
    		_time:t
    	},
    	success:function(data){
    		
    	}
    }); --%>
    var t = new Date().valueOf();
	$(".index-right").load('<%=path%>/activate/activatedetail',{_time:t});
}
</script>
</body>
</html>
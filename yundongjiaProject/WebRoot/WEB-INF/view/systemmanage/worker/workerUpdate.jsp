<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8"></meta>
<title>更新工作人员</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
<script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/indexLeft.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	//跳转到会员页面
	function ret(){
		var maincontent = $('.index-right');
		maincontent.load('<%=path%>/yundongjia/worker');
	}
	
	//提交查询
	function subForm(){
		/*手动验证表单，当是普通按钮时。*/  
		$('#formInfo').data('bootstrapValidator').validate();  
        if(!$('#formInfo').data('bootstrapValidator').isValid()){ 
            return ;  
        }  
		//获取表单信息
		var data = new FormData($('#formInfo')[0]);
		$.ajax({
			url : "<%=path%>/yundongjia/updateWorkerInfo",
			type: 'POST',  
            data: data,
            dataType: 'JSON',  
            async : false,
   			cache: false,  
            processData: false, 
            contentType: false, 
			success : function(data){
				if(data.result){
					var maincontent = $('.index-right');
					maincontent.load('<%=path%>/yundongjia/worker');
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		});		
	}
	
	//验证表单
	$(function(){
		$('#formInfo').bootstrapValidator({
			fields : {
				backusername : {
					validators: {
						notEmpty : {
							message : '姓名不能为空'
						},
						stringLength: {
			                 min:0,
			                 max: 200,
			                 message: '姓名长度必须在0到10之间'
			             },
					}
				},
				backusermobliephone :{
					validators : {
						notEmpty : {
							message : '手机号不能为空'
						},
						 stringLength: {
			                 min: 11,
			                 max: 11,
			                 message: '请输入11位手机号码'
			             },
			             callback: {  
			            	 message: '手机号已注册',
	                         callback: function(value) {
	                        	 var result = true;
	                        	 if(value.length > 10){
	                        		 $.ajax({
	                             		type: "POST",
	                           			url : "<%=path%>/gh/selectBUByPhone",
	                           			dataType : "JSON",
	                           			async : false,
	                           			cache: false,
	                           	        data: {
	                           	        	phone : value
	                           	        },
	                           	        success : function(data){
	                           	        	if(value == "${worker.backusermobliephone }"){
	                           	        		result =  true;
	                           	        	}else{
	                           	        		result =  data.result;
	                           	        	}
	                           	        }
	                           		});
	                        	 }
	                        	 return result;
	                         }
	                     },
	                     regexp: {
			                 regexp: /^1[3|5|4||7|8]{1}[0-9]{9}$/,
			                 message: '请输入正确的手机号码'
			             },
					}
				},
				backuserpwd: {
			         validators: {
			        	 notEmpty : {
								message : '密码不能为空'
							},
			             stringLength: {
			                 min: 6,
			                 max: 30,
			                 message: '密码长度必须在6到30之间'
			             },
			             identical: {//相同
			                 field: 'repassword', //需要进行比较的input name值
			                 message: '两次密码不一致'
			             },
			             regexp: {
			                 regexp: /^[a-zA-Z0-9_\.]+$/,
			                 message: '请输入正确的密码格式'
			             }
			         }
			     },
			     repassword: {
			         validators: {
			        	 notEmpty : {
								message : '重复密码不能为空'
							},
			             stringLength: {
			                 min: 6,
			                 max: 30,
			                 message: '密码长度必须在6到30之间'
			             },
			             identical: {//相同
			                 field: 'backuserpwd',
			                 message: '两次密码不一致'
			             },
			             regexp: {//匹配规则
			                 regexp: /^[a-zA-Z0-9_\.]+$/,
			                 message: '请输入正确的密码格式'
			             }
			         }
			     },
			  }
		});
	});
</script>
</head>
<body>
	<div class="main-content" >
		<div class="col-md-10 page-header">
				当前位置：
				<a href="javascript:void(0)" >修改工作人员</a>
			</div>
		<div>
			 <form id="formInfo"  onsubmit="return false;"  method="post">
				<div class="col-md-12">
					<div class="col-md-1 padding0L">
						姓名：
					</div>
					<div class="col-md-3 padding0L form-group">	
						 <input name="backusername"  class="form-control"  placeholder="请输入姓名" value="${worker.backusername }">
						 <input name="backuserid" type="hidden" value="${worker.backuserid }">
				  	</div>  			
					<label class="xing">*</label>  			
				</div>
				<div class="col-md-12">
					<div class="col-md-1 padding0L">
						手机号：
					</div>
					<div class="col-md-3 padding0L form-group">
						    <input name="backusermobliephone" class="form-control"  placeholder="请输入手机号" value="${worker.backusermobliephone }">
				  			</div>	
					<label class="xing">*</label>
				</div>
				<div class="col-md-12">
					<div class="col-md-1 padding0L">
						密码：
					</div>
					<div class="col-md-3 padding0L form-group">
						    <input type="password" name="backuserpwd"  class="form-control"  placeholder="请输入密码">
				  	</div>  
				  	<label class="xing">*</label>  		
				</div>
				<div class="col-md-12">
					<div class="col-md-1 padding0L">
						确认密码：
					</div>
					<div class="col-md-3 padding0L form-group">
						 <input type="password" name="repassword" class="form-control"  placeholder="重复密码">
				  	</div>  	
				  	<label class="xing">*</label>  	
				</div>	
				<div class="col-md-8">
					<div class="col-md-offset-1 col-md-1">
		  				<input type="button" class="btn btn-default bcColor" onclick="ret();" value="取消">
		  			</div>
				  	<div class="form-group col-md-offset-1 col-md-1">
		  				<input onclick="subForm();" id="inpsub" type="button" class="btn btn-default bcColor" value="提交">
		  			</div>
		  		</div>
			</form>	
		</div>
	</div>	
</body>
</html>
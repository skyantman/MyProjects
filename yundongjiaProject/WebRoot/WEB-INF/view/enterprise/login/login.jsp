<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>企业健康管理平台</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymbase.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymlogin.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymstyle.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
<script src="<%=path%>/static/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="<%=path%>/static/js/bootstrapValidator.js"></script>
<script src="<%=path%>/static/js/bootstrap.min.js"></script>
<style type="text/css">
		body{
			background-color: #49b2bb;
		}
	  /* 定义模态对话框外面的覆盖层样式 */
		#modal-overlay {
		     visibility: hidden;    
		     position: absolute;   /* 使用绝对定位或固定定位  */
		     left: 0px;    
		     top: 0px;
		     width:100%;
		     height:100%;
		     text-align:center;
		     z-index: 1000;
		     background-color: #333; 
		     opacity: 0.9;   /* 背景半透明 */
		}
		/* 模态框样式 */
		.modal-data{
			 height:200px;
			 width:300px;
		     margin: 100px auto;
		     background-color: #fff;
		     border:1px solid #000;
		     padding:15px;
		     text-align:center;
		}
		
		.login-bg .login-content input {
			width: 95%;
			margin-left : 20px;
			padding-left:10px;
			color:#7b7b7b;
			border-radius: 0px;
			border-left-width:0px;
			border-top-width:0px;
			border-right-width:0px;
			border-bottom-color:#E1E3E5;
		}
		.login-bg input[type="submit"] {
			    display: inline-block;
			    width: 30%;
			    height: 2.2em;
			    background-color: #E83F14;
			    font-size: 1.4em;
			    color: white;
			    border-radius: 5px;
			    text-align: center;
			    line-height: 1.5em;
			    cursor: pointer;
			    padding-left: 0;
			    margin-top: 0;
			    float: right;
			}
		.login-bg .login-content {
		    height: 27.8em;
		    margin-top: 1.6em;
		    padding-top: 50px;
		}
		.login-bg .login-content li .user-pwd {
		    font-size: 0.875em;
		    float: left;
		    color: #6ec7cf;
		    line-height: 1.875em;
		    cursor: pointer;
		    margin-top: 15px;
		}
		.login-bg .login-content {
		    border: 1px solid #FcF0F2;
		}
		
		.login-bg .login-content li label {
		    position: absolute;
		    left: -1.5em;
		    top: 0;
		}
		.has-error .help-block, .has-error .control-label, .has-error .radio, .has-error .checkbox, .has-error .radio-inline, .has-error .checkbox-inline, .has-error.radio label, .has-error.checkbox label, .has-error.radio-inline label, .has-error.checkbox-inline label {
		    color: #6ec7cf;
		    margin-left: 30px;
		}
		.login-bg {
			background: url();
		}
</style>
<script type="text/javascript">
var result = true;
// 刷新图片  
function changeImg() {
	var imgSrc = $("#imgObj");  
    var src = imgSrc.attr("src");  
    imgSrc.attr("src", changeUrl(src));
    $("#newLoad").load("<%=path%>/yundongjia");
}  
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳  
function changeUrl(url) {  
    var timestamp = (new Date()).valueOf();
    var srcUrl = url.split("?");
    url = srcUrl[0] + "?timestamp=" + timestamp;
    return url;
}

function afterOverlay(){
	changeImg();
	var phoneno = $('#userMobilephoneno').val();
	if(phoneno.length == 0){
		alert("请输入手机号");
		return ;
	}else if(phoneno.length != 11){
		alert("请输入11位手机号");
		return ;
	}
	$("#newLoad").load("<%=path%>/yundongjia");
	overlay();
}

//关闭验证码框
function overlay(){
	$("#code").val("");
	var e1 = document.getElementById('modal-overlay');	
    e1.style.visibility =  (e1.style.visibility == "visible"  ) ? "hidden" : "visible";
}

$(function() {
	if("${message}" != ""){
		alert("${message}");	
	}
	$('#loginForm').bootstrapValidator({
		message : 'This value is not valid',
		fields : {
			backusermobliephone : {
				validators : {
					notEmpty : {
						message : '用户名不能为空'
					}
				}
			},
			backuserpwd : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					}
				}
			},
		}
	});
	
	$('#form').bootstrapValidator({
		fields : {
			msg : {
			  validators: {
				  notEmpty: {
	                 message: '验证码不能为空'
		          },
		          stringLength: {
	                 min: 6,
	                 max: 6,
	                 message: '请输入6位验证码'
	             },
	             callback: {  
	            	 message: '请输入正确的验证码',
                     callback: function(value) {
                    	 var result = false;
                    	 if(value.length > 5){
                    		 var phone = $('#userMobilephoneno').val();
                    		 $.ajax({
                         		type: "POST",
                       			url : "<%=path%>/gh/checkCode",
                       			data : {
                       				authCode : value,
                       				phone : phone
                       			},
                       			dataType : "JSON",
                       			async : false,
                       			cache: false,
                       	        success : function(data){
                       	        	result = data;
                       	        }
                       		});
                    	 }
                    	 if(result){
                    		 
                    	 }
                    	 return result;
                     }
                 },
			  }
			},
			userMobilephoneno :{
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
		            	 message: '手机号未注册',
                         callback: function(value) {
                        	 var result = true;
                        	 if(value.length > 10){
                        		 $.ajax({
                             		type: "POST",
                           			url : "<%=path%>/gh/selectPhone",
                           			dataType : "JSON",
                           			async : false,
                           			cache: false,
                           	        data: {
                           	        	phone : value
                           	        },
                           	        success : function(data){
                           	        	if(data.result){
                           	        		$("#msg").removeAttr("disabled");
                           	        	}else{
                           	        		$("#msg").attr("disabled" , "disabled");
                           	        	}
                           	        	result =  data.result;
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
			userPassword: {
		         validators: {
		             notEmpty: {
		                 message: '密码不能为空'
		             },
		             stringLength: {
		                 min: 6,
		                 max: 30,
		                 message: '用户名长度必须在6到30之间'
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
		             notEmpty: {
		                 message: '用户名不能为空'
		             },
		             stringLength: {
		                 min: 6,
		                 max: 30,
		                 message: '用户名长度必须在6到30之间'
		             },
		             identical: {//相同
		                 field: 'userPassword',
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
	var countdown=60; 
	var validateCode = "";
	function settime(obj) {
		var phoneno = $('#userMobilephoneno').val();
		if(phoneno.length == 0){
			alert("请输入手机号");
			return ;
		}else if(phoneno.length != 11){
			alert("请输入11位手机号");
			return ;
		}
		/* var code = $("#code").val();
		if(code.length == 0){
			alert("请输入验证码！");
			return;
		}else{
			if(code.toLowerCase() != "${validateCode}".toLowerCase()){
				alert("请输入正确的验证码！");
				changeImg();
				return;
			}			
		}
		validateCode = "${validateCode}";
		overlay();
		 */
		if(countdown == 60){
			$.ajax({
				url : "<%=path%>/gh/sendCode",
				data : {
					phonenum : phoneno,
					/* validateCode : code */
				},
				type : "post",
				dataType : "JSON",
				success : function(data){
					/* $("#code").val("");
					changeImg(); */
					if(!data.result){
					    alert(data.message);
						$(obj).removeAttr("disabled");    
						$(obj).html("发送验证码"); 
						countdown = 0;
						r = false;
					}
				}
			});
			
		} 
		if (countdown == 0) { 
			$(obj).removeAttr("disabled");    
			$(obj).html("发送验证码"); 
			countdown = 60; 
			return;
		} else { 
			$(obj).attr("disabled", true); 
			$(obj).html("重新发送(" + countdown + ")"); 
			countdown--; 
		} 
		setTimeout(function() { 
			settime(obj) 
		},1000) 
	} 
	$(function(){
		$("#bgImg").css("height" , window.screen.availHeight-100);
	})
</script>
</head>	
	<body>
	<div>
		<div class="login-bg-img">
			<img id="bgImg" src="<%=path%>/static/images/enterpriseImage/bj.png" style="width: 100%;"/>
		</div>
		<div class="login-bg">
				<div class="login-container form-group" style="margin-left: -25px;margin-top: -240px;">
					<form class="" action="<%=path%>/enterprise/login" method="post"
							id="loginForm">
					<div class="form-group" >
						<div class="col-sm-12">
						<ul class="login-content"><!-- ${userName} -->
 

							<li style="margin-top: 40px;"><div class="form-group"><label></label><input type="text" name="backusermobliephone"  id="userId"  placeholder="用户名"/></div></li>
							<li><div class="form-group"><label></label><input  type="password"  name="backuserpwd"  id="userPassword"  placeholder="密码" /></div></li>

 							<li>
						 
								<div  style="color: #6ec7cf;margin:0;padding:0;width: auto;" id="error">${errInfo}</div>
							</li>
							<li style="margin-top: 30px;">
								<input type="submit" value="登&nbsp;录"/>
								<a href="javascript:void(0)" class="user-pwd"  data-toggle="modal" data-target="#myModal">忘记密码?</a>
							</li>	
						</ul>
						</div>
					 </div>
				</form>
			</div>
		</div>	
	</div>
	<!-- 弹框-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">忘记密码</h4>
	      </div>
	       <form id="form" class=" required-validate" action="<%=path%>/gh/enterpriseconfigPassword" method="post">
		      <div class="modal-body" style="height: 260px;">
		      	<div class="col-md-12" style="margin-top: -10px;">
					<div class="col-md-2">
						手机号:
		      		</div>
		      		<div class="col-md-6 form-group">
						<input name="userMobilephoneno" class="form-control" id="userMobilephoneno" placeholder="请输入会员手机号">
		      		</div>
		      		<label for='exampleInputEmail1' class="xing">*</label>
		      	</div>
		      	<div class="col-md-12">
					<div class="col-md-2">
						验证码:
		      		</div>
		      		<div class="col-md-4 form-group">
						<input name="msg" id="msg" class="form-control"  placeholder="请输入验证码">
		      		</div>
		      		<div class="col-md-2">
						<button id="msg" type="button" class="btn btn-default" onclick="settime(this)">发送验证码</button>
		      		</div>
		      		<span id="spanmemberMobilephoneno"></span>
		      	</div>
		      	<div class="col-md-12">
					<div class="col-md-2">
						密码:
		      		</div>
		      		<div class="col-md-6 form-group">
						<input type="password" name="userPassword" class="form-control" placeholder="请输入密码">
		      		</div>
		      		<label for='exampleInputEmail1' class="xing">*</label>
		      	</div>
		      	<div class="col-md-12 ">
					<div class="col-md-2 ">
						确认密码:
		      		</div>
		      		<div class="col-md-6 form-group">
						<input type="password" name="repassword" class="form-control" placeholder="请输入确认密码">
		      		</div>
		      		<label for='exampleInputEmail1' class="xing">*</label>
		      	</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
		        <button type="submit" class="btn btn-default" style="background-color: #E83F14;color: white;">提交</button>
		      </div>
	      </form>
	     </div>
	  </div>
	  </div>
	  
	  <!-- 验证码模态框 -->
	  <div id="modal-overlay"> 
		<div class="modal-data">
			<div class="col-md-12">
				<label for="id" class="col-md-4" style="margin-top: 5px;">  
		       		验证码:  
		    	</label>
		    	<div class="col-md-8">
					<input id="code" name="code" class="form-control" placeholder="请输入验证码"/>
		    	</div>	
			</div>		
		    <div class="col-md-12" style="margin-top: 15px;">
		    	 <div class="col-md-offset-4 col-md-6">
			        <img id="imgObj" alt="验证码" src="<%=path%>/gh/validateCode" onclick="changeImg()"/>  
			        <a href="javascript:void(0)" onclick="changeImg()">换一张</a>
		        </div>  
		    </div>
		    <div class="col-md-12"  style="margin-top: 15px;">    
			    <button class="btn btn-default" onclick="overlay()"  style="margin-right: 30px">返回</button>
			    <button class="btn btn-default" style="color: #E38F14;" onclick="settime()">确定</button>
		    </div>
		</div>
	</div>
	</div>
	<div id="newLoad" hidden="hidden"></div>
</body>
</html>



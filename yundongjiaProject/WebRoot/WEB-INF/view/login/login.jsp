<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>运动+ 后台管理系统</title>
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
                           			url : "<%=path%>/gh/selectBUByPhone",
                           			dataType : "JSON",
                           			async : false,
                           			cache: false,
                           	        data: {
                           	        	phone : value
                           	        },
                           	        success : function(data){
                           	        	if(!data.result){
                           	        		$("#msg").removeAttr("disabled");
                           	        	}else{
                           	        		$("#msg").attr("disabled" , "disabled");
                           	        	}
                           	        	result =  !data.result;
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
	function settime() {
		var phoneno = $('#userMobilephoneno').val();
		if(phoneno.length == 0){
			alert("请输入手机号");
			return ;
		}else if(phoneno.length != 11){
			alert("请输入11位手机号");
			return ;
		}
		var code = $("#code").val();
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
		/* if(countdown == 60){ */
			$.ajax({
				url : "<%=path%>/gh/sendCode",
				data : {
					phonenum : phoneno,
					validateCode : code
				},
				type : "post",
				dataType : "JSON",
				success : function(data){
					$("#code").val("");
					changeImg();
					if(!data.result){
						alert(data.message);
						$(obj).removeAttr("disabled");    
						$(obj).html("发送验证码"); 
						r = false;;
					}
				}
			});
			
		/* } */
		/* if (countdown == 0) { 
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
		},1000)  */
	} 

</script>
</head>	
	<body>
	<div>
		<div class="login-bg-img">
			<img src="<%=path%>/static/images/systemImages/login/bg_gril.png" />
		</div>
		<div class="login-bg">
				<div class="login-container form-group">
					<div class="login-img">
				    	<img src="<%=path%>/static/images/systemImages/login/login_title1.png" />
					</div>
					<form class="" action="<%=path%>/yundongjialogin" method="post"
							id="loginForm">
					<div class="form-group" >
						<div class="col-sm-12"  >
						<ul class="login-content"><!-- ${userName} -->
 

							<li style="margin-top: 40px;"><div class="form-group"><label></label><input value="13520646436" type="text" name="backusermobliephone"  id="userId"  placeholder="用户名"/></div></li>
							<li><div class="form-group"><label></label><input value="123456"  type="password"  name="backuserpwd"  id="userPassword"  placeholder="密码" /></div></li>

 							<li>
						 
								<div  style="color: #F00;margin:0;padding:0;width: auto;" id="error">${errInfo}</div>
								<input type="submit" value="登录"/>
							</li>
							<li style="margin-top: 10px;">
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
	        <h4 class="modal-title" id="myModalLabel">首次登录</h4>
	      </div>
	       <form id="form" class=" required-validate" action="<%=path%>/gh/configPassword" method="post">
		      <div class="modal-body" style="height: 320px;">
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
						<input name="msg" class="form-control"  placeholder="请输入验证码">
		      		</div>
		      		<div class="col-md-2">
						<button disabled="disabled" id="msg" type="button" class="btn btn-default" onclick="afterOverlay()">发送验证码</button>
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
		        <button type="submit" class="btn btn-default bcColor">提交</button>
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
					<input type="text" id="code" name="code" class=" form-control" placeholder="请输入验证码"/>
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
			    <button class="btn btn-default bcColor" onclick="settime()">确定</button>
		    </div>
		</div>
	</div>
	</div>
	<div id="newLoad" hidden="hidden"></div>
</body>
</html>



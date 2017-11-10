<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜单</title>

<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
</head>
<body>
	<div class="main-content">
		<div class="col-md-10 page-header">
			<h1>
				<small>添加菜单</small>
			</h1>
		</div>
		<div class="col-md-2 topRange"></div>
		<div class="hrsoild "></div>
		<div>
			<form id="form" name="form1" onsubmit="return false;" method="post">
				<input type="hidden" id="menuIsroot" name="menuIsroot" value="${isRoot}">
				<div class="col-md-12">
					<div class="col-md-1 padding0L padding5T">上级菜单：</div>
					<c:if test="${isRoot == 1}"><!-- 根节点 -->
					<div class="col-md-3 padding0L form-group">
						<input class="form-control" readonly="readonly" value="顶级菜单" placeholder="">
					</div>
					</c:if>
					<c:if test="${isRoot == 0}"><!-- 子节点 -->
					 <div class="col-md-3 padding0L form-group">
						<input  class="form-control" readonly="readonly" value="${menu.menuName}" placeholder="">
						<input type="hidden" id="menuPid" name="menuPid" value="${menu.menuId}">
					</div>
					</c:if>
					<label class="xing">*</label>
				</div>
				<div class="col-md-12">
					<div class="col-md-1 padding0L padding5T">菜单名称：</div>
					<div class="col-md-3 padding0L form-group">
						<input id="menuName" name="menuName" class="form-control" placeholder="请输入菜单名称">
					</div>
				</div>
				<c:if test="${isRoot == 0}">
				 <div class="col-md-12">
					<div class="col-md-1 padding0L padding5T">接口名称：</div>
					<div class="col-md-3 padding0L form-group">
						<input id="menuPathname" name="menuPathname" class="form-control" placeholder="请输入接口名称">
					</div>
				</div>
				</c:if>
				<div class="col-md-12">
					<div class="col-md-1 padding0L padding5T">排序：</div>
					<div class="col-md-3 padding0L form-group">
						<input id="menuOrdernum" name="menuOrdernum" type="text" class="form-control" placeholder="请输入排序数字">
					</div>
				</div>
				<div class="col-md-12">
					<div class="col-md-1 padding0L padding5T">权限标识：</div>
					<div class="col-md-3 padding0L form-group">
						<input id="menuPowerid" name="menuPowerid" class="form-control" placeholder="请输入权限标识">
					</div>
				</div>
				<div class="col-md-12">
					<div class="col-md-1 padding0L padding5T">是否可见：</div>
					<div class="form-group col-md-3 padding0L">
						<input name="menuIsshow" type="radio" value="1" checked="checked">可见
						<input name="menuIsshow" type="radio" value="0" style="margin-left: 15px;">隐藏					
				    </div>
				</div>
				<div class="col-md-8 ">
					<div class="form-group col-md-offset-1 col-md-1 form-group">
						<input onclick="saveORupdate();" id="inpsub" type="button"
							class="btn btn-default bcColor" value="提交">
					</div>
					<div class="col-md-offset-1 col-md-1 form-group">
						<input type="button" class="btn btn-default bcColor"
							onclick="back();" value="取消">
					</div>
				</div>
			</form>
		</div>
	</div>
<script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#form").bootstrapValidator({
			fields:{
				menuName:{
					validators:{
						notEmpty:{
							message:'菜单名称必填'
						}
					}
				},
				menuPathname:{
					validators:{
						notEmpty:{
							message:'接口名称必填'
						}
					}
				},
				menuOrdernum:{
					validators:{
						notEmpty:{
							message:'排序必填'
						},
						regexp:{
							regexp:/^[0-9]+$/,
							message:'排序只能输入数字'
						}
					}
				},
				menuPowerid:{
					validators:{
						notEmpty:{
							message:'权限标识必填'
						},
						callback:{
							message:'权限标识已存在',
							callback:function(value){
								//先通过第一关
								if(value.length == 0){
									return true
								}
								var t = new Date().valueOf();
								var flag=true;
								$.ajax({
									url:'<%=path%>/menu/checkpowerid',
									type:'POST',
									dataType:'JSON',
									async : false,
                           			cache: false,
									data:{
										powerid:value,
										_time:t
									},
									success:function(res){
										if(res > 0){
											flag=false;
										}
									}
								});
								return flag;
							}
						}
					}
				}
			}
		});
	});
	
	function saveORupdate(){
		$("#form").data("bootstrapValidator").validate();
		if(!$("#form").data("bootstrapValidator").isValid()){
			return false;
		}
		var data = new FormData($('#form')[0]);
		$.ajax({
			url:'<%=path%>/menu/saveupdate',
			data:data,
			type:'POST',
			dataType:'JSON',
			cache: false,  
            processData: false, 
            contentType: false, 
            async : false,
            success:function(result){
            	if(result > 0){
            		alert("操作成功");
            		back();
            	}
            	
            }
		});
	}
function back(){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/datamanage/menuManage?_time=' + t);
}
	</script>
</body>
</html>
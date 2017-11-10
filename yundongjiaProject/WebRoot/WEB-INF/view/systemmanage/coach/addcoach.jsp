<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建教练</title>
</head>
<body>
<div class="main-content">
 <div class="page-header">
		当前位置：<a href="javascript:void(0);"> 新建教练 </a>
 </div>
		<form id="form" name="form1" enctype=”multipart/form-data”
			onsubmit="return false;" method="post">
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">教练名称：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="nickname" value="" name="nickname"
						class="form-control" placeholder="请输入教练名称">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">擅长课程：</div>
				<div class="col-md-6 padding0L form-group">
					 <c:forEach items="${skills}" var="sk">
					 <input type="checkbox" name="skills" value="${sk.skillid}">${sk.skillname}&nbsp;
					 </c:forEach>
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">所在城市：</div>
				<div class="col-md-2 padding0L form-group">
					<select id="province" name="province" onchange="loadCity(this);"
						class="form-control btn btn-default">
						<option value="-1">省</option>
						<c:forEach items="${pros}" var="p">
						 <option value="${p.code }">${p.name }</option>
						</c:forEach>

					</select>
				</div>
				<div class="col-md-2 padding0L form-group">
					<select id="city" name="city" class="form-control btn btn-default" onchange="loadArea(this);">
						<option value="-1">市</option>

					</select>
				</div>
				<div class="col-md-2 padding0L form-group">
					<select id="area" name="regionsid"
						class="form-control btn btn-default">
						<option value="-1">区</option>

					</select>
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">所属场馆：</div>
				<div class="col-md-6 padding0L form-group">
					  <select id="studioid" name="studioid" onchange="loadTime()"
						class="form-control btn btn-default">
						<option value="-1">请选择</option>
						<c:forEach items="${studios}" var="s">
							<option value="${s.studioid }">${s.studioname }</option>
						</c:forEach>
					</select>
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L">授课时间：</div>
				<div id="skTime" class="col-md-3 padding0L form-group">
					<!-- <select id="starttime" name="starttime"
						class="form-control btn btn-default">
					</select> -->
				</div>
				<div class="col-md-3 padding0L form-group">
					<!-- <select id="endtime" name="endtime"
						class="form-control btn btn-default">

					</select> -->
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">联系电话：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="mobilePhone" value="" name="mobilePhone"
						class="form-control" placeholder="请输入联系电话">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">关键字：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="keywords" value="" name="keywords"
						class="form-control" placeholder="关键字以英文逗号区分">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">从业年龄：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="workage" value="" name="workage"
						class="form-control" placeholder="请输入从业年龄  单位年">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">教练介绍：</div>
				<div class="col-md-6 padding0L form-group">
					<textarea id="introduce" name="introduce" class="form-control" rows="2"></textarea> 
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">获得奖项：</div>
				<div class="col-md-6 padding0L form-group">
					 <table>
					 	<tr>
					 		<td style="text-align: center;">名称</td>
					 		<td style="text-align: center;">名次</td>
					 	</tr>	
					 	<tr>
					 		<td>
					 		<input id="" value="" name="rewardName"
						class="form-control" >
					 		</td>
					 		<td>
					 		<input id="" value="" name="rewardNum"
						class="form-control" >
					 		</td>
					 	</tr>
					 	<tr>
					 		<td>
					 		<input id="" value="" name="rewardName"
						class="form-control" >
					 		</td>
					 		<td>
					 		<input id="" value="" name="rewardNum"
						class="form-control" >
					 		</td>
					 	</tr>
					 	<tr>
					 		<td>
					 		<input id="" value="" name="rewardName"
						class="form-control" >
					 		</td>
					 		<td>
					 		<input id="" value="" name="rewardNum"
						class="form-control" >
					 		</td>
					 	</tr>
					 </table>
				</div>
				<!-- <label class="xing">*</label> -->
			</div>
			<div class="col-md-12">
						<div class="col-md-1 padding0L">教练主相册</div>
						<div class="col-md-6 padding0L form-group">	
						<div>
							<input id="file0" type="file" name="img"  
							value="上传"   accept="image/gif,image/jpeg,image/png"  
							onchange="imgview('imgsOne','file0',1);"/>
						</div>
					 	<div class="col-md-12"  id="imgsOne">
					 			
						</div> 
						</div>  	
						<label class="xing">*</label>  
					</div>
					
			<div class="col-md-12">
						<div class="col-md-1 padding0L">教练副相册</div>
						<div class="col-md-6 padding0L form-group">	
						<div>
							<input id="file1" type="file" name="img"  value="上传"  
							 accept="image/gif,image/jpeg,image/png"  
							 multiple="multiple" onchange="imgview('imgs','file1');"/>
						     <span style="color:red;">最多可上传4张图</span>
						</div>
					 	<div class="col-md-12"  id="imgs">
					 			
						</div> 
						</div>  	
						<!-- <label class="xing">*</label> -->  
						<input type="button" value="清空" class="btn btn-danger" onclick="delPageImage('file1', 'imgs')">
					</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">价格：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="courseprice" value="" name="courseprice"
						class="form-control" placeholder="请输入价格 单位元">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">取消限制：</div>
				<div class="col-md-6 padding0L form-group">
					 <select id="canclelimit" name="canclelimit"
						class="form-control btn btn-default">
						<option value="0" selected="selected">不限制</option>
						<option value="1">12小时</option>
						<option value="2">24小时</option>
						<option value="3">36小时</option>
						<option value="4">48小时</option>
						<option value="5">72小时</option>
					</select>
				</div>
				<label class="xing">*</label>
			</div>

			<div class="col-md-8">
				<div class="col-md-offset-1 col-md-1">
					<input type="reset" class="btn btn-default bcColor" value="重置">
				</div>
				<div class="form-group col-md-offset-1 col-md-1">
					<input onclick="subForm();" id="inpsub" type="button"
						class="btn btn-default bcColor" value="提交">
				</div>
			</div>


		</form>
	</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>	
<script src="<%=path%>/static/js/param.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/region.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>	
<script type="text/javascript" src="<%=path %>/static/js/imgView.js"></script>
<!-- 市模板 -->
<script type="text/x-javascript-tmpl" id="cityTmpl">
		<option value="{{= code}}">{{= name}}</option>
</script>
<script type="text/javascript">

$(document).ready(function(){
	$("#form").bootstrapValidator({
		fields:{
			nickname:{
				validators:{
					notEmpty:{
						message:'教练名称必填'
					}
				}
			},
			skills:{
				validators:{
					notEmpty:{
						message:'擅长课程必选'
					}
				}
			},
			regionsid:{
				validators:{
					callback:{
						message:'省必选',
						callback:function(value){
							if(value == -1){
								return false;
							}else{
								return true;
							}
						}
					}
				}
			},
			studioid:{
				validators:{
					callback:{
						message:'场馆必选',
						callback:function(value){
							if(value == -1){
								return false;
							}else{
								return true;
							}
						}
					}
				}
			},
			mobilePhone:{
				validators:{
					/* notEmpty:{
						message:'手机号必填'
					}, */
					regexp:{
						message:'请输入正确手机号',
						regexp:/^\d{11}$/
					}/* ,
					callback:{
						message:'手机号码已存在',
						callback:function(value){
							var res = validMobilePhone(value, 2);
															
							return res;
						}
					} */
				}
			},
			keywords:{
				validators:{
					notEmpty:{
						message:'关键字必填'
					},
					stringLength:{
						min:1,
						max:12,
						message: '关键字长度必须在1到12字符之间'
					},
					regexp:{
						message:'多个用英文逗号分隔',
						regexp:/^([\u4e00-\u9fa5a-zA-Z0-9]{1,12},){0,}([\u4e00-\u9fa5A-Za-zA-Z0-9]{1,12})$/
					}
				}
			},
			workage:{
				validators:{
					notEmpty:{
						message:'从业年龄必填'
					},
					regexp:{
						  message:'年龄须填写整数',
						  regexp:/^[0-9]*[1-9][0-9]*$/
					}
				}
			},
			introduce:{
				validators:{
					notEmpty:{
						message:'教练介绍必填'
					}
				}
			},
			/* img:{
				validators:{
					notEmpty:{
						message:'相册必选'
					}
				}
			}, */
			courseprice:{
				validators:{
					notEmpty:{
						message:'价格必填'
					},
					regexp:{
						message:'请正确填写价格(数字或两位小数)',
						regexp:/^(([1-9]\d*)|\d)(\.\d{1,2})?$/
						
					}
				}
			}
			
	
		}
	})
});	
	
	
//选择场馆加载场馆开放时间
function loadTime(){
	var id = $("#studioid").val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/selectstudiotime',
		type:'post',
		dataType:'json',
		data:{
			studioId:id,
			_time:t
		},
		success:function(data){
			$("#skTime").html(data);
		}
	});
}

/* 保存教练 */	
function subForm(){
	$('#form').data('bootstrapValidator').validate();  
    if(!$('#form').data('bootstrapValidator').isValid()){ 
        return ;  
    }
	var t=new Date().valueOf();
	 var data = new FormData($("#form")[0]);
		$.ajax({
			url:'<%=path%>/yundongjia/savecoach',
			type : 'post',
			dataType : 'json',
			data : data,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(result) {
				if(result > 0){
					alert("添加成功");
					$(".index-right").load('<%=path%>/yundongjia/detailcoach?coachId='+result+'&_time='+t);
				}
			}
		});

}	
</script>
</body>
</html>
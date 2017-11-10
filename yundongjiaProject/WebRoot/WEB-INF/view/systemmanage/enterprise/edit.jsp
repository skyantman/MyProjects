<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function toback(num){
	var t=new Date().valueOf();
	if(0 == num){
		url='<%=path%>/yundongjia/listenterprise?_time='+t;
	}
	tobackDemo(url);
}
</script>
<title>企业修改</title>
</head>
<body>
	<div class="main-content">
		<div class="col-md-10 page-header">
			当前位置：<a href="javascript:toback(0);">企业列表</a> &nbsp; &gt; &nbsp;  <a href="javascript:void(0);">
				编辑企业
			</a>
		</div>
		<div>
			<form id="form" name="form1" onsubmit="return false;" method="post">
				<div id="one">
				<input type="hidden" value="${enterprise.enterprise_id}" id="enterpriseId" name="enterpriseId">
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">企业名称：</div>
						<div class="col-md-6 padding0L form-group">
							<input id="enterprisename" value="${enterprise.enterpriseName}" name="enterprisename"
								class="form-control" placeholder="请输入企业名称,建议最多15个字">
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">所在城市：</div>
						<div class="col-md-2 padding0L form-group">
							<select id="province" name="province"
								class="form-control btn btn-default">
								<!-- <option value="-1">省</option> -->
								<c:forEach items="${listPro}" var="pro">
									<option  value="${pro.code}"  <c:if test="${pro.code == enterprise.ProvinceId}"> selected="selected" </c:if>      >${pro.name}</option>
								</c:forEach>

							</select>
						</div>
						<div class="col-md-2 padding0L form-group">
							<select id="city" name="city"
								class="form-control btn btn-default">
								<option value="${enterprise.city }">${enterprise.cityName }</option>

							</select>
						</div>
						<div class="col-md-2 padding0L form-group">
							<select id="area" name="regionsid"
								class="form-control btn btn-default">
								<option value=" ${enterprise.area }">${enterprise.areaName}</option>

							</select>
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">企业地址：</div>
						<div class="col-md-6 padding0L form-group">
							<input id="enterpriseaddr" value="${enterprise.enterpriseAddr}" name="enterpriseaddr"
								class="form-control" placeholder="请输入企业地址">
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">企业规模：</div>
						<div class="col-md-6 padding0L form-group">
							<select id="enterprisescale" name="enterprisescale"
								class="form-control btn btn-default">
								<option value="50人以下"  <c:if test='${enterprise.enterpriseScale == "50人以下"}'>selected="selected"</c:if>  >50人以下</option>
								<option value="50-100人" <c:if test='${enterprise.enterpriseScale == "50-100人"}'>selected="selected"</c:if>  >50-100人</option>
								<option value="100-200人" <c:if test='${enterprise.enterpriseScale == "100-200人"}'>selected="selected"</c:if>  >100-200人</option>
								<option value="200-500人" <c:if test='${enterprise.enterpriseScale == "200-500人"}'>selected="selected"</c:if>  >200-500人</option>
								<option value="500-1000人"  <c:if test='${enterprise.enterpriseScale == "500-1000人"}'>selected="selected"</c:if>  >500-1000人</option>
								<option value="1000-5000人" <c:if test='${enterprise.enterpriseScale == "1000-5000人"}'>selected="selected"</c:if>   >1000-5000人</option>
								<option value="5000-10000人" <c:if test='${enterprise.enterpriseScale == "5000-10000人"}'>selected="selected"</c:if>   >5000-10000人</option>
								<option value="10000人以上" <c:if test='${enterprise.enterpriseScale == "10000人以上"}'>selected="selected"</c:if>   >10000人以上</option>
							</select>
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">联系人：</div>
						<div class="col-md-3 padding0L form-group">
							<input id="contactname" value="${enterprise.contactName}" name="contactname"
								class="form-control" placeholder="请输入联系人姓名">
						</div>
						<div class="col-md-3 padding0L form-group">
							<input type="hidden" id="enterprisetelHid" value="${enterprise.enterpriseTel}" >
							<input id="enterprisetel" name="enterprisetel"
								value="${enterprise.enterpriseTel}" class="form-control"
								placeholder="请输入联系方式  手机号或固话">
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">参与活动：</div>
						<div class="form-group col-md-3 padding0L">
							<input name="isactivity" type="radio" value="1"  <c:if test="${enterprise.isActivity == 1}">checked="checked"</c:if>   >参与
							<input name="isactivity" type="radio" value="0"  <c:if test="${enterprise.isActivity == 0}">checked="checked"</c:if>
								style="margin-left: 15px;">不参与
						</div>

					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">备注：</div>
						<div class="col-md-6 padding0L form-group">
							<textarea class="form-control" id="comm" name="comm" rows="6"
								cols="20">${enterprise.comm}</textarea>
						</div>
					</div>
					<div class="col-md-8 ">
						<div class="form-group col-md-offset-4 col-md-1 form-group">
							<input onclick="submitForm()" id="next" type="button"
								class="btn btn-default bcColor" value="确定">
						</div>
						
						
						 
					</div>
				</div>
				<!-- 结束 -->
				 
			</form>
		</div>


	</div>
<script type="text/javascript" src="<%=path %>/static/js/bootstrapValidator.js"></script>	
<script type="text/javascript" src="<%=path%>/static/js/jquery.tmpl.min.js"></script>
	<!-- 市模板 -->
<script type="text/x-javascript-tmpl" id="cityTmpl">
<option value="{{= code}}">{{= name}}</option>
</script>
<script type="text/x-javascript-tmpl" id="areaTmpl">
<option value="{{= code}}">{{= name}}</option>
</script>	
<script type="text/javascript">
$(document).ready(function(){
	
	$('#form').bootstrapValidator({
		fields:{
			enterprisename:{
				validators:{
					notEmpty:{
						message:'企业名称必填'
					}
				}
			},
			province:{
				validators:{
					callback:{
						message:'请选择省',
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
			city:{
				validators:{
					callback:{
						message:'请选择市',
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
			regionsid:{
				validators:{
					callback:{
						message:'请选择区',
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
			contactname:{
				validators:{
					notEmpty:{
						message:'联系人必填'
					}
				}
			},
			enterprisetel:{
				validators:{
					notEmpty:{
						message:'联系电话必填'
					},
					regexp:{
						message:'请输入手机号或固话',
						regexp:/^((0\d{2,3}-\d{7,8})|(\d{11}))$/
					},
					callback:{
						message:'手机号码已存在',
						callback:function(value){
							var oldValue=$("#enterprisetelHid").val();
							if(oldValue == value){
								return true;
							}
							var res = validMobilePhone(value, 3);
															
							return res;
						}
					}
				}
			},
			enterpriseaddr:{
				validators:{
					notEmpty:{
						message:'企业地址必填'
					}
				}
			}
			
			
		}
	});
	
	
	
	/* 省 */
	$("#form").on('change','#province',function(){
		var value = $("#province").val();
		var t = new Date().valueOf();
		//加载市
		$.ajax({
			url:'<%=path%>/yundongjia/getcitybypro',
			type:'post',
			dataType:'JSON',
			data:{
				_time:t,
				proCode:value
			},
			success:function(data){
				$("#city").html("");
				$("#city").append("<option value='-1'>市</option>");
				$("#city").append($("#cityTmpl").tmpl(data));
			}
		}); 
	});
	
	
	/* 市 */
	$("#form").on('change','#city',function(){
		var value = $("#city").val();
		var t = new Date().valueOf();
		//加载区
		$.ajax({
			url:'<%=path%>/yundongjia/getareabycity',
			type:'post',
			dataType:'JSON',
			data:{
				_time:t,
				cityCode:value
			},
			success:function(data){
				$("#area").append("<option value='-1'>区</option>");
				$("#area").append($("#areaTmpl").tmpl(data));
			}
		});
	});
	
	
});
function submitForm(){
	$('#form').data('bootstrapValidator').validate();  
    if(!$('#form').data('bootstrapValidator').isValid()){ 
        return ;  
    }
    	var t=new Date().valueOf();
		/* 修改企业信息 */
		var data = new FormData($("#form")[0]);
		$.ajax({
			url:'<%=path%>/yundongjia/updateenterprise',
			type : 'post',
			dataType : 'json',
			data : data,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(result) {
				if(result.state > 0){
					var r = confirm("修改企业成功");
					if(r){
						var id = result.id;
						$('.index-right').load('<%=path%>/yundongjia/detailenterprise?id='+id+'&tab=1&_time='+t);
					}
				}else{
					alert("修改企业失败");
				}
			}
		});

	}
</script>	
	
	
</body>
</html>
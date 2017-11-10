<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增企业卡</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">

</head>
<body>
	<div class="main-content">
		<div class="page-header">
			当前位置：<a href="javascript:void(0);">
				新增企业
			</a>
		</div>
		<div>
		<input type="hidden" value="" id="enterpriseId">
			<form id="form" name="form1" onsubmit="return false;" method="post">
				<div id="one">
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">企业名称：</div>
						<div class="col-md-6 padding0L form-group">
							<input id="enterprisename" value="" name="enterprisename"
								class="form-control" placeholder="请输入企业名称,建议最多15个字">
						</div>
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">所在城市：</div>
						<div class="col-md-2 padding0L form-group">
							<select id="province" name="province" onchange="loadCity(this);"
								class="form-control btn btn-default">
								<option value="-1">省</option>
								<c:forEach items="${listPro}" var="pro">
									<option value="${pro.code}">${pro.name}</option>
								</c:forEach>

							</select>
						</div>
						<div class="col-md-2 padding0L form-group">
							<select id="city" name="city" onchange="loadArea(this);"
								class="form-control btn btn-default">
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
						<div class="col-md-1 padding0L padding5T">企业地址：</div>
						<div class="col-md-6 padding0L form-group">
							<input id="enterpriseaddr" value="" name="enterpriseaddr"
								class="form-control" placeholder="请输入企业地址">
						</div>
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">企业规模：</div>
						<div class="col-md-6 padding0L form-group">
							<select id="enterprisescale" name="enterprisescale"
								class="form-control btn btn-default">
								<option value="50人以下">50人以下</option>
								<option value="50-100人">50-100人</option>
								<option value="100-200人">100-200人</option>
								<option value="200-500人">200-500人</option>
								<option value="500-1000人" selected="selected">500-1000人</option>
								<option value="1000-5000人">1000-5000人</option>
								<option value="5000-10000人">5000-10000人</option>
								<option value="10000人以上">10000人以上</option>
							</select>
						</div>
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">联系人：</div>
						<div class="col-md-3 padding0L form-group">
							<input id="contactname" value="" name="contactname" class="form-control"
								placeholder="请输入联系人姓名">
						</div>
						<div class="col-md-3 padding0L form-group">
							<input id="enterprisetel" name="enterprisetel" value="" class="form-control"
								placeholder="请输入联系方式  手机号或固话">
						</div>
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">参与活动：</div>
						<div class="form-group col-md-6 padding0L">
							<input name="isactivity" type="radio" value="1" checked="checked">参与
							<input name="isactivity" type="radio" value="0"
								style="margin-left: 15px;">不参与
						</div>
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">备注：</div>
						<div class="col-md-6 padding0L form-group">
							<textarea class="form-control" id="comm" name="comm" rows="6"
								cols="20"></textarea>
						</div>
					</div>
					<div class="col-md-8 ">
						
						<div class="form-group col-md-offset-4 col-md-1 form-group">
							<input onclick="nextNum()" id="next" type="button"
								class="btn btn-default bcColor" value="下一步">
						</div>

					</div>
				</div>
				<!-- 结束 -->
				<!-- 绑定企业卡 -->
				<div id="tow" style="display: none;">
					<div id="echo" class="col-md-12">
						<div class="col-md-1 padding0L padding5T">绑定企业卡：</div>
						<div class="col-md-11 padding0L form-group">
							<a id="modal" href="#modal-container0" role="button"
								class="btn bcColor"
								data-toggle="modal">选择企业卡</a>
						</div>


					</div>


					<div class="col-md-8 ">
						
					
						<div class="form-group col-md-offset-4 col-md-1 form-group">
							<input onclick="locaDetail()" id="next" type="button"
								class="btn btn-default bcColor" value="确定">
						</div>

					</div>
				</div>

			</form>
		</div>


	</div>

	<!--弹窗-->
	<div class="modal fade" id="modal-container0" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="width: 100%;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button> -->
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body">
					<div class="col-md-12">
						<div class="col-md-2 padding0L padding5T">采购价：</div>
						<div class="col-md-3 padding0L form-group">
							<input id="procMoney" name="" class="form-control" value=""
								placeholder="">
						</div>
						<div class="col-md-2 padding0L padding5T">支付方式：</div>
						<div class="col-md-4 padding0L form-group">
							<select id="cardOrderMethod" name="cardOrderMethod"
								class="form-control btn btn-default">
								<option value="00">支付宝支付</option>
								<option value="01">微信支付</option>
								<option value="02">现金支付</option>
								<option value="03">其他</option>
							</select>
						</div>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th>选择</th>
								<th>卡类型ID</th>
								<th>卡名称</th>
								<th>折扣率</th>
								<th>金额</th>
								<th>运动次数</th>
								<th>有效期</th>
								<th>覆盖城市</th>
							</tr>
						</thead>
						<tbody id="typelist">
							<c:forEach items="${cardTypes}" var="w">
								<tr>
									<td><input name="cardTypeId" type="radio"
										value="${w.cardid}"></td>
									<td>${w.cardid}</td>	
									<td>${w.cardtypename }</td>
									<td>${w.carddiscount }折</td>
									<td>${w.amount }</td>
									<td>${w.sportscount }</td>
									<td>${w.validdate }天</td>
									<td>${w.regionsid }</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
				
				<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
				</button>
				<button type="button" onclick="selectCardTypeOk();" class="btn btn-primary">
					提交更改
				</button>
			</div>
				
			</div>
		</div>

	</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path%>/static/js/param.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/region.js" type="text/javascript" charset="utf-8"></script>	
<script type="text/javascript" src="<%=path %>/static/js/bootstrapValidator.js"></script>	
	<script type="text/javascript"
		src="<%=path%>/static/js/jquery.tmpl.min.js"></script>
	<script type="text/x-javascript-tmpl" id="cardTypeTheEcho">
<div class="col-md-1 padding0L padding5T">绑定企业卡：</div>
		<div class="col-md-1 padding0L padding5T">采购价：</div>
						<div class="col-md-2 padding0L form-group">
							 <input id="" name="" readonly="readonly"
							class="form-control" value="{{= realMoney}}" placeholder=""> 

						</div>
					 	<div class="col-md-1 padding0L form-group">
							<span style="line-height: 30px;">元</span>
						</div>
						 <div class="col-md-10 col-md-offset-1  padding0L form-group">
							<table class="table">
								<thead>
									<tr>
										<th>卡ID</th>
										<th>卡名称</th>
										<th>折扣率</th>
										<th>金额</th>
										<th>运动次数</th>
										<th>有效期至</th>
										<th>激活日期</th>
									</tr>
								</thead>
<tbody id="">
<tr>
  <td>{{= cardId}}</td> <td>{{= cardTypeName}}</td> 
<td>{{= discount}}</td> <td>{{= money}}</td> <td>{{= sportsCount}}</td>  
<td>{{= expireDate}}</td> <td>{{= createDate}}</td>
</tr>
</tbody>
								
							</table>
						</div>
						
</script>
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
		
		
		<%-- /* 省 */
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
		}); --%>
		/* 市 */
		<%-- $("#form").on('change','#city',function(){
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
					$("#area").html("");
					$("#area").append("<option value='-1'>区</option>");
					$("#area").append($("#areaTmpl").tmpl(data));
				}
			});
		}); --%>
		
	});
	function nextNum(){
		//var res = confirm("是否绑定企业卡?");
		//if(res){
			
		//}else{
			
		//}
		$('#form').data('bootstrapValidator').validate();  
        if(!$('#form').data('bootstrapValidator').isValid()){ 
            return ;  
        }  
		
		
		/* 保存企业信息 */
			 var data = new FormData($("#form")[0]);
			$.ajax({
				url:'<%=path%>/yundongjia/saveenterprise',
				type:'post',
				dataType:'json',
				data:data,
				async: false,
	            cache: false,
	            contentType: false,
	            processData: false,
				success:function(result){
					//记录企业id
					$("#enterpriseId").val(result);
					$("#one").hide();
					$("#tow").show(); 
				}
			}); 
			 
	}
	/* 绑定企业卡-确定 */
	function selectCardTypeOk(){
		//$("#echo").html("");
		//采购价
		var procMoney = $("#procMoney").val();
		var payMethod = $("#cardOrderMethod").val();
		var typeCardId  = -1;
		var typeHtml = "";
		var ids =  $("#typelist [name=cardTypeId]");
		if(ids.length > 0){
			for(var i =0 ; i<ids.length;i++){
				if(ids[i].checked){
					typeCardId = ids[i].value; 
				}
			}
		}
		/* 把这个类型查询出来展示 */
		if(typeCardId > -1){/* 绑了卡 */
			var reg=/^\d+$/;
			//验证采购价
			if(!reg.test(procMoney)){
				alert("采购金额须添数字");
				return false;
			}else{
				$("#echo").html("");
				/* 保存卡 */
				var enterpriseId = $("#enterpriseId").val();
				var t=new Date().valueOf();
				$.ajax({
					url:'<%=path%>/yundongjia/savecardorder',
					type:'post',
					dataType:'json',
					data:{
						cardTypeId:typeCardId,
						enterpriseId:enterpriseId,
						money:procMoney,
						payMethod:payMethod,
						_time:t
					},
					success:function(result){
						
						//procMoney 收购价
						//var data={"procMoney":procMoney,"cardTypeId":typeCardId};
						//选择的数据回显
						$("#echo").html($("#cardTypeTheEcho").tmpl(result.message));
						
					}
				});
				
			}
			
		}else{
			
		}
		
		
		//关闭模态框
		$("#modal-container0").hide();
		$('.modal-backdrop').attr("hidden",true);
	}
	
	
	/* 保存之后去详情页面 */
	function locaDetail(){
		var t= new Date().valueOf();
		//企业id
		var id = parseInt($("#enterpriseId").val());
		$(".index-right").load('<%=path%>/yundongjia/detailenterprise?_time='+t+'&id='+id+'&tab=1');
	}
	
	
	
	</script>
</body>
</html>
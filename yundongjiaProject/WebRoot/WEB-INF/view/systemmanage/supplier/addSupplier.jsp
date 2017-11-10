<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<title>新增供应商</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
<style type="text/css">
	.paddingT{
	 	margin-top: 10px;
	}
</style>
</head>
<body>
	<div class="main-content" >
		<div class="page-header">
			当前位置：
			<a href="javascript:void(0)" >新增供应商</a>
		</div>
		<div>
			 <form id="formInfo" name="form1"   onsubmit="return false;"  method="post">
			 		<input name="rowid"  type="hidden" value="${supplier.rowid }" />
					<div class="page-1" >
						<div class="col-md-12">
							<div class="col-md-1 padding0L">
								供应商名称：
							</div>
							<div class="col-md-3 padding0L form-group">	
								<input name="suppliername"  class="form-control"  placeholder="请输入供应商名称"  value="${supplier.suppliername }"/>
							</div>  			
							<label class="xing">*</label>  			
						</div>
						<div class="col-md-12">
							<div class="col-md-1 padding0L">
								联系方式：
							</div>
							<div class="col-md-1 padding0L form-group">
								<input name="linkmanname"  class="form-control"  placeholder="姓名"  value="${supplier.linkmanname }"/>
							</div>	
							<div class="col-md-2 padding0L form-group" style="margin-left: 0px;">
								<input name="mobilephonenum"  class="form-control"  placeholder="联系人手机号"  value="${supplier.mobilephonenum }"/>
							</div>	
							<label class="xing">*</label>
						</div>
						<div class="col-md-12">
							<div class="col-md-1 padding0L">
								所在城市：
							</div>
							<div class="col-md-1 padding0L form-group">
								<select id="province" name="province" 
									class="form-control btn btn-default">
									<option value="-1">省</option>
									<c:forEach items="${pros}"  var="pro">
										<option <c:if test="${pro.code == supplier.regionsid }">selected="selected"</c:if> value="${pro.code}">${pro.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-1 padding0L form-group">
								<select id="city" name="city"
									class="form-control btn btn-default">
									<option value="-1">市</option>
									<c:if test="${tab == -1 }">
										<option value="${city.code}" selected="selected">${city.name}</option>
									</c:if>
								</select>
							</div>
							<div class="col-md-1 padding0L form-group">
								<select id="area" name="regionsid"
									class="form-control btn btn-default">
									<option value="-1">区</option>
									<c:if test="${tab == -1 }">
										<option  value="${area.code}" selected="selected">${area.name}</option>
									</c:if>	
								</select>
							</div>
							<label class="xing">*</label>  	
						</div>
						<div class="col-md-12">
							<div class="col-md-1 padding0L">
								详细地址：
							</div>
							<div class="col-md-3 padding0L form-group">	
								<input name="address"  class="form-control"  placeholder="请输入地址信息"  value="${supplier.address }">
							</div>  			
							<label class="xing">*</label>  			
						</div>
						<div class="col-md-12">
							<div class="col-md-1 padding0L">
								结算模式：
							</div>
							
							<div class="col-md-4 padding0L form-group">	
								<div class="col-md-6 padding0L ">
										<input <c:if test="${supplier.clearingtype==0 }">checked="checked" </c:if> type="radio"  name="clearingtype"  value="0"  onchange="unPeriod();" />预付
										<input <c:if test="${supplier.clearingtype==1 }">checked="checked" </c:if>  type="radio" name="clearingtype"  value="1"  style="margin-left: 15px;" onchange="period();" />周期结算					
								</div>
								<div class="col-md-4 padding0L" style="margin-left: -20px;">
									 <select id="canclelimit"  <c:if test="${supplier.clearingtype !=1 }">disabled="disabled"</c:if>  name="periodclearing" class="form-control btn btn-default">
										<option <c:if test="${supplier.periodclearing==0 }">selected="selected"</c:if> value="0" >每天</option>
										<option <c:if test="${supplier.periodclearing==1 }">selected="selected"</c:if> value="1">每周</option>
										<option <c:if test="${supplier.periodclearing==2 }">selected="selected"</c:if> value="2">每月</option>
										<option <c:if test="${supplier.periodclearing==3 }">selected="selected"</c:if> value="3">每季度</option>
										<option <c:if test="${supplier.periodclearing==4 }">selected="selected"</c:if> value="4">每年</option>
									</select>
								</div>
								<label class="xing">*</label> 		
							</div> 
						</div>
						<div class="col-md-8">
							<div class="col-md-offset-1 col-md-1">
				  				<input type="reset" class="btn btn-default bcColor"  value="重置" />
				  			</div>
						  	<div class="form-group col-md-offset-1 col-md-1">
				  				<input type="button" class="btn btn-default bcColor"  onclick="showPage2();" value="提交" />
				  			</div>
				  		</div>
					</div>
					<div class="page-2"  hidden="hidden">
							<table class="table"  rules="cols" frame="box">
						     	<thead>
						     	 <tr>
						     		<th width="15%">关联</th>
						     		<th></th>
						     	</tr>
						     	</thead>
						     	<tbody  id="statisTbody"  class="font-size-weight">
						     		<tr>
							     		<td><div class="paddingT">场馆</div></td>
							     		<td>
							     			<div class="col-md-1">
							     					<input type="button" class="btn btn-default"  value="增加"  data-toggle="modal" data-target="#studioModel"  onclick="searchStudio(1);" />
							     			</div>
							     			<div class="col-md-11 paddingL20" id="likeStudio">
							     					<table   class="table" style="max-width: 60%;" rules="cols" frame="box">
												     	<thead>
												     	 <tr>
												     		<th style="color: black;">场馆名称</th>	
												     		<th style="color: black;">操作</th>
												     	</tr>
												     	</thead>
												     	<tbody  id="studioTable"  class="font-size-weight">
												     		<c:forEach items="${supplier.info.studio }"  var="info">
												     		     <tr>
												     		     	<td>${info.name }      
													     		     	<input name="studioOpenTime" value="09:30~21:30" type="hidden">      
													     		     	<input name="studioId" value="${info.id }" type="hidden">      
													     		     	<input name="studioPrice" studioprice="studioPrice-${info.id }" value="${info.money }" type="hidden">   
													     		      </td>    
													     		      <td>     
													     		      	<a href="javascript:void(0)" data-toggle="modal" data-target=".bs-example-modal-sm" class="offer" onclick="savePrice(this,'${info.id }',1);">已报价</a>     
													     		      	<a href="javascript:void(0)" onclick="delBand(this);">删除</a>    
													     		      </td>    
												     		     </tr>
												     		</c:forEach>     
												     	</tbody>
												     </table>
							     			</div>
							     		</td>
							     	</tr>
							     	<tr>
							     		<td><div class="paddingT">私教</div></td>
							     		<td>
							     			<div class="col-md-1">
							     					<input type="button" class="btn btn-default" data-toggle="modal" data-target="#coachModel"   value="增加"  onclick="searchCoach(1);" />
							     			</div>
							     			<div class="col-md-11 paddingL20" id="likePrivate">
							     					<table   class="table"  style="max-width: 60%;" rules="cols" frame="box">
												     	<thead>
												     	 <tr>
												     		<th style="color: black;">教练名称</th>	
												     		<th style="color: black;">操作</th>
												     	</tr>
												     	</thead>
												     	<tbody  id="privateTbody"  class="font-size-weight">
												     		<c:forEach items="${supplier.info.coach }"  var="info">
												     				<tr>	
																	     <td>${info.name }      
																	     	<input name="opentime" value="" type="hidden">      
																	     	<input name="coachId" value="${info.id }" type="hidden">      
																	     	<input name="coachPrice" coachprice="coachPrice-${info.id }" value="${info.money }" type="hidden">    
																	     </td>    
																	     <td>    
																	     	 <a href="javascript:void(0)" data-toggle="modal" data-target=".bs-example-modal-sm" class="offer" onclick="savePrice(this,'${info.id }',2);">已报价</a>     
																	     	 <a href="javascript:void(0)" onclick="delBand(this);">删除</a>    
																	     </td>    
																 	<tr>
												     		</c:forEach>
												     	</tbody>
												     </table>
							     			</div>
							     		</td>
							     	</tr>
							     	<tr>
							     		<td><div class="paddingT">商品</div></td>
							     		<td id="likeStudio">
							     			<div class="col-md-1">
							     					<input type="button" class="btn btn-default"  data-toggle="modal" data-target="#goodsModel"  value="增加"  onclick="searchGoods();" />
							     			</div>
							     			<div class="col-md-11 paddingL20" id="likeGoods">
							     					<table   class="table" style="max-width: 60%;" rules="cols" frame="box">
												     	<thead>
												     	 <tr>
												     		<th style="color: black;">商品名称</th>	
												     		<th style="color: black;">操作</th>
												     	</tr>
												     	</thead>
												     	<tbody  id="goodsTbody"  class="font-size-weight">
												     		<c:forEach items="${supplier.info.goods }"  var="info">
												     				<tr>	
																		     <td>${info.name }   
																			     <input name="opentime" value="" type="hidden">     
																			     <input name="goodsId" value="${info.id }" type="hidden">      
																			     <input name="goodsPrice" goodsprice="goodsPrice-${info.id }" value="${info.money }" type="hidden">    
																		     </td>    
																		     <td>     
																		     	<a href="javascript:void(0)" data-toggle="modal" data-target=".bs-example-modal-sm" class="offer" onclick="savePrice(this,'${info.id }',3);">已报价</a> 
																		     	<a href="javascript:void(0)" onclick="delBand(this);">删除</a>    
																		     </td>    
																 	<tr>
												     		</c:forEach>
												     	</tbody>
												     </table>
							     			</div>
							     		</td>
							     	</tr>
							     	<tr>
							     		<td><div class="paddingT"></div></td>
							     		<td id="likeStudio">
							     			<div class="col-md-offset-3 col-md-1">
							     					<input type="button" class="btn btn-default bcColor"  value="返回"  onclick="hiddenPage2();" />
							     			</div>
							     			<div class="col-md-offset-1 col-md-1">
							     					<input type="button" class="btn btn-default bcColor"  value="完成"  onclick="subForm();" />
							     			</div>
							     		</td>
							     	</tr>
						     	</tbody>
						  </table>
					</div>
			</form>
		</div>	
	</div>
	
	
	<!-- Modal -->
<div class="modal fade" id="studioModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">选择场馆</h4>
      </div>
      <div class="modal-body">
      		<div class="col-md-12 padding0L">
					<div class="col-md-9 padding0L">
						<div class="form-group col-md-9 padding0L">
							<input placeholder="请输入场馆名" class="form-control" type="text" id="search_1"/>
						</div>
						<button type="button" class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor"  onclick="searchStudio(1);">搜索</button>
					</div>
				</div>	
        	<table   class="table"  rules="cols" frame="box">
		     	<thead>
		     	 <tr>
		     		<th>选择</th>	
		     		<th>场馆ID</th>
		     		<th>场馆类型</th>
		     		<th>所在城市</th>
		     		<th>场馆名称</th>
		     		<th>状态</th>
		     	</tr>
		     	</thead>
		     	<tbody  id="studioTbody"  class="font-size-weight">
		     		
		     	</tbody>
		     </table>
		     <div class="main-content-footer">
				<div class="page" id="pageStudio">
					
				</div>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary bcColor" onclick="affirmStudio();">确认</button>
      </div>
    </div>
  </div>
</div>



<div class="modal fade bs-example-modal-sm" id="fromPrice" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content" style="height: 100px;">
    	<div style="margin-top: 15px;">
	     	<div class="col-md-5" style="margin-top: 5px;">
	     		请输入报价 ： 
	     	</div>
	     	<div class="col-md-7">
	     		<input class="form-control"  name="publicPrice"  placeholder="请输入报价" >
	     	</div>	
	     	<input type="hidden"  id="price">
     	</div>
     	<div>
	     	<div class="col-md-offset-1 col-md-4"  style="padding-top: 15px;">
	     		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	     	</div>
	     	<div class="col-md-offset-2 col-md-4" style="padding-top: 15px;">
	        	<button type="button" class="btn btn-primary bcColor" onclick="affirmPrice();">确认</button>
	        </div>
        </div>
    </div>
  </div>
</div>


<div class="modal fade" id="coachModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">选择教练</h4>
      </div>
      <div class="modal-body">
      		<div class="col-md-12 padding0L">
					<div class="col-md-9 padding0L">
						<div class="form-group col-md-9 padding0L">
							<input placeholder="请输入教练名" class="form-control" type="text" id="search_2"/>
						</div>
						<button type="button" class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor"  onclick="searchCoach(1);">搜索</button>
					</div>
				</div>	
        	<table   class="table"  rules="cols" frame="box">
		     	<thead>
			     	 <tr>
			     		<th>选择</th>	
			     		<th>教练ID</th>
			     		<th>性别</th>
			     		<th>工作年限</th>
			     		<th>所在城市</th>
			     		<th>教练名称</th>
			     		<th>状态</th>
			     	</tr>
		     	</thead>
		     	<tbody  id="coachbody"  class="font-size-weight">
		     		
		     	</tbody>
		     </table>
		     <div class="main-content-footer">
				<div class="page" id="pageCoach">
					
				</div>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary bcColor" onclick="affirmCoach();">确认</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="goodsModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">选择商品</h4>
      </div>
      <div class="modal-body">
      		<div class="col-md-12 padding0L">
					<div class="col-md-9 padding0L">
						<div class="form-group col-md-9 padding0L">
							<input placeholder="请输入商品名" class="form-control" type="text" id="search_3"/>
						</div>
						<button type="button" class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor"  onclick="searchGoods(1);">搜索</button>
					</div>
				</div>	
        	<table   class="table"  rules="cols" frame="box">
		     	<thead>
			     	 <tr>
			     		<th>选择</th>	
			     		<th>商品ID</th>
			     		<th>商品价格</th>
			     		<th>商品名称</th>
			     		<th>状态</th>
			     	</tr>
		     	</thead>
		     	<tbody  id="goodsbody"  class="font-size-weight">
		     		
		     	</tbody>
		     </table>
		     <div class="main-content-footer">
				<div class="page" id="pageGoods">
					
				</div>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary bcColor" onclick="affirmGoods();">确认</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/gym/My97DatePicker/WdatePicker.js"></script>	
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/region.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/x-javascript-tmpl" id="cityTmpl">
	<option value="{{= code}}">{{= name}}</option>
</script>
<script type="text/x-javascript-tmpl" id="affirmTable">
 		<tr>	
			<td>
					{{= name}}
					<input type="hidden"   name="opentime" value="{{= openTime}}">
					<input type="hidden"   name="id" value="{{= id}}">
					<input type="hidden"   name="money">
			</td>
			<td>
				<a href="javascript:void(0)"  data-toggle="modal" data-target=".bs-example-modal-sm" class="offer" onclick="savePrice(this,'{{= id}}',{{= status}});">报价</a>
				<a href="javascript:void(0)"  onclick="delBand(this);">删除</a>
			</td>
	 	<tr>
</script>
<script type="text/x-javascript-tmpl" id="tableModel">
		 <tr>
			<td><input type="checkbox" class="checkec_studio" studioId="{{= studioId}}"  studioName="{{= studioName}}"   studioOpentime="{{= studioOpentime}}"></td>
			<td>{{= studioId}}</td>
			<td>{{= type}}</td>
			<td>{{= city}}</td>
			<td>{{= studioName}}</td>
			<td>{{= status}}</td>	
		 <tr>
</script>
<script type="text/x-javascript-tmpl" id="coachModelInfo">
		 <tr>
			<td><input type="checkbox" class="checkec_coach" coachId="{{= coachId}}"  nickName="{{= nickName}}" ></td>
			<td>{{= coachId}}</td>
			<td>{{= gender}}</td>
			<td>{{= workAge}}</td>
			<td>{{= city}}</td>
			<td>{{= nickName}}</td>
			<td>{{= status}}</td>	
		 <tr>
</script>
<script type="text/x-javascript-tmpl" id="goodsModelInfo">
		 <tr>
			<td><input type="checkbox" class="checkec_goods" goodsId="{{= goodsId}}"  gName="{{= gName}}" ></td>
			<td>{{= goodsId}}</td>
			<td>{{= gPrice}}</td>
			<td>{{= gName}}</td>
			<td>{{= status}}</td>	
		 <tr>
</script>
<script type="text/javascript">
	var link = "<%=path%>/";
	function showPage2(){
		//验证表单后展示
		$('#formInfo').data('bootstrapValidator').validate();  
        if(!$('#formInfo').data('bootstrapValidator').isValid()){ 
            return ;  
        }  
		$(".page-1").hide();
		$(".page-2").show();
	}
	
	function hiddenPage2(){
		$(".page-2").hide();
		$(".page-1").show();
	}
	//验证表单
	$(function(){
		$('#formInfo').bootstrapValidator({
			fields : {
				suppliername : {
					validators: {
						notEmpty : {
							message : '供应商名称不能为空'
						},
						stringLength: {
			                 min:0,
			                 max: 50,
			                 message: '供应商名称长度必须在0到50之间'
			             },
					}
				},
				linkmanname : {
						validators: {
							notEmpty : {
								message : '姓名不能为空'
							},
							stringLength: {
				                 min:0,
				                 max: 50,
				                 message: '姓名长度必须在0到10之间'
				             },
						}
					},
				mobilephonenum :{
						validators : {
							notEmpty : {
								message : '手机号不能为空'
							},
							 stringLength: {
				                 min: 11,
				                 max: 11,
				                 message: '请输入11位手机号码'
				             },
		                     regexp: {
				                 regexp: /^1[3|5|4||7|8]{1}[0-9]{9}$/,
				                 message: '请输入正确的手机号码'
				             },
						}
					},
				province :{
						validators : {
							callback : {
								message : "请选择有效的省份",
								callback : function(value){
									if(value == -1){
										return false;
									}else{
										return true;
									}
								}
							}	
						}
					},
				city :{
						validators : {
							callback : {
								message : "请选择有效的城市",
								callback : function(value){
									if(value == -1){
										return false;
									}else{
										return true;
									}
								}
							}	
						}
					},
				regionsid :{
						validators : {
							callback : {
								message : "请选择有效的区县",
								callback : function(value){
									if(value == -1){
										return false;
									}else{
										return true;
									}
								}
							}	
						}
					},
				savemoney :{
					validators : {
						notEmpty : {
							message : '预存金额不能为空'
						},
						regexp: {
			                 regexp: /^[0-9.]+$/,
			                 message: '请输入正确的金额数'
			             },
					}
				},
				savemoneyexpiredate :{
					validators : {
						notEmpty : {
							message : '到期日期不能为空'
						},
					}
				},
				address : {
					validators: {
						notEmpty : {
							message : '详细地址不能为空'
						},
						stringLength: {
			                 min:0,
			                 max: 300,
			                 message: '地址长度必须在0到300之间'
			             },
					}
				},
			}
		});
	});
	
	//提交查询
	function subForm(){
		/*手动验证表单，当是普通按钮时。*/  
		$('#formInfo').data('bootstrapValidator').validate();  
        if(!$('#formInfo').data('bootstrapValidator').isValid()){ 
            return ;  
        }  
        /* var b = false;
        for(var i = 0; i < $("input[name='regions_id']").length; i++){
        	if($("input[name='regions_id']").eq(i).is(":checked")){
        		b = true;
        	}
        }
        if(!b){
        	alert("请选择覆盖城市！");
        	return;
        } */
        for(var i = 0; i < $(".offer").length; i++){
        	if("报价" == $(".offer").eq(i).html()){
        		alert("请为绑定的资源填写报价");
            	return;
        	}
        }
		//获取表单信息
		var data = new FormData($('#formInfo')[0]);
		$.ajax({
			url : "<%=path%>/yundongjia/insertSupplier",
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
					maincontent.load('<%=path%>/yundongjia/supplierDetail?tab=1&id=' + data.rowId);
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		});		
	}
	
	function unPeriod(){
		$("#canclelimit").attr("disabled" , "disabled");
		$("#canclelimit").removeAttr("name");
	}
	function period(){
		$("#canclelimit").removeAttr("disabled");
		$("#canclelimit").attr("name" , "canclelimit");
	}
	function searchStudio(page){
		var searchInfo = $("#search_1").val();
		$.ajax({
			url : "<%=path%>/yundongjia/findNoBandStudioList",
			type: 'POST',  
            data: {
            	"pageNum":page,
            	"searchInfo":searchInfo
            	},
            dataType: 'JSON',  
            async : false,
   			cache: false,  
			success : function(data){
				if(data.result){
					$("#studioTbody").html($("#tableModel").tmpl(data.pi.list));
					paging("pageStudio", "searchStudio", data.pi);
				}else{
					alert(data.message);
				}
			}
		});	
	}
	function affirmStudio(){
		for(var i = 0; i < $(".checkec_studio").length; i++){
			if($(".checkec_studio").eq(i).is(":checked")){
				var date ={
						"openTime":$(".checkec_studio").eq(i).attr("studioopentime"),
						"id":$(".checkec_studio").eq(i).attr("studioId"),
						"name" :$(".checkec_studio").eq(i).attr("studioName"),
						"status":1
				}
				$("#studioTable").append($("#affirmTable").tmpl(date));
				$("input[name='opentime']").attr("name", "studioOpenTime");
				$("input[name='id']").attr("name", "studioId");
				$("input[name='money']").attr("studioPrice", "studioPrice-"+$(".checkec_studio").eq(i).attr("studioId"));
				$("input[name='money']").attr("name", "studioPrice-"+$(".checkec_studio").eq(i).attr("studioId"));
			}		
		}
		$('#studioModel').hide();
		$('.modal-backdrop').attr("hidden",true);
	}
	
	function savePrice(obj , id , status){
		switch (status) {
		case 1:
			$("#price").val("studioPrice-"+id);
			break;
		case 2:
			$("#price").val("coachPrice-"+id);		
			break;
		case 3:
			$("#price").val("goodsPrice-"+id);		
			break;
		}
	}
	function delBand(obj){
		$(obj).parent().parent().remove();
	}
	
	function affirmPrice(){
		var pri = $("input[name='publicPrice']").val();
		var reg = /^[0-9.]+$/;
		if(!reg.test(pri)){
			alert("请输入正确的数字格式");
			return ;
		}
		var inputName = $("#price").val();
		$("input["+ inputName.split("-")[0] +"='"+ inputName +"']").val($("input[name='publicPrice']").val());
		$("input["+ inputName.split("-")[0] +"='"+ inputName +"']").parent().next().children().eq(0).html("已报价");
		$("#fromPrice").hide();
		$('.modal-backdrop').attr("hidden",true);
		$("input["+ inputName.split("-")[0] +"='"+ inputName +"']").attr("name" ,inputName.split("-")[0]);
		$("input[name='publicPrice']").val("");
	}
	
	function searchCoach(page){
		var searchInfo = $("#search_2").val();
		$.ajax({
			url : "<%=path%>/yundongjia/findNoBandCoach",
			type: 'POST',  
            data: {
            	"pageNum":page,
            	"searchInfo":searchInfo
            	},
            dataType: 'JSON',  
            async : false,
   			cache: false,  
			success : function(data){
				if(data.result){
					$("#coachbody").html($("#coachModelInfo").tmpl(data.pi.list));
					paging("pageCoach", "searchCoach", data.pi);
				}else{
					alert(data.message);
				}
			}
		});	
	}
	
	function affirmCoach(){
		for(var i = 0; i < $(".checkec_coach").length; i++){
			if($(".checkec_coach").eq(i).is(":checked")){
				var date ={
						"openTime":"",
						"id":$(".checkec_coach").eq(i).attr("coachId"),
						"name" :$(".checkec_coach").eq(i).attr("nickName"),
						"status":2
				}
				$("#privateTbody").append($("#affirmTable").tmpl(date));
				$("input[name='id']").attr("name", "coachId");
				$("input[name='money']").attr("coachPrice", "coachPrice-"+$(".checkec_coach").eq(i).attr("coachId"));
				$("input[name='money']").attr("name", "coachPrice-"+$(".checkec_coach").eq(i).attr("coachId"));
			}		
		}
		$('#coachModel').hide();
		$('.modal-backdrop').attr("hidden",true);
	}
	
	function searchGoods(page){
		var searchInfo = $("#search_3").val();
		$.ajax({
			url : "<%=path%>/yundongjia/findNoBandGoods",
			type: 'POST',  
            data: {
            	"pageNum":page,
            	"searchInfo":searchInfo
            	},
            dataType: 'JSON',  
            async : false,
   			cache: false,  
			success : function(data){
				if(data.result){
					$("#goodsbody").html($("#goodsModelInfo").tmpl(data.pi.list));
					paging("pageGoods", "searchGoods", data.pi);
				}else{
					alert(data.message);
				}
			}
		});	
	}
	
	function affirmGoods(){
		for(var i = 0; i < $(".checkec_goods").length; i++){
			if($(".checkec_goods").eq(i).is(":checked")){
				var date ={
						"openTime":"",
						"id":$(".checkec_goods").eq(i).attr("goodsId"),
						"name" :$(".checkec_goods").eq(i).attr("gName"),
						"status":3
				}
				$("#goodsTbody").append($("#affirmTable").tmpl(date));
				$("input[name='id']").attr("name", "goodsId");
				$("input[name='money']").attr("goodsPrice", "goodsPrice-"+$(".checkec_goods").eq(i).attr("goodsId"));
				$("input[name='money']").attr("name", "goodsPrice-"+$(".checkec_goods").eq(i).attr("goodsId"));
			}		
		}
		$('#goodsModel').hide();
		$('.modal-backdrop').attr("hidden",true);
	}
</script>
</body>
</html>
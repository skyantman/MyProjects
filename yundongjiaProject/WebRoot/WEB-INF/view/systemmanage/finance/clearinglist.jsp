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
<title>结算列表</title>
<style type="text/css">

</style>
</head>
<body>
<div class="page-header">
	当前位置：<a href="javascript:void(0);">结算列表 </a>
</div>
<div class="main-content-inquire" >
   <div class="main-content-item" style="padding: 0px;">
	  <table class="table" style="width: 80%;" rules="cols" frame="box">
	  	<thead>
	  		<tr>
	  			<th>结算总金额</th>
	  			<th>已结算金额</th>
	  			<th>待结算金额</th>
	  			<th>需审批订单数</th>
	  			<th>今日新增订单数</th>
	  		</tr>
	  	</thead>
	  	<tbody class="font-size-weight">
	  		<tr>
	  			<td>${statis.sumOrderMoneyNumber }</td>
	  			<td>${statis.yjsOrderMoneyNumber }</td>
	  			<td>${statis.djsOrderMoneyNumber }</td>
	  			<td>${statis.djsOrderNumber }</td>
	  			<td>${statis.todayInteger }</td>
	  		</tr>
	  	</tbody>
	  </table>
   </div>


	<div class="col-md-12 padding0L" style="padding-top: 1%;">
	   <form id="searchform" name="searchform" onsubmit="return false;"  method="post">
				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">结算日期：</div>
					<div class="form-group col-md-2 padding0L">
						<input id="startTime"  name="startTime" size="16"
							readonly="readonly" type="text"
							onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="开始日期" />

					</div>


					<div class="form-group col-md-2 padding0L">
						<input id="endTime" name="endTime" size="16"
							readonly="readonly" type="text"
							onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="结束日期" />

					</div>
				</div>

				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">供应商名称：</div>
					<div class="form-group col-md-4 padding0L">
						<input placeholder="请输入供应商名称" class="form-control" type="text"
							id="supplierName" value="" name="supplierName" />
					</div>
				</div>

				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">商品名称：</div>
					<div class="form-group col-md-4 padding0L">
						<input placeholder="请输入场馆、教练、商品名称" class="form-control" type="text"
							id="contextName" name="contextName" value=""/>
					</div>
				</div>
				<div class="col-md-12 padding0L">
			   <div class="form-group col-md-2 padding0L">结算状态:</div>
					<div class="form-group col-md-4 padding0L">
						<select id="orderStatus" name="orderStatus" class="form-control btn btn-default">
							<option value="-1">全部</option>
							<option value="5">结算中</option>
							<option value="7">已结算</option>
							<option value="8">已取消</option>
						</select>
					</div>
				</div>
				<div class="col-md-12 padding0L">
					<div class="col-md-6">
					  <input type="hidden" name="pageNum" value="1">
					  
					  <button type="button"
					class="btn btn-default col-md-offset-8 col-md-2 bcColor" onclick="searchForm(1,false);">搜索</button>
					</div>
				  <!--  <div class="col-md-6">
				     <button type="button"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor" >导出Excel</button>
				   </div> -->
					
					 
				</div>
			</form>
	</div>
	<div class="main-content-item">
		<table class="table" rules="cols" frame="box">
			<thead>
				<tr>
					<!-- <th>结算订单ID</th> -->
					<th>结算金额(元)</th>
					<th>供应商名称</th>
					<th>订单ID</th>
					<th>商品名称</th>
					<th>结算日期</th>
					<th>订单状态</th>
					<th>结算模式</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="cOrderTbody">
				<c:forEach items="${os.list }" var="o">
				
				  <tr>
					<td>${o.price }</td>
					<td>${o.supplierName }</td>
					<td>${o.orderNum }</td>
					<td>${o.name }</td>
					<td>${o.retreatDate }</td>
					<td>
					<c:if test="${o.payStatus  == 5 }">结算中</c:if>
					
					<c:if test="${o.payStatus == 7 }">已结算</c:if>
					</td>
					<td>${o.clearingTypeName}</td>
					<td>
					<a href="javascript:void(0);" onclick="detail('${o.supplierId}','${o.orderTypeId}','${o.id}','${o.orderId}');">详情</a>
					&nbsp;&nbsp;
					
					
					<c:if test="${o.payStatus ==5 }">
					      <a href="javascript:void(0);" onclick="upAccount('${o.orderId}','${o.supplierId}','${o.orderTypeId }',7);">确定结算</a>
					</c:if>
					
					</td>
				</tr>
				  
				  
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="main-content-footer" style="padding-bottom: 1%;">
			<div class="page" id="page">
				
			
			</div>
		</div>
</div>

<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/gym/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/x-javascript-tmpl" id="clearOrderTmpl">

<tr>
					<td>{{= price }}</td>
					<td>{{= supplierName }}</td>
					<td>{{= orderNum }}</td>
					<td>{{= name }}</td>
					<td>{{= retreatDate }}</td>
					<td>

					{{if payStatus  == 5}}
结算中
					{{else payStatus == 7}}
已结算
					{{/if}}
					 
					</td>
					<td>{{= clearingTypeName}}</td>
					<td>
					<a href="javascript:void(0);" onclick="detail({{= supplierId}},{{= orderTypeId}},{{= id}},{{= orderId }});">详情</a>
					&nbsp;&nbsp;
					
					
					{{if payStatus ==5 }}
<a href="javascript:void(0);"  onclick="upAccount('{{= orderId}}','{{= supplierId}}','{{= orderTypeId }}',7);"   >确定结算</a>
					{{/if}}
					
					
					</td>
</tr>

</script>
<script type="text/javascript">
function pageInfoList(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/clearorderlist',{pageNum:pageNum,_time:t});
}
$(document).ready(function(){
	var pageNum = ${os.pageNum};
	var pages = ${os.pages};
	var pi={"pageNum":pageNum,"pages":pages};
	paging('page', 'pageInfoList', pi);
});
	/* 详情 */
	function detail(supplierId,orderType,studioId,orderId){
		var t=new Date().valueOf();
		$(".index-right").load('<%=path%>/yundongjia/clearorderdetail',{supplierId:supplierId,orderType:orderType,studioId:studioId,orderId:orderId,_time:t});
	}
	
	 function searchForm(pageNum,flag){
		if(flag){
			return false;
		}
		var data = new FormData($("#searchform")[0]);
		$.ajax({
			url:'<%=path%>/yundongjia/selectclearorderby',
			type:'post',
			dataType:'json',
			data : data,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success:function(data){
				$("#cOrderTbody").html($("#clearOrderTmpl").tmpl(data.list));
				pagingDemo('page', 'searchForm', data);
			}
		});
	}
/* 确定结算 */	 
function upAccount(orderId,rowId,orderTypeId,status){
	var t=new Date().valueOf();
	var result = confirm("确定结算吗?");
	if(!result){
		return false;
	}
	$.ajax({
		url:'<%=path%>/yundongjia/upaccount',
		type:'post',
		dataType:'json',
		data:{
			orderId:orderId,
			supplierId:rowId,
			orderTypeId:orderTypeId,
			status:status,
			_time:t
		},
		success:function(data){
			console.log(data);
			if(data.result > 0){
				
				alert(data.message);
				
				pageInfoList(1,false);
			}else{
				alert(data.message);
			}
		}
	});
}


</script>
</body>
</html>
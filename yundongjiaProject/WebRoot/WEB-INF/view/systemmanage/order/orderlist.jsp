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
<title>订单列表</title>
<link href="<%=path%>/static/css/gymcommon.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/static/css/gymstyle.css" rel="stylesheet"
	type="text/css">

<link href="<%=path%>/static/css/gymcss/style.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 订单列表 </a>
	</div>
	<div class="main-content-inquire" >
	  <div class="main-content-item" style="padding: 0px;">
	     <table class="table" style="max-width: 50%;" rules="cols" frame="box">
	     	<thead>
	     	 <tr>
	     		<th>订单总数</th>
	     		<th>订单总金额</th>
	     		<th>取消订单数</th>
	     		<th>今日新增订单</th>
	     	</tr>
	     	</thead>
	     	<tbody id="orderstatis" class="font-size-weight">
	     		<tr>
	     			<td>${orders.total}</td>
	     			<td>${statis.sumMoney }</td>
	     			<td>${statis.undoSum}</td>
	     			<td>${statis.daysOrders }</td>
	     		</tr>
	     	</tbody>
	     </table>
	     <!-- 搜索条件 -->
	     <div class="col-md-12 padding0L" style="padding-top: 1%;">
	       <form id="form" name="form1" onsubmit="return false;" method="post">
	       
	       <div class="col-md-12 padding0L">
	       	 <div class="form-group col-md-2 padding0L">
	       	 订单内容：
	       	 </div>
	       	 <div class="form-group col-md-6 padding0L">
	       	    <input placeholder="请输入订单内容" class="form-control" type="text"
						id="sourceContext" name="sourceContext"/>
	       	 </div>
	       </div>
	        <div class="col-md-12 padding0L">
	          <div class="form-group col-md-2 padding0L">
	       	 订单类型：
	       	 </div>
	       	 <div class="form-group col-md-3 padding0L">
	       	     <select class="form-control btn btn-default" name="orderType" id="orderType">
	       	     	<option value="-1" selected="selected">全部</option>
	       	     	<option value="0">商城</option>
	       	     	<option value="1">场馆</option>
	       	     	<option value="2">私课</option>
	       	     	<option value="3">课程</option>
	       	     	<option value="4">活动</option>
	       	     	<option value="5">个人卡</option>
	       	     </select>
	       	     
	       	 </div>
	       </div>
	        <div class="col-md-12 padding0L">
	        <div class="form-group col-md-2 padding0L">
	       	 订单状态：
	       	 </div>
	       	 <div class="form-group col-md-3 padding0L">
	       	     <select class="form-control btn btn-default" name="orderStatus" id="orderStatus">
	       	     	<option value="-1" selected="selected">全部</option>
	       	     	<option value="0">待支付</option>
	       	     	<option value="1">已取消</option>
	       	     	<option value="2">已支付</option>
	       	     	<option value="3">退订中</option>
	       	     	<option value="4">已退订</option>
	       	     	<option value="5">已完成</option>
	       	     </select>
	       	 </div>
	       </div>
	        <div class="col-md-12 padding0L">
	        <div class="form-group col-md-2 padding0L">
	       	创建日期：
	       	 </div>
	       	  <div class="form-group col-md-2 padding0L">
	       	     <input id="startTime" name="startTime" size="16" readonly="readonly" type="text" onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="开始日期" />
	       	   
	       	  </div>
	       	 
	     
	       	  <div class="form-group col-md-2 padding0L">
	       	     <input id="endTime" name="endTime" size="16" readonly="readonly" type="text" onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="结束日期" />
	       	  
	       	  </div>
	       </div>
	        <div class="col-md-12 padding0L">
	          <div class="form-group col-md-2 padding0L">
	       	手机号：
	       	 </div>
	       	 <div class="form-group col-md-6 padding0L">
	       	    <input placeholder="请输入手机号码" class="form-control" type="text"
						id="mobilePhoneNum" name="mobilePhoneNum" />
	       	 </div>
	       </div>
	        <div class="col-md-12 padding0L">
	        
	        <button type="button"
					class="btn btn-default col-md-offset-5 col-md-1 bcColor" onclick="search(1,false)">搜索</button>
					
			<button type="button" onclick="exportExcel(4)"
					class="btn btn-default col-md-offset-5 col-md-1 bcColor">导出Excel</button>		
	       </div>
	       
	        </form>
	     </div>
	     <div class="main-content-item">
	     	<table class="table" rules="cols" frame="box">
	     		<thead>
	     			<tr>
	     			 <th>订单ID</th>
	     			 <th>订单类型</th>
	     			 <th>订单内容</th>
	     			 <th>订单金额</th>
	     			 <th>用户</th>
	     			 <th>创建日期</th>
	     			 <th>订单来源</th>
	     			 <th>订单状态</th>
	     			 <th>短信状态</th>
	     			 <th>操作</th>
	     			</tr>
	     		</thead>
	     		<tbody id="orderTobdy">
	     			<c:forEach items="${orders.list}" var="o">
	     			   <tr>
	     			<td>${o.orderId}</td>
	     			<td>${o.orderTypeName}</td>
	     			<td style="width:100px;">${o.comm}</td>
	     			<td>${o.totalMoney}</td>
	     			<td>${o.mobilePhoneNum}</td>
	     			<td>${o.createDate }</td>
	     			<td>${o.sourceName}</td>
	     			<td>${o.orderStatusName}</td>
	     			<td>${o.messName}</td>
	     			<td>
	     			   <a href="javascript:void(0);" onclick="orderDetail(${o.orderId},${o.orderTypeId});">详情</a>
	     				&nbsp;&nbsp;
	     				
	     				<c:if test="${o.payStatus == 0}"><!-- 待支付 -->
	     			   	 <a href="javascript:void(0);" onclick="setStatus(${o.orderId},'${o.orderTypeName}',1);">取消订单</a>
	     			   	 &nbsp;&nbsp;
	     			   </c:if>
	     			   
	     			    <c:if test="${o.payStatus == 1}">已取消&nbsp;&nbsp;</c:if><!-- 已取消 -->
	     			    
	     			   <c:if test="${o.payStatus == 2}"><!-- 已支付 -->
	     			      <a href="javascript:void(0);" onclick="setStatus(${o.orderId},'${o.orderTypeName}',3);">退订</a>
	     			      &nbsp;&nbsp;
	     			   </c:if>
	     			   
	     			   <c:if test="${o.payStatus == 3}"><!-- 退订中 -->
	     			   	 <a href="javascript:void(0);" onclick="openModel(${o.orderId},'${o.orderTypeName}',4);">申请退款</a>
	     			   	 &nbsp;&nbsp;
	     			   	 <a href="javascript:void(0);" onclick="setStatus(${o.orderId},'${o.orderTypeName}',2);">取消退订</a>
	     			   	 &nbsp;&nbsp;
	     			   </c:if>
	     			   
	     			   <c:if test="${o.payStatus == 4}"><!-- 已退订 -->
	     			   	 已退订
	     			   
	     			   </c:if>
	     			   <c:if test="${o.payStatus == 5}">已完成</c:if><!-- 已完成 -->
	     			  	
	     			  	<!-- 除了商品订单 -->
	     			   <c:if test="${o.orderTypeId != 0}">
	     			   	      	<!-- 已支付或已完成的发送短信 -->
	     			   			<c:if test="${o.payStatus == 2 || o.payStatus == 5}">
	     			   			 
	     			              <a href="javascript:void(0);" onclick="sendMess(${o.orderTypeId},${o.orderId});">发送短信</a>
	     			               &nbsp;&nbsp;
	     			   	   		</c:if>
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
	
	</div>
	
	<!-- 退款模态框 -->
	<div id="statusModal" class="modal fade bs-example-modal-sm"
		tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- <div class="modal-header">
					 
					  <h4 class="modal-title">  </h4>
				</div> -->
				<div class="modal-body">
					<input type="hidden" id="id" value="">
					<input type="hidden" id="status" value="">
					<input type="hidden" id="typeName" value="">
					<div class="col-md-12" style="padding-top: 8%;">
					<div class="col-md-4 padding0L padding5T">理由：</div>
					</div>
					<div class="col-md-12">
						
						<div class="col-md-10 padding0L form-group">
							<textarea class="form-control" id="comm" name="comm" rows="6"
								cols="60"></textarea>
						</div>
					</div>
					
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="setRefundStatus();">确定</button>
				</div>
			</div>
		</div>
	</div>	
	
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/gym/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>
<script type="text/x-javascript-tmpl" id="orderTmpl">
<tr>
	     			<td>{{= orderId}}</td>
	     			<td>{{= orderTypeName}}</td>
	     			<td>{{= comm}}</td>
	     			<td>{{= totalMoney}}</td>
	     			<td>{{= mobilePhoneNum}}</td>
	     			<td>{{= createDate }}</td>
	     			<td>{{= sourceName}}</td>
	     			<td>{{= orderStatusName}}</td>
	     			<td>{{= messName}}</td>
<td>
	     			   <a href="javascript:void(0);" onclick="orderDetail({{= orderId}},{{= orderTypeId}});">详情</a>
	     				&nbsp;&nbsp;
{{if payStatus == 0 }}
<a href="javascript:void(0);" onclick="setStatus({{= orderId}},'{{= orderTypeName}}',1);">取消订单</a>
&nbsp;&nbsp;
{{/if}}

{{if payStatus == 1}}
已取消 &nbsp;&nbsp;
{{/if}}
{{if payStatus == 2}}
<a href="javascript:void(0);" onclick="setStatus({{= orderId}},'{{= orderTypeName}}',3);">退订</a>
&nbsp;&nbsp;
{{/if}}
{{if payStatus == 3}}
 <a href="javascript:void(0);" onclick="openModel({{= orderId}},'{{= orderTypeName}}',4);">申请退款</a>
	&nbsp;&nbsp;
 <a href="javascript:void(0);" onclick="setStatus({{= orderId}},'{{= orderTypeName}}',2);">取消退订</a>
&nbsp;&nbsp;
	     			 
{{/if}}
{{if payStatus == 4}}已退订&nbsp;&nbsp;{{/if}}
{{if payStatus == 5}}已完成&nbsp;&nbsp;{{/if}}

{{if orderTypeId != 0}}						
  {{if payStatus == 2 || payStatus == 5}}
       &nbsp;&nbsp;
	   <a href="javascript:void(0);" onclick="sendMess({{= orderTypeId}},{{= orderId}});">发送短信</a>
  {{/if}}	     			
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
	$(".index-right").load('<%=path%>/yundongjia/listorder?pageNum='+pageNum+'&_time='+t);
}
$(document).ready(function(){
	var pages = ${orders.pages};
	var pageNum = ${orders.pageNum};
	var pi={"pageNum":pageNum,"pages":pages};
	paging('page', "pageInfoList", pi);
});
/* 订单详情 */
function orderDetail(orderId,orderType){
	//订单类型，订单ID
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/getorderbyid?orderId='+orderId+'&orderType='+orderType+'&_time='+t);
}
//多条件查询
function search(pageNum,flag){
	if(flag){
		return false;
	}
	var data = new FormData($("#form")[0]);
	$.ajax({
		url:'<%=path%>/yundongjia/selectOrderByOrder',
		type : 'post',
		dataType : 'json',
		data : data,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			$("#orderTobdy").html($("#orderTmpl").tmpl(result.list));
			paging('page','search',result);
		}
	});

}
//打开模态框
function openModel(oId,oTypeName,status){
	$("#id").val(oId);
	$("#status").val(status);
	$("#typeName").val(oTypeName);
	$("#statusModal").modal('show');
}
//设置退款状态
function setRefundStatus(){
	var id = $("#id").val();
	var status = $("#status").val();
	var tn = $("#typeName").val();
	var comm = $("#comm").val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/updateorderstatus',
		type:'post',
		dataType:'json',
		data:{
			orderId:id,
			typeName:tn,
			status:status,
			comm:comm,
			_time:t
		},
		success:function(data){
			if(data > 0){
				$('#statusModal').modal('hide');
		        $('.modal-backdrop').attr("hidden",true);
		        pageInfoList(1,false);
			}
		}
	});
}
//修改订单状态
function setStatus(oId,oTypeName,status){
	var arg="确定[";
	var content="";
	switch (status) {
	case 0:
		
		break;
	case 1://取消
		content="取消";
		break;
	case 2:
		content="取消退订";
		break;
	case 3://退订
		content="退订";
		break;
	default:
		break;
	}
	var end="订单]操作吗?";
	arg+=content+=end;
	var flag = confirm(arg);
	if(flag){
		var t=new Date().valueOf();
		$.ajax({
			url:'<%=path%>/yundongjia/updateorderstatus',
			type:'post',
			dataType:'json',
			data:{
				orderId:oId,
				typeName:oTypeName,
				status:status,
				_time:t
			},
			success:function(data){
				if(data > 0){
					alert("操作成功");
			        pageInfoList(1,false);
				}else{
					alert("操作失败");
				}
			}
		});
	}else{
		
	}
}
/* 发送短信 */
function sendMess(orderType,orderId){
	var flag = confirm("确定发送短信吗?");
	if(!flag){
		return false;
	}
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/sendordermessage',
		type:'post',
		dataType:'json',
		data:{
			orderType:orderType,
			orderId:orderId,
			_time:t
				
		},
		success:function(data){
			if(data.status > 0){
				alert(data.message);
			}else{
				alert(data.message);
			}
		}
	});
}
</script>	
</body>
</html>
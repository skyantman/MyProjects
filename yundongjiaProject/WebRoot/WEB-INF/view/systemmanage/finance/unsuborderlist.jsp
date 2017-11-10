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
<title>退订列表</title>
</head>
<body>
<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 退订列表 </a>
</div>
<div class="main-content-inquire" >
	  <div class="main-content-item" style="padding: 0px;">
	     <table class="table" style="max-width: 50%;" rules="cols" frame="box">
	     	<thead>
	     	 <tr>
	     		<th>订单总数</th>
	     		<th>退款总金额</th>
	     		<th>未退款总金额</th>
	     	</tr>
	     	</thead>
	     	<tbody id="orderstatis" class="font-size-weight">
	     		<tr>
	     			<td>${orders.total}</td>
	     			<td>${statis.totalRefunded }</td>
	     			<td>${statis.unTotalRefunded}</td>
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
	       	     	<option value="3">退订中</option>
	       	     	<option value="4">已退款</option>
	       	     </select>
	       	 </div>
	       </div>
	        <div class="col-md-12 padding0L">
	        <div class="form-group col-md-2 padding0L">
	       	退订日期：
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
					
			<button type="button" onclick="exportExcel(5);"
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
	     			 <th>退订日期</th>
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
	     			<td style="color:red;">${o.totalMoney}</td>
	     			<td>${o.mobilePhoneNum}</td>
	     			<td>${o.retreatDate }</td>
	     			<td>${o.sourceName}</td>
	     			<td>
	     			<!-- ${o.orderStatusName} -->
	     			<c:if test="${o.payStatus == 3}">退订中</c:if>
	     			<c:if test="${o.payStatus == 4 }">已退款</c:if>
	     			</td>
	     			<td>${o.messName}</td>
	     			<td>
	     			   <a href="javascript:void(0);" onclick="orderDetail(${o.orderId},${o.orderTypeId});">详情</a>
	     				&nbsp;&nbsp;
	     			  
	     			   <c:if test="${o.payStatus == 3}"><!-- 退订中 -->
	     			   	 <a href="javascript:void(0);" onclick="setStatus(${o.orderId},'${o.orderTypeName}',4);">确定退款</a>
	     			   	  &nbsp;&nbsp;
	     			   	  <a href="javascript:void(0);" onclick="setStatus(${o.orderId},'${o.orderTypeName}',2);">取消退订</a>
	     			      &nbsp;&nbsp;
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
	     			<td>{{= retreatDate }}</td>
	     			<td>{{= sourceName}}</td>
	     			<td>
                       {{if payStatus == 3}}
退订中
						{{else payStatus == 4}}
已退款
						{{/if}}
					</td>
	     			<td>{{= messName}}</td>
<td>
	  <a href="javascript:void(0);" onclick="orderDetail({{= orderId}},{{= orderTypeId}});">详情</a>
	  &nbsp;&nbsp;

{{if payStatus == 3}}	  
<a href="javascript:void(0);" onclick="setStatus({{= orderId}},'{{= orderTypeName}}',4);">确定退款</a>
&nbsp;&nbsp;
	 <a href="javascript:void(0);" onclick="setStatus({{= orderId}},'{{= orderTypeName}}',2);">取消退订</a>
&nbsp;&nbsp;
{{/if}}
						
	     				 
	     			  
	</td>

</tr>
</script>
<script type="text/javascript" >
function pageInfoList(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/unsuborderlist?pageNum='+pageNum+'&_time='+t);
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
	$(".index-right").load('<%=path%>/yundongjia/getorderbyid?orderId='+orderId+'&orderType='+orderType+'&nav=6&_time='+t);
}

//多条件查询
function search(pageNum,flag){
	if(flag){
		return false;
	}
	var data = new FormData($("#form")[0]);
	$.ajax({
		url:'<%=path%>/yundongjia/selectUnsubOrderByOrder',
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
	case 4:
		content="退款";
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
</script>
</body>
</html>
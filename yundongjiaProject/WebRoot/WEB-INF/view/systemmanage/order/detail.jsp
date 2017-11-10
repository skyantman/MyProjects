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
<title>订单详情</title>
<link href="<%=path%>/static/css/gymcommon.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/static/css/gymstyle.css" rel="stylesheet"
	type="text/css">

<link href="<%=path%>/static/css/gymcss/style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
 function toback(num){
	 var url='';
	 var t=new Date().valueOf();
	 if(1 == num){
		 url = '<%=path%>/yundongjia/listorder?pageNum=1&_time='+t;
	 }else if(2 == num){
		 url =  '<%=path%>/yundongjia/listactivity?pageNum=1&_time='+t;
	 }else if(3 == num){
		 var aId = ${o.activityId};
		 url = '<%=path%>/yundongjia/detailactivity?activityId='+aId+'&tab=2&_time='+t;
	 }else if(4 == num){
		 url =  '<%=path %>/yundongjia/selfcardlist';
	 }else if(5 == num){
		 url =  '<%=path %>/yundongjia/selfCardTypeDetail?cardid=${param.cardtypeid}&status=1';
	 }else if(6 == num){
		 url =  '<%=path%>/yundongjia/selfCardDetail?cardtypeid=${param.cardtypeid}&cardid=${param.cardid}&status=0';
	 }else if(7 == num){
		 url =  '<%=path %>/yundongjia/enterprisecardlist';
	 }else if(8 == num){
		 url =  '<%=path %>/yundongjia/enterpriseCardTypeDetail?cardid=${param.cardtypeid}&status=1';
	 }else if(9 == num){
		 url =  '<%=path%>/yundongjia/enterpriseCardDetail?cardtypeid=${param.cardtypeid}&cardid=${param.cardid}&status=0';
	 }else if(10 == num){
		 url ='<%=path%>/yundongjia/redpackagelist?status=0';
	 }else if(11 == num){
		 url ='<%=path %>/yundongjia/memberList';
	 }else if(12 == num){
		 url ='<%=path%>/yundongjia/memberDetail?userId=${param.userId}';
	 }else if(13 == num){
		 url='<%=path%>/yundongjia/unsuborderlist?pageNum=1&_time='+t;
	 }
	 
	 tobackDemo(url);
 }
</script>	
</head>
<body>
<div class="main-content reManage" id="reManage" >
	<div class="main-content">
	<div class="page-header">
		当前位置：
		<c:if test="${nav == 0}">
		 <a href="javascript:toback(1);"> 订单列表 </a> &nbsp; &gt; &nbsp;
		</c:if>
		<c:if test="${nav == 1 }"><!-- 从活动详情来的 -->
			<a href="javascript:toback(2);">活动列表</a>
			&nbsp; &gt; &nbsp; 
			<a href="javascript:toback(3);">活动详情</a>
			 &nbsp;  &gt; &nbsp;
		</c:if>
		<c:if test="${nav == 2 }"><!-- 从活动详情来的 -->
				<a href="javascript:toback(7);">企业卡类型列表</a>
				&nbsp;>&nbsp;
				<a href="javascript:toback(8);">企业卡类型详情</a>
				&nbsp;>&nbsp;
				<a href="javascript:toback(9);">企业卡详情</a>
				&nbsp;>&nbsp;
		</c:if>
		<c:if test="${nav == 3 }"><!-- 从活动详情来的 -->
			<a href="javascript:toback(4);">个人卡类型列表</a>
				&nbsp;>&nbsp;
				<a href="javascript:toback(5);">个人卡类型详情</a>
				&nbsp;>&nbsp;
				<a href="javascript:toback(6);">个人卡详情</a>
				&nbsp;>&nbsp;
		</c:if>
		<c:if test="${nav == 4}">
		 <a href="javascript:toback(10);"> 红包列表 </a> &nbsp; &gt; &nbsp;
		</c:if>
		<c:if test="${nav == 5}">
		 <a href="javascript:toback(11);"> 用户列表 </a> &nbsp; &gt; &nbsp;
		 <a href="javascript:toback(12);"> 用户详情 </a> &nbsp; &gt; &nbsp;
		</c:if>
		<!-- 财务---菜单  -->
		<c:if test="${nav == 6}">
			<a href="javascript:toback(13);">退订列表</a>  &nbsp; &gt; &nbsp;
			
		</c:if>
		
		 <a href="javascript:void(0);">订单详情</a>
	</div>
	<div class="main-content-inquire" >
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-0" value="0"
							data-toggle="tab">订单详情</a>
							<input type="hidden" id="oId" value="${o.orderId}">
							<input type="hidden" id="orderTypeId" value="${o.orderTypeId}">
							</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-0">
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>订单ID</th>
										<th>订单类型</th>
										<th>订单内容</th>
										<th>订单金额</th>
										<th>用户</th>
										<th>订单来源</th>
										<th>订单状态</th>
										<th>短信状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${o.orderId}</td>
										<td>${o.orderTypeName}</td>
										<td>${o.comm}</td>
										<td>${o.totalMoney}</td>
										<td>${o.mobilePhoneNum}</td>
										<td>${o.sourceName}</td>
										<td>${o.orderStatusName}</td>
										<td>${o.messName}</td>
										<td>
	     			   
	     				
	     				<c:if test="${o.payStatus == 0}"><!-- 待支付 -->
	     			   	 <a href="javascript:void(0);" onclick="setStatus(${o.orderId},'${o.orderTypeName}',1);">取消订单</a>
	     			   	 &nbsp;&nbsp;
	     			   </c:if>
	     			   
	     			    <c:if test="${o.payStatus == 1}">已取消&nbsp;&nbsp;</c:if><!-- 已取消 -->
	     			    
	     			   <c:if test="${o.payStatus == 2}"><!-- 已支付 -->
	     			      <a href="javascript:void(0);">发送短信</a>
	     			      &nbsp;&nbsp;
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
	     			   	  <a href="javascript:void(0);">发送短信</a>
	     			   	  &nbsp;&nbsp;
	     			   
	     			   </c:if>
	     			   <c:if test="${o.payStatus == 5}">已完成</c:if><!-- 已完成 -->
	     			  
	     			  
	     			   <c:if test="${o.orderTypeId != 0}">
	     			   	<c:if test="${o.payStatus == 2 || o.payStatus == 5}">
	     			   	   <a href="javascript:void(0);" onclick="sendMess(${o.orderTypeId},${o.orderId});">发送短信</a>
	     			       &nbsp;&nbsp;
	     			   	</c:if>
	     			   </c:if>
	     			  
	     			  
	     			</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>



				<div class="main-content-inquire">
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#panel-1" value="0"
								data-toggle="tab">优惠减免</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-1">
								<table class="table" rules="cols" frame="box">
									<thead>
										<tr>
											<th>优惠类型</th>
											<th>个人卡</th>
											<th>红包</th>
											<th>优惠卷</th>
											<th>支付渠道</th>
											<th>合计</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>优惠金额</td>
											<td>${o.selfCard }</td>
											<td>${o.redPackage }</td>
											<td>${o.coupon }</td>
											<td>${o.payDitch}</td>
											<td>${o.disSum}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div> 
				</div>

				<div class="main-content-inquire">
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#panel-2" value="0"
								data-toggle="tab">结算详情</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-2">
								<table class="table" rules="cols" frame="box">
									<thead>
										<tr>
											<th>结算ID</th>
											<th>订单内容</th>
											<th>供应商</th>
											<th>结算价</th>
											<th>结算状态</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>${o.orderId}</td>
											<td>${o.comm}</td>
											<td>${o.supplierName }</td>
											<td>${o.clearPrice}</td>
											<td>
											<%-- <c:if test="${o.payStatus == 0}">待支付</c:if>
											<c:if test="${o.payStatus == 1}">已取消</c:if>
											<c:if test="${o.payStatus == 2}">已支付</c:if>
											<c:if test="${o.payStatus == 3}">退订中</c:if>
											<c:if test="${o.payStatus == 4}">已退订</c:if> --%>
											<c:if test="${o.payStatus == 5}">未结算</c:if>
											<c:if test="${o.payStatus == 7}">已结算</c:if>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>



				<div class="main-content-inquire">
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#panel-3" value="0"
								data-toggle="tab">财务信息</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-3">
								<table class="table" rules="cols" frame="box">
									<thead>
										<tr>
											<th>订单金额</th>
											<th>优惠减免</th>
											<th>发票税费</th>
											<th>运费</th>
											<th>实收金额</th>
											<th>收款方式</th>
											<th>到款状态</th>
											<th>是否退款</th>
											<th>退款方式</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>${o.totalMoney }</td>
											<td>${o.disSum}</td>
											<td>${o.invoiceMoney}</td>
											<td>${o.freight}</td>
											<td style="color: red;">${o.shMoney}</td>
											<td>${o.payTypeName}</td>
											<td>
											  <c:if test="${o.payStatus == 4}">已到账</c:if>
											  <c:if test="${o.payStatus != 4}">未到账</c:if>
											</td>
											<td>
											<c:if test="${o.payStatus == 4}">已退款</c:if>
											<c:if test="${o.payStatus != 4}">未退款</c:if>
											</td>
											<td>
											${o.payTypeName}
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

				<!-- 商城才显示 -->
				<div class="main-content-inquire"   <c:if test="${o.orderTypeId != 0}">style="display: none;"</c:if> >
					<div class="tabbable">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#panel-4" value="0"
								data-toggle="tab">物流信息</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-4">
								<table class="table" rules="cols" frame="box"
									style="width: 80%;">
									<thead>
										<tr>
											<th>收件人</th>
											<th>联系电话</th>
											<th>收件地址</th>
											<th>物流公司名称</th>
											<th>物流状态</th>

										</tr>
									</thead>
									<tbody>
										<tr>
											<td>${o.shipperName }</td>
											<td>${o.mobilePhoneNum }</td>
											<td>${o.addr }</td>
											<td>${o.expressType }</td>
											<td style="color:red;">
											<c:if test="${o.payStatus == 2}">待收货</c:if>
											<c:if test="${o.payStatus == 5}">已收货</c:if>
											</td>

										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>



			<div class="main-content-item">
			<table class="table" rules="cols" frame="box" style="width: 80%;">
				<thead>
					<tr>
					<th>操作ID</th>
					<th>操作人</th>
					<th>角色</th>
					<th>操作时间</th>
					<th>操作行为</th>
					<th>备注</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ops }" var="op">
							<tr>
								<td>${op.opeartion_id }</td>
								<td>${op.backuserName }</td>
								<td>${op.role_name }</td>
								<td>${op.opeartion_createdate }</td>
								<td>${op.opeartion_info }</td>
								<td>${op.opeartion_com }</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
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
<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/gym/pageBack.js"></script>	
<script type="text/javascript">
function fulshData(){
	var id=$("#oId").val();
	var t=new Date().valueOf();
	var orderTypeId = $("#orderTypeId").val();
	$(".index-right").load('<%=path%>/yundongjia/getorderbyid?orderId='+id+'&orderType='+orderTypeId+'&_time='+t);
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
		        fulshData();
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
					fulshData();
				}else{
					alert("操作失败");
				}
			}
		});
	}else{
		
	}
}
/*  */
function sendMess(orderType,orderId){
	var f = confirm("确定发送短信吗?");
	if(!f){
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
			console.log(data);
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
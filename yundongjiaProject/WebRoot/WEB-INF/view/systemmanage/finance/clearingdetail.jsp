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
<title>结算详情</title>
<script type="text/javascript">
	var url;
	function toback(num){
		var t=new Date().valueOf();
		if(1 == num){
			url="<%=path%>/yundongjia/clearorderlist?pageNum=1&_time="+t;
		}
		tobackDemo(url);
	}
</script>
</head>
<body>
	<div class="main-content reManage" id="reManage">
		<div class="main-content">
			<div class="page-header">
				当前位置：<a href="javascript:toback(1);">结算列表</a> &nbsp; &gt; &nbsp;
				<a href="javascript:void(0);">结算详情</a>
			</div>
		</div>
		<div class="main-content-inquire">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#panel-0" value="0"
						data-toggle="tab">结算详情</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-0">
					   <table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>结算金额(元)</th>
										<th>供应商名称</th>
										<th>关联订单ID</th>
										<th>商品名称</th>
										<th>结算日期</th>
										<th>订单状态</th>
										<th>结算模式</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="">
									<tr>
										<td>${c.price}</td>
										<td>${c.supplierName }</td>
										<td>${c.orderNum }</td>
										<td>${c.name }</td>
										<td>${c.retreatDate }</td>
										<td>
										    <c:if test="${c.payStatus == 5}">结算中</c:if>
											<c:if test="${c.payStatus == 7}">已结算</c:if>
									</td>
										<td>${c.clearingTypeName }</td>
										<td>
										
										
										 <c:if test="${c.payStatus ==5}">
												<a href="javascript:void(0);" onclick="upAccount('${c.orderId}','${c.supplierId}','${c.orderTypeId }',7);">确定结算</a>
										 </c:if>


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
<script type="text/javascript">
/* 确定结算 */
	function upAccount(orderId,rowId,orderTypeId,status){
		var t = new Date().valueOf();
		var supplierId = ${c.supplierId};
		var studioId =${c.id};
		
		var f=confirm("确定结算吗?");
		if(!f){
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
				if(data.result > 0){
					alert(data.message);
					$(".index-right").load('<%=path%>/yundongjia/clearorderdetail',{orderId:orderId,orderType:orderTypeId,studioId:studioId,supplierId:supplierId,_time:t});
				}else{
					alert(data.message);
				}
			}
			
		});
		
		
	}
</script>	
</body>
</html>
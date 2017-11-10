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
<title>提现详情</title>
</head>
<body>
	<div class="main-content reManage" id="reManage">
		<div class="main-content">
			<div class="page-header">
				当前位置： <a href="javascript:void();">提现列表</a> &nbsp;&gt;&nbsp; <a
					href="javascript:void(0);">提现详情</a>
			</div>
			<div class="main-content-inquire">
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-0" data-toggle="tab">订单详情</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-0">
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>提现订单ID</th>
										<th>提现金额</th>
										<th>用户</th>
										<th>提现日期</th>
										<th>订单状态</th>
										<th>汇款方式</th>
										<th>短信状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${a.orderNum }</td>
										<td>${a.amount }</td>
										<td>${a.loginMobilePhone }</td>
										<td>${a.createDate }</td>
										<td>${a.applyStatusName }</td>
										<td>${a.payStatusName }</td>
										<td>${a.messageStatusName }</td>

										<td> 
										
										<c:if test="${a.applyStatus ==  0}">
										   <a href="javascript:void(0);" onclick="setStatus(${a.rowId},2,2)">取消提现</a> &nbsp;&nbsp;
										   
										   <a href="javascript:void(0);" onclick="setStatus(${a.rowId}, 1,0)">提现成功</a> &nbsp;&nbsp; 
										</c:if>
										
										 
										
										<c:if test="${a.status == 0}">
										 <a href="javascript:void(0);" onclick="setStatus(${a.rowId},1,1)">禁用</a>
										</c:if>
										
										<c:if test="${a.status == 1 }">
										<a href="javascript:void(0);" onclick="setStatus(${a.rowId},0,1)">启用</a>
										</c:if>
										
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>


				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-1" data-toggle="tab">银行卡</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-1">
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>收款姓名</th>
										<th>银行卡号</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${a.accountName }</td>
										<td>${a.accountNo }</td>
									</tr>
								</tbody>
							</table>
						</div>
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
	
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	function setStatus(id,status,flag){
		var msg="确定";
		
		if(0 == flag){
			if(status == 1){
				msg+="提现";
			}else if(status == 2){
				msg+="取消提现";
			}
		}else if(1== flag){
			if(status == 1){
				msg+="禁用";
			}
		}else if(2 == flag){
			msg +="取消提现";
		}
		msg+="吗?";
		var res = confirm(msg);
		if(!res){
			return false;
		}
		
		var t=new Date().valueOf();
		$.ajax({
			url:'<%=path%>/yundongjia/updatestatus',
			type:'post',
			dataType:'json',
			data:{
				id:id,
				status:status,
				flag:flag
			},
			success:function(data){
				if(data.result > 0){
					alert(data.message);
					
					$(".index-right").load('<%=path%>/yundongjia/applydetail',{id:id});
				}else{
					alert(data.message);
				}
			}
		});
		
		
	}
</script>
	
</body>
</html>
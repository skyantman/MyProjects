<%@page import="com.sun.xml.internal.ws.util.xml.CDATA"%>
<%@page import="com.github.pagehelper.PageInfo"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
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
<title>红包列表</title>
<link href="<%=path%>/static/css/gymcommon.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/static/css/gymstyle.css" rel="stylesheet"
	type="text/css">

<link href="<%=path%>/static/css/gymcss/style.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="main-content reManage" id="reManage">
		<div class="page-header">
			当前位置：<a href="javascript:void(0);"> 红包列表 </a>
		</div>
		<div class="main-content-inquire" >
		  <div class="main-content-item" style="padding: 0px;">
		     <table class="table" style="max-width: 50%;" rules="cols" frame="box">
		     	<thead>
		     	 <tr>
		     		<th>红包总金额</th>
		     		<th>已使用红包总金额</th>
		     		<th>过期红包总金额</th>
		     	</tr>
		     	</thead>
		     	<tbody  id="statisTbody"  class="font-size-weight">
		     		<tr>
			     		<td>${moneyCount.allSum }</td>
			     		<td>${moneyCount.employSum }</td>
			     		<td>${moneyCount.pastSum }</td>
			     	</tr>
		     	</tbody>
		     </table>
		     <!-- 搜索条件 -->
		     <div>
			     <div class="col-md-12 padding0L" >
			       	 <div class="form-group col-md-1 padding0L" style="padding-top: 5px">
			       		 选择日期：
			       	 </div>
			       	 <div class="form-group col-md-2 padding0L">
			       	    <input placeholder="创建日期" class="form-control " type="text" id="startTime"  readonly="readonly" onfocus="WdatePicker()"/>
			       	 </div>
	 				<div class="form-group col-md-3 padding0L">
	 					<label class="col-md-1 padding0L" style="padding-top: 5px"  for="">至</label>
	 					<div class="col-md-9 padding0L">
	 						<input width="95%" placeholder="到期日期" class="form-control" type="text" id="endTime" readonly="readonly" onchange="searchinfo();" onfocus="WdatePicker()"/>
	 					</div>
	 				</div>
			     </div>
			      <table class="table"  style="width: 43%; margin-bottom: 30px;" border="1px">
			     		<tr height="30px;">
				     		<td width="17%">已发放：</td>
				     		<td width="17%"><span id="allSum" style="color: red;">${moneyCount.allSum }</span></td>
				     		<td width="17%">已使用：</td>
				     		<td width="17%"><span id="employSum" style="color: red;">${moneyCount.employSum }</span></td>
				     		<td width="17%">已过期：</td>
				     		<td><span id="pastSum" style="color: red;">${moneyCount.pastSum }</span></td>
				     	</tr>
			     </table>
		     </div>
		     <div class="main-content-inquire">
		     	<div class="tabbable">
					<ul class="nav nav-tabs">
						<li <c:if test="${status==0 }">class="active"</c:if>><a href="#panel-0" value="0" data-toggle="tab">已发放</a></li>
						<li <c:if test="${status==1 || status == 3 }">class="active"</c:if>><a href="#panel-1" value="1" data-toggle="tab">已使用</a></li>
						<li <c:if test="${status==2 || status == 4 }">class="active"</c:if>><a href="#panel-2" value="2" data-toggle="tab">已过期</a></li>
					</ul>
					
					<!-- 已发放 -->
					<div class="tab-content">
						<div <c:if test="${status==0 }">class="tab-pane active"</c:if> <c:if test="${status!=0 }">class="tab-pane"</c:if>  id="panel-0">
							<div class="main-content-item">
								<table class="table" rules="cols" frame="box">
									<thead>
										<tr>
											<th>红包ID</th>
											<th>获取方式</th>
											<th>红包金额</th>
											<th>用户</th>
											<th>创建日期</th>
											<th>有效期至</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${sendRedpackage.list }" var="cd">
											<tr>
												<td>${cd.redid }</td>
												<td>
														<c:if test="${cd.type == 1}">登录红包</c:if>
														<c:if test="${cd.type == 2}">评论红包</c:if>
														<c:if test="${cd.type == 3}">邀请红包</c:if>
														<c:if test="${cd.type == 4}">返现红包</c:if>
												</td>
												<td>${cd.amount}</td>
												<td>${cd.mobilephoneno}</td>
												<td>${cd.createdate}</td>
												<td>${cd.expiredate}</td>
											</tr>
									</c:forEach>		
									</tbody>
								</table> 
							</div>
							<div class="main-content-footer">
								<div class="page" id="page">
									<div class="page-list">
										<a onclick="pageListInfo(1,0);" <c:if test="${sendRedpackage.pageNum == 1 }">class="active"</c:if>>
											&lt;&lt;最前页</a>
												<div class="page-list">
													<c:forEach begin="1" end="${sendRedpackage.pages }" varStatus="i">
														<c:if test="${i.index<sendRedpackage.pageNum && i.index>sendRedpackage.pageNum-5}">
															<span onclick="pageListInfo(${i.index },0);">${i.index }</span>
														</c:if>
														<c:if test="${sendRedpackage.pageNum == i.index }">
															<span onclick="pageListInfo(${i.index },0);" class="active">${i.index }</span>
														</c:if> 
														<c:if test="${i.index>sendRedpackage.pageNum && i.index<sendRedpackage.pageNum+5}">
															<span onclick="pageListInfo(${i.index },0);">${i.index }</span>
														</c:if>
													</c:forEach>
												</div>
										<a onclick="pageListInfo(${sendRedpackage.pages },0);" <c:if test="${sendRedpackage.pageNum == sendRedpackage.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
									</div>
								</div>
							</div>
						</div>
						
						<!-- 已使用 -->
						<div <c:if test="${status!= 1 && status!= 3}">class="tab-pane"</c:if> <c:if test="${status==1 || status == 3 }">class="tab-pane active"</c:if> id="panel-1">
							<div class="main-content-inquire">
								<div class="col-md-12 padding0L" style="padding-top: 1%;">
									<div class="col-md-6 padding0L">
										<div class="form-group col-md-9 padding0L">
											<input placeholder="请输入手机号" class="form-control" type="text"
												id="search3" />
										</div>
										<button type="button" 
											class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor"
											onclick="search(1,3);">搜索</button>
									</div>
								</div>
								<div class="col-md-12 padding0L" style="padding-top: 1%;">
									<span style="font-size: 14px;">总计使用金额：<b><font  color="red">${orderMoney }</font></b>元</span>
								</div>
							</div>
							<div class="main-content-item">
								<table style="TABLE-LAYOUT:fixed" class="table" rules="cols" frame="box">
									<thead>
										<tr>
											<th width="7%">订单ID</th>
											<th width="7%">订单类型</th>
											<th width="27%">订单内容</th>
											<th width="7%">订单金额</th>
											<th width="7%">红包金额</th>
											<th width="9%">用户</th>
											<th width="15%">创建日期</th>
											<th width="7%">订单状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${order.list }" var="cd">
											<tr>
												<td>${cd.orderid }</td>
												<td>${cd.type }</td>
												<td>${cd.comm }</td>
												<td>${cd.totalmoney }</td>
												<td>${cd.selfCardCoupon }</td>
												<td>${cd.mobilephonenum }</td>
												<td>${cd.createdate }</td>
												<td>
													<c:if test="${cd.paystatus==0 }">待支付</c:if>
													<c:if test="${cd.paystatus==1 }">已取消</c:if>
													<c:if test="${cd.paystatus==2 }">已支付</c:if>
													<c:if test="${cd.paystatus==3 }">退订中</c:if>
													<c:if test="${cd.paystatus==4 }">已退订</c:if>
													<c:if test="${cd.paystatus==5 }">已完成</c:if>
												</td>
												<td>
													<a href="javascript:void(0)"  onclick="orderDetail(${cd.orderid } , '${cd.type }');" class="">详情</a>
													<c:if test="${cd.paystatus==0 }">
														<a href="javascript:void(0)" onclick="setStatus(${cd.orderid } , '${cd.type }' ,1);" class="">取消订单</a>
													</c:if>
													<c:if test="${cd.paystatus==2 }">
														<a href="javascript:void(0)"  onclick="setStatus(${cd.orderid } , '${cd.type }' ,3);" class="">退订</a>
													</c:if>
													<c:if test="${cd.paystatus==3 }">
														<a href="javascript:void(0)"  onclick="openModel(${cd.orderid } , '${cd.type }' ,4);" class="">申请退款</a>
														<a href="javascript:void(0)"  onclick="setStatus(${cd.orderid } , '${cd.type }' ,2);" class="">取消退订</a>
													</c:if>
												</td>
											</tr>
									</c:forEach>		
									</tbody>
								</table> 
							</div>
							<div class="main-content-footer">
								<div class="page" id="page">
									<div class="page-list">
										<c:if test="${status != 3 }">
												<a onclick="pageListInfo(1,1);" <c:if test="${order.pageNum == 1 }">class="active"</c:if>>
												&lt;&lt;最前页</a>
													<div class="page-list">
														<c:forEach begin="1" end="${order.pages }" varStatus="i">
															<c:if test="${i.index<order.pageNum && i.index>order.pageNum-5}">
																<span onclick="pageListInfo(${i.index },1);">${i.index }</span>
															</c:if>
															<c:if test="${order.pageNum == i.index }">
																<span onclick="pageListInfo(${i.index },1);" class="active">${i.index }</span>
															</c:if> 
															<c:if test="${i.index>order.pageNum && i.index<order.pageNum+5}">
																<span onclick="pageListInfo(${i.index },1);">${i.index }</span>
															</c:if>
														</c:forEach>
													</div>
											<a onclick="pageListInfo(${order.pages },3);" <c:if test="${order.pageNum == order.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
										</c:if>
										<c:if test="${status == 3 }">
												<a onclick="search(1,3);" <c:if test="${order.pageNum == 1 }">class="active"</c:if>>
												&lt;&lt;最前页</a>
													<div class="page-list">
														<c:forEach begin="1" end="${order.pages }" varStatus="i">
															<c:if test="${i.index<order.pageNum && i.index>order.pageNum-5}">
																<span onclick="search(${i.index },3);">${i.index }</span>
															</c:if>
															<c:if test="${order.pageNum == i.index }">
																<span onclick="search(${i.index },3);" class="active">${i.index }</span>
															</c:if> 
															<c:if test="${i.index>order.pageNum && i.index<order.pageNum+5}">
																<span onclick="search(${i.index },3);">${i.index }</span>
															</c:if>
														</c:forEach>
													</div>
											<a onclick="search(${order.pages },3);" <c:if test="${order.pageNum == order.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<!-- 已过期 -->
						<div <c:if test="${status!= 2 && status != 4}">class="tab-pane"</c:if> <c:if test="${status==2 || status == 4 }">class="tab-pane active"</c:if> id="panel-2">
							<div class="main-content-inquire">
								<div class="col-md-12 padding0L" style="padding-top: 1%;">
									<div class="col-md-6 padding0L">
										<div class="form-group col-md-9 padding0L">
											<input placeholder="请输入手机号" class="form-control" type="text"
												id="search2"  value="${info}"/>
										</div>
										<button type="button" 
											class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor"
											onclick="search(1,2);">搜索</button>
									</div>
								</div>
								<div class="col-md-12 padding0L" style="padding-top: 1%;">
									<span style="font-size: 14px;">总计过期金额：<b><font  color="red">${moneyCount.pastSum }</font></b>元</span>
								</div>
							</div>
							<div class="main-content-item">
								<table class="table" rules="cols" frame="box">
									<thead>
										<tr>
											<th>序号ID</th>
											<th>用户</th>
											<th>红包金额</th>
											<th>有效期至</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${pastRedpackage.list }" var="cd">
											<tr>
												<td>${cd.num}</td>
												<td>${cd.mobilePhoneNo}</td>
												<td>${cd.redCount}</td>
												<td>${cd.expireDate}</td>
											</tr>
									</c:forEach>		
									</tbody>
								</table> 
							</div>
							<div class="main-content-footer">
								<div class="page" id="page">
									<div class="page-list">
											<c:if test="${status != 4 }">
													<a onclick="pageListInfo(1,2);" <c:if test="${pastRedpackage.pageNum == 1 }">class="active"</c:if>>
													&lt;&lt;最前页</a>
														<div class="page-list">
															<c:forEach begin="1" end="${pastRedpackage.pages }" varStatus="i">
																<c:if test="${i.index<pastRedpackage.pageNum && i.index>pastRedpackage.pageNum-5}">
																	<span onclick="pageListInfo(${i.index },2);">${i.index }</span>
																</c:if>
																<c:if test="${pastRedpackage.pageNum == i.index }">
																	<span onclick="pageListInfo(${i.index },2);" class="active">${i.index }</span>
																</c:if> 
																<c:if test="${i.index>pastRedpackage.pageNum && i.index<pastRedpackage.pageNum+5}">
																	<span onclick="pageListInfo(${i.index },2);">${i.index }</span>
																</c:if>
															</c:forEach>
														</div>
												<a onclick="pageListInfo(${pastRedpackage.pages },2);" <c:if test="${pastRedpackage.pageNum == pastRedpackage.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
											</c:if>
											<c:if test="${status == 4 }">
													<a onclick="search(1,2);" <c:if test="${pastRedpackage.pageNum == 1 }">class="active"</c:if>>
													&lt;&lt;最前页</a>
														<div class="page-list">
															<c:forEach begin="1" end="${pastRedpackage.pages }" varStatus="i">
																<c:if test="${i.index<pastRedpackage.pageNum && i.index>pastRedpackage.pageNum-5}">
																	<span onclick="search(${i.index },2);">${i.index }</span>
																</c:if>
																<c:if test="${pastRedpackage.pageNum == i.index }">
																	<span onclick="search(${i.index },2);" class="active">${i.index }</span>
																</c:if> 
																<c:if test="${i.index>pastRedpackage.pageNum && i.index<pastRedpackage.pageNum+5}">
																	<span onclick="search(${i.index },2);">${i.index }</span>
																</c:if>
															</c:forEach>
														</div>
												<a onclick="search(${pastRedpackage.pages },2);" <c:if test="${pastRedpackage.pageNum == pastRedpackage.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
											</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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
<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript">
function pageListInfo(page,status){
	$(".index-right").load('<%=path%>/yundongjia/redpackagelist?status='+status+'&page='+ page);
}

function searchinfo(){
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	$.ajax({
		url : '<%=path%>/yundongjia/searchRedPackage',
		data : {
			startTime : startTime,
			endTime : endTime,
			time : (new Date()).valueOf()				
		},
		type : 'post',
		dataType : "json",
		success :function(data){
			$("#allSum").html(data.allSum);
			$("#employSum").html(data.employSum);
			$("#pastSum").html(data.pastSum);
		}
	});
}

function search(page , status){
	var info = $("#search"+status).val();
	if(status == 2){
		$(".index-right").load('<%=path%>/yundongjia/searchPast?info='+info+'&page='+ page);
	}else if(status == 3){
		$(".index-right").load('<%=path%>/yundongjia/searchRedOrder?info='+info+'&page='+ page);
	}
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
		        $(".index-right").load('<%=path%>/yundongjia/redpackagelist?status=0&page='+ 1);
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
					 $(".index-right").load('<%=path%>/yundongjia/redpackagelist?status=0&page='+ 1);
				}else{
					alert("操作失败");
				}
			}
		});
	}else{
		
	}
}
/* 订单详情 */
function orderDetail(orderId,type){
	//0商城 1场馆 2私课 3课程 4活动
	var orderType = null;
	switch (type) {
	case "商城":
		orderType = 0;
		break;
	case "场馆":
		orderType = 1;
		break;
	case "私课":
		orderType = 2;
		break;
	case "课程":
		orderType = 3;
		break;
	case "活动":
		orderType = 4;
		break;
	}
	//订单类型，订单ID
var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/getorderbyid?nav=4&orderId='+orderId+'&orderType='+orderType+'&_time='+t);
}
</script>	
</body>
</html>
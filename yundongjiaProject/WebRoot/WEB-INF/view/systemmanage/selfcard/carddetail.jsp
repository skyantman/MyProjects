<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人卡详情</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css" />
<script type="text/javascript">
	function goback(info){
		var maincontent = $('.index-right');
		if(info == 1){
			maincontent.load('<%=path %>/yundongjia/selfcardlist');	
		}else if(info == 2){
			maincontent.load('<%=path %>/yundongjia/selfCardTypeDetail?cardid=${cardTypyId}&status=1');
		}else if(info == 3){
			maincontent.load('<%=path %>/yundongjia/memberList');
		}else if(info == 4){
			$(".index-right").load('<%=path%>/yundongjia/memberDetail?userId=${userId}');
		}
	}
	
</script>
</head>
<body>
	<div class="main-content reManage" id="reManage">
		<div class="page-header">
			当前位置：
			<c:if test="${condition != 1 }">
				<a href="javascript:void(0)" onclick="goback(1)">个人卡类型列表</a>
				&nbsp;>&nbsp;
				<a href="javascript:void(0)"  onclick="goback(2)">个人卡类型详情</a>
				&nbsp;>&nbsp;
				<a href="javascript:void(0)" >个人卡详情</a>
			</c:if>
			<c:if test="${condition == 1 }">
				<a href="javascript:void(0)"  onclick="goback(3)">用户列表</a>
						&nbsp;>&nbsp;
					<a href="javascript:void(0)"  onclick="goback(4)">用户详情</a>
						&nbsp;>&nbsp;
					<a href="javascript:void(0)" >个人卡详情</a>
			</c:if>			
		</div>
			
		<div class="main-content-inquire">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li <c:if test="${condition != 9 }">class="active"</c:if>><a href="#panel-0" value="0"
						data-toggle="tab">单卡详情</a></li>
					<li <c:if test="${condition == 9 }">class="active"</c:if>><a href="#panel-1" value="1" data-toggle="tab">订单列表</a></li>
				</ul>
				<div class="tab-content">
					<div <c:if test="${condition == 9 }">class="tab-pane"</c:if><c:if test="${condition != 9 }">class="tab-pane active"</c:if> id="panel-0">
						<div class="main-content-item" style="padding-left: 30px">
							<table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">卡ID：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.orderId}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">卡名称：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.cardTypeName}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">卡折扣：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.discount}折</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">用户：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.backuserMobliePhone }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">激活日期：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.createDate }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">有效期至：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.expireDate }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">金额：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.money }元</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">实收金额：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${card.realMoney }元</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">返现金额：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
													<c:if test="${card.cashBack == -1 }">0元</c:if>
													<c:if test="${card.cashBack != -1 }">${card.cashBack}元</c:if>
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">状态：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
												<c:if test="${status == 0 }">生效</c:if>
												<c:if test="${status == 1 }">禁用</c:if>
												<c:if test="${status == 2 }">失效</c:if>
											</label>
										</div>
									</td>
								</tr>
							</table>


							<table class="table" style="max-width: 70%;" rules="cols" frame="box">
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
								<tbody id="cardTypeTbody">
									<c:forEach items="${opeartion }" var="o">
										<tr>
											<td>${o.opeartion_id }</td>
											<td>${o.backuserName }</td>
											<td>${o.role_name }</td>
											<td>${o.opeartion_createdate }</td>
											<td>${o.opeartion_info }</td>
											<td>${o.opeartion_com }</td>	
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<!-- 用户管理 tab -->
					<div <c:if test="${condition == 9 }">class="tab-pane active"</c:if><c:if test="${condition != 9 }">class="tab-pane"</c:if>id="panel-1">
						<div class="main-content-inquire">
							<div class="col-md-12 padding0L" style="padding-top: 1%;">
								<div class="col-md-6 padding0L">
									<div class="form-group col-md-9 padding0L">
										<input placeholder="请输入手机号" class="form-control" type="text"
											id="search" />
									</div>
									<button type="button" 
										class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor"
										onclick="search(1);">搜索</button>
								</div>
							</div>
						</div>
						<div>
							<label for="">总计使用次数：<span style="color: red;">${order.total}</span>&nbsp;次</label>
						</div>
						<div class="main-content-item">
							<table style="TABLE-LAYOUT:fixed" class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th width="7%">订单ID</th>
										<th width="7%">订单类型</th>
										<th width="25%">订单内容</th>
										<th width="7%">订单金额</th>
										<th width="9%">个人卡优惠</th>
										<th width="8%">用户</th>
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
									<c:if test="${status != 1 }">
											<a onclick="pageListInfo(1);" <c:if test="${order.pageNum == 1 }">class="active"</c:if>>
											&lt;&lt;最前页</a>
												<div class="page-list">
													<c:forEach begin="1" end="${order.pages }" varStatus="i">
														<c:if test="${i.index<order.pageNum && i.index>order.pageNum-5}">
															<span onclick="pageListInfo(${i.index });">${i.index }</span>
														</c:if>
														<c:if test="${order.pageNum == i.index }">
															<span onclick="pageListInfo(${i.index });" class="active">${i.index }</span>
														</c:if> 
														<c:if test="${i.index>order.pageNum && i.index<order.pageNum+5}">
															<span onclick="pageListInfo(${i.index });">${i.index }</span>
														</c:if>
													</c:forEach>
												</div>
										<a onclick="pageListInfo(${order.pages });" <c:if test="${order.pageNum == order.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
									</c:if>
									<c:if test="${status == 1 }">
											<a onclick="search(1);" <c:if test="${order.pageNum == 1 }">class="active"</c:if>>
											&lt;&lt;最前页</a>
												<div class="page-list">
													<c:forEach begin="1" end="${order.pages }" varStatus="i">
														<c:if test="${i.index<order.pageNum && i.index>order.pageNum-5}">
															<span onclick="search(${i.index });">${i.index }</span>
														</c:if>
														<c:if test="${order.pageNum == i.index }">
															<span onclick="search(${i.index });" class="active">${i.index }</span>
														</c:if> 
														<c:if test="${i.index>order.pageNum && i.index<order.pageNum+5}">
															<span onclick="search(${i.index });">${i.index }</span>
														</c:if>
													</c:forEach>
												</div>
										<a onclick="search(${order.pages });" <c:if test="${order.pageNum == order.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
									</c:if>
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
<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript">
function pageListInfo(page){
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/selfCardTypeDetail?pageNum='+page);
}

function search(page){
	var info = $("#search").val();
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/searchOrder?cardtypeid=${cardTypyId}&cardid=${card.cardId}&info='+ info +'&pageNum='+page);
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
		        var maincontent = $('.index-right');
				maincontent.load('<%=path%>/yundongjia/selfCardDetail?cardtypeid=${cardTypyId}&cardid=${card.cardId}&condition=9');
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
					var maincontent = $('.index-right');
					maincontent.load('<%=path%>/yundongjia/selfCardDetail?cardtypeid=${cardTypyId}&cardid=${card.cardId}&condition=9');
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
	$(".index-right").load('<%=path%>/yundongjia/getorderbyid?nav=3&cardtypeid=${cardTypyId}&cardid=${card.cardId}&orderId='+orderId+'&orderType='+orderType+'&_time='+t);
}
</script>
</body>
</html>
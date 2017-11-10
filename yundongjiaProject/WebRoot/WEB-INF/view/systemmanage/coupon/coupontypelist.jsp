<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8"></meta>
<title>优惠券类型列表</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css" />
</head>
<body>
<div class="main-content member reManage" id="reManage">
			<div class="page-header">
				当前位置：
				<a href="javascript:void(0)" status="0" >优惠券类型列表</a>
			</div>
			<div class="main-content-inquire">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li <c:if test="${status==0 }">class="active"</c:if>><a href="#panel-0" value="0" data-toggle="tab">金额券类型</a></li>
					<li <c:if test="${status==1 }">class="active"</c:if>><a href="#panel-1" value="1" data-toggle="tab">折扣券类型</a></li>
				</ul>
				<div  class="tab-content">
					<div <c:if test="${status==1 }">class="tab-pane"</c:if> <c:if test="${status==0 }">class="tab-pane active"</c:if>  id="panel-0">
						<div class="main-content-item" >
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>券类型ID</th>
										<th>券名称</th>
										<th>金额</th>
										<th>有效期</th>
										<th>库存</th>
										<th>已发放</th>
										<th>已使用</th>
										<th>覆盖商品</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="cardTypeTbody">
									<c:forEach items="${couponMoney.list }" var="o">
										<tr>
											<td><a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}" onclick="couponList(this);"  >${o.couponid }</a></td>
											<td><a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}" onclick="couponList(this);"  >${o.couponid }</a></td>
											<td>${o.amount }</td>
											<td>${o.validday }天</td>
											<td>
												<c:if test="${o.stock == -1}">系统生成</c:if>
												<c:if test="${o.stock != -1}">${o.stock}</c:if>
											</td>
											<td>${o.stock - o.surplusstock }</td>
											<td>${o.usestock }</td>
											<td>${o.coupontype }</td>
											<td>
													<c:if test="${o.status == 0}">生效</c:if>
													<c:if test="${o.status == 1}">禁用</c:if>
													<c:if test="${o.status == 2}">失效</c:if>
											</td>
											<td>
													<a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}" onclick="couponList(this);"  >属券列表</a>
													<c:if test="${o.status==1}">
														<a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}"  md="m" onclick="start(this);"  class="" data-toggle="modal"  data-target=".bs-example-modal-sm">启用</a>
													</c:if>
													 <c:if test="${o.status==0}">
														<a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}"  md="m" onclick="stop(this);" class="" data-toggle="modal"  data-target=".bs-example-modal-sm">禁用</a>
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
										<a onclick="pageListInfoM(1);" <c:if test="${couponMoney.pageNum == 1 }">class="active"</c:if>>
										&lt;&lt;最前页</a>
											<div class="page-list">
												<c:forEach begin="1" end="${couponMoney.pages }" varStatus="i">
													<c:if test="${i.index<couponMoney.pageNum && i.index>couponMoney.pageNum-5}">
														<span onclick="pageListInfoM(${i.index });">${i.index }</span>
													</c:if>
													<c:if test="${couponMoney.pageNum == i.index }">
														<span onclick="pageListInfoM(${i.index });" class="active">${i.index }</span>
													</c:if> 
													<c:if test="${i.index>couponMoney.pageNum && i.index<couponMoney.pageNum+5}">
														<span onclick="pageListInfoM(${i.index });">${i.index }</span>
													</c:if>
												</c:forEach>
											</div>
									<a onclick="pageListInfoM(${couponMoney.pages });" <c:if test="${couponMoney.pageNum == couponMoney.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
								</div>
							</div>
					</div>
				</div>

					<!--  tab -->
					<div <c:if test="${status==0 }">class="tab-pane"</c:if> <c:if test="${status==1}">class="tab-pane active"</c:if>  id="panel-1">
						<div class="main-content-item" >
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>券类型ID</th>
										<th>券名称</th>
										<th>折扣率</th>
										<th>最大抵扣金额</th>
										<th>有效期</th>
										<th>库存</th>
										<th>已发放</th>
										<th>已使用</th>
										<th>覆盖商品</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="cardTypeTbody">
									<c:forEach items="${couponDiscount.list }" var="o">
										<tr>
											<td><a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}" onclick="couponList(this);"  >${o.couponid }</a></td>
											<td><a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}" onclick="couponList(this);"  >${o.couponname}</a></td>
											<td>${o.discount }</td>
											<td>${o.maxmoney }</td>
											<td>${o.validday }天</td>
											<td>
												<c:if test="${o.stock == -1}">系统生成</c:if>
												<c:if test="${o.stock != -1}">${o.stock}</c:if>
											</td>
											<td>${o.stock - o.surplusstock }</td>
											<td>${o.usestock }</td>
											<td>${o.coupontype }</td>
											<td>
													<c:if test="${o.status == 0}">生效</c:if>
													<c:if test="${o.status == 1}">禁用</c:if>
													<c:if test="${o.status == 2}">失效</c:if>
											</td>
											<td>
													<a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}" onclick="couponList(this);"  >属券列表</a>
													<c:if test="${o.status==1}">
														<a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}"  md="d" onclick="start(this);"  class="" data-toggle="modal"  data-target=".bs-example-modal-sm">启用</a>
													</c:if>
													 <c:if test="${o.status==0}">
														<a href="javascript:void(0)" couponId ="${o.couponid }"  couponname="${o.couponname}"  md="d" onclick="stop(this);" class="" data-toggle="modal"  data-target=".bs-example-modal-sm">禁用</a>
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
										<a onclick="pageListInfoD(1);" <c:if test="${couponDiscount.pageNum == 1 }">class="active"</c:if>>
										&lt;&lt;最前页</a>
											<div class="page-list">
												<c:forEach begin="1" end="${couponDiscount.pages }" varStatus="i">
													<c:if test="${i.index<couponDiscount.pageNum && i.index>couponDiscount.pageNum-5}">
														<span onclick="pageListInfoD(${i.index });">${i.index }</span>
													</c:if>
													<c:if test="${couponDiscount.pageNum == i.index }">
														<span onclick="pageListInfoD(${i.index });" class="active">${i.index }</span>
													</c:if> 
													<c:if test="${i.index>couponDiscount.pageNum && i.index<couponDiscount.pageNum+5}">
														<span onclick="pageListInfoD(${i.index });">${i.index }</span>
													</c:if>
												</c:forEach>
											</div>
									<a onclick="pageListInfoD(${couponDiscount.pages });" <c:if test="${couponDiscount.pageNum == couponDiscount.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</div>			
	<div id="modal-container0" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
			<input type="hidden" id="enterid" value="">
			<input type="hidden" id="status" value="">
			<div class="col-md-12" style="padding-top: 8%;">
			<div class="col-md-4 padding0L padding5T">理由：</div>
			</div>
			<div class="col-md-12">
				
				<div class="col-md-10 padding0L form-group">
					<textarea class="form-control" id="comm" name="comm" rows="6"
						cols="60"></textarea>
				</div>
			</div>
			<input type="hidden"  id="status">
			<input type="hidden"  id="couponId">
			<input type="hidden"  id="md">
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="stopOrStart();">确定</button>
			</div>
		</div>
		</div>
		</div>
	<%-- <shiro:hasPermission name="gym_worker:update"><div hidden="hidden" id="gym_worker_update"></div></shiro:hasPermission>
	<shiro:hasPermission name="gym_worker:del"><div hidden="hidden" id="gym_worker_del"></div></shiro:hasPermission> --%>
	<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript">
//分页跳转金额券
function pageListInfoM(page){
	var maincontent = $('.index-right');
	maincontent.load("<%=path%>/yundongjia/coupontypelist?status=0&page="+page);
	
}
//分页跳转折扣券
function pageListInfoD(page){
	var maincontent = $('.index-right');
	maincontent.load("<%=path%>/yundongjia/coupontypelist?status=1&page="+page);
}

//禁用卡类
function stop(obj){
	$("#couponId").val($(obj).attr("couponId"));
	$("#status").val("1");
	$("#md").val($(obj).attr("md"));
}
//启用卡类
function start(obj){
	$("#couponId").val($(obj).attr("couponId"));
	$("#status").val("0");
	$("#md").val($(obj).attr("md"));
}
//禁用启用卡类
function stopOrStart(){
	var status = $("#status").val();
	var couponId = $("#couponId").val();
	var comm = $("#comm").val();
	var md = $("#md").val();
	$.ajax({
		url : '<%=path%>/yundongjia/stopOrStartCoupon',
		data : {
			couponId : couponId,
			status : status,
			comm : comm,
			type : 5,
			time : (new Date()).valueOf()
		},
		dataType:"JSON",
		success : function(data){
			if(data.result){
				var maincontent = $('.index-right');
				if(md == "m"){
					maincontent.load('<%=path%>/yundongjia/coupontypelist?status=0');
				}else if(md == "d"){
					maincontent.load('<%=path%>/yundongjia/coupontypelist?status=1');
				}
				alert(data.message);
				//关闭模态框
				$("#modal-container0").hide();
				$('.modal-backdrop').attr("hidden",true);
			}else{
				alert(data.message);
			}
		}
	})
}

//属券详情
function couponList(obj){
	var couponId = $(obj).attr("couponId");
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/couponList?status=1&couponId='+couponId);
}
</script>
</body>
</html>
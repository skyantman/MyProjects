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
<title>优惠券类型详情</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css" />
<script type="text/javascript">
	function goback(info){
		var maincontent = $('.index-right');
		maincontent.load('<%=path %>/yundongjia/coupontypelist');
	}
</script>
</head>
<body>
	<div class="main-content reManage" id="reManage">
		<div class="page-header">
				当前位置：
				<a href="javascript:void(0)"  onclick="goback(1)">优惠券类型列表</a>
				&nbsp;>&nbsp;
			<a href="javascript:void(0)" >优惠券类型详情</a>
		</div>
		<div class="main-content-inquire">
			<div class="main-content-item">
				<table class="table" rules="cols" frame="box">
					<thead>
						<tr>
							<th>券类型ID</th>
							<th>券名称</th>
							<c:if test="${coupon.couponmethod==1 }">
								<th>金额</th>
							</c:if>
							<c:if test="${coupon.couponmethod==0 }">
								<th>折扣率</th>
								<th>最大折扣金额</th>
							</c:if>
							<th>创建人</th>
							<th>创建时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="statisTbody">
						<tr>
							<td>${coupon.couponid}</td>
							<td>${coupon.couponname}</td>
							<c:if test="${coupon.couponmethod==1 }">
								<th>${coupon.amount}</th>
							</c:if>
							<c:if test="${coupon.couponmethod==0 }">
								<th>${coupon.discount}</th>
								<th>${coupon.maxmoney}</th>
							</c:if>
							<td>${coupon.opeartionadminname}</td>
							<td>${coupon.createdate}</td>
							<td>
									<c:if test="${coupon.status==0 }">生效</c:if>
									<c:if test="${coupon.status==1 }">禁用</c:if>
							</td>
							<td>
								<c:if test="${coupon.status==1}">
									<a href="javascript:void(0)" couponId ="${coupon.couponid }"  couponName="${coupon.couponname }" onclick="start(this);"  class="" data-toggle="modal"  data-target=".bs-example-modal-sm">启用</a>
								</c:if>
								 <c:if test="${coupon.status==0}">
									<a href="javascript:void(0)" couponId ="${coupon.couponid }" couponName="${coupon.couponname }"  onclick="stop(this);" class="" data-toggle="modal"  data-target=".bs-example-modal-sm">禁用</a>
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
		<div class="main-content-inquire">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li <c:if test="${status==0 }">class="active"</c:if>><a href="#panel-0" value="0"
						data-toggle="tab">券类型详情</a></li>
					<li <c:if test="${status==1 || status==2 }">class="active"</c:if>><a href="#panel-1" value="1" data-toggle="tab">属券列表</a></li>
				</ul>
				<div class="tab-content">
					<div <c:if test="${status==1 || status==2 }">class="tab-pane"</c:if> <c:if test="${status==0 }">class="tab-pane active"</c:if>  id="panel-0">
						<div class="main-content-item" style="padding-left: 30px">
							<table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">优惠券名称：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.couponname}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">券属性：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
													<c:if test="${coupon.couponmethod==0 }">折扣券</c:if>
													<c:if test="${coupon.couponmethod==1 }">金额券</c:if>
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">有效期：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.validday }天</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">库存：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
												<c:if test="${coupon.stock==-1 }">系统生成</c:if>
												<c:if test="${coupon.stock!=-1 }">${coupon.stock }</c:if>
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">覆盖商品：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.coupontype }</label>
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
											<label for="">${coupon.amount }元</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">起用额度：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.startmoney }元</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">已发放：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.stock -  coupon.surplusstock}张</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">已使用：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.usestock}张</label>
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
					<div <c:if test="${status==0 }">class="tab-pane"</c:if> <c:if test="${status==1 || status==2 }">class="tab-pane active"</c:if> id="panel-1">
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
						<div class="main-content-item">
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>券ID</th>
										<th>券名称</th>
										<th>
											<c:if test="${memberCoupon.list[0].couponmethod == 1}">金额</c:if>
											<c:if test="${memberCoupon.list[0].couponmethod == 0}">折扣</c:if>
										</th>
										<th>实际抵扣</th>
										<th>发放日期</th>
										<th>有效期至</th>
										<th>用户</th>
										<th>获取方式</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${memberCoupon.list }" var="cd">
										<tr>
											<td><a href="javascript:void(0)" rowId ="${cd.rowid }"   onclick="detailCard(this);" class=" ">${cd.rowid}</a></td>
											<td><a href="javascript:void(0)" rowId ="${cd.rowid }"   onclick="detailCard(this);" class=" ">${cd.couponname}</a></td>
											<td>${cd.discountamount}</td>
											<td>
													<c:if test="${cd.realmoney == null }"> - </c:if>
													<c:if test="${cd.realmoney != null }">${cd.realmoney}</c:if>
											</td>
											<td>${cd.createdate}</td>
											<td>${cd.expirtiondate}</td>
											<td>${cd.usermobilephoneno}</td>
											<td>
													<c:if test="${cd.gainmethod == 1}">系统发放</c:if>
													<c:if test="${cd.gainmethod == 2}">邀请返券</c:if>
													<c:if test="${cd.gainmethod == 3}">分享返券</c:if>
											</td>
											<td>
												<c:if test="${cd.status==0 }">未使用</c:if>
												<c:if test="${cd.status==1 }">禁用</c:if>
												<c:if test="${cd.status==2 }">已使用</c:if>
												<c:if test="${cd.status==3 }">过期失效</c:if>
											</td>
											<td>
												<a href="javascript:void(0)" rowId ="${cd.rowid }"   onclick="detailCard(this);" class=" ">详情</a>
												<c:if test="${cd.status==0 }">
													<a href="javascript:void(0)" rowId ="${cd.rowid }"  onclick="stopCard(this);" class=" " data-toggle="modal"  data-target=".bs-example-modal-sm">禁用</a>
												</c:if>
												<c:if test="${cd.status==1 }">
													<a href="javascript:void(0)" rowId ="${cd.rowid }"   onclick="startCard(this);" class=" " data-toggle="modal"  data-target=".bs-example-modal-sm">启用</a>
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
										<c:if test="${status != 2 }">
												<a onclick="pageListInfo(1);" <c:if test="${memberCoupon.pageNum == 1 }">class="active"</c:if>>
												&lt;&lt;最前页</a>
													<div class="page-list">
														<c:forEach begin="1" end="${memberCoupon.pages }" varStatus="i">
															<c:if test="${i.index<memberCoupon.pageNum && i.index>memberCoupon.pageNum-5}">
																<span onclick="pageListInfo(${i.index });">${i.index }</span>
															</c:if>
															<c:if test="${memberCoupon.pageNum == i.index }">
																<span onclick="pageListInfo(${i.index });" class="active">${i.index }</span>
															</c:if> 
															<c:if test="${i.index>memberCoupon.pageNum && i.index<memberCoupon.pageNum+5}">
																<span onclick="pageListInfo(${i.index });">${i.index }</span>
															</c:if>
														</c:forEach>
													</div>
											<a onclick="pageListInfo(${memberCoupon.pages });" <c:if test="${memberCoupon.pageNum == memberCoupon.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
										</c:if>
										<c:if test="${status == 2 }">
												<a onclick="search(1);" <c:if test="${memberCoupon.pageNum == 1 }">class="active"</c:if>>
												&lt;&lt;最前页</a>
													<div class="page-list">
														<c:forEach begin="1" end="${memberCoupon.pages }" varStatus="i">
															<c:if test="${i.index<memberCoupon.pageNum && i.index>memberCoupon.pageNum-5}">
																<span onclick="search(${i.index });">${i.index }</span>
															</c:if>
															<c:if test="${memberCoupon.pageNum == i.index }">
																<span onclick="search(${i.index });" class="active">${i.index }</span>
															</c:if> 
															<c:if test="${i.index>memberCoupon.pageNum && i.index<memberCoupon.pageNum+5}">
																<span onclick="search(${i.index });">${i.index }</span>
															</c:if>
														</c:forEach>
													</div>
											<a onclick="search(${memberCoupon.pages });" <c:if test="${memberCoupon.pageNum == memberCoupon.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
										</c:if>
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
			<input type="hidden"  id="rowId">
			<input type="hidden"  id="re">
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="stopOrStart();">确定</button>
			</div>
		</div>
	</div>
</div>
<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript">
//分页跳转
function pageListInfo(page){
	var maincontent = $('.index-right');
	maincontent.load("<%=path%>/yundongjia/couponList?couponId=${coupon.couponid}&status=1&page="+page);
}
//禁用卡类
function stop(obj){
	$("#couponId").val($(obj).attr("couponId"));
	$("#status").val("1");
}
//启用卡类
function start(obj){
	$("#couponId").val($(obj).attr("couponId"));
	$("#status").val("0");
}
//禁用启用卡类
function stopOrStart(){
	var status = $("#status").val();
	var rowId = $("#rowId").val();
	var couponId = $("#couponId").val();
	var comm = $("#comm").val();
	var re = $("#re").val();
	if(re == 1 || re == "1"){
		$.ajax({
			url : '<%=path%>/yundongjia/stopOrStartMemberCoupon',
			data : {
				rowId : rowId,
				status : status,
				comm : comm,
				type : 6,
				time : (new Date()).valueOf()
			},
			dataType:"JSON",
			success : function(data){
				if(data.result){
					var maincontent = $('.index-right');
					maincontent.load('<%=path%>/yundongjia/couponList?couponId=${coupon.couponid}&status=1');
					alert(data.message);
					//关闭模态框
					$("#modal-container0").hide();
					$('.modal-backdrop').attr("hidden",true);
				}else{
					alert(data.message);
				}
			}
		})
	}else{
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
					maincontent.load('<%=path%>/yundongjia/couponList?couponId=${coupon.couponid}&status=1');
					alert(data.message);
					//关闭模态框
					$("#modal-container0").hide();
					$('.modal-backdrop').attr("hidden",true);
				}else{
					alert(data.message);
				}
			}
		});
	}
}

//手机号查询
function search(page){
	var info = $("#search").val();
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/searchMemberCouponByPhone?couponId=${coupon.couponid}&info='+info + '&page=' + page);
}

//禁用单券
function stopCard(obj){
	$("#rowId").val($(obj).attr("rowId"));
	$("#status").val("1");
	$("#re").val("1");
}

//启用单券
function startCard(obj){
	$("#rowId").val($(obj).attr("rowId"));
	$("#status").val("0");
	$("#re").val("1");
}

//优惠券单券详情
function detailCard(obj){
	var rowId = $(obj).attr("rowId");
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/couponDetail?couponId=${coupon.couponid}&rowId='+rowId);
}
</script>
</body>
</html>
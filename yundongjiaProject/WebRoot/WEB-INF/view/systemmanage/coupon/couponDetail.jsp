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
<title>企业卡详情</title>
<script type="text/javascript">
	function goback(info){
		var maincontent = $('.index-right');
		if(info == 1){
			maincontent.load('<%=path %>/yundongjia/coupontypelist');
		}else if(info == 2){
			maincontent.load('<%=path %>/yundongjia/couponList?couponId=${couponId}&status=1');
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
				<c:if test="${status != 1 }">
					<a href="javascript:void(0)"  onclick="goback(1)">优惠券类型列表</a>
						&nbsp;>&nbsp;
					<a href="javascript:void(0)"  onclick="goback(2)">优惠券类型详情</a>
						&nbsp;>&nbsp;
					<a href="javascript:void(0)" >优惠单券详情</a>
				</c:if>
				<c:if test="${status == 1 }">
					<a href="javascript:void(0)"  onclick="goback(3)">用户列表</a>
						&nbsp;>&nbsp;
					<a href="javascript:void(0)"  onclick="goback(4)">用户详情</a>
						&nbsp;>&nbsp;
					<a href="javascript:void(0)" >优惠单券详情</a>
				</c:if>
		</div>
		
		<div class="main-content-inquire">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#panel-0"  value="0"  data-toggle="tab">优惠单券详情</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active"  id="panel-0">
						<div class="main-content-item" style="padding-left: 30px">
							<table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">券ID：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.rowId}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">券名称：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.couponName}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">券类型：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<c:if test="${coupon.couponMethod == 0 }">
												<label for="">折扣券</label>
											</c:if>
											<c:if test="${coupon.couponMethod == 1 }">
												<label for="">金额券</label>
											</c:if>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">绑定用户：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.mobilePhoneNo }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">发放日期：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.createDate }</label>
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
											<label for="">${coupon.expirtionDate }</label>
										</div>
									</td>
								</tr>
								<c:if test="${coupon.couponMethod == 1 }">
									<tr>
										<td>
											<div class="form-group">
												<label for="">金额：</label>
											</div>
										</td>
										<td>
											<div class="form-group">
												<label for="">${coupon.discountAmount }元</label>
											</div>
										</td>
									</tr>
								</c:if>
								<c:if test="${coupon.couponMethod == 0 }">
									<tr>
										<td>
											<div class="form-group">
												<label for="">折扣率：</label>
											</div>
										</td>
										<td>
											<div class="form-group">
												<label for="">${coupon.discountAmount }元</label>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div class="form-group">
												<label for="">最大抵扣金额：</label>
											</div>
										</td>
										<td>
											<div class="form-group">
												<label for="">${coupon.maxMoney }元</label>
											</div>
										</td>
									</tr>
								</c:if>
								<c:if test="${coupon.status == 2 }">
									<tr>
										<td>
											<div class="form-group">
												<label for="">实际抵扣：</label>
											</div>
										</td>
										<td>
											<div class="form-group">
												<label for="">${coupon.realMoney }元</label>
											</div>
										</td>
									</tr>
								</c:if>
								<tr>
									<td>
										<div class="form-group">
											<label for="">起用额度：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${coupon.startMoney }元</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">获取方式：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
												<c:if test="${coupon.gainMethod == 0 }">系统发放</c:if>
												<c:if test="${coupon.gainMethod == 1 }">邀请返券</c:if>
												<c:if test="${coupon.gainMethod == 2 }">分享返券</c:if>
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
												<c:if test="${coupon.status == 0 }">未使用</c:if>
												<c:if test="${coupon.status == 1 }">禁用</c:if>
												<c:if test="${coupon.status == 2 }">已使用</c:if>
												<c:if test="${coupon.status == 3 }">过期失效</c:if>
											</label>
										</div>
									</td>
								</tr>
								<c:if test="${coupon.status == 2 }">
									<tr>
										<td>
											<div class="form-group">
												<label for="">订单ID：</label>
											</div>
										</td>
										<td>
											<div class="form-group">
												<label for="">${coupon.orderId }</label>
											</div>
										</td>
									</tr>
								</c:if>
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
				</div>
			</div>
		</div>
	</div>
</body>
</html>
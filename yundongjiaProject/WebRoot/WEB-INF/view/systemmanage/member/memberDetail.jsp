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
<title>用户详情</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css" />
<script type="text/javascript">
	function goback(num){
		var maincontent = $('.index-right');
		if(num == 0){
			maincontent.load('<%=path %>/yundongjia/memberList');
		}else if(num == 1){
			
			var enterId = ${enterId};
			var enterCardId = ${enterCardId};
			//跳转企业列表的用户管理
			maincontent.load('<%=path %>/yundongjia/detailenterprise',{tab:3,id:enterId,cardId:enterCardId});
		}
		
		
	}
</script>
</head>
<body>
	<div class="main-content reManage" id="reManage">
		<div class="page-header">
			当前位置：
			
			
			<c:if test="${nav == 0}">
			<a href="javascript:void(0)" onclick="goback(0)">用户列表</a>
			
			</c:if>
			
			<c:if test="${nav == 1}">
			<a href="javascript:void(0)" onclick="goback(1)">企业用户列表</a>
			</c:if>
			
			&nbsp;>&nbsp;
			
			<a href="javascript:void(0)" >用户详情</a>
		</div>	
		<div class="main-content-inquire">
			<div class="main-content-item">
				<table class="table" rules="cols" frame="box">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户姓名</th>
							<th>性别</th>
							<th>所在城市</th>
							<th>手机号</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="statisTbody" >
						<tr>
							<td>${member.userId}</td>
							<td>${member.nickName}</td>
							<td>
								<c:if test="${member.gender == '0' }">男</c:if>
								<c:if test="${member.gender == '1' }">女</c:if>
							</td>
							<td>${member. name}</td>
							<td>${member.mobilePhoneNo}</td>
							<td><c:if test="${member.isValid==0 }">生效</c:if>
									<c:if test="${member.isValid==1 }">禁用</c:if>
							</td>
							<td>
								<c:if test="${member.isValid == '0'}"><a href="javascript:void(0)" onclick="openModal(1,${member.userId})" class="" data-toggle="modal"  data-target=".bs-example-modal-sm" >禁用</a></c:if>
								<c:if test="${member.isValid == '1'}"><a href="javascript:void(0)" onclick="openModal(0,${member.userId})" class="" data-toggle="modal"  data-target=".bs-example-modal-sm" >启用</a></c:if>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
		<div class="main-content-inquire">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li <c:if test="${nav != 3 }"> class="active"</c:if> ><a href="#panel-0" value="0" data-toggle="tab">用户详情</a></li>
					<li><a href="#panel-1" value="1" data-toggle="tab">资产信息</a></li>
					<li><a href="#panel-2" value="2" data-toggle="tab">卡信息</a></li>
					<li <c:if test="${nav == 3 }"> class="active"</c:if>><a href="#panel-3" value="3" data-toggle="tab">订单信息</a></li>
				</ul>
				<div class="tab-content">
					<!-- 用户详情 -->
					<div <c:if test="${nav == 3 }"> class="tab-pane"</c:if><c:if test="${nav != 3 }"> class="tab-pane active"</c:if> class="tab-pane active"  id="panel-0">
						<div class="main-content-item" style="padding-left: 30px">
							<table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">用户名称：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${member.nickName}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">性别：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
												<c:if test="${member.gender == '0' }">男</c:if>
												<c:if test="${member.gender == '1' }">女</c:if>
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">生日：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${member.bornDate }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">所在城市：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${member.name }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">收货地址：</label>
										</div>
									</td>
									<td>
										<div class="form-group" style="margin-left: 20px;">
										 		<table class="table table-bordered">
												  	<thead style="background-color: white;color: black;">
														<tr>
															<th>姓名</th>
															<th>手机号</th>
															<th>性别</th>
															<th>地址</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${member.addr }" var="a">
															<tr style="background-color: white;">
																<td>${a.name }</td>
																<td>${a.mobilephone }</td>
																<td>
																	<c:if test="${a.gender == 0 }">男</c:if>
																	<c:if test="${a.gender == 1 }">女</c:if>
																</td>
																<td>${a.address }</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">手机号：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="" id="mobilePhoneNo">${member.mobilePhoneNo}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">邮箱：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${member.email }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">头像：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<img alt="" src="<%=path %>/${member.imgpath}"  width="100px" height="100px">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">来源：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
												<c:if test="${member.userType == '0'}">APP</c:if>
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">注册日期：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
												<label for="">${member.createDate }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">密码：</label>
										</div>
									</td>
									<td>
										<div class="col-md-3  form-group">
												<button type="button" class="btn btn-default bcColor" onclick="resetpwd();">重置密码</button>
										</div>
									</td>
								</tr>
							</table>

							<div style="margin-top: 30px;">
								<table class="table" style="max-width: 70%;" rules="cols" frame="box" >
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

					<!-- 资产信息 tab -->
					<div class="tab-pane" id="panel-1">
						<div class="main-content-item" style="padding-left: 30px">
							<table>
									<tr>
										<td>
											<div class="form-group">
												<label for="">余额：</label>
											</div>
										</td>
										<td>
											<div class="form-group">
												<label for="">${member.balance}元</label>
												<button style="margin-left: 50px;" type="button" class="btn btn-default bcColor" onclick="extractMoney();">提现</button>
											</div>
										</td>
									</tr>
									<tr></tr>
									<tr>
										<td>
											<div class="form-group">
												<label for="">红包余额：</label>
											</div>
										</td>
										<td>
											<div class="form-group">
												<label for="">${member.redAmount}元</label>
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
												<label for="">${validity}</label>
											</div>
										</td>
									</tr>
							</table>
						</div>	
						<div class="main-content-item"  style="padding-left: 30px">
							<div class="tabbable">
									<ul class="nav nav-tabs">
										<li class="active" ><a href="#coupon-0" value="0"  data-toggle="tab">金额优惠券</a></li>
										<li><a href="#coupon-1" value="1"  data-toggle="tab">折扣优惠券</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active"  id="coupon-0">
											<table class="table" rules="cols" frame="box">
												<thead>
													<tr>
														<th>券ID</th>
														<th>券名称</th>
														<th>金额</th>
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
													<c:forEach items="${memberCoupon }" var="cd">
														<c:if test="${cd.couponmethod == 1}">
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
														</c:if>	
													</c:forEach>		
												</tbody>
											</table> 
										</div>
										
										<div class="tab-pane"  id="coupon-1">
											<table class="table" rules="cols" frame="box">
												<thead>
													<tr>
														<th>券ID</th>
														<th>券名称</th>
														<th>折扣</th>
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
													<c:forEach items="${memberCoupon }" var="cd">
														<c:if test="${cd.couponmethod == 0}">
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
														</c:if>	
													</c:forEach>
												</tbody>
											</table> 
										</div>
									</div>		
							</div>
						</div>
						<div class="main-content-item" style="padding-left: 30px">
							<div class="tabbable">
									<ul class="nav nav-tabs">
										<li class="active" ><a href="#card-0" value="0"  data-toggle="tab">提现账号</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active"  id="card-0">
											<table style="width: 70%;" class="table" rules="cols" frame="box">
												<thead>
													<tr>
														<th>收款人姓名</th>
														<th>帐号</th>
														<th>帐号类型</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${account }" var="cd">
															<tr>
																<td class="account-${cd.rowdid}">${cd.accountname}</td>
																<td class="account-${cd.rowdid}">${cd.accountno}</td>
																<td class="account-${cd.rowdid}" type="${cd.type}">
																	<c:if test="${cd.type == '00'}">支付宝</c:if>
																	<c:if test="${cd.type == '01'}">微信</c:if>
																	<c:if test="${cd.type == '02'}">银行卡</c:if>
																</td>
																<td class="account-${cd.rowdid}">
																	<a href="javascript:void(0)"   onclick="eaditor(${cd.rowdid});" class=" ">编辑</a>
																</td>
															</tr>
													</c:forEach>
												</tbody>
											</table> 
										</div>
								</div>		
							</div>
						</div>
						<div class="main-content-item" style="padding-left: 30px">
							<div class="tabbable">
									<ul class="nav nav-tabs">
										<li class="active" ><a href="#card-0" value="0"  data-toggle="tab">提现记录</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active"  id="card-0">
											<table style="width: 70%;" class="table" rules="cols" frame="box">
												<thead>
													<tr>
														<th>提现ID</th>
														<th>提现金额</th>
														<th>提现日期</th>
														<th>状态</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${apply }" var="cd">
														<tr>
															<td class="apply-${cd.rowid}">${cd.rowid}</td>
															<td class="apply-${cd.rowid}">${cd.amount}</td>
															<td class="apply-${cd.rowid}">${cd.createdate}</td>
															<td class="apply-${cd.rowid}">
																<c:if test="${cd.applystatus == 0}">处理中</c:if>
																<c:if test="${cd.applystatus == 1}">已提现</c:if>
																<c:if test="${cd.applystatus == 2}">已取消</c:if>
															</td>
															<td class="apply-${cd.rowid}">
																<c:if test="${cd.applystatus == 0}">
																	<a href="javascript:void(0)"   onclick="updateStatus(2 , ${cd.rowid});" class=" ">取消</a>
																	<a href="javascript:void(0)"   onclick="updateStatus(1 , ${cd.rowid});" class=" ">提现成功</a>
																</c:if>
															</td>
														</tr>
													</c:forEach>	
												</tbody>
											</table> 
										</div>
								</div>		
							</div>
						</div>
					</div>
					
					
					<!-- 卡信息 -->
					<div class="tab-pane"  id="panel-2">
							<div class="main-content-item"  style="padding-left: 30px">
							<div class="tabbable">
									<ul class="nav nav-tabs">
										<li class="active" ><a href="#selfcard-0" value="0"  data-toggle="tab">个人卡</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active"  id="selfcard-0">
											<table class="table" rules="cols" frame="box">
												<thead>
													<tr>
														<th>卡ID</th>
														<th>卡类型名称</th>
														<th>折扣率</th>
														<th>金额</th>
														<th>返现金额</th>
														<th>有效期至</th>
														<th>激活日期</th>
														<th>状态</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${cardDet }" var="cd">
														<tr>
															<td><a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="selfdetailCard(this);" class=" ">${cd.cardId}</a></td>
															<td><a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="selfdetailCard(this);" class=" ">${cd.cardTypeName}</a></td>
															<td>${cd.discount}</td>
															<td>${cd.money}</td>
															<td>
																<c:if test="${cd.cashBack == -1}">0</c:if>
																<c:if test="${cd.cashBack != -1}">${cd.cashBack}</c:if>
															</td>
															<td>${cd.expireDate}</td>
															<td>${cd.createDate}</td>
															<td>
																<c:if test="${cd.status==0 }">生效</c:if>
																<c:if test="${cd.status==1 }">禁用</c:if>
																<c:if test="${cd.status==2 }">失效</c:if>
															</td>
															<td>
																<a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="selfdetailCard(this);" class=" ">详情</a>
																<c:if test="${cd.status==0 }">
																	<a href="javascript:void(0)" cardId ="${cd.cardId }"  onclick="selfstopCard(this);" class="" data-toggle="modal"  data-target=".bs-example-modal-sm">禁用</a>
																</c:if>
																<c:if test="${cd.status==1 }">
																	<a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="selfstartCard(this);" class="" data-toggle="modal"  data-target=".bs-example-modal-sm">启用</a>
																</c:if>
															</td>
														</tr>
													</c:forEach>		
												</tbody>
											</table> 
										</div>
								</div>		
							</div>
						</div>
						
						<div class="main-content-item"  style="padding-left: 30px">
							<div class="tabbable">
									<ul class="nav nav-tabs">
										<li class="active" ><a href="#enterprisecard-0" value="0"  data-toggle="tab">企业卡</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active"  id="enterprisecard-0">
											<table class="table" rules="cols" frame="box">
												<thead>
													<tr>
														<th>卡ID</th>
														<th>卡类型名称</th>
														<th>折扣率</th>
														<th>金额</th>
														<th>剩余次数</th>
														<th>企业名称</th>
														<th>有效期至</th>
														<th>激活日期</th>
														<th>状态</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${cardDetEnterprise }" var="cd">
														<tr>
															<td><a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="entdetailCard(this);" class=" ">${cd.cardId}</a></td>
															<td><a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="entdetailCard(this);" class=" ">${cd.cardTypeName}</a></td>
															<td>${cd.discount}</td>
															<td>${cd.money}</td>
															<td>${cd.surplusSportsCount}</td>
															<td>${cd.enterpriseName}</td>
															<td>${cd.expireDate}</td>
															<td>${cd.createDate}</td>
															<td>
																<c:if test="${cd.status==0 }">生效</c:if>
																<c:if test="${cd.status==1 }">禁用</c:if>
																<c:if test="${cd.status==2 }">失效</c:if>
															</td>
															<td>
																<a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="entdetailCard(this);" class=" ">详情</a>
																<c:if test="${cd.status==0 }">
																	<a href="javascript:void(0)" cardId ="${cd.cardId }"  onclick="entstopCard(this);" class=" " data-toggle="modal"  data-target=".bs-example-modal-sm">禁用</a>
																</c:if>
																<c:if test="${cd.status==1 }">
																	<a href="javascript:void(0)" cardId ="${cd.cardId }"   onclick="entstartCard(this);" class=" " data-toggle="modal"  data-target=".bs-example-modal-sm">启用</a>
																</c:if>
															</td>
														</tr>
													</c:forEach>		
												</tbody>
											</table> 
										</div>
								</div>		
							</div>
						</div>
					</div>
					
					<!-- 订单信息 tab -->
					<c:if test="${nav == 3 }"></c:if>
					<div <c:if test="${nav != 3 }"> class="tab-pane"</c:if><c:if test="${nav == 3 }"> class="tab-pane active"</c:if> id="panel-3">
						<div class="main-content-item" style="padding-left: 30px">
							<form id="form" name="form1" onsubmit="return false;" method="post">
								<div class="col-md-12 padding0L" style="padding-top: 1%;">
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
						        <button type="button"
										class="btn btn-default col-md-offset-5 col-md-1 bcColor" onclick="search(1,false)">搜索</button>
						       </div>
						     </div>
						     <input type="hidden"  name="userId" value="${member.userId}">
						    </form> 
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
	
	<!-- 启用或禁用理由 -->
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
			<input type="hidden"  id="status1">
			<input type="hidden"  id="status2">
			<input type="hidden"  id="status3">
			<input type="hidden"  id="status4">
			<input type="hidden"  id="cardId">
			<input type="hidden"  id="cardId1">
			<input type="hidden"  id="userId">
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
  	<!-- onclick="stop(this);"  -->
<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
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
<a href="javascript:void(0);">发送短信</a>
						  &nbsp;&nbsp;
	     			      <a href="javascript:void(0);" onclick="setStatus({{= orderId}},'{{= orderTypeName}}',3);">退订</a>
&nbsp;&nbsp;
{{/if}}
{{if payStatus == 3}}
 <a href="javascript:void(0);" onclick="openModel({{= orderId}},'{{= orderTypeName}}',4);">申请退款</a>
	&nbsp;&nbsp;
 <a href="javascript:void(0);" onclick="setStatus({{= orderId}},'{{= orderTypeName}}',2);">取消退订</a>
&nbsp;&nbsp;
	     			 
{{/if}}
{{if payStatus == 4}}
<a href="javascript:void(0);">发送短信</a>
&nbsp;&nbsp;
{{/if}}
{{if payStatus == 5}}
已完成
{{/if}}
						
	     				 
	     			  
	</td>

</tr>
</script>
<script type="text/javascript">
//图片是否存在
$(function(){
	for(var i = 0; i < $("img").length;i++){
		var imgurl = $("img").eq(i).attr("src");
		  var ImgObj = new Image(); //判断图片是否存在  
		  ImgObj.src = imgurl;  
		  //没有图片，则返回-1  
		  if (ImgObj.fileSize > 0 || (ImgObj.width > 0 && ImgObj.height > 0)) {
			  $("img").eq(i).attr("src",imgurl);
		  } else {  
			  $("img").eq(i).attr("src","<%=path%>/static/images/null.png");
		  }  
	}
});

function openModal(status , userId){
	$("#status1").val(status);
	$("#userId").val(userId);
}

function stopOrStart(){
	var re = $("#re").val();
	if(re == 1){
		var status = $("#status2").val();
		var rowId = $("#rowId").val();
		var couponId = $("#couponId").val();
		var comm = $("#comm").val();
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
					maincontent.load('<%=path%>/yundongjia/memberDetail?userId=${member.userId}');
					alert(data.message);
					$(".nav-tabs li").eq(0).attr("class","");
					$(".nav-tabs li").eq(1).attr("class","active");
					$("#panel-1").attr("class","tab-pane active");
					$("#panel-0").attr("class","tab-pane");
					//关闭模态框
					$("#modal-container0").hide();
					$('.modal-backdrop').attr("hidden",true);
				}else{
					alert(data.message);
				}
			}
		})
	}else if(re == 2){
		var status = $("#status3").val();
		var cardId = $("#cardId").val();
		var comm = $("#comm").val();
		$.ajax({
			url : '<%=path%>/yundongjia/stopOrStartCard',
			data : {
				cardId : cardId,
				status : status,
				comm : comm,
				type : 2,
				time : (new Date()).valueOf()
			},
			dataType:"JSON",
			success : function(data){
				if(data.result){
					var maincontent = $('.index-right');
					maincontent.load('<%=path%>/yundongjia/memberDetail?userId=${member.userId}');
					alert(data.message);
					$(".nav-tabs li").eq(0).attr("class","");
					$(".nav-tabs li").eq(2).attr("class","active");
					$("#panel-2").attr("class","tab-pane active");
					$("#panel-0").attr("class","tab-pane");
					//关闭模态框
					$("#modal-container0").hide();
					$('.modal-backdrop').attr("hidden",true);
				}else{
					alert(data.message);
				}
			}
		})
	}else if(re == 3){
		var status = $("#status4").val();
		var cardId = $("#cardId1").val();
		var comm = $("#comm").val();
		$.ajax({
			url : '<%=path%>/yundongjia/stopOrStartCard',
			data : {
				cardId : cardId,
				status : status,
				comm : comm,
				type : 4,
				time : (new Date()).valueOf()
			},
			dataType:"JSON",
			success : function(data){
				if(data.result){
					var maincontent = $('.index-right');
					maincontent.load('<%=path%>/yundongjia/memberDetail?userId=${member.userId}');
					alert(data.message);
					$(".nav-tabs li").eq(0).attr("class","");
					$(".nav-tabs li").eq(2).attr("class","active");
					$("#panel-2").attr("class","tab-pane active");
					$("#panel-0").attr("class","tab-pane");
					//关闭模态框
					$("#modal-container0").hide();
					$('.modal-backdrop').attr("hidden",true);
				}else{
					alert(data.message);
				}
			}
		})
	}else{
		var status = $("#status1").val();
		var userId = $("#userId").val();
		var comm = $("#comm").val();
		$.ajax({
			url : '<%=path%>/yundongjia/stopOrStartMember',
			data : {
				userId : userId,
				status : status,
				comm : comm,
				type : 11,
				time : (new Date()).valueOf()
			},
			dataType:"JSON",
			success : function(data){
				if(data.result){
					var maincontent = $('.index-right');
					maincontent.load('<%=path%>/yundongjia/memberDetail?userId=${member.userId}');
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
}

function resetpwd(){
	var b = confirm("是否给用户手机发送密码重置短信？");
	if(b){
		var mobilePhone = $("#mobilePhoneNo").html();
		$.ajax({
			url : '<%=path%>/yundongjia/resetpwd',
			data : {
				mobilePhone : mobilePhone,
				time : (new Date()).valueOf()
			},
			dataType:"JSON",
			success : function(data){
				alert(data.message);
			}
		})
	}
}

//禁用单券
function stopCard(obj){
	$("#rowId").val($(obj).attr("rowId"));
	$("#status2").val("1");
	$("#re").val("1");
}

//启用单券
function startCard(obj){
	$("#rowId").val($(obj).attr("rowId"));
	$("#status2").val("0");
	$("#re").val("1");
}

//优惠券单券详情
function detailCard(obj){
	var rowId = $(obj).attr("rowId");
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/couponDetail?couponId=${coupon.couponid}&status=1&userId=${member.userId}&rowId='+rowId);
}

//禁用个人卡
function selfstopCard(obj){
	$("#cardId").val($(obj).attr("cardId"));
	$("#status3").val("1");
	$("#re").val("2");
}

//启用个人卡
function selfstartCard(obj){
	$("#cardId").val($(obj).attr("cardId"));
	$("#status3").val("0");
	$("#re").val("2");
}

//个人单卡详情
function selfdetailCard(obj){
	var cardId = $(obj).attr("cardId");
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/selfCardDetail?userId=${member.userId}&condition=1&cardid='+ cardId +'&status=0');
}

//禁用企页卡
function entstopCard(obj){
	$("#cardId1").val($(obj).attr("cardId"));
	$("#status4").val("1");
	$("#re").val("3");
}

//启用企页卡
function entstartCard(obj){
	$("#cardId1").val($(obj).attr("cardId"));
	$("#status4").val("0");
	$("#re").val("3");
}

//企业单卡详情
function entdetailCard(obj){
	var cardId = $(obj).attr("cardId");
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/enterpriseCardDetail?userId=${member.userId}&condition=1&cardid='+cardId+'&status=0');
}

//编辑提现账号
function eaditor(rowId){
	var name = $(".account-"+rowId).eq(0).html();
	var no = $(".account-"+rowId).eq(1).html();
	$(".account-"+rowId).eq(0).html('<input name="accountname" class="form-control" id="exampleInputEmail3" placeholder="收款人姓名" value='+ name +'>');
	$(".account-"+rowId).eq(1).html('<input name="accountno" class="form-control" id="exampleInputEmail3" placeholder="收款账号" value='+ no +'>');
	if($(".account-"+rowId).eq(2).attr("type") == 00){
		$(".account-"+rowId).eq(2).html(
			'<select name="type" class="form-control  btn btn-default">'+
				'<option value="00" selected="selected">支付宝</option>'+
				'<option value="01">微信</option>'+
				'<option value="02">银行卡</option>'+
			'</select>'
			);
	}else if($(".account-"+rowId).eq(2).attr("type") == 01){
		$(".account-"+rowId).eq(2).html(
				'<select name="type" class="form-control  btn btn-default">'+
					'<option value="00">支付宝</option>'+
					'<option value="01" selected="selected">微信</option>'+
					'<option value="02">银行卡</option>'+
				'</select>'
				);
	}else if($(".account-"+rowId).eq(2).attr("type") == 02){
		$(".account-"+rowId).eq(2).html(
				'<select name="type" class="form-control  btn btn-default">'+
					'<option value="00">支付宝</option>'+
					'<option value="01">微信</option>'+
					'<option value="02" selected="selected">银行卡</option>'+
				'</select>'
				);
	}
	$(".account-"+rowId).eq(3).html('<input onclick="subForm('+ rowId +');" id="inpsub" type="button" class="btn btn-default bcColor"  value="提交">');
}

//提交查询
function subForm(rowId){
	var name = $("input[name='accountname']").val();
	var no = $("input[name='accountno']").val();
	var type = $("select[name='type']").val();
	reg=/^[\u0391-\uFFE5]+$/; 
	if(name.length == 0){
		alert("收款人姓名不能为空");
		return ;
	}else if(!reg.test(name)){
		alert("收款人姓名只能为中文");
		return ;
	}else if(name.length > 7){
		alert("收款人姓名字符数不能超过6");
		return ;
	}
	if(no.length == 0){
		alert("收款账号不能为空");
		return ;
	}
	//获取表单信息
	$.ajax({
		url : "<%=path%>/yundongjia/updateAccount",
		type: 'POST',  
        data: {
        	rowdid : rowId,
        	accountname : name,
        	accountno : no,
        	type : type,
        	time : (new Date()).valueOf()
        },
        dataType: 'JSON',  
		success : function(data){
			if(data.result){
				$(".account-"+rowId).eq(0).html(data.account.accountname);
				$(".account-"+rowId).eq(1).html(data.account.accountno);
				switch (data.account.type) {
				case "00":$(".account-"+rowId).eq(2).html("支付宝");
					break;
				case "01":$(".account-"+rowId).eq(2).html("微信");
					break;
				case "02":$(".account-"+rowId).eq(2).html("银行卡");
					break;
				}
				$(".account-"+rowId).eq(3).html('<a href="javascript:void(0)"   onclick="eaditor('+ rowId +');" class=" ">编辑</a>');
				alert(data.message);
			}else{
				alert(data.message);
			}
		}
	});		
}

function updateStatus(status , rowid){
	if(status == 2){
		var str = "是否取消ID为【"+ rowid +"】的提现申请？";
	}else if(status == 1){
		var str = "是否通过ID为【"+ rowid +"】的提现申请？";
	}
	var b = confirm(str);
	if(b){
		$.ajax({
			url : "<%=path%>/yundongjia/updateStatus",
			type: 'POST',  
	        data: {
	        	rowId : rowid,
	        	applyStatus : status,
	        	time : (new Date()).valueOf()
	        },
	        dataType: 'JSON',  
			success : function(data){
				if(data.result){
					switch (data.apply.applystatus) {
					case "0": $(".apply-"+rowid).eq(3).html("处理中");
							$(".apply-"+rowid).eq(4).html('<a href="javascript:void(0)"   onclick="updateStatus(2 , '+ rowid +');" class=" ">取消</a>');
							$(".apply-"+rowid).eq(4).html('<a href="javascript:void(0)"   onclick="updateStatus(1 , '+ rowid +');" class=" ">提现成功</a>');
						break;
					case "1":$(".apply-"+rowid).eq(3).html("已提现");
							$(".apply-"+rowid).eq(4).html("");
						break;
					case "2":$(".apply-"+rowid).eq(3).html("已取消");
							$(".apply-"+rowid).eq(4).html("");
						break;
					}
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		});		
	}
}

function pageInfoList(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/memberDetail?nav=3&userId=${member.userId}&pageNum=' + pageNum);
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
	$(".index-right").load('<%=path%>/yundongjia/getorderbyid?nav=5&userId=${member.userId}&orderId='+orderId+'&orderType='+orderType+'&_time='+t);
}
//多条件查询
function search(pageNum,flag){
	if(flag){
		return false;
	}
	var data = new FormData($("#form")[0]);
	$.ajax({
		url:'<%=path%>/yundongjia/selectOrderByMember',
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
		        var t=new Date().valueOf();
		    	$(".index-right").load('<%=path%>/yundongjia/memberDetail?userId=${member.userId}&pageNum=1');
		    	alert("操作成功");
		    	$(".nav-tabs li").eq(0).attr("class","");
		    	$(".nav-tabs li").eq(3).attr("class","active");
		    	$("#panel-3").attr("class","tab-pane active");
		    	$("#panel-0").attr("class","tab-pane");
			}else {
				alert("操作失败");
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
					$(".index-right").load('<%=path%>/yundongjia/memberDetail?userId=${member.userId}&pageNum=1');
					alert("操作成功");
					$(".nav-tabs li").eq(0).attr("class","");
			    	$(".nav-tabs li").eq(3).attr("class","active");
			    	$("#panel-3").attr("class","tab-pane active");
			    	$("#panel-0").attr("class","tab-pane");
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
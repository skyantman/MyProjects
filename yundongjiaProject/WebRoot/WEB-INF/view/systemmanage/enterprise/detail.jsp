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

	

<script type="text/javascript">
function toback(num){
	var t= new Date().valueOf();
	var url="";
	if(0 == num){
		url='<%=path%>/yundongjia/listenterprise?_time='+t;
	}else if(1 == num){
		url='<%=path %>/yundongjia/enterprisecardlist?_time='+t;
	}else if(2 == num){
		url='<%=path %>/yundongjia/enterpriseCardTypeDetail?status=1&cardid=${enterpriseCardId}&_time='+t;
	}
	tobackDemo(url);
}
</script>
<title>企业详情</title>

</head>
<body>
	<div class="main-content reManage " id="reManage">
		<div class="page-header">
			当前位置： 
			<c:if test="${enterpriseCardId == null }">
				<a href="javascript:toback(0);">企业列表</a> &nbsp; &gt; &nbsp; 
			</c:if>
			<c:if test="${enterpriseCardId != null }">
				<a href="javascript:toback(1);">企业卡类型列表</a> &nbsp; &gt; &nbsp; 
				<a href="javascript:toback(2);">企业卡类型详情</a> &nbsp; &gt; &nbsp; 
			</c:if>
			<a href="javascript:void(0);">
				企业详情
			</a>
		</div>
		<div class="main-content-inquire">
			<div class="main-content-item">
				<input type="hidden" id="enterpriseId" value="${enterprise.enterprise_id}">
				<table class="table" rules="cols" frame="box">
					<thead>
						<tr>
							<th>企业ID</th>
							<th>企业名称</th>
							<th>所在城市</th>
							<th>创建人</th>
							<th>创建时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="statisTbody">
						<tr>
							<td>${enterprise.enterprise_id}</td>
							<td>${enterprise.enterpriseName}</td>
							<td>${enterprise.provinceName}</td>
							<td>${enterprise.backuserName}</td>
							<td>${enterprise.createDate}</td>
							<td>
							  <c:if test="${enterprise.status == 0}">生效</c:if>
							  <c:if test="${enterprise.status == 1}">禁用</c:if>
							</td>
							<td>
								<a href="javascript:void(0)" id="${enterprise.enterprise_id}" class="edit">编辑</a>&nbsp;&nbsp;
								<c:if test="${enterprise.status == 0}">
								<a href="javascript:void(0)" onclick="openStatuModal(1,${enterprise.enterprise_id},'setStatus')" class="status">禁用</a>
								</c:if>
								
								<c:if test="${enterprise.status == 1}">
								<a href="javascript:void(0)" onclick="openStatuModal(0,${enterprise.enterprise_id},'setStatus')" class="status">启用</a>
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
					<li <c:if test="${tab == 1}">class="active"</c:if> >
					<a href="#panel-0" value="0" data-toggle="tab">卡类型详情</a>
					</li>
					<li <c:if test="${tab == 2}">class="active"</c:if> ><a href="#panel-1" value="1" data-toggle="tab">企业卡管理</a></li>
					<li <c:if test="${tab == 3}">class="active"</c:if> ><a href="#panel-2" value="2" data-toggle="tab">用户管理</a></li>

				</ul>
				<!--  -->
				<div class="tab-content">
					<div class="tab-pane  <c:if test="${tab == 1}">active</c:if>" id="panel-0">
						<div class="main-content-item" style="padding-left: 30px">
							<table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">企业名称：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${enterprise.enterpriseName}</label>
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
											<label for="">${enterprise.provinceName}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">企业地址：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${enterprise.enterpriseAddr}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">企业规模：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${enterprise.enterpriseScale}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">联系方式：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${enterprise.enterpriseTel}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">剩余次数：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for=""><span style="color:red;">${enterprise.remaCount}</span>次(已使用${enterprise.moveCount}次)</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">参与活动：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
											<c:if test="${enterprise.isActivity == 0}">不参加</c:if>
											<c:if test="${enterprise.isActivity == 1}">参加</c:if>
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">备注：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${enterprise.comm }</label>
										</div>
									</td>
								</tr>
							</table>


							
						</div>
					</div>

					<div class="tab-pane  <c:if test="${tab == 2}">active</c:if> " id="panel-1">
						<div class="main-content-inquire">
							<div class="col-md-12 padding0L" style="padding-top: 1%;">
								<div class="form-group col-md-10 padding0L" style="margin-bottom: 0px;">
									<a id="addcardModal" role="button" href="#modal-addard"
										data-toggle="modal"
										class="btn btn-default col-md-offset-12 col-md-2 bcColor"
										onclick="openDetailAddCard();">新增企业卡</a>
								</div>
							</div>
							<div class="main-content-item">
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>卡ID</th>
										<th>卡名称</th>
										<th>折扣率</th>
										<th>金额</th>
										<th>采购价</th>
										<th>运动次数</th>
										<th>剩余次数</th>
										<th>有效期至</th>
										<th>激活日期</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="cardListTbody">
									<c:forEach items="${cards.list}" var="c">
									 <tr>
										<td>${c.orderId}</td>
										<td>${c.cardTypeName}</td>
										<td>${c.discount}</td>
										<td>${c.totalMoney}</td>
										<td>${c.realMoney}</td>
										<td>${c.sportsCount}</td>
										<td>${c.surplusSportsCount}</td>
										<td>${c.expireDate}</td>
										<td>${c.createDate}</td>
										<td>
										<c:if test="${c.status == 0}">生效</c:if>
										<c:if test="${c.status == 1}">禁用</c:if>
										<c:if test="${c.status == 2}">到期失效</c:if>
										</td>
										<td>
										<a href="javascript:void(0)" id="${c.orderId}" class=" detail">详情</a>&nbsp;&nbsp;
										<c:if test="${c.status == 0}">
										<a href="javascript:void(0)"  onclick="openStatuModal(1,${c.orderId},'setCardStatus')" class=" state">禁用</a>
										</c:if>
										<c:if test="${c.status == 1}">
										<a href="javascript:void(0)" onclick="openStatuModal(0,${c.orderId},'setCardStatus')" class=" state">启用</a>
										</c:if>
										</td>
									 </tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						</div>
						<div class="main-content-footer">
							<div class="page" id="page-cards">
								<a onclick="cardPageInfo(1)"
									<c:if test="${cards.pageNum == 1}">class="active" </c:if>>
									&lt;&lt;最前页</a>
								<div class="page-list">
									<c:forEach begin="1" end="${cards.pages}" varStatus="i">
										<c:if test="${i.index<cards.pageNum && i.index>cards.pageNum-4}">
											<span onclick="cardPageInfo(${i.index });">${i.index }</span>
										</c:if>
										<c:if test="${cards.pageNum == i.index }">
											<span onclick="cardPageInfo(${i.index });" class="active">${i.index }</span>
										</c:if> 
										<c:if test="${i.index>cards.pageNum && i.index<cards.pageNum+4}">
											<span onclick="cardPageInfo(${i.index });">${i.index }</span>
										</c:if>
									</c:forEach>
								</div>
								<a onclick="cardPageInfo(${cards.pages})"
									<c:if test="${cards.pageNum == cards.pages}">class="active"</c:if>>最后页&gt;&gt;</a>
							</div>
						</div>

						<div class="main-content-item">
							<table class="table" style="max-width: 80%;" rules="cols" frame="box">
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
								<tbody id="cardTbody">
									<c:forEach items="${cardOpears}" var="op">
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
					<!-- 用户管理 tab -->
					<div class="tab-pane <c:if test="${tab == 3}">active</c:if>  " id="panel-2">
						<div id="selectcardbody"   <c:if test="${enterpriseCardId != null }">style="display: none;"</c:if>  >
							<table>
								<tr>
									<td style="width:70px;">企业卡:</td>
									<td style="width:150px;">
									<select id="cardids" name="cardids" onchange="selectCard();"
										class="form-control btn btn-default">
											<option value="-1" >请选择</option>
											<c:forEach items="${enterCards}" var="cs">
											<option value="${cs.orderId}"   <c:if test="${cardid == cs.orderId}">selected="selected"</c:if>     >${cs.orderId}</option>
											</c:forEach>
									</select>
									</td>
								</tr>
							</table>
						</div>
						
						<div id="userbody"  <c:if test="${cardid == -1}">style="display: none;"</c:if>     >
						<div class="main-content-inquire">
							<div class="col-md-12 padding0L" style="padding-top: 1%;">
								<div class="col-md-6 padding0L">
									<div class="form-group col-md-9 padding0L">
										<input placeholder="请输入手机号" class="form-control" type="text"
											id="searchMobilePhone" />
									</div>
									<button type="button"
										class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor"
										onclick="userbyMoblieSearch(1);">搜索</button>
								</div>
								<div class="col-md-6 padding0L">
									<div class="form-group col-md-8 padding0L">

										<a id="modal"  href="#modal-container0"  onclick="clearInput();"
								class="btn bcColor btn btn-default col-md-offset-10 col-md-4"
								data-toggle="modal">新增用户</a>
										
									</div>
									<div class="form-group col-md-4 ">
										<!-- <a
										class="btn btn-default col-md-offset-7 col-md-8 bcColor"
										onclick="">批量新增用户</a> -->
									</div>
								</div>
							</div>
						</div>
						<div class="main-content-item">
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>用户ID</th>
										<th>姓名</th>
										<th>性别</th>
										<th>手机号</th>
										<th>使用次数</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="userManageTbody">
								<c:forEach items="${users.list}" var="u">
									<tr>
									  <td>${u.userId}</td>
									  <td>${u.nickName}</td>
									  <td>
									  <c:if test="${u.gender == 0}">男</c:if>
									  <c:if test="${u.gender == 1}">女</c:if>
									  </td>
									  <td>${u.mobilePhoneNo}</td>
									  <td>${u.moveCount}</td>
									  <td>
									  	<c:if test="${u.isValid == 0}">有效</c:if>
									  	<c:if test="${u.isValid == 1}">禁用</c:if>
									  </td>
									  <td>
									  <a href="javascript:void(0)" id="${u.userId}" class=" detail">详情</a>&nbsp;&nbsp;
									  <c:if test="${u.isValid == 0}">
									     <a href="javascript:void(0)"  onclick="openStatuModal(1,${u.userId},'setUserStatus');" class=" status">禁用</a>
									  </c:if>
									  <c:if test="${u.isValid == 1}">
									     <a href="javascript:void(0)" onclick="openStatuModal(0,${u.userId},'setUserStatus');" class=" status">启用</a>
									  </c:if>
									  </td>
									</tr>
								</c:forEach>
								</tbody>
							</table> 
						</div>
						<div class="main-content-footer">
							<div class="page" id="user-page">
								<a onclick="userPageList(1)"
									<c:if test="${users.pageNum == 1}">class="active" </c:if>>
									&lt;&lt;最前页</a>
								<div class="page-list">
									<c:forEach begin="1" end="${users.pages}" varStatus="i">
										<c:if test="${i.index<users.pageNum && i.index>users.pageNum-4}">
											<span onclick="userPageList(${i.index });">${i.index }</span>
										</c:if>
										<c:if test="${users.pageNum == i.index }">
											<span onclick="userPageList(${i.index });" class="active">${i.index }</span>
										</c:if> 
										<c:if test="${i.index>users.pageNum && i.index<users.pageNum+4}">
											<span onclick="userPageList(${i.index });">${i.index }</span>
										</c:if>
									</c:forEach>
								</div>
								<a onclick="userPageList(${users.pages})"
								<c:if test="${users.pageNum == users.pages}">class="active"</c:if>>最后页&gt;&gt;</a>
							</div>
						</div>
						
						<div class="main-content-item">
							<table class="table" style="max-width: 80%;" rules="cols" frame="box">
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
								<tbody id="userManageTbody">
									<c:forEach items="${userOpears}" var="op">
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
			</div><!-- tag结束 -->
			
			
			
			

		</div>

		<div class="main-content-inquire" style="padding-top: 10%;">
			<!-- 企业卡操作记录 -->
			<table class="table" style="max-width: 90%;" rules="cols" frame="box">
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
					<c:forEach items="${enterOpears}" var="op">
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
	
	<!--增加用户  弹窗-->
	<div class="modal fade" id="modal-container0" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="width: 100%;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button> -->
					<h4 class="modal-title" id="myModalLabel">新增用户</h4>
				</div>
				<div class="modal-body">

					<div class="col-md-2 padding0L padding5T">手机号：</div>
					<input id="mobilePhoneNo" name="mobilePhoneNo" class="form-control"
						value="" placeholder="请输入手机号码" style="width: 30%;">
					 
				</div>



				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						关闭</button>
					<button type="button" onclick="saveUser();"
						class="btn btn-primary">提交更改</button>
				</div>

			</div>
		</div>

	</div>


	<!-- 启用或禁用理由 -->
	<div id="statusModal" class="modal fade bs-example-modal-sm"
		tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- <div class="modal-header">
					 
					  <h4 class="modal-title">  </h4>
				</div> -->
				<div class="modal-body">
					<input type="hidden" id="id" value=""> <input
						type="hidden" id="status" value="">
						<input type="hidden" id="type" value="">
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
					<button type="button" class="btn btn-primary"
						onclick="clickType();">确定</button>
				</div>
			</div>
		</div>
	</div>


		<!--弹窗  企业卡管理  --》增加企业卡-->
		<div id="modal-addard" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
    		<div class="modal-content">
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button> -->
					<h4 class="modal-title" id="myModalLabel">添加企业卡</h4>
				</div>
				<div class="modal-body">
					<div class="col-md-12">
						<div class="col-md-2 padding0L padding5T">采购价：</div>
						<div class="col-md-3 padding0L form-group">
							<input id="detailProcMoney" name="detailProcMoney" class="form-control" value=""
								placeholder="">
						</div>
						<div class="col-md-2 padding0L padding5T">支付方式：</div>
						<div class="col-md-4 padding0L form-group">
							<select id="detailCardOrderMethod" name="detailCardOrderMethod"
								class="form-control btn btn-default">
								<option value="00">支付宝支付</option>
								<option value="01">微信支付</option>
								<option value="02">现金支付</option>
								<option value="03">其他</option>
							</select>
						</div>
					</div>
					<table class="table" rules="cols" frame="box">
						<thead>
							<tr>
								<th>选择</th>
								<th>卡类型ID</th>
								<th>卡名称</th>
								<th>折扣率</th>
								<th>金额</th>
								<th>运动次数</th>
								<th>有效期</th>
								<th>覆盖城市</th>
							</tr>
						</thead>
						<tbody id="enterCardtypelist">
							 

						</tbody>
					</table>

				</div>
				
				<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
				</button>
				<button type="button" onclick="detailAddCard();" class="btn btn-primary">
					提交更改
				</button>
			</div>
				
			</div>
		</div>

	</div>	

<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>	
	<script src="<%=path%>/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<!-- 用户手机号码查询模板 -->
<script type="text/x-javascript-tmpl" id="usertmpl">
<tr>
<td>{{= userId}}</td>
<td>{{= nickName}}</td>
<td>
{{if gender == 0 }}
男
{{else}} 女 {{/if}}

</td>
<td>{{= mobilePhoneNo}}</td>
<td>{{= moveCount}}</td>
<td>
{{if isValid == 0 }}有效
{{else}} 禁用 {{/if}}

</td>
<td>
 <a href="javascript:void(0)" id="{{= userId}}" class=" detail">详情</a>&nbsp;&nbsp;
{{if isValid == 0 }}
<a href="javascript:void(0)"  onclick="openStatuModal(1,{{= userId}},'setUserStatus');" class=" status">禁用</a>
{{else}} 
<a href="javascript:void(0)"  onclick="openStatuModal(0,{{= userId}},'setUserStatus');" class=" status">启用</a>
{{/if}}

</td>
</tr>
</script>	
<!-- 企业卡管理-》增加企业卡 -->
<script type="text/x-javascript-tmpl" id="cardTypeShowTmpl">
<tr>
		<td><input name="enterCardTypeId" type="radio"
										value="{{= cardid}}"></td>
									<td>{{= cardid}}</td>	
									<td>{{= cardtypename }}</td>
									<td>{{= carddiscount }}折</td>
									<td>{{= amount }}</td>
									<td>{{= sportscount }}</td>
									<td>{{= validdate }}天</td>
									<td>{{= regionsid }}</td>
								</tr>
</script>
<script type="text/javascript">
/* 设置企业状态 */
function setStatus(status,id,comm){
	var ms =  status == 0?"确定启用吗?":"确定禁用吗";
	var res = confirm(ms);
	if(res){
		var t=new Date().valueOf();
		$.ajax({
			url:'<%=path%>/yundongjia/setenterprisestatus',
			type:'post',
			dataType:'json',
			data:{
				status:status,
				enterpriseId:id,
				comm:comm,
				_time:t
			},
			success:function(result){
				/* 跳转详情页 */
				if(result.result > 0){
					alert("操作成功");
					var t = new Date().valueOf();
					var id = result.enterId;
					 
					$(".index-right").load('<%=path%>/yundongjia/detailenterprise?id='+id+'&tab=1&_time='+t);
				}
			}
		});
	}
}
//点击绑定用户清除数据
function clearInput(){
	
	$("#mobilePhoneNo").val("");
}
	$(document).ready(function(){
		
		$('.tabbable a').click(function (e) {
			  e.preventDefault()
			  var v = parseInt($(this).attr("value"));
			  var enterId = $("#enterpriseId").val();// 企业id
			  var t=(new Date()).valueOf();
			  switch(v){
			  case 0://卡类型详情
				 // $(".index-right").load('/gym/reManage?pageNum=1&_time='+t);

				  break;
			  case 1://企业卡管理
			  	if("${enterpriseCardId}" != null){
			  		 $(".index-right").load('<%=path%>/yundongjia/detailenterprise?enterpriseCardId=${enterpriseCardId}&cardId=${cardid}&tab=2&id='+enterId+'&_time='+t);
			  	}else{
			  		$(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=2&id='+enterId+'&_time='+t);
			  	}
				 
			  	 
				  break;
			  case 2://用户管理
				  if("${enterpriseCardId}" != null){
					  $(".index-right").load('<%=path%>/yundongjia/detailenterprise?enterpriseCardId=${enterpriseCardId}&cardId=${cardid}&tab=3&id='+enterId+'&_time='+t);
				  }else{
					  $(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=3&id='+enterId+'&_time='+t);
				  }
			  
			  
				  break;
			  }
			  //$(this).tab('show')
		})
		
		
		
		/* 编辑 */
		$("#statisTbody").on('click','.edit',function(){
			var t = new Date().valueOf();
			var enterId = $(this).attr("id");
			$(".index-right").load('<%=path%>/yundongjia/enterprisetoeditpage?_time='+t+'&id='+enterId);
		});
		
		//企业卡  详情
		$("#cardListTbody").on('click','.detail',function(){
			var id=$(this).attr("id");
			var t=new Date().valueOf();
			$(".index-right").load('<%=path%>/yundongjia/enterpriseCardDetail?cardid='+id+'&status=0&position=1&_time='+t);
		});
		
		//用户 详情
		$("#userManageTbody").on('click','.detail',function(){
			var id = $(this).attr("id");
			var enterId = $("#enterpriseId").val();// 企业id
			var cardId = $("#cardids").val();//卡id
			var t=new Date().valueOf();
			<%-- $(".index-right").load('<%=path%>/yundongjia/gettuserbyid?userId='+id+'&enterId='+enterId+'&cardId='+cardId+'&_t='+t); --%>
			$(".index-right").load('<%=path%>/yundongjia/memberDetail',{userId:id,nav:1,enterId:enterId,enterCardId:cardId});
		});
		
		
	});

/* ---------------------------企业卡 */
function cardPageInfo(pageNum){
	 var t = new Date().valueOf();
	 var enterId = $("#enterpriseId").val();// 企业id
	
	 $(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=2&id='+enterId+'&_time='+t+'&pageNum='+pageNum);
}

//启用或禁用 企业卡
function setCardStatus(status,cardId,comm){
	var mes=status == 0?"确定启用此卡吗?":"确定禁用此卡吗?";
	var r = confirm(mes);
	if(r){
		$.ajax({
			url : '<%=path%>/yundongjia/stopOrStartCard',
			data : {
				cardId : cardId,
				status : status,
				comm:comm,
				_time : (new Date()).valueOf()
			},
			dataType:"JSON",
			success : function(data){
				if(data.result){
					var maincontent = $('.index-right');
					alert(data.message);
					
					 var t = new Date().valueOf();
					 var enterId = $("#enterpriseId").val();// 企业id
					
					 $(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=2&id='+enterId+'&_time='+t+'&pageNum=1');
					
					
				}else{
					alert(data.message);
				}
			}
		})
	}
	
}
//打开选择卡类型
function openDetailAddCard(){
	var t = new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/getcardtypes',
		type:'post',
		dataType:'json',
		data:{
			_time:t
		},
		success:function(data){
			$("#enterCardtypelist").html($("#cardTypeShowTmpl").tmpl(data));
		}
	});
}
//保存企业卡
function detailAddCard(){
	var reg = /^(([1-9]+\d*)|([1-9]+\d*\.\d{1,2}))$/;
	//采购价
	var procMoney = $("#modal-addard #detailProcMoney").val();
	
	//支付方式
	var payMethod = $("#modal-addard #detailCardOrderMethod").val();
	// 企业id
	var enterId = $("#enterpriseId").val();
	
	var typeId=0;
	var ids = $("#modal-addard [name=enterCardTypeId]");
	if(ids.length>0){
		for(var i = 0;i<ids.length;i++){
			if(ids[i].checked){
				typeId=ids[i].value;
			}
		}
	}else{
		
	}
	
	if(typeId > 0){
		if(!reg.test(procMoney)){
			alert("请正确输入采购金额");
			return false;
		}else{
			var t=new Date().valueOf();
			//生成卡
			$.ajax({
				url:'<%=path%>/yundongjia/savecardorder',
				type:'post',
				dataType:'json',
				data:{
					cardTypeId:typeId,
					enterpriseId:enterId,
					money:procMoney,
					payMethod:payMethod,
					_time:t
				},
				success:function(data){
					console.log(data);
					if(data.result > 0){
						alert("添加成功");
						
						//刷新
						
						$(".index-right").load('<%=path%>/yundongjia/detailenterprise?id='+enterId+'&tab=2&pageNum=1');
						
					}
				}
			});
			
		}
	}
	
	
	
	
	//关闭模态框
	$("#modal-addard").hide();
	$('.modal-backdrop').attr("hidden",true);
}

/* ---------------------------企业卡 end*/

/* ---------------------------用户管理 */

//选择卡加载卡下的用户
function selectCard(){
	var cardId = $("#cardids").val();
	 var t = new Date().valueOf();
	 var enterId = $("#enterpriseId").val();// 企业id
	if(cardId == -1){
		alert("请选择一张卡");
	}else{
		
		
		$(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=3&id='+enterId+'&cardId='+cardId+'&_time='+t);
	}
}
function validMobilePhone(mp){
	var t=new Date().valueOf();
	var result = true;
	//查询手机号码是否已存在
	$.ajax({
		url:'<%=path%>/yundongjia/getvalidmobilephone',
		type:'post',
		async:false,
		dataType:'json',
		data:{
			mobilePhone:mp,
			tType:4,
			_time:t
		},
		success:function(data){
			if(data > 0){
				
			}else{
				result = false;
			}
		}
	});
	return result;
}
function saveUser(){
	var reg=/^1[34578]\d{9}$/;
	var mp = $("#mobilePhoneNo").val();
	if(!reg.test(mp)){
		alert("请输入正确的手机号码");
		return false;
	}
	var r = validMobilePhone(mp);
	var msg="";
	if(r){
		alert("该手机号码已绑定卡,不能再次绑定");
		return false;
	}
	var t=new Date().valueOf();
	
	var enterId = $("#enterpriseId").val();// 企业id
	var cardId = $("#cardids").val();//卡id
	
	$.ajax({
		url:'<%=path%>/yundongjia/saveenteruser',
		type:'post',
		dataType:'json',
		data:{
			mobilePhone:mp,
			cardId:cardId,
			_time:t
		},
		success:function(result){
			if(result.result > 0){
				alert(result.message);
				
				$(".index-right").load('<%=path%>/yundongjia/detailenterprise?id='+enterId+'&tab=3&cardId='+cardId);
			}else{
				alert(result.message);
			}
			
		}
	});
	
	//关闭模态框
	$("#modal-container0").hide();
	$('.modal-backdrop').attr("hidden",true);
}

//设置用户状态 启用，禁用
function setUserStatus(status,id,comm){
	var t= new Date().valueOf();
	var enterId = $("#enterpriseId").val();// 企业id
	var cardId = $("#cardids").val();//卡id
	$.ajax({
		url:'<%=path%>/yundongjia/updateuserstatus',
		type:'post',
		dataType:'json',
		data:{
			userId:id,
			status:status,
			comm:comm,
			_time:t
		},
		success:function(data){
			if(data > 0){
				alert("操作成功");
				
				$(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=3&cardId='+cardId+'&id='+enterId+'&_time='+t);
			}
		}
	});
}
//用户分页
function userPageList(pageNum){
	var t= new Date().valueOf();
	var enterId = $("#enterpriseId").val();// 企业id
	var cardId = $("#cardids").val();//卡id
	$(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=3&cardId='+cardId+'&id='+enterId+'&pageNum='+pageNum+'&_time='+t);
}
//根据手机号码条件查询
function userbyMoblieSearch(pageNum){
	var mphone = $("#searchMobilePhone").val();
	var cardId = $("#cardids").val();//卡id
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/findtuserbymp',
		type:'post',
		dataType:'json',
		data:{
			mobilePhone:mphone,
			cardId:cardId,
			_time:t
		},
		success:function(data){
			$("#userManageTbody").html($("#usertmpl").tmpl(data.list));
			
			paging('user-page', 'userbyMoblieSearch', data);
		}
	});
	
	
}
/* ---------------------------用户管理 end*/


//打开启用禁用框
function openStatuModal(status,id,type){
	$("#id").val(id);
	$("#status").val(status);
	$("#type").val(type);
	$("#statusModal").modal("show");
}
//点击事件
function clickType(){
	var id = $("#id").val();
	var status = $("#status").val();
	var type = $("#type").val();
	var comm = $("#comm").val();
	var ms =  status == 0?"确定启用吗?":"确定禁用吗";
	var res = confirm(ms);
	
	if(res){
		if('setStatus' == type){
			setStatus(status, id,comm);
		}else if('setCardStatus' == type){
			setCardStatus(status, id,comm);
		}else if('setUserStatus' == type){
			setUserStatus(status, id, comm);
		}
		
		
		$('#statusModal').modal('hide');
        $('.modal-backdrop').attr("hidden",true);
	}
	
}


</script>	
</body>
</html>
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
		$(".index-right").load('<%=path%>/yundongjia/linkedSupplierList?_time='+t);
	}
}
</script>
<title>企业详情</title>

</head>
<body>
	<div class="main-content reManage " id="reManage">
		<div class="page-header">
			当前位置： 
				<a href="javascript:toback(0);">供应商列表</a> &nbsp; &gt; &nbsp; 
			<a href="javascript:void(0);">
				供应商详情
			</a>
		</div>
		<div class="main-content-inquire">
			<div class="main-content-item">
				<input type="hidden" id="rowid" value="${supplier.rowid}">
				<table class="table" rules="cols" frame="box">
					<thead>
						<tr>
							<th>供应商ID</th>
							<th>供应商名称</th>
							<th>已结算金额</th>
							<th>未结算金额</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="statisTbody">
						<tr>
							<td>${supplier.rowid}</td>
							<td>${supplier.suppliername}</td>
							<td>${supplier.info.clearing}</td>
							<td>${supplier.info.noclearing}</td>
							<td>
							  	<c:if test="${supplier.status==0 }">生效</c:if>
								<c:if test="${supplier.status==1 }">禁用</c:if>
								<c:if test="${supplier.status==2 }">失效</c:if>
								<c:if test="${supplier.status==3 }">未审核</c:if>
							</td>
							<td>
								<c:if test="${supplier.status == 0}"><a href="javascript:void(0)" onclick="openModal(0,1,${supplier.rowid})" class="state">禁用</a></c:if>
								<c:if test="${supplier.status == 1}"><a href="javascript:void(0)" onclick="openModal(0,0,${supplier.rowid})" class="state">启用</a></c:if>
								<c:if test="${supplier.status == 3}"><a href="javascript:void(0)"  class="userManage" onclick="openModal(0,0,${supplier.rowid})" >审核通过</a></c:if>&nbsp;&nbsp;
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
					<a href="#panel-0" value="0" data-toggle="tab">供应商详情</a>
					</li>
					<li <c:if test="${tab == 2}">class="active"</c:if> ><a href="#panel-1" value="1" data-toggle="tab">商品管理</a></li>
					<li <c:if test="${tab == 3}">class="active"</c:if> ><a href="#panel-2" value="2" data-toggle="tab">资产管理</a></li>

				</ul>
				<!--  -->
				<div class="tab-content">
					<div class="tab-pane  <c:if test="${tab == 1}">active</c:if>" id="panel-0">
						<div class="main-content-item" style="padding-left: 30px">
							<table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">供应商ID：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${supplier.rowid}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">供应商名称：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${supplier.suppliername}</label>
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
											<label for="">${supplier.mobilephonenum}</label>
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
											<label for="">${supplier.info.city}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">详细地址：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${supplier.address}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">结算模式：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">
												<c:if test="${supplier.clearingtype == 0}">预付</c:if>
												<c:if test="${supplier.clearingtype == 1}">周期结算</c:if>
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<button type="button" class=" btn btn-default bcColor"  onclick="update();">编辑</button>
									</td>
								</tr>
							</table>
						</div>
					</div>

					<div class="tab-pane  <c:if test="${tab == 2}">active</c:if> " id="panel-1">
							<table class="table"  rules="cols" frame="box">
						     	<thead>
						     	 <tr>
						     		<th width="15%">关联</th>
						     		<th></th>
						     	</tr>
						     	</thead>
						     	<tbody  id="statisTbody"  class="font-size-weight">
						     		<tr>
							     		<td><div class="paddingT">场馆</div></td>
							     		<td>
							     			<div class="col-md-11 paddingL20" id="likeStudio">
							     					<table   class="table" style="max-width: 60%;" rules="cols" frame="box">
												     	<thead>
												     	 <tr>
												     		<th style="color: black;">场馆名称</th>	
												     		<th style="color: black;">价格</th>
												     	</tr>
												     	</thead>
												     	<tbody  id="studioTable"  class="font-size-weight">
												     		<c:forEach items="${supplier.info.studio }"  var="info">
												     				<tr>	
																		<td id=${info.id }>${info.name }</td>
																		<td>${info.money }</td>
																 	<tr>
												     		</c:forEach>
												     	</tbody>
												     </table>
							     			</div>
							     		</td>
							     	</tr>
							     	<tr>
							     		<td><div class="paddingT">私教</div></td>
							     		<td>
							     			<div class="col-md-11 paddingL20" id="likePrivate">
							     					<table   class="table"  style="max-width: 60%;" rules="cols" frame="box">
												     	<thead>
												     	 <tr>
												     		<th style="color: black;">教练名称</th>	
												     		<th style="color: black;">价格</th>
												     	</tr>
												     	</thead>
												     	<tbody  id="privateTbody"  class="font-size-weight">
												     		<c:forEach items="${supplier.info.coach }"  var="info">
												     				<tr>	
																		<td id=${info.id }>${info.name }</td>
																		<td>${info.money }</td>
																 	<tr>
												     		</c:forEach>
												     	</tbody>
												     </table>
							     			</div>
							     		</td>
							     	</tr>
							     	<tr>
							     		<td><div class="paddingT">商品</div></td>
							     		<td id="likeStudio">
							     			<div class="col-md-11 paddingL20" id="likeGoods">
							     					<table   class="table" style="max-width: 60%;" rules="cols" frame="box">
												     	<thead>
												     	 <tr>
												     		<th style="color: black;">商品名称</th>	
												     		<th style="color: black;">价格</th>
												     	</tr>
												     	</thead>
												     	<tbody  id="goodsTbody"  class="font-size-weight">
												     		<c:forEach items="${supplier.info.goods }"  var="info">
												     				<tr>	
																		<td id=${info.id }>${info.name }</td>
																		<td>${info.money }</td>
																 	<tr>
												     		</c:forEach>
												     	</tbody>
												     </table>
							     			</div>
							     		</td>
							     	</tr>
						     	</tbody>
						  </table>
					</div>
					
					
					<!-- 用户管理 tab -->
					<div class="tab-pane <c:if test="${tab == 3}">active</c:if>  " id="panel-2">
						<div id="selectcardbody" >
							<table>
								<tr>
									<td style="width:70px;">余额：</td>
									<c:if test="${supplier.clearingtype == 0}">
										<td style="width:150px;">${supplier.supersavemoney }</td>
										<td style="width:150px;">
											<button type="button"  class=" btn btn-default  bcColor" data-toggle="modal" data-target="#modal-container1">储值</button>
										</td>
									</c:if>
									<c:if test="${supplier.clearingtype == 1}">
										<td style="width:150px;">${supplier.balance }</td>
										<td style="width:150px;">
											<button type="button"  class=" btn btn-default  bcColor" data-toggle="modal" data-target="#modal-container2" onclick="">提现</button>
										</td>
									</c:if>
								</tr>
								<c:if test="${supplier.clearingtype == 0}">
									<tr>
										<td>有效期至：</td>
										<td colspan="2">${supplier.savemoneyexpiredate }</td>
									</tr>
								</c:if>
							</table>
						</div>
						<br/>
						<div class="main-content-item">
							<table class="table" rules="cols" frame="box">
								<thead>
									<tr>
										<th>结算订单ID</th>
										<th>名称</th>
										<th>结算金额</th>
										<th>创建日期</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="userManageTbody">
								<c:forEach items="${order}" var="u">
									<tr>
									  <td>${u.id}</td>
									  <td>${u.name}</td>
									  <td>${u.money}</td>
									  <td>${u.createdate}</td>
									  <td>
									  	<c:if test="${u.paystatus == 5 || u.paystatus == 6}">未结算</c:if>
									  	<c:if test="${u.paystatus == 7}">已结算</c:if>
									  	<c:if test="${u.paystatus == 8}">取消结算</c:if>
									  </td>
									  <td>
										  <a href="javascript:void(0)" id="${u.id}" class=" detail">详情</a>&nbsp;&nbsp;
										  <c:if test="${u.paystatus == 5 || u.paystatus == 6}">
										     <a href="javascript:void(0)" onclick="openModal(${u.type },7,${u.id});" class=" status">确认结算</a>
										  </c:if>
										  <c:if test="${u.paystatus == 5 || u.paystatus == 6}">
										     <a href="javascript:void(0)" onclick="openModal(${u.type },8,${u.id});" class=" status">取消结算</a>
										  </c:if>
									  </td>
									</tr>
								</c:forEach>
								</tbody>
							</table> 
							<br/>
							<c:if test="${supplier.clearingtype == 0}">
								<table class="table" rules="cols" frame="box">
									<thead>
										<tr>
											<th>储值ID</th>
											<th>储值金额</th>
											<th>操作人</th>
											<th>储值日期</th>
											<th>有效期至</th>
											<th>储值方式</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${savemoney}" var="u">
										<tr>
										  <td>${u.id}</td>
										  <td>${u.money}</td>
										  <td>${u.opeartion}</td>
										  <td>${u.createDate}</td>
										  <td>${u.expiryDate}</td>
										  <td>
										  	<c:if test="${u.type=='00' }">支付宝</c:if>
										  	<c:if test="${u.type=='01' }">微信</c:if>
										  	<c:if test="${u.type=='02' }">银行卡</c:if>
										  	<c:if test="${u.type=='03' }">现金</c:if>
										  </td>
										</tr>
									</c:forEach>
									</tbody>
								</table> 
							</c:if>
							<c:if test="${supplier.clearingtype == 1}">
								<table class="table" rules="cols" frame="box">
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
									<c:forEach items="${apply}" var="u">
										<tr>
										  <td>${u.rowid}</td>
										  <td>${u.amount}</td>
										  <td>${u.createdate}</td>
										  <td>
										  		<c:if test="${u.applystatus == 0}">处理中</c:if>
											  	<c:if test="${u.applystatus == 1}">已提现</c:if>
											  	<c:if test="${u.applystatus == 2}">取消提现</c:if>
										  </td>
										  <td>
										  		 <a href="javascript:void(0)"  rowid="${u.rowid}"  onclick="applyDetail(this);" class=" detail">详情</a>&nbsp;&nbsp;
												  <c:if test="${u.applystatus == 0}">
												     <a href="javascript:void(0)" onclick="updateApplyStatus(1,${u.rowid});" class=" status">确认提现</a>&nbsp;&nbsp;
												     <a href="javascript:void(0)" onclick="updateApplyStatus(2,${u.rowid});" class=" status">取消</a>&nbsp;&nbsp;
												  </c:if>
										  </td>
										</tr>
									</c:forEach>
									</tbody>
								</table> 
							</c:if>
							<br/>
							<div class="col-md-12" style="margin-bottom: 20px">
								<button type="button"  data-toggle="modal" data-target="#modal-container0"  class="col-md-offset-6 col-md-1 btn btn-default offset  bcColor" status="0" onclick="openaddModal(this);">增加</button>
							</div>
							<table class="table" rules="cols" frame="box" style="width: 60%">
								<thead>
									<tr>
										<th>收款姓名</th>
										<th>提现账号</th>
										<th>账号类型</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${accounts}" var="u">
									<tr>
									  <td>${u.accountname}</td>
									  <td>${u.accountno}</td>
									   <td type="${u.type}">
									   		<c:if test="${u.type=='00' }">支付宝</c:if>
										  	<c:if test="${u.type=='01' }">微信</c:if>
										  	<c:if test="${u.type=='02' }">银行卡</c:if>
									   </td>
									  <td>
									  		 <a href="javascript:void(0)"  rowid="${u.rowdid}"  status="1" data-toggle="modal" data-target="#modal-container0" onclick="openaddModal(this);">编辑</a>&nbsp;&nbsp;
									  </td>
									</tr>
								</c:forEach>
								</tbody>
							</table> 
						</div>
					</div>
				</div>
			</div><!-- tag结束 -->
		</div>
	</div>
	
	<!--增加用户  弹窗-->
	<div class="modal fade" id="modal-container0" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="width: 100%;">
		<div class="modal-dialog">
			<div class="modal-content" >
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button> -->
					<h4 class="modal-title" id="myModalLabel">新增收款账号</h4>
				</div>
				<div class="modal-body" style="height: 150px">
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">收款人：</div>
						<div class="col-md-5 padding0L ">
							<input id="accountname" name="accountname" class="form-control"
								value="" placeholder="请输入收款人" >
						</div>
					</div>
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">收款账号：</div>
						<div class="col-md-5 padding0L ">
							<input id="accountno" name="accountno" class="form-control"
								value="" placeholder="请输入收款账号" >
						</div>
					</div>
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">账号类型：</div>
						<div class="col-md-5 padding0L ">
							<select id="type" name="type" class="form-control btn btn-default">
								<option value="-1">请选择</option>
								<option value="00">支付宝</option>
								<option value="01">微信</option>
								<option value="02">银行卡</option>
							</select>
						</div>
					</div>
					<input id="rowidinfo" type="hidden" value="0">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						关闭</button>
					<button type="button" onclick="saveInfo();"
						class="btn btn-primary bcColor">提交更改</button>
				</div>

			</div>
		</div>
	</div>

	<!--储值-->
	<div class="modal fade" id="modal-container1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="width: 100%;">
		<div class="modal-dialog">
			<div class="modal-content" >
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button> -->
					<h4 class="modal-title" id="myModalLabel">供应商储值</h4>
				</div>
				<div class="modal-body" style="height: 150px">
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">储值金额：</div>
						<div class="col-md-5 padding0L ">
							<input id="savemoney" name="savemoney" class="form-control"
								value="" placeholder="请输入金额" >
						</div>
					</div>
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">储值方式：</div>
						<div class="col-md-5 padding0L ">
							<select id="typeid" name="type" class="form-control btn btn-default">
								<option selected="selected" value="00">支付宝</option>
								<option value="01">微信</option>
								<option value="02">银行卡</option>
								<option value="03">现金</option>
							</select>
						</div>
					</div>
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">有效期至：</div>
						<div class="col-md-5 padding0L ">
							  <input id="expirydate" size="16" readonly="readonly" type="text" onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'expirydate\')}'})"
							value=""  class="form_datetime form-control" placeholder="请选择有效期" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						关闭</button>
					<button type="button" onclick="subSaveMoney();"
						class="btn btn-primary bcColor">提交</button>
				</div>

			</div>
		</div>
	</div>

<!--提现-->
	<div class="modal fade" id="modal-container2" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="width: 100%;">
		<div class="modal-dialog">
			<div class="modal-content" >
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button> -->
					<h4 class="modal-title" id="myModalLabel">供应商提现</h4>
				</div>
				<div class="modal-body" style="height: 150px">
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">提现用户：</div>
						<div class="col-md-5 padding0L ">
							<select id="accountInfo" name="accountInfo" class="form-control btn btn-default">
								<c:forEach items="${accounts}" var="u">
									<option value="${u.rowdid}~${u.type}">${u.accountname}&emsp;${u.accountno}</option>
								</c:forEach>	
							</select>
						</div>
					</div>
					<div class="col-md-12 form-group">
						<div class="col-md-2 padding0L padding5T">提现金额：</div>
						<div class="col-md-5 padding0L ">
							<input id="comeMoney" name="comeMoney" class="form-control"
								value="" placeholder="请输入金额" >
						</div>
					</div>
					<div class="col-md-12 form-group">
						<div class="col-md-10 padding0L padding5T">当前可提现金额：<font color="red" id="useableMoney">${supplier.balance  }</font></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						关闭</button>
					<button type="button" onclick="saveApply();"
						class="btn btn-primary bcColor">提交</button>
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
					<input type="hidden" id="rowId" value="">
					<input type="hidden" id="ordertype" value="">
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
					
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="setStatus();">确定</button>
				</div>
			</div>
		</div>
	</div>


<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>	
	<script type="text/javascript" src="<%=path %>/static/js/gym/My97DatePicker/WdatePicker.js"></script>	
	<script src="<%=path%>/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
function subSaveMoney(){
	var savemoney = $("#savemoney").val();
	var type = $("#typeid").val();
	var expirydate = $("#expirydate").val();
	if(savemoney.length == 0){
		alert("请输入储值金额");
		return ;
	}
	var reg = /^[0-9.]+$/;
	if(!reg.test(savemoney)){
		alert("请输入正确的储值金额");
		return ;
	}
	if(expirydate.length == 0){
		alert("请输入到期时间");
		return ;
	}
	$.ajax({
		url:'<%=path%>/yundongjia/insertsavemoney',
		type:'post',
		dataType:'json',
		data:{
			type:type,
			expirydate:expirydate,
			savemoney:savemoney,
			supplierid:"${supplier.rowid}"
		},
		success:function(result){
			if(result.result){
				$("#modal-container1").hide();
				$('.modal-backdrop').attr("hidden",true);
				alert(result.message);
				var t = new Date().valueOf();
				$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=3&id=${supplier.rowid}&_time='+t);
			}else{
				alert(result.message);
			}
		}
	});
	
}

function openaddModal(obj){
	if($(obj).attr("status") == 1){
		$("#myModalLabel").html("更新收款账号");
		var type = $(obj).parent().prevAll().eq(0).attr("type")
		$("option[value="+ type +"]").attr("selected" , "selected");
		var accountno = $(obj).parent().prevAll().eq(1).html();
		$("#accountno").val(accountno);
		var accountname = $(obj).parent().prevAll().eq(2).html();
		$("#accountname").val(accountname);
		var rowid = $(obj).attr("rowid");
		$("#rowidinfo").val(rowid);
	}
}

$('#modal-container0').on('hidden.bs.modal', function () {
	$("#accountno").val("");
	$("#accountname").val("");
	$("#rowidinfo").val(0);
});

function saveInfo(){
	var rowid = $("#rowidinfo").val();
	var type = $("#type").val();
	var accountno = $("#accountno").val();
	var accountname = $("#accountname").val();
	if(accountname.length == 0){
		alert("请输入收款人姓名");
		return ;
	}
	if(accountno.length == 0){
		alert("请输入收款账号");
		return ;
	}
	if(type == -1){
		alert("选择账号类型");
		return ;
	}
	
	$.ajax({
		url:'<%=path%>/yundongjia/accountInsertOrUpdate',
		type:'post',
		dataType:'json',
		data:{
			rowdid: rowid,
			type:type,
			accountno:accountno,
			accountname:accountname,
			likeid:"${supplier.rowid}"
		},
		success:function(result){
			if(result.result){
				$("#modal-container0").hide();
				$('.modal-backdrop').attr("hidden",true);
				alert(result.message);
				var t = new Date().valueOf();
				$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=3&id=${supplier.rowid}&_time='+t);
			}else{
				alert(result.message);
			}
		}
	});
	
}


function openModal(type,status,id){
	$("#ordertype").val(type);
	$("#rowId").val(id);
	$("#status").val(status);
	$("#statusModal").modal('show');
};

/* 设置状态 */
function setStatus(){
	var type = $("#ordertype").val();
	var id = $("#rowId").val();
	var status = $("#status").val();
	var comm = $("#comm").val();
	var t=new Date().valueOf();
	var bo = confirm("确定修改订单状态？");
	if(bo){
		var url = '<%=path%>/yundongjia/orderStatus';
		if(type == 0){
			url = '<%=path%>/yundongjia/supplierStatus';
		}
		$.ajax({
			url:url,
			type:'post',
			dataType:'json',
			data:{
				type:type,
				status:status,
				rowId:id,
				comm:comm,
				_time:t
			},
			success:function(result){
				if(result.result){
					alert("状态更新成功");
					$('#statusModal').hide();
			        $('.modal-backdrop').attr("hidden",true);
					var t = new Date().valueOf();
					if(type == 0){
						$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=3&id=${supplier.rowid}&_time='+t);
					}else{
						$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=1&id=${supplier.rowid}&_time='+t);
					}
				}else{
					alert("状态更新失败");
				}
			}
		});
	}
}

function update(){
	$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=-1&id=${supplier.rowid}');
}

function saveApply(){
	var accountInfo = $("#accountInfo").val();
	var comeMoney = $("#comeMoney").val();
	var useableMoney = parseFloat($("#useableMoney").html());
	if(comeMoney.length == 0){
		alert("请输入储值金额");
		return ;
	}
	var reg = /^[0-9.]+$/;
	if(!reg.test(comeMoney)){
		alert("请输入正确的储值金额");
		return ;
	}
	if(comeMoney > useableMoney){
		alert("提现金额大于可提现金额");
		return ;
	}
	var url = '<%=path%>/yundongjia/insertApply';
	$.ajax({
		url:url,
		type:'post',
		dataType:'json',
		data:{
			accountInfo:accountInfo,
			comeMoney:comeMoney,
		},
		success:function(result){
			if(result.result){
				alert(result.message);
				$('#modal-container2').hide();
		        $('.modal-backdrop').attr("hidden",true);
				var t = new Date().valueOf();
				$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=3&id=${supplier.rowid}&_time='+t);
			}else{
				alert(result.message);
			}
		}
	});
	
}

function updateApplyStatus(status , id){
	var bo = confirm("确定修改提现状态？");
	if(bo){
		var url = '<%=path%>/yundongjia/updateApplyStatus';
		$.ajax({
			url:url,
			type:'post',
			dataType:'json',
			data:{
				applystatus:status,
				rowid:id,
			},
			success:function(result){
				if(result.result){
					alert(result.message);
					var t = new Date().valueOf();
					$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=3&id=${supplier.rowid}&_time='+t);
				}else{
					alert(result.message);
				}
			}
		});
	}
}

function applyDetail(obj){
	var id = $(obj).attr("rowid");
	var t = new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/applydetail?id='+ id +'&_time='+t);
}
</script>	
</body>
</html>
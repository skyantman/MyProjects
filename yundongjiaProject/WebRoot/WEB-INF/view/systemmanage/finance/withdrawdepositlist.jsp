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
<title>提现列表</title>

</head>
<body>
	<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 提现列表 </a>
	</div>
	<div class="main-content-inquire">
		<div class="main-content-item" style="padding: 0px;">
			<table class="table" style="max-width: 50%;" rules="cols" frame="box">
				<thead>
					<tr>
						<th>提现总金额</th>
						<th>已提现金额</th>
						<th>待提现金额</th>
						<th>需审批订单数</th>
						<th>今日新增订单数</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${statis.totalMoney}</td>
						<td>${statis.ytxMoney}</td>
						<td>${statis.stayMoney}</td>
						<td>${statis.spNum}</td>
						<td>${statis.todayNum}</td>
					</tr>
				</tbody>
			</table>
			<!-- 搜索条件 -->
			<div class="col-md-12 padding0L" style="padding-top: 1%;">
				<form id="form" name="form1" onsubmit="return false;" method="post">
					<div class="col-md-12 padding0L">
						<div class="form-group col-md-2 padding0L">提现日期：</div>
						<div class="form-group col-md-2 padding0L">
							<input id="startDate" name="startDate" size="16"
								readonly="readonly" type="text"
								onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
								value="" class="form_datetime form-control" placeholder="开始日期" />

						</div>


						<div class="form-group col-md-2 padding0L">
							<input id="endDate" name="endDate" size="16" readonly="readonly"
								type="text"
								onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
								value="" class="form_datetime form-control" placeholder="结束日期" />

						</div>
					</div>

					<div class="col-md-12 padding0L">
						<div class="form-group col-md-2 padding0L">手机号：</div>
						<div class="form-group col-md-3 padding0L">
							<input placeholder="请输入手机号码" class="form-control" type="text"
								id="mobilePhoneNum" name="mobilePhoneNum" value=""/>
						</div>
					</div>

					<div class="col-md-12 padding0L">
						<div class="form-group col-md-2 padding0L">订单状态：</div>
						<div class="form-group col-md-3 padding0L">
							<select class="form-control btn btn-default" name="applyStatus"
								id="applyStatus">
								<option value="-1" selected="selected">全部</option>
								<option value="0">处理中</option>
								<option value="1">已提现</option>
								<option value="2">已取消</option>
							</select>
						</div>
					</div>
					<div class="col-md-12 padding0L">
						<div class="col-md-6">
							<button type="button"
								class="btn btn-default col-md-offset-8 col-md-2 bcColor"
								onclick="searchForm(1,false);">搜索</button>
						</div>
						<!-- <div class="col-md-6">
							<button type="button"
								onclick="exportExcel('yundongjia/exportactivity')"
								class="btn btn-default col-md-offset-10 col-md-3 bcColor">导出Excel</button>
						</div> -->


					</div>
				</form>
			</div>
			<div class="main-content-item">
				<table class="table" rules="cols" frame="box">
					<thead>
						<tr>
							<th>提现订单ID</th>
							<th>供应商</th>
							<th>提现金额</th>
							<th>用户</th>
							<th>提现日期</th>
							<th>订单状态</th>
							<th>短信状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="applyTbody">
						<c:forEach items="${appliys.list}" var="a">
							<tr>
								<td>${a.orderNum }</td>
								<td>${a.supplierName }</td>
								<td>${a.amount }</td>
								<td>${a.loginMobilePhone }</td>
								<td>${a.createDate }</td>
								<td>${a.applyStatusName }</td>
								<td>${a.messageStatusName }</td>
								<td><a href="javascript:void(0);"
									onclick="detail(${a.rowId});">详情</a> <c:if
										test="${a.applyStatus == 0}">
										<a href="javascript:void(0);"
											onclick="setStatus(${a.rowId},1);">提现成功</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="main-content-footer" style="padding-bottom: 1%;">
				<div class="page" id="page"></div>
			</div>


		</div>
	</div>
	<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="<%=path%>/static/js/pageTemplate.js"></script>
	<script type="text/javascript" src="<%=path%>/static/js/gym/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/x-javascript-tmpl" id="applyTmpl">
<tr>
								<td>{{= orderNum }}</td>
								<td>{{= amount }}</td>
								<td>{{= loginMobilePhone }}</td>
								<td>{{= createDate }}</td>
								<td>{{= applyStatusName }}</td>
								<td>{{= messageStatusName }}</td>
								<td><a href="javascript:void(0);"
									onclick="detail({{= rowId}});">详情</a> 

{{if applyStatus == 0 }}

<a href="javascript:void(0);" onclick="setStatus({{= rowId}},1);">提现成功</a>

{{/if}}

</td>
							</tr>
</script>		
	<script type="text/javascript">	
/* 搜索条件 */
function searchForm(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	var startTime=$("#startDate").val();
	var endTime=$("#endDate").val();
	var mobilePhoneNum=$("#mobilePhoneNum").val();
	var applyStatus=$("#applyStatus").val();
	$.ajax({
		url:'<%=path%>/yundongjia/applysearch',
		dataType:'json',
		type:'post',
		data:{
			startDate:startTime,
			endDate:endTime,
			mobilePhoneNum:mobilePhoneNum,
			applyStatus:applyStatus,
			pageNum:pageNum,
			_time:t
		},
		success:function(data){
			$("#applyTbody").html($("#applyTmpl").tmpl(data.list));
			paging('page', 'searchForm', data);
		}
	});
}
function pageInfoList(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load("<%=path%>/yundongjia/applylist",{pageNum:pageNum,_time:t});
}
$(document).ready(function(){
	var pageNum=${appliys.pageNum};
	var pages=${appliys.pages};
	var pi={"pageNum":pageNum,"pages":pages};
	paging('page', 'pageInfoList', pi);
});
 function detail(id){
	 var t=new Date().valueOf();
	 $(".index-right").load('<%=path%>/yundongjia/applydetail', {id:id,_time:t});
 }
 //设置提现状态
 function setStatus(id,status){
	 var msg="确定";
	 
	 if(1 == status){
		 msg+="提现";
	 }
	 msg+="吗?";
	 var flag = confirm(msg);
	 if(!flag){
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
			 _time:t
		 },
		 success:function(data){
			 console.log(data);
			 if(data.result > 0){
				 alert(data.message);
				 pageInfoList(1, false);
			 }else{
				 alert(data.message);
			 }
		 }
	 });
 }
</script>
</body>
</html>
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
<title>活动详情</title>
<script type="text/javascript">
function toback(num){
	var url="";
	var t = new Date().valueOf();
	if(num == 1){
		url='<%=path%>/yundongjia/listactivity?_time='+t;
	}
	tobackDemo(url);
}
</script>
</head>
<body>
<div class="main-content reManage " id="reManage">
		<div class="page-header">
			当前位置： <a href="javascript:toback(1);">活动列表</a> &nbsp; &gt; &nbsp; <a
				href="javascript:(0);"> 活动详情 </a>
		</div>
		<div class="main-content-inquire">
			<div class="main-content-item">
				<table class="table" rules="cols" frame="box">
					<thead>
						<tr>
							<th>活动ID</th>
							<th>活动名称</th>
							<th>已报名人数</th>
							<th>活动收入</th>
							<th>活动成本</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						 <td>${ac.activeId}</td>
						 <td>${ac.activeName }</td>
						 <td>${ac.bmNumber }</td>
						 <td>${ac.totalMoney}</td>
						 <td>${ac.costPrice}</td>
						 <td>${ac.statusName }</td>
							<td><c:if test="${ac.status == 0}">
									<a href="javascript:void(0)"
										onclick="setStatus(1,${ac.activeId})">禁用</a>
								</c:if> <c:if test="${ac.status == 1}">
									<a href="javascript:void(0)"
										onclick="setStatus(0,${ac.activeId})">启用</a>
								</c:if> <c:if test="${ac.status == 3}">
									<a href="javascript:void(0)"
										onclick="setStatus(0,${ac.activeId})">审核通过</a>
								</c:if></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- tab -->
		<div class="main-content-inquire">
		  <div class="tabbable">
				<ul class="nav nav-tabs">
					<li <c:if test="${tab == 1}">class="active"</c:if> ><a
						href="#panel-0" value="0" data-toggle="tab">活动详情</a></li>
					<li <c:if test="${tab == 2}">class="active"</c:if>  ><a
						href="#panel-1" value="1" data-toggle="tab">用户管理</a></li>

					
				</ul>
				<div class="tab-content">
					 <div class="tab-pane   <c:if test="${tab == 1}">active</c:if>  " id="panel-0">
					    <input type="hidden" id="activityId" value="${ac.activeId}">
					    <div class="main-content-item">
							<table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">活动名称：</label>
										</div>
									</td>
									<td style="">
										<div class="form-group">
											<label for="">${ac.activeName}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">活动类型：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeTypeName}</label>
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
											<label for="">${ac.provinceName}${ac.cityName }${ac.areaName }      </label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">活动地址：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeAddres}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">活动日期：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeStartTime}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">活动限制人数：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeNum }人</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">已报名人数：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for=""><span style="color:red;">${ac.bmNumber }</span> 人</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">活动费用：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for=""><span style="color:red;">${ac.activeNum}</span>元</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">企业卡：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for=""><span style="color:red;">${ac.activeSubNum }</span>次</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">关键字：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeKeyword}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">活动介绍：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeIntroduce}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">注意事项：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeComm}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">地图位置：</label>
										</div>
									</td>
									<td>
										<div class="col-md-12" style="width: 630px; height: 390px;border: 1px solid gray;">
				<div class="col-md-12 padding0L padding5T">经度：${ac.lng } &nbsp;&nbsp;维度：${ac.lat }</div>
				
				<div id="container" class="padding0L form-group" 
				style="position: absolute;overflow:hidden;margin-top:30px; 
				width: 90%; height: 85%; top: 50; ">
					
				</div>
				
				
			</div>
										 
									</td>
								</tr>
								<tr>
									<td style=" ">
										<div class="form-group">
											<label for="">活动相册：</label>
										</div>
									</td>
									<td style="width: 90%;">
										 
										 <c:forEach items="${imgs}" var="att">
										 	 <img class="col-md-1"  value=""  alt='' src="${att.path}"  height='100px' style='padding: 5px;'>
										 	 
										 </c:forEach>
										  
										  
										<%--  <img class="col-md-1"  value=""  alt='' src="<%=path %>/static/images/activityImages/1484903994858.png" width='50px' height='100px' style='padding: 1px;'>
										 <img class="col-md-1"  value=""  alt='' src="<%=path %>/static/images/activityImages/1484905320195.png " width='50px' height='100px' style='padding: 1px;'>
										 <img class="col-md-1"  value=""  alt='' src="<%=path %>/static/images/activityImages/1484893188346.png" width='50px' height='100px' style='padding: 1px;'>
										 <img class="col-md-1"  value=""  alt='' src="<%=path %>/static/images/activityImages/1484893188346.png " width='100px' height='100px' style='padding: 1px;'>
										   <img class="col-md-1"  value=""  alt='' src="<%=path %>/static/images/activityImages/1484905360711.png" width='100px' height='100px' style='padding: 5px;'>
										  --%>
										 
										 
										  
										
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">关联场馆：</label>
										</div>
										
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.studioName }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆成本价：</label>
										</div>
										
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.studioCost }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">关联教练：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.nickName }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">教练成本价：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.coachCosts }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">取消限制：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${ac.activeLimName}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										 
									</td>
									<td>
										<div class="form-group">
											 <input  id="" type="button" onclick="edit();"
								class="btn btn-default bcColor" value="编辑信息">
										</div>
									</td>
								</tr>
							</table>
						</div>
					 </div>
					 <!-- 用户管理 -->
					  <div class="tab-pane  <c:if test="${tab == 2}">active</c:if>  " id="panel-1">
						<div class="col-md-12 padding0L" style="padding-top: 1%;">
							<div class="col-md-12 padding0L">
								<!-- <div class="form-group col-md-2 padding0L">手机号：</div> -->
								<div class="form-group col-md-4 padding0L">
									<input placeholder="请输入手机号" class="form-control" type="text"
										id="mobilePhone" name="mobilePhone" />
								</div>
								<div class="form-group col-md-3 padding0L">
									<button type="button"
										class=" btn btn-default col-md-offset-1 col-md-3 bcColor"
										onclick="search(1,false);">搜索</button>
								</div>
							</div>
							<div class="col-md-12 padding0L">参与活动人数<span style="color:red;">${statis.yzfStatus}</span>人</div>
						</div>
						<div class="main-content-item" style="padding-top:0px; ">
					    	<table class="table" rules="cols" frame="box">
					    		<thead>
					    			<tr>
					    				<th>用户ID</th>
					    				<th>姓名</th>
					    				<th>性别</th>
					    				<th>手机号</th>
					    				<th>订单来源</th>
					    				<th>支付方式</th>
					    				<th>状态</th>
					    				<th>操作</th>
					    			</tr>
					    		</thead>
					    		<tbody id="userTbody">
					    			<c:forEach items="${users.list}" var="u">
					    			  <tr>
					    				<td>${u.orderId }</td>
					    				<td>${u.aName }</td>
					    				<td>${u.genderName}</td>
					    				<td>
					    				<a href="javascript:void(0);" onclick="userDetail(${u.userId})">
					    				${u.mobilePhoneNum }
					    				</a>
					    				</td>
					    				<td>${u.sourceName}</td>
					    				<td>${u.payTypeName}</td>
					    				<td>${u.payStatusName}</td>
					    				<td>
					    				<a href="javascript:void(0);" onclick="userOrderDetail(${u.orderId});">详情</a>
					    				&nbsp;&nbsp;
					    				<c:if test="${u.payStatus == 2}">
					    					<a href="javascript:void(0);" onclick="setOrderStatus(3,${u.orderId});">退订</a>
					    				</c:if>
					    				<c:if test="${u.payStatus == 0 }">
					    					<a href="jajvascript:void(0);" onclick="setOrderStatus(1,${u.orderId});">取消</a>
					    				</c:if>
					    				</td>
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
			</div>
		</div>
		<!-- 操作记录 -->
		<div class="main-content-inquire">
			<div class="main-content-item">
				<table class="table" style="width: 60%;" rules="cols" frame="box">
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
					<tbody id="userTbody">
						<c:forEach items="${ops }" var="op">
							<tr>
								<td>${op.opeartion_id }</td>
								<td>${op.user_name }</td>
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
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>	
<script type="text/x-javascript-tmpl" id="userListTmpl">
<tr>
					    				<td>{{= orderId }}</td>
					    				<td>{{= aName }}</td>
					    				<td>{{= genderName}}</td>
					    				<td>
					    				<a href="javascript:void(0);" onclick="userDetail({{= userId}})">
					    				{{= mobilePhoneNum }}
					    				</a>
					    				</td>
					    				<td>{{= sourceName}}</td>
					    				<td>{{= payTypeName}}</td>
					    				<td>{{= payStatusName}}</td>
					    				<td>
					    				<a href="javascript:void(0);" onclick="userDetail();">详情</a>
					    				&nbsp;&nbsp;
					    				<c:if test="{{= payStatus == 2}">
					    					<a href="javascript:void(0);" onclick="setOrderStatus(3,{{= orderId}});">退订</a>
					    				</c:if>
					    				</td>
					    			</tr>
</script>
<script type="text/javascript">

var map;
function init() {
	map = new BMap.Map("container");            // 创建Map实例
	var x = ${ac.lng};
	var y = ${ac.lat };
	var point = new BMap.Point(x, y);
	map.centerAndZoom(point,12);                 
	
	marker = new BMap.Marker(new BMap.Point(x, y)); // 创建点
	map.addOverlay(marker);
	 
	 
}

//用户管理 全查分页
function userManagePageInfo(pageNum,flag){
	if(flag){
		return false;
	}
	 var t=(new Date()).valueOf();
	 var id = $("#activityId").val();
	 $(".index-right").load('<%=path%>/yundongjia/detailactivity?activityId='+id+'&pageNum='+pageNum+'&tab=2&_time='+t);
}
$(document).ready(function(){
	init();//初始化地图
	$('.tabbable a').click(function (e) {
		  e.preventDefault()
		  var v = parseInt($(this).attr("value"));
		  var t=(new Date()).valueOf();
		  var id = $("#activityId").val();
		  switch(v){
		  case 0://详情
			  $(".index-right").load('<%=path%>/yundongjia/detailactivity?activityId='+id+'&pageNum=1&tab=1&_time='+t);

			  break;
		  case 1://用户管理
			  $(".index-right").load('<%=path%>/yundongjia/detailactivity?activityId='+id+'&pageNum=1&tab=2&_time='+t);
			  
			  break;
		 
		  }
		  //$(this).tab('show')
	});
	
	var tabId = ${tab};
	if(2 == tabId){
		var pages = ${users.pages};
		var pageNum = ${users.pageNum};
		var pi={"pageNum":pageNum,"pages":pages};
		paging('page', "userManagePageInfo", pi);
	}
	
});
//用户详情
function userDetail(userId){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/memberDetail?userId='+userId+'&status=1&_time='+t);
}
//订单详情
function userOrderDetail(orderId){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/getorderbyid?orderId='+orderId+'&orderType=4&nav=1&_time='+t);
}
//编辑
function edit(){
	var id=$("#activityId").val();
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/toeditactivity',{activityId:id,_time:t});
}

//设置数据状态
function setStatus(num,id){
	var msg='确定';

	if(1 == num){
		msg+="禁用";
	}else{
		msg+="启用";
	}
	msg+="吗?";
	var f = confirm(msg);
	if(!f){
		return false;
	}
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/updateactivitystatus',
		type:'post',
		dataType:'json',
		data:{
			status:num,
			activityId:id,
			_time:t
		},
		success:function(result){
			if(result > 0){
				alert("操作成功");
				var t=new Date().valueOf();
				$(".index-right").load('<%=path%>/yundongjia/detailactivity?activityId='+id+'&tab=1&_time='+t);
			}
		}
	});
}
//设置订单状态
function setOrderStatus(num,id){
	var msg="确定";
	if(1 == num){
	 msg+="取消";
	}else if(3 == num){
		msg+="退订";
	}
	msg+="吗";
	var f = confirm(msg);
	if(!f){
		return false;
	}
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/updateactivityorderstatus',
		type:'post',
		dataType:'json',
		data:{
			status:num,
			actOrderId:id,
			_time:t
		},
		success:function(result){
			if(result > 0){
				alert("操作成功");
				userManagePageInfo(1,false);
			}
		}
	});
}
/* 用户管理  --》根据手机号码查询 */
function search(pageNum,flag){
	if(flag){
		return false;
	}
	var mp = $("#mobilePhone").val();
	var id=$("#activityId").val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/selectactiorderbymp',
		type:'post',
		dataType:'json',
		data:{
			mobilePhoneNum:mp,
			activityId:id,
			_time:t
		},
		success:function(data){
			$("#userTbody").html($("#userListTmpl").tmpl(data.list));
			paging('page', "search", data);
		}
	})
	
}
</script>	
</body>
</html>
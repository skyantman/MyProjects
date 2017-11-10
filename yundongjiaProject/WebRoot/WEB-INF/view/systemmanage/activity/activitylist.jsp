<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活动列表</title>
</head>
<body>
	<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 活动列表 </a>
	</div>
	<div class="main-content-inquire" >
		<div class="main-content-item" style="padding: 0px;">
			<table class="table" style="width: 80%;" rules="cols" frame="box">
				<thead>
				  <tr>
				  	<th>活动总数</th>
				  	<th>报名人数</th>
				  	<th>活动总收入</th>
				  	<th>待审核活动</th>
				  	<th>今日活动数</th>
				  	<th>今日报名人数</th>
				  	<th>禁用活动数</th>
				  </tr>
				</thead>
				<tbody class="font-size-weight">
					<tr>
					 <td>${activitys.total}</td>
					 <td>${statis.enrollNum }</td>
					 <td>${statis.totalSumMoney}</td>
					 <td>${statis.noAuditNum}</td>
					 <td>${statis.todayNum}</td>
					 <td>${statis.todayEnrollNum}</td>
					 <td>${statis.disableNum }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-12 padding0L" style="padding-top: 1%;">
		   <form id="searchform" name="searchform" onsubmit="return false;"  method="post">
		   <input type="hidden" id="pageNum" value="">
		   <div class="col-md-12 padding0L">
		   <div class="form-group col-md-2 padding0L">
	       	活动名称：
	       	 </div>
			  <div class="form-group col-md-4 padding0L">
					<input placeholder="请输入活动名称" class="form-control" type="text"
						id="activename" name="activename" />
				</div>
			</div>
			<div class="col-md-12 padding0L">
			   <div class="form-group col-md-2 padding0L">活动场馆:</div>
					<div class="form-group col-md-4 padding0L">
						<select id="studioid" name="studioid" class="form-control btn btn-default">
							<option value="-1">请选择</option>
							<c:forEach items="${studios}" var="s">
							<option value="${s.studioid }">${s.studioname }</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">活动教练:</div>
					<div class="form-group col-md-4 padding0L">
						<select id="coachids" name="coachids" class="form-control btn btn-default">
							<option value="-1">请选择</option>
							<c:forEach items="${coachs}" var="c">
							<option value="${c.coachid }">${c.nickname }</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">活动日期：</div>
					<div class="form-group col-md-2 padding0L">
						<input id="activestarttime" name="activestarttime  " size="16" readonly="readonly" type="text"
							onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="开始日期" />

					</div>


					<div class="form-group col-md-2 padding0L">
						<input id="activeendtime" name="activeendtime" size="16" readonly="readonly" type="text"
							onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="结束日期" />

					</div>
				</div>

				<div class="col-md-12 padding0L">
				  <div class="form-group col-md-2 padding0L">所在城市：</div>
				  <div class="form-group col-md-2 padding0L">
				       <select id="province" name="province" class="form-control btn btn-default" onchange="loadCity(this);">
							<option value="-1">省</option>
							<c:forEach items="${pros}" var="p">
						     <option value="${p.code }" >${p.name }</option>
						    </c:forEach>
						</select>
						
				  </div>
				  <div class="form-group col-md-2 padding0L">
				     <select id="city" name="city" class="form-control btn btn-default" onchange="loadArea(this);">
							<option value="-1">市</option>

						</select>
				  </div>
				  <div class="form-group col-md-2 padding0L">
				     <select id="area" name="regionsid" class="form-control btn btn-default">
							<option value="-1">区</option>

						</select>
				  </div>
				</div>
				
				<div class="col-md-12 padding0L">
				  <div class="form-group col-md-2 padding0L">活动状态：</div>
				  <div class="form-group col-md-4 padding0L">
						<select id="status" name="status" class="form-control btn btn-default">
							<option value="-1">请选择</option>
							<option value="3">未审核</option>
							<option value="0">生效</option>
							<option value="1">禁用</option>
						</select>
					</div>
				</div>
				
				<div class="col-md-12 padding0L">
					<div class="col-md-6">
					  <button type="button"
					class="btn btn-default col-md-offset-8 col-md-2 bcColor" onclick="searchForm(1,false);">搜索</button>
					</div>
				   <div class="col-md-6">
				     <button type="button" onclick="exportExcel(0)"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor" >导出Excel</button>
				   </div>
					
					 
				</div>
				

			</form>
		</div>
		<div class="main-content-item">
			<table class="table" rules="cols" frame="box">
				<thead>
				 <tr>
				  <th>活动ID</th>
				  <th>活动类型</th>
				  <th>所在城市</th>
				  <th>活动名称</th>
				  <th>活动场馆</th>
				  <th>活动教练</th>
				  <th>活动时间</th>
				  <th>活动人数</th>
				  <th>已报名人数</th>
				  <th>活动费用</th>
				  <th>状态</th>
				  <th>操作</th>
				 </tr>
				</thead>
				<tbody id="listTbody">
				<c:forEach items="${activitys.list}" var="ac">
				  <tr>
				 <td>${ac.activeId }</td>
				 <td>${ac.activeTypeName }</td>
				 <td>${ac.provinceName }</td>
				 <td>${ac.activeName }</td>
				 <td>${ac.studioName }</td>
				 <td>${ac.nickName}</td>
				 <td>
				 ${ac.activeStartTime }至
				 ${ac.activeEndTime }
				 </td>
				 <td>${ac.activeNum }</td>
				 <td>
					 ${ac.bmNumber}
				 </td>
				 <td>
				  <c:if test="${ac.activePrice == -1}">-</c:if>
				  <c:if test="${ac.activePrice > -1}">${ac.activePrice}元</c:if>
				  &nbsp;/&nbsp;
				  <c:if test="${ac.activeSubNum == -1 }">--</c:if>
				  <c:if test="${ac.activeSubNum > -1 }">${ac.activeSubNum}次</c:if>
				 </td>
				 <td>${ac.statusName }</td>
				 <td>
				 <a href="javascript:void(0);" onclick="detail(${ac.activeId});">详情</a>
				 &nbsp;
				 
				 <c:if test="${ac.status == 3}">
				 <a href="javascript:edit(${ac.activeId})">编辑</a>
				 </c:if>
				 
				 &nbsp;
				 <a href="javascript:void(0)" onclick="userManage(${ac.activeId});">用户管理</a>
				 <c:if test="${ac.status == 0}">
				  <a href="javascript:void(0)" onclick="setStatus(1,${ac.activeId})">禁用</a>
				 </c:if>
				 <c:if test="${ac.status == 1}">
				  <a href="javascript:void(0)" onclick="setStatus(0,${ac.activeId})">启用</a>
				 </c:if>
				 <c:if test="${ac.status == 3}">
				 	 <a href="javascript:void(0)" onclick="setStatus(0,${ac.activeId})">审核通过</a>
				 </c:if>
				 
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
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/gym/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<!-- 市模板 -->
<script type="text/x-javascript-tmpl" id="cityTmpl">
<option value="{{= code}}">{{= name}}</option>
</script>

<script type="text/x-javascript-tmpl" id="listTmpl">
<tr>
  <td>{{= activeId}} </td>
  <td>{{= activeTypeName}}</td>
  <td>{{= provinceName}}</td>
  <td>{{= activeName}}</td>
  <td>{{= studioName}}</td>
  <td>{{= nickName}}</td>
  <td>{{= activeStartTime}}至{{= activeEndTime}}</td>
  <td>{{= activeNum}}</td>
  <td>{{= bmNumber}}</td>
  <td>
	{{if activePrice == -1}} - 
	{{else}}
	{{= activePrice}}元
	{{/if}}
&nbsp;
	{{if activeSubNum == -1}} - 
	{{else}}
		{{= activeSubNum}}次
	{{/if}}
  </td>
  <td>
	{{= statusName}}
  </td>
  <td>
    <a href="javascript:void(0);" onclick="detail({{= activeId}});">详情</a>
&nbsp;
	<a href="javascript:edit({{= activeId}})">编辑</a>


&nbsp;
<a href="javascript:void(0)" onclick="userManage({{= activeId}});">用户管理</a>

{{if status == 0}}
   <a href="javascript:void(0)" onclick="setStatus(1,{{= activeId}})">禁用</a>
{{else status == 1}}
   <a href="javascript:void(0)" onclick="setStatus(0,{{= activeId}})">启用</a>
{{else status == 3}}
   <a href="javascript:void(0)" onclick="setStatus(0,{{= activeId}})">审核通过</a>
{{/if}}


  </td>
</tr>
</script>

<script type="text/javascript">
/* 活动详情 */
function detail(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/detailactivity?activityId='+id+'&tab=1&_time='+t);
}
/* 编辑活动 */
function edit(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/toeditactivity?activityId='+id+'&_time='+t);
}
//用户管理
function userManage(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/detailactivity?activityId='+id+'&tab=2&_time='+t);
}
//查询分页
function pageInfoList(pageNum,check){
	if(check){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/listactivity?pageNum='+pageNum+'&_time='+t);
}
$(document).ready(function(){
	var pageNum = ${activitys.pageNum};
	var pages = ${activitys.pages};
	var pi = {"pageNum":pageNum,"pages":pages};
	paging("page", "pageInfoList", pi);
});
//省change事件
function loadCity(obj){
	var proid = $(obj).val();
	var value = $("#province").val();
	var t = new Date().valueOf();
	//加载市
	$.ajax({
		url:'<%=path%>/yundongjia/getcitybypro',
		type:'post',
		dataType:'JSON',
		data:{
			_time:t,
			proCode:proid
		},
		success:function(data){
			$("#city").html("");
			$("#city").append("<option value='-1'>市</option>");
			$("#city").append($("#cityTmpl").tmpl(data));
		}
	});
}
//市change事件
function loadArea(obj){
	var value = $(obj).val();
	var t = new Date().valueOf();
	//加载区
	$.ajax({
		url:'<%=path%>/yundongjia/getareabycity',
		type:'post',
		dataType:'JSON',
		data:{
			_time:t,
			cityCode:value
		},
		success:function(data){
			$("#area").html("");
			$("#area").append("<option value='-1'>区</option>");
			$("#area").append($("#cityTmpl").tmpl(data));
		}
	});
}
//多条件查询
function searchForm(pageNum,flag){
	if(flag){
		return false;
	}
	$("#pageNum").val(pageNum);
	var data = new FormData($("#searchform")[0]);
	$.ajax({
		url:'<%=path%>/yundongjia/selectactivity',
		type : 'post',
		dataType : 'json',
		data : data,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			$("#listTbody").html($("#listTmpl").tmpl(result.list));
			paging("page", "searchForm", result);
			
		}
	});	
}
//设置数据状态
function setStatus(num,id){
	var arg="确定";
	var mess="";
	switch(num){
		case 0:
			mess="启用或审核通过";
			break;
		case 1:
			mess="禁用";
			break;
	}
	arg+=mess+="吗?";
	var flag = confirm(arg);
	if(!flag){
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
				pageInfoList(1);
			}
		}
	});
}
</script>	
</body>
</html>
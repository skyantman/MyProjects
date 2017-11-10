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
<title>资讯列表</title>
</head>
<body>
<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 资讯列表 </a>
</div>
	<div class="col-md-12 padding0L" style="padding-top: 1%;">
		<div class="col-md-12 padding0L">
			<div class="form-group col-md-1 padding0L">关键字：</div>
			<div class="form-group col-md-8 padding0L">
				<input placeholder="请输入标题或正文" class="form-control" type="text"
					id="searchInput" name="searchInput" />
			</div>

			<div class="col-md-3">
				<button type="button"
					class="btn btn-default col-md-offset-0 col-md-4 bcColor"
					onclick="search(1,false);">搜索</button>
			</div>
			 

		</div>

	</div>
	<div class="main-content-item">
  <table class="table" rules="cols" frame="box">
  	<thead>
  	  <tr>
  	  	<th>资讯ID</th>
  	  	<th>标题</th>
  	  	<th>类型</th>
  	  	<th>创建时间</th>
  	  	<th>状态</th>
  	  	<th>操作</th>
  	  </tr>
  	</thead>
  	<tbody id="infoList">
  	 <c:forEach items="${res.list}" var="info">
  	  <tr>
  		<td>${info.rowId }</td>
  		<td>${info.infoTitle }</td>
  		<td>${info.infoTypeName }</td>
  		<td>${info.createDate }</td>
  		<td>${info.statusName }</td>
  		<td>
  		<a href="javascript:void(0);" onclick="detail(${info.rowId});">详情</a>
  		
  		<c:if test="${info.status == 0}">
  			<a href="javascript:void(0);" onclick="setStatus(${info.rowId},1);">禁用</a>
  		</c:if>
  		<c:if test="${info.status == 1}">
  			<a href="javascript:void(0);" onclick="setStatus(${info.rowId},0);">启用</a>
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
	<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>	
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/x-javascript-tmpl" id="listTmpl">
<tr>
 <td>{{= rowId}}</td>
 <td>{{= infoTitle}}</td>
 <td>{{= infoTypeName}}</td>
 <td>{{= createDate}}</td>
 <td>{{= statusName}}</td>
 <td>
<a href="javascript:void(0);" onclick="detail({{= rowId}});">详情</a>
{{if status == 0}}
<a href="javascript:void(0);" onclick="setStatus({{= rowId}},1);">禁用</a>
{{else status == 1}}
<a href="javascript:void(0);" onclick="setStatus({{= rowId}},0);">启用</a>
{{/if}}
</td>

</tr>
</script>
<script type="text/javascript">
function pageInfoList(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/informationlist',{pageNum:pageNum,_time:t});
}
$(document).ready(function(){
	var pages=${res.pages};
	var pageNum=${res.pageNum};
	var pi={"pageNum":pageNum,"pages":pages};
	paging('page', 'pageInfoList', pi);
});
function detail(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/informationdetail',{id:id,_time:t});
}
/* 条件搜索 */
function search(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	var tc=$("#searchInput").val();
	$.ajax({
		url:'<%=path%>/yundongjia/selectinformationbytc',
		type:'post',
		dataType:'json',
		data:{
			strContext:tc,
			pageNum:pageNum,
			_time:t		
		},
		success:function(data){
			$("#infoList").html($("#listTmpl").tmpl(data.list));
			paging('page', 'search', data);
		}
	});
}
/* 修改状态 */
function setStatus(id,status){
	var msg = status == 0?"确定启用吗?":"确定禁用吗?"
	var flag = confirm(msg);
	if(!flag){
		return false;
	}
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/updateinformationstatus',
		type:'post',
		dataType:'json',
		data:{
			id:id,
			status:status,
			_time:t
		},
		success:function(data){
			if(data>0){
				alert("操作成功");
				$(".index-right").load('<%=path%>/yundongjia/informationlist',{pageNum:1,_time:t});
			}else{
				alert("操作失败");
			}
		}
	});
	
}
</script>
</body>
</html>
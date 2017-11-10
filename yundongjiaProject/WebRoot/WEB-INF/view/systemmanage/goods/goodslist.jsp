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
<title>商品列表</title>
</head>
<body>
<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 商品列表 </a>
</div>
<div class="main-content-inquire" >
		<div class="main-content-item" style="padding: 0px;">
			<table class="table" style="width: 80%;" rules="cols" frame="box">
				<thead>
					<tr>
						<th>商品总数</th>
						<th>已审核商品</th>
						<th>已禁用</th>
						<th>未审核商品</th>
					</tr>
				</thead>
				<tbody class="font-size-weight">
					<tr>
						<td>${gs.total}</td>
						<td>${statis.statusOk }</td>
						<td>${statis.statusDis }</td>
						<td>${statis.statusAudit }</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="col-md-12 padding0L" style="padding-top: 1%;">
		   <div class="col-md-12 padding0L">
		   <div class="form-group col-md-1 padding0L">商品名称：</div>
			  <div class="form-group col-md-4 padding0L">
					<input placeholder="请输入商品名称" class="form-control" type="text"
						id="gname" name="gname" />
				</div>
				
				<div class="col-md-3">
					  <button type="button"
					class="btn btn-default col-md-offset-0 col-md-4 bcColor" onclick="search(1,false);">搜索</button>
					</div>
				   <div class="col-md-4">
				     <button type="button" onclick="exportExcel(3);"
					class="btn btn-default col-md-offset-10 col-md- bcColor" >导出Excel</button>
				   </div>
				
			</div>
			<!-- <div class="col-md-12 padding0L">
					<div class="col-md-6">
					  <button type="button"
					class="btn btn-default col-md-offset-8 col-md-2 bcColor" onclick="searchList(1,false);">搜索</button>
					</div>
				   <div class="col-md-6">
				     <button type="button"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor" >导出Excel</button>
				   </div>
					
					 
				</div>	 -->
		</div>
		<div class="main-content-item">
		  <table class="table" rules="cols" frame="box">
		  	<thead>
		  		<tr>
		  			<th>商品ID</th>
		  			<th>商品名称</th>
		  			<th>库存</th>
		  			<th>价格</th>
		  			<th>状态</th>
		  			<th>操作</th>
		  		</tr>
		  	</thead>
		  	<tbody id="goodsTbody">
		  		<c:forEach items="${gs.list}" var="g">
		  		  <tr>
		  			<td>${g.goodsId}</td>
		  			<td>${g.gName }</td>
		  			<td>${g.gCount }</td>
		  			<td>${g.gPrice }</td>
		  			<td>${g.statusName }</td>
		  			<td>
		  			<a href="javascript:void(0)" onclick="detail(${g.goodsId})">详情</a>
		  			&nbsp;&nbsp;
		  			 
		  			
		  			<c:if test="${g.status ==0}">
		  			   <a href="javascript:void(0);" onclick="setStatus(${g.goodsId},1);">禁用</a>
		  			   &nbsp;&nbsp;
		  			</c:if>
		  			
		  			<c:if test="${g.status == 1 }">
		  				<a href="javascript:void(0);" onclick="setStatus(${g.goodsId},0);">启用</a>
		  				&nbsp;&nbsp;
		  			</c:if>
		  			
		  			<c:if test="${g.status == 2 }">
		  			    <a href="javascript:void(0)" onclick="edit(${g.goodsId})">编辑</a>
		  			    &nbsp;&nbsp;
		  				<a href="javascript:void(0);" onclick="setStatus(${g.goodsId},0);">审核通过</a>
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
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>	
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/x-javascript-tmpl" id="goodTmpl">
<tr>
		  			<td>{{= goodsId}}</td>
		  			<td>{{= gName }}</td>
		  			<td>{{= gCount }}</td>
		  			<td>{{= gPrice }}</td>
		  			<td>{{= statusName }}</td>
		  			<td>
		  			<a href="javascript:void(0)" onclick="detail({{= goodsId}})">详情</a>
		  			&nbsp;&nbsp;

{{if status == 0}}
<a href="javascript:void(0);" onclick="setStatus({{= goodsId}},1);">禁用</a>
{{/if}}

{{if status == 1}}
<a href="javascript:void(0);" onclick="setStatus({{= goodsId}},0);">启用</a>
{{/if}}

{{if status == 2}}
<a href="javascript:void(0)" onclick="edit({{= goodsId}})">编辑</a>
<a href="javascript:void(0);" onclick="setStatus({{= goodsId}},0);">审核通过</a>
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
	$(".index-right").load('<%=path%>/yungongjia/goodslist?pageNum='+pageNum+'&_time='+t);
}
$(document).ready(function(){
	var pages = ${gs.pages};
	var pageNum=${gs.pageNum};
	var pi={"pageNum":pageNum,"pages":pages};
	paging("page", "pageInfoList", pi);
});
function detail(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/goodsdetail?goodsId='+id+'&_time='+t);
}
function edit(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/updategoodstopage?goodsId='+id+'&_time='+t);
}
//设置状态
function setStatus(id,num){
	var msg="确定";
	if(0 == num){
		msg+="启用或审核通过吗";
	}else if(1 == num){
		msg+="禁用";
	}else if(2 == num){
		msg="审核通过";
	}
	msg +="吗?";
	var flag = confirm(msg);
	if(flag){
		var t=new Date().valueOf();
		$.ajax({
			url:'<%=path%>/yundongjia/updategoodsstatus',
			type:'post',
			dataType:'json',
			data:{
				goodsId:id,
				status:num,
				_time:t
			},
			success:function(data){
				if(data >0){
					alert("操作成功");
					pageInfoList(1,false);
				}
			}
		});
	}
}
/*  */
function search(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	var gname=$("#gname").val();
	$.ajax({
		url:'<%=path%>/yundongjia/selectgoodsbyname',
		type:'post',
		dataType:'json',
		data:{
			gName:gname,
			_time:t
		},
		success:function(result){
			$("#goodsTbody").html($("#goodTmpl").tmpl(result.list));
			paging('page', "search", result);
		}
	});
}
</script>	
</body>
</html>
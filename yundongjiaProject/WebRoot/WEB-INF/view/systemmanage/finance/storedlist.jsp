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
<title>储值列表</title>
</head>
<body>
<div class="page-header">
	当前位置：<a href="javascript:void(0);"> 储值列表 </a>
</div>
<div class="main-content-inquire" >
   <div class="main-content-item" style="padding: 0px;">
	  <table class="table" style="width: 40%;" rules="cols" frame="box">
	  	<thead>
	  		<tr>
	  			<th>储值总金额</th>
	  			<th>总剩余储值额度</th>
	  			<!-- <th>月度过期额度</th>
	  			<th>年度过期额度</th> -->
	  		</tr>
	  	</thead>
	  	<tbody class="font-size-weight">
	  		<tr>
	  			<td>${statis.sumMoney}</td>
	  			<td>${statis.surplusMoney }</td>
	  			<!-- <td></td>
	  			<td></td> -->
	  		</tr>
	  	</tbody>
	  </table>
   </div>

	<div class="main-content-item">
		<table class="table" rules="cols" frame="box">
			<thead>
				<tr>
					<th>储值ID</th>
					<th>储值金额</th>
					<th>供应商名称</th>
					<th>操作人</th>
					<th>储值日期</th>
					<th>有效日期</th>
					<th>储值方式</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sm.list}" var="s">
				  <tr>
					<td>${s.rowId }</td>
					<td>${s.saveMoney }</td>
					<td>${s.supplierName }</td>
					<td>${s.backuserName }</td>
					<td>${s.createDate }</td>
					<td>${s.expiryDate }</td>
					<td>${s.typeName }</td>
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
<script type="text/javascript">
function pageInfoList(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/savemoneylist',{pageNum:pageNum,_time:t});
}
$(document).ready(function(){
	var pageNum=${sm.pageNum};
	var pages=${sm.pages};
	var pi={"pageNum":pageNum,"pages":pages};
	paging('page', 'pageInfoList', pi);
});
</script>
</body>
</html>
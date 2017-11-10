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
<title>企业卡列表</title>
<link href="<%=path%>/static/css/gymcommon.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/static/css/gymstyle.css" rel="stylesheet"
	type="text/css">

<link href="<%=path%>/static/css/gymcss/style.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
.modal-content{
		margin-top: 250px;
}
</style>


<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
</head>
<body>
	<div class="page-header">
		当前位置：<a href="javascript:void(0);">
			供应商列表
		</a>
	</div>
	<div class="main-content-inquire" >
		
			<div class="main-content-item" style="padding: 0px;">
				<table class="table" style="max-width: 50%;" rules="cols" frame="box">
					<thead style="border: 2px solid #0B2F53;">
						<tr>
							<th>供应商总数</th>
							<th>已审核</th>
							<th>已禁用</th>
							<th>未审核</th>
						</tr>
					</thead>
					<tbody id="statisTbody"  class="font-size-weight">
						<tr>
						<td>${supplierStatus.total}</td>
						<td>${supplierStatus.audit }</td>
						<td>${supplierStatus.disable}</td>
						<td>${supplierStatus.noAudit }</td>
						</tr>
					</tbody>
				</table>

			</div>
	
		<div class="col-md-12 padding0L" style="padding-top: 1%;">
			<div class="col-md-12 padding0L">
				<div class="form-group col-md-1 padding0L">供应商名称：</div>
				<div class="form-group col-md-3 padding0L">
					<input placeholder="请输入供应商名称" class="form-control" type="text"
						id="supplierName"  value="${supplierName }"/>
				</div>
			</div>
			<div class="col-md-12 padding0L">
				<div class="form-group col-md-1 padding0L">供应商状态：</div>
				<div class="form-group col-md-3 padding0L">
						<select  id="status"  class="form-control btn btn-default">
							<option value="-1">请选择</option>
							<option <c:if test="${status == 0 }">selected="selected" </c:if> value="0">生效</option>
							<option <c:if test="${status == 1 }">selected="selected" </c:if> value="1">禁用</option>
							<option <c:if test="${status == 2 }">selected="selected" </c:if> value="2">失效</option>
							<option <c:if test="${status == 3 }">selected="selected" </c:if> value="3">未审核</option>
						</select>
				</div>
			</div>
			<div>
				<div class="form-group col-md-offset-4 col-md-5 padding0L">
				  <button type="button"
					class=" btn btn-default col-md-offset-1 col-md-3 bcColor"
					onclick="search(1,false);">搜索</button>
				</div>
			</div>
		</div>
		<div class="main-content-item">
			<table class="table" rules="cols" frame="box">
				<thead>
					<tr>
						<th>供应商ID</th>
						<th>结算类型</th>
						<th>所在城市</th>
						<th>供应商名称</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="eTbody">
					<c:forEach items="${info.list}" var="e">
						<tr>
							<td><a href="javascript:void(0);" onclick="enterDetail(${e.rowid});">${e.rowid}</a></td>
							<td>
								<c:if test="${e.clearingtype==0 }">预付</c:if>
								<c:if test="${e.clearingtype==1 }">周期结算</c:if>
							</td>
							<td>${e.city }</td>
							<td><a href="javascript:void(0);" onclick="enterDetail(${e.rowid});">${e.suppliername}</a></td>
							<td>
								<c:if test="${e.status==0 }">生效</c:if>
								<c:if test="${e.status==1 }">禁用</c:if>
								<c:if test="${e.status==2 }">失效</c:if>
								<c:if test="${e.status==3 }">未审核</c:if>
							</td>
							<td>
							<a href="javascript:void(0)" onclick="enterDetail(${e.rowid});" class="detail">详情</a>&nbsp;&nbsp;
							<c:if test="${e.status == 0}"><a href="javascript:void(0)" onclick="openModal(1,${e.rowid})" class="state">禁用</a></c:if>
							<c:if test="${e.status == 1}"><a href="javascript:void(0)" onclick="openModal(0,${e.rowid})" class="state">启用</a></c:if>
							<c:if test="${e.status == 3}"><a href="javascript:void(0)"  class="userManage" onclick="openModal(0,${e.rowid})" >审核通过</a></c:if>&nbsp;&nbsp;
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




	<script type="text/javascript" src="<%=path%>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>

<script type="text/x-javascript-tmpl" id="tbodyTmpl">
<tr>
		<td>
		<a href="javascript:void(0);" onclick="enterDetail({{= rowid}});">{{= rowid}}</a></td>
		<td>
			{{if clearingtype == 0}}预付
			{{else if clearingtype == 1}} 周期结算
			{{/if}}
		</td>
		<td>{{= city }}</td>
		<td><a href="javascript:void(0);" onclick="enterDetail({{= rowid}});">{{= suppliername}}</a></td>
		<td>
			{{if status == 0}}生效
			{{else if status == 1}} 禁用
			{{else if status == 2}} 失效
			{{else if status == 3}} 未审核
			{{/if}}
		</td>
		<td>
		<a href="javascript:void(0)" id="{{= rowid}}" class="detail">详情</a>&nbsp;&nbsp;
		{{if status == 0}}
		<a href="javascript:void(0)" onclick="openModal(1,{{= rowid}})" class="state">禁用</a>
		{{else if status == 1}}
		<a href="javascript:void(0)" onclick="openModal(0,{{= rowid}})" class="state">启用</a>
		{{else if status == 3}}
		<a href="javascript:void(0)" id="{{= rowid}}" class="userManage">审核通过</a>&nbsp;&nbsp;
		{{/if}}
		</td>	
</tr>
</script>
	<script type="text/javascript">
	
	/* 全查分页 */
	function pageList(pageNum,flag){
		if(flag){
			return false;
		}
		var t = new Date().valueOf();
		$(".index-right").load('<%=path%>/yundongjia/linkedSupplierList?page='+pageNum+'&_time='+t);
	}
	/* 根据供应商名称查询  */
	function search(pageNum,flag){
		if(flag){
			return false;
		}
		var t=new Date().valueOf();
		var name = $("#supplierName").val();
		var status = $("#status").val();
		var t = new Date().valueOf();
		$(".index-right").load('<%=path%>/yundongjia/linkedSupplierList?nav=1&supplierName='+ name +'&status='+ status +'&page='+pageNum+'&_time='+t);
	}
	
	function openModal(status,id){
		$("#rowId").val(id);
		$("#status").val(status);
		$("#statusModal").modal('show');
	};
	
	/* 设置企业状态 */
	function setStatus(){
		var id = $("#rowId").val();
		var status = $("#status").val();
		var comm = $("#comm").val();
		var t=new Date().valueOf();
		var me=status == 0?"确定启用吗?":"确定禁用吗?";
		var bo = confirm(me);
		if(bo){
			$.ajax({
				url:'<%=path%>/yundongjia/supplierStatus',
				type:'post',
				dataType:'json',
				data:{
					status:status,
					rowId:id,
					comm:comm,
					_time:t
				},
				success:function(result){
					if(result.result){
						alert("状态更新成功");
						$('#statusModal').modal('hide');
				        $('.modal-backdrop').attr("hidden",true);
						var t = new Date().valueOf();
						$(".index-right").load('<%=path%>/yundongjia/linkedSupplierList?_time='+t);
					}else{
						alert("状态更新失败");
					}
				}
			});
		}
		
	}
	/* 企业详情 */
	function enterDetail(id){
		var t=new Date().valueOf();
		$(".index-right").load('<%=path%>/yundongjia/supplierDetail?tab=1&id='+id+'&_time='+t);
	}
	
	$(document).ready(function(){
		var pages = ${info.pages};
		var pageNum = ${info.pageNum};
		var pi = {"pages":pages,"pageNum":pageNum};
		if("${nav}" == 1){
			paging("page", "search", pi);
		}else{
			paging("page", "pageList", pi);
		}
		
	});
</script>	
</body>
</html>
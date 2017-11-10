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
			企业列表
		</a>
	</div>
	<div class="main-content-inquire" >
		
			<div class="main-content-item" style="padding: 0px;">
				<table class="table" style="max-width: 50%;" rules="cols" frame="box">
					<thead style="border: 2px solid #0B2F53;">
						<tr>
							<th>企业总数</th>
							<th>企业总次数</th>
							<th>企业已使用次数</th>
							<th>企业购卡总金额</th>
						</tr>
					</thead>
					<tbody id="statisTbody"  class="font-size-weight">
						<tr>
						<td>${lists.total}</td>
						<td>${statis.sportsNumber }</td>
						<td>${statis.moveNumber}</td>
						<td>${statis.realMoney }</td>
						</tr>
					</tbody>
				</table>

			</div>
	
		<div class="col-md-12 padding0L" style="padding-top: 1%;">
			<div class="col-md-12 padding0L">
				<div class="form-group col-md-4 padding0L">
					<input placeholder="请输入企业名称" class="form-control" type="text"
						id="enterpriseName" />
				</div>
				<div class="form-group col-md-3 padding0L">
				  <button type="button"
					class=" btn btn-default col-md-offset-1 col-md-3 bcColor"
					onclick="search(1,false);">搜索</button>
				</div>
				<div class="form-group col-md-5 padding0L">
				  <button type="button" onclick="exportExcel(6);"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor">导出Excel</button>
				</div>
				
			</div>
		</div>
		<div class="main-content-item">
			<table class="table" rules="cols" frame="box">
				<thead>
					<tr>
						<th>企业ID</th>
						<th>企业名称</th>
						<th>所在城市</th>
						<th>企业规模</th>
						<th>运动次数</th>
						<th>已使用次数</th>
						<th>剩余次数</th>
						
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="eTbody">

					<c:forEach items="${lists.list}" var="e">
						<tr>
						<td><a href="javascript:void(0);" onclick="enterDetail(${e.enterprise_id});">${e.enterprise_id}</a></td>
						<td><a href="javascript:void(0);" onclick="enterDetail(${e.enterprise_id});">${e.enterpriseName}</a></td>
						<td>${e.provinceName }</td>
						<td>${e.enterpriseScale }</td>
						<td>${e.moveSum }</td>
						<td>${e.moveCount }</td>
						<td>${e.remaCount }</td>
						<td>
						   ${e.statusName}
						</td>
						<td>
						<a href="javascript:void(0)" onclick="enterDetail(${e.enterprise_id});" class="detail">详情</a>&nbsp;&nbsp;
						<a href="javascript:void(0)" id="${e.enterprise_id}" class="edit">编辑</a>&nbsp;&nbsp;
						<a href="javascript:void(0)" id="${e.enterprise_id}" class="userManage">用户管理</a>&nbsp;&nbsp;
						
						<c:if test="${e.status == 0}"><a href="javascript:void(0)" onclick="openModal(1,${e.enterprise_id})" class="state">禁用</a></c:if>
						<c:if test="${e.status == 1}"><a href="javascript:void(0)" onclick="openModal(0,${e.enterprise_id})" class="state">启用</a></c:if>
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

<td><a href="javascript:void(0);" onclick="enterDetail({{= enterprise_id}});">{{= enterprise_id}}</a></td>
						<td><a href="javascript:void(0);" onclick="enterDetail({{= enterprise_id}});">{{= enterpriseName}}</a></td>
						<td>{{= provinceName }}</td>
						<td>{{= enterpriseScale }}</td>
						<td>{{= moveSum }}</td>
						<td>{{= moveCount }}</td>
						<td>{{= remaCount }}</td>
						<td>{{= statusName}}</td>
						<td>
						<a href="javascript:void(0)" id="{{= enterprise_id}}" class="detail">详情</a>&nbsp;&nbsp;
						<a href="javascript:void(0)" id="{{= enterprise_id}}" class="edit">编辑</a>&nbsp;&nbsp;
						<a href="javascript:void(0)" id="{{= enterprise_id}}" class="userManage">用户管理</a>&nbsp;&nbsp;
						
						{{if status == 0}}
						<a href="javascript:void(0)" onclick="openModal(1,{{= enterprise_id}})" class="state">禁用</a>
						{{else}}
						<a href="javascript:void(0)" onclick="openModal(0,{{= enterprise_id}})" class="state">启用</a>
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
		$(".index-right").load('<%=path%>/yundongjia/listenterprise?pageNum='+pageNum+'&_time='+t);
	}
	/* 根据企业名称查询  */
	function search(pageNum,flag){
		if(flag){
			return false;
		}
		var t=new Date().valueOf();
		var name = $("#enterpriseName").val();
		$.ajax({
			url:'<%=path%>/yundongjia/getenterprisebyname',
			type:'post',
			dataType:'json',
			data:{
				name:name,
				pageNum:pageNum,
				_time:t
			},
			success:function(result){
				$("#eTbody").html($("#tbodyTmpl").tmpl(result.list));
				paging("page", "search", result);
			}
		});
	}
	function openModal(status,id){
		$("#enterid").val(id);
		$("#status").val(status);
		$("#statusModal").modal('show');
	};
	/* 设置企业状态 */
	function setStatus(){
		var id = $("#enterid").val();
		var status = $("#status").val();
		var comm = $("#comm").val();
		var t=new Date().valueOf();
		var me=status == 0?"确定启用吗?":"确定禁用吗?";
		var bo = confirm(me);
		if(bo){
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
					if(result.result > 0){
						alert("操作成功");
						$('#statusModal').modal('hide');
				        $('.modal-backdrop').attr("hidden",true);
						var t = new Date().valueOf();
						$(".index-right").load('<%=path%>/yundongjia/listenterprise?_time='+t);
					}
				}
			});
		}
		
	}
	/* 企业详情 */
	function enterDetail(id){
		var t=new Date().valueOf();
		$(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=1&id='+id+'&_time='+t);
	}
	$(document).ready(function(){
		var pages = ${lists.pages};
		var pageNum = ${lists.pageNum}
		var pi = {"pages":pages,"pageNum":pageNum};
		paging("page", "pageList", pi);
		
		
		/* 编辑 */
		$("#eTbody").on('click','.edit',function(){
			var t = new Date().valueOf();
			var enterId = $(this).attr("id");
			$(".index-right").load('<%=path%>/yundongjia/enterprisetoeditpage?id='+enterId+'&_time='+t);
		});
		
		/* 用户管理 */
		$("#eTbody").on('click','.userManage',function(){
			var enterId = $(this).attr("id");// 企业id
			var t= new Date().valueOf();
			
			$(".index-right").load('<%=path%>/yundongjia/detailenterprise?tab=3&id='+enterId+'&pageNum=1&_time='+t);
		});
		
	});
</script>	
</body>
</html>
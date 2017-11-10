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
<title>用户列表</title>
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
			用户列表
		</a>
	</div>
	<div class="main-content-inquire" >
		
			<div class="main-content-item" style="padding: 0px;">
				<table class="table" style="max-width: 50%;" rules="cols" frame="box">
					<thead style="border: 2px solid #0B2F53;">
						<tr>
							<th>用户总数</th>
							<th>日新增用户</th>
							<th>日活跃用户</th>
						</tr>
					</thead>
					<tbody id="statisTbody"  class="font-size-weight">
						<tr>
						<td>${memberSum.allSum}</td>
						<td>${memberSum.regsionSum }</td>
						<td>${memberSum.activeSum }</td>
						</tr>
					</tbody>
				</table>

			</div>
	
		<div class="col-md-12 padding0L" style="padding-top: 1%;">
			<div class="col-md-12 padding0L">
				<div class="form-group col-md-4 padding0L">
					<input placeholder="请输入手机号" class="form-control" type="text"
						id="enterpriseName" value="${info }" />
				</div>
				<div class="form-group col-md-3 padding0L">
				  <button type="button"
					class=" btn btn-default col-md-offset-1 col-md-3 bcColor"
					onclick="search(1);">搜索</button>
				</div>
				<div class="form-group col-md-5 padding0L">
				  <button type="button"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor">导出Excel</button>
				</div>
			</div>
		</div>
		<div class="main-content-item">
			<table class="table" rules="cols" frame="box">
				<thead>
					<tr>
						<th>用户ID</th>
						<th>用户姓名</th>
						<th>性别</th>
						<th>所在城市</th>
						<th>手机号</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="eTbody">
					<c:forEach items="${memberList.list}" var="e">
						<tr>
						<td><a href="javascript:void(0);" onclick="memberDetail(${e.userId});">${e.userId}</a></td>
						<td><a href="javascript:void(0);" onclick="memberDetail(${e.userId});">${e.nickName}</a></td>
						<td>
							<c:if test="${e.gender == '0' }">男</c:if>
							<c:if test="${e.gender == '1' }">女</c:if>
						</td>
						<td>${e.name }</td>
						<td>${e.mobilePhoneNo }</td>
						<td>
							<c:if test="${e.isValid == '0' }">生效</c:if>
							<c:if test="${e.isValid == '1' }">禁用</c:if>
						</td>
						<td>
						<a href="javascript:void(0)" onclick="memberDetail(${e.userId});" class="detail">详情</a>&nbsp;&nbsp;
						<c:if test="${e.isValid == '0'}"><a href="javascript:void(0)" onclick="openModal(1,${e.userId})" class="" data-toggle="modal"  data-target=".bs-example-modal-sm" >禁用</a></c:if>
						<c:if test="${e.isValid == '1'}"><a href="javascript:void(0)" onclick="openModal(0,${e.userId})" class="" data-toggle="modal"  data-target=".bs-example-modal-sm" >启用</a></c:if>
						</td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>

		</div>
		<div class="main-content-footer">
			<div class="page" id="page">
				<div class="page-list">
						<c:if test="${status == 0 }">
								<a onclick="pageListInfo(1);" <c:if test="${memberList.pageNum == 1 }">class="active"</c:if>>
								&lt;&lt;最前页</a>
									<div class="page-list">
										<c:forEach begin="1" end="${memberList.pages }" varStatus="i">
											<c:if test="${i.index<memberList.pageNum && i.index>memberList.pageNum-5}">
												<span onclick="pageListInfo(${i.index });">${i.index }</span>
											</c:if>
											<c:if test="${memberList.pageNum == i.index }">
												<span onclick="pageListInfo(${i.index });" class="active">${i.index }</span>
											</c:if> 
											<c:if test="${i.index>memberList.pageNum && i.index<memberList.pageNum+5}">
												<span onclick="pageListInfo(${i.index });">${i.index }</span>
											</c:if>
										</c:forEach>
									</div>
							<a onclick="pageListInfo(${memberList.pages });" <c:if test="${memberList.pageNum == memberList.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
						</c:if>
						<c:if test="${status == 1 }">
								<a onclick="search(1);" <c:if test="${memberList.pageNum == 1 }">class="active"</c:if>>
								&lt;&lt;最前页</a>
									<div class="page-list">
										<c:forEach begin="1" end="${memberList.pages }" varStatus="i">
											<c:if test="${i.index<memberList.pageNum && i.index>memberList.pageNum-5}">
												<span onclick="search(${i.index });">${i.index }</span>
											</c:if>
											<c:if test="${memberList.pageNum == i.index }">
												<span onclick="search(${i.index });" class="active">${i.index }</span>
											</c:if> 
											<c:if test="${i.index>memberList.pageNum && i.index<memberList.pageNum+5}">
												<span onclick="search(${i.index });">${i.index }</span>
											</c:if>
										</c:forEach>
									</div>
							<a onclick="search(${memberList.pages });" <c:if test="${memberList.pageNum == memberList.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
						</c:if>
				</div>
			</div>
		</div>
	</div>
	
<!-- 启用或禁用理由 -->
	<div id="modal-container0" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
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
			<input type="hidden"  id="status">
			<input type="hidden"  id="userId">
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="stopOrStart();">确定</button>
			</div>
		</div>
		</div>
		</div>




	<script type="text/javascript" src="<%=path%>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>
<script type="text/x-javascript-tmpl" id="tbodyTmpl">
</script>
<script type="text/javascript">
function pageListInfo(page){
	$(".index-right").load('<%=path%>/yundongjia/memberList?page='+ page);
}

function search(page){
	var info = $("#enterpriseName").val();
	$(".index-right").load('<%=path%>/yundongjia/memberList?status=1&info='+info+'&page='+ page);
}

function openModal(status , userId){
	$("#status").val(status);
	$("#userId").val(userId);
}

function stopOrStart(){
	var status = $("#status").val();
	var userId = $("#userId").val();
	var comm = $("#comm").val();
	$.ajax({
		url : '<%=path%>/yundongjia/stopOrStartMember',
		data : {
			userId : userId,
			status : status,
			comm : comm,
			type : 11,
			time : (new Date()).valueOf()
		},
		dataType:"JSON",
		success : function(data){
			if(data.result){
				var maincontent = $('.index-right');
				maincontent.load('<%=path%>/yundongjia/memberList');
				alert(data.message);
				//关闭模态框
				$("#modal-container0").hide();
				$('.modal-backdrop').attr("hidden",true);
			}else{
				alert(data.message);
			}
		}
	})
}

function memberDetail(userId){
	$(".index-right").load('<%=path%>/yundongjia/memberDetail?userId='+ userId);
}
</script>	
</body>
</html>
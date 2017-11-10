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
<title>教练列表</title>
</head>
<body>
<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 教练列表 </a>
</div>
<div class="main-content-inquire" >
  <div class="main-content-item" style="padding: 0px;">
			<table class="table" style="width: 80%;" rules="cols" frame="box">
				<thead>
					<tr>
						<th>教练总数</th>
						<th>已审核教练</th>
						<th>已禁用</th>
						<th>未审核教练</th>
					</tr>
				</thead>
				<tbody class="font-size-weight">
					<tr>
						<td>${coachs.total }</td>
						<td>${statis.statusOK}</td>
						<td>${statis.statusDis }</td>
						<td>${statis.statusNoAudit }</td>
					</tr>
				</tbody>
			</table>
		</div>
	
	
	<div class="col-md-12 padding0L" style="padding-top: 1%;">
	    <form id="searchform" name="searchform" onsubmit="return false;"  method="post">
	      <input type="hidden" id="pageNum" value="" name="pageNum">
	      <div class="col-md-12 padding0L">
		   <div class="form-group col-md-2 padding0L">教练名称：</div>
			  <div class="form-group col-md-4 padding0L">
					<input placeholder="请输入教练名称" class="form-control" type="text"
						id="nickname" name="nickname" />
				</div>
			</div>
			<div class="col-md-12 padding0L">
		   <div class="form-group col-md-2 padding0L">擅长课程：</div>
			  <div class="form-group col-md-4 padding0L">
			  		<input type="checkbox" id="checkAll" name="" value="-1">全部&nbsp;
					 <c:forEach items="${skills }" var="sk">
					 	<input type="checkbox" name="skills" value="${sk.skillid }">${sk.skillname }&nbsp;
					 </c:forEach>
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
							<option value="2">未审核</option>
							<option value="0">生效</option>
							<option value="1">禁用</option>
						</select>
					</div>
				</div>	
			<div class="col-md-12 padding0L">
					<div class="col-md-6">
					  <button type="button"
					class="btn btn-default col-md-offset-8 col-md-2 bcColor" onclick="searchList(1,false);">搜索</button>
					</div>
				   <div class="col-md-6">
				     <button type="button" onclick="exportExcel(2)"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor" >导出Excel</button>
				   </div>
					
					 
				</div>	
	    </form>
	</div>	
	<div class="main-content-item">
	  <table class="table" rules="cols" frame="box">
		<thead>
			<tr>
				<th>教练ID</th>
				<th>擅长课程</th>
				<th>所在城市</th>
				<th>教练名称</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="coachTbody">
		  <c:forEach items="${coachs.list}" var="c">
		    <tr>
				<td>${c.coachId}</td>
				<td>${c.skillNames}</td>
				<td>${c.provinceName}</td>
				<td>${c.nickName}</td>
				<td>${c.statusName }</td>
				<td>
				
				<a href="javascript:detail(${c.coachId})">详情</a>
				&nbsp;&nbsp;
				
				<c:if test="${c.status == 2}">
				   <a href="javascript:edit(${c.coachId})">编辑</a>
				   &nbsp;&nbsp;
				</c:if>
				
				<c:if test="${c.status == 0}">
					<a href="javascript:openModel(1,${c.coachId})">禁用</a>
				</c:if>
				
				<c:if test="${c.status == 1}">
					<a href="javascript:openModel(0,${c.coachId})">启用</a>
				</c:if>
				
				<c:if test="${c.status == 2}">
				  <a href="javascript:openModel(0,${c.coachId})">审核通过</a>
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
					<input type="hidden" id="id" value="">
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
<script src="<%=path%>/static/js/param.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/region.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>	
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>
<!-- 市模板 -->
<script type="text/x-javascript-tmpl" id="cityTmpl">
<option value="{{= code}}">{{= name}}</option>
</script>
<script type="text/x-javascript-tmpl" id="listTmpl">
<tr>
				<td>{{= coachId}}</td>
				<td>{{= skillNames}}</td>
				<td>{{= provinceName}}</td>
				<td>{{= nickName}}</td>
				<td>{{= statusName }}</td>
				<td>
				
				<a href="javascript:detail({{= coachId}})">详情</a>
				&nbsp;&nbsp;
				
				{{if status == 2}}
					<a href="javascript:edit({{= coachId}})">编辑</a>&nbsp;&nbsp;
				{{/if}}
				
				{{if status == 0}}
				<a href="javascript:openModel(1,{{= coachId}})">禁用</a>
				{{else status == 1}}
				<a href="javascript:openModel(0,{{= coachId}})">启用</a>
				{{else status == 2}}
				<a href="javascript:openModel(0,{{= coachId}})">审核通过</a>
				{{/if}}
				</td>
			</tr>
</script>
<script type="text/javascript">
function pageInfoList(pageNum,flag){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/coachlist?pageNum='+pageNum+'&_time='+t);
}
$(document).ready(function(){
	var pages=${coachs.pages};
	var pageNum=${coachs.pageNum};
	var pi={"pageNum":pageNum,"pages":pages};
	paging("page", "pageInfoList", pi);
	
	$("#searchform").on('click','#checkAll',function(){
		$("input[name='skills']").prop("checked",this.checked);
	});
	
	var $subBox = $("input[name='skills']");
    $subBox.click(function(){
        $("#checkAll").prop("checked",$subBox.length == $("input[name='skills']:checked").length ? true : false);
    });
	
});
function edit(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/toupdatecoach?coachId='+id+'&_time='+t);
}
function detail(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/detailcoach?coachId='+id+'&_time='+t);
}
//打开模态框
function openModel(status,id){
	$("#id").val(id);
	$("#status").val(status);
	$("#statusModal").modal('show');
}
function setStatus(){
	var id = $("#id").val();
	var number = $("#status").val();
	var comm = $("#comm").val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/updatecoachstatus',
		type:'post',
		dataType:'json',
		data:{
			coachId:id,
			status:number,
			comm:comm,
			_time:t
		},
		success:function(data){
			if(data > 0){
				alert("操作成功");
				
				$('#statusModal').modal('hide');
		        $('.modal-backdrop').attr("hidden",true);
		        
		        pageInfoList(1,false);
			}
		}
	});
}

//条件查询
function searchList(pageNum,flag){
	$("#pageNum").val(pageNum);
	if(flag){
		return false;
	}
	var data = new FormData($("#searchform")[0]);
	$.ajax({
		url:'<%=path%>/yundongjia/selectcoachsby',
		type : 'post',
		dataType : 'json',
		data : data,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			 $("#coachTbody").html($("#listTmpl").tmpl(result.list));
			 paging("page", "searchList", result);
		}
	});
}
//全部擅长课程
function selectALL(obj){
	
}
</script>
</body>
</html>
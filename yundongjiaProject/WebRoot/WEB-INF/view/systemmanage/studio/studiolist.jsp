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
<title>场馆列表</title>
</head>
<body>
<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 场馆列表 </a>
	</div>
	<div class="main-content-inquire" >
		<div class="main-content-item" style="padding: 0px;">
			<table class="table" rules="cols" frame="box" style="width: 80%;">
				<thead>
					<tr>
						<th>场馆总数</th>
						<th>已审核场馆</th>
						<th>已禁用</th>
						<th>未审核场馆</th>
					</tr>
				</thead>
				<tbody class="font-size-weight">
					<tr>
						<td>${stus.total}</td>
						<td>${statis.come }</td>
						<td>${statis.dis }</td>
						<td>${statis.noAudit }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 搜索区 -->
	<div class="col-md-12 padding0L" style="padding-top: 1%;">
		 <form id="searchform" name="searchform" onsubmit="return false;"  method="post">
			<input type="hidden" id="pageNum" name="pageNum" value="">
			<div class="col-md-12 padding0L">
				<div class="form-group col-md-2 padding0L">场馆名称：</div>
				<div class="form-group col-md-4 padding0L">
					<input placeholder="请输入场馆名称" class="form-control" type="text"
						id="studioname" name="studioname" />
				</div>
			</div>

			<div class="col-md-12 padding0L">
				<div class="form-group col-md-2 padding0L">场馆类型:</div>
				<div class="form-group col-md-4 padding0L">
					<select id="type" name="type"
						class="form-control btn btn-default">
						<option value="-1">请选择</option>
						<option value="1">工作室</option>
						<option value="2">健身房</option>
						<option value="3">游泳</option>
						<option value="4">羽毛球</option>
						<option value="5">高尔夫</option>
						<option value="6">篮球</option>
						<option value="7">网球</option>
						<option value="8">足球</option>
						<option value="9">台球</option>
						<option value="10">保龄球</option>
						<option value="11">瑜伽</option>
						<option value="12">舞蹈</option>
						<option value="13">马术</option>
						<option value="14">滑雪</option>
						<option value="15">滑冰</option>
						<option value="16">练习场</option>
						<option value="17">智能场馆</option>
					</select>
				</div>
			</div>

			<div class="col-md-12 padding0L">
				<div class="form-group col-md-2 padding0L">所在城市：</div>
				<div class="form-group col-md-2 padding0L">
					<select id="province" name="province"
						class="form-control btn btn-default" onchange="loadCity(this);">
						<option value="-1">省</option>
						<c:forEach items="${pros}" var="p">
							<option value="${p.code }">${p.name }</option>
						</c:forEach>
					</select>

				</div>
				<div class="form-group col-md-2 padding0L">
					<select id="city" name="city" class="form-control btn btn-default"
						onchange="loadArea(this);">
						<option value="-1">市</option>

					</select>
				</div>
				<div class="form-group col-md-2 padding0L">
					<select id="area" name="regionsid"
						class="form-control btn btn-default">
						<option value="-1">区</option>

					</select>
				</div>
			</div>

			<div class="col-md-12 padding0L">
				<div class="form-group col-md-2 padding0L">场馆状态:</div>
				<div class="form-group col-md-4 padding0L">
					<select id="status" name="status"
						class="form-control btn btn-default">
						<option value="-1">请选择</option>
						<option value="0">启用</option>
						<option value="1">禁用</option>
						<option value="2">未审核</option>
					</select>
				</div>
			</div>
			
			
			<div class="col-md-12 padding0L">
					<div class="col-md-6">
					  <button type="button"
					class="btn btn-default col-md-offset-8 col-md-2 bcColor" onclick="searchForm(1,false);">搜索</button>
					</div>
				   <div class="col-md-6">
				     <button type="button" onclick="exportExcel(1);"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor" >导出Excel</button>
				   </div>
					
					 
				</div>
		</form>
	</div>
	<!-- 展示区 -->
	<div class="main-content-item">
	  <table class="table" rules="cols" frame="box">
	  	<thead>
	  		<tr>
	  			<th>场馆ID</th>
	  			<th>场馆类型</th>
	  			<th>所在城市</th>
	  			<th>场馆名称</th>
	  			<th>状态</th>
	  			<th>操作</th>
	  		</tr>
	  	</thead>
	  	<tbody id="studioTbody">
	  		<c:forEach items="${stus.list}" var="s">
	  		 <tr>
	  			<td>${s.studioId}</td>
	  			<td>${s.typeName}</td>
	  			<td>${s.provinceName}</td>
	  			<td>${s.studioName }</td>
	  			<td>${s.statusName}</td>
	  			<td>
	  			 <a href="javascript:void(0)" onclick="detail(${s.studioId});">详情</a>
	  			 
	  			 <c:if test="${s.status ==  2}">
	  				   <a href="javascript:void(0)" onclick="edit(${s.studioId})">编辑</a>
	  			 </c:if>
	  			 
	  				<c:if test="${s.status ==  0}">
	  				   <a href="javascript:void(0)" onclick="openModal(1,${s.studioId})">禁用</a>
	  				</c:if>
	  				<c:if test="${s.status ==  1}">
	  				   <a href="javascript:void(0)" onclick="openModal(0,${s.studioId})">启用</a>
	  				</c:if>
	  				<c:if test="${s.status ==  2}">
	  				   <a href="javascript:void(0)" onclick="openModal(0,${s.studioId})">审核通过</a>
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
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script src="<%=path%>/static/js/param.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/region.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>
<!-- 市模板 -->
<script type="text/x-javascript-tmpl" id="cityTmpl">
<option value="{{= code}}">{{= name}}</option>
</script>
<script type="text/x-javascript-tmpl" id="listTmpl">
<tr>
	  			<td>{{= studioId}}</td>
	  			<td>{{= typeName}}</td>
	  			<td>{{= provinceName}}</td>
	  			<td>{{= studioName }}</td>
	  			<td>{{= statusName}}</td>
<td>
	<a href="javascript:void(0)" onclick="detail({{= studioId}});">详情</a>

	{{if status == 2}}
	<a href="javascript:void(0)" onclick="edit({{= studioId}})">编辑</a>
	{{/if}}

	{{if status == 0}}
<a href="javascript:void(0)" onclick="openModal(1,{{= studioId}})">禁用</a>
	{{else status == 1}}
<a href="javascript:void(0)" onclick="openModal(0,{{= studioId}})">启用</a>
	{{else status == 2}}
<a href="javascript:void(0)" onclick="openModal(0,{{= studioId}})">审核通过</a>
	{{/if}}

</td>
</tr>
</script>
<script type="text/javascript">
function pageInfoList(pageNum,flag){
	if(flag){
		return false;
	}
	var t =new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/studiolist?pageNum='+pageNum+'&_time='+t);
}
	$(document).ready(function(){
		var pages=${stus.pages};
		var pageNum = ${stus.pageNum};
		var pi={"pageNum":pageNum,"pages":pages};
		paging("page", "pageInfoList", pi)
	});
//多条件查询	
function searchForm(pageNum,flag){
	if(flag){
		return false;
	}
	$("#pageNum").val(pageNum);
	var t=new Date().valueOf();
	 var data = new FormData($("#searchform")[0]);
		$.ajax({
			url:'<%=path%>/yundongjia/selectstudiobylist',
			type : 'post',
			dataType : 'json',
			data : data,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(result) {
				 $("#studioTbody").html($("#listTmpl").tmpl(result.list));
				 paging("page", "searchForm", result);
			}
		});
	
	
}	
/* 详情 */
function detail(id){
	var t= new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/detailstudio?studioId='+id+'&tab=1&_time='+t);
}
/* 编辑 */
function edit(id){
	var t= new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/updatestudio?studioId='+id+'&_time='+t);
};

function openModal(status,id){
	$("#id").val(id);
	$("#status").val(status);
	$("#statusModal").modal('show');
};

/* 设置状态 */
function setStatus(){
	var id = $("#id").val();
	var number = $("#status").val();
	var comm = $("#comm").val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/updatestudiostatus',
		type:'post',
		dataType:'json',
		data:{
			id:id,
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
</script>	
</body>
</html>
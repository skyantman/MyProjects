<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
<link href="<%=path%>/static/css/gymcommon.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/static/css/gymstyle.css" rel="stylesheet"
	type="text/css">

<link href="<%=path%>/static/css/gymcss/style.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<div class="main-content menuManage" >
		<div class="col-md-10 page-header">
			当前位置：<a href="javascript:void(0);">
				菜单管理
			</a>
		</div>
			<a href="javascript:void(0);" role="button"  class="btn bcColor"  onclick="addPage(1,-1);"  style="margin-top: 3px;">添加菜单</a>
		</div>
		<div class="hrsoild "></div>
		<div class="main-content-item" style="padding-top: 28px;">
			<table class="table" rules="cols" frame="box">
				<thead>
					<tr>
						<th>名称</th>
						<th>排序</th>
						<th>是否可见</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="listTbody">
					<c:forEach items="${menus.list}" var="menu">
					<tr>
						<td <c:if test="${menu.menuIsroot == 1}">style="text-align:center"</c:if>  <c:if test="${menu.menuIsroot == 0}">style="text-align:right"</c:if>   >${menu.menuName}</td>
						<td>${menu.menuOrdernum}</td>
						<td>
						<c:if test="${menu.menuIsshow == 1}">可见</c:if>
						<c:if test="${menu.menuIsshow == 0}">隐藏</c:if>
						</td>
						<td>
						   <c:if test="${menu.menuIsroot == 1}">
						     <a href="javascript:void(0)" id="${menu.menuId}" class="btn detail-btn addmenu">添加子菜单</a>
						   </c:if>
						   
						  
						   <a href="javascript:void(0)" id="${menu.menuId}" class="btn detail-btn delete">删除</a>
						</td>
					</tr>
					   <c:forEach items="${menu.menuVoList}" var="child">
						<tr>
							<td <c:if test="${child.menuIsroot == 1}">style="text-align: center;"</c:if> <c:if test="${child.menuIsroot == 0}">style="text-align: right;"</c:if> >${child.menuName}</td>
							<td>${child.menuOrdernum }</td>
							<td>
							 <c:if test="${child.menuIsshow == 1}">可见</c:if>
							 <c:if test="${child.menuIsshow == 0}">隐藏</c:if>
							</td>
							<td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
								<a href="javascript:void(0)" id="${child.menuId}" class="btn detail-btn delete">删除</a>
								 
							</td>
						</tr>
					   </c:forEach>
				   </c:forEach>
				</tbody>
			</table>
		</div>
		<div class="main-content-footer" style="margin-top: -10px;">

			<div class="page" id="page">
				
			</div>

		</div>
	</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript">
function pageList(pageNum,flag){
	if(flag){
		return false;
	}
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/datamanage/menuManage?pageNum='+pageNum+'&_time='+t);
}
$(document).ready(function(){
	var pages=${menus.pages};
	var pageNum=${menus.pageNum};
	var pi={"pages":pages,"pageNum":pageNum};
	paging("page", 'pageList', pi);
	

	
	//添加子菜单
	$("#listTbody").on('click','.addmenu',function(){
		var id=$(this).attr("id");
		addPage(0,id);
	});
	//删除
	$("#listTbody").on('click','.delete',function(){
		var id=$(this).attr("id");
		var res = confirm("确定要删除此菜单吗? 提示:如果是根菜单 会和子菜单一起删除");
		if(res){
			var t = new Date().valueOf();
			$.ajax({
				url:'<%=path%>/menu/deletebyid',
				type:'POST',
				dataType:'JSON',
				data:{
					id:id,
					_time:t
				},
				success:function(result){
					if(result > 0){
						var t=new Date().valueOf();
						$(".index-right").load('<%=path%>/datamanage/menuManage?_time='+t);
					}else{
						confirm("删除失败");
					}
				}
			});
		}
	});
});
function addPage(isRoot,id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/menu/add?_time='+t+'&root='+isRoot+'&id='+id);
}
</script>	
</body>
</html>
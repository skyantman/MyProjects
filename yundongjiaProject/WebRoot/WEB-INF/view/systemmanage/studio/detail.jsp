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
<title>场馆详情</title>
<script type="text/javascript">
function toback(num){
	var url="";
	if(1 == num){
		var t=new Date().valueOf();
		url="<%=path%>/yundongjia/studiolist?pageNum=1&_time="+t;
	}
	tobackDemo(url);
}
</script>
</head>
<body>
	<div class="main-content reManage " id="reManage">
		<div class="page-header">
			当前位置： <a href="javascript:toback(1);">场馆列表</a> &nbsp; &gt; &nbsp; <a
				href="javascript:(0);"> 场馆详情 </a>
		</div>
		<!-- tab -->
		<div class="main-content-inquire">
			<div class="tabbable">
			   <ul class="nav nav-tabs">
					<li <c:if test="${tab == 1}">class="active"</c:if> ><a
						href="#panel-0" value="0" data-toggle="tab">场馆信息</a></li>
					<%-- <li <c:if test="${tab == 2}">class="active"</c:if>  ><a
						href="#panel-1" value="1" data-toggle="tab">场馆价格</a></li> --%>

					
				</ul>
				<div class="tab-content">
				  <div class="tab-pane   <c:if test="${tab == 1}">active</c:if>  " id="panel-0">
				  	<div class="main-content-item">
				  	    <table>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆ID：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.studioId }</label>
											<input type="hidden" value="${stu.studioId }" id="studioId">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆名称：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.studioName }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆价格：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.consumeMoney }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆类型：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.typeName }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">所在城市：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.provinceName }${stu.cityName }${stu.areaName }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆地址：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.studioAddr }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">营业时间：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.studioOpentime }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆电话：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.studioTel }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">关键字：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.keyword }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆介绍：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.studioIntroduce }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">注意事项：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.comm }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">地图定位：</label>
										</div>
									</td>
									<td>
										<div class="col-md-12"
											style="width: 630px; height: 390px; border: 1px solid gray;">
											<div class="col-md-12 padding0L padding5T">经度：${stu.lng }
												&nbsp;&nbsp;维度：${stu.lat }</div>

											<div id="container" class="padding0L form-group"
												style="position: absolute; overflow: hidden; margin-top: 30px; width: 90%; height: 85%; top: 50;">

											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td style="width: 10%;">
										<div class="form-group">
											<label for="">场馆相册：</label>
										</div>
									</td>
									<td >
										<div class="form-group">
											<c:forEach items="${imgs}" var="att">
										 	 
										 	 <img class="col-md-1"  value=""  alt='' src="${att.path}"  height='100px' style='padding: 5px;'>
										 	 
										   </c:forEach>
										    
										   
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">服务设施：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.equips}</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">场馆联系人：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.superName }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="">取消限制：</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="">${stu.limitName }</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										 
									</td>
									<td>
										<div class="form-group">
											 <input  id="" type="button" onclick="edit();"
								class="btn btn-default bcColor" value="编辑信息">
										</div>
									</td>
								</tr>
							</table>
				  	</div>
				  </div>
				  <div class="tab-pane  <c:if test="${tab == 2}">active</c:if>  " id="panel-1">
				  
				  </div>
				</div>
			</div>
		</div>

		<!-- 操作记录 -->
		<div class="main-content-inquire">
			<div class="main-content-item">
				<table class="table" style="width: 60%;" rules="cols" frame="box">
					<thead>
						<tr>
							<th>操作ID</th>
							<th>操作人</th>
							<th>角色</th>
							<th>操作时间</th>
							<th>操作行为</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ops }" var="op">
							<tr>
								<td>${op.opeartion_id }</td>
								<td>${op.backuserName }</td>
								<td>${op.role_name }</td>
								<td>${op.opeartion_createdate }</td>
								<td>${op.opeartion_info }</td>
								<td>${op.opeartion_com }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
<script type="text/javascript">
function init() {
	map = new BMap.Map("container");            // 创建Map实例
	var x = ${stu.lng};
	var y = ${stu.lat };
	var point = new BMap.Point(x, y);
	map.centerAndZoom(point,12);                 
	
	marker = new BMap.Marker(new BMap.Point(x, y)); // 创建点
	map.addOverlay(marker);
	 
	 
}

/* 编辑 */
function edit(){
	var id=$("#studioId").val();
	var t= new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/updatestudio?studioId='+id+'&_time='+t);
};
$(document).ready(function(){
	init();//初始化地图
});
</script>	
</body>
</html>
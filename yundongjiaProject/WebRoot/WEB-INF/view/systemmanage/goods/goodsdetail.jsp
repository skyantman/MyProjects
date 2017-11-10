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
<title>商品详情</title>
<script type="text/javascript">
function toback(num){
	var url='';
	var t=new Date().valueOf();
	if(1 == num){
		url='<%=path%>/yungongjia/goodslist?pageNum=1&_time='+t;
	}
	tobackDemo(url);
}
</script>
</head>
<body>
<div class="main-content reManage" id="reManage" >
   <div class="page-header">
			当前位置： <a href="javascript:toback(1);">商品列表</a> &nbsp; &gt; &nbsp; <a
				href="javascript:(0);"> 商品详情 </a>
	</div>
	<div class="main-content-inquire">
	   <div class="tabbable">
	        <ul class="nav nav-tabs">
				<li class="active" ><a href="#panel-0" value="0" data-toggle="tab">商品详情</a></li>
			</ul>
			<div class="tab-content">
		      <div class="tab-pane active" id="panel-0">
		      	 <div class="main-content-item">
		      	 	<table>
		      	 		<tr>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">商品ID：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">${good. goodsId}</label>
							   </div>
		      	 			</td>
		      	 		</tr>
		      	 		<tr>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">商品名称：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">${good.gName }</label>
							   </div>
		      	 			</td>
		      	 		</tr>
		      	 		<tr>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">商品卖点：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">${good.special }</label>
							   </div>
		      	 			</td>
		      	 		</tr>
		      	 		<tr>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">商品规格：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <div >颜色：${good.strColor}</div>
								  <div >尺码：${good.strSize}</div>
							   </div>
		      	 			</td>
		      	 		</tr>
		      	 		<tr>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">商品价格：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">${good.gPrice }元</label>
							   </div>
		      	 			</td>
		      	 		</tr>
		      	 		<tr>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">商品库存：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">${good.gCount }</label>
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
								  <label for="">${good.keywords }</label>
							   </div>
		      	 			</td>
		      	 		</tr>
		      	 		<tr>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">运费：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">${good.freight }</label>
							   </div>
		      	 			</td>
		      	 		</tr>
		      	 		<tr>
		      	 			<td style="width: 10%;">
		      	 			  <div class="form-group">
								  <label for="">商品图片：</label>
							   </div>
		      	 			</td>
		      	 			<td>
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
								  <label for="">商品信息：</label>
							   </div>
		      	 			</td>
		      	 			<td>
		      	 			  <div class="form-group">
								  <label for="">${good.des }</label>
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
								  <label for="">${good.limitName }</label>
							   </div>
		      	 			</td>
		      	 		</tr>
								<tr>
									<td></td>
									<td>
										<div class="form-group">
											<input id="" type="button" onclick="edit(${good. goodsId});"
												class="btn btn-default bcColor" value="编辑信息">
										</div>
									</td>
								</tr>

							</table>
		      	 </div>
		      </div>
		   </div>
		</div>
	</div>
	<!-- 操作记录 -->
		<div class="main-content-inquire">
			<div class="main-content-item">
				<table class="table" style="width: 80%;" rules="cols" frame="box">
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

<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript">
function edit(id){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/updategoodstopage?goodsId='+id+'&_time='+t);
}
</script>
</body>
</html>
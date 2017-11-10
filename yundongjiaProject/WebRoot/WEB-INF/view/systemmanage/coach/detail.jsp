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
<title>教练详情</title>
<script type="text/javascript">
 function toback(num){
	 var url='';
	 var t =new Date().valueOf();
	 if(1 == num){
		 url ='<%=path%>/yundongjia/coachlist?pageNum=1&_time='+t;
	 }
	 tobackDemo(url);
 }
</script>
</head>
<body>
<div class="main-content reManage" id="reManage" >
   <div class="page-header">
			当前位置： <a href="javascript:toback(1);">教练列表</a> &nbsp; &gt; &nbsp; <a
				href="javascript:(0);"> 教练详情 </a>
	</div>
 	<div class="main-content-inquire">
 	   <div class="tabbable">
 	     <ul class="nav nav-tabs">
			<li class="active" ><a href="#panel-0" value="0" data-toggle="tab">教练详情</a></li>
		</ul>
		<div class="tab-content">
		   <div class="tab-pane active" id="panel-0">
		       <input type="hidden" name="caochId" id="coachId" value="${co.coachId }">
		       <div class="main-content-item">
		       		<table>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">教练ID：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.coachId }</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">教练名称：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.nickName }</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">擅长课程：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.skillNames }</label>
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
								  <label for="">${co.provinceName}${co.cityName }${co.areaName }</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">所属场馆：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.studioName }</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">授课时间：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.openTime }</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">联系电话：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.mobilePhoneNo}</label>
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
								  <label for="">${co.keywords }</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">从业年龄：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.workAge }年</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">教练介绍：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">${co.introduce }</label>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">获得奖项：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <c:forEach items="${co.rewars}" var="r">
								  	 <div>${r.reward} &nbsp; ${r.ordernum}</div>
								  </c:forEach>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td style="width: 10%;">
		       				   <div class="form-group">
								  <label for="">教练相册：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								 <c:forEach var="att" items="${imgs}">
								    <img class="col-md-1"  value=""  alt='' src="${att.path}"  height='100px' style='padding: 5px;'>
								 </c:forEach>
							   </div>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>
		       				   <div class="form-group">
								  <label for="">价格：</label>
							   </div>
		       				</td>
		       				<td>
		       				   <div class="form-group">
								  <label for="">￥ ${co.coursePrice }/小时</label>
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
								  <label for="">${co.cancleLimitName }</label>
							   </div>
		       				</td>
		       			</tr>
								<tr>
									<td></td>
									<td>
										<div class="form-group">
											<input id="" type="button" onclick="edit();"
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
function edit(){
	var id= $("#coachId").val();
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/yundongjia/toupdatecoach?coachId='+id+'&_time='+t);
}
</script>

</body>
</html>
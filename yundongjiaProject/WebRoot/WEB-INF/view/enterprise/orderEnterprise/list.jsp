<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业健身房订单列表</title>
<style type="text/css">
.footer-right{
	padding-right: 15px;
	text-align: right;
}
.footer-right .pagination{
	margin-top: 0px;
}
.btn-user-defined-style{
	   background-color:#E83F14;
	   color: #ffffff;	
}
/* td边框颜色 */
.table>tbody>tr>td{border:solid 1px #dddddd;
		line-height: 120%;
}
/* 奇数行 */
.table>tbody>tr:nth-child(odd) {
	background-color: #fff;
}
/* 偶数行 */
.table>tbody>tr:nth-child(even) {
	background-color: #f4f4f4;
}
/* */
.ywc-color-style{
  color:#1ab394; 
}
/*  
分页按钮颜色 
*/
.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover, .pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover {
    z-index: 2;
    color: #fff;
    cursor: default;
    background-color: #7cc3b5;
    border-color:#ffffff;
	
}

</style>
</head>
<body>
<div class="main-content">
 <div class="container" style="margin-left: 0px;width:100%;">
   <div class="row">
       <div class="col-sm-3">
			<div class="input-group">
				<input id="mobilePhoneNum" style="height: 33px;" type="text" class="form-control" placeholder="请输入电话号码">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" onclick="searchData(1);">
						<img alt="" src="<%=path %>/static/images/enterpriseImage/search.png">
					</button>
				</span>
			</div><!-- /input-group -->
		</div><!-- /.col-lg-6 -->
   </div>
 </div>
  
  <div class="main-content-item">
    <div class="col-sm-12">
      <table class="table">
      	<thead class="btn-user-defined-style">
      		<tr>
      			<th>ID</th>
      			<th>类型</th>
      			<th>内容</th>
      			<th>扣除次数</th>
      			<th>用户</th>
      			<th>创建日期</th>
      			<th>状态</th>
      		</tr>
      	</thead>
      	<tbody id="orderTbody" >
      		<c:forEach items="${orders.list}" var="o">
      			<tr>
      				<td>${o.orderId }</td>
      				<td>${o.dataType }</td>
      				<td>
      				<span <c:if test="${o.payStatus == 2}">class="ywc-color-style"</c:if>  >${o.comm }</span>
      				</td>
      				<td>${o.subCount }</td>
      				<td>${o.mobilePhoneNum }</td>
      				<td>${o.createDate }</td>
      				<td style="color: <c:if test='${o.payStatus == 5}' >#1ab394;</c:if>  <c:if test='${o.payStatus == 2}' >#E83F14;</c:if> " >
      				<c:if test="${o.payStatus == 2}">已支付</c:if>
      				 
      				<c:if test="${o.payStatus == 5}">已完成</c:if>
      				</td>
      			</tr>
      		</c:forEach>
      	</tbody>
      	
      </table>
    </div>
  </div>
  <div class="main-content-footer">
  <div class="col-sm-6">已用：<span class="ywc-color-style">${sum }</span>&nbsp;	次</div>
  <div class="col-sm-6 footer-right">
    <ul id="pagination" class="pagination">
     
    </ul>
  </div>
   
  </div>
</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/enterprise/pageUtils.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/x-javascript-tmpl" id="orderTmpl">
<tr>
 <td>{{= orderId}}</td>
 <td>{{= dataType}}</td>
 <td>{{= comm}}</td>
 <td>{{= subCount}}</td>
 <td>{{= mobilePhoneNum}}</td>
 <td>{{= createDate}}</td>


<td  style='color: {{if payStatus == 2}} #E83F14; {{else payStatus == 5}} #1ab394; {{/if}}' >
{{if payStatus == 2}}
已支付
{{else payStatus == 5}}
已完成
{{/if}}
</td>

</tr>
</script>
<script type="text/javascript">
function pageInfoList(pageNum){
	var t=new Date().valueOf();
	$(".index-right").load('<%=path%>/enterpriseorder/list',{_time:t,pageNum:pageNum});
}
$(document).ready(function(){
	var pi={"pageNum":${orders.pageNum},"pages":${orders.pages}};
	pagePading("pagination", "pageInfoList", pi);

});
/* 根据手机号码查询 */
function searchData(pageNum){
	var mp = $("#mobilePhoneNum").val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/enterpriseorder/findOrderByMobilePhoneNum',
		type:'post',
		dataType:'json',
		data:{
			pageNum:pageNum,
			mobilePhone:mp,
			_time:t
		},
		success:function(data){
			 if(data.list != undefined){
				$("#orderTbody").html($("#orderTmpl").tmpl(data.list));
				pagePading("pagination", "searchData", data);
			}else{
				$("#orderTbody").html("");
				pagePading("pagination", "searchData", data);
			} 
		}
	});
}
</script>
</body>
</html>
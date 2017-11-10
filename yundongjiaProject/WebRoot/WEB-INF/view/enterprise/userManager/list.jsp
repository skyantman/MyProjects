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
<title>企业用户管理</title>


<style type="text/css">
	.btn-user-defined-style{
	   background-color:#E83F14;
	   color: #ffffff;	
	}
	/* #E83F14 背景颜色 */
	.user-defined-bg{
		background-color:#E83F14;
	}
	.user-defined-color01{
	   color:#E83F14;
	}
	/* 白色字体颜色 */
	.user-defined-color{
		color: #ffffff;
	}
	.main-content-footer{
		padding-right: 15px;
		text-align: right;
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
.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover, .pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover {
    z-index: 2;
    color: #fff;
    cursor: default;
    background-color: #7cc3b5;
    border-color:#ffffff;
}

.modal-body>input {
			width: 95%;
			margin-left : 20px;
			padding-left:10px;
			color:#7b7b7b;
			border-radius: 0px;
			border-left-width:0px;
			border-top-width:0px;
			border-right-width:0px;
			border-bottom-color:#E1E3E5;
}

</style>
</head>
<body>
<div class="main-content">
  <div class="container" style="margin-left: 0px;width: 100%;">
   <div class="row" style="border:0px solid red;">
      <div class="col-sm-3" style="border:0px solid blue;">
         <div class="form-group  padding0L" >
	 	     <select style="height: 33px;"  class="form-control" name="cardId" id="cardId" onchange="cardChange(this);">
	 	     	<option value="-1" selected="selected">选择</option>
	 	     	<c:forEach items="${cards}" var="c">
	 	     		<option value="${c.orderId}">${c.orderNum }</option>
	 	     	</c:forEach>
	 	     </select>
  	     </div>
      </div>
      <div class="col-sm-1">
        <button class="btn user-defined-bg user-defined-color btn-lg" data-toggle="modal" data-target="#modalSaveUser"
        style="padding: 3px 8px 3px 8px;height: 29px;">
                    新增用户
        </button>
        
         
   	 </div>     
   </div>
   <div class="row">
       <div class="col-sm-3">
			<div class="input-group">
				<input id="mobilePhone" style="height: 33px;" type="text" class="form-control" placeholder="请输入电话号码">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" onclick="search(1);">
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
   	 <thead class="user-defined-bg user-defined-color">
   	 	<tr>
   	 		<th>ID</th>
   	 		<th>姓名</th>
   	 		<th>性别</th>
   	 		<th>手机号</th>
   	 		<th>使用次数</th>
   	 		<th>状态</th>
   	 		<th>操作</th>
   	 	</tr>
   	 </thead>
   	 <tbody id="userTbody">
   	 	<c:forEach items="${users.list }" var="u">
   	 	 <tr>
   	  	<td>${u.orderId }</td>
   	  	<td>${u.nickName }</td>
   	  	<td>
   	  	<c:if test="${u.gender == 0}">男</c:if>
   	  	<c:if test="${u.gender == 1}">女</c:if>
   	  	</td>
   	  	<td>${u.mobilePhoneNo }</td>
   	  	<td>${u.moveCount}</td>
   	  	<td>
   	  		<c:if test="${u.isValid == 0}"> 
   	  		  <a href="javascript:void(0)">生效</a>
   	  		</c:if>
   	  		
   	  		<c:if test="${u.isValid == 1}">禁用</c:if>
   	  	</td>
   	  	<td>
   	  	  
   	  	  
   	  	  <c:if test="${u.isValid == 0}">
   	  	    &emsp;
   	  	    <a href="javascript:void(0)" onclick="setStatus(${u.userId},1);"><span class="user-defined-color01">禁用</span></a>
   	  	  </c:if>
   	  	  
   	  	  <c:if test="${u.isValid == 1}">
   	  	    &emsp;
   	  	    <a href="javascript:void(0)" onclick="setStatus(${u.userId},0);">启用</a>
   	  	  </c:if>
   	  	</td>
   	  </tr>
   	 	</c:forEach> 
   	 </tbody>
   </table>
   </div>
 </div>
  <div class="main-content-footer">
     <ul id="pagination" class="pagination">
		<!-- <li><a href="#">&lt;;</a></li>
		<li class="active"><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&gt;</a></li> -->
    </ul>
  </div>


</div>



<!-- 模态框（Modal）设置状态 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel">
					是否确定禁用
				</h4>
			</div>
			<div class="modal-body">
				<input id="userId" type="hidden" value="">
				<input id="status" type="hidden" value="">
				<textarea id="remark" class="form-control" placeholder="请输入禁用理由"></textarea>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" 
						data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-user-defined-style" onclick="modalClickTemp();">
					确定
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<!-- 模态框（Modal）增加用户 -->
<div class="modal fade" id="modalSaveUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增用户</h4>
            </div>
            <div class="modal-body">
            	<input id="mobilePhoneNum" class=""  type="text" placeholder="请输入手机号码">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-user-defined-style" onclick="saveUser();">确&emsp;认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
 <script src="<%=path%>/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/enterprise/pageUtils.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>

<script type="text/x-javascript-tmpl" id="userTmpl">
<tr>
 <td>{{= orderNum}}</td>
 <td>{{= nickName}}</td>
 <td>
   {{if gender == 0}}男{{else}}女{{/if}}
 </td>
 <td>{{= mobilePhoneNo}}</td>
 <td>{{= moveCount}}</td>
 <td>
{{if isValid == 0}}
 <a href="javascript:void(0)">生效</a>
{{else}}
	禁用
{{/if}}
</td>

<td>
  {{if isValid == 0}}
<a href="javascript:void(0)" onclick="setStatus({{= userId}},1);"><span class="user-defined-color01">禁用</span></a>
  {{else}}
   &emsp;
<a href="javascript:void(0)" onclick="setStatus({{= userId}},0);">启用</a>
  {{/if}}
</td>
</tr>
</script>
<script type="text/javascript">
function pageInfoList(pageNum){
	var t=new Date().valueOf();
	 
	$(".index-right").load("<%=path%>/enterprise/epusermanager/list",{pageNum:pageNum,_time:t});
}

$(document).ready(function(){
	var pi={"pageNum":${users.pageNum},"pages":${users.pages}};
	pagePading("pagination","pageInfoList", pi);
	
	$("#cardId option").each(function(){
        console.log("1");
		$(this).hover(function(){
        	console.log("2");
            alert(this.innerHTML);
        },
        function(){
        	console.log("3");
            return;
        }
        );
    });
	
});
/* 手机号码模糊查询 */
function search(pageNum){
	var mp=$("#mobilePhone").val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/enterprise/epusermanager/searchMobilePhone',
		type:'post',
		dataType:'json',
		data:{
			mobilePhone:mp,
			pageNum:pageNum,
			_time:t
		},
		success:function(data){
			$("#userTbody").html($("#userTmpl").tmpl(data.list));
			pagePading("pagination", "search", data);
		}
	});
}

/* 企业卡查询  */
function cardChange(obj){
	var card = $(obj).val();
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/enterprise/epusermanager/searchcard',
		type:'post',
		dataType:'json',
		data:{
			cardId:card,
			_time:t
		},
		success:function(data){
			$("#userTbody").html($("#userTmpl").tmpl(data.list));
			pagePading("pagination", "cardChange", data);
		}
	});
}
/* 设置状态 */
function setStatus(userId,statusNum){
	if(0 == statusNum){
		layer.confirm('确定启用吗?',{btn:['确认','取消']},function(index){
			var res = statusUpdate(userId, statusNum, null);
			if(res > 0){
				layer.msg("启用成功");
				pageInfoList(1);
			}else{
				layer.msg("启用失败");
			}
			layer.close(index);
		},function(){
			
		});
		
	}else if(1 == statusNum){
		$("#userId").val(userId);
		$("#status").val(statusNum);
		$("#myModal").modal({
			keyboard: true
		});
	}	
}
function modalClickTemp(){
	var uId = $("#userId").val();
	var status = $("#status").val();
	var remark = $("#remark").val();
	
	var res = statusUpdate(uId,status,remark);
	if(res > 0){
		layer.msg("禁用成功",{icon:1});
		
		pageInfoList(1);
		
	}else{
		layer.msg("禁用失败",{icon:2});
	}
	
	$("#myModal").modal("hide");
	$('.modal-backdrop').attr("hidden",true);
}
/* 设置状态 */
function statusUpdate(userId,status,remark){
	var t=new Date().valueOf();
	var result=0;
	$.ajax({
		url:'<%=path%>/enterprise/epusermanager/updatestatus',
		type:'post',
		dataType:'json',
		async:false,
		data:{
			userId:userId,
			status:status,
			comm:remark,
			_time:t
		},
		success:function(data){
			result = data;
		}
	});
	return result;
}
/* 保存用户 */
function saveUser(){
	var cId = $("#cardId").val();
	var reg = /^1[3|5|8][0-9]\d{4,8}$/;
	var mp = $("#mobilePhoneNum").val();
	if(-1 == cId){
		alert("请选择一张企业卡");
	}else if(!reg.test(mp)){
		alert("请输入正确的手机号码");
	}else{
		var t=new Date().valueOf();
		$.ajax({
			url:'<%=path%>/enterprise/epusermanager/saveuser',
			type:'post',
			dataType:'json',
			data:{
				mobilePhoneNum:mp,
				cardId:cId,
				_time:t
			},
			success:function(data){
				if(data.id > 0){
					alert(data.message);
					pageInfoList(1);
				}else{
					alert(data.message);
				}
				
				$('.modal-backdrop').attr("hidden",true);
			}
		});
	}
	
}
</script>
</body>
</html>
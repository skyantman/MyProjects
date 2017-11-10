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
<title>图片管理</title>
</head>
<body>
<div class="main-content-inquire" >
<div class="col-md-12 padding0L" style="padding-top: 1%;">
  <form id="form1" action="">
    <div class="col-md-12 padding0L">
		<div class="form-group col-md-1 padding0L">ID:</div>
		<div class="form-group col-md-2 padding0L">
			<input type="number" id="id" name="id"  class="form-control">
		</div>
		<div class="form-group col-md-1 padding0L">图片类型:</div>
		<div class="form-group col-md-2 padding0L">
			<select id="attachType" name="attachType" class="form-control btn btn-default">
				<option value="-1">请选择</option>
				<option value="1">活动</option>
				<option value="2">场馆</option>
				<option value="3">教练</option>
				<option value="4">商品</option>
				<option value="5">资讯</option>
			</select>
		</div>
	</div>
    <div class="col-md-12 padding0L">
		
	</div>
	
  </form>
</div>
 
</div>
<div id="main-content" class="main-content-item">
  <%-- <c:forEach begin="0" end="15">
	    <div class="col-sm-6 col-md-3">
	        <div class="thumbnail">
	            <img src="/wp-content/uploads/2014/06/kittens.jpg"
	                 alt="没有图片">
	            <div class="caption">
	                <h3>缩略图标签</h3>
	                <p>一些示例文本。一些示例文本。</p>
	                <p>
	                    <!-- <a href="#" class="btn btn-primary" role="button">
	                        按钮
	                    </a> -->
	                    <a href="javascript:void(0);" class="btn btn-danger" role="button">
	                        删除
	                    </a>
	                </p>
	            </div>
	        </div>
	    </div>
	   

  </c:forEach> --%>
</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<!--{{if attachtype == 1}}活动
{{else attachtype == 2}}场馆
{{else attachtype == 3}}教练
{{else attachtype == 4}}商品
{{else attachtype == 5}}资讯
{{else }} 
{/if}-->
<script type="text/x-javascript-tmpl" id="list">
  <div class="col-sm-6 col-md-3">
	        <div class="thumbnail">
	            <img src="{{= path}}" alt="" style="width:100px;height:100px;">
	            <div class="caption">
	                 
	                <p>排序：{{= imgordernum}}<br/>
					  类型：
{{if attachtype == 0}}
--
{{else attachtype == 1}}
活动

{{else attachtype == 2}}
场馆
{{else attachtype == 3}}
教练
{{else attachtype == 4}}
商品
{{else attachtype == 5}}
资讯
{{/if}}

<br/>
ID：{{= proid}}




					</p>
	                <p>
<a href="javascript:void(0);" class="btn btn-danger" role="button" onclick="del({{= attachid}})";>删除
</a>
	                </p>
	            </div>
	        </div>
	</div>
</script>
<script type="text/javascript">
function del(attachId){
	var f = confirm("确定删除吗?");
	if(!f){
		return false;
	}
	var t=new Date().valueOf();
	$.ajax({
		url:'<%=path%>/yundongjia/deleteattachbyid',
		type:'post',
		dataType:{
			attachId:attachId,
			_time:t
		},
		success:function(data){
			if(data > 0){
				alert("删除成功");
				push();
			}else{
				alert("删除失败");
			}
		}
	});
};
function push(){
	 var t=new Date().valueOf();
	 var id = $("#id").val();
	 $.ajax({
		  url:"<%=path%>/yundongjia/findattach",
		  type:'post',
		  dataType:'json',
		  data:{
			  id:id,
			  type:$("#attachType").val(),
			  _time:t
		  },
		  success:function(data){
			  console.log(data);
			  $("#main-content").html($("#list").tmpl(data));
		  }
	  });
}
  $(document).ready(function(){
	 
	  $("#form1").on("change","#attachType",function(){
		 push();
	  });
  });
</script>
</body>
</html>
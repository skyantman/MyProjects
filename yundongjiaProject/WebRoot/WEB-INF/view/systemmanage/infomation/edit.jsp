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
<title>资讯编辑</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/froala_editor.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/froala_style.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/code_view.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/colors.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/emoticons.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/image_manager.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/image.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/line_breaker.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/table.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/char_counter.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/video.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/fullscreen.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/file.css">
  <link rel="stylesheet" href="<%=path%>/static/froalaEditor25/css/plugins/quick_insert.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">	


<script type="text/javascript">
	
	function toback(num){
		var url;
		var t=new Date().valueOf();
		if(0 == num){
			url='<%=path%>/yundongjia/informationlist?pageNum=1&_time='+t;
		}else if(1 == num){
			var id=$("#rowid").val();
			url='<%=path%>/yundongjia/informationdetail?id='+id+'&_time='+t;
		}
		
		tobackDemo(url);
	}
	
</script>
</head>
<body>
<div class="main-content">
		<div class="page-header">
			当前位置：
			<a href="javascript:toback(0)">资讯列表</a> &nbsp; &gt; &nbsp;
			<a href="javascript:toback(1);">资讯详情</a>&nbsp; &gt;  &nbsp;
			<a href="javascript:void(0);"> 编辑资讯 </a>
		</div>
		<form id="form" name="form1"
			onsubmit="return false;" method="post">
			<input type="hidden" value="${info.rowId}" id="rowid" name="rowid">
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">标题：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="infotitle" value="${info.infoTitle}" name="infotitle"
						class="form-control" placeholder="">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">类型：</div>
				<div class="col-md-6 padding0L form-group">
					<select id="infotype" name="infotype" class="form-control btn btn-default">
						<option value="0" <c:if test="${info.infoType ==0}">selected="selected"</c:if> >体重</option>
						<option value="1" <c:if test="${info.infoType ==1}">selected="selected"</c:if> >体脂率</option>
						<option value="2" <c:if test="${info.infoType ==2}">selected="selected"</c:if> >肌肉量</option>
					</select>
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L">教练图</div>
				<div class="col-md-7 padding0L form-group">
					<div>
						<input id="file1" type="file" name="imgs" value="上传"
							accept="image/gif,image/jpeg,image/png" multiple="multiple"
							onchange="imgview('imgs','file1')" />
							<span style="color:red;">最多可上传3张图</span>
					</div>
					<div class="col-md-12" id="imgs">
					 
					   <c:forEach items="${imgs}" var="img">
					       <img class="col-md-2"  value=""  alt='' src="${img.path}" width='100px' height='100px' style='padding: 5px;'>
						</c:forEach>
					
					</div>
				</div>
				<!-- <label class="xing">*</label> -->
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">正文：</div>
				<div class="col-md-11 padding0L form-group">
					<textarea id="editor-trigger" name="infocontext">${info.infoContext}</textarea>
				</div>
			</div>
			<div class="col-md-8">
				<div class="col-md-offset-1 col-md-1">
					<!-- <input type="reset" class="btn btn-default bcColor" value="重置"> -->
				</div>
				<div class="form-group col-md-offset-1 col-md-1">
					<input  id="inpsub"  type="button" onclick="subForm();"
						class="btn btn-default bcColor" value="提交">
				</div>
			</div>
		</form>
	</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrapValidator.js"></script>

  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/froala_editor.min.js" ></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/align.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/char_counter.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/code_beautifier.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/code_view.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/colors.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/draggable.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/emoticons.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/entities.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/font_size.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/font_family.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/fullscreen.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/image.min.js"></script>
<%--   <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/image_manager.min.js"></script> --%>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/line_breaker.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/inline_style.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/link.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/lists.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/paragraph_format.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/paragraph_style.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/quick_insert.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/quote.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/table.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/save.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/url.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/languages/zh_cn.js"></script>

  <script type="text/javascript" src="<%=path %>/static/js/imgView.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('#editor-trigger').froalaEditor({
	    	 "height":"400",
	    	 imageDefaultWidth:'350',
	    	 "placeholderText":placeText,
	    	 "imageAllowedTypes":["jpeg", "jpg", "png","gif","JPEG", "JPG", "PNG", "GIF"],
	    	 imageInsertButtons : ["imageUpload"],
	    	 imageUploadURL: '<%=path%>/yundongjia/editoruploadimgs',
	    	 imageStyles : {
					"fr-rounded" : "圆形",
					"fr-bordered" : "边框"
			 },
	    	 language: "zh_cn"
	     }).on ('froalaEditor.image.removed', function (e, editor, $img) {
	         var src= $img.attr('src');
	         var t=new Date().valueOf();
	         $.ajax({
	        	 url:'<%=path%>/yundongjia/editordelimg',
	        	 type:'post',
	        	 async: false,
	        	 dataType:'json',
	        	 data:{
	        		 src:src,
	        		 _time:t
	        	 },
	        	 success:function(res){
	        	 
	        	 }
	         });
	     });
		
		$("#form").bootstrapValidator({
			fields:{
				infotitle:{
					validators:{
						notEmpty:{
							message:'标题必填'
						},
						stringLength:{
						    min:1,
							max:30,
							message:'标题长度在1到30个字符之间'
						}
					}
				}
			}
		});
		
		
	});
/* 编辑信息 */	
function subForm(){
	$('#form').data('bootstrapValidator').validate();  
    if(!$('#form').data('bootstrapValidator').isValid()){ 
        return ;  
    }
	var data = new FormData($("#form")[0]);
	$.ajax({
		url:'<%=path%>/yundongjia/updateinformation',
		type : 'post',
		dataType : 'json',
		data : data,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			if(result.result > 0){
				alert("编辑成功");
				var t=new Date().valueOf();
				$(".index-right").load('<%=path%>/yundongjia/informationdetail',{id:result.id,_time:t});
			}else{
				alert("编辑失败");
			}
		}
	});
}

</script>

</body>
</html>
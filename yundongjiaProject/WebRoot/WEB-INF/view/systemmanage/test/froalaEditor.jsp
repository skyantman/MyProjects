<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/froala_editor.min.css">





<title></title>
</head>
<body>
<h1>hello</h1>
<textarea id="editor" rows="150" cols="150"></textarea>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path%>/static/froalaEditor/js/froala_editor.min.js"></script> 
<!--[if lt IE 9]>
    <script src="<%=path%>/static/froalaEditor/js/froala_editor_ie8.min.js"></script>
<![endif]--> 
<script src="<%=path%>/static/froalaEditor/js/plugins/tables.min.js"></script> 
<script src="<%=path%>/static/froalaEditor/js/plugins/lists.min.js"></script> 
<script src="<%=path%>/static/froalaEditor/js/plugins/colors.min.js"></script> 
<script src="<%=path%>/static/froalaEditor/js/plugins/media_manager.min.js"></script> 
<%-- <script src="<%=path%>/static/froalaEditor/js/plugins/font_family.min.js"></script>  --%>
<script src="<%=path%>/static/froalaEditor/js/plugins/font_size.min.js"></script> 
<script src="<%=path%>/static/froalaEditor/js/plugins/block_styles.min.js"></script> 
<script src="<%=path%>/static/froalaEditor/js/plugins/video.min.js"></script>


 
<script src="<%=path%>/static/froalaEditor/js/langs/zh_cn.js"></script>
<script type="text/javascript">
$(function(){
	 $('#editor').editable({
	        inlineMode: false,
	        theme: 'gray',
	        height: '500px', //高度
	        language: "zh_cn",
	        allowedImageTypes: ["jpeg", "jpg", "png", "gif"],
	        imageButtons: ["floatImageLeft", "floatImageNone", "floatImageRight",  "replaceImage", "removeImage"],
	        imageUploadURL: '<%=path%>/yundongjia/xheditor',
	    }).on('froalaEditor.image.beforeUpload', function (e, editor, files) {
	    
	          if (files.length) {
	              var reader = new FileReader();
	              reader.onload = function (e) {
	                var result = e.target.result;
	            	console.log(result);
	                editor.image.insert(result, null, null, editor.image.get());
	              };

	              reader.readAsDataURL(files[0]);
	            }

	            return false;
	          });
	 /* "linkImage", */
})
</script>
</body>
</html>
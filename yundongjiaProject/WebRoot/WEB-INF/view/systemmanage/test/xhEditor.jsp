<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 核心样式表 -->
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/froala_editor.min.css" />
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/froala_style.min.css" />
<!-- 各个插件样式表，按需求使用 -->
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/char_counter.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/code_view.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/colors.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/emoticons.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/file.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/fullscreen.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/image.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/image_manager.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/line_breaker.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/quick_insert.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/table.css">
<link rel="stylesheet" href="<%=path %>/static/froalaEditor/css/plugins/video.css">


<link href="<%=path %>/static/froalaEditor/css/themes/dark.min.css" rel="stylesheet" type="text/css" />
<style type="text/css">


      
</style>
</head>
<body>

      <div id='edit' style="margin-top: 30px;">
      
      </div>

 <button onclick="save();">提交</button>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.0.js"></script>

<!-- 核心脚本 -->
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/froala_editor.min.js"></script>
<!-- 各个插件脚本 -->
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/align.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/char_counter.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/code_beautifier.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/code_view.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/colors.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/draggable.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/emoticons.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/entities.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/file.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/font_family.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/font_size.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/fullscreen.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/image.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/image_manager.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/inline_style.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/line_breaker.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/link.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/lists.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/paragraph_format.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/paragraph_style.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/quick_insert.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/quote.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/table.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/save.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/url.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/plugins/video.min.js"></script>
<!-- 语言脚本 -->
<script type="text/javascript" src="<%=path %>/static/froalaEditor/js/languages/zh_cn.js"></script>






<script type="text/javascript">
$(function () {
    $('#edit').on('froalaEditor.initialized', function (e, editor) {
        editor.events.bindClick($('body'), '#save', function () {
            var fs = editor.html.get();
            editor.events.focus();
        });
    }).on('froalaEditor.initialized', function (e, editor) {
        editor.events.bindClick($('body'), '#release', function () {
            var fs = editor.html.get();
            $("#msgForm").submit();
            editor.events.focus();
        });
    }).froalaEditor({
        heightMin: 450,
        heightMax: 800,
        placeholderText: '',
        pastePlain: true,
        theme: 'gray',
        fontFamilySelection: true,
        fontSizeSelection: true,
        paragraphFormatSelection: true,
        toolbarStickyOffset: 53,
        toolbarButtons: ['fullscreen', '|', 'insertLink', 'insertImage', 'insertVideo', 'insertFile', 'insertTable', '|', 'quote', 'insertHR', 'subscript', 'superscript', 'undo', 'redo', '-', 'bold', 'italic', 'underline', 'strikeThrough', '|', 'fontFamily', '|', 'fontSize', '|', 'color', 'emoticons', 'inlineStyle', '-', 'paragraphFormat', '|', 'paragraphStyle', 'align', 'formatOL', 'formatUL', 'outdent', 'indent', 'clearFormatting'],
        imageAllowedTypes: ['jpeg', 'jpg', 'png', 'gif'],
        imageDefaultWidth: 100,
//         imageInsertButtons: ['imageBack', '|', 'imageUpload', 'imageByURL'],
//         imageUploadURL: '/upload_image',
        imageManagerLoadURL: 'http://i.froala.com/assets/photo1.jpg',
        fileUploadURL: '/upload_file',
        language: 'zh_cn'
    });
});

/*
inlineMode: false,
    	alwaysBlank: true,
    	height:'400px',
    	language: 'zh_cn',
    	 allowedImageTypes: ["jpeg", "jpg", "png", "gif"],
    	 imageUploadURL: '/yundongjia/xheditor',//上传到本地服务器
*/
function save(){
	var contxt=$("#text").val();
	console.log(contxt);
	$.ajax({
		url:'<%=path%>/yundongjia/editor',
		type:'post',
		dataType:'json',
		data:{
			context:contxt
		},
		success:function(data){
			console.log(data);
		}
	});
}

</script>
</body>
</html>
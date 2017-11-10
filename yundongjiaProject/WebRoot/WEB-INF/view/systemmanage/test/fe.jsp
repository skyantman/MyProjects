<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
<style type="text/css">


</style>
</head>
<body>
<div id="mainBody">
<p id="cssP">hello word test</p>
 <div id="editor">
    <div id='edit' style="margin-top: 30px;">
      <!-- <img class="fr-fil fr-dii fr-draggable" alt="" src="http://app.goheng.com:9996/images/tempImage/1489643717191.jpg">
      -->
     
     
        <h1>Image Styles</h1>

      <p>The classes should be defined in CSS, otherwise no changes will be visible on the image&#39;s appearance.</p>

      

      <p>You can define your own image styles using the <code><a href="https://www.froala.com/wysiwyg-editor/docs/options#imageStyles" title="imageStyles" target="_blank">imageStyles</a></code> option. This option is an Object where the key represents the class name and its value is the style name that appears in the dropdown list. It is important to have unique keys otherwise they will not work properly.</p>
      <p>By default you can select multiple image styles at a time. If you want to toggle them and allow only one style to be selected at a time use the <code><a href="https://www.froala.com/wysiwyg-editor/docs/options#imageMultipleStyles" title="imageMultipleStyles" target="_blank">imageMultipleStyles</a></code> option.</p>
   
     </div>
    <button onclick="save();">提交</button>
  </div>
  
  

  </div>
  <script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.0.js"></script>
  
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
  <!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script>
 -->
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/froala_editor.min.js" ></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/align.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/char_counter.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/code_beautifier.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/code_view.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/colors.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/draggable.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/emoticons.min.js"></script>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/entities.min.js"></script>
<%--   <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/file.min.js"></script> --%>
<%--   <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/font_size.min.js"></script> --%>
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
<%--   <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/video.min.js"></script> --%>
  <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/languages/zh_cn.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
	 var doc = document.getElementById("cssP");
		    var u = navigator.userAgent;
		    var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
		    var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
		    //alert('是否是Android：'+isAndroid);
		    //alert('是否是iOS：'+isiOS);
		    if(isAndroid){
		    	//document.getElementsByName("title_three")[0].style.cssText = "color:red;";
		    	var doc = document.getElementById("mainBody");
		    	console.log(doc);
		    	doc.setAttribute("style", "font-size:16px;color:red");
		    	//$("#main").css({"font-size":"16px","color":"red"});
		    	
		    }
		    if(isiOS){
		    	var phoneType = "";
		    	//6   w=375    6plus w=414   5s w=320     5 w=320
		    	var wigth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
		    	console.log("width="+wigth);
		    	if(wigth>400){ 
		    		phoneType = "iphone6 plus";
		    	}else if(wigth>370){ 
		    		phoneType = "iphone6";
		    	}else if(wigth>315){ 
		    		phoneType = "iphone5 or iphone5s or iphone 4s";
		    	}else{ 
		    		phoneType = "";
		    	}
		    	console.log(phoneType);
		    	$("#main").css({"font-size":"32px","color":"blue"});
		    }
 });
 </script>
 <script type="text/javascript">
 
 $(function(){
     $('#edit').froalaEditor({
    	 "height":"400",
    	 "imageDefaultWidth":'350',//默认宽度
    	 "imageAllowedTypes":["jpeg", "jpg", "png","gif","JPEG", "JPG", "PNG", "GIF"],//图片上传后缀格式
    	 imageInsertButtons : ["imageUpload"],//只显示(点击或拖拽图片上传)
    	 imageUploadURL: '<%=path%>/yundongjia/editoruploadimgs',//图片上传路径
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

   });
 function save(){
	 var content='';
	 //content = $("#edit").find('.fr-view').html();
	 content = $('#edit').froalaEditor('html.get');
	 console.log(content);
	$.ajax({
		 url:'<%=path%>/yundongjia/editor',
		 dataType:'json',
		 type:'post',
		 data:{
			 context:content,
		 },
		 success:function(data){
			 console.log(data);
		 }
	})
 }
 </script>


</body>
</html>
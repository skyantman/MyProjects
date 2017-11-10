<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>富文本测试</title>

<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/bsfileinput/css/fileinput.min.css">



<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/wEditor/css/wangEditor.min.css">

  

<style type="text/css">
#editor-trigger {
	/* height: 1000px; */
	/*max-height: 500px;*/
	
}

.container {
	/* border: 1px solid blue; width : 100%;
	height: 100%;
	margin: 0 auto;
	position: relative;
	width: 100%; */
	
}
</style>
</head>
<body>
	<h4>支持多种语言</h4>
	<form enctype="multipart/form-data">
		<label>简体中文----</label> <input id="file-zh" name="fileImg"
			type="file" multiple>
		<hr style="border: 2px dotted">
		 
	</form>
	
	
	<h1>Hello Word</h1>

	<div class="container">

		<textarea id="editor-trigger">
           	.........请输入内容...
             </textarea>


	</div>
	<button onclick="getHtml();">获取HTML内容</button>
	<h1 style="text-align: center;">Html5 Upload示例</h1>

	<div id="demo" class="demo"></div>





	<h1>webuploader</h1>

	<div id="uploader">
		<div class="queueList">
			<div id="dndArea" class="placeholder">
				<div id="filePicker"></div>
				<p>或将照片拖到这里，单次最多可选300张</p>
			</div>
		</div>
		<div class="statusBar" style="display: none;">
			<div class="progress">
				<span class="text">0%</span> <span class="percentage"></span>
			</div>
			<div class="info"></div>
			<div class="btns">
				<div id="filePicker2"></div>
				<div class="uploadBtn">开始上传</div>
			</div>
		</div>
	</div>
	<h1></h1>

	

	<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.0.js"></script>

	
	<script type="text/javascript"
		src="<%=path%>/static/wEditor/js/wangEditor.js"></script>




<script type="text/javascript" src="<%=path %>/static/bsfileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
$("#file-zh").fileinput({
	showRemove:true,
	showUpload:true,//是否显示文件上传按钮。默认是submit按钮，除非指定了uploadUrl属性。默认值true。
	showCancel:false,//是否显示取消文件上传按钮。只有在AJAX上传线程中该属性才可见可用。默认值true。
	elErrorContainer:false,//elErrorContainer: 	'#kv-error-1'	错误信息显示地方   false不显示
	language: 'zh',
    uploadUrl: '<%=path%>/yundongjia/bs',
    allowedFileExtensions : ['jpeg', 'png','gif'],
    initialPreview: [//回显图片
                     "<img src='<%=path%>/static/images/yundongjia/nullUpdate.png' class='file-preview-image' alt='Desert' title='Desert'>",
                     "<img src='<%=path%>/static/images/memberImages/gm.png' class='file-preview-image' alt='Jelly Fish' title='Jelly Fish'>",
                 ],
    initialPreviewConfig:[//
          {
        	  caption:'nullUpdate.png',
        	  key: 100, 
        	  extra: {id: 100,flag:1000},
        	  url:'<%=path%>/yundongjia/bsdel'
          },
          {
        	  caption:'gm.png',
        	  key: 101, 
        	  extra: {id: 101,flag:1001},
        	  url:'<%=path%>/yundongjia/bsdel'
          }]
});

/**
 *    // for image files
            initialPreview: [
                  "<img src='/images/desert.jpg' class='file-preview-image' alt='Desert' title='Desert'>",
                  "<img src='/images/jellyfish.jpg' class='file-preview-image' alt='Jelly Fish' title='Jelly Fish'>",
              ], 
 *
 */

</script>

	<script type="text/javascript">
		function getHtml(){
			// 获取编辑器区域完整html代码
	        var html = editor.$txt.html();
			console.log(html);
		}
		//阻止输出log
		// wangEditor.config.printLog = false;
		var editor = new wangEditor('editor-trigger');
		editor.config.uploadImgUrl = '<%=path%>/yundongjia/editoruploadimgs';
		editor.config.uploadImgFileName = 'weditorimgs';//img的name
		
		 // 自定义上传事件
        editor.config.uploadImgFns.onload = function (result, xhr) {
        	var resultJson=eval("("+result+")");//转换为json对象
        	console.log("(" + resultJson + ")");
        	var resultText = resultJson.path;
        	console.log(resultText);
			// resultText 服务器端返回的text
            // xhr 是 xmlHttpRequest 对象，IE8、9中不支持

            // 上传图片时，已经将图片的名字存在 editor.uploadImgOriginalName
            var originalName = editor.uploadImgOriginalName || '';  
            
            var path = '<%=path%>/' + resultText.replace("\"", "");
			console.log("(" + path + ")");
			// 如果 resultText 是图片的url地址，可以这样插入图片：
			editor
					.command(
							null,
							'insertHtml',
							'<img width="'+resultJson.width+'px"   src="' + path + '" alt="'
					+ originalName + '" style="border:1px solid red;display:inline-block;"/>');
			// 如果不想要 img 的 max-width 样式，也可以这样插入：
			// editor.command(null, 'InsertImage', resultText);
		};
		//editor.create();
	</script>

</body>
</html>
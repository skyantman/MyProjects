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
<title>编辑商品</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
<%-- <link rel="stylesheet" type="text/css" href="<%=path%>/static/wEditor/css/wangEditor.min.css"> --%>

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
<div class="main-content">
 <div class="page-header">
		当前位置：<a href="javascript:toback(1);"> 商品列表 </a> &gt;
		<a href="javascript:void(0);"> 编辑商品 </a>
 </div>
		<form id="form" name="form1" enctype=”multipart/form-data”
			onsubmit="return false;" method="post">
			<input type="hidden" value="${g.goodsId }" name="goodsid">
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">商品名称：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="gname" value="${g.gName }" name="gname"
						class="form-control" placeholder="请输入商品名称">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">商品卖点：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="special" value="${g.special }" name="special"
						class="form-control" placeholder="请输入商品卖点-多个用英文逗号隔开">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">商品规格：</div>
				<div class="col-md-6 padding0L form-group">
					
					 
					<table>
						<tr>
							<td style="width:1%;">颜色</td>
							<c:forEach var="color" items="${colors}">
							   <td style="width:1%;"> 
							   		<c:set var="varCol" value="0"></c:set>
							   		<c:forEach items="${chColors}" var="vc">
							   			<c:if test="${color eq vc}">
							   			    <c:set var="varCol" value="1"></c:set>
							   			</c:if>
							   		</c:forEach>
							   		<input type="checkbox" <c:if test="${varCol == 1}">checked="checked"</c:if> value="${color}" name="colors">${color} 
							   </td>
							</c:forEach>
						</tr>
						<tr>
							<td style="width:1%;">尺码</td>
							<c:forEach var="size" items="${sizes}">
							   <td style="width:1%;"> 
							   			<c:set value="0" var="varSize"></c:set>
							   			<c:forEach items="${chSizes}" var="ch">
							   				<c:if test="${ch eq  size}">
							   				   <c:set value="1" var="varSize"></c:set>
							   				</c:if>
							   			</c:forEach>
							   		<input type="checkbox" <c:if test="${varSize == 1}">checked="checked"</c:if> value="${size}" name="sizes">${size} 
							   </td>
							</c:forEach>
						</tr>
					</table>
				</div>
				<!-- <label class="xing">*</label> -->
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">商品价格：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="gprice" value="${g.gPrice }" name="gprice"
						class="form-control" placeholder="请输入商品价格-单位元">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">商品库存：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="gcount" value="${g.gCount }" name="gcount"
						class="form-control" placeholder="请输入商品库存">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">关键字：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="keywords" value="${g.keywords }" name="keywords"
						class="form-control" placeholder="关键字多个用英文逗号区分">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">运费：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="freight" value="${g.freight }" name="freight"
						class="form-control" placeholder="请输入运费">
				</div>
				<label class="xing">*</label>
			</div>

			<div class="col-md-12">
			    <div class="col-md-1 padding0L padding5T">商品主图片：</div>
				<div class="col-md-6 padding0L form-group">
					<div>
						<input id="file0" type="file" name="imgFirst" value="上传"
							accept="image/gif, image/jpeg, image/png"
							onchange="imgview('imgsOne','file0',1)" />
					</div>
					<div class="col-md-12" id="imgsOne">
						<c:forEach begin="0" end="0"  step="1" varStatus="i" items="${goodsImg}" var="img">
					       <img class="col-md-2"    alt='' src="${img.path}" width='100px' height='100px' style='padding: 5px;'>
						</c:forEach>
					</div> 
				</div>
				<!-- <label class="xing">*</label> -->
			</div>
				

			<div class="col-md-12">
			    <div class="col-md-1 padding0L padding5T">商品副图片：</div>
				<div class="col-md-6 padding0L form-group">
					<div>
						<input id="file1" type="file" name="imgs" value="上传"
							accept="image/gif, image/jpeg, image/png" multiple="multiple"
							onchange="imgview('imgs','file1')" />
							<span style="color:red;">最多可上传4张图</span>
					</div>
					<div class="col-md-12" id="imgs">
						<c:forEach begin="1"  step="1" varStatus="i" items="${goodsImg}" var="img">
					       <img class="col-md-2" alt='' src="${img.path}" width='100px' height='100px' style='padding: 5px;'>
						</c:forEach>
					</div> 
				</div>
				<!-- <label class="xing">*</label> -->
			</div>
			
			
			
			
			 
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">商品信息：</div>
				<div class="col-md-11 padding0L form-group">
					<textarea id="editor-trigger" name="des" >
					
					${g.des}
					
					</textarea>
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">取消限制：</div>
				<div class="col-md-6 padding0L form-group">
					<select id="canclelimit" name="canclelimit"
						class="form-control btn btn-default">
						<option value="0" <c:if test="${g.goodsLimit == 0}">selected="selected"</c:if> >不限制</option>
						<option value="1" <c:if test="${g.goodsLimit == 1}">selected="selected"</c:if> >6小时</option>
						<option value="2" <c:if test="${g.goodsLimit == 2}">selected="selected"</c:if> >12小时</option>
						<option value="3" <c:if test="${g.goodsLimit == 3}">selected="selected"</c:if> >24小时</option>
						<option value="4" <c:if test="${g.goodsLimit == 4}">selected="selected"</c:if> >36小时</option>
						<option value="5" <c:if test="${g.goodsLimit == 5}">selected="selected"</c:if> >72小时</option>
					</select>
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-8">
				
				<div class="form-group col-md-offset-1 col-md-1">
					<input onclick="subForm();" id="inpsub" type="button"
						class="btn btn-default bcColor" value="提交">
				</div>
			</div>
		</form>
	</div>
	
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>

<%-- <script type="text/javascript" src="<%=path%>/static/wEditor/js/wangEditor.js"></script> --%>
<script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
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
  <%-- <script type="text/javascript" src="<%=path%>/static/froalaEditor25/js/plugins/font_size.min.js"></script> --%>
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
			gname:{
				validators:{
					notEmpty:{
						message:'商品名称必填'
					}
				}
			},
			special:{
				validators:{
					notEmpty:{
						message:'商品卖点必填'
					}
				}
			},
			/* colors:{
				validators:{
					notEmpty:{
						message:'颜色必选'
					}
				}
			}, */
			gprice:{
				validators:{
					notEmpty:{
						message:'商品价格必填'
					},
					regexp:{
						message:'请正确填写价格(数字或两位小数)',
						regexp:/^(([1-9]\d*)|\d)(\.\d{1,2})?$/
						
					}
				}
			},
			gcount:{
				validators:{
					notEmpty:{
						message:'库存必填'
					},
					regexp:{
						message:'请正确填写库存',
						regexp:/^\d+$/
						
					}
				}
			},
			freight:{
				validators:{
					notEmpty:{
						message:'运费必填'
					},
					regexp:{
						message:'请正确填写运费',
						regexp:/^(([1-9]\d*)|\d)(\.\d{1,2})?$/
						
					}
				}
			},
			keywords:{
				validators:{
					notEmpty:{
						message:'关键字必填'
					},
					stringLength:{
						min:1,
						max:12,
						message: '关键字长度必须在1到12字符之间'
					},
					regexp:{
						message:'多个用英文逗号分隔',
						regexp:/^([\u4e00-\u9fa5a-zA-Z0-9]{1,12},){0,}([\u4e00-\u9fa5A-Za-zA-Z0-9]{1,12})$/
					}
				}
			}
			
			/* ,
			imgs:{
				validators:{
					notEmpty:{
						message:'图片必选'
					}
				}
			} */
			
		}
	});
	
});

/* 修改商品 */	
function subForm(){
	/* var bool = ue.hasContents();
	if(!bool){
		alert("商品信息必填");
		return false;
	}else{
		
	} */
	$('#form').data('bootstrapValidator').validate();  
    if(!$('#form').data('bootstrapValidator').isValid()){ 
        return ;  
    }
    
	var data = new FormData($("#form")[0]);
	$.ajax({
		url:'<%=path%>/yundongjia/updategoods',
		type : 'post',
		dataType : 'json',
		data : data,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			if(result.msg > 0){
				alert("修改成功");
				var t=new Date().valueOf();
				$(".index-right").load('<%=path%>/yundongjia/goodsdetail?goodsId='+result.id+'&_time='+t);
			}else{
				alert("修改失败");
			}
		}
	});
}	

</script>	
	
</body>
</html>
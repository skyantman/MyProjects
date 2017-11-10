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
<title>活动修改</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
</head>
<body>
<div class="main-content">
	<div class="page-header">
		当前位置：<a href="javascript:void(0);"> 新建活动 </a>
	</div>
		<form id="form" name="form1" enctype="multipart/form-data" onsubmit="return false;" method="post">
			<input id="activeid" type="hidden" value="${act.activeId}" name="activeid">
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">活动名称：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="activename" value="${act.activeName }" name="activename"
						class="form-control" placeholder="请输入活动名称">
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">活动类型：</div>
				<div class="col-md-6 padding0L form-group">
				  <select id="activetype" name="activetype" class="form-control btn btn-default">
						<option value="0"  <c:if test='${act.activeType == 0}'>selected="selected"</c:if>  >健身</option>
						<option value="1" <c:if test='${act.activeType == 1}'>selected="selected"</c:if>  >夜跑</option>
						<option value="2" <c:if test='${act.activeType == 2}'>selected="selected"</c:if>   >动感操</option>
					</select>
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">所在城市：</div>
				<div class="col-md-2 padding0L form-group">
					<select id="province" name="province" onchange="loadCity(this);"
						class="form-control btn btn-default">
						<option value="-1">省</option>
						<c:forEach items="${pros}" var="p">
						 <option value="${p.code }"  <c:if test="${act.ProvinceId == p.code}">selected="selected"</c:if>   >${p.name }</option>
						</c:forEach>

					</select>
				</div>
				<div class="col-md-2 padding0L form-group">
					<select id="city" name="city" class="form-control btn btn-default" onchange="loadArea(this);">
						<option value="${act.city }">${act.cityName}</option>
						
					</select>
				</div>
				<div class="col-md-2 padding0L form-group">
					<select id="area" name="regionsid"
						class="form-control btn btn-default">
						<option value="${act.regionsId }">${act.areaName}</option>

					</select>
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">活动地址：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="activeaddres" value="${act.activeAddres }" name="activeaddres"
						class="form-control" placeholder="请输入活动地址" onchange="changeAddress(this);">
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12">
	        <div class="form-group col-md-1 padding0L">
	       	活动时间：
	       	 </div>
	       	  <div class="form-group col-md-3 padding0L">
	       	     <input id="activestarttime" size="16" readonly="readonly" value="${act.activeStartTime }" type="text" onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'activeendtime\')}'})"
							name="activestarttime" 
							value="" class="form_datetime form-control" placeholder="开始日期" />
	       	   
	       	  </div>
	       	 
	     
	       	  <div class="form-group col-md-3 padding0L">
	       	     <input id="activeendtime" size="16" value="${act.activeEndTime }" readonly="readonly" type="text" onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'activestarttime\')}'})"
							value="" name="activeendtime" class="form_datetime form-control" placeholder="结束日期" />
	       	  
	       	  </div>
	       	  <label class="xing">*</label>  
	       </div>
			
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">活动人数：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="activenum" value="${act.activeNum }" name="activenum"
						class="form-control" placeholder="请输入活动人数">
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">关键字：</div>
				<div class="col-md-6 padding0L form-group">
					<input id="activekeyword" value="${act.activeKeyword }" name="activekeyword"
						class="form-control" placeholder="关键字多个用英文逗号区分">
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">活动介绍：</div>
				<div class="col-md-6 padding0L form-group">
					 <textarea class="form-control" id="activeintroduce" name="activeintroduce" rows="5"
								cols="20">${act.activeIntroduce }</textarea>
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">注意事项：</div>
				<div class="col-md-6 padding0L form-group">
					 <textarea class="form-control" id="activecomm" name="activecomm" rows="5"
								cols="20">${act.activeComm }</textarea>
				</div>
				<label class="xing">*</label>  
			</div>
			<div class="col-md-12" style="width: 630px; height: 390px;border: 1px solid gray;">
				<div class="col-md-2 padding0L padding5T">地图位置：</div>
				
				<div id="container" class="padding0L form-group" 
				style="position: absolute;overflow:hidden;margin-top:30px; 
				width: 90%; height: 85%; top: 50; ">
					
				</div>
			</div>
			<div class="col-md-12" style="margin-top: 1%;">
				<div class="col-md-1 padding0L padding5T">经度：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="lng" value="${act.lng }" name="lng" readonly="readonly"
						class="form-control" placeholder="">
						
				</div>
				
				<div class="col-md-1 padding0L padding5T">维度：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="lat" value="${act.lat }" name="lat" readonly="readonly"
						class="form-control" placeholder="">
				</div>
			</div>
			
			<div class="col-md-12">
			    <div class="col-md-1 padding0L padding5T">活动主相册：</div>
				<div class="col-md-6 padding0L form-group">
					<div>
						<input id="file0" type="file" name="imgFirst" value="上传"
							accept="image/gif, image/jpeg,image/png"
							onchange="imgview('imgsOne','file0',1);" />
					</div>
					<div class="col-md-12" id="imgsOne">
					
						<c:forEach begin="0" end="0" step="1" items="${activeImg}" var="img">
					       <img class="col-md-2"  alt='' src="${img.path}" width='100px' height='100px' style='padding: 5px;'>
						</c:forEach>
					</div>
				</div>
				<!-- <label class="xing">*</label> -->
			</div>
			
			<div class="col-md-12">
			    <div class="col-md-1 padding0L padding5T">活动副相册：</div>
				<div class="col-md-6 padding0L form-group">
					<div>
						<input id="file1" type="file" name="img" value="上传"
							accept="image/gif, image/jpeg,image/png" multiple="multiple"
							onchange="imgview('imgs','file1');" />
							<span style="color:red;">最多可上传4张图</span>
					</div>
					<div class="col-md-12" id="imgs">
					
						<c:forEach begin="1" step="1" items="${activeImg}" var="img">
					       <img class="col-md-2" alt='' src="${img.path}" width='100px' height='100px' style='padding: 5px;'>
						</c:forEach>
					</div>
				</div>
				<!-- <label class="xing">*</label> -->
			</div>
			

			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">关联场馆：</div>
				<div class="col-md-2 padding0L form-group">
					 <select id="studioid" name="studioid"
						class="form-control btn btn-default">
						<option value="-1" >请选择</option>
						<c:forEach items="${studios}" var="s">
							<option value="${s.studioid }"  <c:if test="${act.studioId  == s.studioid}">selected="selected"</c:if>    >${s.studioname }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="col-md-1 padding0L padding5T">成本价：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="studiocost" value="${act.studioCost }" name="studiocost"
						class="form-control" placeholder="">
				</div>
				<label class="xing">*</label>  
			</div>
			
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">关联教练：</div>
				<div class="col-md-2 padding0L form-group">
					 <select id="coachids" name="coachids"
						class="form-control btn btn-default">
						<option value="-1">请选择</option>
						<c:forEach items="${coachs}" var="c">
							<option value="${c.coachid }"  <c:if test="${act.coachIds == c.coachid}">selected="selected"</c:if>       >${c.nickname }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="col-md-1 padding0L padding5T">成本价：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="coachcosts" value="${act.coachCosts }" name="coachcosts"
						class="form-control" placeholder="">
				</div>
				<label class="xing">*</label>  
			</div>
			
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">活动费用：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="activeprice" value="${act.activePrice }" name="activeprice"
						class="form-control" placeholder="元为单位">
						
				</div>
				
				<div class="col-md-1 padding0L padding5T">企业卡：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="activesubnum" value="${act.activeSubNum }" name="activesubnum"
						class="form-control" placeholder="计次为单位">
				</div>
				<label class="xing">*</label>  
			</div>
			
			<div class="col-md-12">
				<div class="col-md-1 padding0L padding5T">取消限制：</div>
				<div class="col-md-6 padding0L form-group">
					 <select id="activitylimit" name="activitylimit"
						class="form-control btn btn-default">
						<option value="0"   <c:if test="${act.activityLimit == 0}">selected="selected"</c:if>   >不限制</option>
						<option value="1"  <c:if test="${act.activityLimit == 1}">selected="selected"</c:if> >12小时</option>
						<option value="2" <c:if test="${act.activityLimit == 2}">selected="selected"</c:if> >24小时</option>
						<option value="3" <c:if test="${act.activityLimit == 3}">selected="selected"</c:if> >36小时</option>
						<option value="4" <c:if test="${act.activityLimit == 4}">selected="selected"</c:if> >48小时</option>
						<option value="5" <c:if test="${act.activityLimit == 5}">selected="selected"</c:if> >72小时</option>
					</select>
				</div>
				<label class="xing">*</label>  
			</div>
			
			<div class="col-md-12">
				 <div class="form-group col-md-offset-4 col-md-1 form-group">
							<input  id="" type="button" onclick="update();"
								class="btn btn-default bcColor" value="确定">
						</div>
			</div>
			
		</form>
	</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/gym/My97DatePicker/WdatePicker.js"></script>	
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/imgView.js"></script>

	<!-- 市模板 -->
<script type="text/x-javascript-tmpl" id="cityTmpl">
<option value="{{= code}}">{{= name}}</option>
</script>
<script type="text/x-javascript-tmpl" id="areaTmpl">
<option value="{{= code}}">{{= name}}</option>
</script>
<script type="text/javascript">
var map;
var marker;
function init() {
	map = new BMap.Map("container");            // 创建Map实例
	//-------------------------------------------------------
	var lngx = $("#lng").val();
	var latx = $("#lat").val();
	var point = new BMap.Point(lngx, latx); // 创建点坐标
	map.centerAndZoom(point,12);
	marker = new BMap.Marker(new BMap.Point(lngx, latx)); // 创建点
	map.addOverlay(marker);
	//----------------------------------------------------------
	var geoc = new BMap.Geocoder(); 
	//点击地图获取经纬度
	map.addEventListener("click",function(e){
		//先把点移除掉
		map.removeOverlay(marker);//移除点
		marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat)); // 创建点
		
		map.addOverlay(marker);
		map.enableScrollWheelZoom();                 //启用滚轮放大缩小
		marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
		$("#lng").val(e.point.lng);
		$("#lat").val(e.point.lat);
		
		var pt=e.point;
		geoc.getLocation(pt,function(rs){
			var addComp = rs.addressComponents;
			var address = addComp.province +  addComp.city +  addComp.district + addComp.street + addComp.streetNumber;
			$("#activeaddres").val(address);
		});
		
		
	});
}

/* 保存修改 */
function update(){
	$('#form').data('bootstrapValidator').validate();  
    if(!$('#form').data('bootstrapValidator').isValid()){ 
        return ;  
    } 
    
	var t=new Date().valueOf();
	 var data = new FormData($("#form")[0]);
		$.ajax({
			url:'<%=path%>/yundongjia/updateactivity',
			type : 'post',
			dataType : 'json',
			data : data,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(result) {
				if(result > 0){
					alert("修改成功");
					$(".index-right").load('<%=path%>/yundongjia/detailactivity?activityId='+result+'&tab=1&_time='+t);
				}
			}
		});
}


//输入地址设置坐标
function changeAddress(obj){
	var value = $(obj).val();
	// 创建地址解析器实例
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上,并调整地图视野
	myGeo.getPoint(value, function(point){
		if (point) {
			map.centerAndZoom(point, 16);
			map.addOverlay(null);
			map.addOverlay(new BMap.Marker(point));//红图标
			
			$("#lng").val(point.lng);
			$("#lat").val(point.lat);
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "北京市");
}

$(document).ready(function(){
	init();//初始化地图
	$("#form").bootstrapValidator({
		fields:{
			activename:{
				validators:{
					notEmpty:{
						message:'活动名称必填'
					}
				}
			},
			province:{
				validators:{
					callback:{
						message:'省必选',
						callback:function(value){
							if(value == -1){
								return false;
							}else{
								return true;
							}
							
						}
					}
				}
			},
			city:{
				validators:{
					callback:{
						message:'市必选',
						callback:function(value){
							if(value == -1){
								return false;
							}else{
								return true;
							}
						}
					}
				}
			},
			regionsid:{
				validators:{
					callback:{
						message:'区 必选',
						callback:function(value){
							if(value == -1){
								return false;
							}else{
								return true;
							}
						}
					}
				}
			},
			activeaddres:{
				validators:{
					notEmpty:{
						message:'活动地址必填'
					},
					stringLength:{
						max:50,
						message:'地址最多50个字符'
					}
				}
			},
			activestarttime:{
				validators:{
					notEmpty:{
						message:'活动开始时间必选'
					}
				}
			},
			activeendtime:{
				validators:{
					notEmpty:{
						message:'活动结束时间必选'
					}
				}
			},
			activenum:{
				validators:{
					notEmpty:{
						message:'活动人数必填'
					},
					regexp:{
						message:'活动人数须填数字',
						regexp:/^[0-9]*[1-9][0-9]*$/
						
					}
				}
			},
			activekeyword:{
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
			},
			activeintroduce:{
				validators:{
					notEmpty:{
						message:'活动介绍必填'
					},
					stringLength:{
						max:1000,
						message:'活动介绍最多1000个字符'
					}
				}
			},
			activecomm:{
				validators:{
					notEmpty:{
						message:'注意事项必填'
					},
					stringLength:{
						max:500,
						message:'活动介绍最多500个字符'
					}
				}
			},
			/* img:{
				validators:{
					notEmpty:{
						message:'图片必选'
					}
				}
			}, */
			studioid:{
				validators:{
					callback:{
						message:'关联场馆必选',
						callback:function(value){
							if(value == -1){
								return false;
							}else{
								return true;
							}
						}
					}
				}
			},
			studiocost:{
				validators:{
					notEmpty:{
						message:'场馆成本价必填'
					},
					regexp:{
						message:'请正确填写成本价',
						regexp:/^\d+(\.\d{1,2})?$/
					}
				}
			},
			coachids:{
				validators:{
					callback:{
						message:'关联教练必选',
						callback:function(value){
							if(value == -1){
								return false;
							}else{
								return true;
							}
						}
					}
				}
			},
			coachcosts:{
				validators:{
					notEmpty:{
						message:'教练成本必填'
					},
					regexp:{
						message:'教练成本价须填数字',
						regexp:/^\d+(\.\d{1,2})?$/
					}
				}
			},
			activeprice:{
				validators:{
					notEmpty:{
						message:'活动费用必填'
					},
					regexp:{
						message:'请正确填写活动费用',
						regexp:/^\d+(\.\d{1,2})?$/
					}
			
				}
			},
			activesubnum:{
				validators:{
					notEmpty:{
						message:'企业卡次数必填'
					},
					regexp:{
						message:'企业卡次数必填数字',
						regexp:/^[0-9]*[1-9][0-9]*$/
						
					}
				}
			} 
		}
	});
	  
});

//省change事件
function loadCity(obj){
	var proid = $(obj).val();
	var value = $("#province").val();
	var t = new Date().valueOf();
	//加载市
	$.ajax({
		url:'<%=path%>/yundongjia/getcitybypro',
		type:'post',
		dataType:'JSON',
		data:{
			_time:t,
			proCode:proid
		},
		success:function(data){
			$("#city").html("");
			$("#city").append("<option value='-1'>市</option>");
			$("#city").append($("#cityTmpl").tmpl(data));
		}
	});
}
//市change事件
function loadArea(obj){
	var value = $(obj).val();
	var t = new Date().valueOf();
	//加载区
	$.ajax({
		url:'<%=path%>/yundongjia/getareabycity',
		type:'post',
		dataType:'JSON',
		data:{
			_time:t,
			cityCode:value
		},
		success:function(data){
			$("#area").html("");
			$("#area").append("<option value='-1'>区</option>");
			$("#area").append($("#cityTmpl").tmpl(data));
		}
	});
}

//输入地址设置坐标
function changeAddress(obj){
	var value = $(obj).val();
	// 创建地址解析器实例
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上,并调整地图视野
	myGeo.getPoint(value, function(point){
		if (point) {
			map.centerAndZoom(point, 16);
			map.addOverlay(null);
			map.addOverlay(new BMap.Marker(point));//红图标
			
			$("#lng").val(point.lng);
			$("#lat").val(point.lat);
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "北京市");
}
</script>
</body>
</html>
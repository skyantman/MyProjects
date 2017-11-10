<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<title>添加工作人员</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/clock/bootstrap-clockpicker.min.css">
 <script type="text/javascript" src="<%=path %>/static/css/clock/bootstrap-clockpicker.min.js"></script>
<script src="<%=path%>/static/css/bootstrap/js/bootstrap-datetimepicker.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$('.clockpicker').clockpicker().find('input').change(function(){
	//console.log(this.value);
	var $_li = $(this).parent().parent();
	setFormHiddenVal($_li);
});
</script>
</head>
<body>
	<div class="main-content" >
		 <div class="page-header">
		当前位置：<a href="javascript:void(0);"> 新建场馆 </a>
	</div>
		 
		<div id="stuFormDiv">
			 <form id="formInfo" name="form1" enctype=”multipart/form-data”   onsubmit="return false;"  method="post">
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							场馆名称：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<input id="studioname" name="studioname" value=""  class="form-control"  placeholder="请输入场馆名称">
						</div>  			
						<label class="xing">*</label>  			
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">场馆类型：</div>
						<div class="col-md-6 padding0L form-group">
							<select id="type" name="type"
								class="form-control btn btn-default">
								<option value="1" selected="selected">工作室</option>
								<option value="2">健身房</option>
								<option value="3">游泳</option>
								<option value="4">羽毛球</option>
								<option value="5">高尔夫</option>
								<option value="6">篮球</option>
								<option value="7">网球</option>
								<option value="8">足球</option>
								<option value="9">台球</option>
								<option value="10">保龄球</option>
								<option value="11">瑜伽</option>
								<option value="12">舞蹈</option>
								<option value="13">马术</option>
								<option value="14">滑雪</option>
								<option value="15">滑冰</option>
								<option value="16">练习场</option>
								<option value="17">智能场馆</option>
							</select>
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L padding5T">所在城市：</div>
						<div class="col-md-2 padding0L form-group">
							<select id="province" name="province"
								class="form-control btn btn-default">
								<option value="-1">省</option>
								<c:forEach items="${listPro}" var="pro">
									<option value="${pro.code}">${pro.name}</option>
								</c:forEach>

							</select>
						</div>
						<div class="col-md-2 padding0L form-group">
							<select id="city" name="city"
								class="form-control btn btn-default">
								<option value="-1">市</option>

							</select>
						</div>
						<div class="col-md-2 padding0L form-group">
							<select id="area" name="regionsid"
								class="form-control btn btn-default">
								<option value="-1">区</option>

							</select>
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							场馆地址：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<input type="text" value="" id="studioaddr" name="studioaddr" class="form-control"  placeholder="请输入场馆地址" onchange="changeAddress(this);">
						</div>  	
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							营业时间：
						</div>
						<div id="li_mon" class="clearfix col-md-3 padding0L form-group"  to="studioMon" toCon="mon">
		                        <div class="input-group clockpicker">
		                            <input type="text" id="starttime" name="starttime"  class="form-control openS" placeholder="开店时间"/>
		                            <span class="input-group-addon">
		                                <span class="glyphicon glyphicon-time"></span>
		                            </span>
		                        </div>
		               </div>
						<div id="li_mon" class="clearfix col-md-3 padding0L form-group" to="studioMon" toCon="mon">
		                        <div class="input-group clockpicker">
		                            <input type="text" id="endtime" name="endtime" class="form-control openS"  placeholder="闭店时间"/>
		                            <span class="input-group-addon">
		                                <span class="glyphicon glyphicon-time"></span>
		                            </span>
		                        </div>
		               </div>
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							场馆电话：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<input type="text" id="studiotel" value="" name="studiotel" class="form-control"  placeholder="固话或手机--固话请携带区号">
						</div>  	
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							关键字：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<input type="text" id="keyword" value="" name="keyword" class="form-control"  placeholder="关键字以英文逗号区分">
						</div>  	
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							场馆介绍：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<textarea id="studiointroduce" name="studiointroduce" class="form-control" rows="2"></textarea> 
						</div>  	
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							注意事项：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<textarea id="comm" name="comm" class="form-control" rows="2"></textarea> 
						</div>  	
						<label class="xing">*</label>  
					</div>
			
				<div class="col-md-12"
					style="width: 630px; height: 390px; border: 1px solid gray;">
					<div class="col-md-2 padding0L padding5T">地图定位：</div>

					<div id="container" class="padding0L form-group"
						style="position: absolute; overflow: hidden; margin-top: 30px; width: 90%; height: 85%; top: 50;">

					</div>
				</div>
				<div class="col-md-12" style="margin-top: 1%;">
				<div class="col-md-1 padding0L padding5T">经度：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="lng" value="" name="lng" readonly="readonly"
						class="form-control" placeholder="">
						
				</div>
				
				<div class="col-md-1 padding0L padding5T">维度：</div>
				<div class="col-md-2 padding0L form-group">
					 <input id="lat" value="" name="lat" readonly="readonly"
						class="form-control" placeholder="">
				</div>
			</div>
			
			<div class="col-md-12">
						<div class="col-md-1 padding0L">
							场馆主相册：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<div>
								<input id="file0" type="file" 
								name="img"  value="上传"   
								accept="image/gif,image/jpeg,image/png" 
								 onchange="imgview('imgsOne','file0',1);"/>
							</div>
						 	<div class="col-md-12"  id="imgsOne">
						 			
							</div>
						</div>  	
						<label class="xing">*</label>  
					</div>
			
				<div class="col-md-12">
						<div class="col-md-1 padding0L">
							场馆副相册：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<div>
								<input id="file1" type="file" name="img"  value="上传"   
								accept="image/gif,image/jpeg,image/png"  
								multiple="multiple" onchange="imgview('imgs','file1');"/>
							   <span style="color:red;">最多可上传4张图</span>
							</div>
						 	<div class="col-md-12"  id="imgs">
						 			
							</div>
						</div>  	
						<!-- <label class="xing">*</label> -->
						<input type="button" value="清空" class="btn btn-danger" onclick="delPageImage('file1', 'imgs')">  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							服务设施：
						</div>
						<div class="col-md-6 padding0L form-group">	
							 <c:forEach items="${facs}" var="fa">
							 	<input type="checkbox" value="${fa.facilityid}" name="facilitys">${fa.facilityname}&nbsp;
							 </c:forEach>
						</div>  	 
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							场馆联系人：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<input type="text" id="supername" name="supername" value="" class="form-control"  placeholder="请输入场馆联系人">
						</div>  	
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							联系人电话：
						</div>
						<div class="col-md-6 padding0L form-group">	
							<input type="text" id="supertel" value="" name="supertel" class="form-control"  placeholder="固话或手机--固话请携带区号">
						</div>  	
						<label class="xing">*</label>  
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							取消限制：
						</div>
						<div class="col-md-6 padding0L form-group">	
							 <select id="canclelimit" name="canclelimit"
						class="form-control btn btn-default">
						<option value="0" selected="selected">不限制</option>
						<option value="1">12小时</option>
						<option value="2">24小时</option>
						<option value="3">36小时</option>
						<option value="4">48小时</option>
						<option value="5">72小时</option>
					</select>
						</div>  	
						<label class="xing">*</label>  
					</div>
					
					
					
						
					<div class="col-md-8">
						<div class="col-md-offset-1 col-md-1">
			  				<input type="reset" class="btn btn-default bcColor"  value="重置">
			  			</div>
					  	<div class="form-group col-md-offset-1 col-md-1">
			  				<input onclick="subForm();" id="inpsub" type="button" class="btn btn-default bcColor"  value="提交">
			  			</div>
			  		</div>
			</form>
		</div>	
		
		<!-- 价格div -->
		<div id="priceDiv" style="display: none;">
			<input type="hidden" id="studioId" value="" name="">
			<div class="col-md-12">
				<div class="col-md-1 padding0L">起始时间：</div>
				<div id="openTime" class="col-md-6 padding0L form-group">
					
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 padding0L">价格：</div>
				<div class="col-md-4 padding0L form-group">
					<input type="text" id="stuPrice" value="" name="stuPrice" class="form-control"
						placeholder="请输入场馆价格">
				</div>
				<label class="xing">*</label>
			</div>
			<div class="col-md-8">
				 
				<div class="form-group col-md-offset-1 col-md-1">
					<input onclick="priceSubForm();" id="inpsub" type="button"
						class="btn btn-default bcColor" value="完成">
				</div>
			</div>
		</div>
		
	</div>
	<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
	<script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
	<%-- <script src="<%=path%>/static/js/gym/indexLeft.js" type="text/javascript" charset="utf-8"></script> --%>
	<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
	<script src="<%=path%>/static/js/param.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=path%>/static/js/region.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="<%=path %>/static/js/imgView.js"></script>
	<!-- 市模板 -->
	<script type="text/x-javascript-tmpl" id="cityTmpl">
		<option value="{{= code}}">{{= name}}</option>
	</script>
	<script type="text/javascript">	
	var map;
	var marker;
	function init() {
		map = new BMap.Map("container");            // 创建Map实例
		//var point = new BMap.Point(116.404, 39.915); // 创建点坐标
		var point = new BMap.Point(116.404, 39.915);
		//map.centerAndZoom("北京",12);
		map.centerAndZoom(point,12);                 
		
		marker = new BMap.Marker(new BMap.Point(116.404, 39.915)); // 创建点
		map.addOverlay(marker);
		map.enableScrollWheelZoom();                 //启用滚轮放大缩小
		marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
		
		var geoc = new BMap.Geocoder();
		//点击地图获取经纬度
		map.addEventListener("click",function(e){
			//先把点移除掉
			map.removeOverlay(marker);//移除点
			
			
			//map.addOverlay(null);//移除点
			marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat)); // 创建点
			
			map.addOverlay(marker);
			marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
			$("#lng").val(e.point.lng);
			$("#lat").val(e.point.lat);
			
			var pt=e.point;
			geoc.getLocation(pt,function(rs){
				var addComp = rs.addressComponents;
				var address = addComp.province +  addComp.city +  addComp.district + addComp.street + addComp.streetNumber;
				$("#studioaddr").val(address);
			});
			
		});
	}

		//验证表单
		$(function(){
			init();//初始化地图
			$('#formInfo').bootstrapValidator({
				fields : {
			studioname:{
				validators:{
					notEmpty:{
						message:'场馆名称必填'
					}
				}
			},
			province:{
							validators:{
								callback:{
									message:'请选择省',
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
									message:'请选择市',
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
									message:'请选择区',
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
						studioaddr:{
							validators:{
								notEmpty:{
									message:'场馆地址必填'
								}
							}
						},
						studiotel:{
							validators:{
								 notEmpty:{
								    message:'场馆电话必填'
								 },
							     regexp:{
								   message:'请输入手机号或固话',
								   regexp:/^((0\d{2,4}-\d{7,8})|(\d{11}))$/
							      }
								 /* ,
								callback:{
									message:'手机号码已存在',
									callback:function(value){
										var res = validMobilePhone(value, 1);
										
										return res;
									}
								} */
								
								
								
							}
						},
						studiointroduce:{
							validators:{
								notEmpty:{
									message:'场馆介绍必填'
								}
							}
						},
						comm:{
							validators:{
								notEmpty:{
									message:'注意事项必填'
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
						supername:{
							validators:{
								notEmpty:{
									message:'场馆联系人必填'
								}
							}
						},
						supertel:{
								validators:{
									notEmpty:{
										message:'联系人手机号码必填'
									},
									regexp:{
										message:'请输入正确手机号或固话',
										regexp:/^((0\d{2,4}-\d{7,8})|(\d{11}))$/
									}
									/*一个联系人电话可以有多个场馆 ,
									callback:{
										message:'手机号码已存在',
										callback:function(value,validator){
											var res = validMobilePhone(value, 1);
											return res;
										}
									} */
								} 
						}, 
						facilitys:{
							validators:{
								notEmpty:{
									message:'服务设施必选'
								}
							}
						},
						keyword:{
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
						
						
				  }
			});
		});
		
		//提交查询
		function subForm(){
			/*手动验证表单，当是普通按钮时。*/  
			$('#formInfo').data('bootstrapValidator').validate();  
	        if(!$('#formInfo').data('bootstrapValidator').isValid()){ 
	            return ;  
	        }
			//获取表单信息
			var data = new FormData($('#formInfo')[0]);
			$.ajax({
				url : "<%=path%>/yundongjia/savestudio",
				type: 'POST',  
	            data: data,
	            dataType: 'JSON',  
	            async : false,
	   			cache: false,  
	            processData: false, 
	            contentType: false, 
				success : function(data){
					 if(data.id > 0){
						 $("#studioId").val(data.id);//主键
						 $("#openTime").html(data.opentime);
						 $("#stuFormDiv").hide();
						 $("#priceDiv").show();
					 }
				}
			});		
		}
		//价格提交
		function priceSubForm(){
			var price = $("#stuPrice").val();
			var id = $("#studioId").val();
			var t=new Date().valueOf();
			var reg = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
			
			if(!reg.test(price)){
				alert("请正确输入场馆价格");
				return false;
			}else{
				//修改场馆价格
				$.ajax({
					url:'<%=path%>/yundongjia/updatestudioprice',
					type:'post',
					dataType:'json',
					data:{
						studioId:id,
						price:price,
						_time:t
					},
					success:function(data){
						if(data.result > 0){
							alert("保存成功");
							var t= new Date().valueOf();
							$(".index-right").load('<%=path%>/yundongjia/addstudio');
						}
					}
				});
			}
		}
		
		//输入地址设置坐标
		function changeAddress(obj){
			var value = $(obj).val();
			// 创建地址解析器实例
			var myGeo = new BMap.Geocoder();
			// 将地址解析结果显示在地图上,并调整地图视野
			myGeo.getPoint(value, function(point){
				if (point) {
					map.centerAndZoom(point, 12);
					map.removeOverlay(marker);//移除点
					
					marker = new BMap.Marker(point);
					
					map.addOverlay(marker);//红图标
					
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
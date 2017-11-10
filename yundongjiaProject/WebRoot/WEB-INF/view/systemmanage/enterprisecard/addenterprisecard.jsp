<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8"></meta>
<title>新增企业卡类型</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
<script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	//返回会员卡类页面
	function ret(){
		var mainContent = $(".index-right");
		mainContent.load('<%=path%>/yundongjia/enterprisecardlist')
	}
	//验证表单
	$(function(){
		$('#formInfo').bootstrapValidator({
			fields : {
				cardtypename : {
					validators: {
						notEmpty : {
							message : '卡名称不能为空'
						},
						stringLength: {
			                 min:0,
			                 max: 50,
			                 message: '卡名称长度必须在0到50之间'
			             },
					}
				},
			amount : {
				validators: {
					notEmpty : {
						message : '金额数不能为空'
					},
					regexp: {
		                 regexp: /^(([0-9]|([1-9][0-9]{0,9}))((\.[0-9]{1,2})?))$/,
		                 message: '请输入正确的金额格式'
		             },
				}
			},
			sportscount : {
		    	 validators: {
		    		 notEmpty : {
							message : '运动次数不可以为空'
					},
		    		 regexp: {
		                 regexp: /^\d{0,6}$/,
		                 message: '请输入正确格式的运动次数'
		             },
		    	 }
		     },
		     stockNum : {
		    	 validators: {
		    		 notEmpty : {
							message : '库存数不可以为空'
					},
		    		 regexp: {
		                 regexp: /^\d{0,6}$/,
		                 message: '请输入正确格式的库存数'
		             },
		    	 }
		     },
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
        var b = false;
        for(var i = 0; i < $("input[name='regions_id']").length; i++){
        	if($("input[name='regions_id']").eq(i).is(":checked")){
        		b = true;
        	}
        }
        if(!b){
        	alert("请选择覆盖城市！");
        	return;
        }
		//获取表单信息
		var data = new FormData($('#formInfo')[0]);
		$.ajax({
			url : "<%=path%>/yundongjia/insertEnterpriseCardType",
			type: 'POST',  
            data: data,
            dataType: 'JSON',  
            async : false,
   			cache: false,  
            processData: false, 
            contentType: false, 
			success : function(data){
				if(data.result){
					var maincontent = $('.index-right');
					maincontent.load('<%=path%>/yundongjia/enterpriseCardTypeDetail?cardid=' + data.id);
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		});		
	}
	
	function inputNum(obj){
		if($(obj).is(":checked")){
			$("input[name='stockNum']").removeAttr("disabled");
		}else{
			$("input[name='stockNum']").attr("disabled" , "disabled");
		}
	}
	
	function inNum(obj){
		if($(obj).is(":checked")){
			$("input[name='stockNum']").attr("disabled" , "disabled");
		}else{
			$("input[name='stockNum']").removeAttr("disabled");
		}
	}
	function shohi(obj){
		if($(obj).is(":checked")){
			$("#soh").hide();
		}else{
			$("#soh").show();
		}
	}
</script>
</head>
<body>
	<div class="main-content" >
		<div class="page-header">
			当前位置：
			<a href="javascript:void(0)" status="0" >新增企业卡类型</a>
		</div>
		<div>
			 <form id="formInfo" name="form1"   onsubmit="return false;"  method="post">
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							卡名称：
						</div>
						<div class="col-md-3 padding0L form-group">	
							<input name="cardtypename"  class="form-control"  placeholder="请输入卡名称">
						</div>  			
						<label class="xing">*</label>  			
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							卡折扣：
						</div>
						<div class="col-md-3 padding0L form-group">
							<select name="carddiscount" class="form-control btn btn-default">
								<option value="9">9折</option>
								<option value="8.5">8.5折</option>
								<option value="8" selected="selected">8折</option>
								<option value="7.5">7.5折</option>
							</select>
						</div>	
						<label class="xing">*</label>
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							有效期：
						</div>
						<div class="col-md-3 padding0L form-group">	
							<select name="validdate" class="form-control  btn btn-default">
								<option value="30" selected="selected">30天</option>
								<option value="90">90天</option>
								<option value="180">180天</option>
								<option value="360">360天</option>
							</select>
						</div>  
						<label class="xing">*</label>  	
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							库存：
						</div>
						<div class="col-md-3 padding0L form-group">	
							<div class="col-md-6 padding0L ">
									<input checked="checked" type="radio" name="stock"  value="-1" onchange="inNum(this);">系统生成
									<input type="radio" name="stock"  value="1"  style="margin-left: 15px;" onchange="inputNum(this);">							
							</div>
							<div class="col-md-6 padding0L" style="margin-left: -35px;">
									<input disabled="disabled" name="stockNum"  class="form-control"   placeholder="库存数"  style="max-width: 100px;margin-left: 15px">													
							</div>
						</div>  			
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							覆盖城市：
						</div>
						<div class="col-md-10 padding0L form-group">	
								<div class="col-md-1" >
									<input type="checkbox"  name="regions_id"  value="-1"" onclick="shohi(this);">全部
								</div>
								<div id="soh" class="col-md-10 padding0L">
									<c:forEach items="${city}" var="c" varStatus="i">
											<input type="checkbox"  name="regions_id"  value="${c.id}"  style="margin-left: 10px;">${c.name }
									</c:forEach>
								</div>
						</div>  	
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							金额(元)：
						</div>
						<div class="col-md-3 padding0L form-group">	
							<input name="amount"  class="form-control"  placeholder="请输入金额数">
						</div>  			
						<label class="xing">*</label>  			
					</div>
					<div class="col-md-12">
						<div class="col-md-1 padding0L">
							运动次数：
						</div>
						<div class="col-md-3 padding0L form-group">	
							<input name="sportscount"  class="form-control"  placeholder="请输入运动次数">
						</div>  			
						<label class="xing">*</label>  			
					</div>
					<div class="col-md-8">
						<div class="col-md-offset-1 col-md-1">
			  				<input type="reset" class="btn btn-default bcColor"  value="取消" onclick="ret();">
			  			</div>
					  	<div class="form-group col-md-offset-1 col-md-1">
			  				<input onclick="subForm();" id="inpsub" type="button" class="btn btn-default bcColor"  value="提交">
			  			</div>
			  		</div>
			</form>
		</div>	
	</div>
</body>
</html>
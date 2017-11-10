<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结算列表 历史记录</title>
</head>
<body>
<div class="page-header">
	当前位置：<a href="javascript:void(0);">结算列表 </a>
</div>
<div class="main-content-inquire" >
   <div class="main-content-item" style="padding: 0px;">
	  <table class="table" style="width: 80%;" rules="cols" frame="box">
	  	<thead>
	  		<tr>
	  			<th>结算总金额</th>
	  			<th>已结算金额</th>
	  			<th>待结算金额</th>
	  			<th>需审批订单数</th>
	  			<th>今日新增订单数</th>
	  		</tr>
	  	</thead>
	  	<tbody class="font-size-weight">
	  		<tr>
	  			<td></td>
	  			<td></td>
	  			<td></td>
	  			<td></td>
	  			<td></td>
	  		</tr>
	  	</tbody>
	  </table>
   </div>


	<div class="col-md-12 padding0L" style="padding-top: 1%;">
	   <form id="searchform" name="searchform" onsubmit="return false;"  method="post">
				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">结算日期：</div>
					<div class="form-group col-md-2 padding0L">
						<input id="startTime" name="startTime" size="16"
							readonly="readonly" type="text"
							onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="开始日期" />

					</div>


					<div class="form-group col-md-2 padding0L">
						<input id="endTime" name="endTime" size="16"
							readonly="readonly" type="text"
							onfocus="WdatePicker({readOnly:true,dateFmt: 'yyyy-MM-dd'})"
							value="" class="form_datetime form-control" placeholder="结束日期" />

					</div>
				</div>

				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">供应商名称：</div>
					<div class="form-group col-md-4 padding0L">
						<input placeholder="请输入供应商名称" class="form-control" type="text"
							id="supplierName" name="supplierName" />
					</div>
				</div>

				<div class="col-md-12 padding0L">
					<div class="form-group col-md-2 padding0L">商品名称：</div>
					<div class="form-group col-md-4 padding0L">
						<input placeholder="请输入场馆、教练、商品名称" class="form-control" type="text"
							id="contextName" name="contextName" />
					</div>
				</div>
				<div class="col-md-12 padding0L">
			   <div class="form-group col-md-2 padding0L">结算状态:</div>
					<div class="form-group col-md-4 padding0L">
						<select id="orderStatus" name="orderStatus" class="form-control btn btn-default">
							<option value="-1">全部</option>
							<option value="">结算中</option>
							<option value="">已结算</option>
							<option value="">已取消</option>
						</select>
					</div>
				</div>
				<div class="col-md-12 padding0L">
					<div class="col-md-6">
					  <input type="hidden" name="pageNum" value="1">
					  
					  <button type="button"
					class="btn btn-default col-md-offset-8 col-md-2 bcColor" onclick="searchForm(1,false);">搜索</button>
					</div>
				  <!--  <div class="col-md-6">
				     <button type="button"
					class="btn btn-default col-md-offset-10 col-md-3 bcColor" >导出Excel</button>
				   </div> -->
					
					 
				</div>
			</form>
	</div>
	<div class="main-content-item">
		<table class="table" rules="cols" frame="box">
			<thead>
				<tr>
					<!-- <th>结算订单ID</th> -->
					<th>结算金额(元)</th>
					<th>供应商名称</th>
					<th>订单ID</th>
					<th>商品名称</th>
					<th>结算日期</th>
					<th>订单状态</th>
					<th>结算模式</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="cOrderTbody">
				<c:forEach items="${os.list }" var="o">
				  <!-- 周期模式--》除了已完成的状态 不显示数据 -->
				  
				  <c:if test="${o.clearingType == 0}"><!-- 预存 -->
				  
				  
				  <tr>
					<td>${o.price }</td>
					<td>${o.supplierName }</td>
					<td>${o.orderNum }</td>
					<td>${o.name }</td>
					<td>${o.retreatDate }</td>
					<td>
					<c:if test="${o.clearingType == 0}"><!-- 预付模式 -->
						 <c:if test="${o.payStatus == 2}">结算中</c:if>
					     <c:if test="${o.payStatus == 5 || o.payStatus == 6 }">已结算</c:if>
					</c:if>
					
					
					<c:if test="${o.clearingType == 1}"><!-- 周期模式 -->
						<c:if test="${o.payStatus  == 5 || o.payStatus == 6}">结算中</c:if>
					</c:if>
					
					
					</td>
					<td>${o.clearingTypeName}</td>
					<td>
					<a href="javascript:void(0);" onclick="detail(${o.supplierId},${o.orderTypeId},${o.id},${o.orderId });">详情</a>
					&nbsp;&nbsp;
					
					
					<c:if test="${o.clearingType == 1}"><!-- 周期结算 -->
						<!-- 且 已完成的情况才结算 -->
					    <c:if test="${o.payStatus ==5 || o.payStatus == 6}">
					      <a href="javascript:void(0);">确定结算</a>
					    </c:if>
					</c:if>
					
					
					</td>
				</tr>
				  
				  
				  
				  
				  
				  </c:if><!-- 预存判断结束 -->
				  <c:if test="${o.clearingType == 1}"><!-- 周期 -->
				      <c:if test="${o.payStatus ==5 || o.payStatus == 6}">
				<tr>
					<td>${o.price }</td>
					<td>${o.supplierName }</td>
					<td>${o.orderNum }</td>
					<td>${o.name }</td>
					<td>${o.retreatDate }</td>
					<td>
					<c:if test="${o.clearingType == 0}"><!-- 预付模式 -->
						 <c:if test="${o.payStatus == 2}">结算中</c:if>
					     <c:if test="${o.payStatus == 5 || o.payStatus == 6 }">已结算</c:if>
					</c:if>
					
					
					<c:if test="${o.clearingType == 1}"><!-- 周期模式 -->
						<c:if test="${o.payStatus  == 5 || o.payStatus == 6}">结算中</c:if>
					</c:if>
					
					
					</td>
					<td>${o.clearingTypeName}</td>
					<td>
					<a href="javascript:void(0);" onclick="detail(${o.supplierId},${o.orderTypeId},${o.id},${o.orderId });">详情</a>
					&nbsp;&nbsp;
					
					
					<c:if test="${o.clearingType == 1}"><!-- 周期结算 -->
						<!-- 且 已完成的情况才结算 -->
					    <c:if test="${o.payStatus ==5 || o.payStatus == 6}">
					      <a href="javascript:void(0);">确定结算</a>
					    </c:if>
					</c:if>
					
					
					
					</td>
				</tr>
				      
				      
				      
				      
				      
				      
				      </c:if>
				  
				  
				  
				  </c:if><!-- 周期判断结束 -->
				  
				  
				  
				  
				  
				  
				  
				  
			
				  
				  
				
				
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="main-content-footer" style="padding-bottom: 1%;">
			<div class="page" id="page">
				
			
			</div>
		</div>
</div>

<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/gym/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
<script type="text/x-javascript-tmpl" id="clearOrderTmpl">
{{if clearingType == 0}}

<tr>
 <td>{{= price}}</td>
 <td>{{= supplierName}}</td>
 <td>{{= orderNum}}</td>
 <td>{{= name}}</td>
 <td>{{= retreatDate}}</td>
 <td>
    {{if clearingType == 0}}
		{{if payStatus == 2}}
			结算中
		{{else payStatus == 5 || payStatus == 6}}
			已结算
		{{/if}}
	{{else clearingType ==1}}
		{{if payStatus == 5 || payStatus == 6}}
		        结算中
		{{/if}}
	{{/if}}
 </td>
 <td>{{= clearingTypeName}}</td>
 <td>

 </td>
</tr>




{{else clearingType == 1}}
   {{if payStatus == 5 || payStatus == 6}}
	

   




   {{/if}}

{{/if}}



<!--
<tr>
					<td>{{= price }}</td>
					<td>{{= supplierName }}</td>
					<td>{{= orderNum }}</td>
					<td>{{= name }}</td>
					<td>{{= retreatDate }}</td>
<td>

</td>
					<td>{{= clearingTypeName}}</td>
					<td>
					<a href="javascript:void(0);" onclick="detail();">详情</a>
					&nbsp;&nbsp;


<a href="javascript:void(0);">确定结算</a>
					</td>
</tr> -->
</script>
<script type="text/javascript">
	/* 详情 */
	function detail(supplierId,orderType,studioId,orderId){
		var t=new Date().valueOf();
		$(".index-right").load('<%=path%>/yundongjia/clearorderdetail',{supplierId:supplierId,orderType:orderType,studioId:studioId,orderId:orderId,_time:t});
	}
	
	function searchForm(pageNum,flag){
		if(flag){
			return false;
		}
		var data = new FormData($("#searchform")[0]);
		$.ajax({
			url:'<%=path%>/yundongjia/selectclearorderby',
			type:'post',
			dataType:'json',
			data : data,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success:function(data){
				console.log(data);
				$("#cOrderTbody").html($("#clearOrderTmpl").tmpl(data.list));
			}
		});
	}
</script>
</body>
</html>
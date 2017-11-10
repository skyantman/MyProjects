<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8"></meta>
<title>个人卡类型列表</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css" />
</head>
<body>
<div class="main-content member">
		<div class="page-header">
			当前位置：
			<a href="javascript:void(0)" status="0" >个人卡类型列表</a>
		</div>	
			<div class="main-content-item">
					<table class="table" rules="cols" frame="box">
						<thead>
							<tr>
								<th>
									卡类型ID
								</th>
								<th>
									卡类型名称
								</th>
								<th>
									折扣率
								</th>
								<th>
									金额
								</th>
								<th>
									返现金额
								</th>
								<th>
									有效期
								</th>
								<th>
									库存
								</th>
								<th>
									已激活
								</th>
								<th>
									覆盖城市
								</th>
								<th>
									状态
								</th>
								<th>
									操作
								</th>
							</tr>
						</thead>
						<tbody id="listInfo" >
							<c:forEach items="${card.list }" var="w">
								<tr>
									<td >
										<a href="javascript:void(0)" cardId ="${w.cardid }"  cardname="${w.cardtypename }" onclick="detail(this);" class=" ">${w.cardid }</a>
									</td>
									<td>
											<a href="javascript:void(0)" cardId ="${w.cardid }"  cardname="${w.cardtypename }" onclick="detail(this);" class=" ">${w.cardtypename }</a>
									</td>
									<td>
										${w.carddiscount }折
									</td>
									<td>
										${w.amount }
									</td>
									<td>
										<c:if test="${w.iscashback==0 }">0</c:if>
										<c:if test="${w.iscashback==1 }">${w.backmoney }</c:if>
									</td>
									<td>
										${w.validdate }天
									</td>
									<td>
										<c:if test="${w.stock==-1 }">系统生成</c:if>
										<c:if test="${w.stock!=-1 }">${w.stock }</c:if>
									</td>
									<td>
										${w.surplusstock }
									</td>
									<td>
										${w.regionsid }
									</td>
									<td>
										<c:if test="${w.isstop==0 }">生效</c:if>
										<c:if test="${w.isstop==1 }">禁用</c:if>
									</td>
									<td>
										<a href="javascript:void(0)" cardId ="${w.cardid }"  cardname="${w.cardtypename }" onclick="detail(this);" class=" ">详情</a>
										<a href="javascript:void(0)" cardId ="${w.cardid }"  cardname="${w.cardtypename }" onclick="childCard(this);" class="">属卡</a>
										<c:if test="${w.isstop==1}">
											<a href="javascript:void(0)" cardId ="${w.cardid }"  cardname="${w.cardtypename }"   class=""  data-toggle="modal"  data-target=".bs-example-modal-sm"  onclick="start(this)">启用</a>
										</c:if>
										 <c:if test="${w.isstop==0}">
											<a href="javascript:void(0)" cardId ="${w.cardid }" cardname="${w.cardtypename }"   class=""  data-toggle="modal"  data-target=".bs-example-modal-sm"  onclick="stop(this)" >禁用</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
			<div class="main-content-footer">
				<div class="page" id="page">
						<a onclick="pageListInfo(1);" <c:if test="${card.pageNum == 1 }">class="active"</c:if>>
						&lt;&lt;最前页</a>
							<div class="page-list">
								<c:forEach begin="1" end="${card.pages }" varStatus="i">
									<c:if test="${i.index<card.pageNum && i.index>card.pageNum-5}">
										<span onclick="pageListInfo(${i.index });">${i.index }</span>
									</c:if>
									<c:if test="${card.pageNum == i.index }">
										<span onclick="pageListInfo(${i.index });" class="active">${i.index }</span>
									</c:if> 
									<c:if test="${i.index>card.pageNum && i.index<card.pageNum+5}">
										<span onclick="pageListInfo(${i.index });">${i.index }</span>
									</c:if>
								</c:forEach>
							</div>
					<a onclick="pageListInfo(${card.pages });" <c:if test="${card.pageNum == card.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
				</div>
			</div>
		</div>
	</div>
	
	<div id="modal-container0" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
			<input type="hidden" id="enterid" value="">
			<input type="hidden" id="status" value="">
			<div class="col-md-12" style="padding-top: 8%;">
			<div class="col-md-4 padding0L padding5T">理由：</div>
			</div>
			<div class="col-md-12">
				
				<div class="col-md-10 padding0L form-group">
					<textarea class="form-control" id="comm" name="comm" rows="6"
						cols="60"></textarea>
				</div>
			</div>
			<input type="hidden"  id="status">
			<input type="hidden"  id="cardId">
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="stopOrStart();">确定</button>
			</div>
		</div>
			
     	<!-- onclick="stop(this);"  -->
    </div>
  </div>
</div>
	<%-- <shiro:hasPermission name="gym_worker:update"><div hidden="hidden" id="gym_worker_update"></div></shiro:hasPermission>
	<shiro:hasPermission name="gym_worker:del"><div hidden="hidden" id="gym_worker_del"></div></shiro:hasPermission> --%>
	<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript">
//分页跳转
function pageListInfo(page){
	var maincontent = $('.index-right');
	maincontent.load("<%=path%>/yundongjia/selfcardlist?page="+page);
}
//禁用卡类
function stop(obj){
	$("#cardId").val($(obj).attr("cardId"));
	$("#status").val("1");
}
//启用卡类
function start(obj){
	$("#cardId").val($(obj).attr("cardId"));
	$("#status").val("0");
}
//禁用启用卡类
function stopOrStart(){
	var status = $("#status").val();
	var cardId = $("#cardId").val();
	var comm = $("#comm").val();
	$.ajax({
		url : '<%=path%>/yundongjia/stopOrStart',
		data : {
			cardId : cardId,
			status : status,
			comm : comm,
			type : 1,
			time : (new Date()).valueOf()
		},
		dataType:"JSON",
		success : function(data){
			if(data.result){
				var maincontent = $('.index-right');
				maincontent.load('<%=path%>/yundongjia/selfcardlist');
				alert(data.message);
				//关闭模态框
				$("#modal-container0").hide();
				$('.modal-backdrop').attr("hidden",true);
			}else{
				alert(data.message);
			}
		}
	})
}

//点击属卡
function childCard(obj){
	var cardId = $(obj).attr("cardId");
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/selfCardTypeDetail?cardid='+cardId + '&status=1');
}

//点击详情
function detail(obj){
	var cardId = $(obj).attr("cardId");
	var maincontent = $('.index-right');
	maincontent.load('<%=path%>/yundongjia/selfCardTypeDetail?cardid='+cardId);
}
</script>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8"></meta>
<title>工作人员</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
</head>
<body>
<div class="main-content member">
			<div class="col-md-10 page-header">
				当前位置：
				<a href="javascript:void(0)" status="0" >工作人员</a>
			</div>
			<div class="col-md-2" style="margin-top: 10px;">
				<%-- <shiro:hasPermission name="gym_worker:add">		 --%>		
					<a href="javascript:void(0)" role="button"  class="btn bcColor" onclick="addWorker();">添加工作人员</a>
				<%-- </shiro:hasPermission>	 --%>
			</div>
			<div class="main-content-inquire">
				<div class="col-md-12 padding0L">
					<div class="col-md-6 padding0L">
						<div class="form-group col-md-9 padding0L">
							<input placeholder="请输入手机号、工作人员姓名" class="form-control" type="text" id="search"/>
						</div>
						<button type="button" class="glyphicon glyphicon-search btn btn-default col-md-offset-1 col-md-2 bcColor" onclick="search(1);">查询</button>
					</div>
				</div>	
			</div>
			<div class="main-content-item">
					<table class="table" rules="cols" frame="box">
						<thead>
							<tr>
								<th>
									姓名
								</th>
								<th>
									手机号
								</th>
								<th>
									角色
								</th>
								<th>
									操作
								</th>
							</tr>
						</thead>
						<tbody id="listInfo" >
							<c:forEach items="${workers.list }" var="w">
								<tr>
									<td>
										${w.backusername }
									</td>
									<td>
										${w.backusermobliephone }
									</td>
									<td>
										${w.backuserpwd }
									</td>
									<td>
										<a href="javascript:void(0)" userId ="${w.backuserid }" onclick="update(this);" class=" gym_worker_update">修改</a>&nbsp;
										<a href="javascript:void(0)" userId ="${w.backuserid }" onclick="del(this);" class=" gym_worker_del">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
			<div class="main-content-footer">
				<div class="page" id="page">
				</div>
			</div>
		</div>
	</div>
	<%-- <shiro:hasPermission name="gym_worker:update"><div hidden="hidden" id="gym_worker_update"></div></shiro:hasPermission>
	<shiro:hasPermission name="gym_worker:del"><div hidden="hidden" id="gym_worker_del"></div></shiro:hasPermission> --%>
	<script src="<%=path%>/static/js/gym/memberCard.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<script type="text/javascript">

	$(function(){
		var pages=${workers.pages};
		var pageNum=${workers.pageNum};
		var pi={"pages":pages,"pageNum":pageNum};
		paging("page", 'pageListInfo', pi);
		/* authShowOrHid(); */
	}); 
	//跳转到会员界面
	function addWorker(){
		var maincontent = $('.index-right');
		maincontent.load('<%=path%>/yundongjia/addWorker');
	}
	
	//根据手机号 、姓名查询工作人员信息
	function search(page){
		var searchInfo = $('#search').val();
		var data = {
				searchInfo : searchInfo,
				page : page,
				time : (new Date()).valueOf()
				};
		$.ajax({
			url : '<%=path%>/yundongjia/selectBUByphoneOrName',
			data : data,
			type : 'post',
			dataType : "json",
			success :function(data){
				listData(data.list);
				paging("page", 'search', data);
			}
		});
	}
	
	
	//点击修改触发，修改会员信息
	function update(obj){
		var maincontent = $('.index-right');
		var userId = $(obj).attr("userId");
		maincontent.load('<%=path%>/yundongjia/workerUpdate?userId=' + userId);
	}
	
	//点击删除触发，逻辑删除会员信息
	function del(obj){
		var userId = $(obj).attr("userId");
		var result = confirm("确定要删除该工作人员信息？")
		if(result){
			$.ajax({
				url : "<%=path%>/yundongjia/deleteWorker",
				data : {
					userId : userId,
					time : (new Date()).valueOf()
				},
				dataType : "JSON",
				success : function (data){
					if(data.result){
						var maincontent = $('.index-right');
						maincontent.load('<%=path%>/yundongjia/worker');
						alert(data.message);
					}else{
						alert(data.message);
					}
				}
			});
		}
	}
	
	//分页跳转
	function pageListInfo(page){
		$.ajax({
			url : '<%=path%>/yundongjia/workerNext',
			data : {
				page : page,
				time : (new Date()).valueOf()				
			},
			type : 'post',
			dataType : "json",
			success :function(data){
				listData(data.list);
				paging("page", 'pageListInfo', data);
			}
		});
	}
	
	 //封装数据填写
	function listData(data){
		$('#listInfo').html('');
		for(var i = 0; i < data.length; i++){
			$('#listInfo').append("<tr>"+
				"<td>"+ data[i].backusername +"</td>"+
				"<td>"+ data[i].backusermobliephone +"</td>"+
				"<td>"+ data[i].backuserpwd +"</td>"+
				"<td>"+
					"<a href='javascript:void(0)' userId ='" + data[i].backuserid + "' onclick='update(this);' class='btn gym_worker_update'>修改</a>&nbsp;"+
					"<a href='javascript:void(0)' userId ='" + data[i].backuserid + "' onclick='del(this);' class='btn gym_worker_del'>删除</a>"+
				"</td>"+
				"</tr>");
		}
		/* authShowOrHid(); */
	 }
	/* function authShowOrHid(){
		if($("#gym_worker_update").length == 0){
			$(".gym_worker_update").remove();
		}
		if($("#gym_worker_del").length == 0){
			$(".gym_worker_del").remove();
		}
	} */
</script>
</body>
</html>
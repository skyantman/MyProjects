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
<title>企业管理-用户详情</title>
</head>
<body>
	<div class="main-content" id="">
		<div class="page-header">
			当前位置：
			<a href="javascript:back(0);">企业列表</a>
			  &nbsp; &gt; &nbsp;
			  <a href="javascript:back(1);">企业详情</a>  &nbsp; &gt; &nbsp; <a href="javascript:void();">
				用户详情
			</a>
		</div>
		<!-- <button type="button" class="btn btn-default col-md-8 bcColor" onclick="back();">返回</button> -->
		</div>
		<div class="main-content-inquire">
				<div class="main-content-item" style="padding-left: 30px">
					<table>
						<tr>
							<td>
								<div class="form-group">
									<label for="">微信公众号：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">${user.unionid}</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="">手机号码：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">${user.mobilePhoneNo }</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="">状态：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">
									<c:if test="${user.isValid == 0}">有效</c:if>
									<c:if test="${user.isValid == 1}">禁用</c:if>
									</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="">昵称：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">${user.nickName }</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="">出生日期：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">${user.bornDate }</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="">性别：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">
									<c:if test="${user.gender ==0 }">男</c:if>
									<c:if test="${user.gender ==1 }">女</c:if>
									</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="">红包余额：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">${user.redAmount }</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label for="">部门：</label>
								</div>
							</td>
							<td>
								<div class="form-group">
									<label for="">${user.department}</label>
								</div>
							</td>
						</tr>
					</table>

				</div>

		</div>


<script type="text/javascript">

function back(num){
	var url="<%=path%>";
	var t=new Date().valueOf();
	if(0 == num){
		url="<%=path%>/yundongjia/listenterprise?_time="+t;
	}else if(1 == num){
		
		var eId = ${enterId};
		var cId=${cardId};
		var url='<%=path%>/yundongjia/detailenterprise?id='+eId+'&tab=3&cardId='+cId+'&_t='+t;
	}
	tobackDemo(url);
}
</script>
</body>
</html>
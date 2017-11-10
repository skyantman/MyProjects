<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业卡详情</title>
<style type="text/css">
.main-content{
	border:0px solid blue;
	width:100%;
}
.warp-content{
	border:0px solid red;
	width:70%;
	margin: 5% 10% 10% 10%;
}

.table-detail>tbody>tr>td:nth-child(odd) {
	border:0px solid red;
	width:20%;
	text-align: right;
}
/* 偶数行 */
.table-detail>tbody>tr>td:nth-child(even) {
		border:0px solid blue;
		padding-left: 10%;
}
 .main-content-item{
 margin-left: 10%;
 }
 /* 按钮 */
 .btn-user-defined-style{
	   background-color:#E83F14;
	   color: #ffffff;	
	   width: 50%;
	   font-size: 20px;
}
</style>
</head>
<body>
<div class="main-content">
   <div class="warp-content">
   		<div class="header">
   		<img style="display: block;width:60px;float: left;" alt="" 
   		src="<%=path%>/static/images/enterpriseImage/correct.png">
   		 <h1 style="display: block;width：100px;">已经成功激活！</h1>
   		</div>
   		<div class="main-content-item">
   		  <table class="table-detail">
   		  	<tr>
   		  	  <td>
   		  	    <div class="form-group">
					<label for="">卡折扣：</label>
				</div>
   		  	  </td>
   		  	  <td>
   		  	    <div class="form-group">
					<label for="">5.2折</label>
				</div>
   		  	  </td>
   		  	</tr>
   		  	<tr>
   		  	  <td>
   		  	   <div class="form-group">
					<label for="">所属公司：</label>
				</div>
   		  	  </td>
   		  	  <td>
   		  	    <div class="form-group">
					<label for=""></label>
				</div>
   		  	  </td>
   		  	</tr>
   		  	<tr>
   		  	  <td>
   		  	   <div class="form-group">
					<label for="">激活日期：</label>
				</div>
   		  	  </td>
   		  	  <td>
   		  	    <div class="form-group">
					<label for=""></label>
				</div>
   		  	  </td>
   		  	</tr>
   		  	<tr>
   		  	  <td>
   		  	   <div class="form-group">
					<label for="">有效期至：</label>
				</div>
   		  	  </td>
   		  	  <td>
   		  	    <div class="form-group">
					<label for=""></label>
				</div>
   		  	  </td>
   		  	</tr>
   		  	<tr>
   		  	  <td>
   		  	   <div class="form-group">
					<label for="">金额：</label>
				</div>
   		  	  </td>
   		  	  <td>
   		  	    <div class="form-group">
					<label for="">元</label>
				</div>
   		  	  </td>
   		  	</tr>
   		  	<tr>
   		  	  <td>
   		  	   <div class="form-group">
					<label for="">运动次数：</label>
				</div>
   		  	  </td>
   		  	  <td>
   		  	    <div class="form-group">
					<label for="">次</label>
				</div>
   		  	  </td>
   		  	</tr>
   		  	<tr>
   		  	  <td>
   		  	   <div class="form-group">
					<label for="">剩余次数：</label>
				</div>
   		  	  </td>
   		  	  <td>
   		  	    <div class="form-group">
					<label for="">100次<span style="color:blue;">(已使用50次)</span></label>
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
					<label for=""></label>
				</div>
   		  	  </td>
   		  	</tr>
   		  	<tr>
   		  		<td></td>
   		  		<td>
   		  		  <div class="form-group">
   		  		    <input id="" type="button" onclick="comfrim();"
						class="btn btn-user-defined-style" value="确&nbsp;&nbsp;认">
   		  		  </div>
   		  		</td>
   		  	</tr>
   		  </table>
   		</div>
   </div>
</div>
</body>
</html>
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
	<meta name='viewport' content='user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0' />
	<meta name='apple-mobile-web-app-capable' content='yes' />
	<meta name='apple-mobile-web-app-status-bar-style' content='black' />
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrap.min.css"/>
	<script src="<%=path%>/static/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<title>运动+ 分享</title>
	<style type="text/css">
		body {
			background-color: #f5f5f5;			
		}
		.background{
			padding: 0;
			margin: 0;
		}
		.background img{
			z-index:100;
			padding: 0;
			margin: 0;
			width: 100%;
		}
		.memberInfo-img img{
			width:60px;
			position: absolute;
			top: 30px;
			left: 15px;
			border-radius: 30px;
		}
		.memberInfo-V img{
			width: 15px;
		    position: absolute;
		    top: 70px;
		    left: 60px;
		}
		.memberInfo-name{
			color: #f5f5f5;
			font-size: 0.7em;
			position: absolute;
		    top: 70px;
		    left: 80px;
		}
		.sportInfo{
			width: 100%;
			position: absolute;
			top: 100px;
			text-align: center;
		}
		.sportInfo-percent{
			color: #f5f5f5;
			font-size: 1.0em;
		}
		.sportInfo-img-num img{
			width: 40px;
			padding-top: 20px;
			z-index: 999;
		}
		.sportInfo-img-foot{
			margin-top: -35px;
		}
		.sportInfo-num{
			color: #f5f5f5;
			font-size: 1.2em;
			padding-top: 15px;
		}
		.sportInfo-back{
			background-color: #062645;
			border: 0;
			color: #f5f5f5;
			font-size: 0.6em;
			padding: 5px;
		}
		.contentInfo{
			background-color: white;
			width: 95%;
			margin: -10px 10px;
			height: 20em;
		}
		.contentInfo-title{
			padding-top:10px;
			padding-left: 60px;
		}
		.yuan{
			background-color: #E83F14;
			height:12px;
			width:12px;
			border-radius:12px; 
			float: left;
			margin-top: 10px;
		}
		.contentInfo-font{
			color: #062645;
			font-size: 1.5em;
			padding-left: 20px;
		}
		.contentInfo-content{
			padding-top: 20px;
			padding-bottom: 20px;
		}
		.contentInfo-content img{
			width: 18%;
		}
		.data-title{
			color: #062645;
			font-size: 1em;
		}
		.data-data{
			color: #062645;
			font-size: 1em;
			text-align: right;
		}
		.padding0{
			padding:0;
			margin: 0;
		}
		.solid{
		    background-color: #e5e5e5;
		    border: 0;
		    height: 1px;
		    width: 69%;
		    position:absolute;
		    left: 85px;
		    bottom: 52px;
		}
	</style>
	</head>
    <body>
    	<div class="background">
  			<img alt="" src="<%=path%>/static/images/share/bj1.png" <c:if test="${info.routeNum > 10 }"> hidden="hidden"</c:if>>  	
  			<img alt="" src="<%=path%>/static/images/share/bj2.png" <c:if test="${info.routeNum <= 10 }"> hidden="hidden"</c:if>> 
    	</div>
 		<div class="memberInfo">
 			<div class="memberInfo-img">
 				<img alt="" src="http://app.goheng.com:9996/${info.memberImg }">
 			</div>
 			<div class="memberInfo-V">
 				<img alt="" src="<%=path%>/static/images/share/huiyuan.png">
 			</div>
 			<div class="memberInfo-name">
 				${info.memberName }
 			</div>
 		</div>
 		<div class="sportInfo" <c:if test="${info.routeNum > 10 }">hidden="hidden"</c:if>>
 			<div class="sportInfo-percent">
 				恭喜你击败了${info.percent }用户
 			</div>
 			<div class="sportInfo-img-num">
 				<img alt="" src="<%=path%>/static/images/share/${info.routeNum}.png">
 			</div>
 			<div class="sportInfo-img-foot">
 				<img alt="" src="<%=path%>/static/images/share/foot.png" style="width: 140px;">
 			</div>
 			<div class="sportInfo-num">
 				升至本周榜单${info.routeNum }位
 			</div>
 			<div style="padding-top: 10px;">
 				<span class="sportInfo-back">
 					共计运动时常：${info.allSportTime }min
 				</span>
 			</div>
 		</div>
 		<div class="contentInfo">
 			<div class="contentInfo-title">
 				<div class="yuan"></div>
 				<div class="contentInfo-font">本次运动：</div>
 			</div>
 			<div class="col-xs-12 contentInfo-content">
 				<img class="col-xs-3" alt="" src="<%=path%>/static/images/share/shijian.png">
 				<div class="padding0 col-xs-2 data-title">
 					时长
 				</div>
 				<div class="col-xs-7 padding0 data-data">
 					${info.thisSportTime }min
 				</div>
 			</div>
 			<div class="solid" style="bottom: 207px;"></div>
 			<div class="col-xs-12 contentInfo-content">
 				<img class="col-xs-3" alt="" src="<%=path%>/static/images/share/leixing.png">
 				<div class="padding0 col-xs-2 data-title">
 					类型
 				</div>
 				<div class="col-xs-7 padding0 data-data">
 					${info.type }
 				</div>
 			</div>
 			<div class="solid" style="bottom: 132px;"></div>
 			<div class="col-xs-12 contentInfo-content">
 				<img class="col-xs-3" alt="" src="<%=path%>/static/images/share/dingwei.png" style="width: 16%">
 				<div class="padding0 col-xs-2 data-title">
 					场馆
 				</div>
 				<div class="col-xs-7 padding0 data-data">
 					${info.name }
 				</div>
 			</div>
 			<div class="solid"></div>
 		</div>
 	</body>
</html>
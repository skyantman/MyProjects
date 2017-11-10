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
	<title>运动+ 订单分享</title>
	<style type="text/css">
		body {
			background-image: url("<%=path%>/static/images/share/orderbj.png");
			background-repeat: no-repeat;
			background-size:100%
		}
		.title-name{
			color:white;
			text-align: center;
			font-size: 24px;
			margin-top: 20px;
		}	
		.title-payStatus{
			color:white;
			font-size: 30px;
		}
		.title-money{
			color:white;
			font-size: 24px;
			padding-top: 5px;
			padding-left: 40px;
		}
		.bodyFont{
			color: #787878;
			font-size: 18px;
			line-height: 64px;
			text-align: right;
		}
		.alignL{
			text-align: left;
		}
		.alignR{
			text-align: right;
		}
		.padding0{
			padding: 0;
		}
		.solidMin{
			background-color: #efefef;
			border: 1px solid #efefef;
			height: 1px;
			width: 92%;
			margin-left: 16px;
		}
		.solid{
			background-color: #efefef;
			border: 1px solid #efefef;
			height: 10px;
			width: 100%;
		}
	</style>
	</head>
    <body>
    	<!-- title start -->
    	<div class="title-name">${orderDetail.order.orderName }</div>
    	<div class="col-xs-12 padding0" style="margin-top: 35px;">
    		<div class="col-xs-offset-1 col-xs-5 title-payStatus">${orderDetail.order.payStatus }</div>
    		<div class="col-xs-6 alignR title-money">
    			<c:if test="${!orderDetail.order.isEnterpriseCard }">
    				¥ ${orderDetail.order.realMoney }
    			</c:if>
    			<c:if test="${orderDetail.order.isEnterpriseCard }">
    				${orderDetail.order.realMoney }次
    			</c:if>
    		</div>
    	</div>
    	<!-- title end -->
    	
    	
    	
    	
    	
    	<!-- order start -->
    	<div class="col-xs-12 padding0" style="margin-top: 24px;">
    		<div class="alignL bodyFont col-xs-4" style="color: #3b3b3b;">订单金额</div>
    		<div class="alignL bodyFont col-xs-4" style="color: #e9a81e;">
    			<c:if test="${!orderDetail.order.isEnterpriseCard }">
    				¥ ${orderDetail.order.realMoney }
    			</c:if>
    			<c:if test="${orderDetail.order.isEnterpriseCard }">
    				${orderDetail.order.realMoney }次
    			</c:if>
    		</div>
    	</div>
    	<div class="col-xs-12 solidMin"></div>
    	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">优惠金额</div>
    		<div class="alignL bodyFont col-xs-4" style="color: #e9a81e;">¥ ${orderDetail.order.discountMoney }</div>
    	</div>
    	<div class="col-xs-12 solid"></div>
    	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">
    			<!-- 1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单 -->
    			<c:choose>
    				<c:when test="${orderType ==1 }">活动名称</c:when>
    				<c:when test="${orderType ==2 }">商品名称</c:when>
    				<c:when test="${orderType ==3 }">教练名称</c:when>
    				<c:when test="${orderType ==4 }">场馆名称</c:when>
    				<c:when test="${orderType ==5 }">个人卡名称</c:when>
    			</c:choose>
    		</div>
    		<div class="alignR bodyFont col-xs-8 " style="color: #3b3b3b;">${orderDetail.order.orderName }</div>
    	</div>
    	<div class="col-xs-12 solidMin"></div>
    	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">
    			<!-- 1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单 -->
    			<c:choose>
    				<c:when test="${orderType ==1 }">活动时间</c:when>
    				<c:when test="${orderType ==2 }">商品数量</c:when>
    				<c:when test="${orderType ==3 }">预定时间</c:when>
    				<c:when test="${orderType ==4 }">预定时间</c:when>
    				<c:when test="${orderType ==5 }">购卡金额</c:when>
    			</c:choose>
    		</div>
    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">
    			<c:choose>
    				<c:when test="${orderType ==2 }">${orderDetail.order.num }</c:when>
    				<c:when test="${orderType ==5 }">¥${orderDetail.order.addr }</c:when>
    				<c:otherwise>${orderDetail.order.timeSpan }</c:otherwise>
    			</c:choose>
    		</div>
    	</div>
    	<div class="col-xs-12 solidMin"></div>
    	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">
    			<!-- 1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单 -->
    			<c:choose>
    				<c:when test="${orderType ==1 }">活动地址</c:when>
    				<c:when test="${orderType ==2 }">商品参数</c:when>
    				<c:when test="${orderType ==3 }">场馆名称</c:when>
    				<c:when test="${orderType ==4 }">场馆地址</c:when>
    				<c:when test="${orderType ==5 }">卡折扣</c:when>
    			</c:choose>
    		</div>
    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">
    			<c:choose>
    				<c:when test="${orderType ==5 }">${orderDetail.order.num }</c:when>
    				<c:otherwise>${orderDetail.order.addr }</c:otherwise>
    			</c:choose>
    		</div>
    	</div>
   		<c:choose>
			<c:when test="${orderType ==1 }">
				<div class="col-xs-12 solidMin"></div>
		    	<div  class="col-xs-12 padding0">
		    		<div class="alignL bodyFont col-xs-4">人数</div>
		    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">
		    				${orderDetail.order.num }
		    		</div>
		    	</div>
			</c:when>
			<c:when test="${orderType ==5 }">
				<div class="col-xs-12 solidMin"></div>
		    	<div  class="col-xs-12 padding0">
		    		<div class="alignL bodyFont col-xs-4">卡有效期</div>
		    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">
		    				${orderDetail.order.timeSpan }
		    		</div>
		    	</div>
			</c:when>
		</c:choose>
		<div class="col-xs-12 solid"></div>
		<!-- order end -->
		
		
		<!-- memberInfo start -->
		<div  class="col-xs-12 padding0">
	   		<div class="alignL bodyFont col-xs-12" style="line-height: 54px;font-size: 20px;">预定信息</div>
	   	</div>
	   	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">用户</div>
    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">${orderDetail.order.memberName }</div>
    	</div>
    	<div class="col-xs-12 solidMin"></div>
    	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">手机</div>
    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">${orderDetail.order.phone }</div>
    	</div>
    	<div class="col-xs-12 solid"></div>
    	<!-- memberInfo end -->
    	
    	<!-- other end -->
    	<div  class="col-xs-12 padding0">
	   		<div class="alignL bodyFont col-xs-12" style="line-height: 54px;font-size: 20px;">其他信息</div>
	   	</div>
	   	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">订单编号</div>
    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">${orderDetail.order.orderNumber }</div>
    	</div>
    	<div class="col-xs-12 solidMin"></div>
    	<div  class="col-xs-12 padding0">
    		<div class="alignL bodyFont col-xs-4">预定日期</div>
    		<div class="alignR bodyFont col-xs-8" style="color: #3b3b3b;font-size: 18px;">${orderDetail.order.createDate }</div>
    	</div>
    	<div class="col-xs-12 solid"></div>
    	<!-- other end -->
    	<div class="col-xs-12 pdding0" style="margin-top: 15px;">
    		<button type="button" class="btn btn-warning col-xs-offset-1 col-xs-10" onclick="openApp('SportsAd://host')">
    			<div class="col-xs-2 alignR padding0" >
    				<img alt="" src="<%=path%>/static/images/share/ordersj.png" width="60%" >
    			</div>
    			<div class="col-xs-10 padding0">
    				<span class="col-xs-12 alignL padding0" style="font-size: 20px;color: white;" >去运动+客户端享优惠</span>
    			</div>
    		</button>
    	</div>
    	<div class="col-xs-12 pdding0" style="margin-top: 10px;margin-bottom: 20px;">
    		<button type="button" class="btn btn-danger col-xs-offset-1 col-xs-10">
    			<div class="col-xs-2 alignR padding0" >
    				<img alt="" src="<%=path%>/static/images/share/orderhb.png" width="60%" >
    			</div>
    			<div class="col-xs-10 padding0">
    				<span class="col-xs-12 alignL padding0" style="font-size: 20px;color: white;" onclick="openCoupon();">领红包,分享好友得返现</span>
    			</div>
    		</button>
    	</div>
    	<script type="text/javascript">
    	/*
    	*   @param schemaUrl 想要打开的APP的URI Scheme
    	*   @param fail      如果打开失败(手机没有安装APP)时执行的函数
    	*/
    	 function openApp(schemaUrl) {
    		 window.location="https://a.mlinks.cc/AK7f";
    	  }
    	
    	function openCoupon(){
    		window.location="http://www.goheng.com/ad/gohengpages/leagueweixin/ydjShare/index.html";
    	}
    	</script>
 	</body>
</html>
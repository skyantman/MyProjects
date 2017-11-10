<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>企业员工健康管理平台</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcommon.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymstyle.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/enterprise/font-awesome.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/enterprise/jquery-accordion-menu.css" />
    <link rel="stylesheet" href="<%=path%>/static/css/enterprise/style.css" type="text/css" media="screen"/>
    <script src="<%=path%>/static/js/enterprise/jquery-1.6.2.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/js/jquery.confirm.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/js/gym/indexLeft.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path %>/static/js/gym/pageBack.js"></script>
    <script type="text/javascript" src="<%=path %>/static/js/enterprise/jquery-accordion-menu.js"></script>
    <style type="text/css">
    		*{box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;}
			#demo-list a{
				overflow:hidden;
				text-overflow:ellipsis;
				-o-text-overflow:ellipsis;
				white-space:nowrap;
				width:100%;
				height:101px;
				font-size: 1.5em;
			}
			
    		::-webkit-scrollbar-track {
				  background-color: #b46868;
			} /* 滚动条的滑轨背景颜色 */
		
			::-webkit-scrollbar-thumb {
				  background-color: rgba(0, 0, 0, 0.2); 
			} /* 滑块颜色 */
		
			::-webkit-scrollbar-button {
				  background-color: #7c2929;
			} /* 滑轨两头的监听按钮颜色 */
		
			::-webkit-scrollbar-corner {
				  background-color: black;
			} /* 横向滚动条和纵向滚动条相交处尖角的颜色 */
			.index-right {
			    position: absolute;
			    right: 0;
			    top: 120px;
			    bottom: 0;
			    background-color: #fff;
			    padding-right: 20px;
			    padding-left: 20px;
			    width: -webkit-calc(100% - 230px);
			    width: -moz-calc(100% - 230px);
			    width: calc(100% - 17%);
			    overflow: auto;
			}
			.LeftContainer{
				width: 17%;
				background-color: #1b3045;
				min-height: 100%;
				float: left;
			}
			.welconmeInfo{
				width: 100%;
				min-height:10.85em;
			}
			.welconmeInfo span{
				color: white;
				font-size: 1.8em;
			}
			.welcomefont{
				padding: 20px 8px;
			}
			.soild-y{
				background-color: #E83F14;
				border: 0px;
				width: 10px;
				float: left;
				height: 100%;	
				z-index: 0;			
			}
			.menuList{
				z-index:999;
				height: 160px;			
			}
			#demo-list li a span{
				position: relative;
				top: -36px;
				left:40px;			
			}
			.soild-min-y{
				background-color: #1b3045;
				border: 0px;
				width: 8px;
				height: 25px;
				border-radius:3px;
				position:absolute;
				top: 14px;
   				 left: 185px;
   				 float : right;
			}
			.active div{
				background-color: #E83F14;
			}
			.active span{
				color: #E83F14;
			}
			.titleContainer{
				width: 82%;
				min-height:10.7em;
				float: right;
			}
			.enterpriseNum{
				font-size: 2.0em;
			}
			.enterpriseNumInfo{
				padding-top: 20px;
				padding-left: 50px;
			}
			.soild-x{
    			
    		}
    		.title-enter{
    			position: relative;
    			top: -20px;
    			
    		}
    		
    		.minUl li{
    			padding-top: 10px;
    			padding-bottom: 10px;
    			font-size: 1.2em;
    		}
    		
    		.minACtive div{
    			background-color: #E83F14;
    		}
    		.minACtive span{
    			color: #E83F14;
    		}
    		.minACtive a{
    			color: #E83F14;
    		}
    		.soildBig{
   			    background-color: #f4f4f4;
			    border: 0;
			    width: 110%;
			    height: 13px;
			    margin-left: -10px;
			    z-index: 0;
    		}
    </style>
    <script type="text/javascript">
    	function activeMenu(obj , num){
    		$("#demo-list li").removeAttr("class");
    		for(var i = 0; i < $("#demo-list li img").length; i++){
    			$("#demo-list li img").eq(i).attr("src" , $("#demo-list li img").eq(i).attr("src").replace("2.","."));
    		}
    		$(obj).attr("class" , "active");
    		if($(obj).find("img").attr("src").indexOf("2.") <= 0){
    			$(obj).find("img").attr("src" , $(obj).find("img").attr("src").replace(".","2."));
    		}
    		var url="<%=path%>";
    		switch (num) {
			case 1://订单
				url += "/enterpriseorder/list";
				break;
			case 2://企业用户
				url += "/enterprise/epusermanager/list";			
				break;
			case 3://激活企业卡
				url += "/activate/activatepage";
				break;
			}
    		console.log(url);
    		var t=new Date().valueOf();
    		$(".index-right").load(url,{_time:t});
    	}
    	
    </script>
</head>
<body>
<!--头部开始-->
<div class="LeftContainer">
    <!-------------left开始--------------------->
    <div class="welconmeInfo">
    	<div class="welcomefont">
    		<span>欢迎:</span>
         	<span style="padding-left: 25px;"><br/> ${sessionScope.userVo.enterprise.enterprisename}</span>	
    	</div>
    </div>
    <div class="menuList ">
    	<div class="soild-y"></div>
    	<div id="jquery-accordion-menu" class="jquery-accordion-menu red">
			<ul id="demo-list">
				<li class="active" onclick="activeMenu(this,1);"><a href="javascript:void(0)"><img src="<%=path %>/static/images/enterpriseImage/dd2.png"></img><span>订单详情</span><div class="soild-min-y"></div></a></li>
				<li onclick="activeMenu(this,2);"><a href="javascript:void(0)"><img src="<%=path %>/static/images/enterpriseImage/yh.png"></img><span>用户管理</span><div class="soild-min-y"></div></a></li>
				
				
			</ul>
			<%-- <li onclick="activeMenu(this,3);"><a href="javascript:void(0)"><img src="<%=path %>/static/images/enterpriseImage/k.png"></img><span>激活企业卡</span><div class="soild-min-y"></div></a></li>
				 --%>
		</div>
   	</div>
    <!-------------left结束--------------------->
     <%-- <ul class="header-nav">
         <li>
             <a href="<%=path%>/enterprise/logout"><span style="text-align: center;line-height: 280%;margin-right: 5px;" class="glyphicon glyphicon-off" ></span>安全退出</a>
         </li>
     </ul> --%>
</div>

<!--头部开始-->
	<div class="titleContainer">
		<div class="enterpriseNumInfo">
			<div>
				<img style="float: left;" alt="" src="<%=path %>/static/images/enterpriseImage/balance.png">
				<div class="title-enter enterpriseNum">
					:
					<span style="color:#1AB394;font-size:1.8em;">${cardInfo.count }</span>
					次
				</div>
			</div>
			<div>
				<img style="float: left;margin-top: -20px;padding-left: 5px;" alt="" src="<%=path %>/static/images/enterpriseImage/clock.png">
				<div class="title-enter" style="padding-left: 40px;">
					有效期至：${cardInfo.expriseDate }
				</div>
			</div>
			<div class="soild-x"></div>
		</div>
		<div id="rp_list" class="rp_list">
			<ul>
				<li>
					<div class="divOne">
						<img src="<%=path %>/static/images/enterpriseImage/shezhi.png" alt="" style="width: 15%;"/>
						<div style="padding-left: 70px;">
							<ul class="minUl">
								<li class="minACtive" ><a href="<%=path%>/enterprise/logout"><span>退出登录</span></a></li>
								<li id="lili" onclick="titleClick(2);"><a href="javascript:void(0)"><span>修改密码</span></a></li>
							</ul>
						</div>
					</div>
				</li>
				
			</ul>
		</div>
		<div class="soildBig"></div>
		<script>
			function titleClick(num){
					$(".minUl li").eq(0).attr("class" , "");
					$(".minUl li").eq(1).attr("class" , "minACtive");
					$(".index-right").load('<%=path%>/enterprise/configPwdPage');
			}
		
			$(function() {
				
				$(".index-right").load('<%=path%>/enterpriseorder/list');
				/**
				* the list of posts
				*/
				var $list 		= $('#rp_list ul');
				/**
				* number of related posts
				*/
				var elems_cnt 		= $list.children().length;
				
				/**
				* show the first set of posts.
				* 200 is the initial left margin for the list elements
				*/
				load(200);
				
				function load(initial){
					$list.find('li').hide().andSelf().find('.divOne').css('margin-left',-initial+'px');
					//show 5 random posts from all the ones in the list. 
					//Make sure not to repeat
					
					var $elem	= $list.find('li:nth-child('+ 1 +')');
					$elem.show();
					$("#lili").show();
					//animate them
					var d = 200;
					$list.find('li:visible .divOne').each(function(){
						$(this).stop().animate({
							'marginLeft':'-20px'
						},d += 100);
					});
				}
					
				/**
				* hovering over the list elements makes them slide out
				*/	
				$list.find('li:visible').live('mouseenter',function () {
					$(this).find('.divOne').stop().animate({
						'marginLeft':'-160px'
					},200);
				}).live('mouseleave',function () {
					$(this).find('.divOne').stop().animate({
						'marginLeft':'-20px'
					},200);
				});
				
				
            });
		</script>
	</div>
<!--头部结束-->
<!--主要内容开始-->
<div class="index-container">
    <div class="index-container-main">
        <!--左侧开始-->
        <!-- <div class="index-left" style="overflow: auto;width: 100%;">
            <div class="indexLeftContainer">

                <ul  class="index-left-menu" id="listmenu"  style="height:  95%"">
                </ul>
            </div>
        </div> -->
        <!--左侧结束-->

        <!--右侧开始-->
        <div  class="index-right" id="right-page" >
            <iframe name="rightContent" id="rightContent" src="" height="100%" width="100%" frameborder="0"></iframe>
        </div>
        <!--右侧结束-->
    </div>
</div>


<!--主要内容结束-->
<script type="text/javascript" id="baiduMaps" src="<%=path %>/static/js/mapApi.js?v=1.3"></script>
<script type="text/javascript">

</script>
</body>
</html>



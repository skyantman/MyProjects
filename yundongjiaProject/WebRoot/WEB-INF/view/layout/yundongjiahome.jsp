<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>运动+ 后台管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/bootstrap/css/bootstrapValidator.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcommon.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymstyle.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/gymcss/style.css" />
    <script src="<%=path%>/static/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/js/jquery.confirm.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=path%>/static/js/gym/indexLeft.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path %>/static/js/gym/pageBack.js"></script>
    <style type="text/css">
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
    </style>
</head>
<script type="text/javascript">
    var data;
    $(function () {
        data = ${sessionScope.userVo.menuJson};
        for (var i = 0; i < data.list.length; i++) {
            $('#listmenu').append("<li id=" + i + "></li>");
            for (var j = 0; j < data.list[i].menu.length; j++) {
                if (data.list[i].menu[j].menuIsroot == 1) {
                    $("#" + i).append("<div class='index-left-menu-item'><span></span><a>" + data.list[i].menu[j].menuName + "</a><i></i></div>");
                    $("#" + i).append("<ul class='index-left-menu-list dataManagement' id='list" + i + "' style='display: block;'></ul>");
                } else {
                    $("#list" + i).append("<li onclick='getRightPage(" + i + "," + j + ")'>" + data.list[i].menu[j].menuName + "</li>");
                }
            }
        }


        /*左侧菜单*/
        var indexLeft = {
            arrMenuItem: $(".index-left-menu-item"),
            arrMenuList: $(".index-left-menu-list"),
            arrLiList: $(".index-left-menu-list>li")
        };
        indexLeft.arrMenuList.eq(0).slideDown();
        indexLeft.arrMenuList.not(':first').slideUp();
        indexLeft.arrMenuItem.on('click', function () {
            $(this).parent().siblings().children('.index-left-menu-list').slideUp();
            $(this).next().slideToggle();
        });
        indexLeft.arrLiList.on('click', function () {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
        })

        /*加载页面*/
        var indexRight = $('.index-right');


        function clearData() {
            indexRight.html('');
        };

        var dataManage = {
            arrList: $('.dataManagement>li')
        };
        dataManage.arrList.eq(0).on('click', function () {
            indexRight.html();
        });
    });


    function getRightPage(i, j) {
        var url = "<%=path%>"+data.list[i].menu[j].menuPathname;
        $.ajax({
            type:"POST",
            url:url,
            cache: false,
            processData: false,
            sync:false,
            dataType:'text',
            success:function(data){
                $("#right-page").html(data);
            }
        });
       // document.getElementById("rightContent").src = "<%=path%>" + data.list[i].menu[j].menuPathname;
    }
</script>
<body>
<!--头部开始-->
<div class="index-top">
<input type="hidden" id="project" value="<%=path %>/">
    <div class="indexTopContainer">
        <!-------------header开始--------------------->
        <header>
            <div class="header-container">
                <div class="header-msg">
                    您好！
                    <span> ${sessionScope.userVo.user.backusername}</span> 欢迎登录运动+ 后台管理系统
                </div>
                <ul class="header-nav">
                    <li>
                        <a href="<%=path%>/yundongjia/logout"><span style="text-align: center;line-height: 280%;margin-right: 5px;" class="glyphicon glyphicon-off" ></span>安全退出</a>
                    </li>
                    <!-- <li><i></i>
                        <a>帮助中心</a>
                    </li>
                    <li><i></i>
                        <a>关于我们</a>
                    </li>
                    <li><i></i>
                        <a>我的消息</a>
                        <span>(5)</span>
                    </li> -->
                </ul>
            </div>
        </header>
        <!-------------header结束--------------------->
        <div class="system">
            <div class="system-title">
                <img class="top-logo" src="<%=path%>/static/images/yundongjia/Logo_nei.png"/>
            </div>
        </div>
    </div>

    <!--头部结束-->
</div>
<!--头部结束-->

<!--主要内容开始-->
<div class="index-container">
    <div class="index-container-main">
        <!--左侧开始-->
        <div class="index-left" style="overflow: auto;width: 100%;">
            <!--左侧开始-->
            <div class="indexLeftContainer">

                <ul  class="index-left-menu" id="listmenu"  style="height:  95%"">
                </ul>
            </div>
            <!--左侧结束-->
        </div>
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



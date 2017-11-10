<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>

		<div class="indexLeftContainer">
		<ul class="index-left-menu">
			<li>
				<div class="index-left-menu-item">
					<span></span>
					<a>我的健身房</a>
					<i></i>
				</div>
				<ul class="index-left-menu-list myGym">
					<li></li>
				</ul>
			</li>
			<li>
				<div class="index-left-menu-item">
					<span></span>
					<a>数据管理</a>
					<i></i>
				</div>
				<ul class="index-left-menu-list dataManagement">
					<li>课程预约</li>
					<li>会员</li>
					<li>会员卡</li>
					<li>报表管理</li>
				</ul>
			</li>
		</ul>
	</div>
<script src="<%=path%>/static/js/gym/indexLeft.js" type="text/javascript"></script>



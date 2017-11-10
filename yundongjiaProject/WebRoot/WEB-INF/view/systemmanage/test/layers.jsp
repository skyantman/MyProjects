<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>helloworld</h1>

<select id="select">
<option class="o">1111111111</option>
<option class="o">1111111111</option>
<option>1111111111</option>
<option>1111111111</option>
<option>1111111111</option>
</select>
<script type="text/javascript">
 $(document).ready(function(){
	 $("#select").css("background-color","red");
	/*  $("#select").on("click","option",function(){
		 console.log("ok");
	 }); */
	/*  $("#select").click(function(){
		 console.log("ok");
	 }); */
	 
	 /* $(".o").live(
		  function () {
		    //$(this).addClass("hover");
		    console.log("1");
		  },
		  function () {
		    //$(this).removeClass("hover");
			  console.log("2");
		  }
	  ); */
	  $("#select").mousedown(function(){
		  console.log("ok");
	  });
 });
</script>
</body>
</html>
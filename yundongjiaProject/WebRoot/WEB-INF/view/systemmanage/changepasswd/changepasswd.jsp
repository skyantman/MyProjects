<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8"></meta>
<title>GoHengOA系统V1.0->健身房管理系统</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/authManage.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="main-content mCdetail">
	<div class="col-md-12 page-header">
	  <h1><small>修改密码</small></h1>
	</div>
	<div class="hrsoild"></div>	
    <div class="main-content-mCdetail">
        <div class="form-group">
            <form id="passwdForm"  action="<%= path %>/gym/changepwd"  method="post"  onsubmit="return false" >
                <label>原始密码</label><input autofocus="autofocus" required="required" name="oldPasswd" id="oldPasswd" type="password" class="form-control"  style="width: 200px;"/><br/>
                <label>新密码</label><input required="required" onchange="checkPass()" name="newPasswd" id="newPasswd" type="password" class="form-control" style="width: 200px;"/><br/>
                <label>新密码确认</label><input onchange="checkPass()" name="newsurePasswd" id="newsurePasswd" type="password" class="form-control" style="width: 200px;"/><br/>
                <label style="color: red;" >${msg}</label><br/>
                <input  type="submit" onclick="subForm()"   role="button" class="btn btn-default  bcColor" data-toggle="modal" value="确定"/>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    function subForm() {
        var bol = checkForm();
        if (!bol){
            return false;
        }
        var url = $("#passwdForm").attr("action");
        var formData = new FormData($( "#passwdForm" )[0]);
        $.ajax({
            url: url ,
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (returndata) {
                $("#right-page").html(returndata);
            }
        });
    }

    function checkForm() {
        var oldPass = $("#oldPasswd").val();
        var newPass = $("#newPasswd").val();
        var newSure = $("#newsurePasswd").val();
        if (oldPass ==""){
            return false;
        }
        if (newPass ==""){
            return false;
        }
        if (newSure ==""){
            return false;
        }
        if (newPass != newSure){
            return false;
        }
        return true;
    }

    function checkPass() {
        var pass1 = document.getElementById("newPasswd");
        var pass2 = document.getElementById("newsurePasswd");
        if(pass1.value != pass2.value){
            pass2.setCustomValidity("两次输入的新密码不一致");
        }else{
            pass2.setCustomValidity("");
        }
    }


</script>
</body>
</html>
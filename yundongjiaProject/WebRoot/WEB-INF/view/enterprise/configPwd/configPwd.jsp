<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div class="main-content">
	 <div class="form-group">
          <form id="passwdForm"  action="<%= path %>/enterprise/changepwd"  method="post"  onsubmit="return false" >
              <label>原始密码</label><input autofocus="autofocus" required="required" name="oldPasswd" id="oldPasswd" type="password" class="form-control"  style="width: 200px;"/><br/>
              <label>新密码</label><input required="required" onchange="checkPass()" name="newPasswd" id="newPasswd" type="password" class="form-control" style="width: 200px;"/><br/>
              <label>新密码确认</label><input onchange="checkPass()" name="newsurePasswd" id="newsurePasswd" type="password" class="form-control" style="width: 200px;"/><br/>
              <label style="color: #6ec7cf;" >${msg}</label><br/>
              <input  type="submit" onclick="subForm()"   role="button" class="btn btn-default" style="background-color: #E83F14;color: white;" data-toggle="modal" value="确定"/>
          </form>
      </div>
</div>
<script type="text/javascript" src="<%=path %>/static/js/jquery-1.11.0.js"></script>
 <script src="<%=path%>/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/enterprise/pageUtils.js"></script>
<script type="text/javascript" src="<%=path %>/static/js/jquery.tmpl.min.js"></script>
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
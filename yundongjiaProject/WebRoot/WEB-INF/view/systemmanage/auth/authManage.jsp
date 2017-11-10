<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8"></meta>
<title>权限管理</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<script src="<%=path%>/static/js/gym/pageInfo.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/static/js/gym/authManage.js" type="text/javascript" charset="utf-8"></script>
 <script src="<%=path%>/static/css/bootstrap/js/bootstrapValidator.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/static/js/pageTemplate.js"></script>
<style type="text/css">
	.modal-content{
		margin-top: 0px;
	}
</style>
<script type="text/javascript">
//验证表单
$(function(){
	//authShowOrHid();
	$('#roleForm').bootstrapValidator({
		fields : {
			roleRemark : {
		    	 validators: {
		    		 stringLength: {
		                 min:0,
		                 max: 200,
		                 message: '备注长度必须在0到200之间'
		             },
		    	 }
		     },
		     roleName : {
		    	 validators: {
		    		 notEmpty : {
							message : '名称不可以为空'
					},
					callback: {  
		            	 message: '角色名称不可重复',
                        callback: function(value) {
                       	 var result = true;
                		 $.ajax({
                     		type: "POST",
                   			url : "<%=path%>/yundongjia/selectRoleName",
                   			dataType : "JSON",
                   			async : false,
                   			cache: false,
                   	        data: {
                   	        	roleName : value
                   	        },
                   	        success : function(data){
                   	        	result =  data.result;
                   	        }
                   		});
                       	 return result;
                        }
                    },
		    	 }
		     },
		  }
	});
});

    /*
    *清空表单数据
    */
    function cleanInfo() {
        $("#roleName").val('');
        $("#roleRemark").val('');
        $("#roleId").val('');
        $("#roleisclose").prop("checked",false)
        $("#roleForm").find("input:checkbox[name='authStr']").each(function (index,obj) {
            $(obj).prop("checked",false);
        });
        $("#roleForm").find("input:checkbox[name='menuStr']").each(function (index,obj) {
            $(obj).prop("checked",false);
        });
    }

    /**
     * 添加或者更新数据
     */
    function subRole() {
        var r = false;
        for(var i = 0; i < $(".menu-list input[type='checkbox']").length; i++){
        	if($(".menu-list input[type='checkbox']").eq(i).is(":checked")){
            	r = true;
            }
        }
        if(!r){
        	alert("请选择菜单");
        	return ;
        }
        var url;
        var formData = new FormData($('#roleForm')[0]);
        var roleId = $("#roleId").val();
        if(roleId != ""){
            url = "<%=path%>/yundongjia/updaterole";
            /*手动验证表单，当是普通按钮时。*/  
    		$('#roleForm').data('bootstrapValidator').validate();  
            if(!$('#roleForm').data('bootstrapValidator').isValid()){ 
            	if($("#roleName").val().length != 0){
                 	$("#roleForm")
                     .bootstrapValidator('updateStatus', 'roleName', 'VALID')
                     .bootstrapValidator('validateField', 'roleName');
                 }else{
                	 return ;
                 }
            }
        }else {
        	/*手动验证表单，当是普通按钮时。*/  
    		$('#roleForm').data('bootstrapValidator').validate();  
            if(!$('#roleForm').data('bootstrapValidator').isValid()){ 
                return ;  
            }
            url = $('#roleForm').attr("action");
        }
        $.ajax({
            url: url ,
            type: 'POST',
            data: formData,
            dataType : "JSON",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                if(data.result){
					var mainContent = $('.index-right');
					mainContent.load('<%=path%>/yundongjia/role');
					alert(data.message);
					 $(".modal-backdrop").hide();
				}else{
					alert(data.message);
				}
            }
        });
    }


    /*
     查询role信息
     */
    function getRoleinfo(roleId,roleName,roleRemark,roleIsclose){
        $("#roleName").val(roleName);
        $("#roleRemark").val(roleRemark);
        $("#roleId").val(roleId);
        if (roleIsclose == 1){
            $("#roleIsclose").prop("checked",true);
        }else {
            $("#roleIsclose").prop("checked",false);

        }
        var url = "<%=path%>/yundongjia/getroleinfo/"+roleId;
        $.ajax({
            url: url ,
            type: 'POST',
            async: false,
            cache: false,
            dataType: "json",
            contentType: false,
            processData: false,
            success: function (data) {
//                alert(JSON.stringify(data));
                setInfo(data);
            }
        });
    }

    /*
        填充数据
    */
    function setInfo(data) {

        var authArr = data.authIds;
        var menuArr = data.menuIds;
        $("#roleForm").find("input:checkbox[name='authStr']").each(function (index,obj) {
            if($.inArray(parseInt($(obj).val()),authArr) != -1){
                $(obj).prop("checked",true);
            }else {
                $(obj).prop("checked",false);
            }
        });
        $("#roleForm").find("input:checkbox[name='menuStr']").each(function (index,obj) {
            if($.inArray(parseInt($(obj).val()),menuArr) != -1){
                $(obj).prop("checked",true);
            }else {
                $(obj).prop("checked",false);
            }
        });
    }



    /*
        删除角色
     */
    function delRole(roleId,roleName) {
    	var result = confirm("你确定要删除["+roleName+"]这个角色吗?");
		if(result){
			var url = "<%=path%>/yundongjia/delrole/"+roleId;
            $.ajax({
                url: url ,
                type: 'POST',
                dataType : "JSON",
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                	if(data.result){
	   					var mainContent = $('.index-right');
	   					mainContent.load('<%=path%>/yundongjia/role');
	   					alert(data.message);
	   				}else{
	   					alert(data.message);
	   				}
                }
            });
		}
    }
    
  //顶级菜单点击事件
  function topClick(obj){
	  var valInfo = $(obj).val();
	  if($(obj).is(":checked")){
		  $('.'+valInfo).prop("checked" , true);
		  $('.list_'+valInfo).prop("checked" , true);
	  }else{
		  $('.'+valInfo).removeAttr("checked");
		  $('.list_'+valInfo).removeAttr("checked");
	  }
	  
  }

  //子菜单点击事件
  function childClick(obj){
	  var topId = $(obj).attr("class");
	  $("input[value='"+ topId +"']").prop("checked" , true);
	  var valInfo = $(obj).attr("class");
	  var bool = true;
	  for(var i = 0; i < $('.'+valInfo).length; i++){
		  if($('.'+valInfo).eq(i).is(":checked")){
			 bool = false; 
		  }
	  }
	  if(bool){
		  $('input[value="'+ valInfo +'"]').removeAttr("checked"); 
	  }
	  var val = $(obj).val();
	  for(var i = 0; i < $(".auth_"+val).length; i++){
		  var authObj = $(".auth_"+val).eq(i);
		  if($(obj).is(":checked")){
			  authObj.prop("checked" , true);
		  }else{
			  authObj.removeAttr("checked");  
		  }
	  }
  } 
  
  //按钮权限分配改变事件
  function authClick(obj){
	  var authClass = $(obj).attr("class");
	  var menuId = authClass.split("_")[1];
	  $("input[value='"+ menuId +"']").prop("checked" , true);
	  
  }
  //查询分配权限时所需要的工作人员信息
  function giveAuth(roleId){
	  $.ajax({
          url: '<%=path%>/yundongjia/selectWorkerAuth/'+roleId ,
          type: 'POST',
          dataType : "JSON",
          success: function (data) {
        	$("#haveAu").html("");
        	var userIdStr = "";
			for(var i = 0; i < data.haveAuth.length; i++){
				$("#haveAu").append("<li onclick='active(this);' userId="+ data.haveAuth[i].backuserId +" >" + data.haveAuth[i].backuserName +"</li>")
				userIdStr = userIdStr +  data.haveAuth[i].backuserId + ",";
			}
			$("#oldUserId").val(userIdStr);
          }
      });
	  $("#roleId2").val(roleId);
  }
  //分配权限点击选中
  function active(obj){
	  $(obj).attr("class" , "active");
	  $(obj).prevAll().attr("class" , "");
	  $(obj).nextAll().attr("class" , "");
  }
  //分配权限提交
  function subAuth(){
	  var oldUserId = $("#oldUserId").val();
	  var roleId = $("#roleId2").val();
	  var newUserId = "";
	  for(var i = 0; i < $("#haveAu>li").length; i++){
		  newUserId = newUserId + $("#haveAu>li").eq(i).attr("userId") + ",";
	  }
	  $.ajax({
          url: '<%=path%>/yundongjia/updateAuthRole' ,
          type: 'POST',
          data : {
        	  oldUserId : oldUserId,
        	  newUserId : newUserId,
        	  roleId : roleId
          },
          dataType : "JSON",
          success: function (data) {
        	 if(data.result){
				var mainContent = $('.index-right');
				mainContent.load('<%=path%>/yundongjia/role');
				$('.modal-backdrop').attr("hidden",true);
				alert(data.message);
			}else{
				alert(data.message);
			}
          }
      });
  }	
	
	//分页跳转
	function pageListInfo(page){
		var maincontent = $('.index-right');
		maincontent.load("<%=path%>/yundongjia/role?page="+page);
	}
	
  /* function authShowOrHid(){
	  if($("#gym_authmanage_update").length == 0){
			$(".gym_authmanage_update").remove();
	  }
	  if($("#gym_authmanage_del").length == 0){
			$(".gym_authmanage_del").remove();
	  }
	  if($("#gym_authmanage_giverole").length == 0){
			$(".gym_authmanage_giverole").remove();
	  }
  } */
</script>
</head>
<body>
<div class="main-content authManage">
	<div class="col-md-10  page-header">
			当前位置：
			<a href="javascript:void(0)" >权限管理</a>
		</div>
	<div class="col-md-2"  style="margin-top: 10px;">
		<%-- <shiro:hasPermission name="gym_authmanage:add"> --%>
			<a id="modal" href="#modal-container0" role="button" onclick="cleanInfo()" class="btn bcColor" data-toggle="modal">添加角色</a>
		<%-- </shiro:hasPermission> --%>
	</div>
	<div class="main-content-item" style="padding-top: 0px;">
		<table class="table" rules="cols" frame="box">
			<thead>
				<tr>
					<th>角色名称</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles.list }" var="role">
					<tr>
						<td>${role.roleName}</td>
						<td>${role.roleRemark}</td>
						<td>
							<a id="modal" onclick="giveAuth(${role.roleId})" href="#modal-container1" role="button" class="gym_authmanage_giverole" data-toggle="modal">分配权限</a>
							<a id="modal" onclick="getRoleinfo(${role.roleId},'${role.roleName}','${role.roleRemark}',${role.roleIsclose})" href="#modal-container0" role="button" class="gym_authmanage_giverole" data-toggle="modal">修改</a>
							<a href="javascript:void(0)" class="gym_authmanage_del" onclick="delRole(${role.roleId},'${role.roleName}')">删除</a>
	                       </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="main-content-footer">
			<div class="page" id="page">
				<div class="page" id="page">
				<a onclick="pageListInfo(1);" <c:if test="${roles.pageNum == 1 }">class="active"</c:if>>
					&lt;&lt;最前页</a>
						<div class="page-list">
							<c:forEach begin="1" end="${roles.pages }" varStatus="i">
								<c:if test="${i.index<roles.pageNum && i.index>roles.pageNum-5}">
									<span onclick="pageListInfo(${i.index });">${i.index }</span>
								</c:if>
								<c:if test="${roles.pageNum == i.index }">
									<span onclick="pageListInfo(${i.index });" class="active">${i.index }</span>
								</c:if> 
								<c:if test="${i.index>roles.pageNum && i.index<roles.pageNum+5}">
									<span onclick="pageListInfo(${i.index });">${i.index }</span>
								</c:if>
							</c:forEach>
						</div>
				<a onclick="pageListInfo(${roles.pages });" <c:if test="${roles.pageNum == roles.pages }">class="active"</c:if>>最后页&gt;&gt;</a>
			</div>
			</div>
		</div>
	
	<!--弹窗-->
	<div class="modal fade" id="modal-container0" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						添加角色
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="roleForm" action="<%=path%>/yundongjia/saverole" role="form">
						<div class="form-group">
							<label class="col-sm-2 control-label">名称:</label>
							<div class="col-sm-10">
								<input class="form-control" id="roleName" name="roleName" type="text" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注:</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="roleRemark" name="roleRemark" rows="" cols=""></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label><input type="checkbox" id="roleIsclose" value="1" name="roleIsclose" />禁用</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10 menu-list">
								<ul> 
									<c:forEach items="${menuVos}" var="ms">
									<li class="active">
		                                      <div class="clean"></div>
		                                      <div class="authdiv"><span  class="authspan">${ms.menuName}</span></div>
										<div class="checkbox authcheckbox">
											<label>
		                                              <input type="checkbox" onclick="topClick(this);" name="menuStr" value="${ms.menuId}" />
		                                          </label>
										</div>
		                                      <div class="clean"></div>
										<ul>
											<c:forEach items="${ms.menuVoList}" var="m">
											<li>
		                                              <div class="authdiv"><span class="authspan" >${m.menuName}</span></div>
												<div class="checkbox " style="float: right">
													<label >
		                                                      <input type="checkbox" name="menuStr" value="${m.menuId}" class="${ms.menuId}" onchange="childClick(this);" />
		                                                  </label>
												</div>
		                                              <div class="clean"></div>
		                                              
												<ul>
												<c:forEach items="${m.authList}" var="auth">
													<li>
		                                                      <div class="authdiv"><span  class="authspan">${auth.authName}</span></div>
														<div class="checkbox ">
															<label>
	                                                              <input type="checkbox" name="authStr" class="auth_${m.menuId} list_${ms.menuId}" value="${auth.authId}" onchange="authClick(this);"/>
	                                                          </label>
														</div>
		                                                      <div class="clean"></div>
													</li>
												</c:forEach>	
												</ul>
											</li>
											</c:forEach>
										</ul>
									</li>
									</c:forEach> 
								</ul>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-6">
								<button type="button" class="btn btn-primary bcColor" onclick="subRole()">确定</button>
								<button type="button" class="btn btn-default fr" data-dismiss="modal">取消</button>
							</div>
						</div>
                        <input  type="hidden" id="roleId" name="roleId"/>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-container1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						当前角色:<span>管理员</span>	
					</h4>
				</div>
				<div class="modal-body auth-given">
					<div class="worker">
						<h4>工作人员</h4>
						<ul id="noAu">
							<c:forEach items="${noAuth }" var="no">
								<li userId="${no.backuserId }" >${no.backuserName }</li>	
							</c:forEach>
						</ul>
					</div>
					<input type="hidden" id="oldUserId">
					<input type="hidden" id="roleId2">
					<div class="worker-given">
						<h4>已分配人员</h4>
						<ul id="haveAu">
						</ul>
					</div>
					<div class="del">
						<a href="javascript:void(0)">删除选择</a>
					</div>
					<div style="text-align: center;" class="">
						<button type="submit" onclick="subAuth();" class="btn btn-primary bcColor">确定</button>
						<button type="button" class="btn btn-default" data-dismiss="modal" style="margin-left: 70px;">取消</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%-- <shiro:hasPermission name="gym_authmanage:update"><div hidden="hidden" id="gym_authmanage_update"></div></shiro:hasPermission>
<shiro:hasPermission name="gym_authmanage:del"><div hidden="hidden" id="gym_authmanage_del"></div></shiro:hasPermission>
<shiro:hasPermission name="gym_authmanage:giverole"><div hidden="hidden" id="gym_authmanage_giverole"></div></shiro:hasPermission> --%>
</body>
</html>
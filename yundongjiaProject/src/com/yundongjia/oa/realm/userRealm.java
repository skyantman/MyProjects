package com.yundongjia.oa.realm;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.service.UserService;
import com.yundongjia.oa.admin.vo.UserVo;

/**
 * 
 * Title:com.yundongjia.oa.realm Description:健身房
 * 
 * @author HuangJian
 * @date 2016年11月8日
 */
public class userRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	public static final String GYM_REAML_NAME="gymReaml";
	public userRealm() {
		setName(GYM_REAML_NAME);
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

		String username = (String) principal.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> realms = principal.getRealmNames();
		if(realms.contains(GYM_REAML_NAME)){
			if(!StringUtils.isBlank(username)){
				authorizationInfo.setRoles(userService.findRoles(username));
				//System.out.println(userService.findRoles(username));
				authorizationInfo.setStringPermissions(userService.findPermissions(username,"gym"));
				//System.out.println(userService.findPermissions(username));
			}
		}
		
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		String password = String.valueOf(upToken.getPassword());
		TAdmin baseUser = new TAdmin();
		baseUser.setBackusermobliephone(username);
		baseUser.setBackuserpwd(password);
		
		int result = userService.gymlogin(baseUser);
		String errInfo = "ok";
		switch (result) {
		case UserVo.USER_VAIL_RESULT_NULL:
			errInfo = "账号不存在";
			break;
		case UserVo.USER_VAIL_RESULT_JIAN:
			errInfo = "ok";
			break;
		case UserVo.USER_VAIL_RESULT_PSERR:
			errInfo = "密码错误";
			break;
		case UserVo.USER_VAIL_RESULT_TING:
			errInfo = "账号已经停用";
			break;
		case UserVo.USER_VAIL_RESULT_YC:
			errInfo = "账号异常,请联系管理员";
			break;
		}

		if ("ok".equals(errInfo)) {
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
			return info;
		} else {
			throw new AuthenticationException(errInfo);
		}

	}
	
	@Override
	protected void doClearCache(PrincipalCollection principals) {
		
		super.doClearCache(principals);
	}
	/**
	 * 
	* Title: manualDoGetAuthorizationInfo
	* Description:手动加载权限标识
	* @author HuangJian
	* @date 2016年12月29日
	 */
	public AuthorizationInfo manualDoGetAuthorizationInfo(PrincipalCollection principal){
		return doGetAuthorizationInfo(principal);
	}
	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		SimplePrincipalCollection principalCollection = new SimplePrincipalCollection(principals, getName());
		
		super.clearCachedAuthorizationInfo(principals);
	}
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

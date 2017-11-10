package com.yundongjia.app.user.controller.usercontroller;



import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yundongjia.app.user.service.LoginUserService;
import com.yundongjia.app.user.service.MemberInfoService;
import com.yundongjia.app.user.service.UserInfoService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TActivation;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberExample;
import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TMsgExample;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.po.TUserExample;
import com.yundongjia.oa.utils.DateUtil;
import com.yundongjia.oa.utils.IdentifyCodeUtil;
import com.yundongjia.oa.utils.RedeemCodeUtils;
import com.yundongjia.oa.utils.SendMessage;
import com.yundongjia.oa.utils.UtilMD5;

import net.sf.json.JSONObject;

/** * @author  作者WangLi: * @date 创建时间：2017年1月16日 上午10:57:26 * @version 1.0 * @parameter  * @since  * @return  */

/**
 * 
* @ClassName: LoginUserController 
* @Description: TODO(运动+用户登录界面系列操作) 
* @author Wangli
* @date 2017年1月16日 上午11:00:07 
*
 */
@Controller
public class LoginUserController extends BaseController{
    
	@Autowired
	private LoginUserService loginUserService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private MemberInfoService memberService;
	
	@RequestMapping(value="ydj/user/userlogin")
	 public void loginUser(String str) throws Exception{
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = Integer.parseInt(map.get("type").toString());
		switch (type) {
		case 0: //获取验证码
			createVerfiy(map);
			break;
		case 1: //用户注册
			userRegByCodeAndMobilePhoneNo(map);
			break;
		case 2: //密码登陆
			loginByMobilePhoneNoAndPasswd(map);
			break;
		case 3: //短信验证码登陆
			userLoginByReg(map);
			break;
		case 4: //找回密码
			findBackPassword(map);
			break;
		case   5: //修改密码
			changePassword(map);
			break;
		case 6://验证注册完成设置登录密码
			userSetPW(map);
			break;
		case 7://强制更新接口
			versionUpdate();
			break;
		default:
			break;
		}
	 }
	
		/**
		 * 
		* @Title: createVerfiy 
		* @Description: TODO(生成验证码保存验证码到数据库，通过手机下发) 
		* @param     设定文件 
		* @return void    返回类型 
		* @throws
		 */
		public void createVerfiy(Map<String, Object> map) {
			jsonclear();
			try {
				System.out.println(InetAddress.getLocalHost());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 String mobilePhoneNo = map.get("mobilePhoneNo").toString();
			 Integer codeType = Integer.parseInt(map.get("codeType").toString());
			   //生成随机6位数验证码
				String code = IdentifyCodeUtil.createIndentifyCode(true, 6);
				TMsg msg = new TMsg();
				msg.setVerifycode(code);
				msg.setMobilephoneno(mobilePhoneNo);
				msg.setStatus("1");
				msg.setCreatedate(format.format(new Date()));
				msg.setCodetype(0);
				msg.setFromid(0);
				msg.setIp("");
				int sid = this.loginUserService.insertVerifyCode(msg);
				if (sid > 0) {
				String data = SendMessage.sendMessage(mobilePhoneNo, code , codeType);

				String aa = data;
				String[] am = aa.split(",");
				String a0 = am[0];
				if ("03".equals(a0)) {
					jsonObject.put("status", "0");
					jsonObject.put("message", "请求验证码成功");
					jsonObject.put("verifyCode", code);
				} else {
					System.out.println("a0======================================="+a0);
					jsonObject.put("status", "1");
					jsonObject.put("message", "请求验证码失败");
				}

			}
                  this.RSAprivateencode(jsonObject.toString());

			}
		
		/**
		 * 
		* @Title: findBackPassword 
		* @Description: TODO(找回密码) 
		* @param     设定文件 
		* @return void    返回类型 
		* @throws
		 */
		public void findBackPassword(Map<String, Object> map) {
			jsonclear();
			 String mobilePhoneNo = map.get("mobilePhoneNo").toString();
			 String password = map.get("password").toString();
			 String verifyCode = map.get("verifyCode").toString();
			 TMsgExample example = new TMsgExample();
			 example.createCriteria().andMobilephonenoEqualTo(mobilePhoneNo).andVerifycodeEqualTo(verifyCode);
			 example.setOrderByClause("createDate DESC;");
			 List<TMsg> list = this.loginUserService.selectVerifyCode(example);
			if (list.size()>0 && "1".equals(list.get(0).getStatus())) {//验证码验证通过
				map.put("mobilePhoneNo", mobilePhoneNo);
				TUser user = new TUser();
				TMsg msg = new TMsg();
				TUserExample example2 =  new TUserExample();
				example2.createCriteria().andMobilephonenoEqualTo(mobilePhoneNo);
				List<TUser> list_user = this.userInfoService.selectUserLoginInfo(example2);//查询用户信息是否正常
				if(list_user.size() == 1){
					user.setPassword(UtilMD5.md5(password));
					this.userInfoService.updateUserPwd(user, example2);//修改密码
					msg.setStatus("0");
					msg.setVerifyid(list.get(0).getVerifyid());
					this.loginUserService.updateVerifyCodeStatus(msg);//修改验证码状态使其不可用
					jsonObject.put("status", "0");
					jsonObject.put("message", "找回密码成功！");
					jsonObject.put("userId", list_user.get(0).getUserid());
				}else{
					jsonObject.put("status", "1");
					jsonObject.put("message", "用户信息异常");
				}
			} else {

				jsonObject.put("status", "1");
				jsonObject.put("message", "验证码验证失败！");
			}
              this.RSAprivateencode(jsonObject.toString());
			
		}
		
		
		/**
		 * 
		* @Title: loginByMobilePhoneNoAndPasswd 
		* @Description: TODO(使用手机号和密码进行登陆) 
		* @param     设定文件 
		* @return void    返回类型 
		* @throws
		 */
	    public void loginByMobilePhoneNoAndPasswd(Map<String, Object> map) {
	    	jsonclear();
			String mobilePhoneNo = map.get("mobilePhoneNo").toString();
			String password = map.get("password").toString();
			TUserExample example =new TUserExample();
			example.createCriteria().andMobilephonenoEqualTo(mobilePhoneNo);
	    	List<TUser> list_user = this.userInfoService.selectUserLoginInfo(example);
	        if (list_user.size() == 1) {
	            if (list_user.get(0).getPassword() == null || "".equals(list_user.get(0).getPassword())) {
	                //没有密码
	                jsonObject.put("status", "1");
	                jsonObject.put("message", "您还没有设置密码");
	            } else if (!UtilMD5.md5(password).equals(list_user.get(0).getPassword())) {
	                jsonObject.put("status", "1");
	                jsonObject.put("message", "密码错误,请重试或点击忘记密码找回");
	            } else {
	                jsonObject = memberLogin(mobilePhoneNo,list_user.get(0).getUserid());
	            }
	        } else {
	            jsonObject.put("status", "1");
	            jsonObject.put("message", "该手机号还没有注册,请先注册");
	        }

	        this.RSAprivateencode(jsonObject.toString());

	    }
	    
	    
	    public JSONObject memberLogin(String mobilePhoneNo,Integer userId){
	    	jsonclear();
	    	JSONObject info = new JSONObject();
	    	JSONObject json = new JSONObject();
            TMemberExample memberExample = new TMemberExample();
            memberExample.createCriteria().andUseridEqualTo(userId);
             List<TMember> list_member = this.memberService.selectMemberInfo(memberExample);
             if (list_member != null && list_member.size() > 0) {
                //账号信息没问题
            	 json.put("memberId", list_member.get(0).getMemberid());
            	 json.put("nickName",list_member.get(0).getNickname());
            	 json.put("userId", userId);
            	 json.put("imgpath", list_member.get(0).getImgpath());
            	 json.put("memberId", list_member.get(0).getMemberid());
            	 json.put("mobilePhoneNo",mobilePhoneNo);
            	 json.put("gender", list_member.get(0).getGender());
            	 json.put("autopragh", list_member.get(0).getAutograph());
            	 json.put("age", list_member.get(0).getBorndate());
            	 json.put("height", list_member.get(0).getHeight());
                json.put("status", "0");
                json.put("message", "登录成功");
                if (list_member.get(0).getFirstlogdate() == null || list_member.get(0).getFirstlogdate().equals("")) {
                    TMember tm = new TMember();
                    tm.setMemberid(list_member.get(0).getMemberid());
                    tm.setFirstlogdate(DateUtil.getDateTime());
                    this.memberService.updateMemberInfo(tm);
                }
            } else {
                json.put("status", "1");
                json.put("message", "账号信息有问题,请联系客服");
            }
             return json;
	    }
	    
	    /**
	     * 
	    * @Title: changePassword 
	    * @Description: TODO(修改密码) 
	    * @param     设定文件 
	    * @return void    返回类型 
	    * @throws
	     */
	    public void changePassword(Map<String, Object> map) {
	    	jsonclear();
			String password = UtilMD5.md5( map.get("password").toString());//新密码
			String oldPassword = UtilMD5.md5( map.get("oldPassword").toString());//原始密码
			Integer userId = Integer.parseInt( map.get("userId").toString());
			TUserExample userExample = new TUserExample();
			userExample.createCriteria().andUseridEqualTo(userId);
			List<TUser> list_user = this.userInfoService.selectUserLoginInfo(userExample);
			if(list_user.size() == 1){
				if (!oldPassword.equals(list_user.get(0).getPassword())) {
					jsonObject.put("status", "1");
					jsonObject.put("message", "原密码输入不正确,请重新输入");
				} else {
	                TUser tUser = new TUser();
	                tUser.setPassword(password);
	                this.userInfoService.updateUserPwd(tUser,userExample);
	                jsonObject.put("status", "0");
	                jsonObject.put("message", "修改密码成功！");
				}
			}else{
				jsonObject.put("status", "1");
				jsonObject.put("message", "用户信息有误！");
			}
			this.RSAprivateencode(jsonObject.toString());
		}
		
	    /**
	     * 
	    * @Title: userRegByCodeAndMobilePhoneNo 
	    * @Description: TODO(用户通过手机号和验证码进行注册) 
	    * @param     设定文件 
	    * @return void    返回类型 
	    * @throws
	     */
	    public void userRegByCodeAndMobilePhoneNo(Map<String, Object> map){
	    	jsonclear();
			String mobilePhoneNo = map.get("mobilePhoneNo").toString();
			String code = map.get("code").toString();
			String password = map.get("password").toString();
			//先验证用户是否为会员
			TUserExample userExample = new TUserExample();
			userExample.createCriteria().andMobilephonenoEqualTo(mobilePhoneNo);
			List<TUser> list_user = this.userInfoService.selectUserLoginInfo(userExample);
			if(list_user.size() == 0){
				TMsgExample msgExample = new TMsgExample();
				msgExample.createCriteria().andMobilephonenoEqualTo(mobilePhoneNo).andVerifycodeEqualTo(code).andStatusEqualTo("1");
		    	List<TMsg> list_msg = this.loginUserService.selectVerifyCode(msgExample);	
		            if(list_msg.size() > 0 ){
						//验证码存在进行注册
						String nickName = "尾号"+mobilePhoneNo.substring(7, 11);
						String createDate = format.format(new Date());
						String imgpath="";
						TUser user = new TUser();
						user.setCreatedate(createDate);
						user.setMobilephoneno(mobilePhoneNo);
						user.setIsvalid("0");
						user.setUsertype("app");
						user.setPassword(UtilMD5.md5(password));
						int userId = this.userInfoService.insertUser(user);
						if (userId > 0) {
							TMember member = new TMember();
							member.setUserid(user.getUserid());
							member.setNickname(nickName);
							member.setImgpath(imgpath);
							Integer result = this.memberService.insertMemberInfo(member);
                            //给一个随机金额 方法: createRegRPAndSave(goheng项目有样例 appuserAction)
							jsonObject.put("memberId", member.getMemberid());
                            jsonObject.put("nickName",nickName);
                            jsonObject.put("userId", user.getUserid());
                            jsonObject.put("imgpath", " " );
                            jsonObject.put("memberId", member.getMemberid());
                            jsonObject.put("mobilePhoneNo",mobilePhoneNo);
                            jsonObject.put("gender", "0");
                            jsonObject.put("autopragh", " ");
                            jsonObject.put("age", " ");
                            jsonObject.put("height", 0);
                            jsonObject.put("status", "0");
                            jsonObject.put("message", "注册成功");
                            TMsg msg = new TMsg();
        	            	msg.setStatus("0");
        					msg.setVerifyid(list_msg.get(0).getVerifyid());
        					this.loginUserService.updateVerifyCodeStatus(msg);//修改验证码状态使其不可用
                            
                            
	                    }
				}else{
					//验证码过期或者不存在
					jsonObject.put("status", "1");
					jsonObject.put("message", "验证码过期或者不存在,请重新申请");
				}
				
			}else{
				//是会员
				jsonObject.put("status", "1");
				jsonObject.put("message", "您已经是会员,请前往登录");
			}

			this.RSAprivateencode(jsonObject.toString());
		}
		
	    
	    /**
	     * 
	    * @Title: userLoginByReg 
	    * @Description: TODO(短信验证码登陆) 
	    * @param     设定文件 
	    * @return void    返回类型 
	    * @throws
	     */
	    public void userLoginByReg(Map<String, Object> map){
	    	jsonclear();
			String mobilePhoneNo = map.get("mobilePhoneNo").toString();
			String code = map.get("code").toString();
			//先验证用户是否为会员
			TUserExample userExample = new TUserExample();
			userExample.createCriteria().andMobilephonenoEqualTo(mobilePhoneNo);
			List<TUser> list_user = this.userInfoService.selectUserLoginInfo(userExample);
			if(list_user.size() == 1){
				TMsgExample msgExample = new TMsgExample();
				msgExample.createCriteria().andMobilephonenoEqualTo(mobilePhoneNo).andVerifycodeEqualTo(code).andStatusEqualTo("1");
		    	List<TMsg> list_msg = this.loginUserService.selectVerifyCode(msgExample);	
	            if(list_msg.size() > 0){
						//验证码存在可以登录
	            	jsonObject = memberLogin(mobilePhoneNo,list_user.get(0).getUserid());
	            	TMsg msg = new TMsg();
	            	msg.setStatus("0");
					msg.setVerifyid(list_msg.get(0).getVerifyid());
					this.loginUserService.updateVerifyCodeStatus(msg);//修改验证码状态使其不可用
				}else{
					//验证码过期或者不存在
					jsonObject.put("status", "1");
					jsonObject.put("message", "验证码过期或者不存在,请重新申请");
				}
				
			}else{
				//不是会员
				jsonObject.put("status", "1");
				jsonObject.put("message", "该手机号还没有注册,请先注册");
			}
			this.RSAprivateencode(jsonObject.toString());
			
		}
	    
	    /**
	     * 
	    * @Title: userSetPW 
	    * @Description: TODO(用户注册成功之后设置登录密码) 
	    * @param     设定文件 
	    * @return void    返回类型 
	    * @throws
	     */
	    public void userSetPW(Map<String, Object> map){
	    	jsonclear();
			Integer userId = Integer.parseInt(map.get("userId").toString());
			String password = map.get("password").toString();
	        TUser user = new TUser();
	        user.setPassword(UtilMD5.md5(password));
	        user.setUserid(userId);
	        try {
	        	this.userInfoService.updateUserPwd(user);
	        	jsonObject.put("status", "0");
	        	jsonObject.put("message", "修改成功");
			} catch (Exception e) {
				jsonObject.put("status", "1");
				jsonObject.put("message", "修改失败");
			}finally {
				this.RSAprivateencode(jsonObject.toString());
			}
	    }
		
	    @RequestMapping(value="ydj/test/test")
		public void test(String str){
			this.RSApublicencode(str);
		}

	    @RequestMapping(value="ydj/test/decodeparam")
		public void test1(String str){
			this.RSApublicdecode(str);
		}
	    
		public void versionUpdate(){
			jsonclear();
			jsonObject.put("hot_search_keys", this.selectConfigVal("hot_search_keys"));
			jsonObject.put("android_version", this.selectConfigVal("android_version"));
			jsonObject.put("android_code", Integer.parseInt(this.selectConfigVal("android_code")));
			jsonObject.put("ios_version", this.selectConfigVal("ios_version")); 
			jsonObject.put("ios_code", this.selectConfigVal("ios_code"));
			jsonObject.put("androidisupdate", this.selectConfigVal("androidisupdate"));//是否强制更新  0 不强制  1强制
			jsonObject.put("iosisupdate", this.selectConfigVal("iosisupdate"));
			jsonObject.put("message", "查询成功");
			jsonObject.put("status", "0");
			this.RSAprivateencode(jsonObject.toString());
		}
		
		@RequestMapping(value="ydj/user/createActivationCode")
		public void createActivationCode(){
			RedeemCodeUtils re = new RedeemCodeUtils();
			TActivation activation = new TActivation();
			for(int i=0;i<400;i++){
				String st1 = re.createBigSmallLetterStrOrNumberRadom(8);
				activation.setCardnum(st1.toLowerCase());
				activation.setExpirationdate("2019-01-01");
				activation.setAmount(0.00);
				activation.setActivationtype("5");
				activation.setCreatedate(format.format(new Date()));
				activation.setValid(0);
				activation.setMemberid(0);
				activation.setComm(re.createNumberRadom(18));
				
				this.loginUserService.insertActivation(activation);
			}
		}
		
		
		
		
	    
	    
	    

}

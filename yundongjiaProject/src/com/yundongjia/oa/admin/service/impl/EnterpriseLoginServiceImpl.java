package com.yundongjia.oa.admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TEnterpriseLoginMapper;
import com.yundongjia.oa.admin.mapper.TEnterpriseMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TMsgMapper;
import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.po.TEnterprise;
import com.yundongjia.oa.admin.po.TEnterpriseLogin;
import com.yundongjia.oa.admin.po.TEnterpriseLoginExample;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;
import com.yundongjia.oa.admin.service.EnterpriseLoginService;
import com.yundongjia.oa.admin.vo.UserVo;
import com.yundongjia.oa.utils.MD5Util;

@Service
public class EnterpriseLoginServiceImpl implements EnterpriseLoginService{
	@Autowired
	private TEnterpriseMapper tEnterpriseMapper;
	@Autowired
	private TEnterpriseLoginMapper tEnterpriseLoginMapper;
	@Autowired
	private TMsgMapper baseMsgMapper;
	@Autowired
	private TMemberCardOrderRefMapper tMemberCardOrderRefMapper;
	
	@Override
	public Integer selectByPhone(String phone) {
		TEnterpriseLoginExample tEnterpriseLoginExample = new TEnterpriseLoginExample();
		tEnterpriseLoginExample.createCriteria().andPhoneEqualTo(phone);
		List<TEnterpriseLogin> result = tEnterpriseLoginMapper.selectByExample(tEnterpriseLoginExample);
		if(result.size() == 1){
			return null;
		}else{
			return 1;
		}
	}

	@Override
	public int enterpriseLogin(String backusermobliephone, String backuserpwd , HttpSession session) {
		TEnterpriseLoginExample tEnterpriseLoginExample = new TEnterpriseLoginExample();
		tEnterpriseLoginExample.createCriteria().andPhoneEqualTo(backusermobliephone);
		List<TEnterpriseLogin> result = tEnterpriseLoginMapper.selectByExample(tEnterpriseLoginExample);
		TEnterpriseLogin user = null;
		if(result.size() != 0){
			user = result.get(0);
		}
		if (user != null) {
			if (MD5Util.md5(backuserpwd).equals(user.getPassword())) {
				// 登录成功
				TEnterprise enterprise = tEnterpriseMapper.selectByPrimaryKey(user.getEnterpriseid());
				UserVo userVo = new UserVo();
				user.setPassword(null);
				userVo.setEnterprise(enterprise);
				userVo.setEnterpriseUser(user);
				session.setAttribute("userVo", userVo);
				return UserVo.USER_VAIL_RESULT_JIAN;
			} else {
				return UserVo.USER_VAIL_RESULT_PSERR;
			}
		} else {
			return UserVo.USER_VAIL_RESULT_NULL;
		}
	}

	/**
	 * @param baseUser
	 * @return更新会员密码
	 * @author Li XiaoYang
	 */
	@Override
	public Integer configPassword(String userPassword , String userMobilephoneno , String msg) {
		Map param1= new HashMap();
		param1.put("authCode", msg);
		param1.put("phonenum", userMobilephoneno);
		Integer idInteger = baseMsgMapper.selectBMByphoneAndCode(param1);
		if(idInteger == null || idInteger == 0 ){
			return 0;
		}
		String password = MD5Util.md5(userPassword);
		TEnterpriseLogin tEnterpriseLogin = new TEnterpriseLogin();
		tEnterpriseLogin.setPhone(userMobilephoneno);
		tEnterpriseLogin.setPassword(password);
		TEnterpriseLoginExample tEnterpriseLoginExample = new TEnterpriseLoginExample();
		tEnterpriseLoginExample.createCriteria().andPhoneEqualTo(userMobilephoneno);
		Integer result = tEnterpriseLoginMapper.updateByExampleSelective(tEnterpriseLogin, tEnterpriseLoginExample);
		Integer r = 0; 
		if(result != 0){
			r = baseMsgMapper.updateStatuByPhone(userMobilephoneno);
		}
		return result;
	}

	@Override
	public Map<String, Object> findenterpriseCardInfo(Integer enterpriseid) {
		Map<String, Object> result = new HashMap<>();
		TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
		tMemberCardOrderRefExample.createCriteria().andEnterpriseidEqualTo(enterpriseid).andPaystatusEqualTo("2").andStatusEqualTo(0);
		List<TMemberCardOrderRef> selectByExample = tMemberCardOrderRefMapper.selectByExample(tMemberCardOrderRefExample);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer count = 0;
		String expriseDate = "";
		for (TMemberCardOrderRef tm : selectByExample) {
			count = count + tm.getSurplussportscount();
			if(selectByExample.size() == 1){
				expriseDate = tm.getExpiredate();
			}else{
				if("".equals(expriseDate)){
					expriseDate = tm.getExpiredate();
				}else{
					try {
						if(simpleDateFormat.parse(tm.getExpiredate()).getTime() < simpleDateFormat.parse(expriseDate).getTime()){
							expriseDate = tm.getExpiredate();
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		result.put("expriseDate", expriseDate);
		result.put("count", count);
		return result;
	}
	
	@Override
	public int updateGymPasswordByOldPassword(Integer userId, String oldPassword, String newPassword) {
		TEnterpriseLogin user = this.tEnterpriseLoginMapper.selectByPrimaryKey(userId);
		if (user == null) {
			return -1;
		}
		if (!StringUtils.equals(user.getPassword(), MD5Util.md5(oldPassword))) {
			return 0;
		}
		user.setPassword(MD5Util.md5(newPassword));
		int i = this.tEnterpriseLoginMapper.updateByPrimaryKeySelective(user);
		if (i <= 0) {
			return -1;
		}
		return 1;
	}
}

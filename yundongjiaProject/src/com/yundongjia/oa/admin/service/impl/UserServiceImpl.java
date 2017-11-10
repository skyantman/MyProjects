package com.yundongjia.oa.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yundongjia.oa.admin.mapper.TAdminAuthRefMapper;
import com.yundongjia.oa.admin.mapper.TAdminMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardEnterpriseRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TMenuAdminRefMapper;
import com.yundongjia.oa.admin.mapper.TMenuMapper;
import com.yundongjia.oa.admin.mapper.TMsgMapper;
import com.yundongjia.oa.admin.mapper.TOpeartionMapper;
import com.yundongjia.oa.admin.mapper.TRoleMapper;
import com.yundongjia.oa.admin.mapper.TUserMapper;
import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.po.TAdminExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRef;
import com.yundongjia.oa.admin.po.TMemberExample;
import com.yundongjia.oa.admin.po.TMenu;
import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TMsgExample;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRole;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.service.RoleService;
import com.yundongjia.oa.admin.service.UserService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.UserVo;
import com.yundongjia.oa.utils.MD5Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by ltlxy on 2016/9/18.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TAdminMapper baseUserMapper;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private TMenuMapper baseMenuMapper;

	@Autowired
	private TRoleMapper baseRoleMapper;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private TMsgMapper baseMsgMapper;
	
	@Autowired
	private TAdminAuthRefMapper baseUserAuthRefMapper;

	@Autowired
	private TMenuAdminRefMapper baseMenuUserRefMapper;
	
	@Autowired
	private TOpeartionMapper tOpeartionMapper;
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TMemberMapper memberMapper;
	@Autowired
	private TMemberCardEnterpriseRefMapper memberCardEnterpriseRefMapper;
	
	 
	/**
	 * 健身房登录
	 * 
	 * @param baseUser
	 * @return
	 */
	@Override
	public int gymlogin(TAdmin baseUser) {

		TAdmin user = baseUserMapper.selectByGYMUserName(baseUser);
		if (user != null) {
			if (MD5Util.md5(baseUser.getBackuserpwd()).equals(user.getBackuserpwd())) {
				// 登录成功
				initUserInfo(user.getBackuserid());
				return UserVo.USER_VAIL_RESULT_JIAN;
			} else {
				return UserVo.USER_VAIL_RESULT_PSERR;
			}
		} else {
			return UserVo.USER_VAIL_RESULT_NULL;
		}
	}
	/**
	 * 初始化用户信息
	 * 
	 * @param userId
	 */
	public void initUserInfo(Integer userId) {
		TAdmin user = this.baseUserMapper.selectByPrimaryKey(userId);
		String menuJson = initUserMenu(userId);
		UserVo userVo = new UserVo();
		user.setBackuserpwd(null);
		userVo.setUser(user);
		userVo.setMenuJson(menuJson);
		
		this.request.getSession().setAttribute("userVo", userVo);
	}

	/**
	 * 初始化用户菜单
	 * 
	 * @return
	 */
	private String initUserMenu(int userId) {
			return this.resoleMenu(getGYMWorkerList(userId));
	}

	/**
	 * 健身房工作人员
	 * 
	 * @param userId
	 * @return
	 */
	private List<TMenu> getGYMWorkerList(int userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return this.baseMenuMapper.selectUserMenuByUserId(map);
	}

	/**
	 * 解析用户菜单返回json字符串
	 * 
	 * @param menus
	 * @return
	 */
	private String resoleMenu(List<TMenu> menus) {
		JSONObject json = new JSONObject();
		JSONArray list = new JSONArray();
		JSONObject jtemp = new JSONObject();
		JSONArray menu = null;
		List<Map<Integer, List<TMenu>>> mlist = new ArrayList<Map<Integer, List<TMenu>>>();
		List<List<TMenu>> jlist = new ArrayList<List<TMenu>>();
		if (menus != null) {
			// 第一次 start
			for (TMenu bm : menus) {
				if (bm.getMenuIsdel() == 0 && bm.getMenuIsshow() == 1 && bm.getMenuIsroot() == 1) {
					Map<Integer, List<TMenu>> tmap = new HashMap<Integer, List<TMenu>>();
					List<TMenu> tlist = new ArrayList<TMenu>();
					tlist.add(bm);
					jlist.add(tlist);
					tmap.put(bm.getMenuId(), tlist);
					mlist.add(tmap);
				}
			}
			// 第一次 end
			// 第二次 start
			for (int i = 0; i < menus.size(); i++) {
				TMenu bm = menus.get(i);
				if (bm.getMenuIsdel() == 0 && bm.getMenuIsshow() == 1 && bm.getMenuIsroot() == 0) {
					for (Map<Integer, List<TMenu>> tm : mlist) {
						if (tm.get(Integer.parseInt(bm.getMenuPid())) != null && jlist.indexOf(tm.get(Integer.parseInt(bm.getMenuPid()))) != -1
								&& jlist.get(jlist.indexOf(tm.get(Integer.parseInt(bm.getMenuPid())))).indexOf(bm) == -1) {
							tm.get(Integer.parseInt(bm.getMenuPid())).add(bm);
							// jlist.get(jlist.indexOf(tm.get(bm.getMenuPid()))).add(bm);
						}
					}
				}
			}
			// 第二次 end
			for (List<TMenu> lb : jlist) {
				jtemp.clear();
				if (lb.size() > 1) {
					menu = JSONArray.fromObject(lb);
					jtemp.put("menu", menu);
					list.add(jtemp);
				}
			}
			json.put("list", list);
		}
		return json.toString();
	}

	@Override
	public void gymlogout() {
		this.request.getSession().removeAttribute("userVo");
	}

	@Override
	public int updateGymPasswordByOldPassword(Integer userId, String oldPassword, String newPassword) {
		TAdmin user = this.baseUserMapper.selectByPrimaryKey(userId);
		if (user == null) {
			return -1;
		}
		if (!StringUtils.equals(user.getBackuserpwd(), MD5Util.md5(oldPassword))) {
			return 0;
		}
		user.setBackuserpwd(MD5Util.md5(newPassword));
		int i = this.baseUserMapper.updateByPrimaryKeySelective(user);
		if (i <= 0) {
			return -1;
		}
		return 1;
	}

	@Override
	public Set<String> findRoles(String username) {
		Set<String> setList = new HashSet<String>();
		UserVo user = (UserVo) this.request.getSession().getAttribute("userVo");
		if(user == null){
			return setList;
		}
		TRole role = roleService.getRoleById(user.getUser().getBackuserroleid());
		if (role != null) {
			setList.add(role.getRoleName());
		}
		/*BaseUserExample example = new BaseUserExample();
		example.createCriteria().andUserMobilephonenoEqualTo(username);
		List<BaseUser> list = baseUserMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			BaseUser user = list.get(0);

			BaseRole role = roleService.getRoleById(user.getUserRoleId());
			if (role != null) {
				setList.add(role.getRoleName());
			}

		}*/

		return setList;
	}
	@Override
	public Set<String> findPermissions(String username,String flag) {
		
		Set<String> authSet=new HashSet<>();
		UserVo user = (UserVo) this.request.getSession().getAttribute("userVo");
		if(user == null){
			return authSet;
		}
		Map<String, Object> param=new HashMap<>();
		param.put("rId", user.getUser().getBackuserroleid());
		param.put("flag", flag+"%");
		//按钮权限标志
		//根据用户roleID查询权限
		List<Map<String,Object>> resultMap =  baseUserAuthRefMapper.selectAuthByRoleId(param);
		if(resultMap!=null && resultMap.size() > 0){
			//权限标志放入集合中
			for (int i = 0; i < resultMap.size(); i++) {
				Map<String, Object> temp=resultMap.get(i);
				authSet.add(temp.get("auth_mark").toString());
			}
		}
		//菜单权限标志
		//根据角色查询菜单标志
		List<Map<String,Object>> menuMap =  baseMenuUserRefMapper.selectMenuRoleRefMyRoleId(user.getUser().getBackuserroleid());
		if(menuMap !=null && menuMap.size()>0){
			for (int i = 0; i < menuMap.size(); i++) {
				Map<String, Object> temp=menuMap.get(i);
				authSet.add(temp.get("menu_powerid").toString());
			}
		}
		/*BaseUserExample example = new BaseUserExample();
		example.createCriteria().andUserMobilephonenoEqualTo(username);
		List<BaseUser> list = baseUserMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			BaseUser user = list.get(0);
			//按钮权限标志
			//根据用户roleID查询权限
			List<Map<String,Object>> resultMap =  baseUserAuthRefMapper.selectAuthByRoleId(user.getUserRoleId());
			if(resultMap!=null && resultMap.size() > 0){
				//权限标志放入集合中
				for (int i = 0; i < resultMap.size(); i++) {
					Map<String, Object> temp=resultMap.get(i);
					authSet.add(temp.get("auth_mark").toString());
				}
			}
			//菜单权限标志
			//根据角色查询菜单标志
			List<Map<String,Object>> menuMap =  baseMenuUserRefMapper.selectMenuRoleRefMyRoleId(user.getUserRoleId());
			if(menuMap !=null && menuMap.size()>0){
				for (int i = 0; i < menuMap.size(); i++) {
					Map<String, Object> temp=menuMap.get(i);
					authSet.add(temp.get("menu_powerid").toString());
				}
			}
		}*/
		 
		return authSet;
	}

	/**
	 * @param baseUser
	 * @return更新会员密码
	 * @author Li XiaoYang
    * @date 2016年11月11日
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
		Map param = new HashMap();
		param.put("password", password);
		param.put("mobilphone", userMobilephoneno);
		Integer result = baseUserMapper.updateByPhone(param);
		Integer r = 0; 
		if(result != 0){
			r = baseMsgMapper.updateStatuByPhone(userMobilephoneno);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.yundongjia.oa.admin.service.UserService#insetBaseMsg(java.lang.String, java.lang.String)
	 * 插入验证码相关信息
	 */
	@Override
	public Integer insetBaseMsg(String phonenum, String authCode , String ip) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
		TMsg baseMsg = new TMsg();
		baseMsg.setIp(ip);
		baseMsg.setFromid(0);
		baseMsg.setStatus("1");
    	baseMsg.setCodetype(0);
    	baseMsg.setCreatedate(dateFormat.format(new Date()).toString());
    	baseMsg.setMobilephoneno(phonenum);
    	baseMsg.setVerifycode(authCode);
    	//查询相同IP或手机号的验证信息
    	
    	TMsgExample baseMsgExample1 = new TMsgExample();
    	baseMsgExample1.createCriteria().andMobilephonenoEqualTo(phonenum).andStatusEqualTo("1").andCreatedateGreaterThanOrEqualTo(formate.format(new Date()) + "00:00:00");
    	TMsgExample baseMsgExample2 = new TMsgExample();
    	baseMsgExample2.createCriteria().andIpEqualTo(ip).andStatusEqualTo("1").andMobilephonenoEqualTo(phonenum).andCreatedateGreaterThanOrEqualTo(formate.format(new Date()) + "00:00:00");
    	List<TMsg> phone = baseMsgMapper.selectByExample(baseMsgExample1);
    	List<TMsg> IP = baseMsgMapper.selectByExample(baseMsgExample2);
    	if(IP.size() > 10){
    		return -2;
    	}
    	if(phone.size() > 10){
    		return -1;
    	}
    	int result  = baseMsgMapper.insertSelective(baseMsg);
    	return result;
	}
	

	/* (non-Javadoc)
	 * @see com.yundongjia.oa.admin.service.UserService#checkCode(java.lang.String, java.lang.String)
	 * 查询验证码是否匹配
	 */
	@Override
	public Integer checkCode(String authCode, String phonenum) {
		Map param = new HashMap();
		param.put("authCode", authCode);
		param.put("phonenum", phonenum);
		Integer idInteger = baseMsgMapper.selectBMByphoneAndCode(param);	
		return idInteger;
	}

	/**
	 * @param mobilephone
	 * @return 根据会员手机号查询是否注册
	 */
	@Override
	public Integer selectByPhone(String mobilephone){
		Map param = new HashMap();
		param.put("mobilephone", mobilephone);
		return baseUserMapper.selectByPhone(param);
	}
	
	/**
	 * @return 查询工作人员信息（base_user）Li XiaoYang 2016.11.5
	 */
	@Override
	public List<TAdmin> selectBUByUserType() {
		TAdminExample taAdminExample = new TAdminExample();
		taAdminExample.createCriteria();
		List<TAdmin> byExample = baseUserMapper.selectByExample(taAdminExample);
		return format(byExample);
	}
	
	/**
	 * @return 根据工作人员手机号或工作人员姓名 查询工作人员信息Li XiaoYang 2016.11.5
	 */
	@Override
	public List<TAdmin> selectBUByphoneOrName(String searchInfo) {
		if(searchInfo.length() == 0){
			TAdminExample tAdmin = new TAdminExample();
			tAdmin.setOrderByClause("backuserId desc");
			List<TAdmin> workers = baseUserMapper.selectByExample(tAdmin);
			return workers;
		}
		String search = "%"+ searchInfo +"%";
		TAdminExample tAdmin = new TAdminExample();
		tAdmin.or().andBackusermobliephoneLike(search);
		tAdmin.or().andBackusernameLike(search);
		tAdmin.setOrderByClause("backuserId desc");
		List<TAdmin> workers = baseUserMapper.selectByExample(tAdmin);
		return format(workers);
	}
	
	public List<TAdmin> format(List<TAdmin> list){
		for (TAdmin t : list) {
			//查询出角色名称并放入用户对象的密码字段中
			TRole role = baseRoleMapper.selectByPrimaryKey(t.getBackuserroleid());
			if(role == null ){
				t.setBackuserpwd("暂无");
			}else{
				t.setBackuserpwd(role.getRoleName());
			}
			
		}
		return list;
	}
	
	/**
	 * @return 插入工作人员信息以及操作记录 Li XiaoYang 2016.11.4
	 */
	@Override
	public Integer insertWorker(TAdmin baseUser, UserVo userVo) {
		//插入操作记录
		TOpeartion baseOpeartion = new TOpeartion();
		baseOpeartion.setOpeartionCreatedate(new Date());
		baseOpeartion.setOpeartionAdminId(userVo.getUser().getBackuserid());
		baseOpeartion.setOpeartionInfo("创建工作人员--" + baseUser.getBackusername());
		baseOpeartion.setOpeartionType(13);
		
		String userPassword = baseUser.getBackuserpwd();
		String password = MD5Util.md5(userPassword);
		baseUser.setBackuserpwd(password);
		baseUser.setBackuserroleid(0);
		int resultUser = baseUserMapper.insertSelective(baseUser);
		baseOpeartion.setOpeartionById(baseUser.getBackuserid());
		int resultOpeartion = tOpeartionMapper.insertSelective(baseOpeartion);
		Integer result = null;
		if(resultUser != 0 && resultOpeartion != 0){
			result = 1;
		}else{
			result = 0;
		}
		return result;
	}
	
	/**
	 * @return跳转到会员详情页Li XiaoYang 2016.11.4
	 */
	@Override
	public TAdmin selectBUById(Integer userId) {
		TAdmin worker = baseUserMapper.selectByPrimaryKey(userId);
		//查询出角色名称并放入用户对象的密码字段中
		TRole role = baseRoleMapper.selectByPrimaryKey(worker.getBackuserroleid());
		if(role == null ){
			worker.setBackuserpwd("暂无");
		}else{
			worker.setBackuserpwd(role.getRoleName());
		}
		return worker;
	}
	
	/**
	 * @return逻辑删除工作人员信息 Li XiaoYang 2016.11.4
	 */
	@Override
	public Integer deleteWorker(Integer userId , Integer loginUserId) {
		int res = baseUserMapper.deleteByPrimaryKey(userId);
		//插入操作记录
		TAdmin worker = baseUserMapper.selectByPrimaryKey(userId);
		TOpeartion baseOpeartion = new TOpeartion();
		baseOpeartion.setOpeartionCreatedate(new Date());
		baseOpeartion.setOpeartionAdminId(loginUserId);
		baseOpeartion.setOpeartionInfo("删除工作人员--" + worker.getBackusermobliephone());
		baseOpeartion.setOpeartionType(13);
		baseOpeartion.setOpeartionById(userId);
		int resultOpeartion = tOpeartionMapper.insertSelective(baseOpeartion);
		return res;
	}
	
	/**
	 * @return 更新工作人员信息Li XiaoYang 2016.11.4
	 */
	@Override
	public Integer updateWorkerInfo(TAdmin baseUser, UserVo userVo) {
		if(baseUser.getBackuserpwd().length() != 0 ){
			String userPassword = baseUser.getBackuserpwd();
			String password = MD5Util.md5(userPassword);
			baseUser.setBackuserpwd(password);
		}
		int resultUser = baseUserMapper.updateByPrimaryKeySelective(baseUser);
		//插入操作记录
		TOpeartion baseOpeartion = new TOpeartion();
		baseOpeartion.setOpeartionCreatedate(new Date());
		baseOpeartion.setOpeartionAdminId(userVo.getUser().getBackuserid());
		baseOpeartion.setOpeartionInfo("更新工作人员--" + baseUser.getBackusermobliephone());
		baseOpeartion.setOpeartionType(13);
		baseOpeartion.setOpeartionById(baseUser.getBackuserid());
		int resultOpeartion = tOpeartionMapper.insertSelective(baseOpeartion);
		Integer result = null;
		if(resultUser != 0){
			result = 1;
		}else{
			result = 0;
		}
		return result;
	}
	@Override
	public Map<String, Object> insertTuser(TUser user, Integer cardId) {
		Map<String, Object> res = new HashMap<>();
		//查询改手机号码是否绑卡 如果已经绑卡就不做操作
		List<Map<String, Object>> users =  tUserMapper.selectUserEnterByPhone(user.getMobilephoneno());
		if(users.size() > 0){
			res.put("message", "用户已绑卡,不能再次绑卡");
			res.put("result", 0);
			res.put("id",0);
			return res;
		}
		Integer memberId=-1;
		Integer result=0;
		//查询用户手机号码在t_user t_member是否存在
		List<Map<String, Object>> userMemeber =  tUserMapper.selectUserMemberByPhone(user.getMobilephoneno());
		if(userMemeber.size() > 0){
			//用户手机号已存在   修改企业卡绑定用户
			if(userMemeber.size() == 1){
				Map<String, Object> oneMap = userMemeber.get(0);
				memberId = Integer.parseInt(String.valueOf(oneMap.get("memberId")));
				user.setUserid(Integer.parseInt(String.valueOf(oneMap.get("userId"))));
			}else{
				res.put("message", "手机号码存在多个");
			}
			
			
		}else{
			//如果该用户不存在  则增加用户与会员
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setCreatedate(sdf.format(new Date()));
			user.setIsvalid("0");
			
			String md5Password = MD5Util.md5(ConstantVo.USER_PASSWORD);
			user.setPassword(md5Password);
			int rsult = tUserMapper.insertSelective(user);
			
			
			//添加t_member数据
			TMember member = new TMember();
			member.setUserid(user.getUserid());
			String nickName = "尾号"+user.getMobilephoneno().substring(7, 11);
			member.setNickname(nickName);
			member.setRegionsid(1);//默认北京市
			int memRes = memberMapper.insertSelective(member);
			
			memberId = member.getMemberid();
		}
		TMemberCardEnterpriseRef tcer = new TMemberCardEnterpriseRef();
		if(memberId > -1){
			//企业卡和用户 t_member_card_enterprise_ref
			tcer.setCardid(cardId);
			tcer.setMemberid(memberId);
			int mcResult = memberCardEnterpriseRefMapper.insertSelective(tcer);
			if(tcer.getCardid() > 0){
				result = tcer.getCardid();
			}
		}else{
			res.put("message", "增加会员用户异常");
		}
		
		if(tcer != null && tcer.getCardid() > 0){
			res.put("id", tcer.getCardid());
			res.put("message", "绑卡成功");
		}else{
			res.put("id",0);
			res.put("message", "绑卡失败");
		}
		
		res.put("result", result);
		return res;
	}
	@Override
	public List<Map<String, Object>> findTuserListByMobilePhone(String mobilePhone, Integer cardId) {
		Map<String, Object> param=new HashMap<>();
		param.put("cardId", cardId);
		param.put("mobilePhone", mobilePhone);
		List<Map<String, Object>> data =  tUserMapper.findTuserListByMobilePhone(param);
		if(data !=null){
			for(Map<String, Object> map:data){
				map.put("moveCount", Integer.parseInt(String.valueOf(map.get("sportsCount"))) - Integer.parseInt(String.valueOf(map.get("surplusSportsCount"))));
			}
		}
		return data;
	}
	@Override
	public int updateTuserById(TUser user) {
		int result = tUserMapper.updateByPrimaryKeySelective(user);
		return result;
	}
	@Override
	public List<Map<String, Object>> getTuserById(Integer userId) {
		
		return tUserMapper.getTuserById(userId);
	}
	@Override
	public Integer getTuserMobilePhoneCount(String mobilePhone,Integer tType) {
		Map<String, Object> param=new HashMap<>();
		param.put("mobilePhone", mobilePhone);
		param.put("tableType", tType);
		return tUserMapper.getTuserMobilePhoneCount(param);
	}
	@Override
	public List<Map<String, Object>> findUserByMobilePhoneCards(String mobilePhone, List<Integer> cards) {
		Map<String, Object> param=new HashMap<>();
		param.put("cards", cards);
		param.put("mobilePhone", mobilePhone);
		List<Map<String, Object>> data =  tUserMapper.findUserByMobilePhoneCards(param);
		if(data !=null){
			for(Map<String, Object> map:data){
				map.put("moveCount", Integer.parseInt(String.valueOf(map.get("sportsCount"))) - Integer.parseInt(String.valueOf(map.get("surplusSportsCount"))));
			}
		}
		return data;
	}

	@Override
	public List<Map<String, Object>> findUserByCards(List<Integer> cards) {
		
		return memberCardEnterpriseRefMapper.findUserByCards(cards);
	}
	 

}

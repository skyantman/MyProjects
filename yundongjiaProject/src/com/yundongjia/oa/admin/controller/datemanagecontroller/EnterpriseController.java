/*
* @author HuangJian
* @date 2017年1月10日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TEnterprise;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.service.EnterpriseAndSelfCardService;
import com.yundongjia.oa.admin.service.EnterpriseService;
import com.yundongjia.oa.admin.service.MemberCardOrderRefService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.RegionsService;
import com.yundongjia.oa.admin.service.UserService;
import com.yundongjia.oa.admin.vo.ConstantVo;


/*
 * 
* Title: com.yundongjia.oa.admin.controller.datemanagecontroller 
* Description: 企业管理
* @author HuangJian
* @date 2017年1月10日
 */
@Controller
public class EnterpriseController extends BaseController {

	@Autowired
	private RegionsService regionsService;//城市
	@Autowired
	private EnterpriseService enterpriseService;//企业
	@Autowired
	private EnterpriseAndSelfCardService enterpriseAndSelfCardService; //卡类型
	@Autowired
	private MemberCardOrderRefService memberCardOrderRefService;//卡
	@Autowired
	private OpeartionService opeartionService;
	@Autowired
	private UserService userService;
	
	public List<TRegions> listPro;

	public Map<String, Object> jsonMap;

	public PageInfo<Map<String, Object>> mapPageInfo;
	
	public List<Map<String, Object>> opearMap;
	
	public List<Map<String, Object>> mapsJson;
	
	public List<Map<String, Object>> resultMaps;
	
	public Map<String, Object> resultMap;
	
	List<Map<String, Object>> list;
 	/*
	 * 
	 * Title: listEnterprise Description: 企业列表
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月12日
	 */
	@RequestMapping("/yundongjia/listenterprise")
	public String listEnterprise(Model model, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		list =  enterpriseService.findEnterpriseAndCard();
		mapPageInfo=new PageInfo<>(list);
		
		//统计
		resultMap = enterpriseService.getEnterpriseByStatisMessage();
		
		
		model.addAttribute("statis", resultMap);
		model.addAttribute("lists", mapPageInfo);
		return "/systemmanage/enterprise/enterpriseList";
	}

	/*
	 * 
	 * Title: enterprisePage Description: 去添加页面
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月10日
	 */
	@RequestMapping("/yundongjia/addenterprise")
	public String enterprisePage(Model model) {
		// 加载省
		listPro = regionsService.geTRegionsByProvince();

		List<TCardType> list = enterpriseAndSelfCardService.findenterprisecardlist();

		model.addAttribute("listPro", listPro);
		model.addAttribute("cardTypes", list);
		return "/systemmanage/enterprise/add";
	}

	/*
	 * 
	 * Title: getCityList Description: 根据省获得市
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月11日
	 */
	@RequestMapping("/yundongjia/getcitybypro")
	@ResponseBody
	public String getCityList(Integer proCode) {

		listPro = regionsService.getCityByProvince(proCode);
		String result = new Gson().toJson(listPro);
		return result;
	}

	/*
	 * 
	 * Title: getAreaList Description: 根据市code区
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月11日
	 */
	@RequestMapping("/yundongjia/getareabycity")
	@ResponseBody
	public String getAreaList(Integer cityCode) {
		listPro = regionsService.getAreaByCity(cityCode);
		String result = new Gson().toJson(listPro);
		return result;
	}

	/*
	 * 
	 * Title: saveEnterprise Description: 保存企业信息 cardTypeId:卡类型
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月11日
	 */
	@RequestMapping("/yundongjia/saveenterprise")
	@ResponseBody
	public String saveEnterprise(TEnterprise enterprise) {
		enterprise.setOperationid(this.getLogUserId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		enterprise.setCreatedate(sdf.format(new Date()));
		
		// 增加的数据
		Integer primaryId = enterpriseService.saveEnterprise(enterprise);

		TOpeartion o = new TOpeartion();
		o.setOpeartionAdminId(this.getLogUserId());
		o.setOpeartionById(primaryId);
		o.setOpeartionType(ConstantVo.TYPE_ENTERPRISE);
		o.setOpeartionInfo("创建企业");
		int res = opeartionService.saveOpeartion(o);

		return new Gson().toJson(primaryId);
	}
	/*
	 * 
	* Title: editEnterprise
	* Description: 修改企业信息
	* @author HuangJian
	* @date 2017年1月12日
	 */
	@RequestMapping("/yundongjia/updateenterprise")
	@ResponseBody
	public String editEnterprise(TEnterprise enterprise) {
		jsonMap = new HashMap<>();
		enterprise.setOperationid(this.getLogUserId());
		
		Integer id = enterpriseService.updateEnterprise(enterprise);

		TOpeartion o = new TOpeartion();
		o.setOpeartionAdminId(this.getLogUserId());
		o.setOpeartionById(enterprise.getEnterpriseId());
		o.setOpeartionType(ConstantVo.TYPE_ENTERPRISE);
		o.setOpeartionInfo("企业信息编辑");
		int res = opeartionService.saveOpeartion(o);
		jsonMap.put("id", enterprise.getEnterpriseId());
		jsonMap.put("state", res);
		return new Gson().toJson(jsonMap);
	}
	
	
	
	
	/*
	 * 
	 * Title: detailEnterprise 
	 * 
	 * Description: 去详情页 id:企业id  tab:标识哪个tab展示(1:详情，2：企业卡，3用户管理)  cardId:默认-1    
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月11日
	 */
	@RequestMapping("/yundongjia/detailenterprise")
	public String detailEnterprise(WebRequest request,Model model, Integer id, Integer tab,@RequestParam(defaultValue="-1",required=true) Integer cardId,@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_5) Integer pageSize , Integer enterpriseCardId) {
		// 企业信息
		Map<String, Object> enterprise = enterpriseService.getEnterpriseById(id);
		List<Map<String, Object>> userList = null;
		// 企业操作信息
		List<Map<String, Object>> opears =  opeartionService.findOpeartion(ConstantVo.TYPE_ENTERPRISE, id);
		List<Map<String, Object>> cards = null;
		List<Map<String, Object>> userOpears=null;
		//加载企业卡信息
		if(tab == 2){
			//if cardId == -1 全查
			PageHelper.startPage(pageNum, pageSize);
			cards =  memberCardOrderRefService.getCardOrderByEnterId(id);
			mapPageInfo = new PageInfo<>(cards);
			model.addAttribute("cards", mapPageInfo);
			
			opearMap = opeartionService.findOpeartionByOpearType(ConstantVo.TYPE_ENTERPRISE_CARD);
			//卡的操作记录
			model.addAttribute("cardOpears", opearMap);
			
		}
		//加载企业卡下的用户信息
		if(tab == 3){
			//加载企业的所有卡
			cards =  memberCardOrderRefService.getCardOrderByEnterId(id);
			model.addAttribute("enterCards", cards);
			
			if(cardId == -1){
				
				
				
			}else{//选择了一张卡 加卡下的用户
				PageHelper.startPage(pageNum, pageSize);
				userList =  userService.findTuserListByMobilePhone(null, cardId);
				mapPageInfo = new PageInfo<>(userList);
				
			}
			userOpears =  opeartionService.findOpeartionByOpearType(ConstantVo.TYPE_ENTERPRISE_USER);
			model.addAttribute("userOpears", userOpears);
			model.addAttribute("users", mapPageInfo);
			request.setAttribute("cardid", cardId, request.SCOPE_SESSION);//卡id
		}
		
		
		model.addAttribute("enterprise", enterprise);
		model.addAttribute("enterOpears", opears);
		model.addAttribute("tab", tab);
		if(enterpriseCardId != null){
			model.addAttribute("enterpriseCardId", enterpriseCardId);
		}
		return "/systemmanage/enterprise/detail";
	}

	/*
	 * 
	 * Title: toEditPage Description: 去修改页面 id：企业id
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月12日
	 */
	@RequestMapping("/yundongjia/enterprisetoeditpage")
	public String toEditPage(Model model, Integer id) {

		Map<String, Object> enterprise = enterpriseService.getEnterpriseById(id);

		// 企业信息
		model.addAttribute("enterprise", enterprise);

		// 加载省
		listPro = regionsService.geTRegionsByProvince();
		
		// 加载企业卡类型
		List<TCardType> list = enterpriseAndSelfCardService.findCardTypeByEnterType(null);

		model.addAttribute("listPro", listPro);
		model.addAttribute("cardTypes", list);

		return "/systemmanage/enterprise/edit";
	}

	/*
	 * 
	 * Title: saveCardOrder Description: 根据卡类型创建卡 cardTypeId:类型id
	 * enterpriseId:企业id money:采购价  payMethod:支付方式   cardTypeId:卡类型
	 *  
	 * @author HuangJian
	 * 
	 * @date 2017年1月11日
	 */
	@RequestMapping("/yundongjia/savecardorder")
	@ResponseBody
	public String saveCardOrder(Integer cardTypeId, Integer enterpriseId, double money,Integer payMethod) {
		jsonMap = new HashMap<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 查询卡类型
		List<TCardType> cardTypes = enterpriseAndSelfCardService.findCardTypeByEnterType(cardTypeId);
		TCardType type = cardTypes.get(0);
		
		TMemberCardOrderRef cardOrder = new TMemberCardOrderRef();
		cardOrder.setCardtypeid(type.getCardid());
		cardOrder.setDiscount(type.getCarddiscount());// 折扣
		cardOrder.setRealmoney(money); // 采购价
		cardOrder.setTotalmoney(Double.parseDouble(type.getAmount()));// 面值
		cardOrder.setCashback(Double.parseDouble("-1"));// 返现金额
		cardOrder.setValidday(type.getValiddate());// 有效天数
		cardOrder.setCreatedate(sdf.format(new Date()));// 激活日期
		Calendar calendar = Calendar.getInstance();
		try {
			// 设置日期
			calendar.setTime(sdf.parse(cardOrder.getCreatedate()));
		} catch (ParseException e) {

		}
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + type.getValiddate());
		cardOrder.setCardorder(String.valueOf(System.currentTimeMillis()));//订单号
		cardOrder.setOrdernum(String.valueOf(System.currentTimeMillis()));//订单号
		cardOrder.setPaytype(String.valueOf(payMethod));
		cardOrder.setExpiredate(sdf.format(calendar.getTime()));// 到期日期 激活日期+有效期
		cardOrder.setStatus(0);// 状态 生效
		cardOrder.setEnterpriseid(enterpriseId);// 企业id
		cardOrder.setSportscount(type.getSportscount());// 运动次数
		cardOrder.setSurplussportscount(type.getSportscount());// 剩余次数  首次创建等于运动次数
		cardOrder.setMemberid(-1);// -1为企业卡
		int primaryId = memberCardOrderRefService.saveMemberCardOrderRef(cardOrder);

		TOpeartion o = new TOpeartion();
		o.setOpeartionAdminId(this.getLogUserId());
		o.setOpeartionById(primaryId);
		o.setOpeartionType(ConstantVo.TYPE_ENTERPRISE_CARD);
		o.setOpeartionInfo("新增企业卡");
		int res = opeartionService.saveOpeartion(o);

		//把卡类型库存 -1
		Integer surp =  type.getSurplusstock();
		TCardType ct = new TCardType();
		if(surp > 0){
			 
			ct.setSurplusstock((surp-1));
		}
		
		ct.setCardid(type.getCardid());
		
		//修改库存减一
		int typeResult = enterpriseAndSelfCardService.updateCardTypeById(ct);
		
		
		// 根据卡id查询信息
		Map<String, Object> cardMessage = memberCardOrderRefService.getCardOrderById(primaryId);
		  
		
		jsonMap.put("result", primaryId);
		jsonMap.put("message", cardMessage);
		return new Gson().toJson(jsonMap);
	}
	/*
	 * 
	* Title: getEnterpriseByName
	* Description: 模糊查询企业名称
	* @author HuangJian
	* @date 2017年1月12日
	 */
	@RequestMapping("/yundongjia/getenterprisebyname")
	@ResponseBody
	public String getEnterpriseByName(String name,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_5) Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		list =  enterpriseService.getEnterpriseByName("%"+name+"%");
		mapPageInfo = new PageInfo<>(list);
		return new Gson().toJson(mapPageInfo);
	}
	/*
	 * 
	* Title: setEnterpriseStatus
	* Description: status:状态值  0生效，1禁用    enterpriseId:企业id   comm:理由
	* @author HuangJian
	* @date 2017年1月13日
	 */
	@RequestMapping("/yundongjia/setenterprisestatus")
	@ResponseBody
	public String setEnterpriseStatus(Integer status,Integer enterpriseId,String comm){
		jsonMap = new HashMap<>();
		int result = enterpriseService.updateEnterpriseByStatus(status, enterpriseId);
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(enterpriseId);
		if(status == 0){
			op.setOpeartionInfo("启用企业");
		}else if(status == 1){
			op.setOpeartionInfo("禁用企业");;
		}
		op.setOpeartionCom(comm);
		op.setOpeartionType(ConstantVo.TYPE_ENTERPRISE);
		
		opeartionService.saveOpeartion(op);
		
		jsonMap.put("result", result);
		jsonMap.put("enterId", enterpriseId);
		return new Gson().toJson(jsonMap);
	}

	
	
	/**
	* Title: saveEnterUser
	* Description: 增加企业用户
	* @param mobilePhone:手机号码
	* @param cardId:卡
	* @param 
	* @return
	* @author HuangJian
	* @date 2017年1月16日
	*/
	@RequestMapping("/yundongjia/saveenteruser")
	@ResponseBody
	public String saveEnterUser(String mobilePhone,Integer cardId){
		TUser user = new TUser();
		user.setMobilephoneno(mobilePhone.trim());
		Map<String, Object> res = userService.insertTuser(user, cardId);
		int primaryId = Integer.parseInt(String.valueOf(res.get("id")));
		if(primaryId > 0){
			TOpeartion op = new TOpeartion();
			op.setOpeartionAdminId(this.getLogUserId());
			op.setOpeartionType(ConstantVo.TYPE_ENTERPRISE_USER);
			op.setOpeartionById(primaryId);
			op.setOpeartionInfo("用户绑定企业卡");
			opeartionService.saveOpeartion(op);
		}
		
		return new Gson().toJson(res);
	}
	
	/**
	* Title: updateUserStatus
	* Description: 
	* @param userId 用户id
	* @param status 状态 0生效，1禁用
	* @param comm 备注
	* @return
	* @author HuangJian
	* @date 2017年1月16日
	*/
	@RequestMapping("/yundongjia/updateuserstatus")
	@ResponseBody
	public String updateUserStatus(Integer userId,Integer status,String comm){
		TUser user = new TUser();
		user.setUserid(userId);
		user.setIsvalid(status+"");
		 
		int r = userService.updateTuserById(user);
		
		TOpeartion opeartion = new TOpeartion();
		opeartion.setOpeartionAdminId(this.getLogUserId());
		opeartion.setOpeartionCom(comm);
		opeartion.setOpeartionType(ConstantVo.TYPE_ENTERPRISE_USER);
		opeartion.setOpeartionById(userId);
		if(status == 0){
			opeartion.setOpeartionInfo("启用用户");
		}else{
			opeartion.setOpeartionInfo("禁用用户");
		}
		
		int result = opeartionService.saveOpeartion(opeartion);
		return new Gson().toJson(r);
	}
	
	@RequestMapping("/yundongjia/findtuserbymp")
	@ResponseBody
	public String findTuserByMobilePhone(String mobilePhone,Integer cardId,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_5) Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		mapsJson =  userService.findTuserListByMobilePhone("%"+mobilePhone+"%", cardId);
		mapPageInfo = new PageInfo<>(mapsJson);
		
		return new Gson().toJson(mapPageInfo);
	}
	
	/**
	* Title: getCardTypeList
	* Description: 获取企业卡类型
	* @return
	* @author HuangJian
	* @date 2017年1月17日
	*/
	@RequestMapping("/yundongjia/getcardtypes")
	@ResponseBody
	public String getCardTypeList(){
		List<TCardType> list = enterpriseAndSelfCardService.findCardTypeByEnterType(null);
		return new Gson().toJson(list);
	}
	
	/**
	* Title: getTuserById
	* Description: 根据用户id查询详情
	* @param userId
	* @return
	* @author HuangJian
	* @date 2017年1月17日
	*/
	@RequestMapping("/yundongjia/gettuserbyid")
	public String getTuserById(Model model,Integer userId,Integer enterId,Integer cardId){
		resultMap=new HashMap<>();
		resultMaps = userService.getTuserById(userId);
		if(resultMaps !=null){
			resultMap = resultMaps.get(0);
		}
		model.addAttribute("user", resultMap);
		model.addAttribute("enterId", enterId);
		model.addAttribute("cardId", cardId);
		return "/systemmanage/enterprise/userDetail";
	}
	
	
	
	/**
	* Title: getValidMobilePhone
	* Description: 
	* @param mobilePhone  手机号码
	* @param tType  数据库表名称 0:用户t_user   1：场馆   2：教练  3：企业  4:（判断这个手机号码是否有企业卡）
	* @return
	* @author HuangJian
	* @date 2017年2月13日
	*/
	@RequestMapping("/yundongjia/getvalidmobilephone")
	@ResponseBody
	public String getValidMobilePhone(String mobilePhone,@RequestParam(defaultValue="0",required=true) Integer tType){
		
		Integer result = userService.getTuserMobilePhoneCount(mobilePhone,tType);
		
		return new Gson().toJson(result);
	}
	
	
}

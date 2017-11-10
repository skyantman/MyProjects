/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.service.ActivityOrderService;
import com.yundongjia.oa.admin.service.ActivityService;
import com.yundongjia.oa.admin.service.AttachService;
import com.yundongjia.oa.admin.service.CoachService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.RegionsService;
import com.yundongjia.oa.admin.service.StudioService;
import com.yundongjia.oa.admin.service.UploadExcelService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.FtpUtil;
import com.yundongjia.oa.utils.UtilHttpClient;

import net.sf.json.JSONObject;

@Controller
public class ActivityController extends BaseController{

	@Autowired
	private StudioService studioService;
	@Autowired
	private CoachService coachService;
	@Autowired
	private RegionsService regionsService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private OpeartionService opeartionService;
	@Autowired
	private ActivityOrderService activityOrderService;
	//活动相册
	@Autowired
	private AttachService attachService;
	@Autowired
	private UploadExcelService uploadExcelService;
	
	public List<Map<String, Object>> resultMaps;
	
	public PageInfo<Map<String, Object>> pageInfoMap;
	public Map<String, Object> param;
	/**
	* Title: listActivity
	* Description: 活动列表
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年1月19日
	*/
	@RequestMapping("/yundongjia/listactivity")
	public String listActivity(Model model,  @RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		TActivity activity = new TActivity();
		resultMaps = activityService.findActivityList(activity);
		
		pageInfoMap=new PageInfo<>(resultMaps);
		// 加载场馆
		List<TStudio> studios = studioService.findStudioList();
		// 加载教练
		List<TCoach> coachs = coachService.findCoachList();

		// 加载省
		List<TRegions> pros = regionsService.geTRegionsByProvince();

		
		Map<String, Object> statis =  activityService.selectActivityListStatis();
		
		model.addAttribute("studios", studios);
		model.addAttribute("coachs", coachs);
		model.addAttribute("pros", pros);
		model.addAttribute("activitys", pageInfoMap);
		model.addAttribute("statis", statis);
		return "/systemmanage/activity/activitylist";
	}
	
	/**
	* Title: searchActivity
	* Description: 多条件查询
	* @param model
	* @param activity
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月3日
	*/
	@RequestMapping("/yundongjia/selectactivity")
	@ResponseBody
	public String searchActivity(Model model, TActivity activity,  @RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		resultMaps = activityService.selectByActivity(activity);
		
		pageInfoMap=new PageInfo<>(resultMaps);
		
		 
		return new Gson().toJson(pageInfoMap);
	}
	
	/**
	* Title: toAddPage
	* Description: 去添加页面
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年1月19日
	*/
	@RequestMapping("/yundongjia/addactivity")
	public String toAddPage(Model model){
		
		//加载场馆
		List<TStudio> studios =  studioService.findStudioList();
		//加载教练
		List<TCoach> coachs =  coachService.findCoachList();
		
		//加载省
		List<TRegions> pros =  regionsService.geTRegionsByProvince();
		
		model.addAttribute("studios", studios);
		model.addAttribute("coachs", coachs);
		model.addAttribute("pros", pros);
		return "/systemmanage/activity/add";
	}
	 
	/**
	* Title: saveActivity
	* Description: 保存
	* @param activity
	* @param imgposition
	* @param img
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	@RequestMapping("/yundongjia/saveactivity")
	@ResponseBody
	public String saveActivity(TActivity activity,Integer [] imgposition,@RequestParam(value = "img", required = false) MultipartFile [] img){
		activity.setOpeartionadminid(this.getLogUserId());
		//先保存活动并返回主键
		Integer id = activityService.insertActivity(activity);
		String vPath=null;
		//保存图片
		TAttach attach = new TAttach();
		if(img.length > 0){
			attach.setProid(id);//活动id
			attach.setAttachtype(ConstantVo.ATTACH_TYPE_ACTIVITY);
			for(int i=0;i<img.length;i++){
				if(img[i].getSize() > 0){
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(img[i],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/activityImages/");
						attach.setPath(vPath);//图片路径
						attachService.insertAttach(attach,img[i]);
					} catch (Exception e) {
						 
					}
				}
				
				
			}
		}

		//操作记录
		TOpeartion pOpeartion =new TOpeartion();
		pOpeartion.setOpeartionAdminId(this.getLogUserId());
		pOpeartion.setOpeartionById(id);
		pOpeartion.setOpeartionType(ConstantVo.TYPE_ACTIVITY);
		pOpeartion.setOpeartionInfo("新增活动");
		 
		opeartionService.saveOpeartion(pOpeartion);
		
		return new Gson().toJson(id);
	}
	
	/**
	* Title: activityById
	* Description: 活动详情
	* @param activityId
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	@RequestMapping("/yundongjia/detailactivity")
	public String activityById(Model model,Integer activityId,Integer tab,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize,@RequestParam(required = true, defaultValue = "null") String mobilePhone){
		//操作记录
		List<Map<String, Object>> ops =  opeartionService.findOpeartion(ConstantVo.TYPE_ACTIVITY, activityId);
		
		//数据
		Map<String, Object> actives =  activityService.getActivityById(activityId);
		
		//相册
		List<TAttach> attachs =  attachService.getAttachByActivityId(activityId,ConstantVo.ATTACH_TYPE_ACTIVITY);
		
		//用户管理
		if(2 == tab){
			param = new HashMap<>();
			param.put("mobilePhoneNo", null);
			param.put("activityId", activityId);
			PageHelper.startPage(pageNum, pageSize);
			List<Map<String, Object>> users = activityOrderService.findActivityOrders(param);
			pageInfoMap=new PageInfo<>(users);
			
			Map<String, Object> statis =  activityOrderService.selectActivityOrderStatisByPayStatus();
			
			model.addAttribute("statis", statis);
			model.addAttribute("users", pageInfoMap);
		}else{
			pageInfoMap = new PageInfo<>();
			pageInfoMap.setPages(1);
			pageInfoMap.setPageNum(1);
			model.addAttribute("users", pageInfoMap);
		}
		
		
		model.addAttribute("ac", actives);
		model.addAttribute("tab", tab);
		model.addAttribute("ops", ops);
		model.addAttribute("imgs", attachs);
		return "/systemmanage/activity/detail";
	}
	
	/**
	* Title: editActivityById
	* Description: 去修改页面
	* @param activityId
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	@RequestMapping("/yundongjia/toeditactivity")
	public String editActivityById(Model model,Integer activityId){
		//活动数据
		Map<String, Object> data =  activityService.getActivityById(activityId);
		
		Integer aId = Integer.parseInt(String.valueOf(data.get("activeId")));
		List<TAttach> images =  attachService.getAttachByActivityId(aId,ConstantVo.ATTACH_TYPE_ACTIVITY);
		
		
		//加载省
		List<TRegions> pros =  regionsService.geTRegionsByProvince();
		
		//加载场馆
		List<TStudio> studios =  studioService.findStudioList();
		//加载教练
		List<TCoach> coachs =  coachService.findCoachList();
				
		model.addAttribute("studios", studios);
		model.addAttribute("coachs", coachs);
		model.addAttribute("act", data);
		model.addAttribute("pros", pros);
		model.addAttribute("activeImg", images);
		return "/systemmanage/activity/edit";
	}
	
	/**
	* Title: ActivityController.java
	* Description: 上传图片
	* @param mf 一张图片  主图
	* @param mfArray 多张图片  附图
	* @param attach 图片对象
	* @author HuangJian
	* @date 2017年4月24日
	*/
	public void saveAttachImage(MultipartFile mf,MultipartFile [] mfArray,TAttach attach){
		String vPath = null;
		if(mf.getSize() > 0){
			vPath = FtpUtil.uploadFile(mf, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/activityImages/");
			if(vPath !=null){
				attach.setPath(vPath);
				attach.setImgordernum(0);
				attachService.insertAttach(attach, mf);
			}
		}
		
		if(mfArray.length > 0){
			for (int i = 0; i < mfArray.length; i++) {
				MultipartFile multipartFile = mfArray[i];
				vPath = FtpUtil.uploadFile(multipartFile, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/activityImages/");
				if(vPath !=null){
					attach.setPath(vPath);
					attach.setImgordernum((i+1));
					attachService.insertAttach(attach, multipartFile);
				}
				
			}
		}
	}
	
	/**
	* Title: updateActivity
	* Description: 编辑活动
	* @param activity
	* @param img
	* @return
	* @author HuangJian
	* @date 2017年3月9日
	*/
	@RequestMapping("/yundongjia/updateactivity")
	@ResponseBody
	public String updateActivity(TActivity activity,
			@RequestParam(value = "img", required = false) MultipartFile [] img,
			@RequestParam(value="imgFirst",required=false) MultipartFile imgFirst){
		activity.setStatus(3);//未审核
		int result = activityService.updateActivityById(activity);
		
		
		// 操作记录
		TOpeartion pOpeartion = new TOpeartion();
		pOpeartion.setOpeartionAdminId(this.getLogUserId());
		pOpeartion.setOpeartionById(activity.getActiveid());
		pOpeartion.setOpeartionType(ConstantVo.TYPE_ACTIVITY);
		pOpeartion.setOpeartionInfo("编辑活动");
		opeartionService.saveOpeartion(pOpeartion);
		
		
		TAttach attach = new TAttach();
		attach.setProid(activity.getActiveid());
		attach.setAttachtype(ConstantVo.ATTACH_TYPE_ACTIVITY);
		Object [] objImg = null;
		if(img[0].getSize() > 0){
			//删除副图片
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(-1));
			
			//objImg = ArrayUtils.clone(img);
			saveAttachImage(null, img, attach);
		}
		if(imgFirst.getSize() > 0){
			//删除主图
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(0));
			
			//objImg = ArrayUtils.add(img, 0,imgFirst);
			saveAttachImage(imgFirst, null, attach);
		}
		
		/*String vPath="";
		if(objImg != null){
			if(objImg.length > 0){
				for (int i = 0; i < objImg.length; i++) {
					MultipartFile object = (MultipartFile) objImg[i];
					vPath = FtpUtil.uploadFile(object, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/activityImages/");
					if(vPath !=null){
						attach.setPath(vPath);
						attach.setImgordernum(i);
						attachService.insertAttach(attach, object);
					}
				}
			}
		}*/
		
		/*String vPath="";
		if(img !=null && img.length > 0 && img[0].getSize() > 0){
			TAttach attach = new TAttach();
			attach.setProid(activity.getActiveid());
			attach.setAttachtype(ConstantVo.ATTACH_TYPE_ACTIVITY);
			attachService.deleteAttachByPorIdAndAttachType(attach);
			for(int i=0;i<img.length;i++){
				try {
					vPath = FtpUtil.uploadFile(img[i], this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/activityImages/");
					if(vPath !=null){
						attach.setPath(vPath);
						attach.setImgordernum(i);
						attachService.insertAttach(attach, img[i]);
					}
				} catch (Exception e) {
					 
				}
			}
		}*/
		
		 
		
		return new Gson().toJson(activity.getActiveid());
	}
	
	/**
	* Title: updateActivityStatus
	* Description: 设置活动状态
	* @param status
	* @param activityId
	* @return
	* @author HuangJian
	* @date 2017年2月3日
	*/
	@RequestMapping("/yundongjia/updateactivitystatus")
	@ResponseBody
	public String updateActivityStatus(Integer status,Integer activityId){
		
		Integer result = activityService.updateActivityStatusById(status, activityId);
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(activityId);
		String str="";
		if(status == 0){
			str="生效";
		}else if(status == 1){
			str="禁用";
		}else if(status == 3){
			str="未审核";
		}
		op.setOpeartionInfo(str);
		op.setOpeartionType(ConstantVo.TYPE_ACTIVITY);
		opeartionService.saveOpeartion(op);
		return new Gson().toJson(result);
	}
	
	/**
	* Title: updateActivityOrderStatus
	* Description: 修改活动订单状态
	* @param status
	* @param actOrderId
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	@RequestMapping("/yundongjia/updateactivityorderstatus")
	@ResponseBody
	public String updateActivityOrderStatus(Integer status,Integer actOrderId){
		Integer result = 0;
		
		TActivityOrder activityOrder = new TActivityOrder();
		activityOrder.setOrderid(actOrderId);
		activityOrder.setPaystatus(String.valueOf(status));
		result = activityOrderService.updateActivityOrderById(activityOrder);
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/yundongjia/selectactiorderbymp")
	@ResponseBody
	public String findActivityOrderByMobilePhoneNum(String mobilePhoneNum,Integer activityId){
		param = new HashMap<>();
		param.put("mobilePhoneNum", "%"+mobilePhoneNum+"%");
		param.put("activityId", activityId);
		List<Map<String, Object>> list = activityOrderService.findActivityOrders(param);
		pageInfoMap = new PageInfo<>(list);
		
		return new Gson().toJson(pageInfoMap);
	}
	
}


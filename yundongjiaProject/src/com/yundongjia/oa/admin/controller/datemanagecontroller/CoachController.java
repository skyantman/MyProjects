/**
* @author HuangJian
* @date 2017年2月4日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
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
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachUser;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TSkill;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.service.AttachService;
import com.yundongjia.oa.admin.service.CoachService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.RegionsService;
import com.yundongjia.oa.admin.service.SkillService;
import com.yundongjia.oa.admin.service.StudioService;
import com.yundongjia.oa.admin.service.UploadExcelService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.FtpUtil;
@Controller
public class CoachController extends BaseController{

	
	@Autowired
	private RegionsService regionsService;
	@Autowired
	private StudioService studioService;
	@Autowired
	private OpeartionService opeartionService;
	@Autowired
	private CoachService coachService;
	@Autowired
	private AttachService attachService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private UploadExcelService uploadExcelService;
	
	public List<TRegions> listPro=null;
	public List<TSkill> skills;
	public List<Map<String, Object>> resultList;
	public PageInfo<Map<String, Object>> mapPageInfo;
	public Map<String, Object> param;
	/**
	* Title: listCoach
	* Description: 去全查页面
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/coachlist")
	public String listCoach(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		param=new HashMap<>();
		param.put("status", -1);
		param.put("regionsid", -1);
		param.put("nickname", null);
		param.put("skills", null);
		param.put("flag", 0);//0:不查skills 也不判断
		resultList= coachService.findCoachListLMap(param);
		mapPageInfo=new PageInfo<>(resultList);
		// 加载省
		listPro = regionsService.geTRegionsByProvince();
		
		// 加载擅长课程
		skills = skillService.findSkill();

		//统计
		Map<String, Object> statisMap =  coachService.selectStatisByCoach();
		model.addAttribute("statis", statisMap);
		model.addAttribute("skills", skills);
		model.addAttribute("pros", listPro);
		model.addAttribute("coachs", mapPageInfo);
		return "/systemmanage/coach/coachlist";
	}
	
	/**
	* Title: toAddCoach
	* Description: 去添加页面
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/toaddcoach")
	public String toAddCoach(Model model){
		
		// 加载省
		listPro = regionsService.geTRegionsByProvince();
		
		//加载场馆
		List<TStudio> studios =  studioService.findStudioList();
		
		//加载擅长课程
		skills = skillService.findSkill();
		
		model.addAttribute("skills", skills);
		model.addAttribute("pros", listPro);
		model.addAttribute("studios", studios);
		return "/systemmanage/coach/addcoach";
	}
	
	/**
	* Title: toUpdateCoach
	* Description: 去修改页面
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/toupdatecoach")
	public String toUpdateCoach(Model model,Integer coachId){
		
		Map<String, Object> coach =  coachService.getCoachById(coachId);
		String [] skillIds = new String[]{};
		if(coach !=null){
			String skString = String.valueOf(coach.get("skillids"));
			if(skString!=null || !"".equals(skString)){
				skillIds = skString.split(",");
			}
		}
		// 加载省
		listPro = regionsService.geTRegionsByProvince();
		
		//加载场馆
		List<TStudio> studios =  studioService.findStudioList();
		
		// 加载擅长课程
		skills = skillService.findSkill();

		
		List<TAttach> attachs =  attachService.getAttachByActivityId(coachId, ConstantVo.ATTACH_TYPE_COACH);
		
		model.addAttribute("co", coach);
		model.addAttribute("skills", skills);
		model.addAttribute("pros", listPro);
		model.addAttribute("studios", studios);
		model.addAttribute("chSkillArr", skillIds);
		model.addAttribute("coachImage", attachs);
		return "/systemmanage/coach/edit";
	}
	/**
	* Title: coachDetail
	* Description: 教练详情
	* @param model
	* @param coachId
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	@RequestMapping("/yundongjia/detailcoach")
	public String coachDetail(Model model,Integer coachId){
		
		Map<String, Object> coach =  coachService.getCoachById(coachId);
		
		List<Map<String, Object>> ops =  opeartionService.findOpeartion(ConstantVo.TYPE_COACH, coachId);
		
		List<TAttach> attachs =  attachService.getAttachByActivityId(coachId, ConstantVo.ATTACH_TYPE_COACH);
		model.addAttribute("ops", ops);
		model.addAttribute("co", coach);
		model.addAttribute("imgs", attachs);
		return "/systemmanage/coach/detail";
	}
	
	/**
	* Title: selectStudioTimeById
	* Description: 根据场馆id查询场馆开放时间
	* @param studioId
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	@RequestMapping("/yundongjia/selectstudiotime")
	@ResponseBody
	public String selectStudioTimeById(Integer studioId){
		String time="";
		Map<String, Object> studio =  studioService.selectStudioById(studioId);
		time=String.valueOf(studio.get("studioOpentime"));
		return new Gson().toJson(time);
	}
	
	/**
	* Title: saveCoach
	* Description: 保存教练
	* @param studioid 场馆ID
	* @param mobilePhone 教练手机号码
	* @param rewardName 奖项名称
	* @param rewardNum 奖项名次
	* @param img 图片
	* @param skills 擅长课程
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	@RequestMapping("/yundongjia/savecoach")
	@ResponseBody
	public String saveCoach(TCoach coach,Integer studioid,String mobilePhone,String [] rewardName,String [] rewardNum,@RequestParam(value = "img", required = false) MultipartFile [] img,Integer [] skills){
		
		Integer primaryKey=0;
		
		TCoachUser coachUser = new TCoachUser();
		coachUser.setMobilephoneno(mobilePhone);
		//保存  教练、教练用户、教练奖项、擅长课程 、场馆
		primaryKey = coachService.insertCoach(coach, coachUser,rewardName,rewardNum,skills,studioid);
		//上传教练相册
		if(img.length > 0){
			String vPath="";
			TAttach attach = new TAttach();
			attach.setProid(primaryKey);
			attach.setAttachtype(ConstantVo.ATTACH_TYPE_COACH);
			for (int i = 0; i < img.length; i++) {
				if(img[i].getSize() > 0){
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(img[i], this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/coachImages/");
						attach.setPath(vPath);
						attachService.insertAttach(attach,img[i]);
					} catch (Exception e) {
						 
					}
				}
				
			}
		}
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionInfo("新增教练");
		op.setOpeartionType(ConstantVo.TYPE_COACH);
		op.setOpeartionById(primaryKey);
		opeartionService.saveOpeartion(op);
		
		
		return new Gson().toJson(primaryKey);
	}
	public void saveAttachImage(MultipartFile mf,MultipartFile [] mfArray,TAttach attach){
		String vPath = null;
		if(null != mf){
			if(mf.getSize() > 0){
				try {
					vPath = FtpUtil.uploadFile(mf,this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/coachImages/");
					attach.setImgordernum(0);
					if(vPath !=null){
						
						attach.setPath(vPath);
					}
					attachService.insertAttach(attach, mf);
				} catch (Exception e) {
					 
				}
			}
		}
		
		if(mfArray != null){
			for (int i = 0; i < mfArray.length; i++) {
				MultipartFile multipartFile = mfArray[i];
				if(multipartFile.getSize() > 0){
					try {
						vPath = FtpUtil.uploadFile(multipartFile,this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/coachImages/");
						attach.setImgordernum((i+1));
						if(vPath !=null){
							
							attach.setPath(vPath);
						}
						attachService.insertAttach(attach, multipartFile);
					} catch (Exception e) {
						 
					}
				}
			}
		}
	}
	/**
	* Title: updateCoach
	* Description: 修改教练
	* @param coach
	* @param studioid
	* @param mobilePhone
	* @param rewardName
	* @param rewardNum
	* @param img
	* @param position
	* @param skills
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	@RequestMapping("/yundongjia/updatecoach")
	@ResponseBody
	public String updateCoach(TCoach coach,Integer studioid,String mobilePhone,String [] rewardName,String [] rewardNum,
			@RequestParam(value = "img", required = false) MultipartFile [] img,
			Integer [] position,Integer [] skills,
			@RequestParam(value="imgFrist",required=false) MultipartFile imgFrist){
		Map<String, Object> jsonMap=new HashMap<>();
		
		TCoachUser coachUser = new TCoachUser();
		coachUser.setMobilephoneno(mobilePhone);
		Integer result = coachService.updateCoach(coach, coachUser, rewardName, rewardNum, skills,studioid);
		//修改相册
		Object [] objImg=null;
		TAttach attach = new TAttach();
		attach.setProid(coach.getCoachid());
		attach.setAttachtype(ConstantVo.ATTACH_TYPE_COACH);
		
		if(img[0].getSize() > 0){
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(-1));
			
			saveAttachImage(null, img, attach);
			//objImg = ArrayUtils.clone(img);
		}
		if(imgFrist.getSize() > 0){
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(0));
			//objImg = ArrayUtils.add(img, 0,imgFrist);
			
			saveAttachImage(imgFrist, null, attach);
		}
		/*if(objImg != null){
			if(objImg.length > 0){
				String vPath="";
				for (int i = 0; i < objImg.length; i++) {
					MultipartFile object = (MultipartFile) objImg[i];
					try {
						vPath = FtpUtil.uploadFile(object,this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/coachImages/");
						attach.setImgordernum(i);
						if(vPath !=null){
							
							attach.setPath(vPath);
						}
						attachService.insertAttach(attach, object);
					} catch (Exception e) {
						 
					}
					
					
					
				}
			}
		}*/
		
		
		
		/*if(img != null){
			MultipartFile file0 = img[0];
			if(file0 !=null && file0.getSize() > 0){
				String vPath="";
				TAttach attach = new TAttach();
				attach.setProid(coach.getCoachid());
				attach.setAttachtype(ConstantVo.ATTACH_TYPE_COACH);
				attachService.deleteAttachByPorIdAndAttachType(attach);
				for (int i = 0; i < img.length; i++) {
					try {
						vPath = FtpUtil.uploadFile(img[i],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/coachImages/");
						attach.setImgordernum(i);
						if(vPath !=null){
							
							attach.setPath(vPath);
						}
					} catch (Exception e) {
						 
					}
					attachService.insertAttach(attach, img[i]);
				}
			}
		}*/
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionInfo("编辑教练");
		op.setOpeartionType(ConstantVo.TYPE_COACH);
		op.setOpeartionById(coach.getCoachid());
		opeartionService.saveOpeartion(op);
		
		jsonMap.put("result", result);
		jsonMap.put("id", coach.getCoachid());
		return new Gson().toJson(jsonMap);
	}
	
	
	@RequestMapping("/yundongjia/selectcoachsby")
	@ResponseBody
	public String findCoachListBy(TCoach coach,Integer [] skills,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		param=new HashMap<>();
		param.put("status", coach.getStatus());
		param.put("regionsid", coach.getRegionsid());
		param.put("nickname", coach.getNickname() == null || "".equals(coach.getNickname())?null:"%"+coach.getNickname()+"%");
		param.put("skills", skills);
		param.put("flag", 1);//0:不查skills 也不判断   1:条件查询擅长课程
		
		PageHelper.startPage(pageNum, pageSize);
		resultList =  coachService.findCoachListLMap(param);
		mapPageInfo = new PageInfo<>(resultList);
		return new Gson().toJson(mapPageInfo);
	}
	
	/**
	* Title: updateCoachStatus
	* Description: 设置状态
	* @param coachId
	* @param comm
	* @param status
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	@RequestMapping("/yundongjia/updatecoachstatus")
	@ResponseBody
	public String updateCoachStatus(Integer coachId,String comm,Integer status){
		TCoach coach = new TCoach();
		coach.setCoachid(coachId);
		coach.setStatus(status);
		Integer result = coachService.updateCoachStatusById(coach);
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionCom(comm);
		op.setOpeartionType(ConstantVo.TYPE_COACH);
		op.setOpeartionById(coachId);
		
		if(status == 0){
			op.setOpeartionInfo("启用");
		}else if(status == 1){
			op.setOpeartionInfo("禁用");
		}
		opeartionService.saveOpeartion(op);
		
		
		return new Gson().toJson(result);
	}
	
	 
	
}


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
import com.yundongjia.oa.admin.po.TFacility;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.service.AttachService;
import com.yundongjia.oa.admin.service.FacilityService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.RegionsService;
import com.yundongjia.oa.admin.service.StudioService;
import com.yundongjia.oa.admin.service.UploadExcelService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.FtpUtil;

@Controller
public class StudioController extends BaseController{
	
	@Autowired
	private RegionsService regionsService;
	public List<TRegions> listPro;
	@Autowired
	private FacilityService facilityService;
	@Autowired
	private StudioService studioService;
	@Autowired
	private AttachService attachService;
	@Autowired
	private OpeartionService opeartionService;
	@Autowired
	private UploadExcelService uploadExcelService;
	
	public Map<String, Object> mapJson;
	
	public PageInfo<Map<String, Object>> pageInfo;
	
	List<Map<String, Object>> stuidos=null;
	
	/**
	* Title: studioList
	* Description: 全查
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/studiolist")
	public String studioList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		TStudio studio = new TStudio();
		stuidos =  studioService.findStudioListMap(studio);
		pageInfo=new PageInfo<>(stuidos);
		
		listPro = regionsService.geTRegionsByProvince();
		
		Map<String, Object> statisMap =  studioService.selectStatisByStudioStatus();
		model.addAttribute("statis", statisMap);
		model.addAttribute("pros", listPro);
		model.addAttribute("stus", pageInfo);
		return "/systemmanage/studio/studiolist";
	}
	
	/**
	* Title: addstudio
	* Description: 去添加场馆页面
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/addstudio")
	public String addstudio(Model model){
	
		// 加载省
		listPro = regionsService.geTRegionsByProvince();

		
		//加载服务设施
		List<TFacility> facilities =  facilityService.findFacility();
		
		
		model.addAttribute("listPro", listPro);
		model.addAttribute("facs", facilities);
		return "systemmanage/studio/addstudio";
	}
	
	/**
	* Title: updateStudioToPage
	* Description: 去编辑页面
	* @param model
	* @param studioId
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/updatestudio")
	public String updateStudioToPage(Model model,Integer studioId){
		// 加载省
		listPro = regionsService.geTRegionsByProvince();

		// 加载服务设施
		List<TFacility> facilities = facilityService.findFacility();

		Map<String, Object> studio =  studioService.selectStudioById(studioId);
		
		//图片
		List<TAttach> atts =  attachService.getAttachByActivityId(studioId, ConstantVo.ATTACH_TYPE_STUDIO);
		
		String fac = String.valueOf(studio.get("studioEquip"));
		String [] facsArr = fac.split(",");
		model.addAttribute("equipsarr", facsArr);
		
		model.addAttribute("listPro", listPro);
		model.addAttribute("facs", facilities);
		model.addAttribute("s", studio);
		model.addAttribute("studioImg", atts);
		
		return "/systemmanage/studio/edit";
	}
	
	/**
	* Title: saveStudio
	* Description: 保存场馆
	* @param studio  
	* @param facilitys  服务设施
	* @param starttime  营业开始时间
	* @param endtime   营业结束时间
	* @param img   场馆图片
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/savestudio")
	@ResponseBody
	public String saveStudio(TStudio studio,
			@RequestParam(defaultValue="",required=true)String [] facilitys,String starttime, String endtime,
			@RequestParam(value = "img", required = false) MultipartFile [] img){
		mapJson=new HashMap<>();
		String facs = "";
		//服务设施
		if(facilitys.length > 0){
			
			for(int i =0;i<facilitys.length-1;i++){
				facs+=facilitys[i]+",";
			}
			facs+=facilitys[facilitys.length-1];
		}
		String time="";
		studio.setStudioequip(facs);
		if(null != starttime || !"".equals(starttime)){
			time=starttime+"~"+endtime;
			//开放时间
			studio.setStudioopentime(time);
		}
		
		//保存场馆
		Integer primaryKey =  studioService.saveStudio(studio);
		
		TAttach att = new TAttach();
		String vPath=null;
		//设置场馆图片
		if(img[0].getSize() > 0){
			att.setProid(primaryKey);
			att.setAttachtype(ConstantVo.ATTACH_TYPE_STUDIO);
			for(int i =0;i<img.length;i++){
				if(img[i].getSize() > 0){
					att.setImgordernum(i);	
					try {
						vPath = FtpUtil.uploadFile(img[i],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/studioImages/");
					
						att.setPath(vPath);
						
					} catch (Exception e) {
						 
					}
					attachService.insertAttach(att,img[i]);
				}
			}
		}
		
		//操作记录
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(primaryKey);
		op.setOpeartionInfo("新增场馆");
		op.setOpeartionType(ConstantVo.TYPE_STUDIO);
		opeartionService.saveOpeartion(op);
		
		mapJson.put("id", primaryKey);
		mapJson.put("opentime", time);
		return new Gson().toJson(mapJson);
	}
	
	/**
	* Title: updateStudioPrice
	* Description: 根据场馆修改场馆价格
	* @param studioId
	* @param price
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/updatestudioprice")
	@ResponseBody
	public String updateStudioPrice(Integer studioId,double price){
		mapJson = new HashMap<>();
		TStudio studio = new TStudio();
		studio.setStudioid(studioId);
		studio.setConsumemoney(price);
		Integer result = studioService.updateStudio(studio);
		mapJson.put("result", result);
		mapJson.put("id", studio.getStudioid());
		return new Gson().toJson(mapJson);
	}
	
	/**
	* Title: selectStudio
	* Description: 详情
	* @param model
	* @param studioId
	* @param tab
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/detailstudio")
	public String selectStudio(Model model,Integer studioId,Integer tab){
		
		Map<String, Object> studio =  studioService.selectStudioById(studioId);
		
		List<Map<String, Object>> ops  = opeartionService.findOpeartion(ConstantVo.TYPE_STUDIO, studioId);
		
		List<TAttach> atts =  attachService.getAttachByActivityId(studioId,ConstantVo.ATTACH_TYPE_STUDIO);
		model.addAttribute("imgs", atts);
		model.addAttribute("stu", studio);
		model.addAttribute("ops", ops);
		model.addAttribute("tab", tab);
		
		return "/systemmanage/studio/detail";
	}
	/**
	* Title: updateStudioByStatus
	* Description: 设置状态
	* @param id
	* @param status
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/updatestudiostatus")
	@ResponseBody
	public String updateStudioByStatus(Integer id ,Integer status,String comm){
		
		TStudio studio = new TStudio();
		studio.setStudioid(id);
		studio.setStatus(status);
		Integer result = studioService.updateStudio(studio);
		String str="";
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(id);
		op.setOpeartionCom(comm);
		op.setOpeartionType(ConstantVo.TYPE_STUDIO);
		switch (status) {
		case 0:
			str="启用/审核通过";
			break;
		case 1:
			str="禁用";
			break;
		case 2:
			str="未审核";
			break;
		default:
			break;
		}
		op.setOpeartionInfo(str);
		opeartionService.saveOpeartion(op);
		return new Gson().toJson(result);
	}
	
	
	/**
	* Title: findStudioBy
	* Description: 多条件查询
	* @param studio
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	@RequestMapping("/yundongjia/selectstudiobylist")
	@ResponseBody
	public String findStudioBy(TStudio studio,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> stuidos =  studioService.findStudioListMap(studio);
		pageInfo=new PageInfo<>(stuidos);
		
		
	 
		return new Gson().toJson(pageInfo);
	}
	/**
	* Title: StudioController.java
	* Description: 
	* @param mf  主图
	* @param mfArray  附图
	* @author HuangJian
	* @date 2017年4月21日
	*/
	public void saveAttachImage(MultipartFile mf,MultipartFile [] mfArray,TAttach attach){
		String vPath=null;
		//主图
		if(mf != null){
			if(mf.getSize() > 0){
				try {
					vPath = FtpUtil.uploadFile(mf, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/studioImages/");
					if (vPath != null) {
						attach.setImgordernum(0);
						attach.setPath(vPath);
						attachService.insertAttach(attach,mf);
					}
				} catch (Exception e) {
					 
				}
			}
		}
		//附图
		if(mfArray != null){
			try {
				for (int i = 0; i < mfArray.length; i++) {
					if(mfArray[i].getSize() > 0){
						vPath = FtpUtil.uploadFile(mfArray[i], this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/studioImages/");
						if (vPath != null) {
							attach.setImgordernum((i+1));
							attach.setPath(vPath);
							attachService.insertAttach(attach,mfArray[i]);
						}
					}
				}
			} catch (Exception e) {
				
			}
		}
		
	}
	/**
	* Title: updateStudio
	* Description: 编辑场馆
	* @param studio
	* @param img  图片
	* @param starttime 开始日期
	* @param endtime  结束日期
	* @param facilitys  服务设施
	* @return
	* @author HuangJian
	* @date 2017年2月22日
	*/
	@RequestMapping("/yundongjia/updatestudioinfo")
	@ResponseBody
	public String updateStudio(TStudio studio, 
			@RequestParam(value = "img", required = false) MultipartFile[] img, 
			String starttime, String endtime, String[] facilitys,
			@RequestParam(value="imgFirst",required=false) MultipartFile imgFirst) {
		mapJson = new HashMap<>();

		String facs = "";
		// 服务设施
		if (facilitys != null) {

			for (int i = 0; i < facilitys.length - 1; i++) {
				facs += facilitys[i] + ",";
			}
			facs += facilitys[facilitys.length - 1];
		}
		studio.setStudioequip(facs);
		String time = starttime + "~" + endtime;
		// 开放时间
		studio.setStudioopentime(time);

		Integer result = studioService.updateStudio(studio);

		// 修改图片
		TAttach attach = new TAttach();
		attach.setProid(studio.getStudioid());
		attach.setAttachtype(ConstantVo.ATTACH_TYPE_STUDIO);
		
		Object [] objImg = null;
		if(img[0].getSize() > 0){
			//删除副图
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(-1));
			//保存附图
			saveAttachImage(null, img, attach);
			
			//objImg = ArrayUtils.clone(img);
		}
		if(imgFirst.getSize() > 0){
			//删除主图
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(0));
			//保存主图
			saveAttachImage(imgFirst, null, attach);
			//objImg = ArrayUtils.add(img, 0,imgFirst);
		}
		/*if(objImg != null){
			if(objImg.length > 0){
				String vPath = "";
				for (int i = 0; i < objImg.length; i++) {
					MultipartFile object = (MultipartFile) objImg[i];
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(object, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/studioImages/");
						if (vPath != null) {
							attach.setPath(vPath);
							attachService.insertAttach(attach,object);
						}
					} catch (Exception e) {

					}
				}
			}
		}*/
		
		/*String vPath = "";
		if (img != null) {
			MultipartFile file0=img[0];
			if(file0 != null && file0.getSize() > 0){
				TAttach attach = new TAttach();
				attach.setProid(studio.getStudioid());
				attach.setAttachtype(ConstantVo.ATTACH_TYPE_STUDIO);
				attachService.deleteAttachByPorIdAndAttachType(attach);
				for (int i = 0; i < img.length; i++) {
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(img[i], this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/studioImages/");
						if (vPath != null) {
							attach.setPath(vPath);
							attachService.insertAttach(attach,img[i]);
						}
					} catch (Exception e) {

					}
				}
			}
			
		}*/

		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(studio.getStudioid());
		op.setOpeartionInfo("编辑场馆");
		op.setOpeartionType(ConstantVo.TYPE_STUDIO);
		opeartionService.saveOpeartion(op);

		mapJson.put("id", studio.getStudioid());
		mapJson.put("opentime", time);
		return new Gson().toJson(mapJson);
	}
	
	 
}
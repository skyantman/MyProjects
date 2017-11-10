/**
* @author HuangJian
* @date 2017年2月20日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;

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
import com.yundongjia.oa.admin.po.TInforMation;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.AttachService;
import com.yundongjia.oa.admin.service.InforMationService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.FileOpeartion;
import com.yundongjia.oa.utils.FtpUtil;
import com.yundongjia.oa.utils.UploadUtil;
@Controller
public class InforMationController extends BaseController{

	@Autowired
	private InforMationService inforMationService;
	@Autowired
	private OpeartionService opeartionService;
	@Autowired
	private AttachService attachService;
	
	public Map<String, Object> param;
	
	public List<Map<String, Object>> resultListMap;
	
	public PageInfo<Map<String, Object>> pageInfoMap;
	
	/**
	* Title: inforMationList
	* Description: 资讯列表
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/informationlist")
	public String inforMationList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		param=new HashMap<>();
		param.put("title", null);
		param.put("id", null);
		resultListMap = inforMationService.findInforMation(param);
		pageInfoMap=new PageInfo<>(resultListMap);
		
		
		model.addAttribute("res", pageInfoMap);
		
		return "/systemmanage/infomation/list";
	}
	
	/**
	* Title: toInfoMationAddPage
	* Description: 去资讯添加页面
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/toaddinformation")
	public String toInfoMationAddPage(Model model){
		
		
		return "/systemmanage/infomation/add";
	}
	
	/**
	* Title: saveInfoMation
	* Description: 保存资讯
	* @param mode
	* @param inforMation
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/saveinformation")
	@ResponseBody
	public String saveInfoMation(Mode mode,TInforMation inforMation,@RequestParam(required=true,value="imgs") MultipartFile [] imgs){
		 
		Integer rowId = inforMationService.saveInforMation(inforMation);
		String path = FileOpeartion.write(inforMation.getInfocontext(), "information/"+inforMation.getRowid());
		inforMation.setPath(path);
		inforMation.setRowid(inforMation.getRowid());
		inforMationService.updateInfoMation(inforMation);
		if(imgs.length > 0){
			String vPath="";
			TAttach attach = new TAttach();
			attach.setProid(rowId);
			attach.setAttachtype(ConstantVo.ATTACH_TYPE_INFOR_MATION);
			for(int i=0;i<imgs.length;i++){
				if(imgs[i].getSize() > 0){
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(imgs[i],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/informationImages/");
						attach.setPath(vPath);
					} catch (Exception e) {
						
					}
					attachService.insertAttach(attach, imgs[i]);
				}
			}
			
		}
		
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(rowId);
		op.setOpeartionInfo("新增资讯");
		op.setOpeartionType(ConstantVo.TYPE_INFOR_MATION);
		opeartionService.saveOpeartion(op);
		return new Gson().toJson(rowId);
	}
	
	/**
	* Title: informationdetail
	* Description: 资讯详情
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/informationdetail")
	public String informationdetail(Model model,Integer id){
		
		param=new HashMap<>();
		param.put("id", id);
		param.put("title", null);
		resultListMap =  inforMationService.findInforMation(param);
		
		List<TAttach> attachs =  attachService.getAttachByActivityId(id, ConstantVo.ATTACH_TYPE_INFOR_MATION);
		
		if(resultListMap!=null || resultListMap.size()>0){
			model.addAttribute("info", resultListMap.get(0));
			model.addAttribute("imgs", attachs);
		}
		
		
		List<Map<String, Object>> ops =  opeartionService.findOpeartion(ConstantVo.TYPE_INFOR_MATION, id);
		
		
		model.addAttribute("ops", ops);
		
		return "/systemmanage/infomation/detail";
	}
	
	/**
	* Title: informationsearch
	* Description: 条件查询模糊
	* @param model
	* @param pageNum
	* @param pageSize
	* @param strContext  标题或正文模糊
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/selectinformationbytc")
	@ResponseBody
	public String inforMationSearch(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize,@RequestParam(required=true,defaultValue="") String strContext){
		param=new HashMap<>();
		param.put("id", null);
		param.put("title", "%"+strContext+"%");
		PageHelper.startPage(pageNum, pageSize);
		resultListMap =  inforMationService.findInforMation(param);
		pageInfoMap=new PageInfo<>(resultListMap);
		return new Gson().toJson(pageInfoMap);
	}
	
	/**
	* Title: updateInforMationStatus
	* Description: 修改状态
	* @param id  主键
	* @param status  状态
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/updateinformationstatus")
	@ResponseBody
	public String updateInforMationStatus(Integer id,Integer status){
		Integer result = 0;
		TInforMation inforMation=new TInforMation();
		inforMation.setRowid(id);
		inforMation.setStatus(status);
		result = inforMationService.updateInfoMation(inforMation);
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(id);
		op.setOpeartionInfo(status==0?"启用":"禁用");
		op.setOpeartionType(ConstantVo.TYPE_INFOR_MATION);
		opeartionService.saveOpeartion(op);
		return new Gson().toJson(result);
	}
	
	
	/**
	* Title: toupdatepage
	* Description: 去修改页面
	* @param model
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/toupdatepage")
	public String toAddInforMationPage(Model model,Integer id){
		param=new HashMap<>();
		param.put("id", id);
		List<Map<String, Object>> list = inforMationService.findInforMation(param);
		if(list !=null && list.size()>0){
			model.addAttribute("info", list.get(0));
		}
		
		List<TAttach> attachs =  attachService.getAttachByActivityId(id, ConstantVo.ATTACH_TYPE_INFOR_MATION);
		
		model.addAttribute("imgs", attachs);
		
		return "/systemmanage/infomation/edit";
	}
	
	/**
	* Title: updateInforMation
	* Description: 编辑资讯
	* @param inforMation
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	@RequestMapping("/yundongjia/updateinformation")
	@ResponseBody
	public String updateInforMation(TInforMation inforMation,@RequestParam(required=true,value="imgs") MultipartFile [] imgs){
		param=new HashMap<>();
		
		String path = FileOpeartion.write(inforMation.getInfocontext(), "information/"+inforMation.getRowid());
		inforMation.setPath(path);
		Integer result = inforMationService.updateInfoMation(inforMation);
		
		if(imgs != null && imgs.length>0){
			MultipartFile file0=imgs[0];
			if(file0.getSize() > 0){
				TAttach attach = new TAttach();
				attach.setProid(inforMation.getRowid());
				attach.setAttachtype(ConstantVo.ATTACH_TYPE_INFOR_MATION);
				attachService.deleteAttachByPorIdAndAttachType(attach);
				
				String vPath="";
				for(int i=0;i<imgs.length;i++){
					attach.setAttachtype(ConstantVo.ATTACH_TYPE_INFOR_MATION);
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(imgs[i],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/informationImages/");
					} catch (Exception e) {
						 
					}
					attach.setPath(vPath);
					attachService.insertAttach(attach, imgs[i]);
				}
			}
			
		}
		
		
		TOpeartion op =new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(inforMation.getRowid());
		op.setOpeartionInfo("编辑资讯");
		op.setOpeartionType(ConstantVo.TYPE_INFOR_MATION);
		opeartionService.saveOpeartion(op);
		
		param.put("id", inforMation.getRowid());
		param.put("result", result);
		return new Gson().toJson(param);
	}
	
}


/**
* @author HuangJian
* @date 2017年2月28日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.ApplyService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.vo.ConstantVo;

@Controller
public class ApplyController extends BaseController{

	@Autowired
	private ApplyService applyService;
	@Autowired
	private OpeartionService opeartionService;
	
	public PageInfo<Map<String, Object>> pageInfo;
	public List<Map<String, Object>> list;
	Map<String, Object> statisMap;
	public Map<String, Object> param;
	/**
	* Title: appliList
	* Description: 全查
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	@RequestMapping("/yundongjia/applylist")
	public String appliList(Model model,  @RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize) {
		param=new HashMap<>();
		param.put("id", "");
		param.put("startDate", "");
		param.put("endDate", "");
		param.put("mobilePhoneNum", "");
		param.put("applyStatus", -1);
		PageHelper.startPage(pageNum, pageSize);
		list =  applyService.findApplyList(param);
		pageInfo=new PageInfo<>(list);
		
		statisMap=applyService.selectApplyStatis();
				
		
		model.addAttribute("appliys", pageInfo);
		model.addAttribute("statis", statisMap);
		return "/systemmanage/finance/withdrawdepositlist";
	}
	
	/**
	* Title: selectApplyBySearchList
	* Description: 多条件查询
	* @param pageNum
	* @param pageSize
	* @param startDate 提现开始时间
	* @param endDate  提现结束时间
	* @param mobilePhoneNum  手机号
	* @param applyStatus  提现状态
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	@RequestMapping("/yundongjia/applysearch")
	@ResponseBody
	public String selectApplyBySearchList(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize,@RequestParam(defaultValue="",required=true) String startDate, 
			@RequestParam(defaultValue="",required=true) String endDate,
			@RequestParam(defaultValue="",required=true) String mobilePhoneNum,Integer applyStatus){
		param=new HashMap<>();
		param.put("id", null);
		if(!"".equals(startDate)){
			startDate += " 00:00:00";
		}
		param.put("startDate", startDate);
		if(!"".equals(endDate)){
			endDate += " 59:59:59";
		}
		param.put("endDate", endDate);
		if(!"".equals(mobilePhoneNum)){
			mobilePhoneNum  =   "%"+ mobilePhoneNum +"%";
		}
		param.put("mobilePhoneNum", mobilePhoneNum);
		param.put("applyStatus", applyStatus);
		PageHelper.startPage(pageNum, pageSize);
		list=applyService.findApplyList(param);
		pageInfo=new PageInfo<>(list);
		return new Gson().toJson(pageInfo);
	}
	
	/**
	* Title: updateApplyStatus
	* Description: 修改提现状态
	* @param id 提现ID 
	* @param status 提现状态  0:处理中     1:已提现 2:取消提现         0 生效 1 禁用
	* @param flag 0:applyStatus提现状态(确定提现)    1:status状态(启用禁用)   2:取消提现
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	@RequestMapping("/yundongjia/updatestatus")
	@ResponseBody
	public String updateApplyStatus(Integer id,Integer status,@RequestParam(defaultValue="0",required=true) Integer flag){
		param=new HashMap<>();
		param.put("id", id);

		TApply apply=new TApply();
		apply.setRowid(id);
		Map<String, Object> map = null ;
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(id);
		op.setOpeartionById(id);
		op.setOpeartionType(ConstantVo.TYPE_APPLY);
		Integer result =0;
		if(0 == flag){//确定提现
			apply.setApplystatus(String.valueOf(status));
			map=  applyService.updateApplyById(apply);
			op.setOpeartionInfo("确定提现");
			op.setOpeartionCom("提现金额:"+map.get("applyMoney")+" 提现结果:"+map.get("message"));
			opeartionService.saveOpeartion(op);
			return new Gson().toJson(map);
		}else if(1 == flag){// 启用-禁用
			map=new HashMap<>();
			apply.setStatus(String.valueOf(status));
			
			result = applyService.updateApplyStatusById(apply);
			
			if(0 == status){
				op.setOpeartionInfo("启用");
			}else if(1 == status){
				op.setOpeartionInfo("禁用");
			}else{
				
			}
			
		}else if(2 == flag){//取消提现
			map=new HashMap<>();
			apply.setApplystatus(String.valueOf(status));
			result = applyService.updateApplyStatusById(apply);
			/*map.put("result", result);
			if(result > 0){
				map.put("message", "操作成功");
			}else{
				map.put("message", "操作失败");
			}*/
			op.setOpeartionInfo("取消提现");
		}else{
			
		}
		
		opeartionService.saveOpeartion(op);
		
		map.put("result", result);
		if(result > 0){
			map.put("message", "操作成功");
		}else{
			map.put("message", "操作失败");
		}
		return new Gson().toJson(map);
		
		
		 
		
	}
	
	
	/**
	* Title: applyDetail
	* Description: 提现详情
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	@RequestMapping("/yundongjia/applydetail")
	public String applyDetail(Model model,Integer id){
		param=new HashMap<>();
		param.put("id", id);
		param.put("startDate", "");
		param.put("endDate", "");
		param.put("mobilePhoneNum", "");
		param.put("applyStatus", -1);
		list = applyService.findApplyList(param);
		
		List<Map<String, Object>> ops = opeartionService.findOpeartion(ConstantVo.TYPE_APPLY, id);
		model.addAttribute("a", list.get(0));
		model.addAttribute("ops", ops);
		return "/systemmanage/finance/withdrawdepositdetail";
	}
	
	
	
	
}


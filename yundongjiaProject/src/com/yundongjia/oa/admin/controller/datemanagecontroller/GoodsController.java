/**
* @author HuangJian
* @date 2017年2月7日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsStandard;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.AttachService;
import com.yundongjia.oa.admin.service.GoodsService;
import com.yundongjia.oa.admin.service.GoodsStandardService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.UploadExcelService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.FileOpeartion;
import com.yundongjia.oa.utils.FtpUtil;
import com.yundongjia.oa.utils.UploadUtil;

@Controller
public class GoodsController extends BaseController{

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OpeartionService opeartionService;
	@Autowired
	private AttachService attachService;
	@Autowired
	private GoodsStandardService goodsStandardService;
	@Autowired
	private UploadExcelService uploadExcelService;
	
	public PageInfo<Map<String, Object>> mapPageInfo;
	
	public List<Map<String, Object>> list;
	/**
	* Title: goodsList
	* Description: 商品列表
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	@RequestMapping("/yungongjia/goodslist")
	public String goodsList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		TGoods goods = new TGoods();
		list = goodsService.findGoodsList(goods);
		mapPageInfo = new PageInfo<>(list);
		
		Map<String, Object> statis =  goodsService.selectGoodsStatus();
		model.addAttribute("gs", mapPageInfo);
		model.addAttribute("statis", statis);
		return "/systemmanage/goods/goodslist";
	}
	
	/**
	* Title: addGoodsPage
	* Description: 去添加页面
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	@RequestMapping("/yungongjia/addgoodstopage")
	 public String addGoodsPage(Model model){
		// 规格
		List<Map<String, Object>> maps = goodsStandardService.findGoodsStandard();
		Map<String, Object> temp = new HashMap<>();
		temp = maps.get(0);
		String colors = String.valueOf(temp.get("standard"));
		String[] colorsArr = colors.split(",");
		
		 temp = maps.get(1);
		 String sizes =String.valueOf(temp.get("standard"));
		 String [] sizesArr=sizes.split(",");
		 
		 model.addAttribute("colors", colorsArr);
		 model.addAttribute("sizes", sizesArr);
		 return "/systemmanage/goods/goodsadd";
	 }
	
	/**
	* Title: selectGoodsById
	* Description: 商品详情
	* @param goodsId
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	@RequestMapping("/yundongjia/goodsdetail")
	public String selectGoodsById(Model model,Integer goodsId){
		Map<String, Object> good = goodsService.selectGoodsById(goodsId);
		List<Map<String, Object>> ops =  opeartionService.findOpeartion(ConstantVo.TYPE_GOODS, goodsId);
		
		List<TAttach> imgs =  attachService.getAttachByActivityId(goodsId, ConstantVo.ATTACH_TYPE_GOODS);
		model.addAttribute("good", good);
		model.addAttribute("ops", ops);
		model.addAttribute("imgs", imgs);
		return "/systemmanage/goods/goodsdetail";
	}
	
	/**
	* Title: updateGoodsPage
	* Description: 去商品修改页面
	* @param goodsId
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	@RequestMapping("/yundongjia/updategoodstopage")
	public String updateGoodsPage(Model model,Integer goodsId){
		
		Map<String, Object> good = goodsService.selectGoodsById(goodsId);
		List<TAttach> attachs =  attachService.getAttachByActivityId(goodsId, ConstantVo.ATTACH_TYPE_GOODS);
		
		// 所有规格
		List<Map<String, Object>> maps = goodsStandardService.findGoodsStandard();
		Map<String, Object> temp = new HashMap<>();
		temp = maps.get(0);
		String colors = String.valueOf(temp.get("standard"));
		String [] colorsArr = colors.split(",");

		temp = maps.get(1);
		String sizes = String.valueOf(temp.get("standard"));
		String[] sizesArr = sizes.split(",");
		//----------全部规格
		model.addAttribute("colors", colorsArr);
		model.addAttribute("sizes", sizesArr);
		//---------
		String chColorArr [] = new String[]{};
		String chSizeArr [] =new String[]{};
		//----选中的规格
		String chStrColor = String.valueOf(good.get("strColor"));
		if(null !=chStrColor){
			chColorArr=chStrColor.split(",");
		}
		String chStrSize=String.valueOf(good.get("strSize"));
		if(null != chStrSize){
			chSizeArr = chStrSize.split(",");
		}
		//-------------
		model.addAttribute("chColors", chColorArr);
		model.addAttribute("chSizes", chSizeArr);
		
		model.addAttribute("g", good);
		model.addAttribute("goodsImg", attachs);
		
		
		return "/systemmanage/goods/goodsedit";
	}
	
	 
	/**
	* Title: saveGoods
	* Description:  保存商品
	* @param goods
	* @param imgs
	* @param colors 颜色
	* @param sizes 尺码
	* @return
	* @author HuangJian
	* @date 2017年2月11日
	*/
	@RequestMapping("/yundongjia/savegoods")
	@ResponseBody
	public String saveGoods(TGoods goods,@RequestParam(value = "imgs", required = false) MultipartFile [] imgs,
			String [] colors,String [] sizes) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		goods.setCreatedate(sdf.format(new Date()));
		Integer goodId = goodsService.saveGoods(goods);
		
		String path = FileOpeartion.write(goods.getDes(), "goods/"+goods.getGoodsid());
		goods.setPath(path);
		goods.setGoodsid(goods.getGoodsid());
		goodsService.updateGoods(goods);
		//保存规格
		TGoodsStandard goodsStandard = new TGoodsStandard();
		goodsStandard.setGoodsid(goodId);
		String strSize="";
		if(sizes !=null && sizes.length > 0){
			for (int i = 0; i < sizes.length-1; i++) {
				strSize+=sizes[i]+",";
			}
			strSize+=sizes[sizes.length-1];
			
			//保存尺码
			goodsStandard.setType(1);
			goodsStandard.setStandard(strSize);
			goodsStandardService.insertGoodsStandard(goodsStandard);
			
		}
		String strColor="";
		if(colors != null && colors.length>0){
			for (int i = 0; i < colors.length-1; i++) {
				strColor+=colors[i]+",";
			}
			strColor+=colors[colors.length-1];
			
			//保存颜色
			goodsStandard.setType(0);
			goodsStandard.setStandard(strColor);
			goodsStandardService.insertGoodsStandard(goodsStandard);
			
		}
		
		
	
		if(imgs != null && imgs.length > 0){
			String vPath="";
			TAttach attach = new TAttach();
			attach.setAttachtype(ConstantVo.ATTACH_TYPE_GOODS);
			attach.setProid(goods.getGoodsid());
			for (int i = 0; i < imgs.length; i++) {
				if(imgs[i].getSize() > 0){
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(imgs[i],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/goodImages/");
						attach.setPath(vPath);
					} catch (Exception e) {
						 
					}
					
					attachService.insertAttach(attach,imgs[i]);
				}
			}
		}
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(goodId);
		op.setOpeartionType(ConstantVo.TYPE_GOODS);
		op.setOpeartionInfo("创建商品");
		opeartionService.saveOpeartion(op);
		
		
		
		
		return new Gson().toJson(goodId);
	}
	/**
	* Title: GoodsController.java
	* Description: 保存图片
	* @param mf 一张图片
	* @param mfArray 多张图片
	* @param attach
	* @author HuangJian
	* @date 2017年4月24日
	*/
	public void saveAttachImage(MultipartFile mf,MultipartFile [] mfArray,TAttach attach){
		String vPath="";
		if(mf.getSize() > 0){
			attach.setImgordernum(0);
			try {
				vPath = FtpUtil.uploadFile(mf, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/goodImages/");
				if(vPath != null){
					attach.setPath(vPath);
				}
				attachService.insertAttach(attach,mf);
			} catch (Exception e) {
				 
			}
			 
		}
		
		if(mfArray.length > 0){
			for (int i = 0; i < mfArray.length; i++) {
				MultipartFile multipartFile = mfArray[i];
				if(multipartFile.getSize() > 0){
					attach.setImgordernum((i+1));
					try {
						vPath = FtpUtil.uploadFile(multipartFile, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/goodImages/");
						if(vPath != null){
							attach.setPath(vPath);
						}
						attachService.insertAttach(attach,multipartFile);
					} catch (Exception e) {
						 
					}
						
				}
			}
		}
	}
	/**
	* Title: updateGoods
	* Description: 修改商品信息
	* @param goods 商品
	* @param imgs 图片
	* @param position 图片位置
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	@RequestMapping("/yundongjia/updategoods")
	@ResponseBody
	public String updateGoods(TGoods goods,
			@RequestParam(value = "imgs", required = false) MultipartFile [] imgs,
			String [] colors,String [] sizes,
			@RequestParam(value="imgFirst",required=false) MultipartFile imgFirst){
		
		Map<String, Object> map=new HashMap<>();
		map.put("id", goods.getGoodsid());
		goods.setStatus(2);//未审核
		String path = FileOpeartion.write(goods.getDes(), "goods/"+goods.getGoodsid());
		goods.setPath(path);
		Integer res = goodsService.updateGoods(goods);
		map.put("msg", res);
		TGoodsStandard gStandard = new TGoodsStandard();
		gStandard.setGoodsid(goods.getGoodsid());//商品ID
		//删除商品之前的规格
		goodsStandardService.deleteGoodsStandardByGoodsId(goods.getGoodsid());
		if(colors != null && colors.length>0){
			String strColor="";
			for (int i = 0; i < colors.length-1; i++) {
				strColor += colors[i]+",";
			}
			strColor+=colors[colors.length-1];
			gStandard.setStandard(strColor);
			gStandard.setType(0);
			goodsStandardService.insertGoodsStandard(gStandard);
		}
		
		
		if(sizes != null && sizes.length > 0){
			String strSize="";
			for (int i = 0; i < sizes.length-1; i++) {
				strSize+=sizes[i]+",";
			}
			strSize += sizes[sizes.length-1];
			gStandard.setStandard(strSize);
			gStandard.setType(1);
			goodsStandardService.insertGoodsStandard(gStandard);
		}
		
		//图片
		Object [] objImg=null;
		TAttach attach = new TAttach();
		attach.setProid(goods.getGoodsid());
		attach.setAttachtype(ConstantVo.ATTACH_TYPE_GOODS);
		
		if(imgs[0].getSize() > 0){
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(-1));
			
			//objImg = ArrayUtils.clone(imgs);
			saveAttachImage(null, imgs, attach);
		}
		if(imgFirst.getSize() > 0){
			attachService.deleteAttachByPorIdAndAttachType(attach,ConstantVo.getImageIndexs(0));
			
			//objImg = ArrayUtils.add(imgs, 0,imgFirst);
			saveAttachImage(imgFirst, null, attach);
		}
		/*if(objImg != null){
			if(objImg.length > 0){
				String vPath="";
				for (int i = 0; i < objImg.length; i++) {
					MultipartFile object = (MultipartFile) objImg[i];
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(object, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/goodImages/");
						if(vPath != null){
							attach.setPath(vPath);
						}
						attachService.insertAttach(attach,object);
					} catch (Exception e) {
						 
					}
					
				}
			}
		}*/
		
		/*if(imgs != null && imgs.length > 0){
			MultipartFile file0 = imgs[0];//如果上传图片不选的话默认有一个元素，size=0
			if(file0.getSize() > 0){
				String vPath="";
				TAttach attach = new TAttach();
				attach.setProid(goods.getGoodsid());
				attach.setAttachtype(ConstantVo.ATTACH_TYPE_GOODS);
				attachService.deleteAttachByPorIdAndAttachType(attach);
				for (int i = 0; i < imgs.length; i++) {
					attach.setImgordernum(i);
					try {
						vPath = FtpUtil.uploadFile(imgs[i], this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/goodImages/");
						if(vPath != null){
							attach.setPath(vPath);
						}
						
					} catch (Exception e) {
						 
					}
					attachService.insertAttach(attach, imgs[i]);
				}
			}
		}*/
		
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(goods.getGoodsid());
		op.setOpeartionType(ConstantVo.TYPE_GOODS);
		op.setOpeartionInfo("编辑商品");
		opeartionService.saveOpeartion(op);

		
		
		return new Gson().toJson(map);
	}
	
	/**
	* Title: updateGoodsStatus
	* Description: 设置商品状态
	* @param goodsId
	* @param status
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	@RequestMapping("/yundongjia/updategoodsstatus")
	@ResponseBody
	public String updateGoodsStatus(Integer goodsId,Integer status){
		TGoods goods = new TGoods();
		goods.setStatus(status);
		goods.setGoodsid(goodsId);
		Integer res = goodsService.updateGoods(goods);
		
		TOpeartion op = new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(goodsId);
		if(0 == status){
			op.setOpeartionInfo("启用");
		}else if(1 == status){
			op.setOpeartionInfo("禁用");
		}else if(2 == status){
			op.setOpeartionInfo("审核通过");
		}
		op.setOpeartionType(ConstantVo.TYPE_GOODS);
		opeartionService.saveOpeartion(op);
		return new Gson().toJson(res);
	}
	
	/**
	* Title: selectGoodsByName
	* Description: 条件查询
	* @param gName
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	@RequestMapping("/yundongjia/selectgoodsbyname")
	@ResponseBody
	public String selectGoodsByName(String gName,@RequestParam(required = true, defaultValue = "1") Integer pageNum,@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		TGoods goods = new TGoods();
		goods.setGname("%"+gName+"%");
		list = goodsService.findGoodsList(goods);
		mapPageInfo = new PageInfo<>(list);
		
		return new Gson().toJson(mapPageInfo);
	}

}


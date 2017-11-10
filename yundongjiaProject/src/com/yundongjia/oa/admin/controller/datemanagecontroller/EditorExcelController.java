/**
* @author HuangJian
* @date 2017年2月28日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.service.ActivityService;
import com.yundongjia.oa.admin.service.CoachService;
import com.yundongjia.oa.admin.service.EnterpriseService;
import com.yundongjia.oa.admin.service.GoodsService;
import com.yundongjia.oa.admin.service.OrderService;
import com.yundongjia.oa.admin.service.StudioService;
import com.yundongjia.oa.admin.service.UploadExcelService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.OrderSearchVo;
import com.yundongjia.oa.utils.FtpUtil;
@Controller
public class EditorExcelController extends BaseController{

	@Autowired
	private UploadExcelService uploadExcelService;
	
	/**
	* Title: editorUpload
	* Description: 富文本上传图片
	* @param file
	* @return
	* @author HuangJian
	* @date 2017年3月17日
	*/
	@RequestMapping("/yundongjia/editoruploadimgs")
	@ResponseBody
	public String editorUpload(@RequestParam(value = "file", required = false) MultipartFile [] file){
		Map<String, Object> map = new HashMap<>();
		
		if(file != null && file.length > 0 && file[0].getSize() > 0){
			 MultipartFile mf = file[0];
			 String ct = mf.getContentType();
			 String regex="\\/(jpeg)|(jpg)|(png)|(gif)|(JPEG)|(JPG)|(PNG)|(GIF)";
			 Pattern pattern = Pattern.compile(regex);
			 Matcher matcher =  pattern.matcher(ct);
			 String result = "";
			 if(matcher.find()){
				result = FtpUtil.uploadFile(file[0],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/messageImages/");
					
				String path = this.selectConfigVal("IMAGE_VIEW_URL_BEFORE")+result;
					
				map.put("link", path);
			 }else{
			 } 
		}
		return new Gson().toJson(map);
	}
	
	/**
	* Title: editorDeleteImage
	* Description: 富文本删除图片
	* @param src
	* @return
	* @author HuangJian
	* @date 2017年3月17日
	*/
	@RequestMapping("/yundongjia/editordelimg")
	@ResponseBody
	public String editorDeleteImage(String src){
		boolean b=false;
		try {
			if(src != null || !"".equals(src)){
				String n =src.substring(src.indexOf("/images"), src.length());
				if(n != null || !"".equals(n)){
					b = FtpUtil.removeFile(n);
				}
			}
		} catch (Exception e) {
			
		}
		return new Gson().toJson(b);
	}
	
	/**
	* Title: goodsUpload
	* Description: 所有的富文本图片上传位置
	* @param weditorimgs
	* @return
	* @author HuangJian
	* @date 2017年2月25日
	*/
	/*@Deprecated
	@RequestMapping("/yundongjia/editoruploadimgs")
	@ResponseBody
	public String editorUpload(@RequestParam(value = "weditorimgs", required = false) MultipartFile [] weditorimgs){
		Map<String, Object> map = new HashMap<>();
		String result="";
		if(weditorimgs != null && weditorimgs.length > 0  && weditorimgs[0].getSize() > 0){
			for(int i=0;i<weditorimgs.length;i++){
				try {
					MultipartFile file = weditorimgs[i];
					result = FtpUtil.uploadFile(weditorimgs[i],this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/messageImages/");
					
					String path = this.selectConfigVal("IMAGE_VIEW_URL_BEFORE")+result;
					
					map.put("path", path);
					BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
					
					map.put("width", bufferedImage.getWidth());
					map.put("height", bufferedImage.getHeight());
				} catch (IOException e) {
					
				}
			}
		}
		 
		return new Gson().toJson(map);
	}*/
	@Autowired
	private ActivityService activityService;
	@Autowired
	private StudioService studioService;
	@Autowired
	private CoachService coachService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private EnterpriseService enterpriseService;
	/**
	* Title: excelExportAll
	* Description: 所有的导出excel都在这里
	* @param type 0：活动，1：场馆，2：教练，3：商品，4：订单，5：退订订单 6：企业
	* @author HuangJian
	* @date 2017年3月7日
	*/
	@RequestMapping("/yundongjia/exportall")
	public void excelExportAll(Integer type){
		List<Map<String, Object>> maps;
		maps=new ArrayList<>();
		Map<String, Object> param;
		OrderSearchVo orderSearchVo;
		switch (type) {
		case 0:
			TActivity activity = new TActivity();
			maps = activityService.findActivityList(activity);
			break;
		case 1:
			TStudio studio = new TStudio();
			maps = studioService.findStudioListMap(studio);
			break;
		case 2:
			param=new HashMap<>();
			param.put("status", -1);
			param.put("regionsid", -1);
			param.put("nickname", null);
			param.put("skills", null);
			param.put("flag", 0);
			maps = coachService.findCoachListLMap(param);
			break;
		case 3:
			TGoods goods = new TGoods();
			maps = goodsService.findGoodsList(goods);
			break;
		case 4:
			orderSearchVo = new OrderSearchVo();
			orderSearchVo.setOrderMenuType(ConstantVo.ORDER_MENU_TYPE_NUM0);
			maps = orderService.findOrderList(orderSearchVo);
			break;
		case 5:
			orderSearchVo = new OrderSearchVo();
			orderSearchVo.setOrderMenuType(ConstantVo.ORDER_MENU_TYPE_UNSUB);
			maps = orderService.findOrderList(orderSearchVo);
			break;
		case 6:
			maps = enterpriseService.findEnterpriseAndCard();
			break;
		default:
			break;
		}
		
		uploadExcelService.exportExcelAll(maps, type, response,request);
		
		
	}
	
	
	
}


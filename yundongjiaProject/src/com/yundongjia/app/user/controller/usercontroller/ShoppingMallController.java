package com.yundongjia.app.user.controller.usercontroller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yundongjia.app.user.service.AttachInFoService;
import com.google.gson.Gson;
import com.yundongjia.app.user.service.ShoppingMallService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TAttachExample;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsExample;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TGoodsStandard;
import com.yundongjia.oa.admin.po.TGoodsStandardExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月7日 上午10:57:26 * @version 1.0 * @parameter  * @since  * @return  */

/**
 * 
* @ClassName: ShoppingMallController 
* @Description: TODO(商城控制类) 
* @author Wangli
* @date 2017年2月7日 下午2:52:09 
*
 */
@Controller
public class ShoppingMallController extends BaseController{
    
	@Autowired
	private ShoppingMallService shoppingMallService;
	@Autowired
	private AttachInFoService attachInFoService;
	

	@RequestMapping(value="ydj/user/shoppingmall")
	 public void myPage(String str) throws Exception{
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = Integer.parseInt(map.get("type").toString());
		switch (type) {
		case 0: //商城商品列表接口
			goodsInfo();
			break;
		case 1: //展示商品规格接口
			goodsSpec(map);
			break;
		default:
			break;
		}
	 }
	

	/**
	 * 
	* @Title: goodsInfo 
	* @Description: TODO(获取商品信息) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	  public void goodsInfo(){ 
		  jsonclear();
		  TGoodsExample example = new TGoodsExample();
		  example.createCriteria().andStatEqualTo(1);
		  try {
			
			  List<TGoods> goodsList = this.shoppingMallService.goodsList(example);
			  for(TGoods goods:goodsList){
				  jsonObject.put("goodsId", goods.getGoodsid());
				  jsonObject.put("goodsName", goods.getGname());//商品名称
				  jsonObject.put("img", goods.getImg());//商品大图
				  TAttachExample attachExample = new TAttachExample();
				  attachExample.createCriteria().andAttachtypeEqualTo(4).andProidEqualTo(goods.getGoodsid()).andImgordernumNotEqualTo(0);
				  List<TAttach> list_attach = this.attachInFoService.selecAttach(attachExample);
				  for(TAttach i:list_attach){
					  jsonArray2.add(i.getPath());  
				  }
				  TGoodsOrderExample goodsOrderExample = new TGoodsOrderExample();
				  goodsOrderExample.createCriteria().andGidEqualTo(goods.getGoodsid()).andPaystatusEqualTo(2);
				  List<TGoodsOrder> list_goodsorder = this.shoppingMallService.selectgoodsorder(goodsOrderExample);
				  jsonObject.put("special", goods.getSpecial());//商品卖点（就是上面一小句话）
				  jsonObject.put("monthsales", list_goodsorder.size());//月销售额
				  jsonObject.put("imgInfo", jsonArray2);//商品路轮播图
				  jsonArray2.clear();
				  jsonObject.put("goodsPrice", goods.getGprice());//商品价格
				  jsonObject.put("path", goods.getPath());//商品描述（html）
				  jsonObject.put("freight", goods.getFreight());//商品运费
				  jsonObject.put("gcount", goods.getGcount());//商品库存
				  jsonArray.add(jsonObject);
			  }
			  jsonObject2.put("Info", jsonArray);
			  jsonObject2.put("message", "查询成功");
			  jsonObject2.put("status", "0");
			} catch (Exception e) {
				jsonObject2.put("message", "查询失败");
				jsonObject2.put("status", "1");
			}finally {
				this.RSAprivateencode(jsonObject2.toString());
			}
	  }
	  
	  /**
	   * 
	  * @Title: goodsSpec 
	  * @Description: TODO(商品规格表) 
	  * @param     设定文件 
	  * @return void    返回类型 
	  * @throws
	   */
	  public void goodsSpec(Map<String, Object> map){ 
		  jsonclear();
		  Integer goodsId = Integer.parseInt(map.get("goodsId").toString());
		  
		  
		  TGoodsStandardExample example = new TGoodsStandardExample();
		  example.createCriteria().andGoodsidEqualTo(goodsId);
		  try {
			
			  List<TGoodsStandard> goodsspecList = this.shoppingMallService.goodsSpecList(example);
			  for(TGoodsStandard goodsStandard:goodsspecList){
				  String[] string = goodsStandard.getStandard().split(",");
				  if(goodsStandard.getType().equals(0)){
					  for(int i = 0;i<string.length;i++){
						  jsonArray.add(string[i]);
					  }
				  }
				  if(goodsStandard.getType().equals(1)){
					  for(int i = 0;i<string.length;i++){
						  jsonArray2.add(string[i]);
					  }
				  }
			  }
			  jsonObject2.put("color", jsonArray);
			  jsonObject2.put("size", jsonArray2);
			  jsonObject2.put("message", "查询成功");
			  jsonObject2.put("status", "0");
			} catch (Exception e) {
				jsonObject2.put("message", "查询失败");
				jsonObject2.put("status", "1");
			}finally {
				this.RSAprivateencode(jsonObject2.toString());
			}
	  }
	  
}

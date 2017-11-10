package com.yundongjia.app.user.controller.usercontroller;



import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yundongjia.app.user.service.MemberCardInfoService;
import com.yundongjia.app.user.service.MemberInfoService;
import com.yundongjia.app.user.service.UserInfoService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCardTypeExample;
import com.yundongjia.oa.admin.po.TConsigneeAddress;
import com.yundongjia.oa.admin.po.TConsigneeAddressExample;
import com.yundongjia.oa.admin.po.TJpush;
import com.yundongjia.oa.admin.po.TJpushExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRef;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRefExample;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberCouponRefExample;
import com.yundongjia.oa.admin.po.TMemberExample;
import com.yundongjia.oa.admin.po.TMemberSuggestion;
import com.yundongjia.oa.utils.FtpUtil;
import com.yundongjia.oa.utils.UploadUtil;

/** * @author  作者WangLi: * @date 创建时间：2017年1月16日 上午10:57:26 * @version 1.0 * @parameter  * @since  * @return  */

/**
 * 
* @ClassName: LoginUserController 
* @Description: TODO(运动+用户登录界面系列操作) 
* @author Wangli
* @date 2017年1月16日 上午11:00:07 
*
 */
@Controller
public class MyController extends BaseController{
    
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private MemberInfoService memberService;
	@Autowired
	private MemberCardInfoService memberCardInfoService;
	private File file;   
	private String fileName; 
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@RequestMapping(value="ydj/user/my")
	 public void myPage(String str) throws Exception{
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = Integer.parseInt(map.get("type").toString());
		switch (type) {
		case 1: //我的地址->地址列表
			myAddressList(map);
			break;
		case 2: //我的地址->新增地址
			addMyAddress(map);
			break;
		case 3: //我的地址->删除地址 
			deleteMyAddress(map);
			break;
		case 4: //我的卡包->卡列表
			memberCardList(map);
			break;  
		case 5: //我的卡包->可被添加的卡列表
			beBuyCardList();
			break;
		case 6://意见反馈接口
			memberSuggestion(map);
			break;
		case 7://推送消息列表(有一天会用的)
			pushList();
			break;
		case 8://推送消息删除(有一天会用的)
			
			break;
		case 9://点击我的的接口->展示余额、红包余额、代金券余额等
			myBalance(map);
			break;
		case 10://我的地址修改地址接口
			editMyAddress(map);
			break;
		case 11://我的地址设置默认地址接口
			defaultMyAddress(map);
			break;
		default:
			break;
		}
	 }
	
	
	
	public void saveMemberHeadPic(HttpServletRequest request,HttpServletResponse response){  
		//创建一个临时文件存放要上传的文件，第一个参数为上传文件大小，第二个参数为存放的临时目录  
		//DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024*5,new File("D:\\temp1"));  
		// 设置缓冲区大小为 5M  
		//factory.setSizeThreshold(1024 * 1024 * 5);  
		// 创建一个文件上传的句柄  
		ServletFileUpload upload = new ServletFileUpload();
		//设置上传文件的整个大小和上传的单个文件大小  
		//upload.setSizeMax(1024*1024*50);  
		upload.setFileSizeMax(1024*1024*5);  
		try { //把页面表单中的每一个表单元素解析成一个  
	    List<FileItem> items = upload.parseRequest(request);  
		for (FileItem fileItem : items) {  
		  try { //将文件上传到项目的upload目录并命名，getRealPath可以得到该web项目下包含/upload的绝对路径//  
		      fileItem.write(new File(request.getServletContext().getRealPath("/static/images/memberImages")+"/" + UUID.randomUUID().toString()+".png"));  
		  } catch (Exception e) {   
		      e.printStackTrace();   
		  }   
		}   
		} catch (FileUploadBase.SizeLimitExceededException e) {   
		System.out.println("整个请求的大小超过了规定的大小...");   
		} catch (FileUploadBase.FileSizeLimitExceededException e) {   
		System.out.println("请求中一个上传文件的大小超过了规定的大小...");   
		}catch (FileUploadException e) {  
		e.printStackTrace();   
		}  
}
	
	
	
	
	
	/**
	 * 
	* @Title: updateMemberInfoByMemberId 
	* @Description: TODO(保存用户个人资料) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value="ydj/user/savemyselfInfo")
	public void updateMemberInfoByMemberId(String str,MultipartFile file){
		jsonclear();
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		String nickName =  map.get("nickName").toString();
		String gender = map.get("gender").toString(); 
		String bornDate = map.get("bornDate").toString();
		Double height = Double.parseDouble(map.get("height").toString());
		String imgpath=upLoadImgFromClient(file);
		TMember tMember = new TMember();
		tMember.setMemberid(memberId);
		tMember.setNickname(nickName);
		tMember.setBorndate(bornDate);
		tMember.setGender(gender);
		tMember.setImgpath(imgpath);
		tMember.setHeight(height);
		try{
			this.memberService.updateMemberInfo(tMember);
			jsonObject.put("imgpath", tMember.getImgpath());
			jsonObject.put("status", "0");
			jsonObject.put("message", "用户信息更新成功");
			
		}catch(Exception e){
			jsonObject.put("status", "1");
			jsonObject.put("message", "用户信息查询失败");
		}
		this.RSAprivateencode(jsonObject.toString());
    }
	
	/**
	 * 
	* @Title: updateMemberInfoByMemberId 
	* @Description: TODO(保存用户个人资料) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value="ydj/user/savemyselfInformation")
	public void updateMemberInfoByMemberId(String str){
		jsonclear();
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		String nickName =  map.get("nickName").toString();
		String gender = map.get("gender").toString(); 
		String bornDate = map.get("bornDate").toString();
		Double height = Double.parseDouble(map.get("height").toString());
		TMember tMember = new TMember();
		tMember.setMemberid(memberId);
		tMember.setNickname(nickName);
		tMember.setBorndate(bornDate);
		tMember.setGender(gender);
		tMember.setImgpath("");
		tMember.setHeight(height);
		try{
			this.memberService.updateMemberInfo(tMember);
			jsonObject.put("imgpath", tMember.getImgpath());
			jsonObject.put("status", "0");
			jsonObject.put("message", "用户信息更新成功");
			
		}catch(Exception e){
			jsonObject.put("status", "1");
			jsonObject.put("message", "用户信息查询失败");
		}
		this.RSAprivateencode(jsonObject.toString());
    }
	
	public String upLoadImgFromClient(@RequestParam(value = "file", required = false) MultipartFile  file)  {
		String vPath = "";	
				  try {
					vPath = FtpUtil.uploadFile(file, this.selectConfigVal("IMAGE_UPLOAD_URL_BEFORE")+"images/memberImages/");
				} catch (Exception e) {
					e.printStackTrace();
				}
		return vPath;
	}
	
	/**
	 * 
	* @Title: myAddressList 
	* @Description: TODO(客户端界面我的里面的地址列表) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void myAddressList(Map<String, Object> map){
		jsonclear();
		Integer memberId =  Integer.parseInt(map.get("memberId").toString());
		TConsigneeAddressExample example = new TConsigneeAddressExample();
		example.createCriteria().andMemberidEqualTo(memberId);
		try {
			
			List<TConsigneeAddress> list_adress = this.memberService.selectAddressList(example);
			for(TConsigneeAddress address:list_adress){
				jsonObject.put("adressStatus", address.getStatus());
				jsonObject.put("rowId", address.getRowid());
				jsonObject.put("name", address.getName());
				jsonObject.put("mobilePhone", address.getMobilephone()); 
				jsonObject.put("address", address.getAddress());
				jsonObject.put("gender", address.getGender());
				jsonArray.add(jsonObject);
			}
			jsonObject2.put("Info", jsonArray);
			jsonObject2.put("status", "0");
			jsonObject2.put("message", "查询成功");
		} catch (Exception e) {
			jsonObject2.put("status", "0");
			jsonObject2.put("message", "查询成功");
		}finally {
			this.RSAprivateencode(jsonObject2.toString());
		}
	}
		
	/**
	 * 
	* @Title: addMyAddress 
	* @Description: TODO(添加收货地址) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addMyAddress(Map<String, Object> map){ 
		jsonclear();
		Integer memberId =  Integer.parseInt(map.get("memberId").toString());
		Integer gender =  Integer.parseInt(map.get("gender").toString());
		String name = map.get("name").toString();
		String mobilephone = map.get("mobilephone").toString();
		String address = map.get("address").toString();
		TConsigneeAddress tConsigneeAddress = new TConsigneeAddress();
		try {
			TConsigneeAddressExample example = new TConsigneeAddressExample();
			example.createCriteria().andMemberidEqualTo(memberId);
			List<TConsigneeAddress> list_address = this.memberService.selectAddressList(example);
			tConsigneeAddress.setMemberid(memberId);
			tConsigneeAddress.setName(name);
			tConsigneeAddress.setMobilephone(mobilephone);
			tConsigneeAddress.setAddress(address);
			tConsigneeAddress.setGender(gender);
			if(list_address.size() == 0){
				tConsigneeAddress.setStatus("0");
			}else{
				tConsigneeAddress.setStatus("1");
			}
			this.memberService.insertMyAddress(tConsigneeAddress);
			jsonObject.put("status", "0");
			jsonObject.put("message", "添加成功");
		} catch (Exception e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "添加失败");
		}finally {
			this.RSAprivateencode(jsonObject.toString());
		}
	}
	
	
	/**
	 * 
	* @Title: editMyAddress 
	* @Description: TODO(修改收货地址) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void editMyAddress(Map<String, Object> map){ 
		jsonclear();
		Integer rowId =  Integer.parseInt(map.get("rowId").toString());
		Integer memberId =  Integer.parseInt(map.get("memberId").toString());
		Integer gender =  Integer.parseInt(map.get("gender").toString());
		String name = map.get("name").toString();
		String mobilephone = map.get("mobilephone").toString();
		String address = map.get("address").toString();
		String addressStatus = map.get("addressStatus").toString();
		TConsigneeAddress tConsigneeAddress = new TConsigneeAddress();
		try {
			tConsigneeAddress.setRowid(rowId);
			tConsigneeAddress.setMemberid(memberId);
			tConsigneeAddress.setName(name);
			tConsigneeAddress.setMobilephone(mobilephone);
			tConsigneeAddress.setAddress(address);
			tConsigneeAddress.setGender(gender);
			tConsigneeAddress.setStatus(addressStatus);
			this.memberService.updateMyAddress(tConsigneeAddress);
			jsonObject.put("status", "0");
			jsonObject.put("message", "更新成功"); 
		} catch (Exception e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "更新失败");
		}finally {
			this.RSAprivateencode(jsonObject.toString());
		}
	}
	
	
	/**
	 * 
	* @Title: deleteMyAddress 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteMyAddress(Map<String, Object> map){
		jsonclear();
		Integer rowId =  Integer.parseInt(map.get("rowId").toString());
		try {
			this.memberService.deleteMyAddress(rowId);
			jsonObject.put("status", "0");
			jsonObject.put("message", "删除成功");
		} catch (Exception e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "删除失败");
		}finally {
			this.RSAprivateencode(jsonObject.toString());
		}
	}
	
	/**
	 * 
	* @Title: memberCardList 
	* @Description: TODO(我的卡包----卡列表) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void memberCardList(Map<String, Object> map){
		jsonclear();
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		Map<String, Object> m = new HashMap<String,Object>();
		m.put("memberId", memberId);
		m.put("status", 0);
		try {
			
			List<Map<String, Object>> list_card = this.memberCardInfoService.selectMemberCardInfoCardType(m);//查出来的都是个人通卡
			TMemberCardEnterpriseRefExample example = new TMemberCardEnterpriseRefExample();
			example.createCriteria().andMemberidEqualTo(memberId);
			List<TMemberCardEnterpriseRef> list_enterprise_card = this.memberCardInfoService.selectMemberCardEnterpriseRefInfo(example);
			for(Map<String, Object> orderRef:list_card){
				jsonObject.put("cardId", orderRef.get("cardId"));//卡Id
				jsonObject.put("cardType", "1");//1个人卡
				jsonObject.put("discount", orderRef.get("discount"));//卡折扣
				jsonObject.put("cardTypeName", orderRef.get("cardTypeName"));//卡类型名称
				jsonObject.put("money", orderRef.get("totalMoney"));//卡面值
				jsonObject.put("validDay", orderRef.get("expireDate").toString().split(" ")[0]);//有效天数
				if(0d == Double.parseDouble(orderRef.get("cashBack").toString())){
					jsonObject.put("cashBack", "0");//是否返现   0不返现  1返现
				}else{
					jsonObject.put("cashBack", "1");//是否返现  0不返现  1返现
				}
				
				
				jsonArray.add(jsonObject);
			}
			
			for(TMemberCardEnterpriseRef enterpriseRef:list_enterprise_card){
	            TMemberCardOrderRef Ref = this.memberCardInfoService.selectSelfMemberCardInfo(enterpriseRef.getCardid());			
				if(Ref != null){
		            TCardType cardType = this.memberCardInfoService.selectCardTypeInfo(Ref.getCardtypeid());
		            if(cardType != null){
						jsonObject.put("cardId", Ref.getOrderid());//卡Id
						jsonObject.put("cardType", "2");//1企业卡
						jsonObject.put("discount", Ref.getDiscount());//卡折扣
						jsonObject.put("cardTypeName", cardType.getCardtypename());//卡类型名称
						jsonObject.put("money", Ref.getSurplussportscount());//卡面值
						jsonObject.put("validDay", Ref.getExpiredate().toString().split(" ")[0]);//有效天数
					    jsonObject.put("cashBack", "0");//是否返现   0不返现  1返现
						jsonArray.add(jsonObject);
		            }
				}
			}   
			    jsonObject2.put("Info", jsonArray);
			    jsonObject2.put("status", "0");
			    jsonObject2.put("message", "查询成功!");
		} catch (Exception e) {
				e.printStackTrace();
				jsonObject2.put("status", "1");
				 jsonObject2.put("message", "查询失败!");
		}finally {
				this.RSAprivateencode(jsonObject2.toString());
		}
		
	}
	
	/***
	 * 
	* @Title: beBuyCardList 
	* @Description: TODO(我的卡包添加卡下--可以被购买的卡类型列表) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void beBuyCardList(){
		jsonclear();
		Map<String, Object> m = new HashMap<String,Object>();
		try {
			TCardTypeExample example = new TCardTypeExample();
			TCardTypeExample.Criteria  criteria = example.createCriteria();
			TCardTypeExample.Criteria  criteria2 = example.createCriteria();
			criteria.andCardtypeEqualTo("1").andIsdelEqualTo("0").
			andIsstopEqualTo("0").andStockEqualTo(-1);
			
			criteria2.andCardtypeEqualTo("1").andIsdelEqualTo("0").
			andIsstopEqualTo("0").andSurplusstockGreaterThan(0);
			example.or(criteria2);
			List<TCardType> list_card_type = this.memberCardInfoService.selectCardTypeInfo(example);
			for(TCardType cardType:list_card_type){
				jsonObject.put("cardId", cardType.getCardid());//卡Id
				jsonObject.put("discount", cardType.getCarddiscount());//卡折扣
				jsonObject.put("cardTypeName", cardType.getCardtypename());//卡类型名称
				jsonObject.put("money", cardType.getAmount());//卡面值
				jsonObject.put("validDay", cardType.getValiddate());//有效天数
				jsonObject.put("cashBack", cardType.getIscashback());//是否返现  0不返现  1返现
				if(cardType.getIscashback() == 0){
					jsonObject.put("desc", "");
				}else{
					jsonObject.put("desc", selectConfigVal("THE_BLACK_CASH_BACK_DESC").replace("3000",cardType.getAmount())) ;
				}
				jsonArray.add(jsonObject);
			}
				jsonObject2.put("Info", jsonArray);
			    jsonObject2.put("status", "0");
			    jsonObject2.put("message", "查询成功!");
		} catch (Exception e) {
			 jsonObject2.put("status", "1");
			 jsonObject2.put("message", "查询失败!");
		}finally {
				this.RSAprivateencode(jsonObject2.toString());
		}
	}
	
	/**
	 * 
	* @Title: memberSuggestion 
	* @Description: TODO(添加意见反馈) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void memberSuggestion(Map<String, Object> map) {
		jsonclear();
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		 String mobilePhoneNo = map.get("mobilePhoneNo").toString();
		 String suggestionInfo = map.get("suggestionInfo").toString();
		 TMemberSuggestion suggestion = new TMemberSuggestion();
		 suggestion.setCreatedate(format.format(new Date()));
		 suggestion.setMobilephoneno(mobilePhoneNo);
		 suggestion.setSuggestioninfo(suggestionInfo);
		 suggestion.setLikerid(memberId);
		 suggestion.setStatus(0);
		 Integer result = this.memberService.inserMemberSuggestion(suggestion);
		 if(result >0){
			     jsonObject.put("status", "0");
				 jsonObject.put("message", "添加成功");
		 }else{
				 jsonObject.put("status", "1");
				 jsonObject.put("message", "添加失败");
		 }
              this.RSAprivateencode(jsonObject.toString());

		}	
	
	
	/**
	 * 
	* @Title: pushList 
	* @Description: TODO(消息推送列表) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void pushList() {
		jsonclear();
		try {
			TJpushExample example = new TJpushExample();
			example.setOrderByClause("time desc;");
			List<TJpush> list_push = this.memberService.selectPush(example);
			for(TJpush jpush:list_push){
				jsonObject.put("id", jpush.getId());
				jsonObject.put("title", jpush.getTitle());//推送标题
				jsonObject.put("content", jpush.getContent());//推送内容分
				jsonObject.put("url", jpush.getUrl());//推送url
				jsonArray.add(jsonObject);
				
			}
			 jsonObject2.put("Info", jsonArray);
			 jsonObject2.put("status", "0");
			 jsonObject2.put("message", "查询成功");
		} catch (Exception e) {
			 jsonObject2.put("status", "1");
			 jsonObject2.put("message", "查询失败");
		}
				 
              this.RSAprivateencode(jsonObject2.toString());

		}	
	
	/**
	 * 
	* @Title: myBalance 
	* @Description: TODO(点击我的展示红包余额 现金余额 代金券余额接口) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void myBalance(Map<String, Object> map) {
		jsonclear();
		Integer  memberId = Integer.parseInt(map.get("memberId").toString());
		try {
			TMemberExample example = new TMemberExample();
			example.createCriteria().andMemberidEqualTo(memberId);
			TMember member = this.memberService.selectMemberInfo(memberId);
			TMemberCouponRefExample couponRefExample = new TMemberCouponRefExample();
			couponRefExample.createCriteria().andMemberidEqualTo(memberId).andCouponmethodEqualTo("1").andStatusEqualTo("0");
			List<TMemberCouponRef> list_coupon_member = this.memberService.selectMemberCouponInfo(couponRefExample);
			double couponBalance = 0.00;
			for(TMemberCouponRef couponRef:list_coupon_member){
				couponBalance = couponBalance + couponRef.getDiscountamount();
			}
				jsonObject.put("memberId", member.getMemberid());
				jsonObject.put("redAmount", member.getRedamount());//红包余额
				jsonObject.put("balance", member.getBalance());//现金余额
				jsonObject.put("couponBalance", couponBalance);//代金券余额
				jsonArray.add(jsonObject);
				
			 jsonObject2.put("Info", jsonArray);
			 jsonObject2.put("status", "0");
			 jsonObject2.put("message", "查询成功");
		} catch (Exception e) {
			 jsonObject2.put("status", "1");
			 jsonObject2.put("message", "查询失败");
		}
				 
              this.RSAprivateencode(jsonObject2.toString());

		}	
	
	/**
	 * 
	* @Title: defaultMyAddress 
	* @Description: TODO(设置默认地址) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void defaultMyAddress(Map<String, Object> map) {
		jsonclear();
		Integer  memberId = Integer.parseInt(map.get("memberId").toString());
		Integer  rowId = Integer.parseInt(map.get("rowId").toString());
		TConsigneeAddressExample example = new TConsigneeAddressExample();
		example.createCriteria().andMemberidEqualTo(memberId);
		try {
			TConsigneeAddress tConsigneeAddress = new TConsigneeAddress();
			tConsigneeAddress.setStatus("1");
			this.memberService.updateMyAddress(tConsigneeAddress,example);
			tConsigneeAddress.setStatus("0");
			tConsigneeAddress.setRowid(rowId);
			this.memberService.updateMyAddress(tConsigneeAddress);
			 jsonObject2.put("status", "0");
			 jsonObject2.put("message", "设置默认地址成功");
		} catch (Exception e) {
			 jsonObject2.put("status", "1");
			 jsonObject2.put("message", "查询失败");
		}
				 
              this.RSAprivateencode(jsonObject2.toString());

		}	

}

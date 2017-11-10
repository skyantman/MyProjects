package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TConsigneeAddress;
import com.yundongjia.oa.admin.po.TConsigneeAddressExample;
import com.yundongjia.oa.admin.po.TJpush;
import com.yundongjia.oa.admin.po.TJpushExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberCouponRefExample;
import com.yundongjia.oa.admin.po.TMemberExample;
import com.yundongjia.oa.admin.po.TMemberSuggestion;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:49:12 * @version 1.0 * @parameter  * @since  * @return  */
public interface MemberInfoService {
     /**
      * 
     * @Title: selectMemberInfo 
     * @Description: TODO(根据条件查询用户信息) 
     * @param @param memberExample
     * @param @return    设定文件 
     * @return List<TMember>    返回类型 
     * @throws
      */
	 public List<TMember> selectMemberInfo(TMemberExample memberExample);
	 public TMember selectMemberInfo(Integer memberId);
	 /**
	  * 
	 * @Title: updateMemberInfoFirstLoginDate 
	 * @Description: TODO(更新用户信息) 
	 * @param @param member
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	  */
	 public Integer updateMemberInfo(TMember member);
	 
	 /**
	  * 
	 * @Title: insertMemberInfo 
	 * @Description: TODO(添加用户信息) 
	 * @param @param member
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	  */
	 public Integer insertMemberInfo(TMember member);
	 /**
	  * 
	 * @Title: selectAddressList 
	 * @Description: TODO(我的->地址列表) 
	 * @param @param example
	 * @param @return    设定文件 
	 * @return List<TConsigneeAddress>    返回类型 
	 * @throws
	  */
	 public List<TConsigneeAddress> selectAddressList(TConsigneeAddressExample example);
	 /**
	  * 
	 * @Title: insertMyAddress 
	 * @Description: TODO(添加收货地址) 
	 * @param @param address
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	  */
	 public Integer insertMyAddress(TConsigneeAddress address);
	 public Integer updateMyAddress(TConsigneeAddress address);
	 Integer updateMyAddress(TConsigneeAddress address, TConsigneeAddressExample example);
	 /**
	  * 
	 * @Title: deleteMyAddress 
	 * @Description: TODO(删除收货地址) 
	 * @param @param rowId
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	  */
	 public Integer deleteMyAddress(Integer rowId);
	 /**
	  * 
	 * @Title: inserMemberSuggestion 
	 * @Description: TODO(客户端录入意见反馈) 
	 * @param @param suggestion
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	  */
	 public Integer inserMemberSuggestion(TMemberSuggestion suggestion);
	 /**
	  * 
	 * @Title: selectPush 
	 * @Description: TODO(查询所有推送消息) 
	 * @param @return    设定文件 
	 * @return List<TJpush>    返回类型 
	 * @throws
	  */
	 public List<TJpush> selectPush(TJpushExample example);
	 /**
	  * 
	 * @Title: selectMemberCouponInfo 
	 * @Description: TODO(根据条件查询会员代金券信息) 
	 * @param @param example
	 * @param @return    设定文件 
	 * @return List<TMemberCouponRef>    返回类型 
	 * @throws
	  */
	 public List<TMemberCouponRef> selectMemberCouponInfo(TMemberCouponRefExample example);
}

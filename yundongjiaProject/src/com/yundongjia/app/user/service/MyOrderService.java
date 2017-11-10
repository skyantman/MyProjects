package com.yundongjia.app.user.service;



import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TStudio;

import net.sf.json.JSONArray;

/** * @author  作者WangLi: * @date 创建时间：2017年2月8日 上午11:13:14 * @version 1.0 * @parameter  * @since  * @return  */
public interface MyOrderService {

	public JSONArray myOrder (Integer memberId ,String orderStatus);
	
	public List<TActivityOrder> myActivityOrdersList(TActivityOrderExample example );
	public TActivity myactivityList(Integer id);
	public TStudio selectStudioInfo(Integer id);

	/**
	 * @param orderType
	 * @param proId
	 * @return根据ID查询订单详情
	 */
	public Map<String, Object> findOrderById(Integer orderType, Integer proId);
	
}

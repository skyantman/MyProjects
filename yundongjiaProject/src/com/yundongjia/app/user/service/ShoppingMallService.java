package com.yundongjia.app.user.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsExample;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TGoodsStandard;
import com.yundongjia.oa.admin.po.TGoodsStandardExample;


/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:00:24 * @version 1.0 * @parameter  * @since  * @return  */

public interface ShoppingMallService {
    
		public List<TGoods> goodsList(TGoodsExample example);
		public List<TGoodsStandard> goodsSpecList(TGoodsStandardExample example);
		public List<TGoodsOrder> selectgoodsorder(TGoodsOrderExample example);
}

package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.ShoppingMallService;
import com.yundongjia.oa.admin.mapper.TGoodsMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TGoodsStandardMapper;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsExample;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TGoodsStandard;
import com.yundongjia.oa.admin.po.TGoodsStandardExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月14日 下午6:38:04 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class ShoppingMallServiceImpl implements ShoppingMallService {
    @Autowired
	private TGoodsMapper goodsMapper;
    @Autowired
   	private TGoodsStandardMapper goodsStandardMapper;
    @Autowired
   	private TGoodsOrderMapper goodsOrderMapper;
	@Override
	public List<TGoods> goodsList(TGoodsExample example) {
		List<TGoods> list = this.goodsMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<TGoodsStandard> goodsSpecList(TGoodsStandardExample example) {
		List<TGoodsStandard> list = this.goodsStandardMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<TGoodsOrder> selectgoodsorder(TGoodsOrderExample example) {
		List<TGoodsOrder> list = this.goodsOrderMapper.selectByExample(example);
		return list;
	}

}

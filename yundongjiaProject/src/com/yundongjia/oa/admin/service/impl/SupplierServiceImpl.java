package com.yundongjia.oa.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yundongjia.oa.admin.mapper.TAdminMapper;
import com.yundongjia.oa.admin.mapper.TApplyAccountMapper;
import com.yundongjia.oa.admin.mapper.TApplyMapper;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TGoodsMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.mapper.TSavemoneyMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.mapper.TSupplierLoginMapper;
import com.yundongjia.oa.admin.mapper.TSupplierMapper;
import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TApplyAccount;
import com.yundongjia.oa.admin.po.TApplyAccountExample;
import com.yundongjia.oa.admin.po.TApplyExample;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachExample;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsExample;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TRegionsExample;
import com.yundongjia.oa.admin.po.TSavemoney;
import com.yundongjia.oa.admin.po.TSavemoneyExample;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.po.TStudioExample;
import com.yundongjia.oa.admin.po.TStudioExample.Criteria;
import com.yundongjia.oa.admin.po.TSupplier;
import com.yundongjia.oa.admin.po.TSupplierExample;
import com.yundongjia.oa.admin.po.TSupplierLogin;
import com.yundongjia.oa.admin.service.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private TStudioMapper tStudioMapper;
	@Autowired
	private TSupplierMapper tSupplierMapper;
	@Autowired
	private TSupplierLoginMapper tSupplierLoginMapper ;
	@Autowired
	private TRegionsMapper tRegionsMapper;
	@Autowired
	private TCoachMapper tCaochMapper;
	@Autowired
	private TGoodsMapper tGoodsMapper;
	@Autowired
	private TRegionsMapper regionsMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	@Autowired
	private TOrderMapper tOrderMapper;
	@Autowired
	private TGoodsOrderMapper tGoodsOrderMapper;
	@Autowired
	private TOrderDiscountMapper tOrderDiscountMapper;
	@Autowired
	private TCoachMapper tCoachMapper;
	@Autowired
	private TSavemoneyMapper tSavemoneyMapper;
	@Autowired
	private TAdminMapper tAdminMapper;
	@Autowired
	private TApplyMapper tApplyMapper;
	@Autowired
	private TApplyAccountMapper tApplyAccountMapper;
	/**
	 * @return查询为绑定供应商的场馆列表
	 */
	@Override
	public PageInfo<Map<String,Object>> findNoBandStudioList(Integer row , Integer pageNum , String searchInfo) {
		TSupplierExample tSupplierExample  = new TSupplierExample();
		tSupplierExample.createCriteria().andLinkstudioidNotEqualTo("0");
		List<TSupplier> suppliers = tSupplierMapper.selectByExample(tSupplierExample);
		List<Integer> bandStudioId = new ArrayList<Integer>();
		for (TSupplier tSupplier : suppliers) {
			String[] split = tSupplier.getLinkstudioid().split(",");
			for (int i = 0; i < split.length; i++) {
				bandStudioId.add(Integer.parseInt(split[i]));
			}
		}
		TStudioExample tStudioExample = new TStudioExample();
		Criteria createCriteria = tStudioExample.createCriteria();
		createCriteria.andStatusEqualTo(0).andTypeEqualTo("2");
		if(suppliers.size() != 0){
			createCriteria.andStudioidNotIn(bandStudioId);
		}
		if(searchInfo != null && !"".equals(searchInfo)){
			createCriteria.andStudionameLike("%"+searchInfo+"%");
		}
		tStudioExample.setOrderByClause("studioId desc");
		PageHelper.startPage(pageNum, row);
		List<TStudio> studios = tStudioMapper.selectByExample(tStudioExample);
		PageInfo  pi = new PageInfo(studios);
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for (TStudio ts : studios) {
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("studioName", ts.getStudioname());
			resultMap.put("studioId", ts.getStudioid());
			resultMap.put("studioOpentime", ts.getStudioopentime());
			switch (ts.getStatus()) {
			case 0:
				resultMap.put("status", "生效");
				break;
			case 1:
				resultMap.put("status", "禁用");
				break;
			case 2:
				resultMap.put("status", "未审核");
				break;
			}
			switch (ts.getType()) {
			case "1":
				resultMap.put("type", "工作室");
				break;
			case "2":
				resultMap.put("type", "健身房");
				break;
			}
			
			// 区id
			int regId = ts.getRegionsid();
			//的到区
			TRegionsExample tRegionsExample = new TRegionsExample();
			tRegionsExample.createCriteria().andCodeEqualTo(regId).andIsshowEqualTo(1);
			List<TRegions> regionsList = tRegionsMapper.selectByExample(tRegionsExample);
			TRegions regions = new TRegions();
			if(regionsList.size() == 0){
				resultMap.put("city", "");
			}else{
				regions = regionsList.get(0);
				if(regions != null){
					// 得到省
					tRegionsExample.clear();
					tRegionsExample.createCriteria().andCodeEqualTo(regions.getpCode()).andIsshowEqualTo(1);
					regionsList = tRegionsMapper.selectByExample(tRegionsExample);
					regions = regionsList.get(0);
					if(regions.getName().equals("市辖区") || regions.getName().equals("县")){
						tRegionsExample.clear();
						tRegionsExample.createCriteria().andCodeEqualTo(regions.getpCode()).andIsshowEqualTo(1);
						regionsList = tRegionsMapper.selectByExample(tRegionsExample);
						regions = regionsList.get(0);
						resultMap.put("city", regions.getName());
					}else{
						resultMap.put("city", regions.getName());
					}
					
				}else{
					resultMap.put("city", "");
				}
			}
			result.add(resultMap);
		}
		pi.setList(result);
		return pi;
	}
	
	/**
	 * @param pageRow5
	 * @param pageNum
	 * @param searchInfo
	 * @return查询未绑定供应商的教练列表
	 */
	@Override
	public PageInfo<Map<String, Object>> findNoBandCoach(Integer row, Integer pageNum, String searchInfo) {
		TSupplierExample tSupplierExample  = new TSupplierExample();
		tSupplierExample.createCriteria().andLinkcoachidNotEqualTo("0");
		List<TSupplier> suppliers = tSupplierMapper.selectByExample(tSupplierExample);
		List<Integer> bandCoachId = new ArrayList<Integer>();
		for (TSupplier tSupplier : suppliers) {
			String[] split = tSupplier.getLinkcoachid().split(",");
			for (int i = 0; i < split.length; i++) {
				bandCoachId.add(Integer.parseInt(split[i]));
			}
		}
		TCoachExample tCoachExample = new TCoachExample();
		com.yundongjia.oa.admin.po.TCoachExample.Criteria createCriteria = tCoachExample.createCriteria();
		createCriteria.andStatusEqualTo(0).andStatusEqualTo(0);
		if(suppliers.size() != 0){
			createCriteria.andCoachidNotIn(bandCoachId);
		}
		if(searchInfo != null && !"".equals(searchInfo)){
			createCriteria.andNicknameLike("%"+searchInfo+"%");
		}
		tCoachExample.setOrderByClause("coachId desc");
		PageHelper.startPage(pageNum, row);
		List<TCoach> coachs = tCaochMapper.selectByExample(tCoachExample);
		PageInfo  pi = new PageInfo(coachs);
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for (TCoach ts : coachs) {
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("nickName", ts.getNickname());
			resultMap.put("coachId", ts.getCoachid());
			resultMap.put("workAge", ts.getWorkage() + "年");
			if("0".equals(ts.getGender())){
				resultMap.put("gender", "男");
			}else if("1".equals(ts.getGender())){
				resultMap.put("gender", "女");
			}else{
				resultMap.put("gender", "");
			}
			switch (ts.getStatus()) {
			case 0:
				resultMap.put("status", "生效");
				break;
			case 1:
				resultMap.put("status", "禁用");
				break;
			case 2:
				resultMap.put("status", "未审核");
				break;
			}
		
			
			// 区id
			int regId = ts.getRegionsid();
			//的到区
			TRegionsExample tRegionsExample = new TRegionsExample();
			tRegionsExample.createCriteria().andCodeEqualTo(regId).andIsshowEqualTo(1);
			List<TRegions> regionsList = tRegionsMapper.selectByExample(tRegionsExample);
			TRegions regions = new TRegions();
			if(regionsList.size() == 0){
				resultMap.put("city", "");
			}else{
				regions = regionsList.get(0);
				if(regions != null){
					// 得到省
					tRegionsExample.clear();
					tRegionsExample.createCriteria().andCodeEqualTo(regions.getpCode()).andIsshowEqualTo(1);
					regionsList = tRegionsMapper.selectByExample(tRegionsExample);
					regions = regionsList.get(0);
					if(regions.getName().equals("市辖区") || regions.getName().equals("县")){
						tRegionsExample.clear();
						tRegionsExample.createCriteria().andCodeEqualTo(regions.getpCode()).andIsshowEqualTo(1);
						regionsList = tRegionsMapper.selectByExample(tRegionsExample);
						regions = regionsList.get(0);
						resultMap.put("city", regions.getName());
					}else{
						resultMap.put("city", regions.getName());
					}
					
				}else{
					resultMap.put("city", "");
				}
			}
			result.add(resultMap);
		}
		pi.setList(result);
		return pi;
	}

	@Override
	public PageInfo<Map<String, Object>> findNoBandGoods(Integer row, Integer pageNum, String searchInfo) {
		TSupplierExample tSupplierExample  = new TSupplierExample();
		tSupplierExample.createCriteria().andLinkgoodsidNotEqualTo("0");
		List<TSupplier> suppliers = tSupplierMapper.selectByExample(tSupplierExample);
		List<Integer> bandGoodsId = new ArrayList<Integer>();
		for (TSupplier tSupplier : suppliers) {
			String[] split = tSupplier.getLinkgoodsid().split(",");
			for (int i = 0; i < split.length; i++) {
				bandGoodsId.add(Integer.parseInt(split[i]));
			}
		}
		TGoodsExample tGoodsExample = new TGoodsExample(); 
		com.yundongjia.oa.admin.po.TGoodsExample.Criteria createCriteria = tGoodsExample.createCriteria();
		createCriteria.andStatusEqualTo(0).andStatusEqualTo(0);
		if(suppliers.size() != 0){
			createCriteria.andGoodsidNotIn(bandGoodsId);
		}
		if(searchInfo != null && !"".equals(searchInfo)){
			createCriteria.andGnameLike("%"+searchInfo+"%");
		}
		tGoodsExample.setOrderByClause("goodsId desc");
		PageHelper.startPage(pageNum, row);
		List<TGoods> goods = tGoodsMapper.selectByExample(tGoodsExample);
		PageInfo  pi = new PageInfo(goods);
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for (TGoods ts : goods) {
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("goodsId", ts.getGoodsid());
			resultMap.put("gName", ts.getGname());
			resultMap.put("gPrice", ts.getGprice() + "元");
			switch (ts.getStatus()) {
			case 0:
				resultMap.put("status", "生效");
				break;
			case 1:
				resultMap.put("status", "禁用");
				break;
			case 2:
				resultMap.put("status", "未审核");
				break;
			}
			result.add(resultMap);
		}
		pi.setList(result);
		return pi;
	}

	@Override
	public Integer insertSupplier(TSupplier tSupplier) {
		try {
			int result  = tSupplierMapper.insertSelective(tSupplier); 
			if(result == 1){
				return tSupplier.getRowid();
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Integer insertSupplierLogin(String mobilephonenum) {
		TSupplierLogin tSupplierLogin = new TSupplierLogin();
		tSupplierLogin.setLoginmobilephone(mobilephonenum);
		int result  = tSupplierLoginMapper.insertSelective(tSupplierLogin);
		if(result > 0){
			return tSupplierLogin.getSupplierloginid();
		}
		return 0;
	}

	@Override
	public Map<String, Object> findStatistics() {
		TSupplierExample tSupplierExample = new TSupplierExample();
		int total = tSupplierMapper.countByExample(tSupplierExample);
		tSupplierExample.createCriteria().andStatusEqualTo(0);
		int audit = tSupplierMapper.countByExample(tSupplierExample);
		tSupplierExample.clear();
		tSupplierExample.createCriteria().andStatusEqualTo(1);
		int disable = tSupplierMapper.countByExample(tSupplierExample);
		tSupplierExample.clear();
		tSupplierExample.createCriteria().andStatusEqualTo(2);
		int noAudit = tSupplierMapper.countByExample(tSupplierExample);
		Map<String, Object> result  = new HashMap<String , Object>();
		result.put("total", total);
		result.put("audit", audit);
		result.put("disable", disable);
		result.put("noAudit", noAudit);
		return result;
	}

	@Override
	public PageInfo<TSupplier> findSupplierList(Integer status, String supplierName, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		TSupplierExample tSupplierExample = new TSupplierExample();
		com.yundongjia.oa.admin.po.TSupplierExample.Criteria createCriteria = tSupplierExample.createCriteria();
		if(status != null && status != -1){
			createCriteria.andStatusEqualTo(status);
		}
		if(supplierName != null && !"".equals(supplierName)){
			createCriteria.andSuppliernameLike("%" + supplierName + "%");
		}
		tSupplierExample.setOrderByClause("rowId desc");
		List<TSupplier> supplier = tSupplierMapper.selectByExample(tSupplierExample);
		for (TSupplier ts : supplier) {
			int regId = ts.getRegionsid();
			TRegions regions = null;
			//的到区
			regions = regionsMapper.getAreaByArea(regId);
			// 得到市
			regions = regionsMapper.getCityByArea(regions.getpCode());
			if("市辖区".equals(regions.getName()) || "县".equals(regions.getName())){
				// 得到省
				regions = regionsMapper.getProvinceByCity(regions.getpCode());
				ts.setCity(regions.getName());
			}else{
				ts.setCity(regions.getName());
			}
		}
		PageInfo<TSupplier> result = new PageInfo<TSupplier>(supplier);
		return result;
	}

	@Override
	public Map<String, Object> supplierStatus(Integer status, Integer rowId, String comm) {
		Map<String, Object> result = new HashMap<String , Object>();
		TSupplier tSupplier = new TSupplier();
		tSupplier.setStatus(status);
		tSupplier.setRowid(rowId);
		int resultInfo = tSupplierMapper.updateByPrimaryKeySelective(tSupplier);
		if(resultInfo > 0){
			result.put("result", true);
		}else{
			result.put("result", false);
		}
		return result;
	}

	@Override
	public TSupplier findSupplierDetail(Integer id) {
		TSupplier supplier = tSupplierMapper.selectByPrimaryKey(id);
		Map<String, Object> info = new HashMap<String , Object>();
		Double clearing = 0d;
		Double noclearing = 0d;
		List<Map<String , Object>> studio = new ArrayList<Map<String , Object>>();
		if(!"0".equals(supplier.getLinkstudioid())){
			String[] studioIds = supplier.getLinkstudioid().split(",");
			String[] studioMoney = supplier.getLikestudiocostprice().split(",");
			for (int i = 0; i < studioIds.length; i++) {
				Map<String , Object> map = new HashMap<String, Object>();
				map.put("id", tStudioMapper.selectByPrimaryKey(Integer.parseInt(studioIds[i])).getStudioid());
				map.put("name", tStudioMapper.selectByPrimaryKey(Integer.parseInt(studioIds[i])).getStudioname());
				map.put("money", studioMoney[i]);
				studio.add(map);
				TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
				tStudioConsumeOrderRecordExample.createCriteria().andStudioidEqualTo(Integer.parseInt(studioIds[i])).andPaystatusEqualTo(5);
				List<TStudioConsumeOrderRecord> studioOrder = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
				for (TStudioConsumeOrderRecord ts : studioOrder) {
					Double orderrealmoney = ts.getTotalmoney();
					if(orderrealmoney != -1){
						noclearing = noclearing + orderrealmoney;
					}
				}
				tStudioConsumeOrderRecordExample.clear();
				tStudioConsumeOrderRecordExample.createCriteria().andStudioidEqualTo(Integer.parseInt(studioIds[i])).andPaystatusEqualTo(7);
				List<TStudioConsumeOrderRecord> studioOrder1 = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
				for (TStudioConsumeOrderRecord ts : studioOrder1) {
					Double orderrealmoney = ts.getTotalmoney();
					if(orderrealmoney != -1){
						clearing = clearing + orderrealmoney;
					}
				}
			}
		}
		List<Map<String , Object>> coach = new ArrayList<Map<String , Object>>();
		if(!"0".equals(supplier.getLinkcoachid())){
			String[] coachId = supplier.getLinkcoachid().split(",");
			String[] coachMoney = supplier.getLikecoachcostprice().split(",");
			for (int i = 0; i < coachId.length; i++) {
				Map<String , Object> map = new HashMap<String, Object>();
				map.put("id", tCaochMapper.selectByPrimaryKey(Integer.parseInt(coachId[i])).getCoachid());
				map.put("name", tCaochMapper.selectByPrimaryKey(Integer.parseInt(coachId[i])).getNickname());
				map.put("money", coachMoney[i]);
				coach.add(map);
				TOrderExample tOrderExample = new TOrderExample();
				tOrderExample.createCriteria().andCoachidEqualTo(Integer.parseInt(coachId[i])).andPaystatusEqualTo(5);
				List<TOrder> orders = tOrderMapper.selectByExample(tOrderExample);
				for (TOrder order : orders) {
					Double orderrealmoney = order.getTotalmoney();
					if(orderrealmoney != -1){
						noclearing = noclearing + orderrealmoney;
					}
				}
				tOrderExample.clear();
				tOrderExample.createCriteria().andCoachidEqualTo(Integer.parseInt(coachId[i])).andPaystatusEqualTo(7);
				List<TOrder> orders1 = tOrderMapper.selectByExample(tOrderExample);
				for (TOrder order : orders1) {
					Double orderrealmoney = order.getTotalmoney();
					if(orderrealmoney != -1){
						clearing = clearing + orderrealmoney;
					}
				}
			}
		}
		List<Map<String , Object>> goods = new ArrayList<Map<String , Object>>();
		if(!"0".equals(supplier.getLinkgoodsid())){
			String[] goodsId = supplier.getLinkgoodsid().split(",");
			String[] goodsMoney = supplier.getLikegoodscostprice().split(",");
			for (int i = 0; i < goodsId.length; i++) {
				Map<String , Object> map = new HashMap<String, Object>();
				map.put("id", tGoodsMapper.selectByPrimaryKey(Integer.parseInt(goodsId[i])).getGoodsid());
				map.put("name", tGoodsMapper.selectByPrimaryKey(Integer.parseInt(goodsId[i])).getGname());
				map.put("money", goodsMoney[i]);
				goods.add(map);
				TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
				tGoodsOrderExample.createCriteria().andGidEqualTo(Integer.parseInt(goodsId[i])).andPaystatusEqualTo(5);
				List<TGoodsOrder> goodsOrder = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
				for (TGoodsOrder order : goodsOrder) {
					Double orderrealmoney = order.getTotalmoney();
					if(orderrealmoney != -1){
						noclearing = noclearing + orderrealmoney;
					}
				}
				
				tGoodsOrderExample.clear();
				tGoodsOrderExample.createCriteria().andGidEqualTo(Integer.parseInt(goodsId[i])).andPaystatusEqualTo(7);
				List<TGoodsOrder> goodsOrder1 = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
				for (TGoodsOrder order : goodsOrder1) {
					Double orderrealmoney = order.getTotalmoney();
					if(orderrealmoney != -1){
						clearing = clearing + orderrealmoney;
					}
				}
			}
		}
		
		TRegions regions = null;
		//的到区
		regions = regionsMapper.getAreaByArea(supplier.getRegionsid());
		// 得到市
		regions = regionsMapper.getCityByArea(regions.getpCode());
		if("市辖区".equals(regions.getName()) || "县".equals(regions.getName())){
			// 得到省
			regions = regionsMapper.getProvinceByCity(regions.getpCode());
			info.put("city", regions.getName());
		}else{
			info.put("city", regions.getName());
		}
		info.put("goods", goods);
		info.put("coach", coach);
		info.put("studio", studio);
		info.put("clearing", clearing);
		info.put("noclearing", noclearing);
		supplier.setInfo(info);
		return supplier;
	}

	@Override
	public TRegions findCityByArea(Integer regionsid) {
		TRegionsExample tRegionsExample = new TRegionsExample();
		tRegionsExample.createCriteria().andCodeEqualTo(regionsid);
		List<TRegions> selectByExample = tRegionsMapper.selectByExample(tRegionsExample);
		Integer pcode = selectByExample.get(0).getpCode();
		tRegionsExample.clear();
		tRegionsExample.createCriteria().andCodeEqualTo(pcode);
		return tRegionsMapper.selectByExample(tRegionsExample).get(0);
	}

	@Override
	public TRegions findArea(Integer regionsid) {
		TRegionsExample tRegionsExample = new TRegionsExample();
		tRegionsExample.createCriteria().andCodeEqualTo(regionsid);
		List<TRegions> selectByExample = tRegionsMapper.selectByExample(tRegionsExample);
		return selectByExample.get(0);
	}

	@Override
	public Integer updateSupplier(TSupplier tSupplier) {
		try {
			int result  = tSupplierMapper.updateByPrimaryKeySelective(tSupplier); 
			if(result == 1){
				return tSupplier.getRowid();
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Map<String, Object>> findClearingOrderInfo(Integer id) {
		TSupplier supplier = tSupplierMapper.selectByPrimaryKey(id);
		List<Map<String , Object>> result = new ArrayList<Map<String , Object>>();
		List<Integer> payStatus = new ArrayList<Integer>();
		payStatus.add(5);
		payStatus.add(6);
		payStatus.add(7);
		payStatus.add(8);
		String[] coachids = supplier.getLinkcoachid().split(",");
		for (int i = 0; i < coachids.length; i++) {
			TOrderExample tOrderExample = new TOrderExample();
			tOrderExample.createCriteria().andCoachidEqualTo(Integer.parseInt(coachids[i])).andPaystatusIn(payStatus);
			List<TOrder> orderList = tOrderMapper.selectByExample(tOrderExample);
			for (TOrder order : orderList) {
				Map<String , Object> map = new HashMap<String , Object>();
				TCoach coach = tCoachMapper.selectByPrimaryKey(order.getCoachid());
				map.put("id", order.getOrderid());
				if(coach != null){
					map.put("name", coach.getNickname());
				}else{
					map.put("name", "");
				}
				map.put("money", order.getTotalmoney());
				map.put("createdate", order.getCreatedate());
				map.put("paystatus", order.getPaystatus());
				map.put("type", 3);
				result.add(map);
			}
		}
		
		String[] studioids = supplier.getLinkstudioid().split(",");
		for (int i = 0; i < studioids.length; i++) {
			TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
			tStudioConsumeOrderRecordExample.createCriteria().andStudioidEqualTo(Integer.parseInt(studioids[i])).andPaystatusIn(payStatus);
			List<TStudioConsumeOrderRecord> studioList = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
			for (TStudioConsumeOrderRecord order : studioList) {
				Map<String , Object> map = new HashMap<String , Object>();
				TStudio studio = tStudioMapper.selectByPrimaryKey(order.getStudioid());
				map.put("id", order.getOrderid());
				if(studio != null){
					map.put("name", studio.getStudioname());
				}else{
					map.put("name", "");
				}
				map.put("money", order.getTotalmoney());
				map.put("createdate", order.getCreatedate());
				map.put("paystatus", order.getPaystatus());
				map.put("type", 1);
				result.add(map);
			}
		}
		
		String[] goodsid = supplier.getLinkgoodsid().split(",");
		for (int i = 0; i < goodsid.length; i++) {
			TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
			tGoodsOrderExample.createCriteria().andGidEqualTo(Integer.parseInt(goodsid[i])).andPaystatusIn(payStatus);
			List<TGoodsOrder> goodsList = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
			for (TGoodsOrder order : goodsList) {
				Map<String , Object> map = new HashMap<String , Object>();
				TGoods goods = tGoodsMapper.selectByPrimaryKey(order.getGid());
				map.put("id", order.getOrderid());
				if(goods != null){
					map.put("name", goods.getGname());
				}else{
					map.put("name", "");
				}
				map.put("money", order.getTotalmoney());
				map.put("createdate", order.getCreatedate());
				map.put("paystatus", order.getPaystatus());
				map.put("type", 2);
				result.add(map);
			}
		}
		return result;
	}

	@Override
	public List<Map<String, Object>>  findSavemoneyInfo(Integer supplierId) {
		TSavemoneyExample tSavemoneyExample = new TSavemoneyExample();
		tSavemoneyExample.createCriteria().andSupplieridEqualTo(supplierId);
		List<TSavemoney> savemoney = tSavemoneyMapper.selectByExample(tSavemoneyExample);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (TSavemoney ts : savemoney) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", ts.getRowid());
			map.put("money", ts.getSavemoney());
			map.put("opeartion", tAdminMapper.selectByPrimaryKey(ts.getOpeartionid()).getBackusername());
			map.put("createDate", ts.getCreatedate());
			map.put("expiryDate", ts.getExpirydate());
			map.put("type", ts.getType());
			result.add(map);
		}
		
		return result;
	}

	
	@Override
	public List<TApply> findApplyInfo(Integer rowid) {
		TApplyAccountExample tApplyAccountExample = new TApplyAccountExample();
		tApplyAccountExample.createCriteria().andLiketypeEqualTo(4).andLikeidEqualTo(rowid);
		List<TApplyAccount> account = tApplyAccountMapper.selectByExample(tApplyAccountExample);
		List<TApply> result = new ArrayList<TApply>();
		for (TApplyAccount ta : account) {
			TApplyExample tApplyExample = new TApplyExample();
			tApplyExample.createCriteria().andAppaccountidEqualTo(ta.getRowdid());
			List<TApply> apply = tApplyMapper.selectByExample(tApplyExample);
			result.addAll(apply);
		}
		return result;
	}

	@Override
	public List<TApplyAccount> finAccount(Integer rowid) {
		TApplyAccountExample tApplyAccountExample = new TApplyAccountExample();
		tApplyAccountExample.createCriteria().andLiketypeEqualTo(4).andLikeidEqualTo(rowid);
		return  tApplyAccountMapper.selectByExample(tApplyAccountExample);
	}

	@Override
	public Integer insertAccount(TApplyAccount tApplyAccount) {
		return  tApplyAccountMapper.insertSelective(tApplyAccount);
	}

	@Override
	public Integer updateAccount(TApplyAccount tApplyAccount) {
		return tApplyAccountMapper.updateByPrimaryKeySelective(tApplyAccount);
	}

	@Override
	public Integer insertsavemoney(TSavemoney tSavemoney) {
		TSupplier tSupplier = tSupplierMapper.selectByPrimaryKey(tSavemoney.getSupplierid());
		tSupplier.setSavemoney(tSupplier.getSavemoney() + tSavemoney.getSavemoney());
		tSupplier.setSupersavemoney(tSupplier.getSupersavemoney() + tSavemoney.getSavemoney());
		tSupplier.setSavemoneyexpiredate(tSavemoney.getExpirydate());
		int result1 = tSupplierMapper.updateByPrimaryKeySelective(tSupplier);
		int result2 = tSavemoneyMapper.insertSelective(tSavemoney);
		if(result1 > 0 && result2 >0){
			return tSavemoney.getRowid();
		}else{
			return 0;
		}
	}

	@Override
	public Map<String, Object> orderStatus(Integer type, Integer status, Integer rowId, String comm) {
		int resultInfo =0;
		Map<String, Object> result = new HashMap<String , Object>();
		switch (type) {
		case 1://场馆
			TStudioConsumeOrderRecord tStudioConsumeOrderRecord = new TStudioConsumeOrderRecord();
			tStudioConsumeOrderRecord.setOrderid(rowId);
			tStudioConsumeOrderRecord.setPaystatus(status);
			resultInfo = tStudioConsumeOrderRecordMapper.updateByPrimaryKeySelective(tStudioConsumeOrderRecord);
			if(resultInfo > 0){
				result.put("result", true);
			}else{
				result.put("result", false);
			}
			break;
		case 2://商品
			TGoodsOrder tGoodsOrder = new TGoodsOrder();
			tGoodsOrder.setOrderid(rowId);
			tGoodsOrder.setPaystatus(status);
			resultInfo = tGoodsOrderMapper.updateByPrimaryKeySelective(tGoodsOrder);
			if(resultInfo > 0){
				result.put("result", true);
			}else{
				result.put("result", false);
			}
			break;
		case 3://私课
			TOrder tOrder = new TOrder();
			tOrder.setOrderid(rowId);
			tOrder.setPaystatus(status);
			resultInfo = tOrderMapper.updateByPrimaryKeySelective(tOrder);
			if(resultInfo > 0){
				result.put("result", true);
			}else{
				result.put("result", false);
			}
			break;
		}
		
		return result;
	}
	/**
	 * accountInfo  --->  ${u.rowdid}~${u.type}
	 */
	@Override
	public Integer insertApply(String accountInfo, Double comeMoney) {
		String[] accoun = accountInfo.split("~");
		TApply tApply = new TApply();
		tApply.setOrdernum(System.currentTimeMillis()+"");
		tApply.setAmount(comeMoney);
		tApply.setCreatedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		tApply.setPaystatus(accoun[1]);
		tApply.setMessagestatus("0");
		tApply.setOrdermemo("提现");
		tApply.setApplystatus("0");
		tApply.setStatus("0");
		tApply.setAppaccountid(Integer.parseInt(accoun[0]));
		int result1 = tApplyMapper.insertSelective(tApply);
		TApplyAccount account = tApplyAccountMapper.selectByPrimaryKey(Integer.parseInt(accoun[0]));
		TSupplier supplier = tSupplierMapper.selectByPrimaryKey(account.getLikeid());
		supplier.setBalance(supplier.getBalance() - comeMoney);
		int result2 = tSupplierMapper.updateByPrimaryKeySelective(supplier);
		if(result1 > 0 && result2 > 0){
			return tApply.getRowid();
		}else{
			return 0;
		}
	}

	@Override
	public Integer updateApplyStatus(TApply tApply) {
		return tApplyMapper.updateByPrimaryKeySelective(tApply);
	}


}

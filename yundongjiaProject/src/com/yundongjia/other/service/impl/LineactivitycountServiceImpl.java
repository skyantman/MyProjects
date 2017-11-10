package com.yundongjia.other.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TLineActivityCountMapper;
import com.yundongjia.oa.admin.po.TLineActivityCount;
import com.yundongjia.oa.admin.po.TLineActivityCountExample;
import com.yundongjia.other.service.LineactivitycountService;

@Service
public class LineactivitycountServiceImpl implements LineactivitycountService {
	@Autowired
	private TLineActivityCountMapper tLineActivityCountMapper;
	
	@Override
	public Integer insertSelective(TLineActivityCount tLineActivityCount) {
		int insertSelective = tLineActivityCountMapper.insertSelective(tLineActivityCount);
		if(insertSelective != 0){
			return tLineActivityCount.getLineid();
		}else{
			return  0;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(TLineActivityCount tLineActivityCount) {
		return tLineActivityCountMapper.updateByPrimaryKeySelective(tLineActivityCount);
	}

	@Override
	public List<TLineActivityCount> selectSumInfo(int type, int status) {
		TLineActivityCountExample tLineActivityCountExample = new TLineActivityCountExample();
		tLineActivityCountExample.createCriteria().andTypeEqualTo(type).andStatusEqualTo(status);
		List<TLineActivityCount> list = tLineActivityCountMapper.selectByExample(tLineActivityCountExample);
		return list;
	}

}

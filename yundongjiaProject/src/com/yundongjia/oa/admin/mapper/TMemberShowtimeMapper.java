package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TMemberShowtime;
import com.yundongjia.oa.admin.po.TMemberShowtimeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMemberShowtimeMapper {
    int countByExample(TMemberShowtimeExample example);

    int deleteByExample(TMemberShowtimeExample example);

    int deleteByPrimaryKey(Integer timeid);

    int insert(TMemberShowtime record);

    int insertSelective(TMemberShowtime record);

    List<TMemberShowtime> selectByExample(TMemberShowtimeExample example);

    TMemberShowtime selectByPrimaryKey(Integer timeid);

    int updateByExampleSelective(@Param("record") TMemberShowtime record, @Param("example") TMemberShowtimeExample example);

    int updateByExample(@Param("record") TMemberShowtime record, @Param("example") TMemberShowtimeExample example);

    int updateByPrimaryKeySelective(TMemberShowtime record);

    int updateByPrimaryKey(TMemberShowtime record);

	/**
	 * @return查询用户的运动时间排名
	 */
	List<Map<String, Object>> findRank();
}
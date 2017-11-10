package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TLeague;
import com.yundongjia.oa.admin.po.TLeagueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeagueMapper {
    int countByExample(TLeagueExample example);

    int deleteByExample(TLeagueExample example);

    int deleteByPrimaryKey(Integer leagueid);

    int insert(TLeague record);

    int insertSelective(TLeague record);

    List<TLeague> selectByExample(TLeagueExample example);

    TLeague selectByPrimaryKey(Integer leagueid);

    int updateByExampleSelective(@Param("record") TLeague record, @Param("example") TLeagueExample example);

    int updateByExample(@Param("record") TLeague record, @Param("example") TLeagueExample example);

    int updateByPrimaryKeySelective(TLeague record);

    int updateByPrimaryKey(TLeague record);
}
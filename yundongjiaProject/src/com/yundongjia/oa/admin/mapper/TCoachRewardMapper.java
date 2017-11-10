package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCoachReward;
import com.yundongjia.oa.admin.po.TCoachRewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCoachRewardMapper {
    int countByExample(TCoachRewardExample example);

    int deleteByExample(TCoachRewardExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TCoachReward record);

    int insertSelective(TCoachReward record);

    List<TCoachReward> selectByExample(TCoachRewardExample example);

    TCoachReward selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TCoachReward record, @Param("example") TCoachRewardExample example);

    int updateByExample(@Param("record") TCoachReward record, @Param("example") TCoachRewardExample example);

    int updateByPrimaryKeySelective(TCoachReward record);

    int updateByPrimaryKey(TCoachReward record);
    
    
}
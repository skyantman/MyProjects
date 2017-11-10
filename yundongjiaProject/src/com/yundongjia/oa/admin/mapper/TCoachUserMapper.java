package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCoachUser;
import com.yundongjia.oa.admin.po.TCoachUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCoachUserMapper {
    int countByExample(TCoachUserExample example);

    int deleteByExample(TCoachUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(TCoachUser record);

    int insertSelective(TCoachUser record);

    List<TCoachUser> selectByExample(TCoachUserExample example);

    TCoachUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") TCoachUser record, @Param("example") TCoachUserExample example);

    int updateByExample(@Param("record") TCoachUser record, @Param("example") TCoachUserExample example);

    int updateByPrimaryKeySelective(TCoachUser record);

    int updateByPrimaryKey(TCoachUser record);
}
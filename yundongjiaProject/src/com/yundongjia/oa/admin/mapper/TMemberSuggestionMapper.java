package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TMemberSuggestion;
import com.yundongjia.oa.admin.po.TMemberSuggestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMemberSuggestionMapper {
    int countByExample(TMemberSuggestionExample example);

    int deleteByExample(TMemberSuggestionExample example);

    int deleteByPrimaryKey(Integer suggestionid);

    int insert(TMemberSuggestion record);

    int insertSelective(TMemberSuggestion record);

    List<TMemberSuggestion> selectByExample(TMemberSuggestionExample example);

    TMemberSuggestion selectByPrimaryKey(Integer suggestionid);

    int updateByExampleSelective(@Param("record") TMemberSuggestion record, @Param("example") TMemberSuggestionExample example);

    int updateByExample(@Param("record") TMemberSuggestion record, @Param("example") TMemberSuggestionExample example);

    int updateByPrimaryKeySelective(TMemberSuggestion record);

    int updateByPrimaryKey(TMemberSuggestion record);
}
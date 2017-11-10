package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TAttachExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TAttachMapper {
    int countByExample(TAttachExample example);

    int deleteByExample(TAttachExample example);

    int deleteByPrimaryKey(Integer attachid);

    int insert(TAttach record);

    int insertSelective(TAttach record);

    List<TAttach> selectByExample(TAttachExample example);

    TAttach selectByPrimaryKey(Integer attachid);

    int updateByExampleSelective(@Param("record") TAttach record, @Param("example") TAttachExample example);

    int updateByExample(@Param("record") TAttach record, @Param("example") TAttachExample example);

    int updateByPrimaryKeySelective(TAttach record);

    int updateByPrimaryKey(TAttach record);
    
    /**
    * Title: updateAttachByPosiAid
    * Description: 根据活动id和排序修改图片路径
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年1月20日
    */
    Integer updateAttachByPosiAid(@Param("param") Map<String, Object> param);
    
    /**
    * Title: selectAttachByPosAid
    * Description: 根据位置和活动ID查询数据
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年1月20日
    */
    TAttach selectAttachByPosAid(@Param("param") Map<String, Object> param);
    
    /**
    * Title: deleteByAttachPorIdAndAttType
    * Description: 删除图片 根据proId and attachType
    * @param attach
    * @return
    * @author HuangJian
    * @date 2017年2月11日
    */
    Integer deleteByAttachPorIdAndAttType(TAttach attach);
	/**
	 * @param param
	 * @return查询活动图片列表
	 */
	List<Map<String, Object>> findImgs(Map<String, Object> param);
}
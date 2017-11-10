package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.po.TAdminExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TAdminMapper {
    int countByExample(TAdminExample example);

    int deleteByExample(TAdminExample example);

    int deleteByPrimaryKey(Integer backuserid);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    List<TAdmin> selectByExample(TAdminExample example);

    TAdmin selectByPrimaryKey(Integer backuserid);

    int updateByExampleSelective(@Param("record") TAdmin record, @Param("example") TAdminExample example);

    int updateByExample(@Param("record") TAdmin record, @Param("example") TAdminExample example);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);
    
    TAdmin selectByGYMUserName(TAdmin record);
    
    /**
	 * @param baseUser
	 * @return更新会员密码
	 */
	Integer updateByPhone(Map param);
	/**
	 * 
	* Title: 
	* Description:根据角色id删除用户所在的角色
	 */
	int updateBaseUserRoleByRoleIds(@Param("param") Map<String, Object> param);
	/**
	 * @return 根据工作人员类型查询信息 Li XiaoYang 2016.11.5
	 */
	List<Map> searchBUByType(Map parm);
	List<Map> searchBUByTypeARole(Map param);

	Integer selectByPhone(Map param);
}
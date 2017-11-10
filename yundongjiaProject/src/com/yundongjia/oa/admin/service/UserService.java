package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.vo.UserVo;


/**
 * Created by ltlxy on 2016/9/18.
 */
public interface UserService {

    int gymlogin(TAdmin baseUser);

    void gymlogout();

    int updateGymPasswordByOldPassword(Integer userId,String oldPassword,String newPassword);
    /**
     * 
    * Title: 
    * Description: 根据用户名查找其角色  
    * @author HuangJian
    * @date 2016年11月8日
     */
    public Set<String> findRoles(String username);
    /**
     * 
    * Title: 
    * Description:根据用户名查找其权限
    * @author HuangJian
    * @date 2016年11月8日
     */
    public Set<String> findPermissions(String username,String flag);
	/**
	 * @param baseUser
	 * @return更新会员密码
	 * @author Li XiaoYang
    * @date 2016年11月11日
	 */
	Integer configPassword(String userPassword , String userMobilephoneno , String msg) ;

	/**
	 * @param phonenum
	 * @param authCode
	 * @param iP 
 	 * @return  插入验证码相关信息
	 */
	Integer insetBaseMsg(String phonenum, String authCode, String iP);
	
	/**
	 * @param authCode
	 * @param phonenum
	 * @return查询验证码是否匹配
	 */
	Integer checkCode(String authCode, String phonenum);

	Integer selectByPhone(String phone);

	List<TAdmin> selectBUByUserType();

	/**
	 * @param searchInfo
	 * @return根据手机号或姓名查询工作人员
	 */
	List<TAdmin> selectBUByphoneOrName(String searchInfo);
	/**
	 * @param searchInfo
	 * @return插入工作人员信息
	 */
	Integer insertWorker(TAdmin baseUser, UserVo userVo);
	/**
	 * @param searchInfo
	 * @return根据ID查询工作人员
	 */
	TAdmin selectBUById(Integer userId);

	Integer deleteWorker(Integer userId, Integer loginUserId);
	/**
	 * @return 更新工作人员信息Li XiaoYang 2016.11.4
	 */
	Integer updateWorkerInfo(TAdmin baseUser, UserVo userVo);
	
	
	
	
	
	
	
	 
	/**
	* Title: insertTuser
	* Description: 添加企业用户
	* @param user
	* @param cardId
	* @param 
	* @return
	* @author HuangJian
	* @date 2017年1月16日
	*/
	Map<String, Object> insertTuser(TUser user,Integer cardId);
	
	
	/**
	* Title: findTuserListByMobilePhone
	* Description: 全查卡下的所有用户，根据手机号码查询 
	* @param mobilePhone:手机号码 如果为空  全查
	* @return
	* @author HuangJian
	* @date 2017年1月16日
	*/
	List<Map<String, Object>> findTuserListByMobilePhone(String mobilePhone,Integer cardId);
	
	/**
	* Title: updateTuserById
	* Description: 修改用户信息
	* @param user
	* @return
	* @author HuangJian
	* @date 2017年1月16日
	*/
	int updateTuserById(TUser user);
	
	/**
	* Title: getTuserById
	* Description: 根据id查询用户详情
	* @param userId
	* @return
	* @author HuangJian
	* @date 2017年1月16日
	*/
	List<Map<String, Object>> getTuserById(Integer userId);
	
	
	/**
	* Title: getTuserMobilePhoneCount
	* Description: 根据不同表名称查询手机号码是否存在
	* @param mobilePhone
	* @param tType 表名称
	* @return
	* @author HuangJian
	* @date 2017年2月13日
	*/
	Integer getTuserMobilePhoneCount(String mobilePhone,Integer tType);
	
	/**
	* Title: UserService.java
	* Description: 条件查询或全查  企业端
	* @param mobilePhone 用户的手机号码
	* @param cards 企业的卡
	* @return
	* @author HuangJian
	* @date 2017年4月18日
	*/
	List<Map<String, Object>> findUserByMobilePhoneCards(String mobilePhone,List<Integer> cards);

	
	
	/**
	* Title: UserService.java
	* Description: 根据企业卡查询所有企业用户
	* @param cards
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	List<Map<String, Object>> findUserByCards(List<Integer> cards);
}

package com.yundongjia.oa.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yundongjia.oa.admin.mapper.TAdminAuthRefMapper;
import com.yundongjia.oa.admin.mapper.TAdminMapper;
import com.yundongjia.oa.admin.mapper.TMenuAdminRefMapper;
import com.yundongjia.oa.admin.mapper.TRoleMapper;
import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.po.TAdminAuthRef;
import com.yundongjia.oa.admin.po.TAdminAuthRefExample;
import com.yundongjia.oa.admin.po.TMenuAdminRef;
import com.yundongjia.oa.admin.po.TMenuAdminRefExample;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRole;
import com.yundongjia.oa.admin.po.TRoleExample;
import com.yundongjia.oa.admin.service.AuthService;
import com.yundongjia.oa.admin.vo.ConstantVo;

/**
 * Created by ltlxy on 2016/9/29.
 */
@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private TAdminAuthRefMapper baseUserAuthRefMapper;
    @Autowired
    private TMenuAdminRefMapper baseMenuUserRefMapper;
    @Autowired
    private TRoleMapper baseRoleMapper;
    @Autowired
    private TAdminMapper baseUserMapper;

    @Override
    public int insertRole(TRole role, String[] authStr, String[] menuStr) throws Exception{
        Date current = new Date();
        int res = this.baseRoleMapper.insertSelective(role);
        //批量添加authRoleRef
        List<TAdminAuthRef> ualist = new ArrayList<TAdminAuthRef>();
        List<TMenuAdminRef> mrlist = new ArrayList<TMenuAdminRef>();
        TAdminAuthRef ra ;
        TMenuAdminRef mr ;
        if(authStr != null){
            for (String authId : authStr){
                ra = new TAdminAuthRef();
                ra.setAdminAuthRoleId(role.getRoleId());
                ra.setAdminAuthAuthId(Integer.parseInt(authId));
                ra.setAdminAuthCreateDate(current);
                ra.setAdminAuthOperatorid(role.getRoleOperatorid());
                ualist.add(ra);
            }
            this.baseUserAuthRefMapper.insertRoleAuthRefs(ualist);
        }
        //批量添加menuRoleRef
        if (menuStr != null){
            for (String menuId : menuStr){
                mr = new TMenuAdminRef();
                mr.setMenuAdminCreateDate(current);
                mr.setMenuAdminMenuId(Integer.parseInt(menuId));
                mr.setMenuAdminOperatorid(role.getRoleOperatorid());
                mr.setMenuAdminRoleId(role.getRoleId().toString());
                mrlist.add(mr);
            }
            this.baseMenuUserRefMapper.insertMenuRoleRefs(mrlist);
        }
        return res;
    }

    @Override
    public List<TRole> selectRolesByStudioId(Integer studioId) {
        TRoleExample example = new TRoleExample();
        example.createCriteria()
                .andRoleStudioIdEqualTo(studioId)
                .andRoleIsdelEqualTo("0");
        example.setOrderByClause("role_createdate DESC");
        return this.baseRoleMapper.selectByExample(example);
    }

    @Override
    public int delectRoleById(Map<String, Object> param) {
    	System.out.println("ok");
    	/**
    	 * 删除角色，把拥有角色的用户的role_id改为0
    	 */
    	//把所有用户为roleId的置0
    	int result = baseUserMapper.updateBaseUserRoleByRoleIds(param);
    	
        TRole role = new TRole();
        role.setRoleIsdel("1");
        role.setRoleId(Integer.parseInt(String.valueOf(param.get("roleId"))));
        role.setRoleOperatorid(Integer.parseInt(String.valueOf(param.get("operation"))));
        return this.baseRoleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 查询菜单id集合
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> selectMenuIdsByRoleId(Integer roleId) {
        List<Integer> menuIds = new ArrayList<Integer>();
        TMenuAdminRefExample example = new TMenuAdminRefExample();
        example.createCriteria()
                .andMenuAdminRoleIdEqualTo(roleId.toString());
        List<TMenuAdminRef> list = this.baseMenuUserRefMapper.selectByExample(example);
        if (list != null && list.size() > 0){
            for (TMenuAdminRef b : list){
                menuIds.add(b.getMenuAdminMenuId());
            }
        }
        return menuIds;
    }

    /**
     * 查询权限id集合
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> selectAutoIdsByRoleId(Integer roleId) {
        List<Integer> authIds = new ArrayList<Integer>();
        TAdminAuthRefExample example = new TAdminAuthRefExample();
        example.createCriteria()
                .andAdminAuthRoleIdEqualTo(roleId);
        List<TAdminAuthRef> list = this.baseUserAuthRefMapper.selectByExample(example);
        if (list != null && list.size() > 0){
            for (TAdminAuthRef b : list){
                authIds.add(b.getAdminAuthAuthId());
            }
        }
        return authIds;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED , rollbackFor=Exception.class)
    public int updateRole(TRole role, String[] authStr, String[] menuStr,Integer operatorId) throws Exception {
        Date current = new Date();
        if (role.getRoleIsclose() == null){
            role.setRoleIsclose("0");
        }
        int res = this.baseRoleMapper.updateByPrimaryKeySelective(role);

        TAdminAuthRefExample uae = new TAdminAuthRefExample();
        uae.createCriteria().andAdminAuthRoleIdEqualTo(role.getRoleId());

        TMenuAdminRefExample mer = new TMenuAdminRefExample();
        mer.createCriteria().andMenuAdminRoleIdEqualTo(role.getRoleId().toString());

        this.baseUserAuthRefMapper.deleteByExample(uae);
        this.baseMenuUserRefMapper.deleteByExample(mer);

        //批量添加authRoleRef
        List<TAdminAuthRef> ualist = new ArrayList<TAdminAuthRef>();
        List<TMenuAdminRef> mrlist = new ArrayList<TMenuAdminRef>();
        TAdminAuthRef ra ;
        TMenuAdminRef mr ;
        if(authStr != null){
            for (String authId : authStr){
                ra = new TAdminAuthRef();
                ra.setAdminAuthRoleId(role.getRoleId());
                ra.setAdminAuthAuthId(Integer.parseInt(authId));
                ra.setAdminAuthCreateDate(current);
                ra.setAdminAuthOperatorid(operatorId);
                ualist.add(ra);
            }
            this.baseUserAuthRefMapper.insertRoleAuthRefs(ualist);
        }
        //批量添加menuRoleRef
        if (menuStr != null){
            for (String menuId : menuStr){
                mr = new TMenuAdminRef();
                mr.setMenuAdminCreateDate(current);
                mr.setMenuAdminMenuId(Integer.parseInt(menuId));
                mr.setMenuAdminOperatorid(operatorId);
                mr.setMenuAdminRoleId(role.getRoleId().toString());
                mrlist.add(mr);
            }
            this.baseMenuUserRefMapper.insertMenuRoleRefs(mrlist);
        }
        
        return res;
    }

	@Override
	public List<TRole> selectRoleByName(String roleName) {
		TRoleExample example=new TRoleExample();
		
		example.createCriteria().andRoleNameEqualTo(roleName).andRoleIsdelEqualTo(ConstantVo.IS_NO_DEL.toString());
		return baseRoleMapper.selectByExample(example);
	}
	 /**
     * 
    * Title: 
    * Description:排重角色名称
    * @author Li XiaoYang
    * @date 2016年11月28日
     */
	@Override
	public Integer selectRoleName(String roleName) {
		int result = 1;
		TRoleExample tRoleExample = new TRoleExample();
		tRoleExample.createCriteria().andRoleIsdelEqualTo("0");
		List<TRole> info = baseRoleMapper.selectByExample(tRoleExample);
		for (TRole map : info) {
			if(roleName.equals(map.getRoleName())){
				result = 0;
			}
		}
		return result;
	}
	
	@Override
	public Integer updateAuthRole(String oldUserId, String newUserId, Integer roleId) {
		String[] oldIdArr = oldUserId.split(",");
    	String[] newIdArr = newUserId.split(",");
    	Integer result = 1; 
    	//更新所有提交的新的roleID
    	if(!"".equals(newIdArr[0])){
			for (int j = 0; j < newIdArr.length; j++) {
				TAdmin baseUser = new TAdmin();
				baseUser.setBackuserid(Integer.parseInt(newIdArr[j]));
				baseUser.setBackuserroleid(roleId);
				int r = baseUserMapper.updateByPrimaryKeySelective(baseUser);
				if(r == 0){
					result = 0;
				}
			}
    	}
		Integer[] newId = new Integer[newIdArr.length];
		Integer[] oldId = new Integer[oldIdArr.length];
		if(!"".equals(oldIdArr[0])){
			for (int i = 0; i < oldIdArr.length; i++) {
				oldId[i] = Integer.parseInt(oldIdArr[i]);
			}
		}
		if(!"".equals(newIdArr[0])){
			for (int i = 0; i < newIdArr.length; i++) {
				newId[i] = Integer.parseInt(newIdArr[i]);
			}
		}
		int length = oldIdArr.length;
		int length2 = newIdArr.length;
		//将删除掉的RoleID更新为0
		if(oldIdArr.length > newIdArr.length || newId[0] == null){
			List<Integer> list = compare(newId,oldId);
			for (Integer integer : list) {
				TAdmin baseUser = new TAdmin();
				baseUser.setBackuserid(integer);
				baseUser.setBackuserroleid(0);
				int r = baseUserMapper.updateByPrimaryKeySelective(baseUser);
				if(r == 0){
					result = 0;
				}
			}
		}
		return result;
	}
	
	//从两个数组中取出不同的元素
	private static <T> List<T> compare(T[] t1, T[] t2) {    
	      List<T> list1 = Arrays.asList(t1);    
	      List<T> list2 = new ArrayList<T>();    
	      for (T t : t2) {    
	          if (!list1.contains(t)) {    
	              list2.add(t);    
	          }    
	      }    
	      return list2;    
	  }   
	  //实例
	  public static void main(String[] arg){  
	        
	        Integer[] array1 = {1, 2, 3};  
	        Integer[] array2 = {1, 2, 3, 4,44};  
	          
	        List<Integer> list = compare(array1,array2);  
	        for (Integer integer : list) {  
	            System.out.println(integer);  
	        }  
	  }
	  
	  @Override
	    public List<TRole> selectRoleByStudioId() {
	        TRoleExample example = new TRoleExample();
	        example.createCriteria()
	                .andRoleIsdelEqualTo("0");
	        example.setOrderByClause("role_createdate DESC");
	        return this.baseRoleMapper.selectByExample(example);
	    }

	  /**
	     * 
	    * Title: 
	    * Description:查询工作人员根据场馆ID
	     */
		@Override
		public List<Map> searchBUByType() {
			Map param = new HashMap();
			param.put("typeInfo", 3);
			return baseUserMapper.searchBUByType(param);
		}
		/**
	     * 
	    * Title: 
	    * Description:查询工作人员根据场馆ID与角色ID
	    * @author Li XiaoYang
	    * @date 2016年11月29日
	     */
		@Override
		public List<Map> searchBUByTypeARole(Integer roleId) {
			Map param = new HashMap();
			param.put("roleId",roleId);
			return baseUserMapper.searchBUByTypeARole(param);
		}
}
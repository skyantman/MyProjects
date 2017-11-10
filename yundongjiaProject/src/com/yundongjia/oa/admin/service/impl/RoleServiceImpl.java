package com.yundongjia.oa.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TRoleMapper;
import com.yundongjia.oa.admin.po.TRole;
import com.yundongjia.oa.admin.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private TRoleMapper baseRoleMapper;
	
	@Override
	public TRole getRoleById(Integer roleId) {
		
		
		return baseRoleMapper.selectByPrimaryKey(roleId);
	}

	public TRoleMapper getBaseRoleMapper() {
		return baseRoleMapper;
	}

	public void setBaseRoleMapper(TRoleMapper  baseRoleMapper) {
		this.baseRoleMapper = baseRoleMapper;
	}

}

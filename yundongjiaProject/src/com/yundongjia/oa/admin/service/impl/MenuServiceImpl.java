package com.yundongjia.oa.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TMenuMapper;
import com.yundongjia.oa.admin.mapper.TOpeartionMapper;
import com.yundongjia.oa.admin.mapper.TRoleMapper;
import com.yundongjia.oa.admin.po.TAuth;
import com.yundongjia.oa.admin.po.TMenu;
import com.yundongjia.oa.admin.po.TMenuExample;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.MenuService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.MenuVo;

/**
 * Created by ltlxy on 2016/9/20.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private TMenuMapper baseMenuMapper;
    @Autowired
    private TRoleMapper baseRoleMapper;
    /*
     * 操作记录
     */
    @Autowired
    private TOpeartionMapper tOpeartionMapper;
    @Override
    public List<TMenu> getList() {
    	TMenuExample example = new TMenuExample();
    	example.createCriteria().andMenuIsdelEqualTo(ConstantVo.IS_NO_DEL);
        return baseMenuMapper.selectByExample(example);
    }

    @Override
    public List<TMenu> getGYMAdminList() {
        TMenuExample example = new TMenuExample();
        example.createCriteria()
                .andMenuIsdelEqualTo(Byte.parseByte("0"))
                .andMenuIsshowEqualTo(Byte.parseByte("1"));
        example.setOrderByClause("menu_isroot DESC, menu_ordernum DESC");
        return this.baseMenuMapper.selectByExample(example);
    }



    @Override
    public List<MenuVo> selectGYMTree() {
        List<MenuVo> menuVos = this.baseMenuMapper.selectGYMTree();
        List<MenuVo> list = new ArrayList<MenuVo>();
        List<MenuVo> tlist = new ArrayList<MenuVo>();
        List<MenuVo> clist = new ArrayList<MenuVo>();
        List<TAuth> alist = new ArrayList<TAuth>();
        Map<Integer,MenuVo> temp = new HashMap<Integer, MenuVo>();
        for (MenuVo mv : menuVos){
            if (mv.getAuth() != null){
                alist.add(mv.getAuth());
            }
        }

        for (MenuVo mv : menuVos){
            if(mv.getMenuIsroot() == 0 && !temp.containsKey(mv.getMenuId()) ){
                temp.put(mv.getMenuId(),mv);
                clist.add(mv);
            }else if (mv.getMenuIsroot() == 1 && !temp.containsKey(mv.getMenuId())){
                temp.put(mv.getMenuId(),mv);
                tlist.add(mv);
            }
        }

        for (MenuVo mv : clist){
            for (TAuth ba : alist){
                if (mv.getMenuId() == ba.getAuthMenuId()){
                    mv.getAuthList().add(ba);
                }
            }
        }

        for (MenuVo mv : tlist){
            for (MenuVo mv2 : clist){
                if (Integer.parseInt(mv2.getMenuPid()) == mv.getMenuId().intValue()){
                    mv.getMenuVoList().add(mv2);
                }
            }
        }

        for (MenuVo mv : tlist){
            if (mv.getMenuVoList().size() > 0){
                list.add(mv);
            }
        }

        return list;
    }

	@Override
	public List<MenuVo> findTreeBulider(Map<String, Object> map) {
		

		return  baseMenuMapper.findBaseMenuTree(map);
	}

	@Override
	public int deleteBaseMenuById(Integer id) {
		int result=0;
		//根据id查询是否是根节点
		TMenu menu=this.baseMenuMapper.selectByPrimaryKey(id);
		
		if(menu != null){
			if(menu.getMenuIsroot() == 0){
				
			}else if(menu.getMenuIsroot() == 1){
				
				//删除所有子节点
				result=baseMenuMapper.updateBaseMenuByPid(menu.getMenuId());
			}
		}
		//删除根节点同时，删除自身 (先删除子节点，再删除根节点，不能调换顺序)
		result = baseMenuMapper.updateBaseMenuById(menu.getMenuId());
		
		return result;
	}

	@Override
	public int saveBaseMenu(TMenu menu,boolean isRoot) {
		
		int id = baseMenuMapper.insertSelective(menu);
		if(isRoot){
			TMenu record=new TMenu();
			record.setMenuId(menu.getMenuId());
			record.setMenuPid(menu.getMenuId().toString());
			//把pid修改成主键
			baseMenuMapper.updateByPrimaryKeySelective(record);
		}
		//返回增加的id
		return menu.getMenuId();
	}

	@Override
	public int updateBaseMenu(TMenu menu) {
		
		return baseMenuMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public TMenu selectBaseMenuById(Integer mId) {
		
		return baseMenuMapper.selectByPrimaryKey(mId);
	}

	@Override
	public TMenu selectBaseMenuByPid(Integer pId) {
		
		TMenuExample example=new TMenuExample();
		example.createCriteria().andMenuIdEqualTo(pId);
		
		return baseMenuMapper.selectByExample(example).get(0);
	}

	@Override
	public List<MenuVo> selectTCTree(Map<String, Object> map) {
		List<MenuVo> menuVos = this.baseMenuMapper.findBaseMenuTree(map);
        List<MenuVo> list = new ArrayList<MenuVo>();
        List<MenuVo> tlist = new ArrayList<MenuVo>();
        List<MenuVo> clist = new ArrayList<MenuVo>();
        List<TAuth> alist = new ArrayList<TAuth>();
        Map<Integer,MenuVo> temp = new HashMap<Integer, MenuVo>();
        for (MenuVo mv : menuVos){
            if (mv.getAuth() != null){
                alist.add(mv.getAuth());
            }
        }

        for (MenuVo mv : menuVos){
            if(mv.getMenuIsroot() == 0 && !temp.containsKey(mv.getMenuId()) ){
                temp.put(mv.getMenuId(),mv);
                clist.add(mv);
            }else if (mv.getMenuIsroot() == 1 && !temp.containsKey(mv.getMenuId())){
                temp.put(mv.getMenuId(),mv);
                tlist.add(mv);
            }
        }

        for (MenuVo mv : clist){
            for (TAuth ba : alist){
                if (mv.getMenuId() == ba.getAuthMenuId()){
                    mv.getAuthList().add(ba);
                }
            }
        }

        for (MenuVo mv : tlist){
            for (MenuVo mv2 : clist){
                if (Integer.parseInt(mv2.getMenuPid()) == mv.getMenuId().intValue()){
                    mv.getMenuVoList().add(mv2);
                }
            }
        }

        for (MenuVo mv : tlist){
            if (mv.getMenuVoList().size() > 0){
                list.add(mv);
            }
        }

        return list;
	}

	@Override
	public List<TMenu> selectBaseMenuByPowerid(String pwoerid) {
		
		TMenuExample example=new TMenuExample();
		example.createCriteria().andMenuPoweridEqualTo(pwoerid).andMenuIsdelEqualTo((byte)0);
		
		return baseMenuMapper.selectByExample(example);
	}
	
	
	
	
	
	
}

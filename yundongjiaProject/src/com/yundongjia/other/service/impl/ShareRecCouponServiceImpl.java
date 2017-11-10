package com.yundongjia.other.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TCouponMapper;
import com.yundongjia.oa.admin.mapper.TMemberCouponRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TUserMapper;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCoupon;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberCouponRefExample;
import com.yundongjia.oa.admin.po.TMemberExample;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.po.TUserExample;
import com.yundongjia.other.service.ShareRecCouponService;

@Service
public class ShareRecCouponServiceImpl implements ShareRecCouponService{
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TMemberMapper tMemberMapper;
	@Autowired
	private TMemberCouponRefMapper tMemberCouponRefMapper;
	@Autowired
	private TCouponMapper tCouponMapper;
	
	@Override
	public boolean findIsRegister(String phone) {
		TUserExample tUserExample = new TUserExample();
		tUserExample.createCriteria().andMobilephonenoEqualTo(phone);
		List<TUser> selectByExample = tUserMapper.selectByExample(tUserExample);
		if(selectByExample.size() > 0){
			return true;
		}else{
			return false;
		}
			
	}
	@Override
	public String findIsRecCoupon(String phone , Integer CouponTypeId) {
		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TUserExample tUserExample = new TUserExample();
			tUserExample.createCriteria().andMobilephonenoEqualTo(phone);
			List<TUser> users = tUserMapper.selectByExample(tUserExample);
			if(users.size() <= 0){
				return "1";
			}else{
				TMemberExample tMemberExample = new TMemberExample();
				tMemberExample.createCriteria().andUseridEqualTo(users.get(0).getUserid());
				List<TMember> members = tMemberMapper.selectByExample(tMemberExample);
				if(members.size() <=0){
					return "1";
				}else {
					TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
					tMemberCouponRefExample.createCriteria().andMemberidEqualTo(members.get(0).getMemberid()).andCouponidEqualTo(CouponTypeId);
					List<TMemberCouponRef> memberCoupons = tMemberCouponRefMapper.selectByExample(tMemberCouponRefExample);
					if(memberCoupons.size() <= 0){
						TCoupon coupon = tCouponMapper.selectByPrimaryKey(CouponTypeId);
						if(coupon.getSurplusstock() <= 0){
							return "3";
						}else{
							TMemberCouponRef tMemberCouponRef = new TMemberCouponRef();
							tMemberCouponRef.setCouponid(CouponTypeId);
							tMemberCouponRef.setMemberid(members.get(0).getMemberid());
							tMemberCouponRef.setStatus("0");
							tMemberCouponRef.setCreatedate(sim.format(new Date()));
							Calendar calendar = new GregorianCalendar();
							calendar.add(calendar.DATE, coupon.getValidday());// 把日期往后增加一天.整数往后推,负数往前移动
							tMemberCouponRef.setExpirtiondate(sim.format(calendar.getTime()));
							tMemberCouponRef.setCouponmethod(coupon.getCouponmethod());
							tMemberCouponRef.setDiscountamount(coupon.getAmount());
							tMemberCouponRef.setCoupontype(coupon.getCoupontype());
							tMemberCouponRef.setMaxmoney(coupon.getAmount());
							tMemberCouponRef.setStartmoney(coupon.getAmount());
							tMemberCouponRef.setGainmethod(3);
							int result = tMemberCouponRefMapper.insertSelective(tMemberCouponRef);
							if(result != 1){
								return "4";
							}else{
								if(coupon.getSurplusstock() - 1 >= 0){
									coupon.setSurplusstock(coupon.getSurplusstock() - 1);
									tCouponMapper.updateByPrimaryKeySelective(coupon);
									return "0";
								}else{
									return "3";
								}
							}
						}
					}else{
						return "2";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "-1";
		}
	}
	@Override
	public Integer findCouponCount(String phone) {
		TUserExample tUserExample = new TUserExample();
		tUserExample.createCriteria().andMobilephonenoEqualTo(phone);
		List<TUser> users = tUserMapper.selectByExample(tUserExample);
		if(users.size() <= 0){
			return 0;
		}else{
			TMemberExample tMemberExample = new TMemberExample();
			tMemberExample.createCriteria().andUseridEqualTo(users.get(0).getUserid());
			List<TMember> members = tMemberMapper.selectByExample(tMemberExample);
			if(members.size() <=0){
				return 0;
			}else{
				TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
				tMemberCouponRefExample.createCriteria().andMemberidEqualTo(members.get(0).getMemberid()).andStatusEqualTo("0");
				int countByExample = tMemberCouponRefMapper.countByExample(tMemberCouponRefExample);
				return countByExample ;
			}
		}
	}

}

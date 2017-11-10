package com.yundongjia.oa.admin.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title:com.yundongjia.oa.admin.vo Description:标识符
 * 
 * @author HuangJian
 * @date 2016年10月31日
 */

public class ConstantVo {
	
	//企业信息
	//public static final String ENTERPRISE_PATH="excels/enterprise/企业列表.xls";
	public static final String ENTERPRISE_TITLE="企业列表";
	public static final String [] ENTERPRISE_HEADER={"企业名称","所在城市","企业地址","企业规模","企业联系人"};
	public static final String [] ENTERPRISE_MAPKEY={"enterpriseName","provinceName","enterpriseAddr","enterpriseScale","contactName"};
	
	//订单信息 --退订订单
	//public static final String ORDER_PATH="excels/orders/订单列表.xls";
	public static final String ORDER_TITLE="订单列表";
	public static final String [] ORDER_HEADER={"订单ID","订单类型","订单金额","用户","创建日期","订单来源","订单状态","短信状态"};
	public static final String [] ORDER_MAPKEY={"orderId","orderTypeName","totalMoney","mobilePhoneNum","createDate","sourceName","orderStatusName","messName"};
	//退订订单信息
	
	//活动信息
	//public static final String ACTIVITY_PATH="excels/activity/活动列表.xls";
	public static final String ACTIVITY_TITLE="活动列表";
	public static final String [] ACTIVITY_HEADER = {"活动ID","活动类型","所在城市","活动名称","活动场馆","活动教练","活动开始时间","活动结束时间","活动人数","已报名人数","活动费用-元","活动费用-次","状态"};
	public static final String [] ACTIVITY_MAPKEY={"activeId","activeTypeName","provinceName","activeName","studioName","nickName","activeStartTime","activeEndTime","activeNum","bmNumber","activePrice","activeSubNum","statusName"};
	
	//场馆信息
	//public static final String STUDIO_PATH="excels/studio/场馆列表.xls";
	public static final String STUDIO_TITLE="场馆列表";
	public static final String [] STUDIO_HEADER={"场馆名称","场馆类型","所在地区","场馆地址","场馆电话","联系人","联系方式"};
	public static final String [] STUDIO_MAPKEY={"studioName","typeName","areaName","studioAddr","studioTel","superName","superTel"};
	
	//教练信息
	//public static final String COACH_PATH="excels/coach/教练列表.xls";
	public static final String COACH_TITLE="教练列表";
	public static final String [] COACH_HEADER={"教练名称","擅长课程","所在地区","价格","联系电话"};
	public static final String [] COACH_MAPKEY={"nickName","skillNames","areaName","coursePrice","mobilePhoneNo"};
	
	//商品信息
	//public static final String GOODS_PATH="excels/goods/商品列表.xls";
	public static final String GOODS_TITLE="商品列表";
	public static final String [] GOODS_HEADER={"商品名称","商品规格-颜色","商品规格-尺码","价格","库存"};
	public static final String [] GOODS_MAPKEY={"gName","strColor","strSize","gPrice","gCount"};
	
	// 未删除
	public static final Byte IS_NO_DEL = 0;
	// 分页条数 oa
	public static final String PAGE_SIZE = "20";
	//企业端分页
	public static final String PAGE_SIZE_10="10";
	//app 分页 教练，场馆
	public static final Integer APP_PAGE_SIZE=9;
	//APP 地图模式场馆分页默认值
	public static final Integer APP_MAP_MODEL_PAGE_SIZE=9;
	
	public static final String PAGE_SIZE_5="5";
	/*
	 * 操作表 标识
	 */
	//菜单标识
	public static final Integer TYPE_MENU=14;
	//企业 标识
	public static final Integer TYPE_ENTERPRISE=15;
	//企业卡
	public static final Integer TYPE_ENTERPRISE_CARD=4;
	//企业用户
	public static final Integer TYPE_ENTERPRISE_USER=7;
	//活动
	public static final Integer TYPE_ACTIVITY=9;
	//场馆
	public static final Integer TYPE_STUDIO=10;
	//操作记录  教练
	public static final Integer TYPE_COACH=16;
	//操作记录 订单
	public static final Integer TYPE_ORDER=8;
	//操作记录 商品
	public static final Integer TYPE_GOODS=17;
	//操作记录  资讯
	public static final Integer TYPE_INFOR_MATION=18;
	//操作记录 财务提现
	public static final Integer TYPE_APPLY=12;
	//操作记录 财务结算
	public static final Integer TYPE_CLEAR=21;
	
	// t_user用户默认密码
	public static final String USER_PASSWORD="123456";
	//图片   活动标志
	public static final Integer ATTACH_TYPE_ACTIVITY=1;
	//图片类型  场馆标志
	public static final Integer ATTACH_TYPE_STUDIO=2;
	//图片类型  教练
	public static final Integer ATTACH_TYPE_COACH=3;
	//图片类型 商品  17原来
	public static final Integer ATTACH_TYPE_GOODS=4;
	//资讯 图片
	public static final Integer ATTACH_TYPE_INFOR_MATION=5;
	
	public static final String COACH_PASSWORD="Abc123";
	
	//菜单  菜单列表-
	public static final Integer ORDER_MENU_TYPE_NUM0=0;
	//菜单   财务--》退订列表
	public static final Integer ORDER_MENU_TYPE_UNSUB=1;
	
	//订单支付状态  状态（0待支付 1已取消  2已支付  3退订中 4已退订  5用户端确认上课（已完成））
	
	public static final Integer ORDER_PAY_STATUS_NO_PAY=0;//待支付
	
	public static final Integer ORDER_PAY_STATUS_OK_PAY=2;
	
	//短信未发送
	public static final Integer MESSAGE_STATUS_NO=0;
	//短信已发送
	public static final Integer MESSAGE_STATUS_OK=1;
	//运动家座机
	public static final String YDJ_TELEPHONE="4000165009";
	/**
	* Title: ConstantVo.java
	* Description: 获得图片下标
	* @param num -1 获取副图 1-4下标   num: 0 主图  1:所有图
	* @return
	* @author HuangJian
	* @date 2017年4月7日
	*/
	public static List<Integer> getImageIndexs(Integer num){
		List<Integer> index=new ArrayList<>();
		if(-1 == num){
			index.add(1);
			index.add(2);
			index.add(3);
			index.add(4);
		}else if(0 == num){
			index.add(0);
		}else if(1 == num){
			index.add(0);
			index.add(1);
			index.add(2);
			index.add(3);
			index.add(4);
		}
		return index;
	}
}

package com.yundongjia.app.user.controller.usercontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yundongjia.app.user.service.AppActivityService;
import com.yundongjia.app.user.service.AppConfigService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;

/** * @author  作者Li XiaoYang * @date 创建时间：2017年2月14日 17:21:26 * @version 1.0 * @parameter  * @since  * @return  */
/**
 * 
 * @ClassName: ActivityController
 * @Description: TODO(运动+活动（团课）)
 * @author LiXiaoYang
 * @date 2017年2月14日 17:21:26
 *
 */
@Controller
public class AppActivityController extends BaseController {
	@Autowired
	private AppActivityService appActivityService;
	@Autowired
	private AppConfigService appConfigService;

	@RequestMapping(value = "ydj/user/active")
	public void loginUser(String str) throws Exception {
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = (Integer) map.get("type");
		switch (type) {
		case 0: // 查询活动列表
			activeList(map);
			break;
		case 1: // 根据活动Id 查询
			findActiveById(map);
			break;
		default:
			break;
		}
	}

	/**
	 * @param map
	 *            参数包含 dateEvolve（0至6 Integer 代表 当前日期为基础后推的天数）
	 */
	private void activeList(Map<String, Object> map) {
		jsonclear();
		Integer dateEvolve = Integer.parseInt(map.get("dateEvolve").toString());
		if (dateEvolve == null) {
			dateEvolve = 0;
		}
		Map<Integer, List<String>> sevenDate = new HashMap<Integer, List<String>>();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date ListDate = new Date();
		// 创建日历类
		for (int i = 0; i < 7; i++) {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(new Date());
			calendar.add(calendar.DATE, i);// 把日期往后增加一天.整数往后推,负数往前移动
			Integer weekNum = calendar.get(Calendar.DAY_OF_WEEK) - 1;// 星期数
			if (weekNum == 0)
				weekNum = 7;// 0代表星期天转换为7
			Date time = calendar.getTime();
			String timeDate = sim.format(time);
			List<String> dateInfo = new ArrayList<String>();
			dateInfo.add(weekNum.toString());
			dateInfo.add(timeDate.split("-")[1] + "." + timeDate.split("-")[2]);
			sevenDate.put(i, dateInfo);
			if (dateEvolve == i) {
				ListDate = calendar.getTime();
			}
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 查询指定日期的活动列表
		List<Map<String, Object>> list = appActivityService.findListByDate(dateFormat.format(ListDate));
		List<String> imgs = appConfigService.getConfigValueByName("ACTIVITY_LIST_IMGS");
		Map result = new HashMap();
		result.put("list", list);
		result.put("sevenDate", sevenDate);
		result.put("status", "0");
		result.put("message", "请求成功");
		result.put("imgs", imgs);
		this.RSAprivateencode(new Gson().toJson(result));
	}

	/**
	 * @param map
	 *            activeId 活动ID
	 * 
	 */
	private void findActiveById(Map<String, Object> map) {
		jsonclear();
		Integer activeId = (Integer) map.get("activeId");
		Map<String, Object> activity = appActivityService.finListById(activeId);
		this.RSAprivateencode(new Gson().toJson(activity));
	}

}

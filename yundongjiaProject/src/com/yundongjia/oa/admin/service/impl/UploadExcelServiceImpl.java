/**
* @author HuangJian
* @date 2017年2月14日
*/
package com.yundongjia.oa.admin.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.service.UploadExcelService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.ExcelUtil;

@Service
public class UploadExcelServiceImpl implements UploadExcelService {

	@Override
	public void exportExcelAll(List<Map<String, Object>> list, Integer type, HttpServletResponse response,HttpServletRequest request) {

		//String filePath = "";
		String title = "";
		String[] headers = null;
		String[] mapKeys = null;
		switch (type) {
		case 0:
			//filePath = ConstantVo.ACTIVITY_PATH;
			title = ConstantVo.ACTIVITY_TITLE;
			headers = ConstantVo.ACTIVITY_HEADER;
			mapKeys = ConstantVo.ACTIVITY_MAPKEY;
			break;
		case 1:
			//filePath = ConstantVo.STUDIO_PATH;
			title = ConstantVo.STUDIO_TITLE;
			headers = ConstantVo.STUDIO_HEADER;
			mapKeys = ConstantVo.STUDIO_MAPKEY;
			break;
		case 2:
			//filePath = ConstantVo.COACH_PATH;
			title = ConstantVo.COACH_TITLE;
			headers = ConstantVo.COACH_HEADER;
			mapKeys = ConstantVo.COACH_MAPKEY;
			break;
		case 3:
			//filePath = ConstantVo.GOODS_PATH;
			title = ConstantVo.GOODS_TITLE;
			headers = ConstantVo.GOODS_HEADER;
			mapKeys = ConstantVo.GOODS_MAPKEY;
			break;
		case 4:

		case 5:
			//filePath = ConstantVo.ORDER_PATH;
			title = ConstantVo.ORDER_TITLE;
			headers = ConstantVo.ORDER_HEADER;
			mapKeys = ConstantVo.ORDER_MAPKEY;
			break;
		case 6:
			title=ConstantVo.ENTERPRISE_TITLE;
			headers=ConstantVo.ENTERPRISE_HEADER;
			mapKeys=ConstantVo.ENTERPRISE_MAPKEY;
			break;
		default:
			break;
		}
		//一下不用下载到服务端就可以直接下载到客户端
		ExcelUtil<Map<String, Object>> util = new ExcelUtil<>();
		HSSFWorkbook wb;
		title = title + System.currentTimeMillis()+".xls";
		wb = util.export(title, headers, mapKeys, list, "yyyy-MM-dd HH:mm:ss");

		// 清空response
		response.reset();
		
		String fileName="";
		
		if(request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){
			try {
				fileName = new String(title.getBytes("UTF-8"),"ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			try {
				fileName = URLEncoder.encode(title, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
		
		try {
			OutputStream outputStream = response.getOutputStream();
			
			wb.write(outputStream);
			
			outputStream.flush();
			outputStream.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
	}

}

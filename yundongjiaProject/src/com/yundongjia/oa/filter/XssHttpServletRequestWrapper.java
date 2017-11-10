/**
* @author HuangJian
* @date 2017年2月22日
*/
package com.yundongjia.oa.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringEscapeUtils;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);

	}

	@Override
	public String getHeader(String name) {

		return StringEscapeUtils.escapeHtml(super.getHeader(name));
	}

	@Override
	public String getQueryString() {

		return StringEscapeUtils.escapeHtml(super.getQueryString());
	}

	@Override
	public String getParameter(String name) {

		return StringEscapeUtils.escapeHtml(super.getParameter(name));
	}

	@Override // 中文会变成数字，，再把数字转成中文
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values != null) {
			String tempStr;
			int len = values.length;
			String[] escapseValues = new String[len];
			for (int i = 0; i < len; i++) {
				 tempStr = StringEscapeUtils.escapeHtml(values[i]);
				 
				 escapseValues[i]=tempStr;
				System.out.println("中文:" + escapseValues[i]);
			}

			return escapseValues;
		}
		return super.getParameterValues(name);
	}

} 

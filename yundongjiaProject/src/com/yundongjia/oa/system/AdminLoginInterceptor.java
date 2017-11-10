package com.yundongjia.oa.system;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录验证拦截器
 */
public class AdminLoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView e)
			throws Exception {
		// TODO Auto-generated method stub



		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath();
        String uri = request.getServletPath();
        System.out.println("contextPath  :"+  contextPath);
        if (request.getSession().getAttribute("userVo") == null){
        	if (uri.startsWith("/enterprise/") ){
            	PrintWriter out = response.getWriter();  
                out.println("<html>");      
                out.println("<script>");      
                out.println("window.location ='"+contextPath+"/enterprise'");      
                out.println("</script>");      
                out.println("</html>");
            }else {
                PrintWriter out = response.getWriter();  
                out.println("<html>");      
                out.println("<script>");      
                out.println("window.location ='"+contextPath+"/yundongjia'");      
                out.println("</script>");      
                out.println("</html>");
            }
            return false;
        }
		return true;
	}

}

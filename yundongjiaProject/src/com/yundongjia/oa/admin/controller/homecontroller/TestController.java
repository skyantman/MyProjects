package com.yundongjia.oa.admin.controller.homecontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yundongjia.oa.admin.service.MenuService;
import com.yundongjia.oa.admin.vo.MenuVo;
import com.yundongjia.oa.system.Authority;
import com.yundongjia.oa.utils.RedisUtil;

import redis.clients.jedis.JedisPool;

/**
 * 测试controller
 * @author Administrator
 *
 */


@Controller
@RequestMapping("test")
public class TestController extends BaseController{

	@Resource(name="jedisPool")
	JedisPool jedisPool ;

    @Autowired
    private MenuService menuService;


    public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	@RequestMapping("test/{name}")
	public void test(@PathVariable("name") String name,HttpServletResponse response) throws IOException{
		System.out.println(name);
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.close();
	}
	
	@RequestMapping("lu")
	public void lu(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		jedisPool.getResource().incr("lu");
		writer.write(RedisUtil.get("lu"));
		writer.close();
	}
	
	@RequestMapping("bulu")
	public void bulu(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		jedisPool.getResource().incr("bulu");
		writer.write(jedisPool.getResource().get("bulu"));
		writer.close();
	}

	@Authority("hehe")
	@RequestMapping("getlu")
	public void getlu(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(jedisPool.getResource().get("lu"));
		writer.close();
	}
	
	@RequestMapping("getbulu")
	public void getbulu(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(jedisPool.getResource().get("bulu"));
		writer.close();
	}


    @RequestMapping("inserttest")
	public void insertUserTest(){



    }
    @Authority({"haha"})
    @RequestMapping("login")
    public String login(){
    	return "login/login";
    }


    @RequestMapping("index")
    public String index(){

        return "static/index.html";

    }
    @RequestMapping(value = "/yundongjia")
    public String gymlogin(){

        return "login/login";
    }
    

    @RequestMapping("tree")
    public void selectTree() throws IOException {
        List<MenuVo> menuVos = this.menuService.selectGYMTree();
        this.writeJSONStr(menuVos.toString());
    }




    @RequestMapping("/test/up")
    public void upload(@RequestParam(value = "file",required = false) MultipartFile file,String name) throws IOException {

        InputStream in = file.getInputStream();
        Date d = new Date();
        long time = d.getTime();
        IOUtils.copy(in,new FileOutputStream("E://"+time+".jpg"));
    }


    public MenuService getMenuService() {
        return menuService;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
    
}

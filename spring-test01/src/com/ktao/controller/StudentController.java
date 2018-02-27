package com.ktao.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
@Controller
public class StudentController {
	 private static Connection con = null;
	    private static Statement sql = null;
	    private static ResultSet rs = null;
	    private static ResultSet rs1 = null;
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView student(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws IOException{
    	HttpSession session = httpServletRequest.getSession();
		String rrrrrrrrrr = (String) session.getAttribute("loginName");
		System.out.println(rrrrrrrrrr);
		if(rrrrrrrrrr!="01"){
			httpServletResponse.sendRedirect("http://localhost:8080/spring-test01/login");     
		}
    	return new ModelAndView("student","command",new Student());
        
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView student22(){
        return new ModelAndView("login","command",new Student());
    }
    
    @RequestMapping(value = "/loginAction",method = RequestMethod.POST)
    public String loginAction(Student student,ModelMap model,HttpServletRequest req,HttpServletResponse rsp) throws Exception {
        model.addAttribute("username", student.getUsername());
        model.addAttribute("password", student.getPassword());
        model.addAttribute("id", student.getId());
        String username =student.getUsername();
        String password =student.getPassword();
        String id = student.getId();
        rsp.setCharacterEncoding("UTF-8");
        if(password.equals(null)||password==""||id.equals(null)||id==""){
        	throw new Exception("密码，工号都不能为空");
        }
      
        try {
            con = database.Basedao.dbConn("nc65_0108", "nc65_0108");
            if (con == null) {
               System.out.print("连接失败");
               System.exit(0);
            }
            sql = con.createStatement();
            rs1 = sql.executeQuery("select id,password from   myuser ");
            boolean right = false;
            while(rs1.next()){
            	String aa =rs1.getString(1);
            	if(id ==rs1.getString(1)||id.equals(rs1.getString(1))){
            		if(password==rs1.getString(2)||password.equals(rs1.getString(2))){
            			right =true;
            		}
          
            	}
            }
            if(right == false){
            	
            	 rsp.getWriter().print("你的账号密码错误");
            	 return "login";
            	 
            }
           // rs = sql.executeQuery("insert into myuser values ('"+username+"','"+password+"','"+id+"')");
            HttpSession session = req.getSession();
            session.setAttribute("loginName", id);
            String nn = (String) session.getId();
            System.out.println(nn);
            if (session.isNew()) {
            	rsp.getWriter().print("session创建成功，session的id是："+nn);
            	         }else {
            	        	 rsp.getWriter().print("服务器已经存在该session了，session的id是："+nn);
            	         }
            //跳转到用户主页
        } catch (Exception e) {
            e.printStackTrace();
  
        } finally {
            con.close();
        }
      
       return "loginfirst";
    }
    
    
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(Student student,ModelMap model) throws Exception {
        model.addAttribute("username", student.getUsername());
        model.addAttribute("password", student.getPassword());
        model.addAttribute("id", student.getId());
        String username =student.getUsername();
        String password =student.getPassword();
        String id = student.getId();
        if(username.equals(null)||username==""||password.equals(null)||password==""||id.equals(null)||id==""){
        	throw new Exception("用户名，密码，工号都不能为空");
        }
      
        try {
            con = database.Basedao.dbConn("nc65_0108", "nc65_0108");
            if (con == null) {
               System.out.print("连接失败");
               System.exit(0);
            }
            sql = con.createStatement();
            rs1 = sql.executeQuery("select id from   myuser ");
            while(rs1.next()){
            	if(id ==rs1.getString(1)||id.equals(rs1.getString(1))){
            		return "result2";
          
            	}
            }          
            rs = sql.executeQuery("insert into myuser values ('"+username+"','"+password+"','"+id+"')");

        } catch (Exception e) {
            e.printStackTrace();
  
        } finally {
            con.close();
        }

        return "result";
    }
 
    
}
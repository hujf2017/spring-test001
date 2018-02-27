package com.ktao.controller;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class NumController extends HttpServlet implements Filter{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	    private static Statement sql = null;
	    private static ResultSet rs = null;
	    private static ResultSet rs1 = null;
	@RequestMapping(value = "/in",method = RequestMethod.GET)
	public ModelAndView aaa(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception{
		//String r = (String) HttpServletResponse.getAttribute("id");
		HttpSession session = httpServletRequest.getSession();
		String rrrrrrrrr = (String) session.getAttribute("loginName");
		if(rrrrrrrrr==null||rrrrrrrrr.equals("")||rrrrrrrrr == ""||rrrrrrrrr.isEmpty()){			
			httpServletResponse.sendRedirect("http://localhost:8080/spring-test01/login");
		}else{
        return new ModelAndView("in","command",new Material());
		}
		return null;
    }
	
	@RequestMapping(value = "/InAction",method = RequestMethod.POST)
	public String InAction(Material material,ModelMap model) throws SQLException{
		
		 String name =material.getName();
	     String code =material.getCode();
	     String num = material.getNum();
		
	     try{
	    	 con =database.Basedao.dbConn("nc65_0108", "nc65_0108");
	    	 if (con == null) {
	               System.out.print("连接失败");
	               System.exit(0);
	            }
	    	 sql = con.createStatement();
	    	 rs1 = sql.executeQuery("select name,code from   bd_material where bd_material.name = '"+name+"' and bd_material.code = '"+code+"' ");
	    	 if(!rs1.next()){       //判断是否为NC的物料
	    		 return  "error";
	    	 }
	    	 rs = sql.executeQuery("select name,code from   mymaterial where mymaterial.name = '"+name+"' and mymaterial.code = '"+code+"' ");
	    	 if(!rs.next()){       //判断是否在此系统存在这个物料
	    		 return "error1"; 
	    	 }
	    	 rs = sql.executeQuery("insert into inmaterial values('"+code+"','"+name+"','"+num+"')");
	    	 rs = sql.executeQuery("select num from   mymaterial where mymaterial.name = '"+name+"' and mymaterial.code = '"+code+"' ");
	    	String qq = material.getNum();
	    	String sql1 = "update mymaterial set num=(num+'"+qq+"')  where mymaterial.name = '"+name+"' and mymaterial.code = '"+code+"' ";
	    	con.commit();
	    	 rs = sql.executeQuery(sql1);
	    	 con.commit();
	    	 return "insuccess";
	    	// result = sql.executeQuery(sql)
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 con.close();
	     }
		return null;	
	}
	/**
	 * 
	 * @param material
	 * @param model
	 * @param httpServletRequest
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/In1Action",method = RequestMethod.POST)
	public String In1Action(Material material,ModelMap model,javax.servlet.http.HttpServletRequest httpServletRequest) throws SQLException{
		
		 String name =material.getName();
	     String code =material.getCode();
	     String num = material.getNum();
		
	     try{
	    	 con =database.Basedao.dbConn("nc65_0108", "nc65_0108");
	    	 if (con == null) {
	               System.out.print("连接失败");
	               System.exit(0);
	            }
	    	 sql = con.createStatement();
	    	 rs1 = sql.executeQuery("select *from inmaterial ");
	    	 ArrayList list = new ArrayList();
	    	 for(;rs1.next();){
	    		 list.add(rs1.getString("name"));
	    		 list.add(rs1.getString("code"));
	    		 list.add(rs1.getString("number1"));
	    	 }
	    	 httpServletRequest.setAttribute("list",list); 
		    	
	    	 return "allin";
	    	// result = sql.executeQuery(sql)
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 con.close();
	     }
		return null;	
	}
	
	/**
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return 返回出库
	 * @throws Exception
	 */
	@RequestMapping(value = "/out",method = RequestMethod.GET)
	public ModelAndView aaaout(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception{
		//String r = (String) HttpServletResponse.getAttribute("id");
		HttpSession session = httpServletRequest.getSession();
		String rrrrrrrrr = (String) session.getAttribute("loginName");
		if(rrrrrrrrr==null||rrrrrrrrr.equals("")||rrrrrrrrr == ""||rrrrrrrrr.isEmpty()){			
			httpServletResponse.sendRedirect("http://localhost:8080/spring-test01/login");
		}else{
        return new ModelAndView("out","command",new Material());
		}
		return null;
    }
	
	
	@RequestMapping(value = "/OutAction",method = RequestMethod.POST)
	public String OutAction(Material material,ModelMap model) throws SQLException{
		
		 String name =material.getName();
	     String code =material.getCode();
	     String num = material.getNum();
		
	     try{
	    	 con =database.Basedao.dbConn("nc65_0108", "nc65_0108");
	    	 if (con == null) {
	               System.out.print("连接失败");
	               System.exit(0);
	            }
	    	 sql = con.createStatement();
	    	 rs1 = sql.executeQuery("select name,code from   bd_material where bd_material.name = '"+name+"' and bd_material.code = '"+code+"' ");
	    	 if(!rs1.next()){       //判断是否为NC的物料
	    		 return  "error";
	    	 }
	    	 rs = sql.executeQuery("select name,code,num from   mymaterial where mymaterial.name = '"+name+"' and mymaterial.code = '"+code+"' ");
	    	 if(!rs.next() ){       //判断是否在此系统存在这个物料
	    		 return "error1"; 
	    	 }
	    	
	    	 float b= Float.parseFloat(num);
	    	 float c =Float.parseFloat(rs.getString("num"));
	    	 float a = c-b ;
	    	 if(a<0){
	    		 return "error1";  
	    	 }
	    	
	    	
	    	 rs = sql.executeQuery("insert into outmaterial values('"+code+"','"+name+"','"+num+"')");
	    	
	 
	    	String sql1 = "update mymaterial set num=('"+a+"')  where mymaterial.name = '"+name+"' and mymaterial.code = '"+code+"' ";
	    	 rs = sql.executeQuery(sql1);
	    	 return "insuccess";
	    	// result = sql.executeQuery(sql)
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 con.close();
	     }
		return null;
		
		
		
	}
	
	@RequestMapping(value = "/Out1Action",method = RequestMethod.POST)
	public String Out1Action(Material material,ModelMap model,javax.servlet.http.HttpServletRequest httpServletRequest) throws SQLException{
		
		 String name =material.getName();
	     String code =material.getCode();
	     String num = material.getNum();
		
	     try{
	    	 con =database.Basedao.dbConn("nc65_0108", "nc65_0108");
	    	 if (con == null) {
	               System.out.print("连接失败");
	               System.exit(0);
	            }
	    	 sql = con.createStatement();
	    	 rs1 = sql.executeQuery("select * from   outmaterial ");
	    	ArrayList<List> userList= new  ArrayList<List>()  ; //获取所有用户
	    		for(;rs1.next();){
	    			ArrayList userList1= new  ArrayList()  ; //获取所有用户
	    			userList1.add(rs1.getString("name"));
	    			userList1.add (rs1.getString("code"));
	    			userList1.add( rs1.getString("numbe"));
	    			userList.addAll(userList1);
	    			
	    		}
	    		//userList.get()
	    	 
	    		httpServletRequest.setAttribute("list",userList); 
	    	
	    	 
	    	
	    	 return "allout";
	    	// result = sql.executeQuery(sql)
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 con.close();
	     }
		return null;
	
	}
	
	
	
	@RequestMapping(value = "/has",method = RequestMethod.GET)
	public ModelAndView has(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception{
		//String r = (String) HttpServletResponse.getAttribute("id");
		HttpSession session = httpServletRequest.getSession();
		String rrrrrrrrr = (String) session.getAttribute("loginName");
		if(rrrrrrrrr==null||rrrrrrrrr.equals("")||rrrrrrrrr == ""||rrrrrrrrr.isEmpty()){			
			httpServletResponse.sendRedirect("http://localhost:8080/spring-test01/login");
		}else{
        return new ModelAndView("has","command",new Material());
		}
		return null;
    }

	
	
	@RequestMapping(value = "/HasAction",method = RequestMethod.POST)
	public String HasAction(Material material,ModelMap model,javax.servlet.http.HttpServletRequest httpServletRequest ) throws SQLException{
		
		 String name =material.getName();
	     String code =material.getCode();
	     String num = material.getNum();
		
	     try{
	    	 con =database.Basedao.dbConn("nc65_0108", "nc65_0108");
	    	 if (con == null) {
	               System.out.print("连接失败");
	               System.exit(0);
	            }
	    	 sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    	 if(code==null||code.equals("")){
	    		 rs1 = sql.executeQuery("select * from   mymaterial ");
	    	 }else{
	    	 rs1 = sql.executeQuery("select * from  mymaterial where mymaterial.code = '"+code+"' ");
	    	 }
	    	
	    	 if(!rs1.next() ){       //判断是否在此系统存在这个物料
	    		 return "error1"; 
	    	 }
	    	 ArrayList<List> userList= new  ArrayList<List>()  ; //获取所有用户
	    	 rs1.last();
	    	 int b =rs1.getRow();
	    	 rs1.beforeFirst();
	    		for(;rs1.next();){
	    			ArrayList userList1= new  ArrayList()  ; //获取所有用户
	    			userList1.add(rs1.getString("name"));
	    			userList1.add (rs1.getString("code"));
	    			userList1.add( rs1.getString("num"));
	    			userList.addAll(userList1);
	    			
	    		}
	    		//userList.get()
	    	 
	    		httpServletRequest.setAttribute("list",userList); 
	    	
	    		
	    		
		     
		        return "all";
	    	// result = sql.executeQuery(sql)
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 con.close();
	     }
		return null;
		
		
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}

package com.ktao.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Weihu extends HttpServlet {
	 private static Connection con = null;
	    private static Statement sql = null;
	    private static ResultSet rs = null;
	    private static ResultSet rs1 = null;

	@RequestMapping(value ="/addmaterial",method = RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("addmaterial","command",new Material());		
	}
	@RequestMapping(value ="/addAction",method = RequestMethod.POST)
	public String addAction(Model model,Material material) throws SQLException{
		 String name =material.getName();
	     String code =material.getCode();
	    // String num = material.getNum();
		
	     try{
	    	 con =database.Basedao.dbConn("nc65_0108", "nc65_0108");
	    	 if (con == null) {
	               System.out.print("¡¨Ω” ß∞‹");
	               System.exit(0);
	            }
	    	 sql = con.createStatement();
	    	 rs1 = sql.executeQuery("select name,code from   bd_material where bd_material.name = '"+name+"' and bd_material.code = '"+code+"' ");
	    	 if(!rs1.next()){
	    		return "error";
	    	 }
	    	 rs = sql.executeQuery("select name,code from   mymaterial where mymaterial.name = '"+name+"' and mymaterial.code = '"+code+"' ");
	    	 if(rs.next()){
	    		 return "exit";
	    	 }
	    	 String sql1 = "insert into mymaterial(name ,code ,num) values('"+name+"','"+code+"','0')";
	    	 rs = sql.executeQuery(sql1);
	    	 
	    	   	 
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 con.close();
	     }
		
		
		
		return "success";
		
	}
}

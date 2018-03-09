package com.test.spring.support.configuration;

public class TestBean {

    public void sayHello(){
        System.out.println("TestBean sayHello...");
    }

    public String toString(String username,String password){
		return null;
      //  return "username:"+this.username+",url:"+this.url+",password:"+this.password;
    }

    public void start(){
        System.out.println("TestBean ³õÊ¼»¯¡£¡£¡£");
    }

    public void cleanUp(){
        System.out.println("TestBean Ïú»Ù¡£¡£¡£");
    }
}
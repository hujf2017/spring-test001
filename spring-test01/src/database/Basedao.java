package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Basedao {
	public static  Connection dbConn(String name,String pass){
		 Connection c = null;
		 try {
	           Class.forName("oracle.jdbc.driver.OracleDriver");
	           // Ҫ�ǵ�������û�гɹ��Ļ����ǻ����classnotfoundException.�Լ������ǲ����������,����classpath��Щ����
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
		 
		  try {
	           c = DriverManager.getConnection(
	                  "jdbc:oracle:thin:@10.0.1.59:1521:orcl", name, pass);
	           // �������ݵķ���������, ���������򵥵�,һ������ҳ����
	           // "jdbc:oracle:thin:@���������:�����˿�:ϵͳʵ����", username, password,
	           // ���������,Ҫ���Լ���֪�������ڼ�������Բ�֪.
	           // �����˿�һ��Ĭ����1521, Ҫ�Ǹı��˾Ϳ��Լ��ļ����ļ�listener.ora
	           // ϵͳʵ����һ����Ĭ��orcl, Ҫ�ǲ��ǵĻ����� select name from v$database; ������ǰ��ʵ����.
	           // username,password,���ǵ�½���ݿ���û���������.
	 
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
		  return  c;
	}
}

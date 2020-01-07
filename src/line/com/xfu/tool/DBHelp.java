package line.com.xfu.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelp {

	/**
	 * 数据库帮助类，登录，注册，修改，删除、找回密码，显示全部记录
	 * 显示符合条件的记录
	 */
	Connection conn;
	public Connection  getConn() {
		try{
		    //1.加载数据库驱动(系统类)
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    //2.获得数据库连接
		    conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=huarongdao","sa","123456");
		  if(conn==null) 
		    System.out.println("数据库连接失败");
		  else 
		    System.out.println("数据库连接成功");
		  }
		catch(Exception ex){
		  System.out.print(ex);	
		}
		return conn;
	}
}

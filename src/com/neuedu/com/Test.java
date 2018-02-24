package com.neuedu.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		//geshi  jdbc:mysql://主机ip：端口号/数据库名
		String url="jdbc:mysql://192.168.122.130:3306/db2?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			//选择要操作的数据库种类---加载驱动(反射)
			Class.forName("com.mysql.jdbc.Driver");		
			con= DriverManager.getConnection(url, user, password);
			//创建命令窗口
			pstmt=con.prepareStatement("select * from student");
			//运行sql语句并查看结果，如果是增删改，则返回受影响的行数，如果是查询返回的是查询结果
			//如果是增删改，则调用executeUpdate 返回int 如果查询则调用execute
			rs= pstmt.executeQuery();
			//查看结果集
			while(rs.next()){
				System.out.println(rs.getString("sno")+" "+rs.getString("sname"));				
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

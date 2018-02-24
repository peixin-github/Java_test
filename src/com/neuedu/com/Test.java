package com.neuedu.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		
		//2.1格式jdbc:mysql://主机IP:端口号//数据库名
		String url="jdbc:mysql://192.168.122.130:3306/db2";
		String user="root";
		String password="123456";
		//2.2创建必要对象,扩大作用域
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1.选择要创建的数据库----加载驱动(反射)
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建连接 主机IP 端口号 用户名 密码 和选择要操作的数据库,url里包含主机IP、端口号和要操作的数据库
			con = DriverManager.getConnection(url,user,password);
			//3.创建命令窗口 写sql语句
			pstmt = con.prepareStatement("select * from student");
			//4.运行sql语句并查看结果 如果是增删改 返回受影响的行数 如果是查询返回的是查询结果
			//4.1运行的时候 如果是增删改则调用executeUpdate 返回int(代表的是受影响的行数) 如果是查询 则调用executeQuery 返回ResultSet(结果的集合)
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("sno")+"  "+rs.getString("sname"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//空指针调用任何方法都会报错
				if(rs!=null);
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

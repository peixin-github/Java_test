package com.neuedu.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecondTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.1格式：url=“jdbc:mysql//主机IP:端口号//数据库名”
		String url="jdbc:mysql://192.168.122.130:3306/db3?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		//
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pmt=null;
		try {
			//1连接数据库---加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2建立连接 url user password 选择数据库
			con=DriverManager.getConnection(url, user, password);
			//3建立命令行窗口 输入sql 语句
			pmt = con.prepareStatement("select * from student");
			//4运行sql语句 返回语句结果
			rs = pmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
				rs.close();
				if(pmt!=null)
					pmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

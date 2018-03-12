package com.neuedu.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecondTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.1��ʽ��url=��jdbc:mysql//����IP:�˿ں�//���ݿ�����
		String url="jdbc:mysql://192.168.122.130:3306/db3?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		//
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pmt=null;
		try {
			//1�������ݿ�---��������
			Class.forName("com.mysql.jdbc.Driver");
			//2�������� url user password ѡ�����ݿ�
			con=DriverManager.getConnection(url, user, password);
			//3���������д��� ����sql ���
			pmt = con.prepareStatement("select * from student");
			//4����sql��� ���������
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

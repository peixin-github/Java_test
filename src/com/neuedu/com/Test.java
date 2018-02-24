package com.neuedu.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		//geshi  jdbc:mysql://����ip���˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.122.130:3306/db2?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			//ѡ��Ҫ���������ݿ�����---��������(����)
			Class.forName("com.mysql.jdbc.Driver");		
			con= DriverManager.getConnection(url, user, password);
			//���������
			pstmt=con.prepareStatement("select * from student");
			//����sql��䲢�鿴������������ɾ�ģ��򷵻���Ӱ�������������ǲ�ѯ���ص��ǲ�ѯ���
			//�������ɾ�ģ������executeUpdate ����int �����ѯ�����execute
			rs= pstmt.executeQuery();
			//�鿴�����
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

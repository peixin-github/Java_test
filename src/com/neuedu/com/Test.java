package com.neuedu.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		
		//2.1��ʽjdbc:mysql://����IP:�˿ں�//���ݿ���
		String url="jdbc:mysql://192.168.122.130:3306/db2";
		String user="root";
		String password="123456";
		//2.2������Ҫ����,����������
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1.ѡ��Ҫ���������ݿ�----��������(����)
			Class.forName("com.mysql.jdbc.Driver");
			//2.�������� ����IP �˿ں� �û��� ���� ��ѡ��Ҫ���������ݿ�,url���������IP���˿ںź�Ҫ���������ݿ�
			con = DriverManager.getConnection(url,user,password);
			//3.��������� дsql���
			pstmt = con.prepareStatement("select * from student");
			//4.����sql��䲢�鿴��� �������ɾ�� ������Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ���
			//4.1���е�ʱ�� �������ɾ�������executeUpdate ����int(���������Ӱ�������) ����ǲ�ѯ �����executeQuery ����ResultSet(����ļ���)
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
				//��ָ������κη������ᱨ��
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

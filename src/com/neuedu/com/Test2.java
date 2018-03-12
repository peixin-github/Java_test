package com.neuedu.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {
	public static void main(String[] args) {
		
		//2.1��ʽjdbc:mysql://����IP:�˿ں�//���ݿ���
		String url="jdbc:mysql://192.168.122.130:3306/db3?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		//2.2������Ҫ����,����������
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			//1.ѡ��Ҫ���������ݿ�----��������(����)
			Class.forName("com.mysql.jdbc.Driver");
			//2.�������� ����IP �˿ں� �û��� ���� ��ѡ��Ҫ���������ݿ�,url���������IP���˿ںź�Ҫ���������ݿ�
			con = DriverManager.getConnection(url,user,password);
			//3.��������� дsql���
			//3.1 дsql��� �����ַ�ƴ�� ����ȫ
			pstmt = con.prepareStatement("delete from student where name=?");
			//ע�����
			pstmt.setString(1, "px");
			//4.����sql��䲢�鿴��� �������ɾ�� ������Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ���
			//4.1���е�ʱ�� �������ɾ�������executeUpdate ����int(���������Ӱ�������) ����ǲ�ѯ �����executeQuery ����ResultSet(����ļ���)
			
			//ִ�����
			int i=pstmt.executeUpdate();
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//��ָ������κη������ᱨ��
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

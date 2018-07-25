package persistence;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

import other.JDBCUtils;

/*
 * ɾ������ɾ��·��ʱ��Ҫ�����еİ���оٳ���
 */
public class DelCityLine_PER {

	//ɾ����Ӧ���ֵĳ���
	public static int DelCity(String name) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="DELETE FROM city WHERE name=?";
			Object[] params= {name};
			Connection con=JDBCUtils.getConnection();
			int line=qr.update(con, sql, params);
			return line;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	//ɾ����Ӧ��ŵ�·��,��ɾ������ʱһ��ʹ��
	public static int DelCityLine(int num) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="DELETE FROM line WHERE begincity=? OR endcity=?";
			Object[] params= {num,num};
			Connection con=JDBCUtils.getConnection();
			int line=qr.update(con, sql, params);
			return line;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	//ɾ����·
	public static int DelTowCityLine(int num1,int num2) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="DELETE FROM line WHERE begincity=? AND endcity=?";
			Object[] params= {num1,num2};
			Connection con=JDBCUtils.getConnection();
			int line=qr.update(con, sql, params);
			return line;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}

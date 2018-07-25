package persistence;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

import other.JDBCUtils;

/*
 * 删除层在删除路线时需要将所有的班次列举出来
 */
public class DelCityLine_PER {

	//删除对应名字的城市
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
	
	//删除对应序号的路线,在删除城市时一起使用
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
	
	//删除线路
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

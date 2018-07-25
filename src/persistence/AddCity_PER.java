package persistence;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import other.JDBCUtils;

public class AddCity_PER {

	
	public static int Addcity(String name) {
		try {
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String sql="INSERT INTO city(cityname) VALUES(?)";
			Object[] params= {name};
			int line=qr.update(con,sql,params);
			return line;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//根据城市序号寻找城市
	public static String Getcity(int num) {
		try {
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String sql="SELECT cityname from city where citynum=?";
			Object[] params= {num};
			List<String> list=qr.query(con, sql, new ColumnListHandler<String>(),params);
			for(String str :list) {
				return str;
			}

		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}

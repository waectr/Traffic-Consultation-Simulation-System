package persistence;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import other.JDBCUtils;

public class WangJiMiMa_PER {

	//寻找用户，电话号码
	public static String FindUser(String name) {
		try{
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String sql="SELECT phonenum FROM user WHERE name=?";
			Object[] pra= {name};
			List<String> list=qr.query(con, sql,new ColumnListHandler<String>(),pra);
			for(String str:list) {
				return str;
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}

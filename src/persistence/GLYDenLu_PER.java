package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import other.JDBCUtils;

public class GLYDenLu_PER {
	
	public static int Check(String num) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="SELECT num FROM GLY";
			Connection con=JDBCUtils.getConnection();
			List<String> list=qr.query(con,sql,new ColumnListHandler<String>());
			for(String str:list) {
				System.out.println(str);
				if(str.equals(num)) {
					return 1;
				}
			}
			return 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}

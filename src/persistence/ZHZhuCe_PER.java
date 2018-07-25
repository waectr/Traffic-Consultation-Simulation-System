package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import other.JDBCUtils;

public class ZHZhuCe_PER {
	
	//添加用户信息
	public static int Add(String name, String password, String phonenum) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="INSERT INTO user(name,password,phonenum) VALUES(?,?,?)";
			Connection conn=JDBCUtils.getConnection();
			Object[] params= {name,password,phonenum};
			int line=qr.update(conn,sql,params);
			return line;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//用户查重
	public static int Check(String name) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="SELECT name FROM user";
			Connection con=JDBCUtils.getConnection();
			List<String> list=qr.query(con,sql,new ColumnListHandler<String>());
			for(String str:list) {
				System.out.println(str);
				if(str.equals(name)) {
					return 0;
				}
			}
			return 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}

package persistence;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import other.JDBCUtils;
import person.Line;
import person.User;

public class UserUse_PER {
	
	

	//登录时检查用户名
	public static int CheckUser(String num,String password) {
		try {
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT * FROM user WHERE name=?";
			Object[] pramas= {num};
			Connection conn = JDBCUtils.getConnection();
			List<User> u=qr.query(conn,sql,new BeanListHandler<User>(User.class),pramas);
			if(u.isEmpty()) {
				return 0;
			}
			if(u.get(0).getPassword().equals(password)) {
				//密码正确
				return 1;
			}else {
				//密码错误
				return 0;
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<Line> GetCityLine(){
		try {
			QueryRunner qr = new QueryRunner();
			String sql = "SELECT * FROM line";
			Connection conn = JDBCUtils.getConnection();
			List<Line> list = qr.query(conn, sql, new BeanListHandler<Line>(Line.class));
			return list;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

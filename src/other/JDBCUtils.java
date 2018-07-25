package other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
	private JDBCUtils() {}
	private static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/map?characterEncoding=gbk";  //url:   ���ݿ��ַ  jdbc:mysql://��������IP:�˿ں�//���ݿ�����
			String username="root";//�û���
			String password="199810";//����
			con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void close(Connection con,Statement stat,ResultSet rs) {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {}
		}
		if(stat!=null) {
			try {
				stat.close();
			} catch (Exception e) {}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {}
		}
	}
}

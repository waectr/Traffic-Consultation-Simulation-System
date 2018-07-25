package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import other.JDBCUtils;

public class AddCityLine_PER {

	//找到所有的城市名并装到一个集合中
	public static String[] FindCity() {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="SELECT cityname FROM city";
			Connection con=JDBCUtils.getConnection();
			List<String> list=qr.query(con, sql,new ColumnListHandler<String>());
			String[] array1 = list.toArray(new String[list.size()]);
			return array1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//通过城市名字找到城市编号并返回
	public static int FindCityNum(String name) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="SELECT citynum FROM city WHERE cityname=?";
			Object[] pra= {name};
			Connection con=JDBCUtils.getConnection();
			List<Integer> list=qr.query(con, sql,new ColumnListHandler<Integer>(),pra);
			for(int i:list) {
				return i;
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	//将路线信息存进数据库
	public static int Memory(int begincity,int endcity,double dis,String vehicle,String begintime,String endtime,String money,String alltime) {
		try {
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String sql="INSERT INTO line(begincity,endcity,dis,vehicle,begintime,endtime,money,alltime) VALUES(?,?,?,?,?,?,?,?)";
			Object[] params= {begincity,endcity,dis,vehicle,begintime,endtime,money,alltime};
			int line=qr.update(con,sql,params);
			return line;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//查找是否已经有这条线
	public static int FindYON(String begin,String end) {
		int a=FindCityNum(begin);
		int b=FindCityNum(end);
		try {
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String s="SELECT alltime FROM line WHERE begincity=? AND endcity=?";
			Object[] params= {a,b};
			List<Integer> list=qr.query(con,s,new ColumnListHandler<Integer>(),params);
			if(!list.isEmpty()) {
				return 1;
			}else {
				return 0;
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

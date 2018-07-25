package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.mysql.jdbc.PreparedStatement;

import other.JDBCUtils;
import person.DijkLine;
import person.FindLineTest;
import person.Line;

public class FindLine_PER {

	//获得城市的最大个数
	public static int  GetCityNum() {
		try {
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String sql="SELECT * FROM city WHERE citynum>0";
			List<Integer> list=qr.query(con,sql,new ColumnListHandler<Integer>());
			int max=0;
			for(int i:list) {
				if(max<i) {
					max=i;
				}
			}
			return max+1;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//获得城市的矩阵图(按钱)
	public static int[][] GetCityTuMon(){
		try {
			int max=GetCityNum();
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String s="select * from line";
			PreparedStatement stat=(PreparedStatement) con.prepareStatement(s);
			ResultSet rs=stat.executeQuery();
			int[][] a=new int[max][max];
			while(rs.next()) {
				a[rs.getInt("begincity")][rs.getInt("endcity")]=Integer.parseInt(rs.getString("money"));
				
			}
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a.length;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			return a;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//获得城市矩阵图（按时间）
	public static int[][] GetCityTuTime(){
		try {
			int max=GetCityNum();
			Connection con=JDBCUtils.getConnection();
			QueryRunner qr=new QueryRunner();
			String s="select * from line";
			PreparedStatement stat=(PreparedStatement) con.prepareStatement(s);
			ResultSet rs=stat.executeQuery();
			int[][] a=new int[max][max];
			while(rs.next()) {
				a[rs.getInt("begincity")][rs.getInt("endcity")]=Integer.parseInt(rs.getString("alltime"));
			} 
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a.length;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			return a;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

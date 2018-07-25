package persistence;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

import other.JDBCUtils;

public class ModCityLine_PER {

	
	//根据起始距离更新路线
	public static int ModCityLine(int begincity,int endcity,double dis,String vehicle,String begintime,String endtime,String money,String alltime) {
		try {
			QueryRunner qr=new QueryRunner();
			String sql="UPDATE line SET dis=?,vehicle=?,begintime=?,endtime=?,money=?,alltime=? WHERE begincity=? AND endcity=?";
			Object[] pramas= {dis,vehicle,begintime,endtime,money,alltime,begincity,endcity};
			Connection con=JDBCUtils.getConnection();
			int line=qr.update(con,sql,pramas);
			return line;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}

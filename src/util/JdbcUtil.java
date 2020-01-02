package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
	
	public static Connection getConnection() {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="SCOTT";
		String pw="TIGER";

		Connection con = null;

		try {
			//1. Driver클래스를 로딩
			Class.forName(driver);
			//2. 로딩된 Driver클래스를 이용해서 Connection요청(url, user, pwd)
			con = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
            e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con,Statement ps,ResultSet rs) {
		// 자원정리(connection, statement, resultset)
		try {
            if(rs != null) rs.close();				
            if(ps != null) ps.close();				
            if(con != null) con.close();				
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}
}

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("JDBC TEST");
		
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="SCOTT";
		String pw="TIGER";
		
		String sql = "select * from dept";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			//1. Driver클래스를 로딩
			Class.forName(driver);
			
			//2. 로딩된 Driver클래스를 이용해서 Connection요청(url, user, pwd)
			con = DriverManager.getConnection(url, user, pw);
			
			//3. 생성된Connection으로부터 Statement생성
			ps = con.prepareStatement(sql);
			
			//4. 생성된 Statement를 이용해서 sql수행
			rs = ps.executeQuery();
			
			//5. 결과 처리(ResultSet, int)
			while(rs.next()) {
				System.out.print(rs.getString("deptno")+" ");
				System.out.print(rs.getString("dname")+" ");
				System.out.print(rs.getString("loc")+" ");
				System.out.println("\n---------------------------");
			}
			
		} catch (Exception e) {
			//6. SQLException 처리
			System.out.println(e);
		}finally {
			//7. 자원정리(connection, statement, resultset)
			try {
                if(rs != null) rs.close();				
                if(ps != null) ps.close();				
                if(con != null) con.close();				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		System.out.println("JDBC TEST END");
	}
}






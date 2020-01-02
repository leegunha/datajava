package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.JdbcUtil;

public class Test02_emp {
	public static void main(String[] args) {
		System.out.println("JDBC TEST");
		
		String sql = "select * from emp where deptno = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtil.getConnection();
			
			//3. 생성된Connection으로부터 Statement생성
			ps = con.prepareStatement(sql);
			
			String deptno = JOptionPane.showInputDialog("deptno"); 
			
			// ? 값 세팅
            ps.setInt(1, Integer.parseInt(deptno));
            
			//4. 생성된 Statement를 이용해서 sql수행
			rs = ps.executeQuery();
			
			//5. 결과 처리(ResultSet, int)
			while(rs.next()) {
				System.out.print(rs.getString("ename")+" ");
				System.out.print(rs.getString("sal")+" ");
				System.out.print(rs.getString("job")+" ");
				System.out.print(rs.getDate("hiredate")+" ");
				System.out.print(rs.getInt("deptno")+" ");
				System.out.println("\n---------------------------");
			}
		} catch (Exception e) {
			//6. SQLException 처리
			System.out.println(e);
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		System.out.println("JDBC TEST END");
	}
}






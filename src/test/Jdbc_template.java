package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JdbcUtil;

public class Jdbc_template {

	public static void main(String[] args) {
	}

	//JDBC Template
	public void temp() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		String sql="select ~~~";
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			//? 값 세팅 작업
			rs = ps.executeQuery();    //select 구문 처리 함수 
			row = ps.executeUpdate();  //dml 구문 처리 함수
			
			//결과 값 처리 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
	}
}








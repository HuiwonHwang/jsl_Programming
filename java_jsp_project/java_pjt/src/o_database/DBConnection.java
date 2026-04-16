package o_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	//db 연결	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//다양한 db중 오라클driver를 연결한다
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String db_url = "jdbc:oracle:thin:@192.168.0.140:1522/xe";
		String db_user="c##track27";
		String db_passwords="1234";
			
		try {
			con= DriverManager.getConnection(db_url, db_user, db_passwords);
		} catch (SQLException e) {
			System.out.println("DB Connection Error!");
			e.printStackTrace();
		}
		
		return con;
	}


	//연결 종료  끊을때는 역순
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}

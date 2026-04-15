package o_database;

import java.sql.Connection;

public class DBConnection {
	Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//다양한 db중 오라클driver를 연결한다
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
	
	
	
	
	
	
	
}

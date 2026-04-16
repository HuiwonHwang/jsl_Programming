package o_database;

import java.sql.Connection;

public class DBTest {

	public static void main(String[] args) {
//		DBConnection db = new DBConnection();
//		Connection con= db.getConnection();  static을 붙여서 생략가능
		Connection con= DBConnection.getConnection();
		System.out.println(con);
		
		
		
		
	}

}

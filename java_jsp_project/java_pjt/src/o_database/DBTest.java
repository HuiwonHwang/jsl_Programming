package o_database;

import java.sql.Connection;

public class DBTest {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		Connection con= db.getConnection();
		System.out.println(con);
		
		
		
		
	}

}

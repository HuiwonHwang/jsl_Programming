package o_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import o_database.DBConnection;

public class Snackdao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Snackdto> getSnackCompany(){
		ArrayList<Snackdto> dtos = new ArrayList<>();
		String sql = "select * from snack_company";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString("company_code");
				String name = rs.getString("company_name");
				Snackdto dto =new Snackdto(code,name);
				dtos.add(dto);
			}
			
			
		}catch(Exception e) {
			System.out.println("Error: " + sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return dtos;
	}

	public String getSnackView(String code) {
		String name2 = null;
		String sql="select company_name from snack_company where company_code = '"+code+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				name2=rs.getString("company_name");
				
			}
		}catch(Exception e) {
			System.out.println("error: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return name2;
	}
	
	
	
	
}

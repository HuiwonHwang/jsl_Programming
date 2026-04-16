package o_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	Connection con =null;
	PreparedStatement ps =null;
	ResultSet rs= null;

	ArrayList<MemberDto>  getMemberList(){
		ArrayList<MemberDto> dtos = new ArrayList<>();
		
		String sql ="select * from member_황희원 order by id" ;
		

		try {
			con = DBConnection.getConnection();
			ps =con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				String id= rs.getString("id");
				String name = rs.getString("name");
				String area= rs.getString("area");
				int age = rs.getInt("age");
				MemberDto dto = new MemberDto(id,name,area,age);
				dtos.add(dto);
			} 
			
		} catch (SQLException e) {
			System.out.println("getMemberlist() Error: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con,ps,rs);
		}
		
		return dtos;
	}

	public MemberDto getMemberView(String ViewId) {
		MemberDto dto = null;
		String sql = "select * from member_황희원 where id = '"+ViewId+"'";
		
		try {
			con= DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area");
				int age = rs.getInt("age");
				dto= new MemberDto(id, name, area, age);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("getMemberView Error: "+ sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	
	
	
	
}

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

	public String getMemberName(String id) {
		String name=null;
		String sql = "select name from member_황희원 where id = '"+id+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				name=rs.getString("name");
			}
		}catch(Exception e) {
			System.out.println("Error: "+sql);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		return name;
	}

	//회원 등록
	public int memberSave(MemberDto dto) {
		int result =0;
		String sql ="insert into member_황희원(id, name, area, age) values('"+dto.getId()+"','"+dto.getName()+"','"+dto.getArea()+"',"+dto.getAge() +")";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			result=ps.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("error: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}

	//id 중복 검사하기
	public int checkId(String id) {
		int count = 0;
		String sql="select count(*) as count from member_황희원 where id = '"+id+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt("count");
			}
			
		}catch(Exception e) {
			System.out.println("error: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return count;
	}
	
	
	
	
}

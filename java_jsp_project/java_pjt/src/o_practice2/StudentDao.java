package o_practice2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import o_database.DBConnection;

public class StudentDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	public int studentSave(StudentDto dto) {
		int result=0;
		String sql = "insert into student_황희원(syear, sclass, sno, name,kor,eng,mat) \r\n"
				+ "values('"+dto.getSyear()+"','"+dto.getSclass()+"','"+dto.getSno()+"','"+dto.getName()+"',"+dto.getKor()+","+dto.getEng()+","+dto.getMat()+")";
		
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}



	public ArrayList<StudentDto> getSearching() {
		ArrayList<StudentDto> dtos = new ArrayList<>();
		String sql="select * from student_황희원 order by syear,sclass,sno";
		
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String syear = rs.getString("syear");
				String sclass=rs.getString("sclass");
				String sno=rs.getString("sno");
				String name=rs.getString("name"); 
				int kor=rs.getInt("kor");
				int eng=rs.getInt("eng");
				int mat=rs.getInt("mat");
				 
				StudentDto dto = new StudentDto(syear, sclass, sno, name, kor, eng, mat);
				dtos.add(dto);		
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error:"+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}



	public ArrayList<StudentDto> getSearchingGrade(int grade) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		String sql = "select * from student_황희원 where syear ='"+grade+"' order by sclass,sno";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String syear = rs.getString("syear");
				String sclass=rs.getString("sclass");
				String sno=rs.getString("sno");
				String name=rs.getString("name"); 
				int kor=rs.getInt("kor");
				int eng=rs.getInt("eng");
				int mat=rs.getInt("mat");
				 
				StudentDto dto = new StudentDto(syear, sclass, sno, name, kor, eng, mat);
				dtos.add(dto);	
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}



	public StudentDto getSearchingName(String searchingName) {
		StudentDto dto = null;
		String sql = "select * from student_황희원 where name ='"+searchingName+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String syear = rs.getString("syear");
				String sclass=rs.getString("sclass");
				String sno=rs.getString("sno");
				String name=rs.getString("name"); 
				int kor=rs.getInt("kor");
				int eng=rs.getInt("eng");
				int mat=rs.getInt("mat");
				dto = new StudentDto(syear, sclass, sno, name, kor, eng, mat);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}



	public StudentDto getSearchingSpecific(int searchingGrade, int searchingClass, int searchingNumber) {
		StudentDto dto = null;
		String sql ="select * from student_황희원 where syear='"+searchingGrade+"' and sclass='"+searchingClass+"' and sno ='"+searchingNumber+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String syear = rs.getString("syear");
				String scalss = rs.getString("sclass");
				String sno = rs.getString("sno");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat =rs.getInt("mat");
				
				dto = new StudentDto(syear, scalss, sno, name, kor, eng, mat);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error:"+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}



	public void dtosPrint(ArrayList<StudentDto> dtos) {
		System.out.println("==========================result==========================");
		System.out.println("grade   class   number   name   kor   eng   mat\r");
		if(dtos.size()!=0) {
			for(int i=0;i<dtos.size();i++) {
				System.out.print(dtos.get(i).getSyear()+"\t");
				System.out.print(dtos.get(i).getSclass()+"\t");
				System.out.print(dtos.get(i).getSno()+"\t");
				System.out.print(dtos.get(i).getName()+"\t");
				System.out.print(dtos.get(i).getKor()+"\t");
				System.out.print(dtos.get(i).getEng()+"\t");
				System.out.print(dtos.get(i).getMat()+"\r");
			}
		}else System.out.println("doesn't exist");
		
		System.out.println("-----------------------------------------------------------\r");
		
		
	}



	
	
	
	
	
	
	
	
	
}

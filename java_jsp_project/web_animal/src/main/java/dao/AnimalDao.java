package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.AnimalDto;

public class AnimalDao {
	Connection con =null;
	PreparedStatement ps =null;
	ResultSet rs= null;

	//전체조회
	public ArrayList<AnimalDto> getAnimalList() {
		ArrayList<AnimalDto> dtos = new ArrayList<>();
		String sql= "select no,name,kind,weight from animal_황희원 order by no";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				int weight = rs.getInt("weight");
				
				AnimalDto dto = new AnimalDto(no,name,kind,weight);
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
	
	//dtos 조회  
	public void printDtos(ArrayList<AnimalDto> dtos) {
		System.out.println("==============조회==============");
		System.out.println("번호\t이름\t분류\t무게\r");
		for(int i = 0;i<dtos.size();i++) {
			System.out.print(dtos.get(i).getNo()+"\t");
			System.out.print(dtos.get(i).getName()+"\t");
			if(dtos.get(i).getKind().equalsIgnoreCase("O"))System.out.print("해상동물\t");
			else if(dtos.get(i).getKind().equalsIgnoreCase("L"))System.out.print("육상동물\t");
			System.out.println(dtos.get(i).getWeight()+"\t");
		}
		System.out.println("----------------------------------\r");
		
		
	}
	//동물등록
	public int animalInsert(String no, String name, String kind, int weight) {
		int result = 0;
		String sql="insert into animal_황희원 (no,name,kind,weight) values ('"+no+"','"+name+"','"+kind+"',"+weight+")";
		
		try {
			con=DBConnection.getConnection();
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

	//번호검색, update시 동물 불러오기, delete시 동물불러오기
	public AnimalDto searchingByNumber(String searchingByNumber) {
		AnimalDto dto = null;
		String sql ="select no,name,kind,weight from animal_황희원 where no='"+searchingByNumber+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				int weight = rs.getInt("weight");
				
				dto = new AnimalDto(no,name,kind,weight);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	
	//dto 출력
	public void printDto(AnimalDto dto) {
		System.out.println("==============조회==============");
		System.out.println("번호\t이름\t분류\t무게\r");
			System.out.print(dto.getNo()+"\t");
			System.out.print(dto.getName()+"\t");
			if(dto.getKind().equalsIgnoreCase("O"))System.out.print("해상동물\t");
			else if(dto.getKind().equalsIgnoreCase("L"))System.out.print("육상동물\t");
			System.out.println(dto.getWeight()+"\t");
		System.out.println("----------------------------------\r");
		
	}

	//이름검색
	public ArrayList<AnimalDto> searchingByName(String nameForSearching) {
		ArrayList<AnimalDto> dtos=new ArrayList<>();
		String sql="select no,name,kind,weight from animal_황희원 where name like'%"+nameForSearching+"%' order by no";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				int weight = rs.getInt("weight");
				
				AnimalDto dto = new AnimalDto(no,name,kind,weight);
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
	
	//수정
	public int AnimalUpadte(String noForUpdate, String nameForUpdate, String kindForUpdate, int weightForUpdate) {
		int result=0;
		String sql ="update animal_황희원 set name='"+nameForUpdate+"',kind='"+kindForUpdate+"',weight="+weightForUpdate+" where no = '"+noForUpdate+"'";
		
		try {
			con=DBConnection.getConnection();
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
	
	//삭제
	public int AnimalDelete(String noForDelete) {
		int result =0;
		String sql="delete from animal_황희원 where no= '"+noForDelete+"' ";
		
		try {
			con=DBConnection.getConnection();
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

	//중복검사
	public int checking(String noForInsert) {
		int result = 0;
		String sql="select count(*) from animal_황희원 where no='"+noForInsert+"'";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getInt("count(*)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	public ArrayList<AnimalDto> getAnimalListGubun(String gubun,String sname) {
		ArrayList<AnimalDto> dtos = new ArrayList<>();
		String sql= "";
		if(gubun.equals("")) {sql= "select no,name,kind,weight from animal_황희원 where  name like'%"+sname+"%' order by no";}
		else {
			sql= "select no,name,kind,weight from animal_황희원 where kind like '%"+gubun+"%' and name like'%"+sname+"%' order by no";

		}
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				int weight = rs.getInt("weight");
				
				AnimalDto dto = new AnimalDto(no,name,kind,weight);
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
	
	
}

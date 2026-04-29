package o_황희원;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SnackDao {
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	String pcode,pname,company,company_name,makedate;
	int price;
	DecimalFormat df = new DecimalFormat();
	
	
	
	public ArrayList<SnackDto> getSearching(String searchingGubun, String searching) {
		ArrayList<SnackDto> dtos = new ArrayList<>();
		
		switch(searchingGubun) {
		case "1":
			String sql= "select s.pcode,s.pname,s.company,c.company_name,s.price,to_char(s.makedate,'yyyy-MM-dd') as makedate from snack_황희원 s,snack_company c "
					+"  where s.company = c.company_code order by pcode";
			try {
				con=DBConnection.getConnection();
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					pcode=rs.getString("pcode");
					pname=rs.getString("pname");
					company=rs.getString("company");
					company_name=rs.getString("company_name");
					makedate=rs.getString("makedate");
					price=rs.getInt("price");
					SnackDto dto=new SnackDto(pcode, pname, company, company_name, makedate, price);
					dtos.add(dto);
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error: "+sql);
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			break;
		case "2":
			sql ="select s.pcode,s.pname,s.company,c.company_name,s.price,to_char(s.makedate,'yyyy-MM-dd') as makedate from snack_황희원 s,snack_company c "
					+"  where s.company = c.company_code and pname like '%"+searching+"%' order by pcode ";
			try {
				con=DBConnection.getConnection();
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					pcode=rs.getString("pcode");
					pname=rs.getString("pname");
					company=rs.getString("company");
					company_name=rs.getString("company_name");
					makedate=rs.getString("makedate");
					price=rs.getInt("price");
					SnackDto dto=new SnackDto(pcode, pname, company, company_name, makedate, price);
					dtos.add(dto);
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error: "+sql);
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			break;
		case "3":
			
			sql = "select s.pcode,s.pname,s.company,c.company_name,s.price,to_char(s.makedate,'yyyy-MM-dd') as makedate from snack_황희원 s,snack_company c "
					+ "	 where s.company = c.company_code and s.company = '"+searching+"' order by pcode  ";
			try {
				con=DBConnection.getConnection();
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					pcode=rs.getString("pcode");
					pname=rs.getString("pname");
					company=rs.getString("company");
					company_name=rs.getString("company_name");
					makedate=rs.getString("makedate");
					price=rs.getInt("price");
					SnackDto dto=new SnackDto(pcode, pname, company, company_name, makedate, price);
					dtos.add(dto);
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error: "+sql);
			}finally {
				DBConnection.closeDB(con, ps, rs);
			}
			break;
		case "0":
			break;
		default:
			System.out.println("0~3 중 골라주세요");
			break;
		}
		
		return dtos;
	}

	public void printDtos(ArrayList<SnackDto> dtos) {
		if(dtos.size()!=0) {
			System.out.println("====================조회====================");
			System.out.println("제품코드\t\t제품명\t\t제조사[제조사코드]\t\t가격\t\t제조일");
			for(SnackDto dto : dtos) {
				System.out.print(dto.getPcode()+"\t\t");
				System.out.print(dto.getPname()+"\t\t");
				System.out.print(dto.getCompany_name()+"["+dto.getCompany()+"]\t\t");
				System.out.print(df.format(dto.getPrice()) +"\t\t");
				System.out.println(dto.getMakedate());
			}
			
//			for(int i=0;i<dtos.size();i++) {
//				System.out.print(dtos.get(i).getPname()+"\t");
//				System.out.print(dtos.get(i).getPcode()+"\t");
//				System.out.println(dtos.get(i).getCompany_name()+"["+dtos.get(i).getCompany()+"]");
//			} 과거의 잔재
			System.out.println("--------------------------------------------------");	
		}else System.out.println("정보 없음");
	}

	public int insert(String pcode2, String pname2, String company2, int price2, String makedate2) {
		int insertResult =0;
		String sql="insert into snack_황희원 (pcode,pname,company, price,makedate) "
				+ "values ('"+pcode2+"','"+pname2+"','"+company2+"',"+price2+",'"+makedate2+"')";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			insertResult=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return insertResult;
	}

	public int duplicateCheck(String pcode2) {
		int duplicateCheck=0;
		String sql="select count(*) from snack_황희원 where pcode='"+pcode2+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				duplicateCheck=rs.getInt("count(*)");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return duplicateCheck;
	}
	
	public ArrayList<CompanyDto> getCompanyList() {
		ArrayList<CompanyDto> comDtos = new ArrayList<>(); 
		String sql = "select * from snack_company";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String company_code=rs.getString("company_code");
				String company_name=rs.getString("company_name");
				CompanyDto comDto=new CompanyDto(company_code, company_name);
				comDtos.add(comDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return comDtos;
	}
	
	public void companyPrint(ArrayList<CompanyDto> comDtos) {
		if(comDtos.size()!=0) {
			System.out.println("====================조회====================");
			System.out.println("제조사명\t제조사 코드");
			for(CompanyDto dto : comDtos) {
				System.out.print(dto.getCompany_name()+"\t");
				System.out.print(dto.getCompany_code()+"\r");
			}
			System.out.println("--------------------------------------------------\r");	
		}else System.out.println("정보 없음");
	}

	public int update(String update, String pname2, String company2, int price2, String makedate2) {
		int updateResult=0;
		String sql="update snack_황희원 set pname='"+pname2+"',company='"+company2+"',price="+price2+",'"+makedate2+"' where pcode='"+update+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			updateResult=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return updateResult;
	}

	public int delete(String delete) {
		int deleteResult=0;
		String sql="delete from snack_황희원 where pcode='"+delete+"'";
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			deleteResult=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return deleteResult;
	}

	public String getMaxCode() {
		String max="";
		String sql="select max(pcode) from snack_황희원";
		
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				max=rs.getString("max(pcode)");
				if(max==null) max="P000";
				int m= Integer.parseInt(max.substring(1))+1 ;
				DecimalFormat df = new DecimalFormat("P000");
				max=df.format(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return max;
	}
	

}

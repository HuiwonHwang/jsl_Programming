package o_황희원;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SnackDao {
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	String pcode,pname,company,company_name,makedate;
	int price;
	
	
	
	
	public ArrayList<SnackDto> getSearching(String searchingGubun, String searching) {
		ArrayList<SnackDto> dtos = new ArrayList<>();
		String sql = "select s.pcode,s.pname,s.company,c.company_name,s.price,to_char(s.makedate,'yyyy-MM-dd') as makedate from snack_황희원 s,snack_company c "
				+"where s.company = c.company_code";
		switch(searchingGubun) {
		case "1":
			
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
			sql =sql+" and pname = '%"+searching+"%'";
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
			sql =sql+ " and company = '"+searching+"'";
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
		System.out.println("====================searching====================");
		System.out.println("제품명\t제품코드\t제조사[제조사코드]");
		for(int i=0;i<dtos.size();i++) {
			System.out.print(dtos.get(i).getPname()+"\t");
			System.out.print(dtos.get(i).getPcode()+"\t");
			System.out.println(dtos.get(i).getCompany_name()+"["+dtos.get(i).getCompany()+"]");
		}
		System.out.println("--------------------------------------------------");
	}

}

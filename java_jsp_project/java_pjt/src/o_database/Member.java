package o_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		MemberDao dao= new MemberDao();
		Scanner sc = new Scanner(System.in);
		
		ArrayList<MemberDto> dtos= dao.getMemberList();
		System.out.println("=============전체조회===========");
		for(int i=0;i<dtos.size();i++) {
			System.out.print(dtos.get(i).getId()+"\t");
			System.out.print(dtos.get(i).getName()+"\t");
			System.out.print(dtos.get(i).getArea()+"\t");
			System.out.println(dtos.get(i).getAge());
		}
		System.out.println("------------------------------");
		System.out.println("total: "+dtos.size()+"\r");
		
		System.out.println("id?");
		String id = sc.next();
		MemberDto dto =dao.getMemberView(id);
		System.out.println("=============상세조회===========");
		if(dto!=null) {
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getArea()+"\t");
			System.out.println(dto.getAge());	
		}else {
			System.out.println("\tno information");
		}
		System.out.println("------------------------------");
		
		
		
	}

}

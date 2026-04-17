package o_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		MemberDao dao= new MemberDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("id");
		String id =sc.next();
		
		
		int count = dao.checkId(id);
		if(count==0) {
			System.out.println("name");
			String name=sc.next();
			System.out.println("area");
			String area=sc.next();
			System.out.println("age");
			int age =sc.nextInt();
			MemberDto dto = new MemberDto(id,name,area,age);
			int result =dao.memberSave(dto);
			
			if(result>0) {
				System.out.println(result+"행이 삽입되었습니다.");
			} else {
				System.out.println("insert failed");
			}
		}else {
			System.out.println("already exsist");
		}
		
		/*
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
		System.out.println("------------------------------\r");

		System.out.println("about name's id?");
		String id2 = sc.next();
		String name =dao.getMemberName(id2);
		System.out.println("============성명조회===========");
		if(name!=null) {
			System.out.println("\t"+id2+": "+name);
		}else {
			System.out.println("\tno information");
		}
		System.out.println("------------------------------");
		
		
		
		
*/		
	}

}

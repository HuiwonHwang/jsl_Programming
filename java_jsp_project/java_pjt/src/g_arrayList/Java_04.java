package g_arrayList;

import java.util.ArrayList;

public class Java_04 {

	public static void main(String[] args) {
		Java_04_DAO dao = new Java_04_DAO();
		ArrayList<Java_04_DTO> dtos1 = new ArrayList<>();
		

		Java_04_DTO dto1 = dao.getMember();
		
		System.out.println("id: "+ dto1.getId());
		System.out.println("name: "+ dto1.getName());
		System.out.println("area: "+ dto1.getArea());
		System.out.println("age: "+ dto1.getAge());
		
		
		Java_04_DTO dto2 = dao.getMember2();
		System.out.println("========dto2========");
		System.out.println("id: "+ dto2.getId());
		System.out.println("name: "+ dto2.getName());
		System.out.println("area: "+ dto2.getArea());
		System.out.println("age: "+ dto2.getAge());
		
		Java_04_DTO dto3 = dao.getMember3("301","박길동","대구",45);
		System.out.println("========dto3========");
		System.out.println("id: "+ dto3.getId());
		System.out.println("name: "+ dto3.getName());
		System.out.println("area: "+ dto3.getArea());
		System.out.println("age: "+ dto3.getAge());
		
		
		dtos1.add(dto1);
		dtos1.add(dto2);
		dtos1.add(dto3);
		System.out.println("========dtos1========");
		for(int i=0;i<dtos1.size();i++) {
			System.out.print(dtos1.get(i).getId()+"\t");
			System.out.print(dtos1.get(i).getName()+"\t");
			System.out.print(dtos1.get(i).getArea()+"\t");
			System.out.print(dtos1.get(i).getAge()+"\r");
		}		
		
		ArrayList<Java_04_DTO> dtos2 = dao.getList1();
		System.out.println("========dtos2========");
		for(int i=0;i<dtos2.size();i++) {
			System.out.print(dtos2.get(i).getId()+"\t");
			System.out.print(dtos2.get(i).getName()+"\t");
			System.out.print(dtos2.get(i).getArea()+"\t");
			System.out.print(dtos2.get(i).getAge()+"\r");
		}
		ArrayList<Java_04_DTO> dtos3 = dao.getList3(dto1,dto2);
		dtos3.add(dto3);
		System.out.println("========dtos3========");
		for(int i=0;i<dtos3.size();i++) {
			System.out.print(dtos3.get(i).getId()+"\t");
			System.out.print(dtos3.get(i).getName()+"\t");
			System.out.print(dtos3.get(i).getArea()+"\t");
			System.out.print(dtos3.get(i).getAge()+"\r");
		}
		
		Java_04_DTO dto4 = dao.getInfo(dtos3,"801");
		System.out.println("========dto4========");
		if(dto4.getId()!=null) {
		System.out.println("id: "+ dto4.getId());
		System.out.println("name: "+ dto4.getName());
		System.out.println("area: "+ dto4.getArea());
		System.out.println("age: "+ dto4.getAge());
		}else {
			System.out.println("존재하지않습니다.");
		}
		
	}

}

package g_arrayList;

import java.util.ArrayList;

public class Java_04_DAO {
	//바로 아래껀 기본생성자
	public Java_04_DTO getMember() {
		Java_04_DTO dto = new Java_04_DTO();
		dto.setId("101");
		dto.setName("홍길동");
		dto.setArea("서울");
		dto.setAge(25);
		
		return dto;
	}
	
	//전체생성자
	public Java_04_DTO getMember2() {
		Java_04_DTO dto = new Java_04_DTO("201","김길동","대전",35);
		
		return dto;
	}
	
	
	//기본생성자이지만
	public Java_04_DTO getMember3(String id, String name, String area, int age) {
		Java_04_DTO dto = new Java_04_DTO();
		dto.setId(id);
		dto.setName(name);
		dto.setArea(area);
		dto.setAge(age);
		
		return dto;
	}

	public ArrayList<Java_04_DTO> getList1() {
		ArrayList<Java_04_DTO> dtos = new ArrayList<>();
		Java_04_DTO dto= new Java_04_DTO("401", "최길동","부산", 55);
		Java_04_DTO dto1= new Java_04_DTO("501", "유길동","제주", 65);
		dtos.add(dto);
		dtos.add(dto1);
		return dtos;
	}

	public ArrayList<Java_04_DTO> getList3(Java_04_DTO dto1, Java_04_DTO dto2) {
		ArrayList<Java_04_DTO> dtos = new ArrayList<>();
		dtos.add(dto1);
		dtos.add(dto2);
		return dtos;
	}

	public Java_04_DTO getInfo(ArrayList<Java_04_DTO> dtos3, String idForSearching) {
		Java_04_DTO dto = new Java_04_DTO();
		
		for(int i=0;i<dtos3.size();i++) {
			if(dtos3.get(i).getId().equals(idForSearching))dto=dtos3.get(i);
		}
		return dto;
	}




}

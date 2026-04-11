package g_arrayList;

import java.util.ArrayList;

public class Java_02 {

	
	public static void main(String[] args) {
		//ArrayList<String>     arr  = new ArrayList<String>();
		ArrayList<Java_02Dto> dtos = new ArrayList<>();
		Java_02Dto dto1 = new Java_02Dto("101","홍길동","영업",25);
		Java_02Dto dto2 = new Java_02Dto("201","김길동","총무",27);
		Java_02Dto dto3 = new Java_02Dto("301","박길동","생산",29);

		dtos.add(dto1);
		dtos.add(dto2);
		dtos.add(dto3);
		
		for(int k=0; k<dtos.size(); k++) {
			System.out.print(dtos.get(k).getId()+" ");
			System.out.print(dtos.get(k).getName()+" ");
			System.out.print(dtos.get(k).getDepart()+" ");
			System.out.print(dtos.get(k).getAge()+"\r");
		}
		
		

		
		
	}

}





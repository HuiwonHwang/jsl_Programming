package o_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Snack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Snackdao dao = new Snackdao();
		
		ArrayList<Snackdto> dtos = dao.getSnackCompany();
	
		int gubun = 0;
		do {
			System.out.println("what do you want to do 1. full 2.searching company by code 0.close\r");
			gubun =sc.nextInt();
			switch(gubun) {
			case 1:
				System.out.println("==full searching==");
				for(int i=0;i<dtos.size();i++) {
					System.out.print(dtos.get(i).getCompany_code()+"\t");
					System.out.println(dtos.get(i).getCompany_name());
				}
				System.out.println("----------------");
				break;
			case 2:
				System.out.println("searching by code");
				String code=sc.next();
				String name = dao.getSnackView(code);
				System.out.println("==searching==");
				if(name!=null) {
					System.out.println(code+": "+name);
				}else {
					System.out.println("no information");
				}
					System.out.println("----------------");	
				break;
				
			default:
				System.out.println("\rchoose 0~2 \r");
			}
		}while(gubun!=0);
		
		//10일때 제조사명
		
		
	}

}

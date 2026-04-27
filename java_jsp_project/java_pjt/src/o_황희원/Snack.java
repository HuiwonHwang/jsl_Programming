package o_황희원;

import java.util.ArrayList;
import java.util.Scanner;

public class Snack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SnackDao dao= new SnackDao();
		
		String gubun = "";
		String searchingGubun="";
		String searching="";
		do {
			System.out.println("1. searching 2. insert 3. update 4. delete 0. close\r");
			gubun=sc.next();			
			switch(gubun) {
			case "1":
				System.out.println("1. full searching 2. 제품명 조회 3. 제조사 검색 0. 나가기");
				searchingGubun=sc.next();
				if(searchingGubun.equals("2")) {
					System.out.println("조회를 원하는 제품명을 입력하시오");
					searching=sc.next();
				} else if(searchingGubun.equals("3")) {
					System.out.println("조회를 원하는 제조사를 입력하시오");
					searching=sc.next();
				}
				ArrayList<SnackDto> dtosSearching = new ArrayList<>();
				dtosSearching = dao.getSearching(searchingGubun,searching);
				dao.printDtos(dtosSearching);
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "0":
				break;
			default:
				System.out.println("Enter 0 ~ 4");	
				break;
			}
			
			
			
		}while(!gubun.equals("0"));
		System.out.println("System Off");
		
		
		
		
	}

}

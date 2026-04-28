package o_황희원;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Snack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SnackDao dao= new SnackDao();
		
		String gubun = "";
		String searchingGubun="";
		String searching="";
		String pcode;
		String pname;
		String company;
		String company_name;
		String makedate;
		int price;
		do {
			System.out.println("1. searching 2. insert 3. update 4. delete 0. close\r");
			gubun=sc.next();			
			switch(gubun) {
			case "1":
				System.out.println("1. 전체 조회 2. 제품명 조회 3. 제조사 검색 0. 나가기");
				searchingGubun=sc.next();
				if(searchingGubun.equals("2")) {
					System.out.println("조회를 원하는 제품명을 입력하시오");
					searching=sc.next();
				} else if(searchingGubun.equals("3")) {
					ArrayList<CompanyDto> comDtos = dao.getCompanyList();
					dao.companyPrint(comDtos);
					System.out.println("조회를 원하는 제조사의 코드를 입력하시오");
					searching=sc.next();
					
				}
				ArrayList<SnackDto> dtosSearching = new ArrayList<>();
				dtosSearching = dao.getSearching(searchingGubun,searching);
				dao.printDtos(dtosSearching);
				break;
			case "2":
				System.out.println("삽입할 과자의 제품 코드를 입력해주세요  ex)p001");
				pcode=sc.next();
				if(pcode.substring(0, 1).equalsIgnoreCase("p")) {
					int duplicateCheck=dao.duplicateCheck(pcode);
					if(duplicateCheck!=1) {
						System.out.println("삽입할 과자의 제품명을 입력해주세요");
						pname=sc.next();
						System.out.println("삽입할 과자의 제조사 코드를 입력해주세요");
						company=sc.next();
						System.out.println("삽입할 과자의 가격을 입력해주세요");
						price=sc.nextInt();
						int resultInsert = dao.insert( pcode, pname,  company,  price);
						if(resultInsert!=0)System.out.println(resultInsert+" 행이 삽입되었습니다.");
						else System.out.println("삽입 실패");
					}else System.out.println("중복된 pcode입니다");
					
				}else {
					System.out.println("잘못된 pcode입니다 p로 시작해야합니다.");
				}
				
				
				break;
			case "3":
				dtosSearching = dao.getSearching("1",searching);
				dao.printDtos(dtosSearching);
				System.out.println("수정할 제품코드를 입력해주세요");
				String update=sc.next();
				if(update.substring(0, 1).equalsIgnoreCase("p")) {
					System.out.println("변경할 제품명를 입력해주세요");
					pname=sc.next();
					ArrayList<CompanyDto> comDtos = dao.getCompanyList();
					dao.companyPrint(comDtos);
					System.out.println("변경할 제조사를 번호로 입력해주세요");
					company=sc.next();
					System.out.println("변경할 가격를 입력해주세요");
					price=sc.nextInt();
					int resultUpdate = dao.update(update,pname,company,price);
					if(resultUpdate>0) System.out.println(resultUpdate +" 행이 수정되었습니다.");
					else System.out.println("수정 실패");
				}
				break;
			case "4":
				dtosSearching = dao.getSearching("1",searching);
				dao.printDtos(dtosSearching);
				System.out.println("삭제할 제품코드를 입력해주세요");
				String delete=sc.next();
				int deleteResult=dao.delete(delete);
				if(deleteResult>0)System.out.println(deleteResult+" 행이 삭제되었습니다.");
				else System.out.println("삭제 실패");
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

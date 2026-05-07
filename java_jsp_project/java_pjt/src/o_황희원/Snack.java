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
				System.out.println("1. 전체 조회 2. 제품명 조회 3. 제조사 검색 4. 제품코드 검색 0. 나가기");
				searchingGubun=sc.next();
				if(searchingGubun.equals("2")) {
					System.out.println("조회를 원하는 제품명을 입력하시오");
					searching=sc.next();
				} else if(searchingGubun.equals("3")) {
					ArrayList<CompanyDto> comDtos = dao.getCompanyList();
					dao.companyPrint(comDtos);
					System.out.println("조회를 원하는 제조사의 코드를 입력하시오");
					searching=sc.next();
				} else if(searchingGubun.equals("4")) {
					System.out.println("조회를 원하는 제품코드를 입력하시오");
					searching=sc.next();
				}
				ArrayList<SnackDto> dtosSearching = new ArrayList<>();
				dtosSearching = dao.getSearching(searchingGubun,searching);
				dao.printDtos(dtosSearching);
				break;
			case "2":
				
				String maxPcode=dao.getMaxCode();
				
				
				System.out.println("삽입될 제품코드는 "+maxPcode+"입니다.  Y/N");
				if(sc.next().equalsIgnoreCase("Y")) {
//					System.out.println("삽입할 과자의 제품 코드를 입력해주세요  ex)p001");
//					pcode=sc.next();
//					if(pcode.substring(0, 1).equalsIgnoreCase("p")) {
//						int duplicateCheck=dao.duplicateCheck(pcode);
//						if(duplicateCheck!=1) {
							System.out.println("삽입할 과자의 제품명을 입력해주세요");
							pname=sc.next();
							ArrayList<CompanyDto> comDtos = dao.getCompanyList();
							dao.companyPrint(comDtos);
							boolean going=false;
							do {
								System.out.println("삽입할 과자의 제조사 코드를 입력해주세요");
								company=sc.next();	
								for( CompanyDto cdto: comDtos) {
									if(cdto.getCompany_code().equals(company))going=true;
								}
							}while(!going);
							System.out.println("삽입할 과자의 가격을 입력해주세요");
							price=sc.nextInt();
							System.out.println("삽입할 과자의 제조날짜를 입력해주세요");
							makedate=sc.next();
							int resultInsert = dao.insert( maxPcode, pname,  company,  price,makedate);
							if(resultInsert!=0)System.out.println(resultInsert+" 행이 삽입되었습니다.");
							else System.out.println("삽입 실패");
//						}else System.out.println("중복된 pcode입니다");
//					}else System.out.println("잘못된 pcode입니다 p로 시작해야합니다.");
				}
				break;
			case "3":
				dtosSearching = dao.getSearching("1",searching);
				dao.printDtos(dtosSearching);
				System.out.println("수정할 제품코드를 입력해주세요");
				String update=sc.next();
				if(update.substring(0, 1).equalsIgnoreCase("p")) {
					System.out.println("수정할 항목을 선택하세요 f. 전체 수정 n. 제품명 c. 제조사 p. 가격 m. 제조날짜 0. 되돌아가기");
					String updateSelect =sc.next();
					int resultUpdate = dao.update(update.toUpperCase(),updateSelect.toUpperCase());
					if(resultUpdate>0) System.out.println(resultUpdate +" 행이 수정되었습니다.\r");
					else System.out.println("수정 실패\r");
				} else System.out.println("제품코드를 정확히 입력해주세요\r");
				break;
			case "4":
//				dtosSearching = dao.getSearching("1",searching);
//				dao.printDtos(dtosSearching);
				System.out.println("삭제할 제품코드를 입력해주세요");
				String delete=sc.next();
				dtosSearching = dao.getSearching("4",delete);
				dao.printDtos(dtosSearching);
				if(dtosSearching.size()!=0) {
					System.out.println("삭제 하시겠습니까?  Y/N");
					String yn = sc.next();
					if(yn.equalsIgnoreCase("Y")) {
						int deleteResult=dao.delete(delete);
						if(deleteResult>0)System.out.println(deleteResult+" 행이 삭제되었습니다.");
						else System.out.println("삭제 실패");
					}
				}
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

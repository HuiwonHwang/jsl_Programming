package o_황희원;

import java.util.ArrayList;
import java.util.Scanner;

public class Animal {

	public static void main(String[] args) {
		// 수정 3삭제 4
		Scanner sc = new Scanner(System.in);
		AnimalDao dao = new AnimalDao();
		
		String gubun="";
		String gubunForSelect="";
		do {
			System.out.println("1. 조회 2. 등록 3. 수정 4. 삭제 0. 종료\r");
			gubun=sc.next();
			switch(gubun) {
			case "1":
				ArrayList<AnimalDto> dtos = new ArrayList<>();
				System.out.println("1. 전체 조회 2. 번호 조회 3. 이름 조회 0. 나가기");
				gubunForSelect=sc.next();
				switch(gubunForSelect) {
				case "1":
					dtos=dao.getAnimalList();
					dao.printDtos(dtos);
					break;
				case "2":
					System.out.println("조회할 번호를 입력하세요");
					int searchingByNumber=sc.nextInt();
					AnimalDto dtoForNumberSearching=dao.searchingByNumber(searchingByNumber);
					if(dtoForNumberSearching!=null)dao.printDto(dtoForNumberSearching);
					else System.out.println("존재하지 않습니다.");
					break;
				case "3":
					System.out.println("조회할 이름을 입력하세요");
					String nameForSearching=sc.next();
					AnimalDto dtoForNameSearching=dao.searchingByName(nameForSearching);
					if(dtoForNameSearching!=null) dao.printDto(dtoForNameSearching);
					else System.out.println("존재하지 않습니다.");
					break;
				case "0":
					break;
				default:
					System.out.println("0~3 중 선택해주세요");
					break;
				}
				break;
			case "2":
				System.out.println("등록할 동물의 번호를 입력해주세요");
				String noForInsert=sc.next();
				int checking = dao.checking(noForInsert);
				if(checking==0) {
					System.out.println("등록할 동물의 이름를 입력해주세요");
					String nameForInsert=sc.next();
					System.out.println("등록할 동물의 분류를 입력해주세요  O: 해상동물 L:육상동물");
					String kindForInsert=sc.next();
					if(kindForInsert.equalsIgnoreCase("O")||kindForInsert.equalsIgnoreCase("L")) {
						System.out.println("등록할 동물의 무게를 입력해주세요");
						int weightForInsert=sc.nextInt();
						int result=dao.animalInsert(noForInsert,nameForInsert,kindForInsert,weightForInsert);
						if(result>0) System.out.println(result+" 행이 등록되었습니다.\r");
						else if (result==0)System.out.println("등록 실패");
					}else {
						System.out.println("O와 L 중에 입력해주세요.\r");
					}
				}else System.out.println("이미 존재하는 번호입니다.\r");
				break;
			case "3":
				System.out.println("수정할 동물의 번호를 입력해주세요");
				int noForUpdate=sc.nextInt();
				AnimalDto dtoForNumberSearching=dao.searchingByNumber(noForUpdate);
				if(dtoForNumberSearching!=null){
					dao.printDto(dtoForNumberSearching);
					System.out.println("이 동물이 맞나요?  Y/N");
					String answerForUpdate=sc.next();
					if(answerForUpdate.equalsIgnoreCase("y")||answerForUpdate.equalsIgnoreCase("ㅛ")) {
						System.out.println("변경할 동물의 이름을 입력해주세요");
						String nameForUpdate=sc.next();
						System.out.println("변경할 동물의 분류를 입력해주세요    O: 해상동물 L:육상동물");
						String kindForUpdate=sc.next();
						if(kindForUpdate.equalsIgnoreCase("L")||kindForUpdate.equalsIgnoreCase("O")) {
							System.out.println("변경할 동물의 무게를 입력해주세요");
							int weightForUpdate=sc.nextInt();
							int resultForUpdate = dao.AnimalUpadte(noForUpdate,nameForUpdate,kindForUpdate,weightForUpdate);
							if(resultForUpdate>0) System.out.println(resultForUpdate+" 행이 수정되었습니다.");
							else System.out.println("수정 실패");
						}else System.out.println("Enter L or O");;
					}else System.out.println("Enter Y or N");
				}
				else System.out.println("존재하지 않습니다.");
				break;
			case "4":
				System.out.println("삭제할 동물의 번호를 입력해주세요");
				int noForDelete=sc.nextInt();
				dtoForNumberSearching=dao.searchingByNumber(noForDelete);
				if(dtoForNumberSearching!=null) {
					dao.printDto(dtoForNumberSearching);
					System.out.println("이 동물이 맞나요?  Y/N");
					String answerForDelete=sc.next();
					if(answerForDelete.equalsIgnoreCase("y")||answerForDelete.equalsIgnoreCase("ㅛ")) {
						int resultForDelete=dao.AnimalDelete(noForDelete);
						if(resultForDelete>0)System.out.println(resultForDelete+" 행이 삭제되었습니다.");
						else System.out.println("삭제 실패");
					}else System.out.println("Enter y or n");
				}else System.out.println("존재하지 않습니다.");
				
				break;			
			case "0":
				
				break;
			default:
				System.out.println("0~4 중 선택해주세요");
				break;
			}
		}while(!gubun.equals("0"));
		System.out.println("System Off!!");
	}
}

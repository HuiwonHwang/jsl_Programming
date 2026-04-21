package o_practice2;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		Scanner sc=new Scanner(System.in);
		String syear = "";
		String sclass="";
		String sno="";
		String name=""; 
		int kor=0;
		int eng=0;
		int mat=0;
		

		
		int gubun=0;
		int searching=0;
		do {
			System.out.println("Enter the number  1.search 2.insert 3.update 4.delete 0.close");
			gubun = sc.nextInt();
			switch(gubun) {
			case 1:
				System.out.println("searching by what 1.Full Searching 2.by grade 3.by number 4.by name 0.close searching");
				searching = sc.nextInt();
				switch(searching) {
				case 1:
					ArrayList<StudentDto> dtos = dao.getSearching();
					
					dao.dtosPrint(dtos);
					
					break;
				case 2:
					
					System.out.println("what grade searching for");
					int grade = sc.nextInt();
					ArrayList<StudentDto> dtos1 = dao.getSearchingGrade(grade);
					dao.dtosPrint(dtos1);
					break;
				case 3:
					System.out.println("what grade");
					String searchingGrade = sc.next();
					System.out.println("what class");
					String searchingClass = sc.next();
					System.out.println("what number");
					String searchingNumber = sc.next();
					StudentDto dto2 =dao.getSearchingSpecific(searchingGrade,searchingClass,searchingNumber);
					dao.dtoprint(dto2);
					 break;
				case 4:
					System.out.println("who you looking for\r");
					String searchingName =sc.next();
					ArrayList<StudentDto> dtos3 =dao.getSearchingName(searchingName);
					dao.dtosPrint(dtos3);			
					break;
				case 0:
					break;
				default:
					System.out.println("choose in 0~4\r");	
				}
				break;
				
				
			case 2:
				System.out.println("enter year");
				syear = sc.next();
				System.out.println("enter class");
				sclass=sc.next();
				System.out.println("enter number");
				sno=sc.next();
				
				int checking = dao.checkStudent(syear,sclass,sno);
				if(checking ==0) {
					System.out.println("enter name");
					name=sc.next(); 
					System.out.println("enter kor score");
					kor=sc.nextInt();
					System.out.println("enter eng score");
					eng=sc.nextInt();
					System.out.println("enter mat score");
					mat=sc.nextInt();
					StudentDto dto = new StudentDto(syear, sclass, sno, name, kor, eng, mat);
					
					int result = dao.studentSave(dto);
					if(result>0) {
						System.out.println(result+"행이 삽입되었습니다.");
					}else System.out.println("insert failed");
				}else {
					System.out.println("already exist!");
				}
				
				break;
			case 3:
				System.out.println("what grade");
				String updateGrade = sc.next();
				System.out.println("what class");
				String updateClass = sc.next();
				System.out.println("what number");
				String updateNumber = sc.next();
				StudentDto dto4 =dao.getSearchingSpecific(updateGrade,updateClass,updateNumber);
				dao.dtoprint(dto4);
				
				if(dto4!=null) {
					System.out.println("is he correct? do you want modifying  Y/N");
					String yn = sc.next();
					if(yn.equalsIgnoreCase("y")) {
						System.out.println("enter name");
						name=sc.next(); 
						System.out.println("enter kor score");
						kor=sc.nextInt();
						System.out.println("enter eng score");
						eng=sc.nextInt();
						System.out.println("enter mat score");
						mat=sc.nextInt();
						
						StudentDto updateDto = new StudentDto(updateGrade, updateClass, updateNumber, name, kor, eng, mat);
						int result = dao.studentUpdate(updateDto);
					}else {
						System.out.println("close modifying\r");
					}
				}
				
				break;
			case 4:
				break;
			case 0:
				break;
			default :
				System.out.println("choose in 0 ~ 4");
			}
			
		}while(gubun!=0);
		
		System.out.println("System Off!");
		
		
		
		
		
		
		
	}

}

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
					int searchingGrade = sc.nextInt();
					System.out.println("what class");
					int searchingClass = sc.nextInt();
					System.out.println("what number");
					int searchingNumber = sc.nextInt();
					StudentDto dto2 =dao.getSearchingSpecific(searchingGrade,searchingClass,searchingNumber);
					if(dto2!=null) {
						System.out.println("==========================name searching==========================");
						System.out.println("grade   class   number   name   kor   eng   mat\r");
						System.out.print(dto2.getSyear()+"\t");
						System.out.print(dto2.getSclass()+"\t");
						System.out.print(dto2.getSno()+"\t");
						System.out.print(dto2.getName()+"\t");
						System.out.print(dto2.getKor()+"\t");
						System.out.print(dto2.getEng()+"\t");
						System.out.print(dto2.getMat()+"\r");
						System.out.println("-----------------------------------------------------------\r");
						}else 	System.out.println("doesn't exist\r");
					 break;
				case 4:
					System.out.println("who you looking for\r");
					String searchingName =sc.next();
					StudentDto dto =dao.getSearchingName(searchingName);
					if(dto!=null) {
						System.out.println("==========================name searching==========================");
						System.out.println("grade   class   number   name   kor   eng   mat");
						System.out.print(dto.getSyear()+"\t");
						System.out.print(dto.getSclass()+"\t");
						System.out.print(dto.getSno()+"\t");
						System.out.print(dto.getName()+"\t");
						System.out.print(dto.getKor()+"\t");
						System.out.print(dto.getEng()+"\t");
						System.out.print(dto.getMat()+"\r");
						System.out.println("-----------------------------------------------------------\r");
					}else {
						System.out.println(searchingName+"doesn't exsist\r");
					}					
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
				break;
			case 3:
				break;
			case 4:
				break;
			default :
				System.out.println("choose in 0 ~ 4");
			}
			
			
		}while(gubun!=0);
		
		System.out.println("System Off!");
		
		
		
		
		
		
		
	}

}

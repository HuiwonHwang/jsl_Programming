package d_array;

import java.util.Scanner;

public class Java_05 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String[] name = {"이상민", "박만수", "이찬우", "김성식", "김지우", 
				"김인수", "안상수", "이미옥", "백현수", "이찬우", 
				"허상수", "김이우", "김미순", "허정우", "임민수", 
				"윤석민", "안태정", "최순실", "송민수", "강유현", 
				"강민기", "신강식", "허준용", "김형수", "안강현"};	
				
				
		int gubun ;

		do {
			System.out.println("1. search 0. close");
			gubun=sc.nextInt();
			
			if(gubun==1) {
				System.out.println("name?");
				String searchName = sc.next();
				int count =0;
				for(int i=0;i<name.length;i++) {
					if(name[i].indexOf(searchName)!=-1) {
						System.out.println(name[i]);
						count++;
					}
				}
				System.out.println("total "+count);
				if(count==0) System.out.println("none");
			}
				
		}while(gubun!=0);
		System.out.println("System Closed");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

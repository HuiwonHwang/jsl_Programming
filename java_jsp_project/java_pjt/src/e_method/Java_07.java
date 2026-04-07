package e_method;

import java.util.Scanner;

public class Java_07 {

	public static void main(String[] args) {
		Java_07_sub sub = new Java_07_sub();
		Scanner sc = new Scanner(System.in);

		String[] name = {"이상민", "박만수", "이찬우", "김성식", "김지우", 
				"김인수", "안상수", "이미옥", "백현수", "이찬우", 
				"허상수", "김이우", "김미순", "허정우", "임민수", 
				"윤석민", "안태정", "최순실", "송민수", "강유현", 
				"강민기", "신강식", "허준용", "김형수", "안강현"};
		System.out.println("searching what?");
		String search = sc.next();
		int count = sub.getSearch(name, search);
		System.out.println(count);
		
		String[]  searched = sub.getList(name,search);
		for(int i=0;i<searched.length;i++) {
			System.out.print(searched[i]+"\t");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}

package l_exception;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor;
		System.out.println("system on");
		
		
		System.out.println("kor score");
		try {
			 kor = sc.nextInt();
		}catch(Exception e) {
			kor = 0;
			e.printStackTrace();
		}finally {
			
		}
		System.out.println("kor score is "+kor);
	
		
		
		
		System.out.println("system off");		
		
		
	}

}

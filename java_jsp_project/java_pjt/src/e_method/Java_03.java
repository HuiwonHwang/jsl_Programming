package e_method;

import java.util.Scanner;

public class Java_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Java_03_sub sub = new Java_03_sub();
		System.out.println("kor score?");
		String kor = sc.next();
		System.out.println("eng score?");
		String eng = sc.next();
		System.out.println("mat score?");
		String mat = sc.next();
		
		int total = sub.getTotal(kor,eng,mat);
		System.out.println(total);
		
		double ave = sub.getAve(total,3);
		System.out.println(ave);
		
		String result = sub.getResult(ave);
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

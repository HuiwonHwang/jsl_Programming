package a_basic;

import java.util.Scanner;

public class Java_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("name");
		String name = sc.next();
		System.out.print("total");
		double total = sc.nextDouble();
		System.out.print("count");
		int count = sc.nextInt();
		
		System.out.println(name+"님 평균 "+ total/count+"점 입니다.");
		
		
		
	}

}

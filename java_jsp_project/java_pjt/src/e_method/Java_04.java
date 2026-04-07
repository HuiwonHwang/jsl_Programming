package e_method;

import java.util.Scanner;

public class Java_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Java_04_sub sub = new Java_04_sub();
		
		System.out.println("base money");
		int base = sc.nextInt();
		System.out.println("gender   M/F");
		String gender = sc.next();
		System.out.println("age");
		int age = sc.nextInt();
		
		int money = sub.getMoney(base,gender,age);
		System.out.println(money);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

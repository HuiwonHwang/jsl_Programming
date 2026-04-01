package b_if;

import java.util.Scanner;

public class Java_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int salary = 1000000;
		System.out.println("age");
		int age=sc.nextInt();
		System.out.println("gender");
		String gender = sc.next();
		if(gender.equals("m")) {
			salary+= 10000;
		}
		if(age >= 30) {
			salary+=100000 ;
		} else {
			salary+=50000;
		}
		System.out.println(salary);
		
		
		
		
		
		
		
		
		
	}

}

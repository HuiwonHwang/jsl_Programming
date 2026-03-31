package a_basic;

import java.util.Scanner;

public class Java_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("name?");
		String name = sc.next();
		System.out.print("age");
		int age = sc.nextInt();
		System.out.println(name+age);
		
		System.out.print("학점");
		double score = sc.nextDouble();
		System.out.println(score);
		
		System.out.println(name+"님 나이 " +age+ " 학점은 "+score++);
		
		
		
		
	}

}

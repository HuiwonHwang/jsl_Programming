package b_if;

import java.util.Scanner;

public class Java_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("what's your grade?");
		int grade = sc.nextInt();
		
		/*
		System.out.println("what's your score");
		int score = sc.nextInt();
		
		if(grade<=3) {
			if(score>=60) {
				System.out.println(grade+" grade "+score+" score passed");
			} else {
				System.out.println(grade+" grade "+score+" score failed");
			}
		} else if(grade <= 6) {
			if(score>=80) {
				System.out.println(grade+" grade "+score+" score passed");
			} else {
				System.out.println(grade+" grade "+score+" score failed");
			} 
		}else {
			System.out.println("grade error");
		}
		*/
		
		if(grade>=1&&grade<=6) {
			System.out.println("what's your score");
			int score = sc.nextInt();
			if(grade<=3) {
				if(score>=60) {
					System.out.println(grade+" grade "+score+" score passed");
				} else {
					System.out.println(grade+" grade "+score+" score failed");
				}
			} else {
			
				if(score>=80) {
					System.out.println(grade+" grade "+score+" score passed");
				} else {
					System.out.println(grade+" grade "+score+" score failed");
				}
			}	
		} else {
			System.out.println("grade error!");
		}
		
		
		
		
		
		
		
		
	}

}

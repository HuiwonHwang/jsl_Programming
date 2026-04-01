package b_if;

import java.util.Scanner;

public class Java_04 {

	public static void main(String[] args) {
		//성별 체력지수 정상 비정상 도출
		Scanner sc = new Scanner(System.in);
		System.out.println("what's your gender  M/F");
		String gender = sc.next();
		if(gender.equals("M")||gender.equals("F")) {
			System.out.println("score");
			int score = sc.nextInt();
			if(gender.equals("M")) {
				if(score>=75) {
					System.out.println("normal");
				} else {
					System.out.println("unnomal");
				}
			
			}else {
				if(score>=65) {
					System.out.println("normal");
				} else {
					System.out.println("unnomal");
				}
			}
		
		} else {
			System.out.println("gender error");
		}

	}
}


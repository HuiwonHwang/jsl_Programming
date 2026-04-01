package b_if;

import java.util.Scanner;

public class Java_05 {

	public static void main(String[] args) {
		//출력: 홍길동님 b
		//평균점수 90 a
		//101 -1 예외처리
		Scanner sc= new Scanner(System.in);
		System.out.println("name?");
		String name = sc.next();
		System.out.println("ave");
		int ave = sc.nextInt();
		char gpa = 'a';
		if(ave>=0&&ave<=100) {
			if(ave>=90)				gpa='a';
			else if(ave>=80) gpa='b';
			else if(ave>=70) gpa='c';
			else if(ave>=60) gpa='d';
			else if(ave<60)	 gpa='f';
			
			System.out.println(name+"'s gpa is "+gpa);
		} else System.out.println("score error");
		
		
		
		
		
		
	}

}

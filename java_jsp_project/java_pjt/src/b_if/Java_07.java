package b_if;

import java.util.Scanner;

public class Java_07 {

	public static void main(String[] args) {
		//적금 월 10만 몇년 몇 년 후 금액 이자 학생 만기금의 20 주부 10 회사원 5%
		Scanner sc = new Scanner(System.in);
		System.out.println("what's your job?  1.student 2. housewife 3.salaryman");
		int job = sc.nextInt();
		
		double total = 0;
		if(job<=3&&job>=1) {
			System.out.println("월 납입액?");
			int monthly = sc.nextInt();
			System.out.println("how long?");
			int period = 12*sc.nextInt();
			if(job==1)	total = monthly*period*1.2;
			else if(job==2)	total = monthly*period*1.1;
			else if(job==3)	total = monthly*period*1.05;
			System.out.println(job+"'s total: "+total);
		} else System.out.println("error");
		
		
		
	}

}

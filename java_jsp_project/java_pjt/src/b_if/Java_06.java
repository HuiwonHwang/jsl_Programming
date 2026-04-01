package b_if;

import java.util.Scanner;

public class Java_06 {

	public static void main(String[] args) {
		//기본생활비 오십 학생 십 주부 삼십 회사원 사십
		Scanner sc = new Scanner(System.in);
		int cost = 500000;
		System.out.println("what is your job	student/housewife/salaryman");
		String job = sc.next();
		if(job.equals("student")||job.equals("housewife")||job.equals("salaryman")) {
			if(job.equals("student")) cost+=100000;
			else if(job.equals("housewife")) cost+= 300000;
			else if(job.equals("salaryman")) cost += 400000;
			System.out.println(job+"'s cost: "+cost);
		} else {
			System.out.println("who are you");
		}
		
		
		
		
		
		
		
		
		
	}

}

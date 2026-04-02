package c_반복문;

import java.util.Scanner;

public class Java_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("how many ");
		int count = sc.nextInt();
		int number = 0;
		int total = 0;
		int count2=0;
		for(int i= 0;i<count;i++) {
			System.out.println("enter the number");
			number=sc.nextInt();
			if(number==-1) break;
			total += number;
			count2++;
			
		}
		System.out.println(count2+" count total is "+total);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

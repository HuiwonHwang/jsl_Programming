package c_반복문;

import java.util.Scanner;

public class Java_05_while {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total=0;
		while(true) {
			System.out.println("enter the number");
			int value = sc.nextInt();
			if(value==-1) break;
			total+= value;
		}
		System.out.println(total);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

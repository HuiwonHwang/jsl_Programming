package c_반복문;

import java.util.Scanner;

public class Java_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for(int i = 0;i<5;i++) {
			System.out.println("enter a number");
			if(i==3) break;
			total+=sc.nextInt();
			
		}
		System.out.println(total);
		
		
		
		
	}

}

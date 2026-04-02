package c_반복문;

import java.util.Scanner;

public class Java_06_while {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int oddTotal=0;
		int evenTotal=0;
		int value=0;
		while(true) {
			System.out.println("enter the number");
			value=sc.nextInt();
			if(value==-1) break;
			if(value%2==0) {
				evenTotal+=value;
			} else {
				oddTotal+=value;
			}
			
		}
		System.out.println("odd total is "+oddTotal+", even total is "+evenTotal);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

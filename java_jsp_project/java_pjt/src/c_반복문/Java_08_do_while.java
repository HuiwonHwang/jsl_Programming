package c_반복문;

import java.util.Scanner;

public class Java_08_do_while {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
		int choose = 0;

		do {
			System.out.println("1.+ 2.- 0.close");
			int first=0,secend=0;
			choose = sc.nextInt();
			System.out.println("first number");
			first=sc.nextInt();
			System.out.println("secend number");
			secend=sc.nextInt();
			switch(choose) {
				case 1:
					System.out.println(first+"+"+secend+"="+(first+secend));
					break;
				case 2:
					System.out.println(first+"-"+secend+"="+(first-secend));
					break;
			}
			System.out.println("");
		}while(choose !=0);
		
		System.out.println("closed");
		
		
		
	}

}

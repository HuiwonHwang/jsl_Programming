package c_반복문;

import java.util.Scanner;

public class Java_07_do_while {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gubun=0;
		do {gubun++;
			System.out.println("choose? 1.search 2. insert 3. modify 0.close");
			gubun=sc.nextInt();
			switch(gubun) {
				case 1:
					System.out.println("searching");
					break;
				case 2:
					System.out.println("inserting");
			}
		}while(gubun!=0);
		System.out.println("closed");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

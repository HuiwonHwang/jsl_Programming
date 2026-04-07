package e_method;

import java.util.Scanner;

public class Java_05 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Java_05_sub sub = new Java_05_sub();
		
		int[] score = {55,65,75,86};
		
		
		int total = sub.getTotal(score);
		System.out.println(total);
		
		double ave = sub.getAve(score);
		System.out.println(ave);
		
		String result= sub.getResult(score);
		System.out.println(result);
		
		
		
		
		
		
		
	}

}

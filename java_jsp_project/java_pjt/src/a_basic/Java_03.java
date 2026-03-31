package a_basic;

import java.util.Scanner;

public class Java_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("name?");
		String name = sc.next();
		System.out.println(name);
		System.out.print("kor score");
		int kor = sc.nextInt();
		System.out.print("eng score");
		int eng = sc.nextInt();
		System.out.print("mat score");
		int mat = sc.nextInt();
		int total = kor +eng+mat;
		System.out.println(name+" of score is "+ total);

	}

}

package d_array;

import java.util.Scanner;

public class Java_06 {

	public static void main(String[] args) {
		//q1 몇과목  3  홍길동 90 90 90
		Scanner sc=new Scanner(System.in);
		System.out.println("how many subject");
		int number = sc.nextInt()+1;
		String[] man = new String[number];
		int total=0;
		
		for(int i=0;i<man.length;i++) {
			if(i==0) {
				System.out.println("name");
			} else {
				System.out.println("score");
			}	
			man[i]=sc.next();
			if(i>0)total+= Integer.parseInt(man[i]);
		}
//		for(int i=1;i<man.length;i++) {
//			total+= Integer.parseInt(man[i]);
//		}
		for(int i=0;i<man.length;i++) {
			System.out.print(man[i]+"\t");
		}
		System.out.println("\n"+total);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

package d_array;

import java.util.Scanner;

public class Java_04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("how many people");
		String[] name = new String[sc.nextInt()];
		
		for(int i = 0;i<name.length;i++) {
			System.out.println("name?");
			name[i]=sc.next();
		}
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}
		
		int gubun =0;
		do {
			System.out.println("1.search 0.close");
			gubun=sc.nextInt();
			
			if(gubun==1) {
			System.out.println("검색");
			String search = sc.next();
			for(int i=0;i<name.length;i++) {
				if(name[i].indexOf(search)!=-1) 	System.out.println(name[i]);
				}
			}
		}while(gubun!=0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

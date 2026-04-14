package l_exception;

import k_interface.inter_A;

public class Main {

	public static void main(String[] args) {
		System.out.println("시스템 시작");
		try {
			int total = Integer.parseInt("20");	
			System.out.println("total is "+total);
		}catch(Exception e) {
			System.out.println("오류");
		}
		
		
		
		System.out.println("시스템 종료");
		
		
		
		
		
		
		
		
	}

}

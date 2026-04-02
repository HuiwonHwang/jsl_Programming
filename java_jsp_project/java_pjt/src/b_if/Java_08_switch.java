package b_if;

import java.util.Scanner;

public class Java_08_switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇월입니까?");
		String month = sc.next();
		String result = "";
		switch(month){
			case "1월": case "2월": case "12월": 
				result = "겨울 입니다";
				break;
			case "3월": case "5월": case "4월":
				result = "봄 입니다";
				break;
			case "7월": case "8월": case "6월":
				result = "여름 입니다";
				break;
			case "9월": case "11월": case "10월":
				result = "가을 입니다";
				break;
			default:
				result = "없습니다";
		}
		System.out.println(result);
	}

}

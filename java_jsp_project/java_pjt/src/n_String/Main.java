package n_String;

public class Main {

	public static void main(String[] args) {
		String str = "가나다라마바사";
		int len = str.length();
		System.out.println(len);
		
		boolean tf =str.equals("가나");
		System.out.println(tf);
		
		String a = str.substring(1, 3);
		System.out.println(a);
		
		String b= str.substring(1);
		System.out.println(b);
		
		int c=str.indexOf("다");		
		System.out.println(c);
	}

}

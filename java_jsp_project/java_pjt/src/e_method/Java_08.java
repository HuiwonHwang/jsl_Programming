package e_method;

public class Java_08 {

	public static void main(String[] args) {
		Java_08_sub sub = new Java_08_sub();
		
		
		int total = sub.getTotal(50,60);
		System.out.println(total);
		total = sub.getTotal(50,60,70);
		System.out.println(total);
		total = sub.getTotal(50,60,70,80);
		System.out.println(total);
		
		
		
	}

}

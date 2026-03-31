package b_if;

public class Java_01 {

	public static void main(String[] args) {
		int a = 10, b = 5, c = 2;
		if(a>b) {
			System.out.println("1. true");
		} 
		if (a>=b) {
			System.out.println("2. true");
		} 
		if (a>b&&a<20) {
			System.out.println("3. true");
		}
		if (a>b&&a>20) {
			System.out.println("4. true");
		} else {
			System.out.println("4. false");
		}
		if (a>b||a>20) {
			System.out.println("5. true");
		} else {
			System.out.println("5. false");
		}
		
	}

}

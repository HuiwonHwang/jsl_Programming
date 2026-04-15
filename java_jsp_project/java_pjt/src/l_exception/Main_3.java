package l_exception;

public class Main_3 {

	public static void main(String[] args) {
		
		sub_1 sub = new sub_1();
		int total = sub.getTotal("80", "90");
		System.out.println(total);
		
		
		try {
			int ave = sub.getAve(180, "5");
		} catch (Exception e) {
			System.out.println("exception~~");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}

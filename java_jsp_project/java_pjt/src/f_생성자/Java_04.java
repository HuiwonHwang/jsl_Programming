package f_생성자;

public class Java_04 {

	public static void main(String[] args) {
		Java_04_sub sub = new Java_04_sub();
		sub.setName("홍길동");
		sub.setKor(70);
		sub.setEng(80);
		sub.setMat(90);
		int total = sub.getTotal();
		System.out.println("1.total : "+total);
		
		Java_04_sub sub2 = new Java_04_sub("이순신",10,20,30);
//		sub2.setSum();
		total = sub2.getTotal();
		System.out.println("2.total : "+total);
		
//		sub.setSum();
//		total = sub.getTotal();
//		System.out.println("2.total : "+total);
		
		
		
		
	}

}







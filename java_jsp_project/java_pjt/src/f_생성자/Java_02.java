package f_생성자;

public class Java_02 {

	public static void main(String[] args) {
		Java_02_sub sub = new Java_02_sub("트럼프");
		String name = sub.getName();
		System.out.println("1. name : "+name);
		sub.setName("푸틴~");
		name = sub.getName();
		System.out.println("1-1. name : "+name);
		
		

		Java_02_sub sub2 = new Java_02_sub("홍길동");	
		name = sub2.getName();
		sub2.setName("이순신");
		System.out.println("2. name : "+name);		
		
	}

}







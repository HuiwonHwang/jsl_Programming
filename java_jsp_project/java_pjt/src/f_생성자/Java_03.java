package f_생성자;

public class Java_03 {

	public static void main(String[] args) {
		Java_03_sub sub = new Java_03_sub();
		String name = sub.getName();
		sub.setName("홍길동");
		sub.setName("이순신");
		int age = sub.getAge();
		sub.setAge(25);
		age = sub.getAge();
		System.out.println(age);
		Java_03_sub sub2 = new Java_03_sub();
		Java_03_sub sub3 = new Java_03_sub("이순신",35);
		sub2.getName();
		sub3.getName();
		

		
	}

}







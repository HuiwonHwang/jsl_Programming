package e_method;

public class Java_06 {

	public static void main(String[] args) {
		Java_06_sub sub = new Java_06_sub();
		String name = "홍길동";
		String kor = "60";
		String eng = "70";
		String mat = "80";
		String[] info =sub.getInfo(name,kor,eng,mat);
		for(int i=0;i<info.length;i++) {
			System.out.print(info[i]+"\t");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

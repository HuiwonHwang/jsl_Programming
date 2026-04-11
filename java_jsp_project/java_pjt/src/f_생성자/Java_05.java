package f_생성자;

public class Java_05 {

	public static void main(String[] args) {
		Java_05Dao dao = new Java_05Dao();
		Java_05Dto dto = new Java_05Dto("홍길동",50,60,70);
		
		int total = dao.getTotal(dto);
		
		
		
	}

}







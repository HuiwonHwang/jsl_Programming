package f_생성자;

public class Java_08 {

	public static void main(String[] args) {
		
		Java_08dto dto = new Java_08dto("101","홍길동",85);
		
		Java_08dao dao = new Java_08dao(dto);
		
		
		String result = dao.getResult();
		System.out.println(result);
		
		Java_08dao dao2 = new Java_08dao();
		Java_08dto dto2 = new Java_08dto("201","김길동",75);
		dao2.setDto(dto2);
		String result2=dao2.getResult();
		System.out.println(result2);
		
		Java_08dto dto3 = new Java_08dto("301","박길동",95);
		dao2.setDto(dto3);
		String result3=dao2.getResult();
		System.out.println(result3);
		
		Java_08dto dto4 = dao2.getDto();
		System.out.println(dto4.getId());

	}

}

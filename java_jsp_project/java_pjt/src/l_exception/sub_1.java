package l_exception;

public class sub_1 {
	int getTotal(String kor, String eng) {
		int total=0;
		try {
		total= Integer.parseInt(kor)+Integer.parseInt(eng);
		}catch(Exception e) {
			System.out.println("error");
		}
		return total;
	}
	
	
	
	int getAve(int total, String count)throws Exception {
		
		int ave= total/Integer.parseInt(count);
		return ave;
	}
	
	
	
	
	
	
}

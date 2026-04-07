package e_method;

public class Java_02_sub {
	int getTotal_1(int a, int b, int c) {
		int total = a+b+c;
		return total; 
	}
	
	int getTotal_2(int a,String b, int c) {
		int total = a+ Integer.parseInt(b)+c;
				return total;
	}
	
	
	String getResult(int a) {
		String result = "불합격";
		if(a>=85) result="합격";
		return result;
	}
	
	String getResult_2(int a, int b) {
		String result="불합격";
		if(a>3) {
			if(b>80) result="합격";
		} else {
			if(b>60) result="합격";
		}
		return result;
	}
	
	String getResult_3(double a) {
		String result="";
		
		if (a>90)result="A";
		else if(a>80)result="B";
		else if(a>70)result="C";
		else result="C";
		return result;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

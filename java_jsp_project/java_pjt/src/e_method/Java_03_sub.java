package e_method;

public class Java_03_sub {
	int getTotal(String a, String b, String c) {
		int total= Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c);
		return total;
	}
	
	double getAve(int a, int b) {
		double ave = (double)a/b;
		return ave;
	}
	
	String getResult(double a) {
		String result= "불합격";
		if(a>80)result="합격";
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

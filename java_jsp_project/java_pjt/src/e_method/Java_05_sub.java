package e_method;

public class Java_05_sub {
	int getTotal(int[] a) {
		int total=0;
		for(int i=0;i<a.length;i++) {
			total+=a[i];
		}
		return total;
	}
	
	double getAve(int[] a) {
		int total=getTotal(a);
		double ave = (double)total / a.length;
		return ave;
	}
	
	String getResult(int[] a) {
		String result= "불합격";
		double ave =getAve(a);
		if(ave>80) result="합격";
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package e_method;

public class Java_07_sub {
	int getSearch(String[] a, String b) {
		int count =0;
		for(int i=0;i<a.length;i++)
			if(a[i].indexOf(b) !=-1) count++;
		return count;
	}
	
	String[] getList(String[] a, String b) {
		int count = getSearch(a,b);
		String[] list = new String[count];
		String name ="";
		for(int i=0;i<a.length;i++) {
			if(a[i].indexOf(b) !=-1) {
				name= a[i];
			}
				
	}
		return list;
	}
	
	//목록불러와야댐
	
	
	
	
	
	
	
	
	
	
	
}

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
		int count1=0;
		String[] list = new String[count];
		for(int i=0;i<a.length;i++) {
			if(a[i].indexOf(b) !=-1) {
				list[count1]= a[i];
				count1++;
			}
				
	}
		return list;
	}
	
	//목록불러와야댐
	
	
	
	
	
	
	
	
	
	
	
}

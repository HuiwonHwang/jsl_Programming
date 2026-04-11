package g_arrayList;

import java.util.ArrayList;

public class Java_01 {

	public static void main(String[] args) {
		
		String[] name = new String[3];
		name[0] ="홍길동";
		name[1] ="김길동";
		//name.length;
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("홍길동");
		arr.add("김길동");
		arr.add("박길동");
		arr.add("최길동");
		
		arr.add(1,"표길동");
		arr.remove(2);
		arr.clear();
		
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
//		System.out.println(arr.get(0));
		
		
//		int size = arr.size();
//		System.out.println(" size : "+arr.size());
		
		
	}

}





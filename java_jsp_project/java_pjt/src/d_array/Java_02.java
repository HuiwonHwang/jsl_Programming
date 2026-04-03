package d_array;

public class Java_02 {

	public static void main(String[] args) {
		int[] a = {15,13,78,56,456,65,45,88,65,44,52,
		     			542,755,15,138,745,462,765,45,45,78,55,
		    			6,7,87,84,95,21,45,65,87,49,94,54,324,
		    			456,78,321,45,48,78,45,21,35,48,21,32,
		    			48,46,13,78,45,86};
		int total=0,odd = 0,even=0;
		int count=0;
		for(int i=0;i<a.length;i++){
			if(a[i]%2==0) even+=a[i];
			else  odd+=a[i];
			if(a[i]>=50) count++;
			total += a[i];
		}
		
		System.out.println("total is "+total+", even total is "+even+", odd is "+odd+" 50이상 "+ count);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

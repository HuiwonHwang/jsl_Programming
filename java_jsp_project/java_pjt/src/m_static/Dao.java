package m_static;

public class Dao {
	int getTotal(int i,int j) {
		return i+j;
	}
	
	static boolean getResult(int ave) {
		boolean result = false;
		if(ave>80)result = true;
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}

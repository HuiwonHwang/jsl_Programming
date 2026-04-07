package d_array;

public class Java_07 {

	public static void main(String[] args) {
		String[][] info = new String[2][3];
		String[] info_1= {"홍길동","김길동","황희원"};
		info[0]=info_1;
		String[] info_2= {"박박길","최치수","정불주"};
		info[1]=info_2;
		String[][] str= {{"박박길","최치수","정불주"},{"독고","전사길","황희워"}};
		for(int i=0;i<str.length;i++) {
			for(int k=0;k<str[i].length;k++) {
				System.out.println(str[i][k]);
			}
		}
		
		
	}

}

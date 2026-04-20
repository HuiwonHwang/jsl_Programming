package o_practice2;

public class StudentDto {
	String syear,sclass, sno,name;
	int kor,eng,mat;
	
	public StudentDto(String syear, String sclass, String sno, String name, int kor, int eng, int mat) {
		this.syear = syear;
		this.sclass = sclass;
		this.sno = sno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public StudentDto() {
		// TODO Auto-generated constructor stub
	}
	public String getSyear() {
		return syear;
	}
	public void setSyear(String syear) {
		this.syear = syear;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

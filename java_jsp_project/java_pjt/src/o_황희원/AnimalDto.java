package o_황희원;

public class AnimalDto {
	String no="";
	String name="";
	String kind="";
	int weight=0;
	
	public AnimalDto(String no, String name, String kind, int weight) {
		this.no = no;
		this.name = name;
		this.kind = kind;
		this.weight = weight;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
	
	
}

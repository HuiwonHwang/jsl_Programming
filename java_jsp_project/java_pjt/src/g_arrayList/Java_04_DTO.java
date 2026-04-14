package g_arrayList;

public class Java_04_DTO {
	//아이디성명지역나이
	String id, name,area="";
	int age ;
	public Java_04_DTO () {	}
	public Java_04_DTO (String id, String name, String area, int age) {
		this.id = id;
		this.name = name;
		this.area=area;
		this.age=age;
		}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
}

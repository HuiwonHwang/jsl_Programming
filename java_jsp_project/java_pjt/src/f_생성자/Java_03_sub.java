package f_생성자;

public class Java_03_sub {
	String name;
	int age;
	
	public Java_03_sub(){}
	
	public Java_03_sub(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
	
	void setName(String name) {
		this.name = name;
	}
	void setAge(int age) {
		this.age = age;
	}
	
}






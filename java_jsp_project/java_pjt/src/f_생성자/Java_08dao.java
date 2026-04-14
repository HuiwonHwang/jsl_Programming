package f_생성자;

public class Java_08dao {
	Java_08dto dto;
	
	public Java_08dao() {	}
	
	public Java_08dto getDto() {
		return dto;
	}

	public void setDto(Java_08dto dto) {
		this.dto = dto;
	}

	public Java_08dao(Java_08dto dto) {
		this.dto = dto;
	}

	public String getResult() {
		String result="불합격";
		if(dto.getAve() >=80)result="합격";
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

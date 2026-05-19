package dto;

public class SnackDto {
	private String pcode,pname,company,company_name,makedate;
	private int price;
	public SnackDto(String pcode, String pname, String company, String company_name, String makedate, int price) {
		this.pcode = pcode;
		this.pname = pname;
		this.company = company;
		this.company_name = company_name;
		this.makedate = makedate;
		this.price = price;
	}
	public String getPcode() {
		return pcode;
	}
	public String getPname() {
		return pname;
	}
	public String getCompany() {
		return company;
	}
	public String getCompany_name() {
		return company_name;
	}
	public String getMakedate() {
		return makedate;
	}
	public int getPrice() {
		return price;
	}
	
	
	
	
	
}

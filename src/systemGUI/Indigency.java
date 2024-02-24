package systemGUI;

public class Indigency {
	
	private int certificateIndId;
	private int residentId;
	private String date;
	private String address;
	private String fullName;
	private String civilStat;
	private String sex;
	private int age;
	
	public Indigency(int residentId, String date, String address, String fullName, String civilStat, String sex, int age) {

		this(0, residentId, date, address, fullName, civilStat, sex, age);
	}
		
	public Indigency(int certificateIndId, int residentId, String date, String address, String fullName, 
			String civilStat, String sex, int age)  {
		
		super();
		this.certificateIndId = certificateIndId;
		this.residentId = residentId;
		this.date = date;
		this.address = address;
		this.fullName = fullName;
		this.civilStat = civilStat;
		this.sex = sex;
		this.age = age;
	}

	public int getCertificateIndId() { return certificateIndId;	}
	
	public void setResidentId(int residentId) {this.residentId = residentId;}
	public int getResidentId() {return residentId;}
	
	public void setDate(String date) {this.date = date;}
	public String getDate() {return date;}
	
	public void setAddress(String address) {this.address = address;}
	public String getAddress() { return address;}
	
	public void setFullName(String fullName) {this.fullName = fullName;}
	public String getFullName() {return fullName;}
	
	public void setCivilStat(String civilStat) {this.civilStat = civilStat;}
	public String getCivilStat() {return civilStat;}
	
	public void setSex(String sex) {this.sex = sex;}
	public String getSex() {return sex;}
	
	public void setAge(int age) {this.age = age;}
	public int getAge() {return age;}
}

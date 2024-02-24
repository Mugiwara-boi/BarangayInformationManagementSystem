package systemGUI;

import java.time.LocalDate;
import java.time.Period;

public class Resident {
	
	private int id;
	private String fName;
	private String mName;
	private String lName;
	private String bPlace;
	private String bDate;
	private String civil;
	private String sex;
	private int houseNo;
	private int zoneNo;
	private String street;
	private String voterStat;
	private String precinctNo;
	private String citizenship;
	private String occup;
	private String contact;
	private String email;
	//private String address;
	private String bloodType;
	private String religion;
	
	public Resident(String fName, String mName, String lName, String bDate, String bPlace, String civil, String sex, int houseNo, int zoneNo, String street,
			String voterStat, String precinctNo, String citizenship, String occup, String contact, String email, String bloodType, String religion) {

		this(0, fName, mName,lName, bDate, bPlace, civil, sex, houseNo, zoneNo, street, voterStat, precinctNo, citizenship, occup, contact, email, bloodType, religion);
	}
	
	public Resident(int id, String fName, String mName, String lName)  {
		this.id = id;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
	}
	
	//public Resident(int id, String fName, String mName, String lName, String bDate, String bPlace, String civil, String sex, int houseNo,
	//		String voterStat, String precinctNo, String citizenship, String occup, String contact, String email, String address) 
	
	public Resident(int id, String fName, String mName, String lName, String bDate, String bPlace, String civil, String sex, int houseNo, int zoneNo, String street,
			String voterStat, String precinctNo, String citizenship, String occup, String contact, String email, String bloodType, String religion)  {
		
		super();
		this.id = id;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.bDate = bDate;
		this.bPlace = bPlace;
		this.civil = civil;
		this.sex = sex;
		this.houseNo = houseNo;
		this.zoneNo = zoneNo;
		this.street = street;
		this.voterStat = voterStat;
		this.precinctNo = precinctNo;
		this.citizenship = citizenship;
		this.occup = occup;
		this.contact = contact;
		this.email = email;
		this.bloodType = bloodType;
		this.religion = religion;;
	}

	public int getId() { return id;	}
	
	public void setFirstName(String firstName) {this.fName = firstName;}
	public String getFirstName() {return fName;}
	
	public void setMidName(String mName) {this.mName = mName;}
	public String getMidName() {return mName;}
	
	public void setLastName(String lastName) {this.lName = lastName;}
	public String getLastName() {return lName;}
	
	//public String getFullName() { return lName + ", " + fName + " " + mName.charAt(0) + ".";}
	
	public String getFullName() { return fName +  " " + mName +" " + lName;}
	
	public int getAge() {
		LocalDate dob = LocalDate.parse(bDate);
		LocalDate curDate = LocalDate.now();  
		Period.between(dob, curDate).getYears();  
		
		return Period.between(dob, curDate).getYears(); 
		}
	
	public void setBirthPlace(String bPlace) {this.bPlace = bPlace;}
	public String getBirthPlace() {return bPlace;}
	
	public void setBirthDate(String bDate) {this.bDate = bDate;}
	public String getBirthDate() {return bDate;}
	
	public void setCivilStat(String civil) {this.civil = civil;}
	public String getCivilStat() {return civil;}
	
	public void setSex(String sex) {this.sex = sex;}
	public String getSex() {return sex;}
	
	public void setHouseNo(int houseNo) {this.houseNo = houseNo;}
	public int getHouseNo() {return houseNo;}
	
	public void setZoneNo(int zoneNo) {this.zoneNo = zoneNo;}
	public int getZoneNo() {return zoneNo;}
	
	public void setStreet(String street) {this.street = street;}
	public String getStreet() {return street;}
	
	public void setVoterStat(String voterStat) {this.voterStat = voterStat;}
	public String getVoterStat() {return voterStat;}
	
	public void setPrecinctNo(String precintNo) {this.precinctNo = precintNo;}
	public String getPrecinctNo() {return precinctNo;}
	
	public void setCitizenship(String citizenship) {this.citizenship = citizenship;}
	public String getCitizenship() {return citizenship;}
	
	public void setOccupation(String occup) {this.occup = occup;}
	public String getOccupation() {return occup;}
	
	public void setContact(String contact) {this.contact = contact;}
	public String getContact() {return contact;}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	
	public void setBloodType(String bloodType) {this.bloodType = bloodType;}
	public String getBloodType() {return bloodType;}
	
	public void setReligion(String religion) {this.religion = religion;}
	public String getReligion() {return religion;}
	
	//public void setAddress(String address) {this.address = address;}
	public String getAddress() {return street + ", Zone " + zoneNo + ", Hulo, Mandaluyong City, Metro Manila";}

	}

	
	
    	 
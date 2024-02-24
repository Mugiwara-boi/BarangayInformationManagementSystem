package systemGUI;

public class BusinessClearance {
	
	private int busiClearanceId;
	private String date;
	private String businessName;
	private String busiAddress;
	private String busiOwner;
	private String contactNumber;
	private String busiType;
	
	public BusinessClearance(String date, String businessName, String busiAddress, String busiOwner, String contactNumber, String busiType) {

		this(0, date, businessName, busiAddress, busiOwner, contactNumber, busiType);
	}
		
	public BusinessClearance(int busiClearanceId, String date, String businessName, String busiAddress, String busiOwner, String contactNumber, String busiType) {
		
		super();
		this.busiClearanceId = busiClearanceId;
		this.date = date;
		this.businessName = businessName;
		this.busiAddress = busiAddress;
		this.busiOwner = busiOwner;
		this.contactNumber = contactNumber;
		this.busiType = busiType;
	}

	public int getBusiClearanceId() { return busiClearanceId;}
	
	public void setDate(String date) {this.date = date;}
	public String getDate() {return date;}
	
	public void setBusinessName(String businessName) {this.businessName = businessName;}
	public String getBusinessName() {return businessName;}
	
	public void setBusiAddress(String busiAddress) {this.busiAddress = busiAddress;}
	public String getBusiAddress() { return busiAddress;}
	
	public void setBusiOwner(String busiOwner) {this.busiOwner = busiOwner;}
	public String getBusiOwner() {return busiOwner;}
	
	public void setContactNumber(String contactNumber) {this.contactNumber = contactNumber;}
	public String getContactNumber() {return contactNumber;}
	
	public void setBusiType(String busiType) {this.busiType = busiType;}
	public String getBusiType() {return busiType;}
}

package systemGUI;

public class Blotter {
	
	private int blotterId;
	private String complainant;
	private int compAge;
	private String compContact;
	private String compAddress;
	private String person2Comp;
	private String compDate;
	private String compTime;
	private String incidenceDate;
	private String incidenceTime;
	private int zoneNo;
	private String complaint;
	private String compStatus;
	
	public Blotter(String complainant, int compAge, String compContact, String compAddress, String person2Comp, String compDate, String compTime, 
			String incidenceDate,  String incidenceTime, int zoneNo, String complaint, String compStatus) {

		this(0, complainant, compAge, compContact, compAddress, person2Comp, compDate, compTime, incidenceDate, incidenceTime, zoneNo, complaint, compStatus);
	}
		
	public Blotter(int blotterId, String complainant, int compAge, String compContact, String compAddress, String person2Comp, String compDate, String compTime, 
			String incidenceDate,  String incidenceTime, int zoneNo, String complaint, String compStatus)  {
		
		super();
		this.blotterId = blotterId;
		this.complainant = complainant;
		this.compAge = compAge;
		this.compContact = compContact;
		this.compAddress = compAddress;
		this.person2Comp = person2Comp;
		this.compDate = compDate;
		this.compTime = compTime;
		this.incidenceDate = incidenceDate;
		this.incidenceTime = incidenceTime;
		this.zoneNo = zoneNo;
		this.complaint = complaint;
		this.compStatus = compStatus;
	}

	public int getBlotterId() { return blotterId;	}
	
	public void setComplainant(String complainant) {this.complainant = complainant;}
	public String getComplainant() {return complainant;}
	
	public void setCompAge(int compAge) {this.compAge = compAge;}
	public int getCompAge() {return compAge;}
	
	public void setCompContact(String compContact) {this.compContact = compContact;}
	public String getCompContact() {return compContact;}
	
	public void setCompAddress(String compAddress) {this.compAddress = compAddress;}
	public String getCompAddress() { return compAddress;}
	
	public void setPerson2Comp(String person2Comp) {this.person2Comp = person2Comp;}
	public String getPerson2Comp() {return person2Comp;}
	
	public void setCompDate(String compDate) {this.compDate = compDate;}
	public String getCompDate() {return compDate;}
	
	public void setCompTime(String compTime) {this.compTime = compTime;}
	public String getCompTime() {return compTime;}
	
	public void setIncidenceDate(String incidenceDate) {this.incidenceDate = incidenceDate;}
	public String getIncidenceDate() {return incidenceDate;}
	
	public void setIncidenceTime(String incidenceTime) {this.incidenceTime = incidenceTime;}
	public String getIncidenceTime() {return incidenceTime;}
	
	public void setZoneNo(int zoneNo) {this.zoneNo = zoneNo;}
	public int getZoneNo() {return zoneNo;}
	
	public void setComplaint(String complaint) {this.complaint = complaint;}
	public String getComplaint() {return complaint;}
	
	public void setCompStatus(String compStatus) {this.compStatus = compStatus;}
	public String getCompStatus() {return compStatus;}
	
}

package systemGUI;

public class Residency {
	
	private int certificateResId;
	private int residentId;
	private String fullName;
	private String date;
	private String purpose;
	
	public Residency(int residentId, String fullName, String date, String purpose) {

		this(0, residentId, fullName, date, purpose);
	}
		
	public Residency(int certificateResId, int residentId, String fullName, String date, String purpose)  {
		
		super();
		this.certificateResId = certificateResId;
		this.residentId = residentId;
		this.fullName = fullName;
		this.date = date;
		this.purpose = purpose;
	}

	public int getCertificateResId() { return certificateResId;	}
	
	public void setResidentId(int residentId) {this.residentId = residentId;}
	public int getResidentId() {return residentId;}
	
	public void setFullName(String fullName) {this.fullName = fullName;}
	public String getFullName() {return fullName;}
	
	public void setDate(String date) {this.date = date;}
	public String getDate() {return date;}
	
	public void setPurpose(String purpose) {this.purpose = purpose;}
	public String getPurpose() { return purpose;}
	
}



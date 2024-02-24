package systemGUI;

public class BarangayClearance {
	
	private int clearanceId;
	private int residentId;
	private String fullName;
	private String date;
	private String address;
	
	public BarangayClearance(int residentId, String fullName, String date, String address) {

		this(0, residentId, fullName, date, address);
	}
		
	public BarangayClearance(int clearanceId, int residentId, String fullName, String date, String address)  {
		
		super();
		this.clearanceId = clearanceId;
		this.residentId = residentId;
		this.fullName = fullName;
		this.date = date;
		this.address = address;
	}

	public int getClearanceId() { return clearanceId;	}
	
	public void setResidentId(int residentId) {this.residentId = residentId;}
	public int getResidentId() {return residentId;}
	
	public void setFullName(String fullName) {this.fullName = fullName;}
	public String getFullName() {return fullName;}
	
	public void setDate(String date) {this.date = date;}
	public String getDate() {return date;}
	
	public void setAddress(String address) {this.address = address;}
	public String getAddress() { return address;}
	

}

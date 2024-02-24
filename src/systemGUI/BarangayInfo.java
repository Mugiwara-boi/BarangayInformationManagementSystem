package systemGUI;

public class BarangayInfo {
	
	private int brgyId;
	private byte[] brgyLogo;
	private String brgyName;
	private String city;
	private String state;
	private String contact;
	private String email;
	
	public BarangayInfo(byte[] brgyLogo, String brgyName, String city, String state, String contact, String email) {

		this(0, brgyLogo, brgyName, city, state, contact, email);
	}
	
	public BarangayInfo(int brgyId, byte[] brgyLogo, String brgyName, String city, String state, String contact, String email) {
		super();
		this.brgyId = brgyId;
		this.brgyLogo = brgyLogo;
		this.brgyName = brgyName;
		this.city = city;
		this.state = state;
		this.contact= contact;
		this.email = email;
	}
	
	public int getId() {return brgyId;}
	
	public void setBarangayLogo(byte[] brgyLogo) {this.brgyLogo = brgyLogo;}
	public byte[] getBarangayLogo() {return brgyLogo;}
	
	public void setBarangayName(String brgyName) {this.brgyName = brgyName;}
	public String getBarangayName() {return brgyName;}

	public void setCity(String city) {this.city = city;}
	public String getCity() {return city;}
	
	public void setState(String state) {this.state = state;}
	public String getState() {return state;}
	
	public void setContact(String contact) {this.contact = contact;}
	public String getContact() {return contact;}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	
}

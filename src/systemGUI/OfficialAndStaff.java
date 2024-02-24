package systemGUI;

public class OfficialAndStaff{
	
	private int offId;
	private int residentId;
	private String fullName;
	private String position;
	private String chairmanship;
	private String termStart;
	private String termEnd;
	private String status;
	
	public OfficialAndStaff(int residentId, String fullName, String position, String chairmanship, String termStart, String termEnd, String status) {
		
		this(0, residentId, fullName, position, chairmanship, termStart, termEnd, status);
	}
	
	public OfficialAndStaff(int offId, int residentId, String fullName, String position, String chairmanship, String termStart, String termEnd, String status) {
		
		super();
		this.offId = offId;
		this.residentId = residentId;
		this.fullName = fullName;
		this.position = position;
		this.chairmanship = chairmanship;
		this.termStart = termStart;
		this.termEnd = termEnd;
		this.status = status;
	}
	
	public int getOffId() { return offId;}
	
	public void setResidentId(int residentId) { this.residentId = residentId;}
	public int getResidentId() { return residentId;}
	
	public void setFullName(String fullName) {this.fullName = fullName;}
	public String getFullName() {return fullName;}
	
	public void setPosition(String position) {this.position = position;}
	public String getPosition() {return position;}
	
	public void setChairmanship(String chairmanship) {this.chairmanship = chairmanship;}
	public String getChairmanship() {return chairmanship;}
	
	public void setTermStart(String termStart) {this.termStart = termStart;}
	public String getTermStart() {return termStart;}
	
	public void setTermEnd(String termEnd) {this.termEnd = termEnd;}
	public String getTermEnd() {return termEnd;}
	
	public void setStatus(String status) {this.status = status;}
	public String getStatus() {return status;}
}

package systemGUI;

public class Household {
	
	private int householdNo;
	private String houseOwnership;
	private String houseOwner;
	private String structureType;
	private int zoneNo;
	private String streetName;
	private String householdHead;
	private int noFamilyMembers;
	
	public Household(String houseOwnership, String houseOwner, String structureType, int zoneNo, String streetName, String householdHead, int noFamilyMembers) {
		
		this(0, houseOwnership, houseOwner, structureType, zoneNo, streetName, householdHead, noFamilyMembers);
	}
	
	public Household(int houseHoldNo, String houseOwnership, String houseOwner, String structureType, int zoneNo, String streetName, String householdHead, int noFamilyMembers) {
		super();
		this.householdNo = houseHoldNo;
		this.houseOwnership = houseOwnership;
		this.houseOwner = houseOwner;
		this.structureType = structureType;
		this.zoneNo = zoneNo;
		this.streetName = streetName;
		this.householdHead = householdHead;
		this.noFamilyMembers = noFamilyMembers;
	}
	
	public void setHouseholdNo(int householdNo) {this.householdNo = householdNo;}
	public int getHouseholdNo() {return householdNo;}
	
	public void setHouseOwnership(String houseOwnership) {this.houseOwnership = houseOwnership;}
	public String getHouseOwnership() {return houseOwnership;}
	
	public void setHouseOwner(String houseOwner) {this.houseOwner = houseOwner;}
	public String getHouseOwner() {return houseOwner;}
	
	public void setStructureType(String structureType) {this.structureType = structureType;}
	public String getStructureType() {return structureType;}
	
	public void setZoneNo(int zoneNo) {this.zoneNo = zoneNo;}
	public int getZoneNo() {return zoneNo;}
	
	public void setStreetName(String streetName) {this.streetName = streetName;}
	public String getStreetName() {return streetName;}
	
	public void setHouseholdHead(String householdHead) {this.householdHead = householdHead;}
	public String getHouseholdHead() {return householdHead;}
	
	public void setNoFamilyMembers(int noFamilyMembers) {this.noFamilyMembers = noFamilyMembers;}
	public int getNoFamilyMembers() {return noFamilyMembers;}
}

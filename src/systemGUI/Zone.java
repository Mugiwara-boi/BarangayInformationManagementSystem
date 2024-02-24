package systemGUI;

public class Zone {
	
	private int zoneNo;
	private String streetName;
	
	public Zone(int zoneNo, String streetName) {
		this.zoneNo = zoneNo;
		this.streetName = streetName;
	}
	
	public int getZoneNo() {return zoneNo;}
	
	public String getStreetName() {return streetName;}
}

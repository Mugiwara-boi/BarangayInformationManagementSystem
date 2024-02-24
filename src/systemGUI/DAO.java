package systemGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DAO {

	private Connection conn;
	
	public DAO() throws Exception {
		
		String user = "root";
		String password = "";
		String dburl = "jdbc:mysql://localhost/bimss";
		
		conn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public void updateInfo(BarangayInfo info) throws SQLException {
		PreparedStatement state = null;

		try {
			state = conn.prepareStatement("update tb_brgyinfo"
					+ " set brgyLogo=?, brgyName=?, city=?,  state=?, contact=?, email=? "
					+ " where brgyId=1000000001");
			
			state.setBytes(1, info.getBarangayLogo());
			state.setString(2, info.getBarangayName());
			state.setString(3, info.getCity());
			state.setString(4, info.getState());
			state.setString(5, info.getContact());
			state.setString(6, info.getEmail());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public BarangayInfo getInfo() throws Exception {
		BarangayInfo tempInfo = null;
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_brgyinfo where brgyId=1000000001");	// change this
			
			while (result.next()) {
				tempInfo = convertRowToInfo(result);
			}
			return tempInfo;	
			
		}
		finally {
			close(state, result);
		}
	}
	public List<BarangayInfo> getAllInfo() throws Exception {
		List<BarangayInfo> list = new ArrayList<BarangayInfo>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_brgyinfo");	// change this
			
			while (result.next()) {
				BarangayInfo tempInfo = convertRowToInfo(result);
				list.add(tempInfo);
			}
			return list;	
			
		}
		finally {
			close(state, result);
		}
	}
	public static BarangayInfo convertRowToInfo(ResultSet result) throws SQLException {
		
		int brgyId = result.getInt("brgyId");
		byte[] brgyLogo = result.getBytes("brgyLogo");
		String brgyName = result.getString("brgyName");
		String city = result.getString("city");
		String state = result.getString("state");
		String contact = result.getString("contact");
		String email = result.getString("email");

		
		BarangayInfo tempInfo = new BarangayInfo(brgyId, brgyLogo, brgyName, city, state, contact, email);
		
		return tempInfo;
	}
	
	
	public void addHousehold(Household household) throws Exception {
		PreparedStatement state = null;
			
		try {
			state = conn.prepareStatement("insert into tb_household"    //
					+ " (householdNo, houseOwnership, houseOwner, structureType, zoneNo, streetName, householdHead, noFamilyMembers)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
					
			// set params
			state.setInt(1, household.getHouseholdNo());
			state.setString(2, household.getHouseOwnership());
			state.setString(3, household.getHouseOwner());
			state.setString(4, household.getStructureType());
			state.setInt(5, household.getZoneNo());
			state.setString(6, household.getStreetName());
			state.setString(7, household.getHouseholdHead());
			state.setInt(8, household.getNoFamilyMembers());
		
			
			// execute SQL
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
		
	}
	
	public void updateHousehold(Household household) throws SQLException {
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement("update tb_household"
					+ " set houseOwnership=?,  houseOwner=?, structureType=?, zoneNo=?,  streetName=?, householdHead=?, noFamilyMembers=?"
					+ " where householdNo=?");
			
			state.setString(1, household.getHouseOwnership());
			state.setString(2, household.getHouseOwner());
			state.setString(3, household.getStructureType());
			state.setInt(4, household.getZoneNo());
			state.setString(5, household.getStreetName());
			state.setString(6, household.getHouseholdHead());
			state.setInt(7, household.getNoFamilyMembers());
			state.setInt(8, household.getHouseholdNo());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public void deleteHousehold(int id) throws SQLException {
		PreparedStatement state = null;

		try {
			state = conn.prepareStatement("delete from tb_household where householdNo=?");
			
			state.setInt(1, id);
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public List<Household> getAllHouseholds() throws Exception {
		List<Household> list = new ArrayList<Household>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_household");	// change this
			
			while (result.next()) {
				Household tempHousehold = convertRowToHousehold(result);
				list.add(tempHousehold);
			}
			return list;	
			
		}
		finally {
			close(state, result);
		}
	}
	
    
	private static Household convertRowToHousehold(ResultSet result) throws SQLException {
			
		int householdNo = result.getInt("householdNo");
		String houseOwnership = result.getString("houseOwnership");
		String houseOwner = result.getString("houseOwner");
		String structureType = result.getString("structureType");
		int zoneNo = result.getInt("zoneNo");
		String streetName = result.getString("streetName");
		String householdHead = result.getString("householdHead");
		int noFamilyMembers = result.getInt("noFamilyMembers");

		
		Household tempHousehold = new Household(householdNo, houseOwnership, houseOwner, structureType, zoneNo, streetName, householdHead, noFamilyMembers);
		
		return tempHousehold;
	}
	
	private static Zone convertRowToZone(ResultSet result) throws SQLException {
		
		int zoneNo = result.getInt("zoneNo");
		String streetName = result.getString("streetName");
		

		
		Zone tempZone = new Zone(zoneNo, streetName);
		
		return tempZone;
	}
	public void fillComboZone(JComboBox zoneCombo) throws Exception {
		List<Zone> list = new ArrayList<Zone>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_zone");	// change this
			
			while (result.next()) {
				//Zone tempZone = convertRowToZone(result);
				//zoneCombo.addItem(tempZone.getZoneNo());
				zoneCombo.addItem(result.getInt("zoneNo"));
			}
		}
		finally {
			close(state, result);
		}
	}
	
	public void fillComboStreet(JComboBox zoneCombo, JComboBox streetCombo) throws Exception {
		String choice = zoneCombo.getSelectedItem().toString();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_zone_street where zoneNo = '" + choice + "'");	// change this
			
			while (result.next()) {
				Zone tempZone = convertRowToZone(result);
				streetCombo.addItem(tempZone.getStreetName());
				//streetCombo.addItem(result.getString("streetName"));
			}
		}
		finally {
			close(state, result);
		}
	}
	
	public void fillHouseHeadCombo(JTextField houseIdField, JComboBox hhHeadCombo) throws Exception {
		String choice = houseIdField.getText();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_resident where householdNo = '" + choice + "'");	// change this
			
			while (result.next()) {
				Resident tempResident = convertRowToResident(result);
				hhHeadCombo.addItem(tempResident.getFullName());
			}
		}
		finally {
			close(state, result);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addResident(Resident resident) throws Exception {
		PreparedStatement state = null;
		
		try {
			state = conn.prepareStatement("insert into tb_resident"    //
					+ " (fName, mName, lName, bDate, bPlace, civilStat, sex, "
					+ "householdNo, zoneNo, streetName, voterStat, precinctNo, citizenship, occupation, contact, email, bloodType, religion)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
			// set params
			state.setString(1, resident.getFirstName());
			state.setString(2, resident.getMidName());
			state.setString(3, resident.getLastName());
			state.setString(4, resident.getBirthDate());
			state.setString(5, resident.getBirthPlace());
			state.setString(6, resident.getCivilStat());
			state.setString(7, resident.getSex());
			state.setInt(8, resident.getHouseNo());
			state.setInt(9, resident.getZoneNo());
			state.setString(10, resident.getStreet());
			state.setString(11, resident.getVoterStat());
			state.setString(12, resident.getPrecinctNo());
			state.setString(13, resident.getCitizenship());
			state.setString(14, resident.getOccupation());
			state.setString(15, resident.getContact());
			state.setString(16, resident.getEmail());
			state.setString(17, resident.getBloodType());
			state.setString(18, resident.getReligion());
			// execute SQL
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
		
	}
	
	public void updateResident(Resident resident) throws SQLException {
		PreparedStatement state = null;

		try {
			state = conn.prepareStatement("update tb_resident"
					+ " set fName=?,  mName=?, lName=?, bDate=?,  bPlace=?, civilStat=?, sex=?, "
					+ "householdNo=?,  zoneNo=?, streetName=?, voterStat=?, precinctNo=?,  citizenship=?, occupation=?, contact=?,  email=?, bloodType=?, religion=?"
					+ " where residentId=?");
			
			state.setString(1, resident.getFirstName());
			state.setString(2, resident.getMidName());
			state.setString(3, resident.getLastName());
			state.setString(4, resident.getBirthDate());
			state.setString(5, resident.getBirthPlace());
			state.setString(6, resident.getCivilStat());
			state.setString(7, resident.getSex());
			state.setInt(8, resident.getHouseNo());
			state.setInt(9, resident.getZoneNo());
			state.setString(10, resident.getStreet());
			state.setString(11, resident.getVoterStat());
			state.setString(12, resident.getPrecinctNo());
			state.setString(13, resident.getCitizenship());
			state.setString(14, resident.getOccupation());
			state.setString(15, resident.getContact());
			state.setString(16, resident.getEmail());
			state.setString(17, resident.getBloodType());
			state.setString(18, resident.getReligion());
			state.setInt(19, resident.getId());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public void deleteResident(int id) throws SQLException {
		PreparedStatement state = null;

		try {
			state = conn.prepareStatement("delete from tb_resident where residentId=?");
			
			state.setInt(1, id);
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public List<Resident> getAllResidents() throws Exception {
		List<Resident> list = new ArrayList<Resident>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_resident");	// change this
			
			while (result.next()) {
				Resident tempResident = convertRowToResident(result);
				list.add(tempResident);
			}
			return list;	
			
		}
		finally {
			close(state, result);
		}
	}
	
	private static Resident convertRowToResident(ResultSet result) throws SQLException {
		
		int id = result.getInt("residentId");
		String fName = result.getString("fName");
		String mName = result.getString("mName");
		String lName = result.getString("lName");
		String bDate = result.getString("bDate");
		String bPlace = result.getString("bPlace");
		String civil = result.getString("civilStat");
		String sex = result.getString("sex");
		int houseNo = result.getInt("householdNo");
		int zoneNo = result.getInt("zoneNo");
		String street = result.getString("streetName");	
		String voterStat = result.getString("voterStat");	
		String precinctNo = result.getString("precinctNo");
		String citizenship = result.getString("citizenship");
		String occup = result.getString("occupation");
		String contact = result.getString("contact");	
		String email = result.getString("email");
		String bloodType = result.getString("bloodType");
		String religion = result.getString("religion");
		
		Resident tempResident = new Resident(id, fName, mName, lName, bDate, bPlace, civil, sex, houseNo, zoneNo, street, voterStat, precinctNo, citizenship, occup, contact, email, bloodType, religion);
		
		return tempResident;
	}
	
	public List<Resident> getAllMembers(int householdNo) throws Exception {
		List<Resident> list = new ArrayList<Resident>();
		
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select residentId, fname, mName, lname from tb_resident where householdNo = " + householdNo);	// change this
			
			while (result.next()) {
				Resident tempResident = convertRowToMember(result);
				list.add(tempResident);
			}
			return list;	
			
		}
		finally {
			close(state, result);
		}
	}
	
	private static Resident convertRowToMember(ResultSet result) throws SQLException {
		
		int id = result.getInt("residentId");
		String fName = result.getString("fName");
		String mName = result.getString("mName");
		String lName = result.getString("lName");
		
		Resident tempResident = new Resident(id, fName, mName, lName);
		
		return tempResident;
	}
    
	private static Position convertRowToPosition(ResultSet result) throws SQLException {
		String position = result.getString("position");
		String chairmanship = result.getString("chairmanship");
		
		Position tempPosition = new Position(position, chairmanship);
		
		return tempPosition;
	}
	
	@SuppressWarnings("unchecked")
	public void fillHousehold(JComboBox hhCombo) throws SQLException {
		//List<Position> list = new ArrayList<Position>();
	
		Statement state = null;
		ResultSet result = null;
	
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_household");	// change this
		
			while (result.next()) {
				Household tempHousehold = convertRowToHousehold(result);
				hhCombo.addItem(tempHousehold.getHouseholdNo());
			}
		}
		finally {
			close(state, result);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void fillComboPosition(JComboBox posCombo) throws SQLException {
		//List<Position> list = new ArrayList<Position>();
	
		Statement state = null;
		ResultSet result = null;
	
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_position");	// change this
		
			while (result.next()) {
				Position tempPosition = convertRowToPosition(result);
				posCombo.addItem(tempPosition.getPosition());
			}
		}
		finally {
			close(state, result);
		}
	}
	
	public void fillTextChairmanship(JComboBox posCombo, JTextField chmanshipField) throws SQLException{
		String choice = posCombo.getSelectedItem().toString();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_position where position = '" + choice + "'");	// change this
			
			while (result.next()) {
				Position tempPosition = convertRowToPosition(result);
				chmanshipField.setText(tempPosition.getChairmanship());
			}
		}
		finally {
			close(state, result);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void fillComboResident(JComboBox resCombo) throws Exception {
		List<Resident> list = new ArrayList<Resident>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_resident");	// change this
			
			while (result.next()) {
				Resident tempResident = convertRowToResident(result);
				resCombo.addItem(tempResident.getId());
				
			}
		}
		finally {
			close(state, result);
		}
	}
	
	
	public void fillTextResident(JComboBox resCombo, JTextField fnField) throws SQLException{
		String choice = resCombo.getSelectedItem().toString();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_resident where residentId = '" + choice + "'");	// change this
			
			while (result.next()) {
				Resident tempResident = convertRowToResident(result);
				fnField.setText(tempResident.getFullName());
				
			}
		}
		finally {
			close(state, result);
		}
	}
	

	public void fillHouseholInfo(JComboBox hhCombo, JTextField zoneField, JTextField streetField) throws SQLException{
		
		String choice = hhCombo.getSelectedItem().toString();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_household where householdNo = '" + choice + "'");
			
			while (result.next()) {
				Household tempHousehold = convertRowToHousehold(result);
				zoneField.setText(String.valueOf(tempHousehold.getZoneNo()));
				streetField.setText(tempHousehold.getStreetName());
				
			}
		}
		finally {
			close(state, result);
		}
	}
	
	public void fillAllResident(JComboBox resCombo, JTextField fnField, JTextField addressField) throws SQLException{
		
		String choice = resCombo.getSelectedItem().toString();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_resident where residentId = '" + choice + "'");
			
			while (result.next()) {
				Resident tempResident = convertRowToResident(result);
				fnField.setText(tempResident.getFullName());
				addressField.setText(tempResident.getAddress());
				
			}
		}
		finally {
			close(state, result);
		}
	}
	
	public void fillAllResident(JComboBox resCombo, JTextField addressField, JTextField fnField, 
			JTextField civilField, JTextField sexField, JTextField ageField) throws SQLException{
		
		String choice = resCombo.getSelectedItem().toString();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_resident where residentId = '" + choice + "'");	// change this
			
			while (result.next()) {
				Resident tempResident = convertRowToResident(result);
				addressField.setText(tempResident.getAddress());
				fnField.setText(tempResident.getFullName());
				civilField.setText(tempResident.getCivilStat());
				sexField.setText(tempResident.getSex());
				ageField.setText(String.valueOf(tempResident.getAge()));
				
			}
		}
		finally {
			close(state, result);
		}
	}
	
	public void addOffStaff(OfficialAndStaff official) throws Exception {
		PreparedStatement state = null;

		try {
			state = conn.prepareStatement("insert into tb_officials"    
					+ " (residentId, fullName, position, chairmanship, termStart, termEnd, status)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			state.setInt(1, official.getResidentId());
			state.setString(2, official.getFullName());
			state.setString(3, official.getPosition());
			state.setString(4, official.getChairmanship());
			state.setString(5, official.getTermStart());
			state.setString(6, official.getTermEnd());
			state.setString(7, official.getStatus());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}	
	}
	
	public void updateOffStaff(OfficialAndStaff official) throws SQLException {
		PreparedStatement state = null;

		try {
			state = conn.prepareStatement("update tb_officials"
					+ " set residentId=?, fullName=?,  position=?, chairmanship=?, termStart=?, termEnd=?,  status=?"
					+ " where offId=?");
			
			state.setInt(1, official.getResidentId());
			state.setString(2, official.getFullName());
			state.setString(3, official.getPosition());
			state.setString(4, official.getChairmanship());
			state.setString(5, official.getTermStart());
			state.setString(6, official.getTermEnd());
			state.setString(7, official.getStatus());
			state.setInt(8, official.getOffId());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public void deleteOffStaff(int id) throws SQLException {
		PreparedStatement state = null;

		try {
			state = conn.prepareStatement("delete from tb_officials where offId=?");
			
			state.setInt(1, id);
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public List<OfficialAndStaff> getAllOffStaff() throws Exception {
		List<OfficialAndStaff> list = new ArrayList<OfficialAndStaff>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_officials");	// change this
			
			while (result.next()) {
				OfficialAndStaff tempOfficial = convertRowToOffStaff(result);
				list.add(tempOfficial);
			}

			return list;		
		}
		finally {
			close(state, result);
		}
	}
	
	private static OfficialAndStaff convertRowToOffStaff(ResultSet result) throws SQLException {
		
		int offId = result.getInt("offId");
		int residentId = result.getInt("residentId"); 
		String fullName = result.getString("fullName");
		String position = result.getString("position");
		String chairmanship = result.getString("chairmanship");
		String termStart = result.getString("termStart");
		String termEnd = result.getString("termEnd");
		String status = result.getString("status"); 
		
		OfficialAndStaff tempOfficial = new OfficialAndStaff(offId, residentId, fullName, position, chairmanship, termStart, termEnd, status);
		
		return tempOfficial;
	}
	
	
	
	
	
	
	public void addBlotter(Blotter blotter) throws Exception {
		PreparedStatement state = null;
			
		try {
			state = conn.prepareStatement("insert into tb_blotter"    
					+ " (complainant, complainantAge, complainantContact, complainantAddress, personToComplain, dateOfComplaint, "
					+ "timeOfComplaint, dateOfIncidence, timeOfIncidence, zoneNo, complaint, complainStatus)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			state.setString(1, blotter.getComplainant());
			state.setInt(2, blotter.getCompAge());
			state.setString(3, blotter.getCompContact());
			state.setString(4, blotter.getCompAddress());
			state.setString(5, blotter.getPerson2Comp());
			state.setString(6, blotter.getCompDate());
			state.setString(7, blotter.getCompTime());
			state.setString(8, blotter.getIncidenceDate());
			state.setString(9, blotter.getIncidenceTime());
			state.setInt(10, blotter.getZoneNo());
			state.setString(11, blotter.getComplaint());
			state.setString(12, blotter.getCompStatus());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}	
	}
	
	public void updateBlotter(Blotter blotter) throws SQLException {
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement("update tb_blotter"
					+ " set complainant=?, complainantAge=?,  complainantContact=?, complainantAddress=?, personToComplain=?, dateOfComplaint=?,  timeOfComplaint=?, dateOfIncidence=?, "
					+ "timeOfIncidence=?, zoneNo=?, complaint=?, complainStatus=? where blotterId=?");
			
			state.setString(1, blotter.getComplainant());
			state.setInt(2, blotter.getCompAge());
			state.setString(3, blotter.getCompContact());
			state.setString(4, blotter.getCompAddress());
			state.setString(5, blotter.getPerson2Comp());
			state.setString(6, blotter.getCompDate());
			state.setString(7, blotter.getCompTime());
			state.setString(8, blotter.getIncidenceDate());
			state.setString(9, blotter.getIncidenceTime());
			state.setInt(10, blotter.getZoneNo());
			state.setString(11, blotter.getComplaint());
			state.setString(12, blotter.getCompStatus());
			state.setInt(13, blotter.getBlotterId());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}
	}
	
	public List<Blotter> getAllBlotter() throws Exception {
		List<Blotter> list = new ArrayList<Blotter>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_blotter");	// change this
			
			while (result.next()) {
				Blotter tempBlotter = convertRowToBlotter(result);
				list.add(tempBlotter);
			}

			return list;		
		}
		finally {
			close(state, result);
		}
	}
	
	private static Blotter convertRowToBlotter(ResultSet result) throws SQLException {
		
		int blotterId = result.getInt("blotterId");
		String complainant = result.getString("complainant");
		int compAge = result.getInt("complainantAge");
		String compContact = result.getString("complainantContact");
		String compAddress = result.getString("complainantAddress");
		String person2Comp = result.getString("personToComplain");
		String compDate = result.getString("dateOfComplaint");
		String compTime = result.getString("timeOfComplaint");
		String incidenceDate = result.getString("dateOfIncidence");
		String incidenceTime = result.getString("timeOfIncidence");
		int zoneNo = result.getInt("zoneNo");
		String complaint = result.getString("complaint");
		String compStatus = result.getString("complainStatus");
		
		Blotter tempBlotter = new Blotter(blotterId, complainant, compAge, compContact, compAddress, person2Comp, compDate, compTime, incidenceDate, incidenceTime, zoneNo, complaint, compStatus);
		
		return tempBlotter;
	}
	
	
	
	public void addIndigency(Indigency indigency) throws Exception {
		PreparedStatement state = null;
			
		try {
			state = conn.prepareStatement("insert into tb_indigency"    
					+ " (residentId, date, address, fullName, civilStat, sex, age)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			state.setInt(1, indigency.getResidentId());
			state.setString(2, indigency.getDate());
			state.setString(3, indigency.getAddress());
			state.setString(4, indigency.getFullName());
			state.setString(5, indigency.getCivilStat());
			state.setString(6, indigency.getSex());
			state.setInt(7, indigency.getAge());
			
			state.executeUpdate();			
		}
		finally {
			close(state);
		}	
	}
	public List<Indigency> getAllIndigency() throws Exception {
		List<Indigency> list = new ArrayList<Indigency>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_indigency");	// change this
			
			while (result.next()) {
				Indigency tempIndigency = convertRowToIndigency(result);
				list.add(tempIndigency);
			}

			return list;		
		}
		finally {
			close(state, result);
		}
	}
	
	private static Indigency convertRowToIndigency(ResultSet result) throws SQLException {
		
		int certificateIndId = result.getInt("certificateIndId");
		int residentId = result.getInt("residentId");
		String date = result.getString("date");
		String address = result.getString("address");
		String fullName = result.getString("fullName");
		String civilStat = result.getString("civilStat");
		String sex = result.getString("sex");
		int age = result.getInt("age");

		
		Indigency tempIndigency = new Indigency(certificateIndId, residentId, date, address, fullName, civilStat, sex, age);
		
		return tempIndigency;
	}
	
	
	
	
	
	
	public void addResidency(Residency residency) throws Exception {
		PreparedStatement state = null;
	
		try {
			state = conn.prepareStatement("insert into tb_certofresidency"    
					+ " (residentId, fullName, date, purpose)"
					+ " values (?, ?, ?, ?)");
			
			state.setInt(1, residency.getResidentId());
			state.setString(2, residency.getFullName());
			state.setString(3, residency.getDate());
			state.setString(4, residency.getPurpose());
					
			state.executeUpdate();			
		}
		finally {
			close(state);
		}	
	}
	
	public List<Residency> getAllResidency() throws Exception {
		List<Residency> list = new ArrayList<Residency>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_certofresidency");	// change this
			
			while (result.next()) {
				Residency tempResidency = convertRowToResidency(result);
				list.add(tempResidency);
			}

			return list;		
		}
		finally {
			close(state, result);
		}
	}
	
	private static Residency convertRowToResidency(ResultSet result) throws SQLException {
		
		int certificateResId = result.getInt("certificateResId");
		int residentId = result.getInt("residentId");
		String fullName = result.getString("fullName");
		String date = result.getString("date");
		String purpose = result.getString("purpose");
		
		Residency tempResidency = new Residency(certificateResId, residentId, fullName, date, purpose);
		
		return tempResidency;
	}
	
	
	public void addBusinessClearance(BusinessClearance businessClearance) throws Exception {
		PreparedStatement state = null;
			
		try {
			state = conn.prepareStatement("insert into tb_brgybusiclearance"    
					+ " (date, businessName, busiAddress, busiOwner, contactNumber, busiType)"
					+ " values (?, ?, ?, ?, ?, ?)");
			
			state.setString(1, businessClearance.getDate());
			state.setString(2, businessClearance.getBusinessName());
			state.setString(3, businessClearance.getBusiAddress());
			state.setString(4, businessClearance.getBusiOwner());
			state.setString(5, businessClearance.getContactNumber());
			state.setString(6, businessClearance.getBusiType());
					
			state.executeUpdate();			
		}
		finally {
			close(state);
		}	
	}
	
	public List<BusinessClearance> getAllBusinessClearance() throws Exception {
		List<BusinessClearance> list = new ArrayList<BusinessClearance>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_brgybusiclearance");
			
			while (result.next()) {
				BusinessClearance tempBusinessClearance = convertRowToBusinessClearance(result);
				list.add(tempBusinessClearance);
			}

			return list;		
		}
		finally {
			close(state, result);
		}
	}
	
	private static BusinessClearance convertRowToBusinessClearance(ResultSet result) throws SQLException {
		
		int busiClearanceId = result.getInt("busiClearanceId");
		String date = result.getString("date");
		String businessName = result.getString("businessName");
		String busiAddress = result.getString("busiAddress");
		String busiOwner = result.getString("busiOwner");
		String contactNumber = result.getString("contactNumber");
		String busiType = result.getString("busiType");
		
		BusinessClearance tempBusinessClearance = new BusinessClearance(busiClearanceId, date, businessName, busiAddress, busiOwner, contactNumber, busiType);
		
		return tempBusinessClearance;
	}
	
	
	
	
	
	public void addBarangayClearance(BarangayClearance barangayClearance) throws Exception {
		PreparedStatement state = null;
			
		try {
			state = conn.prepareStatement("insert into tb_brgyclearance"    
					+ " (residentId, fullName, date, address)"
					+ " values (?, ?, ?, ?)");
			
			state.setInt(1, barangayClearance.getResidentId());
			state.setString(2, barangayClearance.getFullName());
			state.setString(3, barangayClearance.getDate());
			state.setString(4, barangayClearance.getAddress());

					
			state.executeUpdate();			
		}
		finally {
			close(state);
		}	
	}
	
	public List<BarangayClearance> getAllBarangayClearance() throws Exception {
		List<BarangayClearance> list = new ArrayList<BarangayClearance>();
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_brgyclearance");
			
			while (result.next()) {
				BarangayClearance tempBarangayClearance = convertRowToBarangayClearance(result);
				list.add(tempBarangayClearance);
			}

			return list;		
		}
		finally {
			close(state, result);
		}
	}
	
	private static BarangayClearance convertRowToBarangayClearance(ResultSet result) throws SQLException {
				
		int clearanceId = result.getInt("clearanceId");
		int residentId = result.getInt("residentId");
		String fullName = result.getString("fullName");
		String date = result.getString("date");
		String address = result.getString("address");
		
		BarangayClearance tempBarangayClearance = new BarangayClearance(clearanceId, residentId, fullName, date, address);
		
		return tempBarangayClearance;
	}
	
	
	public int getCount(String query) throws Exception{
		
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery(query);
			
			result.next();
			int count = result.getInt(1);
			
			return count;
		}
		finally {
			close(state,result);
		}
	}
	
	public Connection getConn() {
		return conn;
	}
	/*
	public List<Resident> searchResident(String lName) throws Exception {
		List<Resident> list = new ArrayList<Resident>();

		PreparedStatement state = null;
		ResultSet result = null;

		try {
			lName += "%";
			state = conn.prepareStatement("select * from employees where last_name like ?  order by last_name");
			
			state.setString(1, lName);
			
			result = state.executeQuery();
			
			while (result.next()) {
				Resident tempResident = convertRowToResident(result);
				list.add(tempResident);
			}
			
			return list;
		}
		finally {
			close(state, result);
		}
	}
	*/

	private static void close(Connection conn, Statement state, ResultSet result)
			throws SQLException {

		if (result != null) {
			result.close();
		}

		if (state != null) {
			
		}
		
		if (conn != null) {
			conn.close();
		}
	}

	private static void close(Statement state, ResultSet result) throws SQLException {
		close(null, state, result);		
	}

	private void close(Statement state) throws SQLException {
		close(null, state, null);		
	}

}

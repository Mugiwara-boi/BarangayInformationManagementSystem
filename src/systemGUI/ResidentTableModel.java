package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ResidentTableModel extends AbstractTableModel{
	
	private List<Resident> residents;
	private String[] columnNames = {"ID", "First Name", "Middle Name", "Last Name", "Birth Date", "Birth Place",
			"Civil Status", "Sex", "Household No.", "Zone No.", "Street", "Voter Status", "Precinct No.", "Citizenship", "Occupation", "Phone Number", "Email", "Blood Type", "Religion"};

	
	public ResidentTableModel(List<Resident> resident) {
		residents = resident;
	}

	@Override
	public int getRowCount() {return residents.size();}
	
	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}

	@Override
	public Object getValueAt(int row, int column) {
		Resident tempResident = residents.get(row);
		
		switch (column) {
		case -1:
			return tempResident;
		case 0:
			return tempResident.getId();
		case 1:
			return tempResident.getFirstName();
		case 2:
			return tempResident.getMidName();
		case 3:
			return tempResident.getLastName();
		case 4:
			return tempResident.getBirthDate();
		case 5:
			return tempResident.getBirthPlace();
		case 6:
			return tempResident.getCivilStat();
		case 7:
			return tempResident.getSex();
		case 8:
			return tempResident.getHouseNo();
		case 9:
			return tempResident.getZoneNo();
		case 10:
			return tempResident.getStreet();
		case 11:
			return tempResident.getVoterStat();
		case 12:
			return tempResident.getPrecinctNo();
		case 13:
			return tempResident.getCitizenship();
		case 14:
			return tempResident.getOccupation();
		case 15:
			return tempResident.getContact();
		case 16:
			return tempResident.getEmail();
		case 17:
			return tempResident.getBloodType();
		case 18:
			return tempResident.getReligion();
		default:
			return tempResident.getLastName();
			
		}
	
	}	
	
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();	}
}

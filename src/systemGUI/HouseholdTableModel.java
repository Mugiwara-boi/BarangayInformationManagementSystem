package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class HouseholdTableModel extends AbstractTableModel{
	
	private List<Household> households;
	private String[] columnNames = {"Household No.", "House Ownership", "House Owner", "Structure Type", "Zone No. ", "Street", "Household Head", "No. of Family Members"};

	public HouseholdTableModel(List<Household> household) {households = household;}

	@Override
	public int getRowCount() {return households.size();}

	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}
	
	@Override
	public Object getValueAt(int row, int column) {
		Household tempHousehold = households.get(row);
		
		switch (column) {
		case -1:
			return tempHousehold;
		case 0:
			return tempHousehold.getHouseholdNo();
		case 1:
			return tempHousehold.getHouseOwnership();
		case 2:
			return tempHousehold.getHouseOwner();
		case 3:
			return tempHousehold.getStructureType();
		case 4:
			return tempHousehold.getZoneNo();
		case 5:
			return tempHousehold.getStreetName();
		case 6:
			return tempHousehold.getHouseholdHead();
		case 7:
			return tempHousehold.getNoFamilyMembers();
		default:
			return tempHousehold.getHouseholdNo();
		}
	}

}

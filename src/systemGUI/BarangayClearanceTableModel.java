package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BarangayClearanceTableModel extends AbstractTableModel{
	
	private List<BarangayClearance> barangayClearances;
	private String[] columnNames = {"Barangay Clearance ID", "Resident ID", "Full Name", "Date of Issuance", "Address"};

	
	public BarangayClearanceTableModel(List<BarangayClearance> barangayClearance) {barangayClearances = barangayClearance;}

	@Override
	public int getRowCount() {return barangayClearances.size();}
	
	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}

	@Override
	public Object getValueAt(int row, int column) {
		BarangayClearance tempbarangayClearance = barangayClearances.get(row);
		
		switch (column) {
		case -1:
			return tempbarangayClearance;
		case 0:
			return tempbarangayClearance.getClearanceId();
		case 1:
			return tempbarangayClearance.getResidentId();
		case 2:
			return tempbarangayClearance.getFullName();
		case 3:
			return tempbarangayClearance.getDate();
		case 4:
			return tempbarangayClearance.getAddress();
		default:
			return tempbarangayClearance.getFullName();
			
		}
	
	}	
	
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();	}

}


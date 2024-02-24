package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MemberTableModel extends AbstractTableModel{

	private List<Resident> residents;
	private String[] columnNames = {"Resident ID", "First Name", "Middle Name", "Last Name"};

	
	public MemberTableModel(List<Resident> resident) {residents = resident;}

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
		default:
			return tempResident.getLastName();
		}
	}
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();	
	}
}
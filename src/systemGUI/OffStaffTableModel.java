package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class OffStaffTableModel extends AbstractTableModel{
	
	private List<OfficialAndStaff> officials;
	private String[] columnNames = {"Official ID", "Resident ID", "Full Name", "Position", "Chairmanship ", "Term Start", "Term End", "Status"};

	
	public OffStaffTableModel(List<OfficialAndStaff> official) {officials = official;}

	@Override
	public int getRowCount() {return officials.size();}

	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}
	
	@Override
	public Object getValueAt(int row, int column) {
		OfficialAndStaff tempOfficial = officials.get(row);
		
		switch (column) {
		case -1:
			return tempOfficial;
		case 0:
			return tempOfficial.getOffId();
		case 1:
			return tempOfficial.getResidentId();
		case 2:
			return tempOfficial.getFullName();
		case 3:
			return tempOfficial.getPosition();
		case 4:
			return tempOfficial.getChairmanship();
		case 5:
			return tempOfficial.getTermStart();
		case 6:
			return tempOfficial.getTermEnd();
		case 7:
			return tempOfficial.getStatus();
		default:
			return tempOfficial.getFullName();
		}
	}
}

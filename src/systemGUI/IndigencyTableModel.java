package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class IndigencyTableModel extends AbstractTableModel{
	
	private List<Indigency> indigencys;
	private String[] columnNames = {"Indigency ID", "Resident ID", "Date of Issuance", "Address", "Full Name", "Civil Status", "Sex", "Age"};

	
	public IndigencyTableModel(List<Indigency> indigency) {indigencys = indigency;}

	@Override
	public int getRowCount() {return indigencys.size();}
	
	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}

	@Override
	public Object getValueAt(int row, int column) {
		Indigency tempIndigency = indigencys.get(row);
		
		switch (column) {
		case -1:
			return tempIndigency;
		case 0:
			return tempIndigency.getCertificateIndId();
		case 1:
			return tempIndigency.getResidentId();
		case 2:
			return tempIndigency.getDate();
		case 3:
			return tempIndigency.getAddress();
		case 4:
			return tempIndigency.getFullName();
		case 5:
			return tempIndigency.getCivilStat();
		case 6:
			return tempIndigency.getSex();
		case 7:
			return tempIndigency.getAge();
		default:
			return tempIndigency.getFullName();
			
		}
	
	}	
	
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();	}

}

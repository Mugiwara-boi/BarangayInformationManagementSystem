package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ResidencyTableModel extends AbstractTableModel{
	
	private List<Residency> residencys;
	private String[] columnNames = {"Residency ID", "Resident ID", "Full Name", "Date of Issuance", "Purpose"};

	
	public ResidencyTableModel(List<Residency> residency) {residencys = residency;}

	@Override
	public int getRowCount() {return residencys.size();}
	
	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}

	@Override
	public Object getValueAt(int row, int column) {
		Residency tempResidency = residencys.get(row);
		
		switch (column) {
		case -1:
			return tempResidency;
		case 0:
			return tempResidency.getCertificateResId();
		case 1:
			return tempResidency.getResidentId();
		case 2:
			return tempResidency.getFullName();
		case 3:
			return tempResidency.getDate();
		case 4:
			return tempResidency.getPurpose();
		default:
			return tempResidency.getFullName();
			
		}
	
	}	
	
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();	}

}


package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BlotterTableModel extends AbstractTableModel{
	
	private List<Blotter> blotters;
	private String[] columnNames = {"Blotter ID", "Complainant", "Complainant Age", "Complainant Contact", "Complainant Address", "Person To Complain",
			"Complaint Date", "Complaint Time", "Incidence Date", "Incidence Time", "Zone No.", "Complaint", "Status"};

	
	public BlotterTableModel(List<Blotter> blotter) {blotters = blotter;}

	@Override
	public int getRowCount() {return blotters.size();}
	
	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}

	@Override
	public Object getValueAt(int row, int column) {
		Blotter tempBlotter = blotters.get(row);
		
		switch (column) {
		case -1:
			return tempBlotter;
		case 0:
			return tempBlotter.getBlotterId();
		case 1:
			return tempBlotter.getComplainant();
		case 2:
			return tempBlotter.getCompAge();
		case 3:
			return tempBlotter.getCompContact();
		case 4:
			return tempBlotter.getCompAddress();
		case 5:
			return tempBlotter.getPerson2Comp();
		case 6:
			return tempBlotter.getCompDate();
		case 7:
			return tempBlotter.getCompTime();
		case 8:
			return tempBlotter.getIncidenceDate();
		case 9:
			return tempBlotter.getIncidenceTime();
		case 10:
			return tempBlotter.getZoneNo();
		case 11:
			return tempBlotter.getComplaint();
		case 12:
			return tempBlotter.getCompStatus();

		default:
			return tempBlotter.getComplainant();
			
		}
	
	}	
	
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();	}

}

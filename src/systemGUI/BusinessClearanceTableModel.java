package systemGUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BusinessClearanceTableModel extends AbstractTableModel{
	
	private List<BusinessClearance> businessClearances;
	private String[] columnNames = {"Business Clearance ID", "Date of Issuance", "Business Name", "Business Address", "Business Owner", "Contact Number", "Type of Business"};

	
	public BusinessClearanceTableModel(List<BusinessClearance> businessClearance) {businessClearances = businessClearance;}

	@Override
	public int getRowCount() {return businessClearances.size();}
	
	@Override
	public int getColumnCount() {return columnNames.length;}
	
	@Override
	public String getColumnName(int col) {return columnNames[col];}

	@Override
	public Object getValueAt(int row, int column) {
		BusinessClearance tempBusinessClearance = businessClearances.get(row);
		
		switch (column) {
		case -1:
			return tempBusinessClearance;
		case 0:
			return tempBusinessClearance.getBusiClearanceId();
		case 1:
			return tempBusinessClearance.getDate();
		case 2:
			return tempBusinessClearance.getBusinessName();
		case 3:
			return tempBusinessClearance.getBusiAddress();
		case 4:
			return tempBusinessClearance.getBusiOwner();
		case 5:
			return tempBusinessClearance.getContactNumber();
		case 6:
			return tempBusinessClearance.getBusiType();
		default:
			return tempBusinessClearance.getBusinessName();
			
		}
	
	}	
	
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();	}

}


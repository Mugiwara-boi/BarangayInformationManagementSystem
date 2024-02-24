package systemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelClass extends JPanel{
	
	JTable table;
	JLabel hdrLabel;
	JButton addButton;
	JButton delButton;
	JButton updButton;
	BlotterWindow blotPopup;
	String header;
    DAO dao;
    ResidentTableModel resiModel;
    OffStaffTableModel offstaffModel;
    HouseholdTableModel householdModel;
	private JButton viewButton;
	protected MemberWindow memPopup;
	
	public PanelClass(String header, String aButton, String uButton, String dButton) {
		
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		this.setLayout(null);
		this.setBounds(65, 87, 1287, 659);
		this.setBackground(Color.WHITE);
		
		Color color = Color.decode("#0C2D48");
		
		//table = new JTable(data, columnNames);
		//table.setPreferredScrollableViewportSize(new Dimension(250,250));
		//table.setFillsViewportHeight(true);
		//table.setBackground(new Color(0, 128, 128));
		//table.setBounds(1081, 102, -1070, 565);
		
		//JScrollPane scroll = new JScrollPane(table);
		//scroll.setSize(1266, 461);
		//scroll.setLocation(10, 195);
		//table.setFillsViewportHeight(true);
		//this.add(scroll);
		
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(250,250));
		table.setFillsViewportHeight(true);
		//table.setBounds(1081, 102, -1070, 565);
		
		
		switch(header) {
		case "Household Records":
			refreshHouseholdTable();
			break;
		case "Resident Records":
			refreshResidentTable();
			break;
		case "Barangay Officials And Staffs Records":
			refreshOffStaffTable();
			break;
		}
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 198, 1266, 455);
		this.add(scroll);
		table.setFillsViewportHeight(true);
		
		this.header = header;
		hdrLabel = new JLabel(header);
		hdrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hdrLabel.setForeground(color);
		hdrLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		hdrLabel.setBounds(0, 20, 1287, 43);
		this.add(hdrLabel);
		
		addButton = new JButton(aButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(header) {
				case "Resident Records":
					ResidentWindow resPopup = new ResidentWindow(PanelClass.this, dao);
					resPopup.setVisible(true);
					break;
				//case "Blotter":
				//	BlotterWindow blotPopup = new BlotterWindow();
				//	blotPopup.setVisible(true);
				//	break;
				case "Chairmanship":
					ChairmanshipWindow cmanshipPopup = new ChairmanshipWindow();
					cmanshipPopup.setVisible(true);
					break;
				case "Barangay Officials And Staffs Records":
					OfficialsAndStaffsWindow offPopup = new OfficialsAndStaffsWindow(PanelClass.this, dao);
					offPopup.setVisible(true);
					break;
				case "Household Records":
					HouseholdWindow hhPopup = new HouseholdWindow(PanelClass.this, dao);
					hhPopup.setVisible(true);
					break;
				}
			}
		});
		addButton.setForeground(color);
		//addButton.setBackground(new Color(0, 255, 0));
		
		addButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		addButton.setFocusable(false);
		addButton.setBounds(725, 156, 165, 29);
		this.add(addButton);
				
		updButton = new JButton(uButton);
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row;
				switch(header) {
				case "Resident Records":
					row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(PanelClass.this, "You must select a resident", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					Resident tempResident =  (Resident) table.getValueAt(row, -1);
					ResidentWindow resPopup = new ResidentWindow(PanelClass.this, dao, tempResident, true);
					resPopup.setVisible(true);
					break;
					
				case "Barangay Officials And Staffs Records":
					row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(PanelClass.this, "You must select an official or staff", "Error",
							JOptionPane.ERROR_MESSAGE);				
						return;
					}
					OfficialAndStaff tempOffStaff =  (OfficialAndStaff) table.getValueAt(row, -1);
					OfficialsAndStaffsWindow offstaffPopup = new OfficialsAndStaffsWindow(PanelClass.this, dao, tempOffStaff, true);
					offstaffPopup.setVisible(true);
					break;
				case "Household Records":
					row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(PanelClass.this, "You must select a household", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					Household tempHousehold =  (Household) table.getValueAt(row, -1);
					HouseholdWindow householdPopup = new HouseholdWindow(PanelClass.this, dao, tempHousehold, true);
					householdPopup.setVisible(true);
					break;
				}
			}
		});
		
		updButton.setForeground(color);
		//updButton.setBackground(Color.CYAN);
		updButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		updButton.setFocusable(false);
		updButton.setBounds(900, 156, 183, 29);
		this.add(updButton);

		delButton = new JButton(dButton);
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(header) {
				case "Resident Records":
					
					try {
						int row = table.getSelectedRow();

						if (row < 0) {
							JOptionPane.showMessageDialog(PanelClass.this, 
									"You must select a resident", "Error", JOptionPane.ERROR_MESSAGE);				
							return;
						}

						// prompt the user
						int response = JOptionPane.showConfirmDialog(
								PanelClass.this, "Delete this resident?", "Confirm", 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						Resident tempResident = (Resident) table.getValueAt(row, -1);
						
						dao.deleteResident(tempResident.getId());

						refreshResidentTable();

						JOptionPane.showMessageDialog(PanelClass.this,
								"Resident deleted succesfully.", "Resident Deleted",
								JOptionPane.INFORMATION_MESSAGE);
						break;

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(PanelClass.this,
								"Error deleting resident: " + exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				case "Barangay Officials And Staffs Records":
					
					try {
						int row = table.getSelectedRow();

						if (row < 0) {
							JOptionPane.showMessageDialog(PanelClass.this, 
									"You must select an official or staff", "Error", JOptionPane.ERROR_MESSAGE);				
							return;
						}

						// prompt the user
						int response = JOptionPane.showConfirmDialog(
								PanelClass.this, "Delete this official/staff?", "Confirm", 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						OfficialAndStaff tempOffStaff = (OfficialAndStaff) table.getValueAt(row, -1);
						
						dao.deleteOffStaff(tempOffStaff.getOffId());

						refreshOffStaffTable();

						JOptionPane.showMessageDialog(PanelClass.this,
								"Official/Staff deleted succesfully.", "Resident Deleted",
								JOptionPane.INFORMATION_MESSAGE);
						break;

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(PanelClass.this,
								"Error deleting official/staff: " + exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				case "Household Records":
					
					try {
						int row = table.getSelectedRow();

						if (row < 0) {
							JOptionPane.showMessageDialog(PanelClass.this, 
									"You must select a household", "Error", JOptionPane.ERROR_MESSAGE);				
							return;
						}

						// prompt the user
						int response = JOptionPane.showConfirmDialog(
								PanelClass.this, "Delete this household?", "Confirm", 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						Household tempHousehold = (Household) table.getValueAt(row, -1);
						
						dao.deleteHousehold(tempHousehold.getHouseholdNo());

						refreshHouseholdTable();

						JOptionPane.showMessageDialog(PanelClass.this,
								"Household deleted succesfully.", "Resident Deleted",
								JOptionPane.INFORMATION_MESSAGE);
						break;

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(PanelClass.this,
								"Error deleting household: " + exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					
				}
			}
		});
		delButton.setForeground(color);
		delButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		delButton.setFocusable(false);
		delButton.setBounds(1093, 156, 183, 29);
		this.add(delButton);
		
		if(header.equals("Household Records")) {
			viewButton = new JButton("View Members");
			viewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(PanelClass.this, "You must select a household", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					Household tempHousehold =  (Household) table.getValueAt(row, -1);
					memPopup = new MemberWindow(tempHousehold.getHouseholdNo());
					memPopup.setVisible(true);
			}
	});
			viewButton.setForeground(new Color(8, 157, 227));
			viewButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
			viewButton.setFocusable(false);
			viewButton.setBounds(10, 159, 165, 29);
			this.add(viewButton);
		}
		
	}
	
	public void refreshResidentTable() {
		try {
			List<Resident> residents = dao.getAllResidents();
			System.out.println(residents.get(0));
			resiModel = new ResidentTableModel(residents);

			table.setModel(resiModel);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshOffStaffTable() {
		try {
			List<OfficialAndStaff> offstaffs = dao.getAllOffStaff();
			offstaffModel = new OffStaffTableModel(offstaffs);

			table.setModel(offstaffModel);
		} catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshHouseholdTable() {
		try {
			List<Household> households = dao.getAllHouseholds();
			householdModel = new HouseholdTableModel(households);

			table.setModel(householdModel);
		} catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}

package systemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FormPanel extends JPanel{
	
	JTable table;
	JLabel hdrLabel;
	JButton addButton;
	JButton delButton;
	JButton genButton;
	BlotterWindow blotPopup;
	String header;
    DAO dao;
    ResidentTableModel resiModel;
	protected MemberWindow memPopup;
	private IndigencyTableModel indigencyModel;
	private ResidencyTableModel residencyModel;
	private BusinessClearanceTableModel businessClearanceModel;
	private BarangayClearanceTableModel barangayClearanceModel;
	
	public FormPanel(String header, String aButton) {
		
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		this.setLayout(null);
		this.setBounds(65, 87, 1287, 659);
		this.setBackground(Color.WHITE);
		
		Color color = Color.decode("#0C2D48");
		
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(250,250));
		table.setFillsViewportHeight(true);
		
		switch(header) {
		case "Certificate of Indigency":
			refreshIndigencyTable();
			break;
		case "Certificate of Residency":
			refreshResidencyTable();
			break;
		case "Barangay Business Clearance":
			refreshBusinessClearanceTable();
			break;
		case "Barangay Clearance":
			refreshBarangayClearanceTable();
			break;
		}
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 198, 1266, 455);
		this.add(scroll);
		table.setFillsViewportHeight(true);
		
		
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
				case "Certificate of Indigency":
					IndigencyWindow indigencyPopup = new IndigencyWindow(FormPanel.this, dao);
					indigencyPopup.setVisible(true);
					break;
				case "Certificate of Residency":
					ResidencyWindow residencyPopup = new ResidencyWindow(FormPanel.this, dao);
					residencyPopup.setVisible(true);
					break;
				case "Barangay Business Clearance":
					BusinessClearanceWindow busiclearancePopup = new BusinessClearanceWindow(FormPanel.this, dao);
					busiclearancePopup.setVisible(true);
					break;
				case "Barangay Clearance":
					BarangayClearanceWindow brgyClearancePopup = new BarangayClearanceWindow(FormPanel.this, dao);
					brgyClearancePopup.setVisible(true);
					break;
				}
			}
		});
		addButton.setForeground(color);
		addButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		addButton.setFocusable(false);
		addButton.setBounds(918, 156, 165, 29);
		this.add(addButton);
				
		genButton = new JButton("Generate Form");
		genButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = 0;
				switch(header) {
				case "Certificate of Indigency":
					row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(FormPanel.this, "You must select an indigency record", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					Indigency tempIndigency =  (Indigency) table.getValueAt(row, -1);
					try {
						BIMS_Indigency indigency = new BIMS_Indigency(tempIndigency.getFullName(), tempIndigency.getAddress(), tempIndigency.getDate());
						
						JOptionPane.showMessageDialog(FormPanel.this, "Indigency created succesfully.",
								"Indigency Added",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					break;
				case "Certificate of Residency":
					row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(FormPanel.this, "You must select a residency record", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					Residency tempResidency =  (Residency) table.getValueAt(row, -1);
					try {
						BIMS_residency residency = new BIMS_residency(tempResidency.getFullName(), tempResidency.getDate());
						
						JOptionPane.showMessageDialog(FormPanel.this, "Certificate of Residency created succesfully.",
								"Certificate of Residency Added",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (MalformedURLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					//indigencyPopup.setVisible(true);
					break;
				case "Barangay Business Clearance":
					row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(FormPanel.this, "You must select a business clearance record", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					BusinessClearance tempBusinessClearance =  (BusinessClearance) table.getValueAt(row, -1);
					try {
						BIMS_BusinessClearance busClearance = new BIMS_BusinessClearance(tempBusinessClearance.getBusiType(), tempBusinessClearance.getBusinessName(), 
								tempBusinessClearance.getBusiOwner(),tempBusinessClearance.getBusiAddress(), tempBusinessClearance.getDate());
						
						JOptionPane.showMessageDialog(FormPanel.this, "Business clearance created succesfully.",
								"Business Clearance Added",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "Barangay Clearance":
					row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(FormPanel.this, "You must select a barangay clearance record", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					BarangayClearance tempBarangayClearance =  (BarangayClearance) table.getValueAt(row, -1);
					try {
						BIMS_brgyClearance brgyClearance = new BIMS_brgyClearance(tempBarangayClearance.getFullName(), 
								tempBarangayClearance.getAddress(), tempBarangayClearance.getDate());
						
						JOptionPane.showMessageDialog(FormPanel.this, "Barangay clearance created succesfully.",
								"Barangay Clearance Added",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//IndigencyWindow indigencyPopup = new IndigencyWindow(FormPanel.this, dao, tempIndigency, true);
					//indigencyPopup.setVisible(true);
					break;
				}

			}
		});
		
		genButton.setForeground(color);
		genButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		genButton.setFocusable(false);
		genButton.setBounds(1093, 156, 183, 29);
		this.add(genButton);
	}
	
	public void refreshIndigencyTable() {
		try {
			List<Indigency> indigencys = dao.getAllIndigency();
			indigencyModel = new IndigencyTableModel(indigencys);

			table.setModel(indigencyModel);
		} catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshResidencyTable() {
		try {
			List<Residency> residencys = dao.getAllResidency();
			residencyModel = new ResidencyTableModel(residencys);

			table.setModel(residencyModel);
		} catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshBusinessClearanceTable() {
		try {
			List<BusinessClearance> businessClearances = dao.getAllBusinessClearance();
			businessClearanceModel = new BusinessClearanceTableModel(businessClearances);

			table.setModel(businessClearanceModel);
		} catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshBarangayClearanceTable() {
		try {
			List<BarangayClearance> barangayClearances = dao.getAllBarangayClearance();
			barangayClearanceModel = new BarangayClearanceTableModel(barangayClearances);

			table.setModel(barangayClearanceModel);
		} catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}

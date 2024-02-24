package systemGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class HouseholdWindow extends JFrame implements ActionListener{
	
	private DAO dao;
	private Household previousHousehold = null;
	private boolean updateMode = false;
	private PanelClass panel;
	private JPanel contentPane;
	private JTextField hhField;
	private JComboBox zoneCombo;
	private JLabel memNoLabel;
	private JTextField noMemField;
	private JButton saveButton;
	private JButton closeButton;
	private JLabel ownershipLabel;
	private JComboBox structCombo;
	private JTextField ownerField;
	private JLabel streetLabel;
	private JComboBox streetCombo;
	private JLabel hhHeadLabel;
	private JComboBox hhHeadCombo;
	private JComboBox ownershipCombo;
	private String[] structChoice = {"House", "Condominium Unit", "Apartment"};
	private String[] ownershipChoice = {"Owned", "Rented", "Room Renter", "Room Sharer"};
	
	public HouseholdWindow(PanelClass panel, DAO dao, Household previousHousehold, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousHousehold = previousHousehold;
		
		this.updateMode = updateMode;

		if (updateMode) {
			setTitle("Update Household");
			hhField.setEditable(false);;
			
			try {
				populateGui(previousHousehold);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void populateGui(Household household) throws ParseException {
		hhField.setText(String.valueOf(household.getHouseholdNo()));
		ownershipCombo.setSelectedItem(household.getHouseOwnership());
		ownerField.setText(household.getHouseOwner());
		structCombo.setSelectedItem(household.getStructureType());
		zoneCombo.setSelectedItem(String.valueOf(household.getZoneNo()));
		streetCombo.setSelectedItem(household.getStreetName());
		hhHeadCombo.setSelectedItem(household.getHouseholdHead());
		noMemField.setText(String.valueOf(household.getNoFamilyMembers()));
		
	}
	
	public HouseholdWindow(PanelClass panel, DAO dao) {
		this(panel, dao, null, false);
	}
	public HouseholdWindow() {
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		this.setType(Type.POPUP);
		this.setTitle("Add Household");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 424, 751);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		JLabel hhLabel = new JLabel("Household No.");
		hhLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		hhLabel.setBounds(29, 32, 162, 13);
		contentPane.add(hhLabel);
		
		
		
		hhField = new JTextField();
		hhField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					dao.fillHouseHeadCombo(hhField, hhHeadCombo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		hhField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hhField.setBounds(29, 55, 352, 32);
		contentPane.add(hhField);
		
		streetLabel = new JLabel("Street");
		streetLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		streetLabel.setBounds(29, 417, 81, 13);
		contentPane.add(streetLabel);
		
		streetCombo = new JComboBox();
		streetCombo.setEditable(false);
		streetCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		streetCombo.setBounds(29, 440, 352, 32);
		contentPane.add(streetCombo);
		
		JLabel zoneLabel = new JLabel("Zone");
		zoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		zoneLabel.setBounds(29, 340, 81, 13);
		contentPane.add(zoneLabel);
		
		hhHeadCombo = new JComboBox();
		hhHeadCombo.addItem("None");
		hhHeadCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hhHeadCombo.setBounds(29, 517, 352, 32);
		contentPane.add(hhHeadCombo);
		
		zoneCombo = new JComboBox();
		zoneCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					streetCombo.removeAllItems();
					dao.fillComboStreet(zoneCombo, streetCombo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		zoneCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		zoneCombo.setBounds(29, 363, 352, 32);
		contentPane.add(zoneCombo);
		
		try {
			dao.fillComboZone(zoneCombo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		memNoLabel = new JLabel("Number of Members ");
		memNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		memNoLabel.setBounds(29, 571, 146, 13);
		contentPane.add(memNoLabel);
				
		noMemField = new JTextField();
		try {
			int count = dao.getCount("select count(*) from tb_resident where householdNo=" + Integer.valueOf(hhField.getText()));
		} catch (NumberFormatException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		noMemField.setEditable(false);
		noMemField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		noMemField.setBounds(29, 594, 352, 32);
		contentPane.add(noMemField);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setBounds(257, 675, 124, 29);
		contentPane.add(saveButton);
		
		closeButton = new JButton("Close");
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(123, 675, 124, 29);
		contentPane.add(closeButton);
		
		ownershipLabel = new JLabel("House Ownership");
		ownershipLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ownershipLabel.setBounds(29, 109, 136, 13);
		contentPane.add(ownershipLabel);
		
		ownershipCombo = new JComboBox(ownershipChoice);
		ownershipCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ownershipCombo.setBounds(29, 132, 352, 32);
		contentPane.add(ownershipCombo);
		
		JLabel structLabel = new JLabel("Structure Type");
		structLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		structLabel.setBounds(29, 263, 146, 13);
		contentPane.add(structLabel);
		
		structCombo = new JComboBox(structChoice);
		structCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		structCombo.setBounds(29, 286, 352, 32);
		contentPane.add(structCombo);
		
		JLabel ownerLabel = new JLabel("House Owner");
		ownerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ownerLabel.setBounds(29, 186, 124, 13);
		contentPane.add(ownerLabel);
		
		ownerField = new JTextField();
		ownerField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ownerField.setBounds(29, 209, 352, 32);
		contentPane.add(ownerField);
		
		hhHeadLabel = new JLabel("Household Head");
		hhHeadLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		hhHeadLabel.setBounds(29, 494, 146, 13);
		contentPane.add(hhHeadLabel);
		
		
		try {
			dao.fillHouseHeadCombo(hhField, hhHeadCombo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	protected void saveHousehold() throws ParseException {
			
		
		int householdNo = Integer.parseInt(hhField.getText());			/////////////////////////////////////
		String houseOwnership = ownershipCombo.getSelectedItem().toString();
		String houseOwner = ownerField.getText();
		String structureType = structCombo.getSelectedItem().toString();
		int zoneNo = (int) zoneCombo.getSelectedItem();
		String streetName = streetCombo.getSelectedItem().toString();
		String householdHead = hhHeadCombo.getSelectedItem().toString();
		
		int count = 0;
		try {
			count = dao.getCount("select count(*) from tb_resident where householdNo=" + householdNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int noFamilyMembers = count;
		
		Household tempHousehold = null;

		if (updateMode) {
			tempHousehold = previousHousehold;
			
			tempHousehold.setHouseholdNo(householdNo);
			tempHousehold.setHouseOwnership(houseOwnership);
			tempHousehold.setHouseOwner(houseOwner);
			tempHousehold.setStructureType(structureType);
			tempHousehold.setZoneNo(zoneNo);
			tempHousehold.setStreetName(streetName);
			tempHousehold.setHouseholdHead(householdHead);
			tempHousehold.setNoFamilyMembers(noFamilyMembers);
			
		} else {
			tempHousehold = new Household(householdNo, houseOwnership, houseOwner, structureType, zoneNo, streetName, householdHead, noFamilyMembers);
		}

			try {
				if (updateMode) {
					dao.updateHousehold(tempHousehold);
				} else {
					dao.addHousehold(tempHousehold);
				}

				// close dialog
				setVisible(false);
				dispose();

				// refresh gui list
				panel.refreshHouseholdTable();
			
				// show success message
				JOptionPane.showMessageDialog(panel,
						"Household added succesfully.",
						"Household Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				System.out.println(exc);
				JOptionPane.showMessageDialog(
						panel,
						"Error saving official/staff: "
								+ exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton) {
			this.dispose();
		}
		if(e.getSource() == saveButton) {
			try {
				saveHousehold();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

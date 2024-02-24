package systemGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class ResidentWindow extends JFrame implements ActionListener{
	
	private DAO dao;
	private PanelClass panel;
	private JPanel contentPane;
	private JTextField fnField;
	private JTextField mnField;
	private JTextField lnField;
	private JLabel lnLabel;
	private JLabel hhLabel;
	private JLabel prcnctLabel;
	private JTextField prcnctField;
	private JLabel bplaceLabel;
	private JTextField bplaceField;
	private JLabel bdateLabel;
	//private JTextField bdateField;
	//private JLabel ageLabel;
	//private JTextField ageField;
	private JLabel cvstatLabel;
	private JLabel occuLabel;
	private JTextField occupField;
	private JLabel addressLabel;
	private JTextField religionField;
	private JLabel contactLabel;
	private JTextField contactField;
	private JLabel citizenshipLabel;
	private JTextField citizenshipField;
	private JButton saveButton;
	private JButton closeButton;
	private JLabel emailLabel;
	private JLabel vtrstatLabel;
	private JTextField emailField;
	private JComboBox hhBox;
	private JComboBox sexBox;
	private JComboBox cvstatBox;
	private JComboBox vtrstatBox;
	private String[] civilChoice = {"Single", "Married", "Divorced", "Widowed"};
	private String[] sexChoice = {"Male", "Female"};
	private String[] vtrstatChoice = {"Non-voter", "Voter"};
	private String [] bloodTypeChoice = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
	private JDateChooser bdateChooser;
	private Resident previousResident = null;
	private boolean updateMode = false;
	private JTextField zoneNoField;
	private JTextField streetField;
	private JComboBox bloodTypeCombo;
	
	public ResidentWindow(PanelClass panel, DAO dao, Resident previous, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousResident = previous;
		
		this.updateMode = updateMode;

		if (updateMode) {
			setTitle("Update Person");
			
			try {
				populateGui(previous);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void populateGui(Resident resident) throws ParseException {
				
		fnField.setText(resident.getFirstName());
		mnField.setText(resident.getMidName());
		lnField.setText(resident.getLastName());
		bdateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse((String)resident.getBirthDate()));
		bplaceField.setText(resident.getBirthPlace());
		cvstatBox.setSelectedItem(resident.getCivilStat());
		sexBox.setSelectedItem(resident.getSex());
		hhBox.setSelectedItem(String.valueOf(resident.getHouseNo()));
		zoneNoField.setText(String.valueOf(resident.getZoneNo()));
		streetField.setText(resident.getStreet());
		vtrstatBox.setName(resident.getVoterStat());
		prcnctField.setText(resident.getPrecinctNo());
		citizenshipField.setText(resident.getCitizenship());
		occupField.setText(resident.getOccupation());
		contactField.setText(resident.getContact());
		emailField.setText(resident.getEmail());
		bloodTypeCombo.setSelectedItem(resident.getBloodType());
		religionField.setText(resident.getAddress());
	}

	public ResidentWindow(PanelClass panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public ResidentWindow() {
		
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setResizable(false);
		this.setType(Type.POPUP);
		this.setLocationRelativeTo(null);
		this.setTitle("Add Resident");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 624, 681);
		
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fnField = new JTextField();
		fnField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fnField.setBounds(25, 55, 157, 32);
		contentPane.add(fnField);
		fnField.setColumns(10);
		
		JLabel fnLabel = new JLabel("First Name");
		fnLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fnLabel.setBounds(25, 32, 81, 13);
		contentPane.add(fnLabel);
		
		mnField = new JTextField();
		mnField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mnField.setColumns(10);
		mnField.setBounds(227, 55, 157, 32);
		contentPane.add(mnField);
		
		JLabel mnLabel = new JLabel("Middle Name");
		mnLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnLabel.setBounds(227, 32, 88, 13);
		contentPane.add(mnLabel);
		
		lnField = new JTextField();
		lnField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lnField.setColumns(10);
		lnField.setBounds(432, 55, 157, 32);
		contentPane.add(lnField);
		
		lnLabel = new JLabel("Last Name");
		lnLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lnLabel.setBounds(432, 32, 88, 13);
		contentPane.add(lnLabel);
		
		hhLabel = new JLabel("Household No.");
		hhLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		hhLabel.setBounds(227, 216, 101, 13);
		contentPane.add(hhLabel);
		
		zoneNoField = new JTextField();
		zoneNoField.setEditable(false);
		zoneNoField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		zoneNoField.setBounds(432, 239, 157, 32);
		contentPane.add(zoneNoField);
		
		streetField = new JTextField();
		streetField.setEditable(false);
		streetField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		streetField.setBounds(25, 332, 157, 32);
		contentPane.add(streetField);
		hhBox = new JComboBox();
		
		hhBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					dao.fillHouseholInfo(hhBox, zoneNoField, streetField);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		hhBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		hhBox.setBounds(227, 239, 157, 32);
		contentPane.add(hhBox);
		
		try {
			dao.fillHousehold(hhBox);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		prcnctLabel = new JLabel("Street");
		prcnctLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		prcnctLabel.setBounds(25, 309, 101, 13);
		contentPane.add(prcnctLabel);
		
		prcnctField = new JTextField();
		prcnctField.setEditable(false);
		prcnctField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		prcnctField.setBounds(432, 332, 157, 32);
		contentPane.add(prcnctField);
		
		bplaceLabel = new JLabel("Birth Place");
		bplaceLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bplaceLabel.setBounds(227, 124, 101, 13);
		contentPane.add(bplaceLabel);
		
		bplaceField = new JTextField();
		bplaceField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bplaceField.setColumns(10);
		bplaceField.setBounds(227, 147, 157, 32);
		contentPane.add(bplaceField);
		
		bdateLabel = new JLabel("Birthdate");
		bdateLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bdateLabel.setBounds(25, 124, 101, 13);
		contentPane.add(bdateLabel);
		
		bdateChooser = new JDateChooser();
		bdateChooser.setBounds(25, 147, 157, 32);
		contentPane.add(bdateChooser);
		
		cvstatLabel = new JLabel("Civil Status");
		cvstatLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cvstatLabel.setBounds(432, 124, 101, 13);
		contentPane.add(cvstatLabel);
		
		cvstatBox = new JComboBox(civilChoice);
		cvstatBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cvstatBox.setBounds(432, 147, 157, 32);
		contentPane.add(cvstatBox);
		
		vtrstatLabel = new JLabel("Zone No.");
		vtrstatLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		vtrstatLabel.setBounds(432, 216, 101, 13);
		contentPane.add(vtrstatLabel);
		
		vtrstatBox = new JComboBox(vtrstatChoice);
		vtrstatBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(vtrstatBox.getSelectedIndex() == 1) {
					prcnctField.setEditable(true);
				}	
				else {
					prcnctField.setEditable(false);
				}
			}
		});
		vtrstatBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vtrstatBox.setBounds(227, 332, 157, 32);
		contentPane.add(vtrstatBox);
		
		occuLabel = new JLabel("Precinct No.");
		occuLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		occuLabel.setBounds(432, 309, 101, 13);
		contentPane.add(occuLabel);
		
		occupField = new JTextField();
		occupField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		occupField.setColumns(10);
		occupField.setBounds(227, 423, 157, 32);
		contentPane.add(occupField);
		
		addressLabel = new JLabel("Contact Number");
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addressLabel.setBounds(432, 400, 157, 13);
		contentPane.add(addressLabel);
		
		religionField = new JTextField();
		religionField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		religionField.setColumns(10);
		religionField.setBounds(432, 504, 157, 32);
		contentPane.add(religionField);
		
		contactLabel = new JLabel("Citizenship");
		contactLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contactLabel.setBounds(25, 400, 121, 13);
		contentPane.add(contactLabel);
		
		contactField = new JTextField();
		contactField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contactField.setColumns(10);
		contactField.setBounds(432, 423, 157, 32);
		contentPane.add(contactField);
		
		citizenshipLabel = new JLabel("Voter Status");
		citizenshipLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		citizenshipLabel.setBounds(227, 309, 121, 13);
		contentPane.add(citizenshipLabel);
		
		citizenshipField = new JTextField();
		citizenshipField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		citizenshipField.setColumns(10);
		citizenshipField.setBounds(25, 423, 157, 32);
		contentPane.add(citizenshipField);
		
		closeButton = new JButton("Close");
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(334, 604, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setBounds(465, 604, 124, 29);
		contentPane.add(saveButton);
		
		JLabel sexLabel = new JLabel("Sex");
		sexLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sexLabel.setBounds(25, 216, 101, 13);
		contentPane.add(sexLabel);
		
		sexBox = new JComboBox(sexChoice);
		sexBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		sexBox.setBounds(25, 239, 157, 32);
		contentPane.add(sexBox);
		
		emailLabel = new JLabel("Occupation");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		emailLabel.setBounds(227, 400, 101, 13);
		contentPane.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		emailField.setColumns(10);
		emailField.setBounds(25, 504, 157, 32);
		contentPane.add(emailField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmail.setBounds(25, 481, 121, 13);
		contentPane.add(lblEmail);
		
		JLabel lblBloodType = new JLabel("Blood Type");
		lblBloodType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBloodType.setBounds(227, 482, 157, 13);
		contentPane.add(lblBloodType);
		
		bloodTypeCombo = new JComboBox(bloodTypeChoice);
		bloodTypeCombo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bloodTypeCombo.setBounds(227, 504, 157, 32);
		contentPane.add(bloodTypeCombo);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblReligion.setBounds(432, 482, 157, 13);
		contentPane.add(lblReligion);
	
	}
	protected void saveResident() throws ParseException {

		// get the employee info from gui
		String fName = fnField.getText();
		String mName = mnField.getText();
		String lName = lnField.getText();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String bDate = df.format(bdateChooser.getDate());
		String bPlace = bplaceField.getText();
		String civil = cvstatBox.getSelectedItem().toString();
		String sex = sexBox.getSelectedItem().toString();
		int houseNo = Integer.valueOf(hhBox.getSelectedItem().toString());
		int zoneNo = Integer.valueOf(zoneNoField.getText());
		String street = streetField.getText();
		String voterStat = vtrstatBox.getSelectedItem().toString();	
		String precinctNo = prcnctField.getText();
		String citizenship = citizenshipField.getText();
		String occup = occupField.getText();
		String contact = contactField.getText();
		String email = emailField.getText();
		String bloodType = bloodTypeCombo.getSelectedItem().toString();
		String religion = religionField.getText();

		Resident tempResident = null;

		if (updateMode) {
			tempResident = previousResident;
			
			tempResident.setFirstName(fName);
			tempResident.setMidName(mName);
			tempResident.setLastName(lName);
			tempResident.setBirthDate(bDate);
			tempResident.setBirthPlace(bPlace);
			tempResident.setCivilStat(civil);
			tempResident.setSex(sex);
			tempResident.setHouseNo(houseNo);
			tempResident.setZoneNo(zoneNo);
			tempResident.setStreet(street);
			tempResident.setVoterStat(voterStat);
			tempResident.setPrecinctNo(precinctNo);
			tempResident.setCitizenship(citizenship);
			tempResident.setOccupation(occup);
			tempResident.setContact(contact);
			tempResident.setEmail(email);
			tempResident.setBloodType(bloodType);
			tempResident.setReligion(religion);
			
		} else {
			tempResident = new Resident(fName, mName, lName, bDate, bPlace, civil, sex, houseNo, zoneNo, street, voterStat, precinctNo, citizenship, occup, contact, email, bloodType, religion);
		}

			try {
				if (updateMode) {
					dao.updateResident(tempResident);
				} else {
					dao.addResident(tempResident);
				}

				// close dialog
				setVisible(false);
				dispose();

				// refresh gui list
				panel.refreshResidentTable();
				panel.refreshHouseholdTable();
			
				// show success message
				JOptionPane.showMessageDialog(panel,
						"Resident added succesfully.",
						"Resident Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
			
				JOptionPane.showMessageDialog(
						panel,
						"Error saving resident: "
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
				saveResident();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}

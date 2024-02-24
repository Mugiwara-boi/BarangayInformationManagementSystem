package systemGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;

public class BlotterWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField compAddressField;
	private JTextField person2compField;
	private JButton closeButton;
	private JButton saveButton;
	private JTextField incidenceTimeField;
	private JComboBox zoneNoCombo;
	private JComboBox statusCombo;
	private DAO dao;
	private BlotterPanel panel;
	private Blotter previousBlotter = null;
	private boolean updateMode = false;
	JTextField compContactField;
	private JTextField compAgeField;
	private JTextField complainantField;
	private JTextField timeCompField;
	private JTextArea complaintField;
	private JDateChooser incidenceDateChooser;
	private JDateChooser compDateChooser;
	String[] statusChoice =  {"Unsettled", "Settled", "Scheduled"};
	
	public BlotterWindow(BlotterPanel panel, DAO dao, Blotter previousBlotter, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousBlotter = previousBlotter;
		
		this.updateMode  = updateMode;

		if (updateMode) {
			setTitle("Update Official and Staff");
			
			try {
				populateGui(previousBlotter);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void populateGui(Blotter blotter) throws ParseException {
		
		complainantField.setText(blotter.getComplainant());
		compAgeField.setText(String.valueOf(blotter.getCompAge()));
		compContactField.setText(blotter.getCompContact());
		compAddressField.setText(blotter.getCompAddress());
		person2compField.setText(blotter.getPerson2Comp());
		compDateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse((String)blotter.getCompDate()));
		timeCompField.setText(blotter.getCompTime());
		incidenceDateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse((String)blotter.getIncidenceDate()));
		incidenceTimeField.setText(blotter.getIncidenceTime());
		zoneNoCombo.setSelectedItem(blotter.getZoneNo());
		complaintField.setText(blotter.getComplaint());
		statusCombo.setSelectedItem(blotter.getCompStatus());
		
	}

	public BlotterWindow(BlotterPanel panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public BlotterWindow() {
		
		try {
			dao = new DAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.setType(Type.POPUP);
		this.setTitle("Add Blotter");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 596, 723);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		JLabel cmplnntLabel = new JLabel("Complainant");
		cmplnntLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cmplnntLabel.setBounds(35, 32, 92, 13);
		contentPane.add(cmplnntLabel);
		
		complainantField = new JTextField();
		complainantField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		complainantField.setBounds(35, 55, 225, 32);
		contentPane.add(complainantField);
		
		JLabel vctmLabel = new JLabel("Complainant Contact");
		vctmLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		vctmLabel.setBounds(35, 109, 144, 13);
		contentPane.add(vctmLabel);
		
		compContactField = new JTextField();
		compContactField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		compContactField.setBounds(35, 132, 225, 32);
		contentPane.add(compContactField);
		
		JLabel rspndntLabel = new JLabel("Complainant Age");
		rspndntLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rspndntLabel.setBounds(324, 33, 130, 13);
		contentPane.add(rspndntLabel);
		
		compAgeField = new JTextField();
		compAgeField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		compAgeField.setBounds(324, 55, 225, 32);
		contentPane.add(compAgeField);
		
		JLabel locLabel = new JLabel("Complainant Address");
		locLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		locLabel.setBounds(324, 109, 144, 13);
		contentPane.add(locLabel);
		
		compAddressField = new JTextField();
		compAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		compAddressField.setBounds(324, 132, 225, 32);
		contentPane.add(compAddressField);
		
		JLabel person2compLabel = new JLabel("Person to Complain");
		person2compLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		person2compLabel.setBounds(35, 186, 144, 13);
		contentPane.add(person2compLabel);
		
		person2compField = new JTextField();
		person2compField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		person2compField.setBounds(35, 209, 225, 32);
		contentPane.add(person2compField);
		
		JLabel statusLabel = new JLabel("Date of Complaint");
		statusLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		statusLabel.setBounds(324, 186, 130, 13);
		contentPane.add(statusLabel);
		
		Date date = new Date();
		String strDateFormat = "hh:mm:ss";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate= dateFormat.format(date);	
		
		timeCompField = new JTextField(formattedDate);
		timeCompField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timeCompField.setBounds(35, 286, 225, 32);
		contentPane.add(timeCompField);
		
		JLabel cmplntLabel = new JLabel("Time of Complaint");
		cmplntLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cmplntLabel.setBounds(35, 263, 130, 13);
		contentPane.add(cmplntLabel);
		
		closeButton = new JButton("Close");
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(291, 647, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setBounds(425, 647, 124, 29);
		contentPane.add(saveButton);
		
		incidenceTimeField = new JTextField();
		incidenceTimeField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		incidenceTimeField.setBounds(35, 360, 225, 32);
		contentPane.add(incidenceTimeField);
		
		JLabel lblDateOfInciden = new JLabel("Date of Incidence");
		lblDateOfInciden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateOfInciden.setBounds(324, 263, 130, 13);
		contentPane.add(lblDateOfInciden);
		
		JLabel lblTimeOfIncidence = new JLabel("Time of Incidence");
		lblTimeOfIncidence.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTimeOfIncidence.setBounds(35, 337, 130, 13);
		contentPane.add(lblTimeOfIncidence);
		
		zoneNoCombo = new JComboBox();
		zoneNoCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		zoneNoCombo.setBounds(324, 360, 225, 32);
		contentPane.add(zoneNoCombo);
		

		try {
			dao.fillComboZone(zoneNoCombo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		statusCombo = new JComboBox(statusChoice);
		statusCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		statusCombo.setBounds(35, 566, 225, 32);
		contentPane.add(statusCombo);
		
		JLabel lblComplaint = new JLabel("Complaint");
		lblComplaint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblComplaint.setBounds(35, 408, 130, 13);
		contentPane.add(lblComplaint);
		
		JLabel lblZoneNo = new JLabel("Zone No.");
		lblZoneNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblZoneNo.setBounds(324, 337, 130, 13);
		contentPane.add(lblZoneNo);
		
		complaintField = new JTextArea();
		complaintField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		complaintField.setBounds(35, 431, 514, 84);
		contentPane.add(complaintField);
		
		JLabel lblComplainStatus = new JLabel("Complain Status");
		lblComplainStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblComplainStatus.setBounds(35, 543, 130, 13);
		contentPane.add(lblComplainStatus);
		
		incidenceDateChooser = new JDateChooser();
		incidenceDateChooser.setBounds(324, 286, 225, 32);
		contentPane.add(incidenceDateChooser);
		
		Date currentDate = new Date();
		compDateChooser = new JDateChooser(currentDate);
		compDateChooser.setBounds(324, 209, 225, 32);
		contentPane.add(compDateChooser);
	}
	
	protected void saveBlotter() throws ParseException {
			
		String complainant = complainantField.getText();
		int compAge = Integer.valueOf(compAgeField.getText());
		String compContact = compContactField.getText();
		String compAddress = compAddressField.getText();
		String person2Comp = person2compField.getText();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String compDate = df.format(compDateChooser.getDate());
		String compTime = timeCompField.getText();
		String incidenceDate = df.format(incidenceDateChooser.getDate());
		String incidenceTime = incidenceTimeField.getText();
		int zoneNo = Integer.valueOf(zoneNoCombo.getSelectedItem().toString());
		String complaint = complaintField.getText();
		String compStatus = statusCombo.getSelectedItem().toString();

		Blotter tempBlotter = null;
	
		if (updateMode) {
			tempBlotter = previousBlotter;
			
			tempBlotter.setComplainant(complainant);
			tempBlotter.setCompAge(compAge);
			tempBlotter.setCompContact(compContact);
			tempBlotter.setCompAddress(compAddress);
			tempBlotter.setPerson2Comp(person2Comp);
			tempBlotter.setCompDate(compDate);
			tempBlotter.setCompTime(compTime);
			tempBlotter.setIncidenceDate(incidenceDate);
			tempBlotter.setIncidenceTime(incidenceTime);
			tempBlotter.setZoneNo(zoneNo);
			tempBlotter.setComplaint(complaint);
			tempBlotter.setCompStatus(compStatus);
			
		} else {
			tempBlotter = new Blotter(complainant, compAge, compContact, compAddress, person2Comp, compDate, compTime, incidenceDate,  
					incidenceTime, zoneNo, complaint, compStatus);
		}

			try {
				if (updateMode) {
					dao.updateBlotter(tempBlotter);
				} else {
					dao.addBlotter(tempBlotter);
				}

				// close dialog
				setVisible(false);
				dispose();

				// refresh gui list
				panel.refreshBlotterTable();
			
				// show success message
				JOptionPane.showMessageDialog(panel,
						"Blotter added succesfully.",
						"Blotter Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				System.out.println(exc);
				JOptionPane.showMessageDialog(
						panel,
						"Error saving blotter: "
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
				saveBlotter();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

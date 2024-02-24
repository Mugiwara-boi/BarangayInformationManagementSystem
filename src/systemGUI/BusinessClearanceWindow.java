package systemGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.toedter.calendar.JDateChooser;
import javax.swing.DropMode;

@SuppressWarnings("serial")
public class BusinessClearanceWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private DAO dao;
	private JTextField busiNameField;
	private JTextField busiAddressField;
	private JTextField busiOwnerField;
	private JDateChooser termEndChooser;
	private JButton closeButton;
	private JButton saveButton;
	private JTextField contactField;
	private FormPanel panel;
	private BusinessClearance previousBusinessClearance;
	private boolean updateMode = false;
	private JDateChooser dateChooser;
	private JComboBox busiTypeField;
	private String[] typeChoice = {"Sole proprietorship", "Partnership","Limited Liability Company","Corporation","Cooperative"};
	
	public BusinessClearanceWindow(FormPanel panel, DAO dao, BusinessClearance previousBusinessClearance, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousBusinessClearance = previousBusinessClearance;
		
		this.updateMode  = updateMode;

	}
	public BusinessClearanceWindow(FormPanel panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public BusinessClearanceWindow() {
		
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}

		this.setType(Type.POPUP);
		this.setTitle("Create Business Clearance");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 424, 614);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		JLabel resIdLabel = new JLabel("Date of Issuance");
		resIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		resIdLabel.setBounds(29, 32, 150, 13);
		contentPane.add(resIdLabel);
		
		JLabel fnLabel = new JLabel("Business Name");
		fnLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fnLabel.setBounds(29, 109, 124, 13);
		contentPane.add(fnLabel);
		
		busiNameField = new JTextField();
		busiNameField.setBackground(Color.WHITE);
		busiNameField.setForeground(Color.BLACK);
		busiNameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		busiNameField.setBounds(29, 132, 352, 32);
		contentPane.add(busiNameField);
		busiNameField.setColumns(10);
		
		JLabel posLabel = new JLabel("Business Address");
		posLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		posLabel.setBounds(29, 186, 124, 13); 
		contentPane.add(posLabel);
		
		busiAddressField = new JTextField();
		busiAddressField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		busiAddressField.setBounds(29, 209, 352, 32);
		contentPane.add(busiAddressField);
		
		JLabel chmanshipLabel = new JLabel("Business Owner");
		chmanshipLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chmanshipLabel.setBounds(29, 263, 135, 13);
		contentPane.add(chmanshipLabel);
		
		busiOwnerField = new JTextField();
		busiOwnerField.setBackground(Color.WHITE);
		busiOwnerField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		busiOwnerField.setBounds(29, 286, 352, 32);
		contentPane.add(busiOwnerField);
		
		JLabel startLabel = new JLabel("Contact Number");
		startLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		startLabel.setBounds(29, 340, 124, 13);
		contentPane.add(startLabel);
		
		JLabel endLabel = new JLabel("Type of Business");
		endLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		endLabel.setBounds(29, 417, 150, 13);
		contentPane.add(endLabel);
		
		
		closeButton = new JButton("Close");
		closeButton.addActionListener(this);
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.setBounds(123, 537, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.setBounds(257, 537, 124, 29);
		contentPane.add(saveButton);
		
		Date currentDate = new Date();
		dateChooser = new JDateChooser(currentDate);
		dateChooser.setBounds(29, 55, 352, 32);
		contentPane.add(dateChooser);
		
		busiTypeField = new JComboBox(typeChoice);
		busiTypeField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		busiTypeField.setBounds(29, 440, 352, 32);
		contentPane.add(busiTypeField);
		
		contactField = new JTextField();
		contactField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contactField.setBackground(Color.WHITE);
		contactField.setBounds(29, 363, 352, 32);
		contentPane.add(contactField);
	}
	
	protected void saveBusinessClearance() throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(dateChooser.getDate());
		String businessName = busiNameField.getText();
		String busiAddress = busiAddressField.getText();
		String busiOwner = busiOwnerField.getText();
		String contactNumber = contactField.getText();
		String busiType = busiTypeField.getSelectedItem().toString();
		
		BusinessClearance tempBusinessClearance = null;

		tempBusinessClearance = new BusinessClearance(date, businessName, busiAddress, busiOwner, contactNumber, busiType);

		try {
			dao.addBusinessClearance(tempBusinessClearance);
			setVisible(false);
			dispose();

			// refresh gui list
			panel.refreshBusinessClearanceTable();
			
					// show success message
			JOptionPane.showMessageDialog(panel, "Business Clearance added succesfully.",
						"Business Clearance Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				System.out.println(exc);
				JOptionPane.showMessageDialog(
						panel,
						"Error saving business clearance: "
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
				saveBusinessClearance();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}

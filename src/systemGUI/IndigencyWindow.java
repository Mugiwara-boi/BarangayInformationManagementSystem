package systemGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;

public class IndigencyWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField fullnameField;
	private JButton closeButton;
	private JButton saveButton;
    DAO dao;
	private FormPanel panel;
	private JComboBox residentIdBox;
	private JDateChooser dateChooser;
	private JTextField addressField;
	private JTextField ageField;
	private JTextField sexField;
	private JTextField civilStatField;
	private Indigency previousIndigency;
	private boolean updateMode;
	
	public IndigencyWindow(FormPanel panel, DAO dao, Indigency previousIndigency, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousIndigency = previousIndigency;
		
		this.updateMode = updateMode;

	}
	public IndigencyWindow(FormPanel panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public IndigencyWindow() {
		try {
			dao = new DAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setResizable(false);
		//panel = new FormPanel();
		
		this.setType(Type.POPUP);
		this.setTitle("Create Indigency");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 605, 481);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		JLabel cmplnntLabel = new JLabel("Resident ID");
		cmplnntLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cmplnntLabel.setBounds(40, 32, 92, 13);
		contentPane.add(cmplnntLabel);
		
		fullnameField = new JTextField();
		fullnameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fullnameField.setBounds(324, 132, 225, 32);
		contentPane.add(fullnameField);
		
		sexField = new JTextField();
		sexField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sexField.setBounds(324, 211, 225, 32);
		contentPane.add(sexField);
		
		civilStatField = new JTextField();
		civilStatField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		civilStatField.setBounds(40, 211, 225, 32);
		contentPane.add(civilStatField);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ageField.setBounds(40, 287, 225, 32);
		contentPane.add(ageField);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		addressField.setBounds(40, 132, 225, 32);
		contentPane.add(addressField);
		
		residentIdBox = new JComboBox();
		residentIdBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					dao.fillAllResident(residentIdBox, addressField, fullnameField, civilStatField, sexField, ageField);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		residentIdBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		residentIdBox.setBounds(40, 55, 225, 32);
		contentPane.add(residentIdBox);
		
		
		JLabel vctmLabel = new JLabel("Address");
		vctmLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		vctmLabel.setBounds(40, 109, 144, 13);
		contentPane.add(vctmLabel);
		
		try {
			dao.fillComboResident(residentIdBox);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel rspndntLabel = new JLabel("Issuance Date");
		rspndntLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rspndntLabel.setBounds(324, 33, 130, 13);
		contentPane.add(rspndntLabel);
		
		JLabel locLabel = new JLabel("Full Name");
		locLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		locLabel.setBounds(324, 109, 144, 13);
		contentPane.add(locLabel);
		
		
		JLabel dateLabel = new JLabel("Sex");
		dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dateLabel.setBounds(324, 187, 144, 13);
		contentPane.add(dateLabel);
		
		JLabel timeLabel = new JLabel("Civil Status");
		timeLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		timeLabel.setBounds(40, 187, 144, 13);
		contentPane.add(timeLabel);
		
		
		closeButton = new JButton("Close");
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(310, 405, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setBounds(444, 405, 124, 29);
		contentPane.add(saveButton);
		
		
		JLabel statusLabel_1 = new JLabel("Age");
		statusLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		statusLabel_1.setBounds(40, 264, 130, 13);
		contentPane.add(statusLabel_1);
		
		Date currentDate = new Date();
		dateChooser = new JDateChooser(currentDate);
		dateChooser.setBounds(324, 55, 225, 32);
		contentPane.add(dateChooser);
	}
	
	protected void saveIndigency() throws ParseException {
		
		int residentId = (int) residentIdBox.getSelectedItem();	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(dateChooser.getDate());
		String address = addressField.getText();
		String fullName = fullnameField.getText();
		String civilStat = civilStatField.getText();
		String sex = sexField.getText();
		int age = Integer.valueOf(ageField.getText());
		
		Indigency tempIndigency = null;

		tempIndigency = new Indigency(residentId, date, address, fullName, civilStat, sex, age);

		try {
			dao.addIndigency(tempIndigency);
			setVisible(false);
			dispose();

			// refresh gui list
			panel.refreshIndigencyTable();
			
					// show success message
			JOptionPane.showMessageDialog(panel, "Indigency added succesfully.",
						"Indigency Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				System.out.println(exc);
				JOptionPane.showMessageDialog(
						panel,
						"Error saving indigency: "
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
				saveIndigency();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

package systemGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;

public class ResidencyWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private DAO dao;
	private FormPanel panel;
	private Residency previousResidency = null;
	private boolean updateMode = false;
	private JTextField fullNameField;
	private JTextField purposeField;
	private JComboBox residentIdCombo;
	private JDateChooser dateChooser;
	private JButton closeButton;
	private JButton saveButton;
	
	public ResidencyWindow(FormPanel panel, DAO dao, Residency previousResidency, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousResidency = previousResidency;
		
		this.updateMode  = updateMode;

	}
	public ResidencyWindow(FormPanel panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public ResidencyWindow() {
		try {
			dao = new DAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setResizable(false);
		this.setType(Type.POPUP);
		this.setTitle("Create Certificate of Residency");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 436, 481);
		
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fnLabel = new JLabel("Resident ID");
		fnLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fnLabel.setBounds(33, 32, 81, 13);
		contentPane.add(fnLabel);
		
		fullNameField = new JTextField();
		fullNameField.setEditable(false);
		fullNameField.setBackground(Color.WHITE);
		fullNameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fullNameField.setBounds(33, 132, 352, 32);
		contentPane.add(fullNameField);
		
		residentIdCombo = new JComboBox();
		residentIdCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					dao.fillTextResident(residentIdCombo, fullNameField);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		residentIdCombo.setBackground(Color.WHITE);
		residentIdCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		residentIdCombo.setBounds(33, 55, 352, 32);
		contentPane.add(residentIdCombo);
		
		try {
			dao.fillComboResident(residentIdCombo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel prpsLabel = new JLabel("Full Name");
		prpsLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		prpsLabel.setBounds(33, 109, 132, 13);
		contentPane.add(prpsLabel);
		
		JLabel dateLabel = new JLabel("Date of Issuance");
		dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dateLabel.setBounds(33, 186, 148, 13);
		contentPane.add(dateLabel);
		
		JLabel orLabel = new JLabel("Purpose");
		orLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		orLabel.setBounds(33, 263, 81, 13);
		contentPane.add(orLabel);
		
		purposeField = new JTextField();
		purposeField.setBackground(Color.WHITE);
		purposeField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		purposeField.setBounds(33, 286, 352, 32);
		contentPane.add(purposeField);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.setBounds(288, 405, 124, 29);
		contentPane.add(saveButton);
		
		closeButton = new JButton("Close");
		closeButton.addActionListener(this);
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.setBounds(154, 405, 124, 29);
		contentPane.add(closeButton);
		
		Date currentDate = new Date();
		dateChooser = new JDateChooser(currentDate);
		dateChooser.setBounds(33, 209, 352, 32);
		contentPane.add(dateChooser);
	}
	protected void saveResidency() throws ParseException {
		
		int residentId = (int) residentIdCombo.getSelectedItem();
		String fullName = fullNameField.getText();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(dateChooser.getDate());
		String purpose = purposeField.getText();
		
		
		Residency tempResidency = null;

		tempResidency = new Residency(residentId, fullName, date, purpose);

		try {
			dao.addResidency(tempResidency);
			setVisible(false);
			dispose();

			// refresh gui list
			panel.refreshResidencyTable();
			
					// show success message
			JOptionPane.showMessageDialog(panel, "Residency added succesfully.",
						"Residency Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				System.out.println(exc);
				JOptionPane.showMessageDialog(
						panel,
						"Error saving residency: "
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
				saveResidency();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}


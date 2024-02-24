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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class BarangayClearanceWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private DAO dao;
	private JTextField fullNameField;
	private JComboBox residentIdCombo;
	private JTextField addressField;
	private JDateChooser termEndChooser;
	private JButton closeButton;
	private JButton saveButton;
	private FormPanel panel;
	private BarangayClearance previousBarangayClearance;
	private boolean updateMode = false;
	private JDateChooser dateChooser;
	
	public BarangayClearanceWindow(FormPanel panel, DAO dao, BarangayClearance previousBarangayClearance, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousBarangayClearance = previousBarangayClearance;
		
		this.updateMode  = updateMode;

	}
	public BarangayClearanceWindow(FormPanel panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public BarangayClearanceWindow() {
		
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}

		this.setType(Type.POPUP);
		this.setTitle("Create Barangay Clearance");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 424, 475);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		JLabel resIdLabel = new JLabel("Resident ID");
		resIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		resIdLabel.setBounds(29, 32, 150, 13);
		contentPane.add(resIdLabel);
		
		JLabel fnLabel = new JLabel("Full Name");
		fnLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fnLabel.setBounds(29, 109, 124, 13);
		contentPane.add(fnLabel);
		
		fullNameField = new JTextField();
		fullNameField.setEditable(false);
		fullNameField.setBackground(Color.WHITE);
		fullNameField.setForeground(Color.BLACK);
		fullNameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fullNameField.setBounds(29, 132, 352, 32);
		contentPane.add(fullNameField);
		fullNameField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setEditable(false);
		addressField.setBackground(Color.WHITE);
		addressField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		addressField.setBounds(29, 286, 352, 32);
		contentPane.add(addressField);
		
		JLabel posLabel = new JLabel("Date of Issuance");
		posLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		posLabel.setBounds(29, 186, 150, 13); 
		contentPane.add(posLabel);
		
		residentIdCombo = new JComboBox();
		residentIdCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					dao.fillAllResident(residentIdCombo, fullNameField, addressField);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		residentIdCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		residentIdCombo.setBounds(29, 55, 352, 32);
		contentPane.add(residentIdCombo);
		
		try {
			dao.fillComboResident(residentIdCombo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel chmanshipLabel = new JLabel("Address");
		chmanshipLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chmanshipLabel.setBounds(29, 263, 135, 13);
		contentPane.add(chmanshipLabel);

		
		closeButton = new JButton("Close");
		closeButton.addActionListener(this);
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.setBounds(123, 397, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.setBounds(257, 397, 124, 29);
		contentPane.add(saveButton);
		
		Date currentDate = new Date();
		dateChooser = new JDateChooser(currentDate);
		dateChooser.setBounds(29, 209, 352, 32);
		contentPane.add(dateChooser);
	}
	
	protected void saveBarangayClearance() throws ParseException {
		
		int residentId = (int) residentIdCombo.getSelectedItem();	
		String fullName = fullNameField.getText();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(dateChooser.getDate());
		String address = addressField.getText();
		
		BarangayClearance tempBarangayClearance = null;

		tempBarangayClearance = new BarangayClearance(residentId, fullName, date, address);

		try {
			dao.addBarangayClearance(tempBarangayClearance);
			setVisible(false);
			dispose();

			// refresh gui list
			panel.refreshBarangayClearanceTable();
			
					// show success message
			JOptionPane.showMessageDialog(panel, "Barangay clearance added succesfully.",
						"Barangay Clearance Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				System.out.println(exc);
				JOptionPane.showMessageDialog(
						panel,
						"Error saving barangay clearance: "
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
				saveBarangayClearance();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}

package systemGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class BarangayInfoWindow extends JFrame implements ActionListener{

	private DAO dao;
	private BrgyInfoPanel panel;
	private BarangayInfo previousInfo = null;
	private boolean updateMode = false;
	private String filename = null;
	private byte[] logoImage = null;
	private ImageIcon imageIcon;
	private JPanel contentPane;
	private JButton closeButton;
	private JButton saveButton;
	private JButton browseButton;
	private JLabel brgyNameLabel;
	private JTextField brgyNameField;
	private JLabel cityLabel;
	private JTextField cityField;
	private JLabel stateLabel;
	private JTextField stateField;
	private JLabel contactLabel;
	private JTextField contactField;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel logoLabel;
	
	public BarangayInfoWindow(BrgyInfoPanel panel, DAO dao, BarangayInfo previousInfo, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousInfo = previousInfo;
		
		this.updateMode = updateMode;

		if (updateMode) {
			setTitle("Update BarangayInformation");
			
			try {
				populateGui(previousInfo);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void populateGui(BarangayInfo previousInfo) throws ParseException {		
		ImageIcon image = new ImageIcon(previousInfo.getBarangayLogo());
		Image im = image.getImage();
		Image myImg = im.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(myImg);
		logoLabel.setIcon(newImage);
		//logoLabel.setIcon(imageIcon);
		brgyNameField.setText(previousInfo.getBarangayName());
		cityField.setText(previousInfo.getCity());
		stateField.setText(previousInfo.getState());
		contactField.setText(previousInfo.getContact());
		emailField.setText(previousInfo.getEmail());
	}

	public BarangayInfoWindow(BrgyInfoPanel panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public BarangayInfoWindow() {
		setResizable(false);
		this.setType(Type.POPUP);
		this.setLocationRelativeTo(null);
		this.setTitle("Edit Barangay Information");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 424, 816);
		
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel brgyLogoLabel = new JLabel("Barangay Logo");
		brgyLogoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		brgyLogoLabel.setBounds(29, 32, 120, 13);
		contentPane.add(brgyLogoLabel);
		
		logoLabel = new JLabel();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		logoLabel.setBorder(border);
		logoLabel.setBounds(68, 55, 273, 200);
		contentPane.add(logoLabel);
		
		brgyNameLabel = new JLabel("Barangay ");
		brgyNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		brgyNameLabel.setBounds(29, 316, 120, 13);
		contentPane.add(brgyNameLabel);
		
		brgyNameField = new JTextField((String) null);
		brgyNameField.setForeground(Color.BLACK);
		brgyNameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		brgyNameField.setColumns(10);
		brgyNameField.setBackground(Color.WHITE);
		brgyNameField.setBounds(29, 339, 352, 32);
		contentPane.add(brgyNameField);
		
		cityLabel = new JLabel("City");
		cityLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cityLabel.setBounds(29, 393, 120, 13);
		contentPane.add(cityLabel);
		
		cityField = new JTextField();
		cityField.setForeground(Color.BLACK);
		cityField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cityField.setColumns(10);
		cityField.setBackground(Color.WHITE);
		cityField.setBounds(29, 416, 352, 32);
		contentPane.add(cityField);
		
		stateLabel = new JLabel("State");
		stateLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		stateLabel.setBounds(29, 470, 120, 13);
		contentPane.add(stateLabel);
		
		stateField = new JTextField();
		stateField.setForeground(Color.BLACK);
		stateField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		stateField.setColumns(10);
		stateField.setBackground(Color.WHITE);
		stateField.setBounds(29, 493, 352, 32);
		contentPane.add(stateField);
		
		contactLabel = new JLabel("Contact");
		contactLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contactLabel.setBounds(29, 547, 120, 13);
		contentPane.add(contactLabel);
		
		contactField = new JTextField();
		contactField.setForeground(Color.BLACK);
		contactField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contactField.setColumns(10);
		contactField.setBackground(Color.WHITE);
		contactField.setBounds(29, 570, 352, 32);
		contentPane.add(contactField);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		emailLabel.setBounds(29, 628, 120, 13);
		contentPane.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setForeground(Color.BLACK);
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		emailField.setColumns(10);
		emailField.setBackground(Color.WHITE);
		emailField.setBounds(29, 651, 352, 32);
		contentPane.add(emailField);
		
		
		browseButton = new JButton("Browse");
		browseButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		browseButton.setFocusable(false);
		browseButton.addActionListener(this);
		browseButton.setBounds(138, 265, 124, 29);
		contentPane.add(browseButton);
		
		closeButton = new JButton("Close");
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(123, 739, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setBounds(257, 739, 124, 29);
		contentPane.add(saveButton);
	}

	protected void saveInfo() throws ParseException {

		// get the employee info from gui
		byte[] brgyLogo = logoImage;
		String brgyName = brgyNameField.getText();
		String city = cityField.getText();
		String state = stateField.getText();
		String contact = contactField.getText();
		String email = emailField.getText();
		

		BarangayInfo tempInfo = null;
		
		tempInfo = previousInfo;
		
		tempInfo.setBarangayLogo(brgyLogo);
		tempInfo.setBarangayName(brgyName);
		tempInfo.setCity(city);
		tempInfo.setState(state);
		tempInfo.setContact(contact);
		tempInfo.setEmail(email);
		
		try {
			dao.updateInfo(tempInfo);
			setVisible(false);
			dispose();
			
			panel.fillInfo(dao);
			//BrgyInfoPanel infoPanel = new BrgyInfoPanel();
			//JTextArea id = infoPanel.brgyIdField;
			//dao.fillInfo(infoPanel.brgyIdField, infoPanel.logoLabel, infoPanel.brgyNameField, infoPanel.cityField, infoPanel.stateField, infoPanel.contactField, infoPanel.emailField);
			
		} catch (Exception exc) {
		
		JOptionPane.showMessageDialog(panel,"Error saving information: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == browseButton) {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File file = chooser.getSelectedFile();
			filename = file.getAbsolutePath();
			imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH));
			logoLabel.setIcon(imageIcon);
			try {
				File image = new File(filename);
				FileInputStream fis = new FileInputStream(image);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				for(int i; (i = fis.read(buf)) != -1;) {
					bos.write(buf, 0, i);
				}
				logoImage = bos.toByteArray();
			}
			catch(Exception exc){
				JOptionPane.showMessageDialog(panel,"Error saving image: "+ exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == closeButton) {
			this.dispose();
		}
		if(e.getSource() == saveButton) {
			try {
				saveInfo();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}

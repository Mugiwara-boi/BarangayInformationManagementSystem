package systemGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class BrgyInfoPanel extends JPanel{

	 private DAO dao;
	 private Connection conn;
	 JLabel logoLabel;
	 JTextArea brgyIdField;
	 JTextArea brgyNameField;
	 JTextArea cityField;
	 JTextArea stateField;
	 JTextArea contactField;
	 JTextArea emailField;
	 JLabel brgyLogoLabel;
	 private JButton editButton;
	
	public BrgyInfoPanel() {
		
		try {
				dao = new DAO();
				conn = dao.getConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		this.setLayout(null);
		this.setBounds(65, 87, 1287, 659);
		this.setBackground(Color.WHITE);
		
		Color color = Color.decode("#0C2D48");

		logoLabel = new JLabel();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		logoLabel.setBorder(border);
		logoLabel.setBounds(110, 237, 273, 200);
		this.add(logoLabel);
		
		JLabel hdrLabel = new JLabel("Barangay Information");
		hdrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hdrLabel.setForeground(color);
		hdrLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		hdrLabel.setBounds(0, 35, 1287, 43);
		this.add(hdrLabel);
		
		JLabel brgyIdLabel = new JLabel("Barangay ID :");
		brgyIdLabel.setForeground(color);
		brgyIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		brgyIdLabel.setBounds(456, 168, 120, 29);
		this.add(brgyIdLabel);
		
		brgyIdField = new JTextArea();
		brgyIdField.setEditable(false);
		brgyIdField.setForeground(color);
		brgyIdField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		brgyIdField.setBounds(602, 173, 620, 36);
		this.add(brgyIdField);
		brgyIdField.setColumns(10);
		
		JLabel brgyNameLabel = new JLabel("Barangay      :");
		brgyNameLabel.setForeground(color);
		brgyNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		brgyNameLabel.setBounds(456, 240, 120, 29);
		this.add(brgyNameLabel);
		
		brgyNameField = new JTextArea();
		brgyNameField.setEditable(false);
		brgyNameField.setForeground(color);
		brgyNameField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		brgyNameField.setColumns(10);
		brgyNameField.setBounds(602, 245, 620, 36);
		this.add(brgyNameField);
		
		JLabel cityLabel = new JLabel("City                :");
		cityLabel.setForeground(color);
		cityLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cityLabel.setBounds(456, 312, 120, 29);
		this.add(cityLabel);
		
		cityField = new JTextArea();
		cityField.setForeground(color);
		cityField.setEditable(false);
		cityField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cityField.setColumns(10);
		cityField.setBounds(602, 317, 620, 36);
		this.add(cityField);
		
		stateField = new JTextArea();
		stateField.setForeground(color);
		stateField.setEditable(false);
		stateField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		stateField.setColumns(10);
		stateField.setBounds(602, 386, 620, 36);
		this.add(stateField);
		
		contactField = new JTextArea();
		contactField.setForeground(color);
		contactField.setEditable(false);
		contactField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contactField.setColumns(10);
		contactField.setBounds(602, 461, 620, 36);
		this.add(contactField);
		
		emailField = new JTextArea();
		emailField.setForeground(color);
		emailField.setEditable(false);
		emailField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		emailField.setColumns(10);
		emailField.setBounds(602, 533, 620, 36);
		this.add(emailField);
		
		JLabel stateLabel = new JLabel("State               :");
		stateLabel.setForeground(color);
		stateLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		stateLabel.setBounds(456, 384, 120, 29);
		this.add(stateLabel);
		
		JLabel contactLabel = new JLabel("Contact          :");
		contactLabel.setForeground(color);
		contactLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contactLabel.setBounds(456, 456, 124, 29);
		this.add(contactLabel);
		
		JLabel emailLabel = new JLabel("Email              :");
		emailLabel.setForeground(color);
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		emailLabel.setBounds(456, 528, 120, 29);
		this.add(emailLabel);
		
		brgyLogoLabel = new JLabel("Barangay Logo:");
		brgyLogoLabel.setForeground(color);
		brgyLogoLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		brgyLogoLabel.setBounds(110, 198, 139, 29);
		this.add(brgyLogoLabel);
		
		editButton = new JButton("Edit Information");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarangayInfo tempInfo = null;
				try {
					tempInfo = dao.getInfo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BarangayInfoWindow infoPopup = new BarangayInfoWindow(BrgyInfoPanel.this, dao, tempInfo, true);
				infoPopup.setVisible(true);
			}
		});
		editButton.setForeground(color);
		editButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		editButton.setFocusable(false);
		editButton.setBounds(993, 601, 183, 29);
		this.add(editButton);
		
		try {
			//dao.fillInfo(brgyIdField, logoLabel, brgyNameField, cityField, stateField, contactField, emailField);
			fillInfo(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void fillInfo(DAO dao) {	
		Statement state = null;
		ResultSet result = null;
		
		try {
			state = conn.createStatement();
			result = state.executeQuery("select * from tb_brgyinfo");	// change this
			
			while (result.next()) {
				BarangayInfo tempInfo = dao.convertRowToInfo(result);
				brgyIdField.setText(String.valueOf(tempInfo.getId()));
				ImageIcon image = new ImageIcon(tempInfo.getBarangayLogo());
				Image im = image.getImage();
				Image myImg = im.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage = new ImageIcon(myImg);
				logoLabel.setIcon(newImage);
				brgyNameField.setText(tempInfo.getBarangayName());
				cityField.setText(tempInfo.getCity());
				stateField.setText(tempInfo.getState());
				contactField.setText(tempInfo.getContact());
				emailField.setText(tempInfo.getEmail());	
			}
		}
		catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showInputDialog(this);
		}
	}
}

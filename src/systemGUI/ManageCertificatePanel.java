package systemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ManageCertificatePanel extends JPanel implements ActionListener{

	JTable table;
	JLabel hdrPanel;
	JButton clearanceButton;
	JButton residencyButton;
	JButton indiButton;
	JButton permitButton;
	
	public ManageCertificatePanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		this.setBackground(new Color(0, 128, 128));
		this.setBounds(250, 55, 1092, 677);
		this.setLayout(null);
		
		String[] columnNames = {"Name", "Transaction Type", "Date Issued", "Date Expired", "O.R. Number"};
		Object[][] data = {{"Asdadas", "Presiding Officer", "qeqw", "ds", "asdasd"}};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(250,250));
		//table.setFillsViewportHeight(true);
		//table.setBackground(new Color(0, 128, 128));
		//table.setBounds(1081, 102, -1070, 565);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(1077, 508);
		scroll.setLocation(7, 148);
		table.setFillsViewportHeight(true);
		this.add(scroll);
		
		hdrPanel = new JLabel("Manage Certificate");
		hdrPanel.setForeground(new Color(255, 255, 255));
		hdrPanel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		hdrPanel.setBounds(22, 22, 214, 31);
		this.add(hdrPanel);
		
		
		clearanceButton = new JButton("Clearance");
		clearanceButton.setForeground(new Color(0, 128, 128));
		//addButton.setBackground(new Color(0, 255, 0));
		clearanceButton.addActionListener(this);
		clearanceButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		clearanceButton.setFocusable(false);
		clearanceButton.setBounds(356, 109, 165, 29);
		this.add(clearanceButton);
				
		indiButton = new JButton("Indigency");
		indiButton.setForeground(new Color(0, 128, 128));
		//updButton.setBackground(Color.CYAN);
		indiButton.addActionListener(this);
		indiButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		indiButton.setFocusable(false);
		indiButton.setBounds(706, 109, 183, 29);
		this.add(indiButton);
		
		permitButton = new JButton("Business Permit");
		permitButton.setForeground(new Color(0, 128, 128));
		//viewButton.setBackground(Color.YELLOW);
		permitButton.addActionListener(this);
		permitButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		permitButton.setFocusable(false);
		permitButton.setBounds(531, 109, 165, 29);
		this.add(permitButton);
		
		residencyButton = new JButton("Residency");
		residencyButton.setForeground(new Color(0, 128, 128));
		//delButton.setBackground(Color.RED);
		residencyButton.addActionListener(this);
		residencyButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		residencyButton.setFocusable(false);
		residencyButton.setBounds(899, 109, 183, 29);
		this.add(residencyButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

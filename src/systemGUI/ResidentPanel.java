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


@SuppressWarnings("serial")
public class ResidentPanel extends JPanel implements ActionListener{

	JTable table;
	JButton btnAddRes;
	JButton btnUpdateRes;
	
	public ResidentPanel() {
		
		this.setBounds(250, 55, 1092, 677);
		this.setLayout(null);
		
		
		String[] columnNames = {"Full Name", "Age", "Civil Status", "Gender", "Zone","Voter Status"};
		Object[][] data = {{"Vinn Eizen Agbay", "19", "Single", "Male", "Zone 3", "Yes"}};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(250,250));
		//table.setFillsViewportHeight(true);
		//table.setBackground(new Color(0, 128, 128));
		//table.setBounds(1081, 102, -1070, 565);
		
		JScrollPane resScroll = new JScrollPane(table);
		resScroll.setSize(1077, 500);
		resScroll.setLocation(7, 148);
		table.setFillsViewportHeight(true);
		this.add(resScroll);
		
		JLabel hdrResPanel = new JLabel("RESIDENT RECORDS");
		hdrResPanel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		hdrResPanel.setBounds(7, 10, 214, 31);
		this.add(hdrResPanel);
		
		btnAddRes = new JButton("ADD");
		btnAddRes.addActionListener(this);
		btnAddRes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddRes.setFocusable(false);
		btnAddRes.setBounds(125, 109, 124, 29);
		this.add(btnAddRes);
		
		JButton btnDeleteRes = new JButton("DELETE");
		btnDeleteRes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeleteRes.setFocusable(false);
		btnDeleteRes.setBounds(480, 109, 124, 29);
		this.add(btnDeleteRes);
		
		btnUpdateRes = new JButton("UPDATE");
		btnUpdateRes.addActionListener(this);
		btnUpdateRes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdateRes.setFocusable(false);
		btnUpdateRes.setBounds(300, 109, 124, 29);
		this.add(btnUpdateRes);
		
		JButton btnViewRes = new JButton("VIEW ALL");
		btnViewRes.addActionListener(this);
		btnViewRes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnViewRes.setFocusable(false);
		btnViewRes.setBounds(660, 109, 124, 29);
		this.add(btnViewRes);
		
		//this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAddRes) {
			ResidentWindow popup = new ResidentWindow();
			popup.setVisible(true);
		}
		if(e.getSource() == btnUpdateRes) {
			ResidentWindow popup = new ResidentWindow();
			popup.setVisible(true);
		}
	}

}

package systemGUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ChairmanshipPanel extends JPanel implements ActionListener{
	
	JTable table;
	JButton btnAddChmanship;
	JButton btnDelChmanship;
	JButton btnUpdChmanship;
	JButton btnViewChmanship;
	
	public ChairmanshipPanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		this.setBackground(new Color(0, 128, 128));
		this.setBounds(250, 55, 1092, 677);
		this.setLayout(null);
		
		String[] columnNames = {"No.", "Title"};
		Object[][] data = {{"1", "Presiding Officer"}};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(250,250));
		//table.setFillsViewportHeight(true);
		//table.setBackground(new Color(0, 128, 128));
		//table.setBounds(1081, 102, -1070, 565);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(1077, 500);
		scroll.setLocation(7, 148);
		table.setFillsViewportHeight(true);
		this.add(scroll);
		
		JLabel hdrChmanshipPanel = new JLabel("Chairmanship");
		hdrChmanshipPanel.setForeground(new Color(255, 255, 255));
		hdrChmanshipPanel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		hdrChmanshipPanel.setBounds(22, 22, 214, 31);
		this.add(hdrChmanshipPanel);
		
		
		btnAddChmanship = new JButton("Add Chairmanship");
		btnAddChmanship.setBackground(new Color(0, 255, 0));
		btnAddChmanship.addActionListener(this);
		btnAddChmanship.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddChmanship.setFocusable(false);
		btnAddChmanship.setBounds(531, 109, 165, 29);
		this.add(btnAddChmanship);
		
		btnDelChmanship = new JButton("Delete Chairmanship");
		btnDelChmanship.setBackground(Color.RED);
		btnDelChmanship.addActionListener(this);
		btnDelChmanship.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelChmanship.setFocusable(false);
		btnDelChmanship.setBounds(899, 109, 183, 29);
		this.add(btnDelChmanship);
		
		btnUpdChmanship = new JButton("Update Chairmanship");
		btnUpdChmanship.setBackground(Color.CYAN);
		btnUpdChmanship.addActionListener(this);
		btnUpdChmanship.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdChmanship.setFocusable(false);
		btnUpdChmanship.setBounds(706, 109, 183, 29);
		this.add(btnUpdChmanship);
		
		//btnViewChmanship = new JButton("VIEW ALL");
		//btnViewChmanship.addActionListener(this);
		//btnViewChmanship.setFont(new Font("Times New Roman", Font.BOLD, 16));
		//btnViewChmanship.setFocusable(false);
		//btnViewChmanship.setBounds(660, 109, 124, 29);
		//this.add(btnViewChmanship);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAddChmanship) {
			ChairmanshipWindow popup = new ChairmanshipWindow();
			popup.setVisible(true);
		}
		if(e.getSource() == btnUpdChmanship) {
			ChairmanshipWindow popup = new ChairmanshipWindow();
			popup.UpdateChairmanship();
			popup.setVisible(true);
		}
	}
}

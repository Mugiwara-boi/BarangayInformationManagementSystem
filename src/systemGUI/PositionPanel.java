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

public class PositionPanel extends JPanel implements ActionListener{

	JTable table;
	JButton btnAddPosition;
	JButton btnDelPosition;
	JButton btnUpdPosition;
	JButton btnViewChmanship;

	public PositionPanel() {
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
		
		JLabel hdrPositionPanel = new JLabel("Position");
		hdrPositionPanel.setForeground(new Color(255, 255, 255));
		hdrPositionPanel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		hdrPositionPanel.setBounds(22, 22, 214, 31);
		this.add(hdrPositionPanel);
		
		
		btnAddPosition = new JButton("Add Position");
		btnAddPosition.setBackground(new Color(0, 255, 0));
		btnAddPosition.addActionListener(this);
		btnAddPosition.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddPosition.setFocusable(false);
		btnAddPosition.setBounds(531, 109, 165, 29);
		this.add(btnAddPosition);
		
		btnDelPosition = new JButton("Delete Position");
		btnDelPosition.setBackground(Color.RED);
		btnDelPosition.addActionListener(this);
		btnDelPosition.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelPosition.setFocusable(false);
		btnDelPosition.setBounds(899, 109, 183, 29);
		this.add(btnDelPosition);
		
		btnUpdPosition = new JButton("Update Position");
		btnUpdPosition.setBackground(Color.CYAN);
		btnUpdPosition.addActionListener(this);
		btnUpdPosition.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdPosition.setFocusable(false);
		btnUpdPosition.setBounds(706, 109, 183, 29);
		this.add(btnUpdPosition);
		
		//btnViewChmanship = new JButton("VIEW ALL");
		//btnViewChmanship.addActionListener(this);
		//btnViewChmanship.setFont(new Font("Times New Roman", Font.BOLD, 16));
		//btnViewChmanship.setFocusable(false);
		//btnViewChmanship.setBounds(660, 109, 124, 29);
		//this.add(btnViewChmanship);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAddPosition) {
			PositionWindow popup = new PositionWindow();
			popup.setVisible(true);
		}
		if(e.getSource() == btnUpdPosition) {
			PositionWindow popup = new PositionWindow();
			popup.UpdatePosition();
			popup.setVisible(true);
		}
	}

}

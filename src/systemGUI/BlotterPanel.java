package systemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BlotterPanel extends JPanel{
	
	JTable table;
	JLabel hdrLabel;
	JButton addButton;
	JButton delButton;
	JButton updButton;
	BlotterWindow blotPopup;
	String header;
    DAO dao;
    ResidentTableModel resiModel;
    OffStaffTableModel offstaffModel;
    HouseholdTableModel householdModel;
	protected MemberWindow memPopup;
	BlotterTableModel blotterModel;
	
	public BlotterPanel() {
		
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		this.setLayout(null);
		this.setBounds(65, 87, 1287, 659);
		this.setBackground(Color.WHITE);
		
		Color color = Color.decode("#0C2D48");
		
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(250,250));
		table.setFillsViewportHeight(true);
		
		
		refreshBlotterTable();
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 198, 1266, 455);
		this.add(scroll);
		table.setFillsViewportHeight(true);
		
		hdrLabel = new JLabel("Blotter Records");
		hdrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hdrLabel.setForeground(color);
		hdrLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		hdrLabel.setBounds(0, 20, 1287, 43);
		this.add(hdrLabel);
		
		addButton = new JButton("Add Blotter");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlotterWindow blotPopup = new BlotterWindow(BlotterPanel.this, dao);
				blotPopup.setVisible(true);
			}
		});
		addButton.setForeground(color);
		addButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		addButton.setFocusable(false);
		addButton.setBounds(918, 156, 165, 29);
		this.add(addButton);
				
		updButton = new JButton("Update Blotter");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(BlotterPanel.this, "You must select a blotter record", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				Blotter tempBlotter =  (Blotter) table.getValueAt(row, -1);
				BlotterWindow blotPopup = new BlotterWindow(BlotterPanel.this, dao, tempBlotter, true);
				blotPopup.setVisible(true);
			}
		});
		
		updButton.setForeground(color);
		updButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		updButton.setFocusable(false);
		updButton.setBounds(1093, 156, 183, 29);
		this.add(updButton);
	}
	
	public void refreshBlotterTable() {
		try {
			List<Blotter> blotters = dao.getAllBlotter();
			blotterModel = new BlotterTableModel(blotters);

			table.setModel(blotterModel);
		} catch (Exception exc) {
			System.out.println(exc);
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
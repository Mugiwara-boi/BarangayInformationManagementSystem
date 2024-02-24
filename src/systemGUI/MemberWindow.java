package systemGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberWindow extends JFrame {
	
	private static MemberWindow window;
	private MemberTableModel memModel;
	private DAO dao;
	private JPanel contentPane;
	private JTable table;
	private int householdNo;
	private String householdNoStr;
	

	public MemberWindow(int householdNo) {
		
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		this.householdNo = householdNo;
		
		setResizable(false);
		this.setType(Type.POPUP);
		this.setLocationRelativeTo(null);
		this.setTitle("Household Members");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 865, 491);
		
		Color color = Color.decode("#089DE3");
		
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setPreferredScrollableViewportSize(new Dimension(250,250));
		table.setFillsViewportHeight(true);
		
		refreshMemberTable();
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 82, 831, 295);
		getContentPane().add(scroll);
		table.setFillsViewportHeight(true);
		
		
		householdNoStr = String.valueOf(householdNo);
		JLabel noLabel = new JLabel("Household No. :   " + householdNoStr);
		noLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		noLabel.setForeground(Color.BLACK);
		noLabel.setBounds(10, 29, 471, 43);
		contentPane.add(noLabel);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.setBounds(717, 415, 124, 29);
		contentPane.add(closeButton);
		
	}
	
	public void refreshMemberTable() {
		try {
			List<Resident> residents = dao.getAllMembers(householdNo);
			memModel = new MemberTableModel(residents);

			table.setModel(memModel);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}

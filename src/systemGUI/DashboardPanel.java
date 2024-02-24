package systemGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class DashboardPanel extends JPanel implements ActionListener{
	
	DAO dao;
	int resiCount;
	int maleCount;
	int femaleCount;
	int vtrCount;
	private int nonvtrCount;
	private int settledCount;
	private int unsettledCount;
	private int scheduledCount;
	private int hhCount;
	
	public DashboardPanel() {
		
		try {
			dao = new DAO();
			hhCount = dao.getCount("select count(*) from tb_household");
			resiCount = dao.getCount("select count(*) from tb_resident");
			maleCount = dao.getCount("select count(*) from tb_resident where sex='male'");
			femaleCount = dao.getCount("select count(*) from tb_resident where sex='female'");
			vtrCount = dao.getCount("select count(*) from tb_resident where voterStat='voter'");
			nonvtrCount = dao.getCount("select count(*) from tb_resident where voterStat='non-voter'");
			settledCount = dao.getCount("select count(*) from tb_blotter where complainStatus = 'Settled'");
			unsettledCount = dao.getCount("select count(*) from tb_blotter where complainStatus = 'Unsettled'");
			scheduledCount = dao.getCount("select count(*) from tb_blotter where complainStatus = 'Scheduled'");
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		//this.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		this.setBackground(Color.WHITE);
		this.setBounds(65, 87, 1287, 659);
		this.setLayout(null);
		
		Color color = Color.decode("#0C2D48");
		
		JLabel hdrLabel = new JLabel("DASHBOARD");
		hdrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//hdrLabel.setBackground(new Color(255, 255, 255));
		hdrLabel.setForeground(color);
		hdrLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		hdrLabel.setBounds(0, 20, 1287, 43);
		this.add(hdrLabel);
		
		JLabel nameLabel = new JLabel("Barangay Hulo");
		nameLabel.setForeground(color);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		nameLabel.setBounds(42, 67, 214, 31);
		this.add(nameLabel);
		
		JLabel locLabel1 = new JLabel("Hulo, Mandaluyong City, Metro Manila");
		locLabel1.setForeground(color);
		locLabel1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		locLabel1.setBounds(42, 89, 402, 31);
		this.add(locLabel1);
		
		DbPanels hhPanel = new DbPanels("/household.png", "Total Household", hhCount);
		hhPanel.setBounds(40, 140, 192, 109);
		this.add(hhPanel);
		
		DbPanels popuPanel = new DbPanels("/population.png", "Total Population", resiCount);
		popuPanel.setBounds(366, 140, 192, 109);
		this.add(popuPanel);
		
		DbPanels malePanel = new DbPanels("/male.png", "Male", maleCount);
		malePanel.setBounds(692, 140, 192, 109);		//+76
		this.add(malePanel);
		
		DbPanels femalePanel = new DbPanels("/female.png", "Female", femaleCount);
		femalePanel.setBounds(1018, 140, 192, 109);		//+76
		this.add(femalePanel);
		
		DbPanels voterPanel = new DbPanels("/voter.png", "Total Voters", vtrCount);
		voterPanel.setBounds(42, 317, 192, 109);		//+76
		this.add(voterPanel);
		
		DbPanels nonvoterPanel = new DbPanels("/voter.png", "Total Nonvoters", nonvtrCount);
		nonvoterPanel.setBounds(366, 317, 192, 109);		//+76
		this.add(nonvoterPanel);
		
		JLabel summaryLabel = new JLabel("BLOTTER RECORD SUMMARY");
		summaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		summaryLabel.setForeground(color);
		summaryLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		summaryLabel.setBounds(0, 461, 1092, 31);
		//summaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(summaryLabel);
		
		DbPanels settledPanel = new DbPanels("Settled Cases", String.valueOf(settledCount) , new Color(0, 0, 153));
		settledPanel.setBounds(42, 530, 192, 109);		//+76
		this.add(settledPanel);
		
		DbPanels unsettledPanel = new DbPanels("Unsettled Cases", String.valueOf(unsettledCount), new Color(204, 0, 51));
		unsettledPanel.setBounds(366, 530, 192, 109);		//+76
		this.add(unsettledPanel);
		
		DbPanels schedPanel = new DbPanels("Scheduled Cases", String.valueOf(scheduledCount), new Color(255, 153, 51));
		schedPanel.setBounds(692, 530, 192, 109);		//+76
		this.add(schedPanel);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

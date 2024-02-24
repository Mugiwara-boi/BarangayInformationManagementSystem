package systemGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class HomeWindowFinal extends JFrame {

	private JPanel contentPane;
	public HomeWindowFinal home;
	Cursor cursor;
	JPanel currentPanel;
	PanelClass resiPanel;
	PanelClass hhPanel;
	PanelClass offPanel;
	BrgyInfoPanel infoPanel;
	DashboardPanel dbPanel;
	MenuPanel menu;
	MenuLabel dbLabel;
	MenuLabel resLabel;
	MenuLabel hhLabel;
	MenuLabel offLabel;
	MenuLabel blotLabel;
	MenuLabel revLabel;
	MenuLabel indigencyLabel;
	MenuLabel clrncLabel;
	MenuLabel permitLabel;
	MenuLabel rsdncyLabel;
	BlotterPanel blotPanel;
	private DAO dao;
	private MenuLabel infoLabel;
	private MenuLabel outLabel;
	private FormPanel indigencyPanel;
	private FormPanel residencyPanel;
	private FormPanel busiClearancePanel;
	Font roboto;
	protected FormPanel brgyClearancePanel;
	
	
	
	public HomeWindowFinal() {
		
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
			 
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Home");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1366, 784);
		
		Color color = Color.decode("#274472");
		
		//JLabel[] labels = {dbLabel, resLabel, hhLabel, offLabel, blotLabel, revLabel, indigencyLabel, clrncLabel, permitLabel, rsdncyLabel};
		contentPane = new JPanel();
		contentPane.setBackground(color);		
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu = new MenuPanel();
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menu.setBounds(0, 87, 240, 659);
				menu.g2d.fillRect(0, 87, getWidth(), getHeight());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu.setBounds(0, 87, 66, 659);
				menu.g2d.fillRect(0, 87, getWidth(), getHeight());
			}
		});
		getContentPane().add(menu);
		
		infoLabel = new MenuLabel(45, 45, "/info.png", "", 1201, 14, 66, 57);
		infoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentPanel.setVisible(false);
				revalidate();
				infoPanel = new BrgyInfoPanel();        
				contentPane.add(infoPanel);
				currentPanel = infoPanel;
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				cursor = new Cursor(Cursor.HAND_CURSOR); 
			    setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cursor = new Cursor(Cursor.DEFAULT_CURSOR); 
			    setCursor(cursor);
			}
		});
		//setChoosable(infoLabel);
		contentPane.add(infoLabel);
		
		
		outLabel = new MenuLabel(45, 47, "/logout.png", "", 1276, 12, 66, 57);
		outLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(home,
			            "Are you sure you want to logout?", "Logout Confirmation",
			            JOptionPane.YES_NO_OPTION);
			        if (result == JOptionPane.YES_OPTION)
			          HomeWindowFinal.this.dispose();
			        else if (result == JOptionPane.NO_OPTION)
			          home.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				cursor = new Cursor(Cursor.HAND_CURSOR); 
			    setCursor(cursor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cursor = new Cursor(Cursor.DEFAULT_CURSOR); 
			    setCursor(cursor);
			}
		});
		//setChoosable(outLabel);
		contentPane.add(outLabel);
		
		dbLabel = new MenuLabel(50, 50, "/dashboard.png", "Dashboard", -51, 0, 300, 55);
		dbLabel.setSize(339, 55);
		dbLabel.setLocation(-89, 0);
		setChoosable(dbLabel);
		menu.add(dbLabel);
		
		resLabel = new MenuLabel(50, 50, "/residentss.png", "Resident Records", -51, 0, 300, 55);
		resLabel.setLocation(-50, 65);
		setChoosable(resLabel);
		menu.add(resLabel);
		
		hhLabel = new MenuLabel(50, 50, "/households.png", "Household Records", -41, 66, 291, 55);
		hhLabel.setLocation(-41, 130);
		setChoosable(hhLabel);
		menu.add(hhLabel);
		
		offLabel = new MenuLabel(55, 55, "/officials.png", "Officials and Staffs", -45, 132, 301, 55);
		offLabel.setLocation(-45, 195);
		setChoosable(offLabel);
		menu.add(offLabel);
		
		blotLabel = new MenuLabel(50, 50, "/blotter.png", "Blotter Records", -47, 198, 291, 55);
		blotLabel.setLocation(-47, 260);
		setChoosable(blotLabel);
		menu.add(blotLabel);
		
	//	revLabel = new MenuLabel(46, 46, "/revenues.png", "Revenue Records", -45, 264, 287, 55);
	//	revLabel.setLocation(-45, 325);
	//	setChoosable(revLabel);
	//	menu.add(revLabel);
		
		indigencyLabel = new MenuLabel(50, 50, "/indigency.png", "Certificate of Indigency", -11, 330, 261, 55);
		indigencyLabel.setLocation(-7, 325); //-11, 390
		setChoosable(indigencyLabel);
		menu.add(indigencyLabel);
		
		clrncLabel = new MenuLabel(50, 50, "/clearance.png", "Barangay Clearance", -26, 396, 276, 55);
		clrncLabel.setLocation(-29, 390); // -29, 455
		setChoosable(clrncLabel);
		menu.add(clrncLabel);
		
		permitLabel = new MenuLabel(50, 50, "/permit.png", "Business Clearance", -43, 462, 291, 55);
		permitLabel.setLocation(-28, 455); // -46, 520
		setChoosable(permitLabel);
		menu.add(permitLabel);
		
		rsdncyLabel = new MenuLabel(50, 50, "/residency.png", "Certificate of Residency", -11, 528, 261, 55);
		rsdncyLabel.setLocation(-2, 520); // -11, 585
		setChoosable(rsdncyLabel);
		menu.add(rsdncyLabel); 
		
		ImageIcon panelIcon = new ImageIcon(this.getClass().getResource("/HULO.png"));
		Image tempImage = panelIcon.getImage();
		Image panelImage = tempImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		panelIcon = new ImageIcon(panelImage);
		
		JLabel lblNewLabel = new JLabel("Barangay Information Management System");
		lblNewLabel.setIcon(panelIcon);
		lblNewLabel.setIconTextGap(20);
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblNewLabel.setBounds(41, 0, 935, 87);
		contentPane.add(lblNewLabel);
		
		dbPanel = new DashboardPanel();
		this.getContentPane().add(dbPanel);
		
		currentPanel = dbPanel;
			
	}
	
	public void setChoosable(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cursor = new Cursor(Cursor.HAND_CURSOR); 
			    setCursor(cursor);
				menu.setBounds(0, 87, 240, 659);
				menu.g2d.fillRect(0, 87, getWidth(), getHeight());
				label.setBackground(Color.LIGHT_GRAY);
				label.setOpaque(true);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//JLabel[] labels = {dbLabel, resLabel, hhLabel, 
				//		offLabel, blotLabel, revLabel, indigencyLabel, clrncLabel, permitLabel, rsdncyLabel};
				if(e.getSource() == resLabel) {
					currentPanel.setVisible(false);
					revalidate();
					resiPanel = new PanelClass("Resident Records", "Add Resident", "Update Resident", "Delete Resident");        
					//resiPanel.refreshTable();
					contentPane.add(resiPanel);
					currentPanel = resiPanel;
			
				}
				if(e.getSource() == dbLabel) {
					currentPanel.setVisible(false);
					revalidate();
					dbPanel = new DashboardPanel();                      
					contentPane.add(dbPanel);
					currentPanel = dbPanel;
				}
				if(e.getSource() == hhLabel) {
					currentPanel.setVisible(false);
					revalidate();
					hhPanel = new PanelClass("Household Records", "Add Household", "Update Household", "Delete Household"); 
					contentPane.add(hhPanel);
					currentPanel = hhPanel;
				}
		
				if(e.getSource() ==	offLabel) {
					currentPanel.setVisible(false);
					revalidate();
					offPanel = new PanelClass("Barangay Officials And Staffs Records", "Add Official/Staff", "Update Official/Staff", "Delete Official/Staff");        
					//resiPanel.refreshTable();
					contentPane.add(offPanel);
					currentPanel = offPanel;
				}
				if(e.getSource() == blotLabel) {
					currentPanel.setVisible(false);
					revalidate();
					blotPanel = new BlotterPanel();
					contentPane.add(blotPanel);
					currentPanel = blotPanel;
				}
				if(e.getSource() == indigencyLabel) {
					currentPanel.setVisible(false);
					revalidate();
					indigencyPanel = new FormPanel("Certificate of Indigency", "Add Indigency");
					contentPane.add(indigencyPanel);
					currentPanel = indigencyPanel;
				}
				if(e.getSource() == clrncLabel) {
					currentPanel.setVisible(false);
					revalidate();
					brgyClearancePanel = new FormPanel("Barangay Clearance", "Add Clearance");
					contentPane.add(brgyClearancePanel);
					currentPanel = brgyClearancePanel;
				}
				if(e.getSource() ==	permitLabel) {
					currentPanel.setVisible(false);
					revalidate();
					busiClearancePanel = new FormPanel("Barangay Business Clearance", "Add Clearance");
					contentPane.add(busiClearancePanel);
					currentPanel = busiClearancePanel;
				}
				if(e.getSource() == rsdncyLabel) {
					currentPanel.setVisible(false);
					revalidate();
					residencyPanel = new FormPanel("Certificate of Residency", "Add Residency");
					contentPane.add(residencyPanel);
					currentPanel = residencyPanel;
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cursor = new Cursor(Cursor.DEFAULT_CURSOR); 
			    setCursor(cursor);
				menu.setBounds(0, 87, 66, 659);
				menu.g2d.fillRect(0, 87, getWidth(), getHeight());
				label.setBackground(Color.decode("#5885AF"));	//"#00FFFF"
			}
		});
	}	
	/*
	public static void main(String[] args) throws Exception {
		 

		 home = new HomeWindowFinal();
		 home.setVisible(true);
		 
		  
	}*/
}


    

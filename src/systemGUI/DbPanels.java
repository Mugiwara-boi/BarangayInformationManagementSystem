package systemGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class DbPanels extends JPanel{
	/**
	 * @wbp.parser.constructor
	 */
	public DbPanels(String path, String hdr,  int count) {	
		this.setLayout(null);
		
		Color color = Color.decode("#41729F");
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new LineBorder(color, 3));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setOpaque(true);
		contentPanel.setBounds(0, 0, 192, 109);
		contentPanel.setLayout(null);
		this.add(contentPanel);
		
		ImageIcon panelIcon = new ImageIcon(this.getClass().getResource(path));
		Image tempImage = panelIcon.getImage();
		Image panelImage = tempImage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		panelIcon = new ImageIcon(panelImage);
		
		JLabel hdrLabel = new JLabel(hdr);
		hdrLabel.setIcon(panelIcon);
		hdrLabel.setIconTextGap(10);
		hdrLabel.setBounds(0, 5, 192, 94);
		hdrLabel.setVerticalAlignment(SwingConstants.TOP);
		hdrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hdrLabel.setForeground(new Color(255, 255, 255));
		hdrLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		contentPanel.add(hdrLabel);
		
		
		String strCount =String.valueOf(count);
		
		JLabel cntLabel = new JLabel(strCount);
		cntLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cntLabel.setForeground(color);
		cntLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		cntLabel.setBounds(10, 35, 172, 64);
		contentPanel.add(cntLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(color);
		panel.setBounds(0, 0, 192, 35);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		

	}
	
	public DbPanels(String head, String count, Color color) {
		this.setLayout(null);
		//this.setBackground(Color.WHITE);
		//this.setOpaque(true);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new LineBorder(color, 3));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setOpaque(true);
		contentPanel.setBounds(0, 0, 192, 109);
		contentPanel.setLayout(null);
		this.add(contentPanel);
		
		JLabel hdrLabel = new JLabel();
		hdrLabel.setBounds(0, 0, 192, 94);
		hdrLabel.setVerticalAlignment(SwingConstants.TOP);
		hdrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//hdrLabel.setForeground(new Color(255, 255, 255));
		//hdrLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPanel.add(hdrLabel);
		
		JLabel cntLabel = new JLabel(count);
		cntLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cntLabel.setForeground(color);
		cntLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		cntLabel.setBounds(10, 35, 172, 64);
		contentPanel.add(cntLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(color);
		panel.setBounds(0, 0, 192, 35);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(head);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 5, 172, 20);
		panel.add(lblNewLabel);

	}
	

}

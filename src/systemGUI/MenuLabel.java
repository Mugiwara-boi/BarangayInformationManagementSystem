package systemGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuLabel extends JLabel {

	/**
	 * Create the panel.
	 */
	
	public MenuLabel(int xScale, int yScale, String path, String label, int x, int y, int width, int height) {
		
		ImageIcon panelIcon = new ImageIcon(this.getClass().getResource(path));
		Image tempImage = panelIcon.getImage();
		Image panelImage = tempImage.getScaledInstance(xScale, yScale, java.awt.Image.SCALE_SMOOTH);
		panelIcon = new ImageIcon(panelImage);
		
		/*JLabel hdrLabel = new JLabel(label);
		hdrLabel.setIcon(panelIcon);
		hdrLabel.setIconTextGap(18);
		hdrLabel.setBounds(x, y, width, height);
		hdrLabel.setForeground(new Color(255, 255, 255));
		hdrLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));*/
		
		this.setText(label);
		this.setIcon(panelIcon);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setIconTextGap(18);
		this.setBounds(x, y, width, height);
		this.setForeground(new Color(255, 255, 255));
		this.setFont(new Font("SansSerif", Font.BOLD, 15));
		
	
	}

}

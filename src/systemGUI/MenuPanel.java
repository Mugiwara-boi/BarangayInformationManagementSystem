package systemGUI;

import java.lang.Object;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuPanel extends JPanel { //implements MouseListener{
	
	Graphics2D g2d;
	//Animator animator;
	boolean entered;
	boolean exited;
	int x = 0;
	int y = 0;
	
	public MenuPanel() {
		
		this.setLayout(null);
		this.setBounds(0, 87, 66, 659);
		
	}
	
	public void paintComponent(Graphics g) {
		
		g2d = (Graphics2D) g;
		g2d.setPaint(Color.decode("#5885AF"));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
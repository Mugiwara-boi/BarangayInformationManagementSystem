package systemGUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginWindow implements ActionListener{

	private JFrame frame;
	private final JLabel titleLabel = new JLabel("BARANGAY MANAGEMENT SYSTEM");
	private JTextField usrField;
	private JPasswordField pwField;
	private JButton loginButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Color color = Color.decode("#274472");
				
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#5885AF"));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1366, 784);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/HULO.png"));
		Image image = imageIcon.getImage();
		Image newImage = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newImage);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setForeground(new Color(255, 255, 255));

		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		titleLabel.setBounds(314, 136, 758, 53);
		frame.getContentPane().add(titleLabel);
		
		JLabel iconLabel = new JLabel();
		iconLabel.setBackground(new Color(240, 240, 240));
		iconLabel.setIcon(imageIcon);
		iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iconLabel.setBounds(169, 100, 137, 127);
		frame.getContentPane().add(iconLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		panel.setBounds(337, 295, 595, 293);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel headerNewLabel = new JLabel("   Login");
		headerNewLabel.setForeground(Color.WHITE);
		headerNewLabel.setBackground(color);
		headerNewLabel.setOpaque(true);
		headerNewLabel.setBounds(0, 0, 595, 38);
		panel.add(headerNewLabel);
		headerNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel usrLabel = new JLabel("Username:");
		usrLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		usrLabel.setBounds(57, 79, 86, 31);
		panel.add(usrLabel);
		
		JLabel pwLabel = new JLabel("Password:");
		pwLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pwLabel.setBounds(57, 136, 86, 31);
		panel.add(pwLabel);
		
		usrField = new JTextField();
		usrField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		usrField.setBounds(167, 81, 349, 31);
		panel.add(usrField);
		usrField.setColumns(10);
		
		loginButton = new JButton("Login");
		loginButton.setFocusable(false);
		loginButton.setBackground(color);
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		loginButton.addActionListener(this);
		loginButton.setBounds(167, 198, 97, 31);
		panel.add(loginButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setFocusable(false);
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clearButton.setBackground(color);
		clearButton.setBounds(419, 198, 97, 31);
		panel.add(clearButton);
		
		pwField = new JPasswordField();
		pwField.setEchoChar('*');
		pwField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pwField.setBounds(167, 138, 349, 31);
		panel.add(pwField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			frame.dispose();
			HomeWindowFinal home = new HomeWindowFinal();
			home.setVisible(true);
			
		}
		
	}
}

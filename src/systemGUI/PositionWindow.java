package systemGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PositionWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField titleField;
	private JButton closeButton;
	private JButton saveButton;

	public PositionWindow() {
		this.setType(Type.POPUP);
		this.setTitle("Add Position");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 436, 403);
		
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleField = new JTextField("Enter Position");
		titleField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		titleField.setBounds(121, 72, 157, 32);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		JLabel titleLabel = new JLabel("Position");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		titleLabel.setBounds(173, 49, 81, 13);
		contentPane.add(titleLabel);
		
		closeButton = new JButton("Close");
		closeButton.setBackground(Color.RED);
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(154, 327, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.setBackground(Color.GREEN);
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setBounds(288, 327, 124, 29);
		contentPane.add(saveButton);
	}
	public void UpdatePosition() {
		this.setTitle("Update Positioin");
		
	}
	
	public void DeleteChairmanship() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton) {
			this.dispose();
		}
	}
}

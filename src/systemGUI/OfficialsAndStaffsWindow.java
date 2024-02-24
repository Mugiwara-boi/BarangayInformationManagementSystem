package systemGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class OfficialsAndStaffsWindow extends JFrame implements ActionListener{
	
	private DAO dao;
	private OfficialAndStaff previousOffStaff = null;
	private boolean updateMode = false;
	private PanelClass panel;
	private JPanel contentPane;
	private JComboBox fnCombo;
	private JComboBox resIdCombo;
	private JComboBox posCombo;
	private JComboBox statCombo;
	private JButton closeButton;
	private JButton saveButton;
	private JDateChooser termStartChooser;
	private JDateChooser termEndChooser;
	private String[] statChoice = {"Active", "Inactive"};
	private JTextField fnField;
	private JTextField chmanshipField;
	private String fullName;
	private String chairmanship;
	//private String[] posiOpt = {"Secretary", "Treasurer"};
	//private List<Resident> names;
	
	public OfficialsAndStaffsWindow(PanelClass panel, DAO dao, OfficialAndStaff previousOffStaff, boolean updateMode) {
		this();
		this.dao = dao;
		this.panel = panel;

		this.previousOffStaff = previousOffStaff;
		
		this.updateMode = updateMode;

		if (updateMode) {
			setTitle("Update Official and Staff");
			
			try {
				populateGui(previousOffStaff);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void populateGui(OfficialAndStaff offstaff) throws ParseException {
		resIdCombo.setSelectedItem(String.valueOf(offstaff.getResidentId()));
		fnField.setText(offstaff.getFullName());
		posCombo.setSelectedItem(offstaff.getPosition());
		chmanshipField.setText(offstaff.getChairmanship());
		termStartChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse((String)offstaff.getTermStart()));
		termEndChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse((String)offstaff.getTermEnd()));
		statCombo.setName(offstaff.getStatus());	
	}

	public OfficialsAndStaffsWindow(PanelClass panel, DAO dao) {
		this(panel, dao, null, false);
	}
	
	public OfficialsAndStaffsWindow() {
		try {
			dao = new DAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		this.setType(Type.POPUP);
		this.setTitle("Add Official");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 424, 738);
		
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel resIdLabel = new JLabel("Resident ID");
		resIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		resIdLabel.setBounds(29, 32, 81, 13);
		contentPane.add(resIdLabel);
		
		resIdCombo = new JComboBox();
		resIdCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					dao.fillTextResident(resIdCombo, fnField);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		resIdCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		resIdCombo.setBounds(29, 55, 352, 32);
		contentPane.add(resIdCombo);
		
		JLabel fnLabel = new JLabel("Fullname");
		fnLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fnLabel.setBounds(29, 109, 99, 13);
		contentPane.add(fnLabel);
		
		fnField = new JTextField(fullName);
		fnField.setEditable(false);
		fnField.setBackground(Color.WHITE);
		fnField.setForeground(Color.BLACK);
		fnField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fnField.setBounds(29, 132, 352, 32);
		contentPane.add(fnField);
		fnField.setColumns(10);
		
		JLabel posLabel = new JLabel("Position");
		posLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		posLabel.setBounds(29, 186, 99, 13); 
		contentPane.add(posLabel);
		
		try {
			dao.fillComboResident(resIdCombo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		posCombo = new JComboBox();
		posCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					dao.fillTextChairmanship(posCombo, chmanshipField);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		posCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		posCombo.setBounds(29, 209, 352, 32);
		contentPane.add(posCombo);
		
		AutoCompleteDecorator.decorate(resIdCombo);
		AutoCompleteDecorator.decorate(posCombo);
		
		JLabel chmanshipLabel = new JLabel("Chairmanship");
		chmanshipLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chmanshipLabel.setBounds(29, 263, 99, 13);
		contentPane.add(chmanshipLabel);
		
		chmanshipField = new JTextField();
		chmanshipField.setEditable(false);
		chmanshipField.setBackground(Color.WHITE);
		chmanshipField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		chmanshipField.setColumns(10);
		chmanshipField.setBounds(29, 286, 352, 32);
		contentPane.add(chmanshipField);
		
		try {
			dao.fillComboPosition(posCombo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel startLabel = new JLabel("Term Start");
		startLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		startLabel.setBounds(29, 340, 99, 13);
		contentPane.add(startLabel);
		
		termStartChooser = new JDateChooser();
		termStartChooser.setBounds(29, 363, 352, 32);
		contentPane.add(termStartChooser);
		
		JLabel endLabel = new JLabel("Term End");
		endLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		endLabel.setBounds(29, 417, 99, 13);
		contentPane.add(endLabel);
		
		termEndChooser = new JDateChooser();
		termEndChooser.setBounds(29, 440, 352, 32);
		contentPane.add(termEndChooser);
		
		JLabel statLabel = new JLabel("Status");
		statLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		statLabel.setBounds(29, 494, 99, 13);
		contentPane.add(statLabel);
		
		statCombo = new JComboBox(statChoice);
		statCombo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		statCombo.setBounds(29, 517, 352, 32);
		contentPane.add(statCombo);
		
		closeButton = new JButton("Close");
		closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		closeButton.setBounds(123, 662, 124, 29);
		contentPane.add(closeButton);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setBounds(257, 662, 124, 29);
		contentPane.add(saveButton);
		
	}
	protected void saveOffStaff() throws ParseException {
	
		int residentId = (int) resIdCombo.getSelectedItem();	
		String fullName = fnField.getText();
		String position = posCombo.getSelectedItem().toString();
		String chairmanship = chmanshipField.getText();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String termStart = df.format(termStartChooser.getDate());
		String termEnd = df.format(termEndChooser.getDate());
		String status = statCombo.getSelectedItem().toString();

		OfficialAndStaff tempOffStaff = null;

		if (updateMode) {
			tempOffStaff = previousOffStaff;
			
			tempOffStaff.setResidentId(residentId);
			tempOffStaff.setFullName(fullName);
			tempOffStaff.setPosition(position);
			tempOffStaff.setChairmanship(chairmanship);
			tempOffStaff.setTermStart(termStart);
			tempOffStaff.setTermEnd(termEnd);
			tempOffStaff.setStatus(status);
			
		} else {
			tempOffStaff = new OfficialAndStaff(residentId, fullName, position, chairmanship, termStart, termEnd, status);
		}

			try {
				if (updateMode) {
					dao.updateOffStaff(tempOffStaff);
				} else {
					dao.addOffStaff(tempOffStaff);
				}

				// close dialog
				setVisible(false);
				dispose();

				// refresh gui list
				panel.refreshOffStaffTable();
			
				// show success message
				JOptionPane.showMessageDialog(panel,
						"Official/Staff added succesfully.",
						"Official/Staff Added",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				System.out.println(exc);
				JOptionPane.showMessageDialog(
						panel,
						"Error saving official/staff: "
								+ exc.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton) {
			this.dispose();
		}
		if(e.getSource() == saveButton) {
			try {
				saveOffStaff();
				System.out.print(posCombo.getSelectedItem());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
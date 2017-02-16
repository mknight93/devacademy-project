package hrproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.SQLiteConfig;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class holidayRequest extends JFrame {

	private JPanel contentPane;
	
	String month[];
	private JTextField txtStartYear;
	private JTextField txtEndYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					holidayRequest frame = new holidayRequest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public holidayRequest() {
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 390);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubmitALeave = new JLabel("Submit a Leave Request");
		lblSubmitALeave.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblSubmitALeave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmitALeave.setBounds(0, 0, 589, 61);
		contentPane.add(lblSubmitALeave);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblStartDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartDate.setBounds(71, 75, 131, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblReturnDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReturnDate.setBounds(71, 100, 131, 14);
		contentPane.add(lblReturnDate);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setBounds(71, 125, 131, 14);
		contentPane.add(lblReason);
		
		JLabel lblTerms = new JLabel("<html><center>\r\nPlease note that all leave requests are subject to your contract of employment.<br>\r\nHR reserves the right to deny any and all leave requests that are in breach of the terms of use of this service.\r\n</center></html>");
		lblTerms.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTerms.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerms.setBounds(0, 245, 589, 68);
		contentPane.add(lblTerms);
		
		JLabel lblInformation = new JLabel("Additional Information");
		lblInformation.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblInformation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInformation.setBounds(71, 150, 131, 14);
		contentPane.add(lblInformation);
		
		JComboBox cmbStartDate = new JComboBox();
		cmbStartDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbStartDate.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbStartDate.setBounds(212, 72, 46, 20);
		contentPane.add(cmbStartDate);
		
		JComboBox cmbStartMonth = new JComboBox();
		cmbStartMonth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbStartMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cmbStartMonth.setBounds(268, 72, 89, 20);
		contentPane.add(cmbStartMonth);
		
		JComboBox cmbReturnDate = new JComboBox();
		cmbReturnDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbReturnDate.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbReturnDate.setBounds(212, 97, 46, 20);
		contentPane.add(cmbReturnDate);
		
		JComboBox cmbReturnMonth = new JComboBox();
		cmbReturnMonth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbReturnMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cmbReturnMonth.setBounds(268, 97, 89, 20);
		contentPane.add(cmbReturnMonth);
		
		JComboBox cmbReason = new JComboBox();
		cmbReason.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbReason.setModel(new DefaultComboBoxModel(new String[] {"Holiday", "Maternity/Paternity Leave", "Grievance", "Other"}));
		cmbReason.setBounds(212, 122, 145, 20);
		contentPane.add(cmbReason);
		
		JTextArea txtInformation = new JTextArea();
		txtInformation.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtInformation.setBounds(212, 145, 235, 95);
		contentPane.add(txtInformation);
		txtInformation.setLineWrap(true);
		txtInformation.setWrapStyleWord(true);
		
		txtStartYear = new JTextField();
		txtStartYear.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtStartYear.setBounds(361, 72, 86, 20);
		contentPane.add(txtStartYear);
		txtStartYear.setColumns(10);
		
		txtEndYear = new JTextField();
		txtEndYear.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEndYear.setColumns(10);
		txtEndYear.setBounds(361, 97, 86, 20);
		contentPane.add(txtEndYear);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checks if text fields are empty and displays a message
				if(txtInformation.getText().isEmpty() || txtStartYear.getText().isEmpty() || txtEndYear.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must provide information regarding your absence.");
				// Checks if the year is valid for both dates
				} else if((int) Double.parseDouble(txtStartYear.getText()) < Calendar.getInstance().get(Calendar.YEAR) || 
						(int) Double.parseDouble(txtEndYear.getText()) < Calendar.getInstance().get(Calendar.YEAR)){
					JOptionPane.showMessageDialog(null, "The year entered for the start or end of this holiday is invalid. Please try again.");
				} else {
					// Creates two dates - start and end. Saves reason and additional info as variables
					String startDate = cmbStartDate.getSelectedItem().toString() + "-" + (cmbStartMonth.getSelectedIndex() + 1) + "-" + txtStartYear.getText();
					String endDate = cmbReturnDate.getSelectedItem().toString() + "-" + (cmbReturnMonth.getSelectedIndex() + 1) + "-" + txtEndYear.getText();
					String reason = cmbReason.getSelectedItem().toString();
					String additionalInfo = txtInformation.getText();
					
					// Creates query with created information
					String query =   "INSERT INTO holidayRequests " +
									" (REQUEST_EMPLOYEEID, REQUEST_STARTDATE, REQUEST_ENDDATE, REQUEST_REASON, REQUEST_INFO, REQUEST_RESOLVED)" +
									" VALUES (" +
									employeeInfo.loggedInUser.employeeNo + ", '" +
									startDate + "', '" +
									endDate + "', '" +
									reason + "', '" +
									additionalInfo + "', " +
									"0" + ");";
					
					try {
						requestSubmit(query);
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "There has been a problem submitting your holiday request.");
					}
				}
			}
		});
		btnSubmit.setBounds(187, 312, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holidayRequest.this.setVisible(false);	// Closes the current leave request window
				
				if(loginCheck.l.sessionMode == "Standard") {
					uiNormal u = new uiNormal();			// Creates a new instance of the UI
					u.setVisible(true);						// Opens the UI
				} else if(loginCheck.l.sessionMode == "HR") {
					uiHR u = new uiHR();
                    u.setVisible(true);
				} else if(loginCheck.l.sessionMode == "Management") {
					uiHR u = new uiHR();
                    u.setVisible(true);
				}
			}
		});
		btnCancel.setBounds(286, 312, 89, 23);
		contentPane.add(btnCancel);
	}
	
	private void requestSubmit(String qry) throws SQLException {
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			statement.executeUpdate(qry);

			JOptionPane.showMessageDialog(null, "Your holiday request has been submitted for review.");
			if(loginCheck.l.sessionMode == "Standard") {
				uiNormal u = new uiNormal();			// Creates a new instance of the UI
				holidayRequest.this.setVisible(false);	// Closes the current ticket submission window
				u.setVisible(true);						// Opens the UI
			} else if(loginCheck.l.sessionMode == "HR" || loginCheck.l.sessionMode == "Management") {
				uiHR u = new uiHR();					// Creates a new instance of the UI
				holidayRequest.this.setVisible(false);	// Closes the current ticket submission window
				u.setVisible(true);						// Opens the UI
			}
		} catch(Exception exc) {
			JOptionPane.showMessageDialog(null, "Your description is too long. (Maximum 200 characters)");
		} finally {
			statement.close();
			con.close();
		}
	}
}

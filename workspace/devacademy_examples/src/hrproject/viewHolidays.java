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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class viewHolidays extends JFrame {

	private JPanel contentPane;
	private JTextField txtSubmittedBy;
	private JTextField txtStartDate;
	private JTextField txtEndDate;
	private JTextField txtReason;
	
	String id[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewHolidays frame = new viewHolidays();
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
	public viewHolidays() {
		// Customise JOptionPane according to style
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 703);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewHolidayRequests = new JLabel("View Holiday Requests");
		lblViewHolidayRequests.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblViewHolidayRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewHolidayRequests.setBounds(10, 11, 536, 62);
		contentPane.add(lblViewHolidayRequests);
		
		JLabel lblSubmittedBy = new JLabel("Submitted by:");
		lblSubmittedBy.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSubmittedBy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubmittedBy.setBounds(10, 122, 188, 14);
		contentPane.add(lblSubmittedBy);
		
		JLabel lblStartDate = new JLabel("Start date:");
		lblStartDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblStartDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartDate.setBounds(10, 154, 188, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblReturnDate = new JLabel("Return date:");
		lblReturnDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblReturnDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReturnDate.setBounds(10, 178, 188, 14);
		contentPane.add(lblReturnDate);
		
		JLabel lblReasonForLeave = new JLabel("Reason for leave:");
		lblReasonForLeave.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblReasonForLeave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReasonForLeave.setBounds(10, 203, 188, 14);
		contentPane.add(lblReasonForLeave);
		
		JLabel lblAdditionalInformation = new JLabel("Additional Information:");
		lblAdditionalInformation.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAdditionalInformation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdditionalInformation.setBounds(10, 228, 188, 14);
		contentPane.add(lblAdditionalInformation);
		
		JLabel lblResponse = new JLabel("Response:");
		lblResponse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblResponse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResponse.setBounds(10, 442, 188, 14);
		contentPane.add(lblResponse);
		
		JLabel lblRequestStatus = new JLabel("Request Status:");
		lblRequestStatus.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRequestStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRequestStatus.setBounds(10, 409, 188, 14);
		contentPane.add(lblRequestStatus);
		
		JLabel lblSelectARequest = new JLabel("Select a request to view:");
		lblSelectARequest.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSelectARequest.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectARequest.setBounds(10, 84, 188, 14);
		contentPane.add(lblSelectARequest);
		
		txtSubmittedBy = new JTextField();
		txtSubmittedBy.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSubmittedBy.setEditable(false);
		txtSubmittedBy.setBounds(208, 119, 188, 20);
		contentPane.add(txtSubmittedBy);
		txtSubmittedBy.setColumns(10);
		
		txtStartDate = new JTextField();
		txtStartDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtStartDate.setEditable(false);
		txtStartDate.setColumns(10);
		txtStartDate.setBounds(208, 151, 188, 20);
		contentPane.add(txtStartDate);
		
		txtEndDate = new JTextField();
		txtEndDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEndDate.setEditable(false);
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(208, 175, 188, 20);
		contentPane.add(txtEndDate);
		
		txtReason = new JTextField();
		txtReason.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtReason.setEditable(false);
		txtReason.setColumns(10);
		txtReason.setBounds(208, 200, 188, 20);
		contentPane.add(txtReason);
		
		JComboBox cmbSelectRequest = new JComboBox();
		cmbSelectRequest.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbSelectRequest.setBounds(208, 81, 188, 20);
		contentPane.add(cmbSelectRequest);
		
		JComboBox cmbStatus = new JComboBox();
		cmbStatus.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"Accept", "Deny"}));
		cmbStatus.setBounds(208, 406, 302, 20);
		contentPane.add(cmbStatus);
		
		JTextArea txtDesc = new JTextArea();
		txtDesc.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtDesc.setEditable(false);
		txtDesc.setBounds(208, 223, 302, 172);
		contentPane.add(txtDesc);
		txtDesc.setLineWrap(true);
		txtDesc.setWrapStyleWord(true);
		
		JTextArea txtResponse = new JTextArea();
		txtResponse.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtResponse.setBounds(208, 437, 302, 172);
		contentPane.add(txtResponse);
		txtResponse.setLineWrap(true);
		txtResponse.setWrapStyleWord(true);
		
		JButton btnNewButton = new JButton("Send Response");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checks if response box is empty and displays a message
				if(txtResponse.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must provide a response to this holiday request.");
				} else {
					// Gets the response and status of the request
					String response = txtResponse.getText();
					String status = cmbStatus.getSelectedItem().toString();

					Connection con = null;
					Statement statement = null;
					try {
						Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
						SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
						config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
						con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
						
						statement = con.createStatement();
						
						// Create a query using the response and status. Sets request to resolved.
						String updateRequest =   "UPDATE holidayRequests SET REQUEST_RESPONSE = '" +
												response + "', REQUEST_ACCEPTED = '" + 
												status + "', REQUEST_RESOLVED = 1" + 
												" WHERE ROWID = " + id[0];
						
						statement.executeUpdate(updateRequest);
						
						JOptionPane.showMessageDialog(null, "Your response has been saved and this request has been marked as complete.");

						uiHR u = new uiHR();				// Creates a new instance of the UI
						viewHolidays.this.setVisible(false);	// Closes the current ticket viewing window
						u.setVisible(true);					// Opens the UI
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(null, "Your response is too long. (Maximum 200 characters)");
					} finally {
						try {
							statement.close();
							con.close();
						} catch (Exception exc2) {
							System.out.println(exc2);
						}
					}
				}
			}
		});
		btnNewButton.setBounds(133, 620, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uiHR u = new uiHR();				// Creates a new instance of the UI
				viewHolidays.this.setVisible(false);	// Closes the current ticket viewing window
				u.setVisible(true);					// Opens the UI
			}
		});
		btnCancel.setBounds(284, 620, 141, 23);
		contentPane.add(btnCancel);
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Gets the selected request from the combobox
				String selectedRequest = cmbSelectRequest.getSelectedItem().toString();
				// Gets the ID by splitting the string in combobox - id[0] is request ID
				id = selectedRequest.split(" ");
				
				Connection con = null;
				Statement statement = null;
				
				try {
					ResultSet rs = null;
					
					Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
					SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
					config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
					con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
					
					statement = con.createStatement();
					
					// Create query to find request based on row ID
					String getRequestInfo = "SELECT * FROM holidayRequests WHERE ROWID = " + id[0];
					
					rs = statement.executeQuery(getRequestInfo);
					
					// Saves fields from result set into variables
					int empID = rs.getInt("REQUEST_EMPLOYEEID");
					String startDate = rs.getString("REQUEST_STARTDATE");
					String endDate = rs.getString("REQUEST_ENDDATE");
					String reason = rs.getString("REQUEST_REASON");
					String info = rs.getString("REQUEST_INFO");
					
					// Create query using employee ID to find name
					String getEmployeeName = "SELECT EMPLOYEE_FORENAME, EMPLOYEE_SURNAME FROM employeeInfo " +
											" WHERE EMPLOYEE_ID = " + empID;
					
					rs = statement.executeQuery(getEmployeeName);
					
					// Gets the full name as a string
					String name = rs.getString("EMPLOYEE_FORENAME") + " " + rs.getString("EMPLOYEE_SURNAME"); 
							
					// Sets text fields to data retrieved from database
					txtSubmittedBy.setText(name);
					txtStartDate.setText(startDate);
					txtEndDate.setText(endDate);
					txtReason.setText(reason);
					txtDesc.setText(info);
				} catch (Exception exc) {
					System.out.println(exc);
				} finally {
					try {
						statement.close();
						con.close();
					} catch (Exception exc2) {
						System.out.println(exc2);
					}
				}
			}
		});
		btnGetDetails.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnGetDetails.setBounds(406, 80, 104, 23);
		contentPane.add(btnGetDetails);
		
		Connection con = null;
		Statement statement = null;
		
		try {
			ResultSet rs = null;

			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			String qry = "SELECT ROWID, * FROM holidayRequests WHERE " +
						" REQUEST_RESOLVED = 0 AND REQUEST_EMPLOYEEID != " + employeeInfo.loggedInUser.employeeNo;
			
			rs = statement.executeQuery(qry);
			
			while(rs.next()) {
				int requestID = rs.getInt("ROWID");
				int id = rs.getInt("REQUEST_EMPLOYEEID");
				String reason = rs.getString("REQUEST_REASON");
				
				cmbSelectRequest.addItem(requestID + " - " + reason + " (" + id + ")");
			}
		} catch(Exception exc) {
			System.out.println(exc);
		} finally {
			try {
				statement.close();
				con.close();
			} catch (Exception exc2) {
				System.out.println(exc2);
			}
		}
	}
}

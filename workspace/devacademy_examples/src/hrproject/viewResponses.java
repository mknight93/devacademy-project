package hrproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.SQLiteConfig;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class viewResponses extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewResponses frame = new viewResponses();
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
	public viewResponses() {
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 567);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewResponses = new JLabel("View Responses");
		lblViewResponses.setBounds(10, 11, 479, 57);
		lblViewResponses.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblViewResponses.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblViewResponses);
		
		JLabel lblSelectAResponse = new JLabel("Select a response to view:");
		lblSelectAResponse.setBounds(10, 79, 151, 14);
		lblSelectAResponse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectAResponse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		contentPane.add(lblSelectAResponse);
		
		JLabel lblYourQuery = new JLabel("Your query:");
		lblYourQuery.setBounds(10, 112, 151, 14);
		lblYourQuery.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblYourQuery.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblYourQuery);
		
		JLabel lblResponse = new JLabel("Response:");
		lblResponse.setBounds(10, 288, 151, 14);
		lblResponse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResponse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		contentPane.add(lblResponse);
		
		JComboBox cmbSelectResponse = new JComboBox();
		cmbSelectResponse.setBounds(171, 77, 187, 20);
		cmbSelectResponse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		contentPane.add(cmbSelectResponse);
		
		JTextArea txtQuery = new JTextArea();
		txtQuery.setBounds(171, 108, 318, 164);
		txtQuery.setEditable(false);
		txtQuery.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		contentPane.add(txtQuery);
		txtQuery.setLineWrap(true);
		txtQuery.setWrapStyleWord(true);
		
		JTextArea txtResponse = new JTextArea();
		txtResponse.setBounds(171, 284, 318, 194);
		txtResponse.setEditable(false);
		txtResponse.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		contentPane.add(txtResponse);
		txtResponse.setLineWrap(true);
		txtResponse.setWrapStyleWord(true);
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.setBounds(368, 75, 121, 23);
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedResponse = cmbSelectResponse.getSelectedItem().toString();
				String info[] = selectedResponse.split(" ");
				// Type is info[0] and ID is info[2]
				
				// If the type of the response is holiday, load info from holiday database
				if(info[0].equals("Holiday")) {
					Connection con = null;
					Statement statement = null;
					
					try {
						ResultSet rs = null;
						
						Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
						SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
						config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
						con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
						
						statement = con.createStatement();
						
						// Get info from database using row ID
						String getRequestInfo = "SELECT * FROM holidayRequests WHERE ROWID = " + info[2];
						
						rs = statement.executeQuery(getRequestInfo);
						
						// Get details and save into variables
						String startDate = rs.getString("REQUEST_STARTDATE");
						String endDate = rs.getString("REQUEST_ENDDATE");
						String reason = rs.getString("REQUEST_REASON");
						String information = rs.getString("REQUEST_INFO");
						String accepted = rs.getString("REQUEST_ACCEPTED");
						String response = rs.getString("REQUEST_RESPONSE");
						
						// Create string for holiday request query
						String yourQuery =  "Start date: " + startDate + "\n" +
											"End date: " + endDate + "\n" +
											"Reason: " + reason + "\n" +
											"Additional information: " + information + "\n";
						
						// Create response string - concatenates response with a line stating whether accepted or denied
						String hrResponse = "";
						
						if(accepted.equals("Accept")) {
							hrResponse = response + "\n\nYour request has been accepted";
						} else if(accepted.equals("Deny")) {
							hrResponse = response + "\n\nYour request has been denied";
						}
						
						txtQuery.setText(yourQuery);
						txtResponse.setText(hrResponse);
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
				// If the response is to a ticket
				} else if(info[0].equals("Ticket")) {
					Connection con = null;
					Statement statement = null;
					
					try {
						ResultSet rs = null;
						
						Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
						SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
						config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
						con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
						
						statement = con.createStatement();
						
						// Get info from tickets table matching the row ID
						String getRequestInfo = "SELECT * FROM tickets WHERE ROWID = " + info[2];
						
						rs = statement.executeQuery(getRequestInfo);
						
						// Saves ticket information as variables
						String type = rs.getString("TICKET_TYPE");
						String desc = rs.getString("TICKET_DESC");
						String response = rs.getString("TICKET_RESPONSE");
						
						// Creates a string storing the query
						String yourQuery =  "Query type: " + type + "\n" +
											"Description: " + desc;
						
						txtQuery.setText(yourQuery);
						txtResponse.setText(response);
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
			}
		});
		
		btnGetDetails.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		contentPane.add(btnGetDetails);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(181, 489, 89, 23);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(loginCheck.l.sessionMode == "Standard") {
					uiNormal u = new uiNormal();			// Creates a new instance of the UI
					viewResponses.this.setVisible(false);	// Closes the current ticket submission window
					u.setVisible(true);						// Opens the UI
				} else if(loginCheck.l.sessionMode == "HR" || loginCheck.l.sessionMode == "Management") {
					uiHR u = new uiHR();					// Creates a new instance of the UI
					viewResponses.this.setVisible(false);	// Closes the current ticket submission window
					u.setVisible(true);						// Opens the UI
				}
			}
		});
		btnClose.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		contentPane.add(btnClose);
		
		Connection con = null;
		Statement statement = null;
		
		try {
			ResultSet rs = null;

			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			// Create query to select all resolved holiday requests
			String qry = "SELECT ROWID, * FROM holidayRequests WHERE " +
						" REQUEST_RESOLVED = 1 AND REQUEST_EMPLOYEEID = " + employeeInfo.loggedInUser.employeeNo;
			
			rs = statement.executeQuery(qry);
			
			// Iterate over all results and store in combobox for selection
			while(rs.next()) {
				int requestID = rs.getInt("ROWID");
				String startDate = rs.getString("REQUEST_STARTDATE");
				String endDate = rs.getString("REQUEST_ENDDATE");
				
				cmbSelectResponse.addItem("Holiday ID: " + requestID + " - " + startDate + " to " + endDate);
			}
			
			// Create query to select all resolved support tickets
			qry = "SELECT ROWID, * FROM tickets WHERE " +
				 " TICKET_RESOLVED = 1 AND TICKET_EMPLOYEEID = " + employeeInfo.loggedInUser.employeeNo;
			
			rs = statement.executeQuery(qry);
			
			// Iterate over all results and store in combobox for selection
			while(rs.next()) {
				int requestID = rs.getInt("ROWID");
				String ticketType = rs.getString("TICKET_TYPE");
				
				cmbSelectResponse.addItem("Ticket ID: " + requestID + " - " + ticketType);
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

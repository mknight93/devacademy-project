package hrproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.SQLiteConfig;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class viewTickets extends JFrame {

	private JPanel contentPane;
	private JTextField txtType;
	private JTextField txtSubmittedBy;
	
	String id[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewTickets frame = new viewTickets();
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
	public viewTickets() {
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 524);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewAllTickets = new JLabel("View All Tickets");
		lblViewAllTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewAllTickets.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblViewAllTickets.setBounds(0, 11, 514, 49);
		contentPane.add(lblViewAllTickets);
		
		JLabel lblSelectATicket = new JLabel("Select a ticket to view:");
		lblSelectATicket.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSelectATicket.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectATicket.setBounds(10, 71, 148, 14);
		contentPane.add(lblSelectATicket);
		
		JLabel lblTicketType = new JLabel("Ticket Type:");
		lblTicketType.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTicketType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTicketType.setBounds(10, 133, 148, 14);
		contentPane.add(lblTicketType);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(10, 174, 148, 14);
		contentPane.add(lblDescription);
		
		JLabel lblResponse = new JLabel("Response:");
		lblResponse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblResponse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResponse.setBounds(10, 306, 148, 14);
		contentPane.add(lblResponse);
		
		JLabel lblSubmittedBy = new JLabel("Submitted by:");
		lblSubmittedBy.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSubmittedBy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubmittedBy.setBounds(10, 105, 148, 14);
		contentPane.add(lblSubmittedBy);
		
		txtType = new JTextField();
		txtType.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtType.setEditable(false);
		txtType.setBounds(165, 130, 181, 20);
		contentPane.add(txtType);
		txtType.setColumns(10);
		
		txtSubmittedBy = new JTextField();
		txtSubmittedBy.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSubmittedBy.setEditable(false);
		txtSubmittedBy.setBounds(165, 102, 181, 20);
		contentPane.add(txtSubmittedBy);
		txtSubmittedBy.setColumns(10);
		
		JComboBox cmbSelectTicket = new JComboBox();
		cmbSelectTicket.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbSelectTicket.setBounds(165, 68, 217, 20);
		contentPane.add(cmbSelectTicket);
		
		JTextArea txtDesc = new JTextArea();
		txtDesc.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtDesc.setEditable(false);
		txtDesc.setBounds(165, 169, 340, 117);
		contentPane.add(txtDesc);
		txtDesc.setLineWrap(true);
		txtDesc.setWrapStyleWord(true);
		
		JTextArea txtResponse = new JTextArea();
		txtResponse.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtResponse.setBounds(165, 301, 340, 117);
		contentPane.add(txtResponse);
		txtResponse.setLineWrap(true);
		txtResponse.setWrapStyleWord(true);
		
		JButton btnSendResponse = new JButton("Send Response");
		btnSendResponse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSendResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResponse.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must provide a response to this ticket.");
				} else {
					String response = txtResponse.getText(); 

					Connection con = null;
					Statement statement = null;
					try {
						Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
						SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
						config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
						con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
						
						statement = con.createStatement();
						
						String updateTicket =   "UPDATE tickets SET TICKET_RESPONSE = '" +
												response + "', TICKET_RESOLVED = 1" + 
												" WHERE ROWID = " + id[0];
						
						statement.executeUpdate(updateTicket);
						
						JOptionPane.showMessageDialog(null, "Your response has been saved and this ticket has been marked as complete.");

						uiHR u = new uiHR();				// Creates a new instance of the UI
						viewTickets.this.setVisible(false);	// Closes the current ticket viewing window
						u.setVisible(true);					// Opens the UI
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(null, "Your response is too long. (Maximum 200 characters)");
					} finally {
						try {
							statement.close();
							con.close();
						} catch (Exception exc2) {
							
						}
					}
				}
			}
		});
		btnSendResponse.setBounds(124, 445, 119, 23);
		contentPane.add(btnSendResponse);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uiHR u = new uiHR();				// Creates a new instance of the UI
				viewTickets.this.setVisible(false);	// Closes the current ticket viewing window
				u.setVisible(true);					// Opens the UI
			}
		});
		btnCancel.setBounds(253, 445, 119, 23);
		contentPane.add(btnCancel);
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedTicket = cmbSelectTicket.getSelectedItem().toString();
				id = selectedTicket.split(" ");
				Connection con = null;
				Statement statement = null;
				
				try {
					ResultSet rs = null;
					
					Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
					SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
					config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
					con = DriverManager.getConnection("jdbc:./db/hrdb.db", config.toProperties());
					
					statement = con.createStatement();
					
					String getTicketInfo = "SELECT * FROM tickets WHERE ROWID = " + id[0];
					
					rs = statement.executeQuery(getTicketInfo);
					
					int empID = rs.getInt("TICKET_EMPLOYEEID");
					String type = rs.getString("TICKET_TYPE");
					String desc = rs.getString("TICKET_DESC");
					
					String getEmployeeName = "SELECT EMPLOYEE_FORENAME, EMPLOYEE_SURNAME FROM employeeInfo " +
											" WHERE EMPLOYEE_ID = " + empID;
					
					rs = statement.executeQuery(getEmployeeName);
					
					String name = rs.getString("EMPLOYEE_FORENAME") + " " + rs.getString("EMPLOYEE_SURNAME"); 
							
					txtSubmittedBy.setText(name);
					txtType.setText(type);
					txtDesc.setText(desc);
				} catch (Exception exc) {
					System.out.println(exc);
				} finally {
					try {
						statement.close();
						con.close();
					} catch (Exception exc2) {
						
					}
				}
			}
		});
		btnGetDetails.setBounds(392, 68, 113, 23);
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
			
			String qry = "SELECT ROWID, * FROM tickets WHERE " +
						" TICKET_RESOLVED = 0 AND TICKET_EMPLOYEEID != " + employeeInfo.loggedInUser.employeeNo;
			
			rs = statement.executeQuery(qry);
			
			while(rs.next()) {
				int ticketID = rs.getInt("ROWID");
				int id = rs.getInt("TICKET_EMPLOYEEID");
				String type = rs.getString("TICKET_TYPE");
				
				cmbSelectTicket.addItem(ticketID + " - " + type + " (" + id +")");
			}
		} catch(Exception exc) {
			
		} finally {
			try {
				statement.close();
				con.close();
			} catch (Exception exc2) {
				
			}
		}
	}
}

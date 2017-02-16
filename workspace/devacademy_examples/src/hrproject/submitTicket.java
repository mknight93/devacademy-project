/**
 * This interface is for normal users to submit tickets to HR for review.
 * Since HR will require a separate system for editing their information, 
 * this frame is only used by non-HR and non-management employees.
 */

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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class submitTicket extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					submitTicket frame = new submitTicket();
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
	public submitTicket() {
		// Customise JOptionPane according to style
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// LABELS
		JLabel lblSubmitATicket = new JLabel("Submit a Ticket");
		lblSubmitATicket.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblSubmitATicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmitATicket.setBounds(0, 11, 434, 37);
		contentPane.add(lblSubmitATicket);
		
		JLabel lblTicketType = new JLabel("Ticket Type");
		lblTicketType.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTicketType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTicketType.setBounds(10, 64, 79, 14);
		contentPane.add(lblTicketType);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(10, 89, 79, 14);
		contentPane.add(lblDescription);
		
		JLabel lblTerms = new JLabel("<html><center>\r\nPlease note that all tickets will be resolved in the order they are received.<br>\r\nYou will receive any updates to your tickets to your account once it has been received by HR.<br>\r\nThe HR team reserves the right to refuse assistance if the ticket system is abused.\r\n</center></html>");
		lblTerms.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTerms.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerms.setBounds(0, 258, 434, 108);
		contentPane.add(lblTerms);
		
		// COMBO BOXES
		JComboBox cmbTicketDesc = new JComboBox();
		cmbTicketDesc.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTicketDesc.setModel(new DefaultComboBoxModel(new String[] {"General", "Technical", "Incorrect Information", "Request Change to Availability", "Other"}));
		cmbTicketDesc.setBounds(99, 61, 325, 20);
		contentPane.add(cmbTicketDesc);
		
		// TEXT AREAS
		JTextArea txtDesc = new JTextArea();
		txtDesc.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtDesc.setBounds(99, 84, 325, 163);
		contentPane.add(txtDesc);
		txtDesc.setLineWrap(true);
		txtDesc.setWrapStyleWord(true);
		
		// BUTTONS
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(loginCheck.l.sessionMode == "Standard") {
					uiNormal u = new uiNormal();			// Creates a new instance of the UI
					submitTicket.this.setVisible(false);	// Closes the current ticket submission window
					u.setVisible(true);						// Opens the UI
				} else if(loginCheck.l.sessionMode.equals("HR") || loginCheck.l.sessionMode.equals("Management")) {
					uiHR u = new uiHR();					// Creates a new instance of the UI
					submitTicket.this.setVisible(false);	// Closes the current ticket submission window
					u.setVisible(true);						// Opens the UI
				}
			}
		});
		btnCancel.setBounds(335, 377, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checks if ticket description is empty and shows a message
				if(txtDesc.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please provide a description of your issue.");
				} else {
					// Gets ticket description and type
					String ticketType = cmbTicketDesc.getSelectedItem().toString();
					String ticketDesc = txtDesc.getText();
					
					// Creates a new query using information
					String query =   "INSERT INTO tickets " +
									" (TICKET_EMPLOYEEID, TICKET_TYPE, TICKET_DESC, TICKET_RESOLVED)" +
									" VALUES (" + 
									employeeInfo.loggedInUser.employeeNo + ", '" +
									ticketType + "', '" +
									ticketDesc + "', " +
									"0" + ");";
					try {
						ticketSubmit(query);
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "There has been a problem submitting your ticket.");
					}
				}
			}
		});
		btnSubmit.setBounds(236, 377, 89, 23);
		contentPane.add(btnSubmit);
	}
	
	private void ticketSubmit(String qry) throws SQLException {
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			statement.executeUpdate(qry);
			
			JOptionPane.showMessageDialog(null, "Your ticket has been submitted for review.");
			if(loginCheck.l.sessionMode == "Standard") {
				uiNormal u = new uiNormal();			// Creates a new instance of the UI
				submitTicket.this.setVisible(false);	// Closes the current ticket submission window
				u.setVisible(true);						// Opens the UI
			} else if(loginCheck.l.sessionMode.equals("HR") || loginCheck.l.sessionMode.equals("Management")) {
				uiHR u = new uiHR();					// Creates a new instance of the UI
				submitTicket.this.setVisible(false);	// Closes the current ticket submission window
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

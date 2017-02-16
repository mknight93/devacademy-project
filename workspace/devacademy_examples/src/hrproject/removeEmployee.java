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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class removeEmployee extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removeEmployee frame = new removeEmployee();
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
	public removeEmployee() {
		// Customise JOptionPane according to style
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 238);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveAnEmployee = new JLabel("Remove an Employee");
		lblRemoveAnEmployee.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblRemoveAnEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveAnEmployee.setBounds(10, 11, 531, 58);
		contentPane.add(lblRemoveAnEmployee);
		
		JLabel lblSelectAnEmployee = new JLabel("Select an employee:");
		lblSelectAnEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSelectAnEmployee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectAnEmployee.setBounds(10, 93, 140, 14);
		contentPane.add(lblSelectAnEmployee);
		
		JComboBox cmbEmployeeList = new JComboBox();
		cmbEmployeeList.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbEmployeeList.setBounds(160, 90, 342, 20);
		contentPane.add(cmbEmployeeList);
		
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get selected item from combo box
				String selectedEmployee = cmbEmployeeList.getSelectedItem().toString();
				// Split string into array - use id[0] for employee ID
				String id[] = selectedEmployee.split(" ");
				
				Connection con = null;
				Statement statement = null;
				
				try {
					Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
					SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
					config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
					con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
					
					statement = con.createStatement();
					
					// Delete records from other tables first as they use foreign keys, then delete employee record.
					String qryHol = "DELETE FROM holidayRequests WHERE REQUEST_EMPLOYEEID = " + id[0];
					String qryTick = "DELETE FROM tickets WHERE TICKET_EMPLOYEEID = " + id[0];
					String qryEmp = "DELETE FROM employeeInfo WHERE EMPLOYEE_ID = " + id[0];
					
					statement.executeUpdate(qryHol);
					statement.executeUpdate(qryTick);
					statement.executeUpdate(qryEmp);
				} catch(Exception exc) {
					System.err.println(exc.getClass().getName() + exc.getMessage());
				} finally {
					try {
						statement.close();
						con.close();
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
				
				JOptionPane.showMessageDialog(null, "Employee has been removed from the database.");
			}
		});
		btnRemoveEmployee.setBounds(118, 142, 147, 23);
		contentPane.add(btnRemoveEmployee);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uiHR u = new uiHR();					// Creates a new instance of the UI
				removeEmployee.this.setVisible(false);	// Closes the current remove employee window
				u.setVisible(true);						// Opens the UI
			}
		});
		btnCancel.setBounds(288, 142, 147, 23);
		contentPane.add(btnCancel);
		
		// Get all employee records from database and sort into ascending order by employee ID
		String selectAll = "SELECT * FROM employeeInfo ORDER BY EMPLOYEE_ID ASC";
		try {
			select(selectAll, cmbEmployeeList);
		} catch(Exception exc) {
			System.out.println(exc);
		}
	}
	
	private static void select(String qry, JComboBox cmbBox) throws SQLException{
		ResultSet rs = null;
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			rs = statement.executeQuery(qry);
			
			while(rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("EMPLOYEE_FORENAME");
				String sName = rs.getString("EMPLOYEE_SURNAME");
				
				cmbBox.addItem(id + " - " + fName + " " + sName);
			}
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
	}
}

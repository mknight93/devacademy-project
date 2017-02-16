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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class addEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField txtForename;
	private JTextField txtSurname;
	private JTextField txtJobTitle;
	private JTextField txtDept;
	private JTextField txtRateOfPay;
	private JTextField txtRemainingHolidays;
	private JTextField txtAvailability;
	private JTextField txtContractedHours;
	private JTextField txtPayrollNo;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtDobYear;
	private JTextField txtEmployeeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addEmployee frame = new addEmployee();
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
	public addEmployee() {
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 616);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmployee.setBounds(10, 11, 414, 63);
		contentPane.add(lblAddEmployee);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(10, 87, 115, 14);
		contentPane.add(lblTitle);
		
		JLabel lblForename = new JLabel("Forename:");
		lblForename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(10, 112, 115, 14);
		contentPane.add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(10, 137, 115, 14);
		contentPane.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setBounds(10, 162, 115, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(10, 187, 115, 14);
		contentPane.add(lblGender);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblJobTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJobTitle.setBounds(10, 237, 115, 14);
		contentPane.add(lblJobTitle);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartment.setBounds(10, 262, 115, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblRateOfPay = new JLabel("Rate of Pay:");
		lblRateOfPay.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRateOfPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRateOfPay.setBounds(10, 287, 115, 14);
		contentPane.add(lblRateOfPay);
		
		JLabel lblRemainingHolidays = new JLabel("Remaining Holidays:");
		lblRemainingHolidays.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRemainingHolidays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRemainingHolidays.setBounds(10, 312, 115, 14);
		contentPane.add(lblRemainingHolidays);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAvailability.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAvailability.setBounds(10, 337, 115, 14);
		contentPane.add(lblAvailability);
		
		JLabel lblContractedHours = new JLabel("Contracted Hours:");
		lblContractedHours.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblContractedHours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContractedHours.setBounds(10, 362, 115, 14);
		contentPane.add(lblContractedHours);
		
		JLabel lblPayrollNumber = new JLabel("Payroll Number:");
		lblPayrollNumber.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPayrollNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayrollNumber.setBounds(10, 387, 115, 14);
		contentPane.add(lblPayrollNumber);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(10, 413, 115, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 438, 115, 14);
		contentPane.add(lblPassword);
		
		JLabel lblAccessLevel = new JLabel("Access Level:");
		lblAccessLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccessLevel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAccessLevel.setBounds(10, 463, 115, 14);
		contentPane.add(lblAccessLevel);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeId.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmployeeId.setBounds(10, 212, 115, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblAccessLevels = new JLabel("<html><center><b>Access Levels</b><br>\r\n1 - Standard<br>\r\n2 - HR<br>\r\n3 - Management</center></html>");
		lblAccessLevels.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAccessLevels.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccessLevels.setBounds(190, 462, 191, 63);
		contentPane.add(lblAccessLevels);
		
		JComboBox cmbTitle = new JComboBox();
		cmbTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTitle.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Miss", "Ms", "Dr"}));
		cmbTitle.setBounds(135, 84, 100, 20);
		contentPane.add(cmbTitle);
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cmbGender.setBounds(135, 184, 100, 20);
		contentPane.add(cmbGender);
		
		JComboBox cmbDobDate = new JComboBox();
		cmbDobDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbDobDate.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbDobDate.setBounds(135, 160, 45, 20);
		contentPane.add(cmbDobDate);
		
		JComboBox cmbDobMonth = new JComboBox();
		cmbDobMonth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbDobMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cmbDobMonth.setBounds(190, 160, 99, 20);
		contentPane.add(cmbDobMonth);
		
		JComboBox cmbAccessLevel = new JComboBox();
		cmbAccessLevel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cmbAccessLevel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbAccessLevel.setBounds(135, 461, 45, 20);
		contentPane.add(cmbAccessLevel);
		
		txtForename = new JTextField();
		txtForename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtForename.setBounds(135, 109, 245, 20);
		contentPane.add(txtForename);
		txtForename.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSurname.setColumns(10);
		txtSurname.setBounds(135, 134, 245, 20);
		contentPane.add(txtSurname);
		
		txtDobYear = new JTextField();
		txtDobYear.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtDobYear.setBounds(299, 160, 81, 20);
		contentPane.add(txtDobYear);
		txtDobYear.setColumns(10);
		
		txtEmployeeID = new JTextField();
		txtEmployeeID.setEditable(false);
		txtEmployeeID.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEmployeeID.setBounds(135, 210, 245, 20);
		contentPane.add(txtEmployeeID);
		txtEmployeeID.setColumns(10);
		
		txtJobTitle = new JTextField();
		txtJobTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtJobTitle.setColumns(10);
		txtJobTitle.setBounds(135, 234, 245, 20);
		contentPane.add(txtJobTitle);
		
		txtDept = new JTextField();
		txtDept.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtDept.setColumns(10);
		txtDept.setBounds(135, 259, 245, 20);
		contentPane.add(txtDept);
		
		txtRateOfPay = new JTextField();
		txtRateOfPay.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtRateOfPay.setColumns(10);
		txtRateOfPay.setBounds(135, 284, 245, 20);
		contentPane.add(txtRateOfPay);
		
		txtRemainingHolidays = new JTextField();
		txtRemainingHolidays.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtRemainingHolidays.setColumns(10);
		txtRemainingHolidays.setBounds(135, 309, 245, 20);
		contentPane.add(txtRemainingHolidays);
		
		txtAvailability = new JTextField();
		txtAvailability.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAvailability.setColumns(10);
		txtAvailability.setBounds(135, 334, 245, 20);
		contentPane.add(txtAvailability);
		
		txtContractedHours = new JTextField();
		txtContractedHours.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtContractedHours.setColumns(10);
		txtContractedHours.setBounds(135, 359, 245, 20);
		contentPane.add(txtContractedHours);
		
		txtPayrollNo = new JTextField();
		txtPayrollNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtPayrollNo.setColumns(10);
		txtPayrollNo.setBounds(135, 384, 245, 20);
		contentPane.add(txtPayrollNo);
		
		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtUsername.setColumns(10);
		txtUsername.setBounds(135, 410, 245, 20);
		contentPane.add(txtUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(135, 435, 245, 20);
		contentPane.add(txtPassword);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uiHR u = new uiHR();				// Creates a new instance of the UI
				addEmployee.this.setVisible(false);	// Closes the current ticket viewing window
				u.setVisible(true);					// Opens the UI
			}
		});
		btnCancel.setBounds(239, 536, 131, 23);
		contentPane.add(btnCancel);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checks if any of the text fields are empty
				if(txtForename.getText().isEmpty() || 
					txtSurname.getText().isEmpty() || 
					txtJobTitle.getText().isEmpty() || 
					txtDept.getText().isEmpty() || 
					txtRateOfPay.getText().isEmpty() || 
					txtRemainingHolidays.getText().isEmpty() || 
					txtAvailability.getText().isEmpty() || 
					txtContractedHours.getText().isEmpty() || 
					txtPayrollNo.getText().isEmpty() || 
					txtUsername.getText().isEmpty() || 
					txtPassword.getText().isEmpty() || 
					txtDobYear.getText().isEmpty() ||
					txtEmployeeID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "One or more fields have been left blank. Please ensure all fields are filled.");
				// Checks if the birth year is higher than the current year or more than 200 years before the current year
				} else if((int) Double.parseDouble(txtDobYear.getText()) > Calendar.getInstance().get(Calendar.YEAR) ||
						(int) Double.parseDouble(txtDobYear.getText()) < (Calendar.getInstance().get(Calendar.YEAR) - 200)) {
					JOptionPane.showMessageDialog(null, "The year in the date of birth field is invalid. Please try again.");
				} else {
					DBInitialiser db = new DBInitialiser();
					
					// Creates date of birth using comboboxes and year
					String dob = cmbDobDate.getSelectedItem() + "-" + (cmbDobMonth.getSelectedIndex() + 1) + "-" + txtDobYear.getText();
					
					// Creates query using information in text boxes and date of birth
					String query =   "INSERT INTO employeeInfo " +
									" (EMPLOYEE_ID, EMPLOYEE_TITLE, EMPLOYEE_FORENAME, EMPLOYEE_SURNAME, EMPLOYEE_DATEOFBIRTH," +
									" EMPLOYEE_GENDER, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD, EMPLOYEE_PRIVILEGELEVEL, EMPLOYEE_JOBTITLE," +
									" EMPLOYEE_RATEOFPAY, EMPLOYEE_DEPARTMENT, EMPLOYEE_HOLIDAYS, EMPLOYEE_HOURSWORKED, EMPLOYEE_PAYROLLNO," +
									" EMPLOYEE_AVAILABILITY)" +
									" VALUES (" + 
									txtEmployeeID.getText() + ", '" +
									cmbTitle.getSelectedItem() + "', '" +
									txtForename.getText() + "', '" +
									txtSurname.getText() + "', '" +
									dob + "', '" +
									cmbGender.getSelectedItem() + "', '" +
									txtUsername.getText() + "', '" +
									txtPassword.getText() + "', " +
									cmbAccessLevel.getSelectedItem() + ", '" +
									txtJobTitle.getText() + "', " +
									txtRateOfPay.getText() + ", '" +
									txtDept.getText() + "', " +
									txtRemainingHolidays.getText() + ", " +
									txtContractedHours.getText() + ", " +
									txtPayrollNo.getText() + ", '" +
									txtAvailability.getText() + "');";
					
					JOptionPane.showMessageDialog(null, "Employee has been added to the database.");

					uiHR u = new uiHR();				// Creates a new instance of the UI
					addEmployee.this.setVisible(false);	// Closes the current ticket viewing window
					u.setVisible(true);					// Opens the UI
					try {
						db.connection(query);
					} catch(Exception exc) {
						System.err.println("EXCEPTION: " + exc);
					}
				}
			}
		});
		btnAddEmployee.setBounds(84, 536, 131, 23);
		contentPane.add(btnAddEmployee);
		
		Connection con = null;
		Statement statement = null;
		try {
			ResultSet rs;
			
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			// Query to select the highest employee ID value from database. Orders by descending value, stops after 1 result
			String highestEmpNo = "SELECT EMPLOYEE_ID FROM employeeInfo ORDER BY EMPLOYEE_ID DESC LIMIT 1";
			
			statement = con.createStatement();
			
			// Execute the query
			rs = statement.executeQuery(highestEmpNo);
			
			int id = rs.getInt("EMPLOYEE_ID");			// Get the value of the ID
			id++;										// Add one
			
			// Set the text for the employee ID and username to the incremented ID
			txtEmployeeID.setText(String.valueOf(id));
			txtUsername.setText(String.valueOf(id));
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			try {
				statement.close();
				con.close();
			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
	}
}

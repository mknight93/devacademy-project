package hrproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class employeeInfo {
	// PERSONAL DETAILS
	String username = "";
	String password = "";
	String title = "";
	String forename = "";
	String surname = "";
	String dateOfBirth = "";
	String gender = "";
	String address1 = "";
	String address2 = "";
	String town = "";
	String county = "";
	String postcode = "";
	String homePhone = "";
	String mobilePhone = "";
	String email = "";
	int privilegeLevel = 0;
	
	// EMERGENCY CONTACT DETAILS
	String emerg1Title = "";
	String emerg1Forename = "";
	String emerg1Surname = "";
	String emerg1Telephone = "";
	String emerg1Email = "";
	String emerg2Title = "";
	String emerg2Forename = "";
	String emerg2Surname = "";
	String emerg2Telephone = "";
	String emerg2Email = "";
	
	// BANK INFORMATION
	String accountNo = "";
	String sortCode = "";
	String acctName = "";
	String bank = "";
	
	// JOB DESCRIPTION
	int employeeNo;
	String availability = "";
	String jobTitle = "";
	String dept = "";
	String payrollNo = "";
	int hoursWorked = 0;	// Hours to work each week in employee contract
	int attendance = 0;		// Hours the employee has worked
	int holidays = 0;
	float rateOfPay = 0;
	
	// Two static instances of this class - one for the current user logged in, one for the employee selected by a HR user
	static employeeInfo loggedInUser = new employeeInfo();
	static employeeInfo hrSelectedUser = new employeeInfo();
	
	// Method to get information for current logged in user
	protected void selectInfo() throws SQLException {
		ResultSet rs = null;
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			String selectInfo = "SELECT * FROM employeeInfo WHERE EMPLOYEE_ID = " + loginCheck.l.sessionUser;
			
			rs = statement.executeQuery(selectInfo);
			
			// GET PERSONAL INFO
			loggedInUser.title = rs.getString("EMPLOYEE_TITLE");
			loggedInUser.forename = rs.getString("EMPLOYEE_FORENAME");
			loggedInUser.surname = rs.getString("EMPLOYEE_SURNAME");
			loggedInUser.dateOfBirth = rs.getString("EMPLOYEE_DATEOFBIRTH");
			loggedInUser.gender = rs.getString("EMPLOYEE_GENDER");
			loggedInUser.address1 = rs.getString("EMPLOYEE_ADDRESS1");
			loggedInUser.address2 = rs.getString("EMPLOYEE_ADDRESS2");
			loggedInUser.town = rs.getString("EMPLOYEE_TOWN");
			loggedInUser.county = rs.getString("EMPLOYEE_COUNTY");
			loggedInUser.postcode = rs.getString("EMPLOYEE_POSTCODE");
			loggedInUser.homePhone = rs.getString("EMPLOYEE_HOMEPHONE");
			loggedInUser.mobilePhone = rs.getString("EMPLOYEE_MOBILEPHONE");
			loggedInUser.email = rs.getString("EMPLOYEE_EMAIL");
			
			// GET EMERGENCY CONTACT INFO
			loggedInUser.emerg1Title = rs.getString("EMPLOYEE_EMERG1TITLE");
			loggedInUser.emerg1Forename = rs.getString("EMPLOYEE_EMERG1FORENAME");
			loggedInUser.emerg1Surname = rs.getString("EMPLOYEE_EMERG1SURNAME");
			loggedInUser.emerg1Telephone = rs.getString("EMPLOYEE_EMERG1TELEPHONE");
			loggedInUser.emerg1Email = rs.getString("EMPLOYEE_EMERG1EMAIL");
			loggedInUser.emerg2Title = rs.getString("EMPLOYEE_EMERG2TITLE");
			loggedInUser.emerg2Forename = rs.getString("EMPLOYEE_EMERG2FORENAME");
			loggedInUser.emerg2Surname = rs.getString("EMPLOYEE_EMERG2SURNAME");
			loggedInUser.emerg2Telephone = rs.getString("EMPLOYEE_EMERG2TELEPHONE");
			loggedInUser.emerg2Email = rs.getString("EMPLOYEE_EMERG2EMAIL");
			
			// GET PAYMENT INFO
			loggedInUser.accountNo = rs.getString("EMPLOYEE_ACCOUNTNO");
			loggedInUser.sortCode = rs.getString("EMPLOYEE_SORTCODE");
			loggedInUser.acctName = rs.getString("EMPLOYEE_ACCOUNTNAME");
			loggedInUser.bank = rs.getString("EMPLOYEE_BANK");
			
			// GET EMPLOYMENT INFO
			loggedInUser.employeeNo = rs.getInt("EMPLOYEE_ID");
			loggedInUser.jobTitle = rs.getString("EMPLOYEE_JOBTITLE");
			loggedInUser.dept = rs.getString("EMPLOYEE_DEPARTMENT");
			loggedInUser.availability = rs.getString("EMPLOYEE_AVAILABILITY");
			loggedInUser.payrollNo = rs.getString("EMPLOYEE_PAYROLLNO");
			loggedInUser.hoursWorked = rs.getInt("EMPLOYEE_HOURSWORKED");
			loggedInUser.attendance = rs.getInt("EMPLOYEE_ATTENDANCE");
			loggedInUser.holidays = rs.getInt("EMPLOYEE_HOLIDAYS");
			loggedInUser.rateOfPay = rs.getFloat("EMPLOYEE_RATEOFPAY");
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
	}
	
	// Method to get information for employee selected by HR
	protected void selectEmployeeInfo(String employeeID) throws SQLException {
		ResultSet rs = null;
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			String selectInfo = "SELECT * FROM employeeInfo WHERE EMPLOYEE_ID = " + employeeID;
			
			rs = statement.executeQuery(selectInfo);
			
			// GET PERSONAL INFO
			hrSelectedUser.title = rs.getString("EMPLOYEE_TITLE");
			hrSelectedUser.forename = rs.getString("EMPLOYEE_FORENAME");
			hrSelectedUser.surname = rs.getString("EMPLOYEE_SURNAME");
			hrSelectedUser.dateOfBirth = rs.getString("EMPLOYEE_DATEOFBIRTH");
			hrSelectedUser.gender = rs.getString("EMPLOYEE_GENDER");
			hrSelectedUser.address1 = rs.getString("EMPLOYEE_ADDRESS1");
			hrSelectedUser.address2 = rs.getString("EMPLOYEE_ADDRESS2");
			hrSelectedUser.town = rs.getString("EMPLOYEE_TOWN");
			hrSelectedUser.county = rs.getString("EMPLOYEE_COUNTY");
			hrSelectedUser.postcode = rs.getString("EMPLOYEE_POSTCODE");
			hrSelectedUser.homePhone = rs.getString("EMPLOYEE_HOMEPHONE");
			hrSelectedUser.mobilePhone = rs.getString("EMPLOYEE_MOBILEPHONE");
			hrSelectedUser.email = rs.getString("EMPLOYEE_EMAIL");
			
			// GET EMERGENCY CONTACT INFO
			hrSelectedUser.emerg1Title = rs.getString("EMPLOYEE_EMERG1TITLE");
			hrSelectedUser.emerg1Forename = rs.getString("EMPLOYEE_EMERG1FORENAME");
			hrSelectedUser.emerg1Surname = rs.getString("EMPLOYEE_EMERG1SURNAME");
			hrSelectedUser.emerg1Telephone = rs.getString("EMPLOYEE_EMERG1TELEPHONE");
			hrSelectedUser.emerg1Email = rs.getString("EMPLOYEE_EMERG1EMAIL");
			hrSelectedUser.emerg2Title = rs.getString("EMPLOYEE_EMERG2TITLE");
			hrSelectedUser.emerg2Forename = rs.getString("EMPLOYEE_EMERG2FORENAME");
			hrSelectedUser.emerg2Surname = rs.getString("EMPLOYEE_EMERG2SURNAME");
			hrSelectedUser.emerg2Telephone = rs.getString("EMPLOYEE_EMERG2TELEPHONE");
			hrSelectedUser.emerg2Email = rs.getString("EMPLOYEE_EMERG2EMAIL");
			
			// GET PAYMENT INFO
			hrSelectedUser.accountNo = rs.getString("EMPLOYEE_ACCOUNTNO");
			hrSelectedUser.sortCode = rs.getString("EMPLOYEE_SORTCODE");
			hrSelectedUser.acctName = rs.getString("EMPLOYEE_ACCOUNTNAME");
			hrSelectedUser.bank = rs.getString("EMPLOYEE_BANK");
			
			// GET EMPLOYMENT INFO
			hrSelectedUser.employeeNo = rs.getInt("EMPLOYEE_ID");
			hrSelectedUser.jobTitle = rs.getString("EMPLOYEE_JOBTITLE");
			hrSelectedUser.dept = rs.getString("EMPLOYEE_DEPARTMENT");
			hrSelectedUser.availability = rs.getString("EMPLOYEE_AVAILABILITY");
			hrSelectedUser.payrollNo = rs.getString("EMPLOYEE_PAYROLLNO");
			hrSelectedUser.hoursWorked = rs.getInt("EMPLOYEE_HOURSWORKED");
			hrSelectedUser.attendance = rs.getInt("EMPLOYEE_ATTENDANCE");
			hrSelectedUser.holidays = rs.getInt("EMPLOYEE_HOLIDAYS");
			hrSelectedUser.rateOfPay = rs.getFloat("EMPLOYEE_RATEOFPAY");
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
	}
	
	// Method to clear object on log out or for selecting a new user in HR mode
	protected void clearObject() {
		// PERSONAL DETAILS
		username = "";
		password = "";
		title = "";
		forename = "";
		surname = "";
		dateOfBirth = "";
		gender = "";
		address1 = "";
		address2 = "";
		town = "";
		county = "";
		postcode = "";
		homePhone = "";
		mobilePhone = "";
		email = "";
		privilegeLevel = 0;
		
		// EMERGENCY CONTACT DETAILS
		emerg1Title = "";
		emerg1Forename = "";
		emerg1Surname = "";
		emerg1Telephone = "";
		emerg1Email = "";
		emerg2Title = "";
		emerg2Forename = "";
		emerg2Surname = "";
		emerg2Telephone = "";
		emerg2Email = "";
		
		// BANK INFORMATION
		accountNo = "";
		sortCode = "";
		acctName = "";
		bank = "";
		
		// JOB DESCRIPTION
		employeeNo = 0;
		availability = "";
		jobTitle = "";
		dept = "";
		payrollNo = "";
		hoursWorked = 0;
		attendance = 0;
		holidays = 0;
		rateOfPay = 0;
	}
}

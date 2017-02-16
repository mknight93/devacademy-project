package hrproject;

import java.sql.Statement;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInitialiser {
	public static void main(String[] args) throws SQLException {
		Connection con = null;		// Used to store an SQL connection
		Statement statement = null;	// Used to store an SQL statement
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			String createInfoTable = "CREATE TABLE IF NOT EXISTS employeeInfo " +
									// ID - PRIMARY KEY
									" (EMPLOYEE_ID INT PRIMARY KEY NOT NULL UNIQUE," +
									// PERSONAL DETAILS
									" EMPLOYEE_USERNAME CHAR NOT NULL," +
									" EMPLOYEE_PASSWORD CHAR NOT NULL," +
									" EMPLOYEE_TITLE CHAR NOT NULL," +
									" EMPLOYEE_FORENAME CHAR NOT NULL," +
									" EMPLOYEE_SURNAME CHAR NOT NULL," +
									" EMPLOYEE_DATEOFBIRTH DATE NOT NULL," +
									" EMPLOYEE_GENDER CHAR NOT NULL," +
									" EMPLOYEE_ADDRESS1 CHAR," +
									" EMPLOYEE_ADDRESS2 CHAR," +
									" EMPLOYEE_TOWN CHAR," +
									" EMPLOYEE_COUNTY CHAR," +
									" EMPLOYEE_POSTCODE CHAR," +
									" EMPLOYEE_HOMEPHONE CHAR," +
									" EMPLOYEE_MOBILEPHONE CHAR," +
									" EMPLOYEE_EMAIL CHAR," +
									" EMPLOYEE_PRIVILEGELEVEL INT NOT NULL," +
									// EMERGENCY CONTACT
									" EMPLOYEE_EMERG1TITLE CHAR," +
									" EMPLOYEE_EMERG1FORENAME CHAR," +
									" EMPLOYEE_EMERG1SURNAME CHAR," +
									" EMPLOYEE_EMERG1TELEPHONE CHAR," +
									" EMPLOYEE_EMERG1EMAIL CHAR," +
									" EMPLOYEE_EMERG2TITLE CHAR," +
									" EMPLOYEE_EMERG2FORENAME CHAR," +
									" EMPLOYEE_EMERG2SURNAME CHAR," +
									" EMPLOYEE_EMERG2TELEPHONE CHAR," +
									" EMPLOYEE_EMERG2EMAIL CHAR," +
									// BANK
									" EMPLOYEE_ACCOUNTNO INT," +
									" EMPLOYEE_SORTCODE CHAR," +
									" EMPLOYEE_ACCOUNTNAME CHAR," +
									" EMPLOYEE_BANK CHAR," +
									// JOB DESCRIPTION
									" EMPLOYEE_AVAILABILITY CHAR NOT NULL," +
									" EMPLOYEE_JOBTITLE CHAR NOT NULL," +
									" EMPLOYEE_DEPARTMENT CHAR NOT NULL," +
									" EMPLOYEE_PAYROLLNO INT NOT NULL," +
									" EMPLOYEE_HOURSWORKED INT NOT NULL," +
									" EMPLOYEE_ATTENDANCE INT," +
									" EMPLOYEE_HOLIDAYS INT NOT NULL," +
									" EMPLOYEE_RATEOFPAY REAL NOT NULL," +
									// ID CHECK CONSTRAINT
									" CHECK(length(EMPLOYEE_ID) <= 6" +
									// PERSONAL INFORMATION CHECK CONSTRAINTS
									" and length(EMPLOYEE_USERNAME) <= 10" +
									" and length(EMPLOYEE_PASSWORD) <= 20" +
									" and length(EMPLOYEE_TITLE) <= 6" +
									" and length(EMPLOYEE_FORENAME) <= 20" +
									" and length(EMPLOYEE_SURNAME) <= 20" +
									" and length(EMPLOYEE_GENDER) <= 6" +
									" and length(EMPLOYEE_ADDRESS1) <= 50" +
									" and length(EMPLOYEE_ADDRESS2) <= 50" +
									" and length(EMPLOYEE_TOWN) <= 30" +
									" and length(EMPLOYEE_COUNTY) <= 30" +
									" and length(EMPLOYEE_POSTCODE) <= 10" +
									" and length(EMPLOYEE_HOMEPHONE) <= 11" +
									" and length(EMPLOYEE_MOBILEPHONE) <= 11" +
									" and length(EMPLOYEE_EMAIL) <= 30" +
									" and length(EMPLOYEE_PRIVILEGELEVEL) <= 1" +
									// EMERGENCY CONTACT CHECK CONSTRAINTS
									" and length(EMPLOYEE_EMERG1TITLE) <= 6" +
									" and length(EMPLOYEE_EMERG1FORENAME) <= 20" +
									" and length(EMPLOYEE_EMERG1SURNAME) <= 20" +
									" and length(EMPLOYEE_EMERG1TELEPHONE) <= 11" +
									" and length(EMPLOYEE_EMERG1EMAIL) <= 30" +
									" and length(EMPLOYEE_EMERG2TITLE) <= 6" +
									" and length(EMPLOYEE_EMERG2FORENAME) <= 20" +
									" and length(EMPLOYEE_EMERG2SURNAME) <= 20" +
									" and length(EMPLOYEE_EMERG2TELEPHONE) <= 11" +
									" and length(EMPLOYEE_EMERG2EMAIL) <= 30" +
									// BANK CHECK CONSTRAINTS
									" and length(EMPLOYEE_ACCOUNTNO) <= 15" +
									" and length(EMPLOYEE_SORTCODE) <= 10" +
									" and length(EMPLOYEE_ACCOUNTNAME) <= 30" +
									" and length(EMPLOYEE_BANK) <= 20" +
									// JOB DESCRIPTION CHECK CONSTRAINTS
									" and length(EMPLOYEE_AVAILABILITY) <= 50" +
									" and length(EMPLOYEE_JOBTITLE) <= 25" +
									" and length(EMPLOYEE_DEPARTMENT) <= 20" +
									" and length(EMPLOYEE_PAYROLLNO) <= 15" +
									" and length(EMPLOYEE_HOURSWORKED) <= 10" +
									" and length(EMPLOYEE_ATTENDANCE) <= 3" +
									" and length(EMPLOYEE_HOLIDAYS) <= 4" +
									" and length(EMPLOYEE_RATEOFPAY) <= 6))";
			
			statement.executeUpdate(createInfoTable);	// Executes the statement
			
			String createTicketTable =   "CREATE TABLE IF NOT EXISTS tickets " +
										" (TICKET_EMPLOYEEID INT NOT NULL," +
										" TICKET_TYPE CHAR NOT NULL," +
										" TICKET_DESC CHAR NOT NULL," +
										" TICKET_RESPONSE CHAR," +
										" TICKET_RESOLVED INT NOT NULL," +
										// FOREIGN KEY FOR EMPLOYEE ID
										" FOREIGN KEY(TICKET_EMPLOYEEID) REFERENCES employeeInfo(EMPLOYEE_ID)," +
										// CHECK CONSTRAINTS FOR TICKET DESCRIPTION AND RESPONSE
										" CHECK(length(TICKET_DESC) <= 200" +
										" and length(TICKET_RESPONSE) <= 200))";
			
			statement.executeUpdate(createTicketTable);
			
			String createHolidayTable =  "CREATE TABLE IF NOT EXISTS holidayRequests " +
										" (REQUEST_EMPLOYEEID INT NOT NULL," +
										" REQUEST_STARTDATE DATE NOT NULL," +
										" REQUEST_ENDDATE DATE NOT NULL," +
										" REQUEST_REASON CHAR NOT NULL," +
										" REQUEST_INFO CHAR NOT NULL," +
										" REQUEST_ACCEPTED CHAR," +
										" REQUEST_RESPONSE CHAR," +
										" REQUEST_RESOLVED INT NOT NULL," +
										// FOREIGN KEY FOR EMPLOYEE ID
										" FOREIGN KEY(REQUEST_EMPLOYEEID) REFERENCES employeeInfo(EMPLOYEE_ID)," +
										// CHECK CONSTRAINTS
										" CHECK(length(REQUEST_INFO) <= 200" +
										" and length(REQUEST_RESPONSE) <= 200))";
			
			statement.executeUpdate(createHolidayTable);
			
			/* DROP TABLES */
//			String dropHolTable = "DROP TABLE IF EXISTS holidayRequests";
//			String dropTickTable = "DROP TABLE IF EXISTS tickets";
//			String dropEmpTable = "DROP TABLE IF EXISTS employeeInfo";
//			
//			statement.executeUpdate(dropHolTable);
//			statement.executeUpdate(dropTickTable);
//			statement.executeUpdate(dropEmpTable);
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
	}
	
	protected static void connection(String qry) throws SQLException{
		Connection con = null;
		Statement statement = null;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			statement.executeUpdate(qry);
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
	}
	
	protected static ResultSet select(String qry, employeeInfo user) throws SQLException{
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
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
		
		return rs;
	}
}
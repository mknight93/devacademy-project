package hrproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import org.sqlite.SQLiteConfig;

public class loginCheck {
	// Current logged in user information
	String sessionUser = "";
	char[] sessionPwd;
	String sessionMode = "";
	boolean hasHRPrivileges = false;
	
	// Creates a static loginCheck object to store session variables
	static loginCheck l = new loginCheck();

	ResultSet rs = null;
	Connection con = null;
	Statement statement = null;
	
	// Check user information on login
	protected boolean checkUser(String username, char[] password) throws SQLException {
		boolean userState = false;
		
		// Gets only the user information from the database
		String select = "SELECT EMPLOYEE_ID, EMPLOYEE_PASSWORD, EMPLOYEE_PRIVILEGELEVEL FROM employeeInfo WHERE EMPLOYEE_ID = " + username;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			rs = statement.executeQuery(select);
			
			// Stores the results in variables
			String dbPassword = rs.getString("EMPLOYEE_PASSWORD");
			int dbPrivilege = rs.getInt("EMPLOYEE_PRIVILEGELEVEL");
			char[] dbPasswordChar = dbPassword.toCharArray();
			
			// Checks the password entered matches the database password
			if(Arrays.equals(password, dbPasswordChar)){
				if(dbPrivilege == 1) {
					loginCheck.l.sessionMode = "Standard";
				} else if(dbPrivilege == 2) {
					loginCheck.l.sessionMode = "HR";
				} else if(dbPrivilege == 3) {
					loginCheck.l.sessionMode = "Management";
				}
				
				// User is verified and can now login
				userState = true;
			}
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
		
		return userState;
	}
	
	// Method to change current user's password
	protected void changePass(char[] newPass) throws SQLException {
		String passString = new String(newPass);
		String pwUpdate = "UPDATE employeeInfo SET EMPLOYEE_PASSWORD = '" + passString + "' WHERE EMPLOYEE_ID = " + l.sessionUser;
		
		try {
			Class.forName("org.sqlite.JDBC");			// Initialises the SQL driver
			SQLiteConfig config = new SQLiteConfig();	// Creates a new instance of SQLite class
			config.enforceForeignKeys(true);			// Enables foreign keys - occurs on every connection
			con = DriverManager.getConnection("jdbc:sqlite:./db/hrdb.db", config.toProperties());
			
			statement = con.createStatement();
			
			statement.executeUpdate(pwUpdate);
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
	}
}

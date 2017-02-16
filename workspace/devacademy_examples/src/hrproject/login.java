// RUN THIS CLASS FIRST!

package hrproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPassword;
	
	// User information strings
	String username = "";
	char[] password;
	String usermode = "";
	
	public loginCheck l = new loginCheck();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		// Customise JOptionPane according to style
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 176);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// LABELS
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Century Gothic", Font.BOLD, 36));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(0, 0, 279, 37);
		contentPane.add(lblWelcome);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeId.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmployeeId.setBounds(10, 51, 95, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPassword.setBounds(10, 76, 95, 14);
		contentPane.add(lblPassword);
		
		// TEXT BOXES
		txtID = new JTextField();
		txtID.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtID.setBounds(115, 48, 154, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(115, 73, 154, 20);
		contentPane.add(txtPassword);
		
		// BUTTONS
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get the information entered by the user
				username = txtID.getText();
				password = txtPassword.getPassword();
				
				// Used to determine whether the information the user provided is false - set by method
				boolean correctInfo = false;
				
				// If either of the fields are blank display a message
				if(txtID.getText().isEmpty() || txtPassword.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please ensure all fields are correctly completed and try again.");
				} else {
					try {
						// Use method checkUser with details entered to determine if info is correct
						correctInfo = l.checkUser(username, password);
					} catch(Exception exc) {
						System.out.println("EXCEPTION: " + exc);
					}
					
					// If the information is accurate
					if(correctInfo){
						// Show message and hide window
						loginCheck.l.sessionUser = username;
						loginCheck.l.sessionPwd = password;
						
						// Disables the current login screen
						login.this.setVisible(false);
						
						// Check the selected user mode and open the appropriate information screen
						if(loginCheck.l.sessionMode == "Standard"){
							// Show normal user screen
							uiNormal uNormal = new uiNormal();
							uNormal.setVisible(true); 
						} else if(loginCheck.l.sessionMode == "HR") {
							// Show HR screen
							uiHR uHr = new uiHR();
							uHr.setVisible(true);
						} else if(loginCheck.l.sessionMode == "Management") {
							// Show Management screen
							uiHR uHr = new uiHR();
							uHr.setVisible(true);
						}
					} else {
						// If the information entered is incorrect, display vague message
						JOptionPane.showMessageDialog(null, "Username or password is incorrect. Please try again.");
					}
				}
			}
		});
		btnLogin.setBounds(106, 104, 89, 23);
		contentPane.add(btnLogin);
	}
}
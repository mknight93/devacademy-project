package hrproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class payslip extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payslip frame = new payslip();
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
	public payslip() {
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 583);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourPayslip = new JLabel("Your Weekly Payslip");
		lblYourPayslip.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourPayslip.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblYourPayslip.setBounds(10, 11, 414, 75);
		contentPane.add(lblYourPayslip);
		
		JTextArea txtPayslip = new JTextArea();
		txtPayslip.setEditable(false);
		txtPayslip.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtPayslip.setBounds(10, 97, 414, 386);
		contentPane.add(txtPayslip);
		txtPayslip.setLineWrap(true);
		txtPayslip.setWrapStyleWord(true);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginCheck.l.sessionMode == "Standard") {
					uiNormal u = new uiNormal();	// Creates a new instance of the UI
					payslip.this.setVisible(false);	// Closes the current ticket submission window
					u.setVisible(true);				// Opens the UI
				} else if(loginCheck.l.sessionMode.equals("HR") || loginCheck.l.sessionMode.equals("Management")) {
					uiHR u = new uiHR();			// Creates a new instance of the UI
					payslip.this.setVisible(false);	// Closes the current ticket submission window
					u.setVisible(true);				// Opens the UI
				}
			}
		});
		btnClose.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnClose.setBounds(173, 497, 89, 23);
		contentPane.add(btnClose);
		
		try {
			float totalPay = (float) employeeInfo.loggedInUser.rateOfPay * (float) employeeInfo.loggedInUser.attendance;
			// Creates a decimal format mask for payment
			DecimalFormat df = new DecimalFormat("####0.00");
			// Creates a string to display payslip
			// Personal information
			String payslip = "Payslip for: " + employeeInfo.loggedInUser.title + " " + employeeInfo.loggedInUser.forename + " " + employeeInfo.loggedInUser.surname + "\n" +
							 employeeInfo.loggedInUser.jobTitle + " in " + employeeInfo.loggedInUser.dept + " department\n" +
							 "Employee no.: " + employeeInfo.loggedInUser.employeeNo + "\n" +
							 "Payroll no.: " + employeeInfo.loggedInUser.payrollNo + "\n\n";
			
			// Address  - determined by whether or not address line 2 exists
			if(employeeInfo.loggedInUser.address2.isEmpty()) {
				payslip += "Address: \n" +  employeeInfo.loggedInUser.address1 + "\n" + 
											employeeInfo.loggedInUser.town + "\n" + 
											employeeInfo.loggedInUser.county + "\n" + 
											employeeInfo.loggedInUser.postcode + "\n\n";
			} else {
				payslip += "Address: \n" +  employeeInfo.loggedInUser.address1 + "\n" + 
											employeeInfo.loggedInUser.address2 + "\n" + 
											employeeInfo.loggedInUser.town + "\n" + 
											employeeInfo.loggedInUser.county + "\n" + 
											employeeInfo.loggedInUser.postcode + "\n\n";
			}
			
			// Contact information
			payslip += "Contact information: \n" +
						"Home phone no.: " + employeeInfo.loggedInUser.homePhone + "\n" +
						"Mobile phone no.: " + employeeInfo.loggedInUser.mobilePhone + "\n" +
						"Email: " + employeeInfo.loggedInUser.email + "\n\n";
			
			// Payment information
			payslip += "Hourly pay rate: £" + df.format(employeeInfo.loggedInUser.rateOfPay) + "\n" + 
						"Hours worked: " + employeeInfo.loggedInUser.attendance + "\n" +
						"Total payment: £" + df.format(totalPay) + "\n\n" +
						"Thank you for your continued support!";
							
			txtPayslip.setText(payslip);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "One or more of your personal information fields are empty. Payslip generation failed.");
			
			txtPayslip.setText("Your payslip could not be generated.\n\n" +
								"Please click the 'close' button at the bottom of this window and try again.");
		}
	}
}

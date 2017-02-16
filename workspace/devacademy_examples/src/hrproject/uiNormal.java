package hrproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import org.sqlite.SQLiteConfig;

import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class uiNormal extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtForename;
	private JTextField txtSurname;
	private JTextField txtDateOfBirth;
	private JTextField txtGender;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JTextField txtTown;
	private JTextField txtCounty;
	private JTextField txtPostcode;
	private JTextField txtHomePhone;
	private JTextField txtMobilePhone;
	private JTextField txtEmail;
	private JTextField txtForenameE1;
	private JTextField txtSurnameE1;
	private JTextField txtPhoneNumberE1;
	private JTextField txtEmailE1;
	private JTextField txtForenameE2;
	private JTextField txtSurnameE2;
	private JTextField txtPhoneNumberE2;
	private JTextField txtEmailE2;
	private JTextField txtBank;
	private JTextField txtAccountNumber;
	private JTextField txtSortCode;
	private JTextField txtAccountHolder;
	private JTextField txtJobTitle;
	private JTextField txtDepartment;
	private JTextField txtEmployeeNo;
	private JTextField txtRateOfPay;
	private JTextField txtRemainingHolidays;
	private JTextField txtAvailability;
	private JTextField txtContractedHours;
	private JTextField txtPayrollNo;
	private JTextField txtHoursWorked;
	private JPasswordField txtCurrentPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtAttendance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uiNormal frame = new uiNormal();
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
	public uiNormal() {
		// Customise JOptionPane according to style
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		
		try {
			employeeInfo.loggedInUser.selectInfo();
		} catch(Exception exc) {
			
		}
		
		// Calculate attendance - (hours worked divided by contracted hours) * 100 
		float attendance = 100*((float)(employeeInfo.loggedInUser.attendance)/(float)(employeeInfo.loggedInUser.hoursWorked));
		DecimalFormat df = new DecimalFormat("##0.00");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 738);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Gets the profile picture by adding the employee ID to the image path
		ImageIcon icon = new ImageIcon("./img/" + loginCheck.l.sessionUser + ".jpg");
		
		JLabel lblImg = new JLabel();
		lblImg.setBounds(10, 0, 90, 90);
		contentPane.add(lblImg);
		lblImg.setIcon(icon);
		
		JLabel lblWelcome = new JLabel("Welcome, " + employeeInfo.loggedInUser.forename + " " + employeeInfo.loggedInUser.surname + "!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblWelcome.setBounds(0, 10, 939, 49);
		contentPane.add(lblWelcome);
		
		JLabel lblPersonalInformation = new JLabel("Your Personal Information");
		lblPersonalInformation.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setBounds(10, 95, 272, 25);
		contentPane.add(lblPersonalInformation);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(0, 134, 136, 14);
		contentPane.add(lblTitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(0, 159, 136, 14);
		contentPane.add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(0, 184, 136, 14);
		contentPane.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setBounds(0, 209, 136, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(0, 234, 136, 14);
		contentPane.add(lblGender);
		
		JLabel lblAddressLine = new JLabel("Address Line 1");
		lblAddressLine.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAddressLine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressLine.setBounds(0, 259, 136, 14);
		contentPane.add(lblAddressLine);
		
		JLabel lblAddressLine_1 = new JLabel("Address Line 2");
		lblAddressLine_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAddressLine_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressLine_1.setBounds(0, 284, 136, 14);
		contentPane.add(lblAddressLine_1);
		
		JLabel lblTowncity = new JLabel("Town/City");
		lblTowncity.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTowncity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTowncity.setBounds(0, 309, 136, 14);
		contentPane.add(lblTowncity);
		
		JLabel lblCounty = new JLabel("County");
		lblCounty.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCounty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCounty.setBounds(0, 334, 136, 14);
		contentPane.add(lblCounty);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPostcode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostcode.setBounds(0, 359, 136, 14);
		contentPane.add(lblPostcode);
		
		JLabel lblHomePhoneNumber = new JLabel("Home Phone Number");
		lblHomePhoneNumber.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblHomePhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomePhoneNumber.setBounds(0, 384, 136, 14);
		contentPane.add(lblHomePhoneNumber);
		
		JLabel lblMobilePhoneNumber = new JLabel("Mobile Phone Number");
		lblMobilePhoneNumber.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblMobilePhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobilePhoneNumber.setBounds(0, 409, 136, 14);
		contentPane.add(lblMobilePhoneNumber);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmailAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAddress.setBounds(0, 434, 136, 14);
		contentPane.add(lblEmailAddress);
		
		JLabel lblEmergencyContactDetails = new JLabel("Emergency Contact Details");
		lblEmergencyContactDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergencyContactDetails.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmergencyContactDetails.setBounds(478, 95, 272, 25);
		contentPane.add(lblEmergencyContactDetails);
		
		JLabel lblEmergencyContact = new JLabel("Emergency Contact 1");
		lblEmergencyContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergencyContact.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmergencyContact.setBounds(319, 134, 272, 25);
		contentPane.add(lblEmergencyContact);
		
		JLabel lblEmergencyContact_1 = new JLabel("Emergency Contact 2");
		lblEmergencyContact_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergencyContact_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmergencyContact_1.setBounds(635, 134, 272, 25);
		contentPane.add(lblEmergencyContact_1);
		
		JLabel lblTitleE1 = new JLabel("Title");
		lblTitleE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTitleE1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleE1.setBounds(290, 170, 111, 14);
		contentPane.add(lblTitleE1);
		
		JLabel lblForenameE1 = new JLabel("Forename");
		lblForenameE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblForenameE1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForenameE1.setBounds(290, 195, 111, 14);
		contentPane.add(lblForenameE1);
		
		JLabel lbSurnameE1 = new JLabel("Surname");
		lbSurnameE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lbSurnameE1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSurnameE1.setBounds(290, 220, 111, 14);
		contentPane.add(lbSurnameE1);
		
		JLabel lblPhoneNumberE1 = new JLabel("Telephone Number");
		lblPhoneNumberE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPhoneNumberE1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumberE1.setBounds(290, 245, 111, 14);
		contentPane.add(lblPhoneNumberE1);
		
		JLabel lblEmailE1 = new JLabel("Email Address");
		lblEmailE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmailE1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailE1.setBounds(290, 270, 111, 14);
		contentPane.add(lblEmailE1);
		
		JLabel lblTitleE2 = new JLabel("Title");
		lblTitleE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTitleE2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleE2.setBounds(618, 170, 111, 14);
		contentPane.add(lblTitleE2);
		
		JLabel lblForenameE2 = new JLabel("Forename");
		lblForenameE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblForenameE2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForenameE2.setBounds(618, 195, 111, 14);
		contentPane.add(lblForenameE2);
		
		JLabel lblSurnameE2 = new JLabel("Surname");
		lblSurnameE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSurnameE2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurnameE2.setBounds(618, 220, 111, 14);
		contentPane.add(lblSurnameE2);
		
		JLabel lblPhoneNumberE2 = new JLabel("Telephone Number");
		lblPhoneNumberE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPhoneNumberE2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumberE2.setBounds(618, 245, 111, 14);
		contentPane.add(lblPhoneNumberE2);
		
		JLabel lblEmailE2 = new JLabel("Email Address");
		lblEmailE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmailE2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailE2.setBounds(618, 270, 111, 14);
		contentPane.add(lblEmailE2);
		
		JLabel lblPaymentInformation = new JLabel("Payment Information");
		lblPaymentInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentInformation.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPaymentInformation.setBounds(10, 493, 272, 25);
		contentPane.add(lblPaymentInformation);
		
		JLabel lblBank = new JLabel("Bank/Building Society");
		lblBank.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblBank.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBank.setBounds(10, 529, 126, 14);
		contentPane.add(lblBank);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAccountNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountNumber.setBounds(10, 554, 126, 14);
		contentPane.add(lblAccountNumber);
		
		JLabel lblSortCode = new JLabel("Sort Code");
		lblSortCode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSortCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortCode.setBounds(10, 579, 126, 14);
		contentPane.add(lblSortCode);
		
		JLabel lblAccountHolder = new JLabel("Account Holder");
		lblAccountHolder.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAccountHolder.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountHolder.setBounds(10, 604, 126, 14);
		contentPane.add(lblAccountHolder);
		
		JLabel lblEmploymentInformation = new JLabel("Employment Information");
		lblEmploymentInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmploymentInformation.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmploymentInformation.setBounds(478, 359, 272, 25);
		contentPane.add(lblEmploymentInformation);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblJobTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJobTitle.setBounds(363, 394, 132, 14);
		contentPane.add(lblJobTitle);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartment.setBounds(363, 419, 132, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblRateOfPay = new JLabel("Rate of Pay");
		lblRateOfPay.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRateOfPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRateOfPay.setBounds(363, 469, 132, 14);
		contentPane.add(lblRateOfPay);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmployeeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeId.setBounds(363, 444, 132, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblRemainingHolidays = new JLabel("Remaining Holidays");
		lblRemainingHolidays.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRemainingHolidays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRemainingHolidays.setBounds(365, 493, 132, 14);
		contentPane.add(lblRemainingHolidays);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAvailability.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAvailability.setBounds(601, 395, 132, 14);
		contentPane.add(lblAvailability);
		
		JLabel lblContractedHours = new JLabel("Contracted Hours");
		lblContractedHours.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblContractedHours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContractedHours.setBounds(601, 419, 132, 14);
		contentPane.add(lblContractedHours);
		
		JLabel lblPayrollNumber = new JLabel("Payroll Number");
		lblPayrollNumber.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPayrollNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayrollNumber.setBounds(601, 493, 132, 14);
		contentPane.add(lblPayrollNumber);
		
		JLabel lblHoursWorked = new JLabel("Hours Worked");
		lblHoursWorked.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblHoursWorked.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoursWorked.setBounds(601, 444, 132, 14);
		contentPane.add(lblHoursWorked);
		
		JLabel lblAdditionalFeatures = new JLabel("Additional Features");
		lblAdditionalFeatures.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdditionalFeatures.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAdditionalFeatures.setBounds(657, 554, 272, 25);
		contentPane.add(lblAdditionalFeatures);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblChangePassword.setBounds(303, 529, 272, 25);
		contentPane.add(lblChangePassword);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentPassword.setBounds(273, 563, 161, 14);
		contentPane.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPassword.setBounds(273, 586, 161, 14);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblConfirmNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmNewPassword.setBounds(273, 611, 161, 14);
		contentPane.add(lblConfirmNewPassword);
		
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAttendance.setBounds(601, 469, 132, 14);
		contentPane.add(lblAttendance);
		
		txtTitle = new JTextField(employeeInfo.loggedInUser.title);
		txtTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtTitle.setEditable(false);
		txtTitle.setBounds(146, 131, 86, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtForename = new JTextField(employeeInfo.loggedInUser.forename);
		txtForename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtForename.setBounds(146, 156, 86, 20);
		contentPane.add(txtForename);
		txtForename.setColumns(10);
		
		txtSurname = new JTextField(employeeInfo.loggedInUser.surname);
		txtSurname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSurname.setBounds(146, 181, 86, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		txtDateOfBirth = new JTextField(employeeInfo.loggedInUser.dateOfBirth);
		txtDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtDateOfBirth.setEditable(false);
		txtDateOfBirth.setBounds(146, 206, 86, 20);
		contentPane.add(txtDateOfBirth);
		txtDateOfBirth.setColumns(10);
		
		txtGender = new JTextField(employeeInfo.loggedInUser.gender);
		txtGender.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtGender.setEditable(false);
		txtGender.setBounds(146, 231, 86, 20);
		contentPane.add(txtGender);
		txtGender.setColumns(10);
		
		txtAddress1 = new JTextField(employeeInfo.loggedInUser.address1);
		txtAddress1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAddress1.setBounds(146, 256, 86, 20);
		contentPane.add(txtAddress1);
		txtAddress1.setColumns(10);
		
		txtAddress2 = new JTextField(employeeInfo.loggedInUser.address2);
		txtAddress2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAddress2.setBounds(146, 281, 86, 20);
		contentPane.add(txtAddress2);
		txtAddress2.setColumns(10);
		
		txtTown = new JTextField(employeeInfo.loggedInUser.town);
		txtTown.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtTown.setBounds(146, 306, 86, 20);
		contentPane.add(txtTown);
		txtTown.setColumns(10);
		
		txtCounty = new JTextField(employeeInfo.loggedInUser.county);
		txtCounty.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtCounty.setBounds(146, 331, 86, 20);
		contentPane.add(txtCounty);
		txtCounty.setColumns(10);
		
		txtPostcode = new JTextField(employeeInfo.loggedInUser.postcode);
		txtPostcode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtPostcode.setBounds(146, 356, 86, 20);
		contentPane.add(txtPostcode);
		txtPostcode.setColumns(10);
		
		txtHomePhone = new JTextField(employeeInfo.loggedInUser.homePhone);
		txtHomePhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtHomePhone.setBounds(146, 381, 86, 20);
		contentPane.add(txtHomePhone);
		txtHomePhone.setColumns(10);
		
		txtMobilePhone = new JTextField(employeeInfo.loggedInUser.mobilePhone);
		txtMobilePhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtMobilePhone.setBounds(146, 406, 86, 20);
		contentPane.add(txtMobilePhone);
		txtMobilePhone.setColumns(10);
		
		txtEmail = new JTextField(employeeInfo.loggedInUser.email);
		txtEmail.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEmail.setBounds(146, 431, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtForenameE1 = new JTextField(employeeInfo.loggedInUser.emerg1Forename);
		txtForenameE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtForenameE1.setBounds(411, 192, 86, 20);
		contentPane.add(txtForenameE1);
		txtForenameE1.setColumns(10);
		
		txtSurnameE1 = new JTextField(employeeInfo.loggedInUser.emerg1Surname);
		txtSurnameE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSurnameE1.setBounds(411, 217, 86, 20);
		contentPane.add(txtSurnameE1);
		txtSurnameE1.setColumns(10);
		
		txtPhoneNumberE1 = new JTextField(employeeInfo.loggedInUser.emerg1Telephone);
		txtPhoneNumberE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtPhoneNumberE1.setBounds(411, 242, 86, 20);
		contentPane.add(txtPhoneNumberE1);
		txtPhoneNumberE1.setColumns(10);
		
		txtEmailE1 = new JTextField(employeeInfo.loggedInUser.emerg1Email);
		txtEmailE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEmailE1.setBounds(411, 267, 86, 20);
		contentPane.add(txtEmailE1);
		txtEmailE1.setColumns(10);
		
		txtForenameE2 = new JTextField(employeeInfo.loggedInUser.emerg2Forename);
		txtForenameE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtForenameE2.setColumns(10);
		txtForenameE2.setBounds(739, 189, 86, 20);
		contentPane.add(txtForenameE2);
		
		txtSurnameE2 = new JTextField(employeeInfo.loggedInUser.emerg2Surname);
		txtSurnameE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSurnameE2.setColumns(10);
		txtSurnameE2.setBounds(739, 214, 86, 20);
		contentPane.add(txtSurnameE2);
		
		txtPhoneNumberE2 = new JTextField(employeeInfo.loggedInUser.emerg2Telephone);
		txtPhoneNumberE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtPhoneNumberE2.setColumns(10);
		txtPhoneNumberE2.setBounds(739, 239, 86, 20);
		contentPane.add(txtPhoneNumberE2);
		
		txtEmailE2 = new JTextField(employeeInfo.loggedInUser.emerg2Email);
		txtEmailE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEmailE2.setColumns(10);
		txtEmailE2.setBounds(739, 264, 86, 20);
		contentPane.add(txtEmailE2);
		
		txtBank = new JTextField(employeeInfo.loggedInUser.bank);
		txtBank.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtBank.setBounds(146, 526, 86, 20);
		contentPane.add(txtBank);
		txtBank.setColumns(10);
		
		txtAccountNumber = new JTextField(employeeInfo.loggedInUser.accountNo);
		txtAccountNumber.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAccountNumber.setBounds(146, 551, 86, 20);
		contentPane.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		txtSortCode = new JTextField(employeeInfo.loggedInUser.sortCode);
		txtSortCode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSortCode.setBounds(146, 576, 86, 20);
		contentPane.add(txtSortCode);
		txtSortCode.setColumns(10);
		
		txtAccountHolder = new JTextField(employeeInfo.loggedInUser.acctName);
		txtAccountHolder.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAccountHolder.setBounds(146, 601, 86, 20);
		contentPane.add(txtAccountHolder);
		txtAccountHolder.setColumns(10);
		
		txtJobTitle = new JTextField(employeeInfo.loggedInUser.jobTitle);
		txtJobTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtJobTitle.setEditable(false);
		txtJobTitle.setBounds(505, 391, 86, 20);
		contentPane.add(txtJobTitle);
		txtJobTitle.setColumns(10);
		
		txtDepartment = new JTextField(employeeInfo.loggedInUser.dept);
		txtDepartment.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtDepartment.setEditable(false);
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(505, 416, 86, 20);
		contentPane.add(txtDepartment);
		
		txtEmployeeNo = new JTextField(String.valueOf(employeeInfo.loggedInUser.employeeNo));
		txtEmployeeNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEmployeeNo.setEditable(false);
		txtEmployeeNo.setColumns(10);
		txtEmployeeNo.setBounds(505, 441, 86, 20);
		contentPane.add(txtEmployeeNo);
		
		txtRateOfPay = new JTextField(String.valueOf(df.format(employeeInfo.loggedInUser.rateOfPay)));
		txtRateOfPay.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtRateOfPay.setEditable(false);
		txtRateOfPay.setColumns(10);
		txtRateOfPay.setBounds(505, 466, 86, 20);
		contentPane.add(txtRateOfPay);
		
		txtRemainingHolidays = new JTextField(String.valueOf(employeeInfo.loggedInUser.holidays));
		txtRemainingHolidays.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtRemainingHolidays.setEditable(false);
		txtRemainingHolidays.setColumns(10);
		txtRemainingHolidays.setBounds(505, 490, 86, 20);
		contentPane.add(txtRemainingHolidays);
		
		txtAvailability = new JTextField(employeeInfo.loggedInUser.availability);
		txtAvailability.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAvailability.setEditable(false);
		txtAvailability.setColumns(10);
		txtAvailability.setBounds(739, 391, 86, 20);
		contentPane.add(txtAvailability);
		
		txtContractedHours = new JTextField(String.valueOf(employeeInfo.loggedInUser.hoursWorked));
		txtContractedHours.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtContractedHours.setEditable(false);
		txtContractedHours.setColumns(10);
		txtContractedHours.setBounds(739, 416, 86, 20);
		contentPane.add(txtContractedHours);
		
		txtPayrollNo = new JTextField(employeeInfo.loggedInUser.payrollNo);
		txtPayrollNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtPayrollNo.setEditable(false);
		txtPayrollNo.setColumns(10);
		txtPayrollNo.setBounds(739, 490, 86, 20);
		contentPane.add(txtPayrollNo);
		
		txtHoursWorked = new JTextField(String.valueOf(employeeInfo.loggedInUser.attendance));
		txtHoursWorked.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtHoursWorked.setEditable(false);
		txtHoursWorked.setColumns(10);
		txtHoursWorked.setBounds(739, 441, 86, 20);
		contentPane.add(txtHoursWorked);
		
		txtAttendance = new JTextField(String.valueOf(df.format(attendance)));
		txtAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAttendance.setEditable(false);
		txtAttendance.setBounds(739, 466, 86, 20);
		contentPane.add(txtAttendance);
		
		txtCurrentPassword = new JPasswordField();
		txtCurrentPassword.setBounds(444, 560, 86, 20);
		contentPane.add(txtCurrentPassword);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setBounds(444, 583, 86, 20);
		contentPane.add(txtNewPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(444, 608, 86, 20);
		contentPane.add(txtConfirmPassword);
		
		// COMBO BOXES
		JComboBox cmbTitleE1 = new JComboBox();
		cmbTitleE1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTitleE1.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Miss", "Ms", "Dr"}));
		cmbTitleE1.setBounds(411, 167, 86, 20);
		contentPane.add(cmbTitleE1);
		
		JComboBox cmbTitleE2 = new JComboBox();
		cmbTitleE2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTitleE2.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Miss", "Ms", "Dr"}));
		cmbTitleE2.setBounds(739, 164, 86, 20);
		contentPane.add(cmbTitleE2);
		
		cmbTitleE1.setSelectedItem(employeeInfo.loggedInUser.emerg1Title);
		cmbTitleE2.setSelectedItem(employeeInfo.loggedInUser.emerg2Title);
		
		// BUTTONS
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear object to prevent user information leaking into new sessions
				employeeInfo.loggedInUser.clearObject();
				
				login lWindow = new login();
				uiNormal.this.setVisible(false);
				JOptionPane.showMessageDialog(null, "You are now logged out.");
				lWindow.setVisible(true);
			}
		});
		btnLogOut.setBounds(840, 11, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnPersonalSubmit = new JButton("Submit Changes");
		btnPersonalSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPersonalSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check for empty fields and show a message
				if(txtForename.getText().isEmpty() || 
					txtSurname.getText().isEmpty() || 
					txtAddress1.getText().isEmpty() || 
					txtTown.getText().isEmpty() || 
					txtCounty.getText().isEmpty() || 
					txtPostcode.getText().isEmpty() || 
					txtHomePhone.getText().isEmpty() || 
					txtMobilePhone.getText().isEmpty() || 
					txtEmail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more personal information fields are empty. Please check your data and try again.");
				} else {
					// Get text from fields and save in object variables
					employeeInfo.loggedInUser.forename = txtForename.getText();
					employeeInfo.loggedInUser.surname = txtSurname.getText();
					employeeInfo.loggedInUser.address1 = txtAddress1.getText();
					employeeInfo.loggedInUser.address2 = txtAddress2.getText();
					employeeInfo.loggedInUser.town = txtTown.getText();
					employeeInfo.loggedInUser.county = txtCounty.getText();
					employeeInfo.loggedInUser.postcode = txtPostcode.getText();
					employeeInfo.loggedInUser.homePhone = txtHomePhone.getText();
					employeeInfo.loggedInUser.mobilePhone = txtMobilePhone.getText();
					employeeInfo.loggedInUser.email = txtEmail.getText();
					
					// Create query to update info
					String updateQry =   "UPDATE employeeInfo SET " +
										" EMPLOYEE_FORENAME = '" + employeeInfo.loggedInUser.forename + "'," + 
										" EMPLOYEE_SURNAME = '" + employeeInfo.loggedInUser.surname + "'," +
										" EMPLOYEE_ADDRESS1 = '" + employeeInfo.loggedInUser.address1 + "'," +
										" EMPLOYEE_ADDRESS2 = '" + employeeInfo.loggedInUser.address2 + "'," +
										" EMPLOYEE_TOWN = '" + employeeInfo.loggedInUser.town + "'," +
										" EMPLOYEE_COUNTY = '" + employeeInfo.loggedInUser.county + "'," +
										" EMPLOYEE_POSTCODE = '" + employeeInfo.loggedInUser.postcode + "'," +
										" EMPLOYEE_HOMEPHONE = '" + employeeInfo.loggedInUser.homePhone + "'," + 
										" EMPLOYEE_MOBILEPHONE = '" + employeeInfo.loggedInUser.mobilePhone + "'," +
										" EMPLOYEE_EMAIL = '" + employeeInfo.loggedInUser.email + "'" +
										" WHERE EMPLOYEE_ID = " + loginCheck.l.sessionUser;
					try {
						updateInfo(updateQry);
						JOptionPane.showMessageDialog(null, "Your personal information has been updated!");
					} catch (Exception exc) {
						
					}
				}
			}
		});
		btnPersonalSubmit.setBounds(70, 459, 143, 23);
		contentPane.add(btnPersonalSubmit);
		
		JButton btnEmergencySubmit = new JButton("Submit Changes");
		btnEmergencySubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnEmergencySubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtForenameE1.getText().isEmpty() || 
					txtSurnameE1.getText().isEmpty() || 
					txtPhoneNumberE1.getText().isEmpty() || 
					txtEmailE1.getText().isEmpty() || 
					txtForenameE2.getText().isEmpty() || 
					txtSurnameE2.getText().isEmpty() || 
					txtPhoneNumberE2.getText().isEmpty() || 
					txtEmailE2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more emergency contact fields are empty. Please check your data and try again.");
				} else {
					employeeInfo.loggedInUser.emerg1Title = cmbTitleE1.getSelectedItem().toString();
					employeeInfo.loggedInUser.emerg1Forename = txtForenameE1.getText();
					employeeInfo.loggedInUser.emerg1Surname = txtSurnameE1.getText();
					employeeInfo.loggedInUser.emerg1Telephone = txtPhoneNumberE1.getText();
					employeeInfo.loggedInUser.emerg1Email = txtEmailE1.getText();
					employeeInfo.loggedInUser.emerg2Title = cmbTitleE2.getSelectedItem().toString();
					employeeInfo.loggedInUser.emerg2Forename = txtForenameE2.getText();
					employeeInfo.loggedInUser.emerg2Surname = txtSurnameE2.getText();
					employeeInfo.loggedInUser.emerg2Telephone = txtPhoneNumberE2.getText();
					employeeInfo.loggedInUser.emerg2Email = txtEmailE2.getText();
					
					String updateQry =   "UPDATE employeeInfo SET " +
										" EMPLOYEE_EMERG1TITLE = '" + employeeInfo.loggedInUser.emerg1Title + "'," + 
										" EMPLOYEE_EMERG1FORENAME = '" + employeeInfo.loggedInUser.emerg1Forename + "'," + 
										" EMPLOYEE_EMERG1SURNAME = '" + employeeInfo.loggedInUser.emerg1Surname + "'," + 
										" EMPLOYEE_EMERG1TELEPHONE = '" + employeeInfo.loggedInUser.emerg1Telephone + "'," + 
										" EMPLOYEE_EMERG1EMAIL = '" + employeeInfo.loggedInUser.emerg1Email + "'," + 
										" EMPLOYEE_EMERG2TITLE = '" + employeeInfo.loggedInUser.emerg2Title + "'," + 
										" EMPLOYEE_EMERG2FORENAME = '" + employeeInfo.loggedInUser.emerg2Forename + "'," + 
										" EMPLOYEE_EMERG2SURNAME = '" + employeeInfo.loggedInUser.emerg2Surname + "'," + 
										" EMPLOYEE_EMERG2TELEPHONE = '" + employeeInfo.loggedInUser.emerg2Telephone + "'," + 
										" EMPLOYEE_EMERG2EMAIL = '" + employeeInfo.loggedInUser.emerg2Email + "'" + 
										" WHERE EMPLOYEE_ID = " + loginCheck.l.sessionUser;
					try {
						updateInfo(updateQry);
						JOptionPane.showMessageDialog(null, "Your emergency contact information has been updated!");
					} catch (Exception exc) {
						
					}
				}
			}
		});
		btnEmergencySubmit.setBounds(505, 305, 143, 23);
		contentPane.add(btnEmergencySubmit);
		
		JButton btnPaymentSubmit = new JButton("Submit Changes");
		btnPaymentSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPaymentSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAccountNumber.getText().isEmpty() || 
					txtSortCode.getText().isEmpty() || 
					txtAccountHolder.getText().isEmpty() || 
					txtBank.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more payment information fields are empty. Please check your data and try again.");
				} else {
					employeeInfo.loggedInUser.accountNo = txtAccountNumber.getText();
					employeeInfo.loggedInUser.sortCode = txtSortCode.getText();
					employeeInfo.loggedInUser.bank = txtBank.getText();
					employeeInfo.loggedInUser.acctName = txtAccountHolder.getText();
					
					String updateQry =   "UPDATE employeeInfo SET " +
										" EMPLOYEE_ACCOUNTNO = '" + employeeInfo.loggedInUser.accountNo + "'," + 
										" EMPLOYEE_SORTCODE = '" + employeeInfo.loggedInUser.sortCode + "'," + 
										" EMPLOYEE_ACCOUNTNAME = '" + employeeInfo.loggedInUser.acctName + "'," + 
										" EMPLOYEE_BANK = '" + employeeInfo.loggedInUser.bank + "'" + 
										" WHERE EMPLOYEE_ID = " + loginCheck.l.sessionUser;
					try {
						updateInfo(updateQry);
						JOptionPane.showMessageDialog(null, "Your payment information has been updated!");
					} catch (Exception exc) {
						
					}
				}
			}
		});
		btnPaymentSubmit.setBounds(70, 629, 143, 23);
		contentPane.add(btnPaymentSubmit);
		
		JButton btnRequestHoliday = new JButton("Request Holiday");
		btnRequestHoliday.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRequestHoliday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				holidayRequest h = new holidayRequest();	// Create new instance of holiday request window
				h.setVisible(true);							// Open the window
				uiNormal.this.setVisible(false);			// Close the UI
			}
		});
		btnRequestHoliday.setBounds(684, 582, 224, 23);
		contentPane.add(btnRequestHoliday);
		
		JButton btnSubmitTicketTo = new JButton("Submit Ticket to HR");
		btnSubmitTicketTo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSubmitTicketTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitTicket s = new submitTicket();	// Create new instance of ticket submission window
				s.setVisible(true);						// Open the window
				uiNormal.this.setVisible(false);		// Close the UI
			}
		});
		btnSubmitTicketTo.setBounds(684, 607, 224, 23);
		contentPane.add(btnSubmitTicketTo);
		
		JButton btnChangePassword = new JButton("Submit Changes");
		btnChangePassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Save passwords as character array
				char[] passwordValidation = txtCurrentPassword.getPassword();
				char[] newPass = txtNewPassword.getPassword();
				char[] passConf = txtConfirmPassword.getPassword();
				
				// Check the current password is valid
				if(Arrays.equals(passwordValidation, loginCheck.l.sessionPwd)){
					// Check the new password matches the confirmation
					if(Arrays.equals(newPass, passConf)){
						try {
							loginCheck.l.changePass(newPass);
							JOptionPane.showMessageDialog(null, "Your password has been changed.");
						} catch (Exception exc) {
							System.out.println(exc);
						}
					} else {
						JOptionPane.showMessageDialog(null, "New password does not match confirmation. Please try again.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Your current password is incorrect. Please try again.");
				}
			}
		});
		btnChangePassword.setBounds(366, 641, 143, 23);
		contentPane.add(btnChangePassword);
		
		JButton btnViewResponses = new JButton("View Responses");
		btnViewResponses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewResponses v = new viewResponses();
				v.setVisible(true);
				uiNormal.this.setVisible(false);
			}
		});
		btnViewResponses.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnViewResponses.setBounds(684, 632, 223, 23);
		contentPane.add(btnViewResponses);
		
		JButton btnViewPayslip = new JButton("View Payslip");
		btnViewPayslip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payslip p = new payslip();
				uiNormal.this.setVisible(false);
				p.setVisible(true);
			}
		});
		btnViewPayslip.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnViewPayslip.setBounds(684, 657, 223, 23);
		contentPane.add(btnViewPayslip);
	}
	
	private void updateInfo(String qry) throws SQLException {
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
}
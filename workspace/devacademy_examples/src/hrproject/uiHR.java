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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class uiHR extends JFrame {

	private JPanel contentPane;
	private JTextField txtForename;
	private JTextField txtSurname;
	private JTextField txtDateOfBirth;
	private JTextField txtGender;
	private JTextField txtAddressLine1;
	private JTextField txtAddressLine2;
	private JTextField txtTown;
	private JTextField txtCounty;
	private JTextField txtPostcode;
	private JTextField txtHomePhone;
	private JTextField txtMobilePhone;
	private JTextField txtEmail;
	private JTextField txtE1Forename;
	private JTextField txtE1Surname;
	private JTextField txtE1Telephone;
	private JTextField txtE1Email;
	private JTextField txtE2Forename;
	private JTextField txtE2Surname;
	private JTextField txtE2Telephone;
	private JTextField txtE2Email;
	private JTextField txtBank;
	private JTextField txtAccountNo;
	private JTextField txtSortCode;
	private JTextField txtAccountHolder;
	private JTextField txtJobTitle;
	private JTextField txtDept;
	private JTextField txtEmployeeID;
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
					uiHR frame = new uiHR();
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
	public uiHR() {
		// Customise JOptionPane according to style
		UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Century Gothic", Font.PLAIN, 11));
		UIManager.put("OptionPane.background", SystemColor.activeCaption);
		UIManager.put("Panel.background", SystemColor.activeCaption);
		// Decimal format mask for money values
		DecimalFormat df = new DecimalFormat("####0.00");
		// Get user info. Try catch because it throws SQLException
		try {
			employeeInfo.loggedInUser.selectInfo();
		} catch(Exception exc) {
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 857);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ICONS
		// Gets the profile picture for the logged in user by adding their employee ID to the image path
		ImageIcon hrIcon = new ImageIcon("./img/" + loginCheck.l.sessionUser + ".jpg");
		
		//LABELS
		JLabel lblHRImg = new JLabel();
		lblHRImg.setBounds(0, 0, 90, 90);
		contentPane.add(lblHRImg);
		lblHRImg.setIcon(hrIcon);
		
		JLabel lblImg = new JLabel();
		lblImg.setBounds(0, 101, 90, 90);
		contentPane.add(lblImg);
		
		JLabel lblPersonalInformation = new JLabel("Your Personal Information");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPersonalInformation.setBounds(10, 196, 272, 25);
		contentPane.add(lblPersonalInformation);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(0, 235, 136, 14);
		contentPane.add(lblTitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(0, 260, 136, 14);
		contentPane.add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(0, 285, 136, 14);
		contentPane.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setBounds(0, 310, 136, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(0, 335, 136, 14);
		contentPane.add(lblGender);
		
		JLabel lblAddressLine1 = new JLabel("Address Line 1");
		lblAddressLine1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAddressLine1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressLine1.setBounds(0, 360, 136, 14);
		contentPane.add(lblAddressLine1);
		
		JLabel lblAddressLine2 = new JLabel("Address Line 2");
		lblAddressLine2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAddressLine2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressLine2.setBounds(0, 385, 136, 14);
		contentPane.add(lblAddressLine2);
		
		JLabel lblTown = new JLabel("Town/City");
		lblTown.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTown.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTown.setBounds(0, 410, 136, 14);
		contentPane.add(lblTown);
		
		JLabel lblCounty = new JLabel("County");
		lblCounty.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCounty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCounty.setBounds(0, 435, 136, 14);
		contentPane.add(lblCounty);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPostcode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostcode.setBounds(0, 460, 136, 14);
		contentPane.add(lblPostcode);
		
		JLabel lolHomePhone = new JLabel("Home Phone Number");
		lolHomePhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lolHomePhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lolHomePhone.setBounds(0, 485, 136, 14);
		contentPane.add(lolHomePhone);
		
		JLabel lblMobilePhone = new JLabel("Mobile Phone Number");
		lblMobilePhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblMobilePhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobilePhone.setBounds(0, 510, 136, 14);
		contentPane.add(lblMobilePhone);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(0, 535, 136, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEmergencyDetails = new JLabel("Emergency Contact Details");
		lblEmergencyDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergencyDetails.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmergencyDetails.setBounds(478, 196, 272, 25);
		contentPane.add(lblEmergencyDetails);
		
		JLabel lblEmergency1 = new JLabel("Emergency Contact 1");
		lblEmergency1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergency1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmergency1.setBounds(319, 235, 272, 25);
		contentPane.add(lblEmergency1);
		
		JLabel lblEmergency2 = new JLabel("Emergency Contact 2");
		lblEmergency2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergency2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmergency2.setBounds(635, 235, 272, 25);
		contentPane.add(lblEmergency2);
		
		JLabel lblE1Title = new JLabel("Title");
		lblE1Title.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE1Title.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE1Title.setBounds(290, 271, 111, 14);
		contentPane.add(lblE1Title);
		
		JLabel lblE1Forename = new JLabel("Forename");
		lblE1Forename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE1Forename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE1Forename.setBounds(290, 296, 111, 14);
		contentPane.add(lblE1Forename);
		
		JLabel lblE1Surname = new JLabel("Surname");
		lblE1Surname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE1Surname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE1Surname.setBounds(290, 321, 111, 14);
		contentPane.add(lblE1Surname);
		
		JLabel lblE1Telephone = new JLabel("Telephone Number");
		lblE1Telephone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE1Telephone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE1Telephone.setBounds(290, 346, 111, 14);
		contentPane.add(lblE1Telephone);
		
		JLabel lblE1Email = new JLabel("Email Address");
		lblE1Email.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE1Email.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE1Email.setBounds(290, 371, 111, 14);
		contentPane.add(lblE1Email);
		
		JLabel lblE2Title = new JLabel("Title");
		lblE2Title.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE2Title.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE2Title.setBounds(618, 271, 111, 14);
		contentPane.add(lblE2Title);
		
		JLabel lblE2Forename = new JLabel("Forename");
		lblE2Forename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE2Forename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE2Forename.setBounds(618, 296, 111, 14);
		contentPane.add(lblE2Forename);
		
		JLabel lblE2Surname = new JLabel("Surname");
		lblE2Surname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE2Surname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE2Surname.setBounds(618, 321, 111, 14);
		contentPane.add(lblE2Surname);
		
		JLabel lblE2Telephone = new JLabel("Telephone Number");
		lblE2Telephone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE2Telephone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE2Telephone.setBounds(618, 346, 111, 14);
		contentPane.add(lblE2Telephone);
		
		JLabel lblE2Email = new JLabel("Email Address");
		lblE2Email.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblE2Email.setHorizontalAlignment(SwingConstants.RIGHT);
		lblE2Email.setBounds(618, 371, 111, 14);
		contentPane.add(lblE2Email);
		
		JLabel lblPaymentInfo = new JLabel("Payment Information");
		lblPaymentInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentInfo.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPaymentInfo.setBounds(10, 594, 272, 25);
		contentPane.add(lblPaymentInfo);
		
		JLabel lblBank = new JLabel("Bank/Building Society");
		lblBank.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblBank.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBank.setBounds(10, 630, 126, 14);
		contentPane.add(lblBank);
		
		JLabel lblAccountNo = new JLabel("Account Number");
		lblAccountNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAccountNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountNo.setBounds(10, 655, 126, 14);
		contentPane.add(lblAccountNo);
		
		JLabel lblSortCode = new JLabel("Sort Code");
		lblSortCode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSortCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortCode.setBounds(10, 680, 126, 14);
		contentPane.add(lblSortCode);
		
		JLabel lblAccountHolder = new JLabel("Account Holder");
		lblAccountHolder.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAccountHolder.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountHolder.setBounds(10, 705, 126, 14);
		contentPane.add(lblAccountHolder);
		
		JLabel lblEmploymentInfo = new JLabel("Employment Information");
		lblEmploymentInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmploymentInfo.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEmploymentInfo.setBounds(478, 460, 272, 25);
		contentPane.add(lblEmploymentInfo);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblJobTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJobTitle.setBounds(343, 499, 132, 14);
		contentPane.add(lblJobTitle);
		
		JLabel lblDept = new JLabel("Department");
		lblDept.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDept.setBounds(343, 524, 132, 14);
		contentPane.add(lblDept);
		
		JLabel lblRateOfPay = new JLabel("Rate of Pay");
		lblRateOfPay.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRateOfPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRateOfPay.setBounds(343, 574, 132, 14);
		contentPane.add(lblRateOfPay);
		
		JLabel lblEmployeeID = new JLabel("Employee ID");
		lblEmployeeID.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmployeeID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeID.setBounds(343, 549, 132, 14);
		contentPane.add(lblEmployeeID);
		
		JLabel lblRemainingHolidays = new JLabel("Remaining Holidays");
		lblRemainingHolidays.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRemainingHolidays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRemainingHolidays.setBounds(345, 598, 132, 14);
		contentPane.add(lblRemainingHolidays);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAvailability.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAvailability.setBounds(581, 500, 132, 14);
		contentPane.add(lblAvailability);
		
		JLabel lblContractedHours = new JLabel("Contracted Hours");
		lblContractedHours.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblContractedHours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContractedHours.setBounds(581, 524, 132, 14);
		contentPane.add(lblContractedHours);
		
		JLabel lblPayrollNo = new JLabel("Payroll Number");
		lblPayrollNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPayrollNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayrollNo.setBounds(581, 595, 132, 14);
		contentPane.add(lblPayrollNo);
		
		JLabel lblHoursWorked = new JLabel("Hours Worked");
		lblHoursWorked.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblHoursWorked.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoursWorked.setBounds(581, 547, 132, 14);
		contentPane.add(lblHoursWorked);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an employee");
		lblPleaseSelectAn.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPleaseSelectAn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPleaseSelectAn.setBounds(163, 115, 221, 14);
		contentPane.add(lblPleaseSelectAn);
		
		JLabel lblWelcome = new JLabel("Welcome, " + employeeInfo.loggedInUser.forename + " " + employeeInfo.loggedInUser.surname + "!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblWelcome.setBounds(10, 11, 916, 49);
		contentPane.add(lblWelcome);
		
		JLabel lblHrOptions = new JLabel("Additional Features");
		lblHrOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblHrOptions.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblHrOptions.setBounds(580, 663, 272, 25);
		contentPane.add(lblHrOptions);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblChangePassword.setBounds(267, 663, 272, 25);
		contentPane.add(lblChangePassword);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurrentPassword.setBounds(242, 697, 156, 14);
		contentPane.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPassword.setBounds(242, 720, 156, 14);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm New Password");
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setBounds(242, 745, 156, 14);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAttendance.setBounds(581, 570, 132, 14);
		contentPane.add(lblAttendance);
		
		txtForename = new JTextField(employeeInfo.hrSelectedUser.forename);
		txtForename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtForename.setColumns(10);
		txtForename.setBounds(146, 257, 86, 20);
		contentPane.add(txtForename);
		
		txtSurname = new JTextField(employeeInfo.hrSelectedUser.surname);
		txtSurname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSurname.setColumns(10);
		txtSurname.setBounds(146, 282, 86, 20);
		contentPane.add(txtSurname);
		
		txtDateOfBirth = new JTextField(employeeInfo.hrSelectedUser.dateOfBirth);
		txtDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBounds(146, 307, 86, 20);
		contentPane.add(txtDateOfBirth);
		
		txtGender = new JTextField(employeeInfo.hrSelectedUser.gender);
		txtGender.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtGender.setColumns(10);
		txtGender.setBounds(146, 332, 86, 20);
		contentPane.add(txtGender);
		
		txtAddressLine1 = new JTextField(employeeInfo.hrSelectedUser.address1);
		txtAddressLine1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAddressLine1.setColumns(10);
		txtAddressLine1.setBounds(146, 357, 86, 20);
		contentPane.add(txtAddressLine1);
		
		txtAddressLine2 = new JTextField(employeeInfo.hrSelectedUser.address2);
		txtAddressLine2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAddressLine2.setColumns(10);
		txtAddressLine2.setBounds(146, 382, 86, 20);
		contentPane.add(txtAddressLine2);
		
		txtTown = new JTextField(employeeInfo.hrSelectedUser.town);
		txtTown.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtTown.setColumns(10);
		txtTown.setBounds(146, 407, 86, 20);
		contentPane.add(txtTown);
		
		txtCounty = new JTextField(employeeInfo.hrSelectedUser.county);
		txtCounty.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtCounty.setColumns(10);
		txtCounty.setBounds(146, 432, 86, 20);
		contentPane.add(txtCounty);
		
		txtPostcode = new JTextField(employeeInfo.hrSelectedUser.postcode);
		txtPostcode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtPostcode.setColumns(10);
		txtPostcode.setBounds(146, 457, 86, 20);
		contentPane.add(txtPostcode);
		
		txtHomePhone = new JTextField(employeeInfo.hrSelectedUser.homePhone);
		txtHomePhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtHomePhone.setColumns(10);
		txtHomePhone.setBounds(146, 482, 86, 20);
		contentPane.add(txtHomePhone);
		
		txtMobilePhone = new JTextField(employeeInfo.hrSelectedUser.mobilePhone);
		txtMobilePhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtMobilePhone.setColumns(10);
		txtMobilePhone.setBounds(146, 507, 86, 20);
		contentPane.add(txtMobilePhone);
		
		txtEmail = new JTextField(employeeInfo.hrSelectedUser.email);
		txtEmail.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 532, 86, 20);
		contentPane.add(txtEmail);
		
		txtE1Forename = new JTextField(employeeInfo.hrSelectedUser.emerg1Forename);
		txtE1Forename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE1Forename.setColumns(10);
		txtE1Forename.setBounds(411, 293, 86, 20);
		contentPane.add(txtE1Forename);
		
		txtE1Surname = new JTextField(employeeInfo.hrSelectedUser.emerg1Surname);
		txtE1Surname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE1Surname.setColumns(10);
		txtE1Surname.setBounds(411, 318, 86, 20);
		contentPane.add(txtE1Surname);
		
		txtE1Telephone = new JTextField(employeeInfo.hrSelectedUser.emerg1Telephone);
		txtE1Telephone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE1Telephone.setColumns(10);
		txtE1Telephone.setBounds(411, 343, 86, 20);
		contentPane.add(txtE1Telephone);
		
		txtE1Email = new JTextField(employeeInfo.hrSelectedUser.emerg1Email);
		txtE1Email.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE1Email.setColumns(10);
		txtE1Email.setBounds(411, 368, 86, 20);
		contentPane.add(txtE1Email);
		
		txtE2Forename = new JTextField(employeeInfo.hrSelectedUser.emerg2Forename);
		txtE2Forename.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE2Forename.setColumns(10);
		txtE2Forename.setBounds(739, 290, 86, 20);
		contentPane.add(txtE2Forename);
		
		txtE2Surname = new JTextField(employeeInfo.hrSelectedUser.emerg2Surname);
		txtE2Surname.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE2Surname.setColumns(10);
		txtE2Surname.setBounds(739, 315, 86, 20);
		contentPane.add(txtE2Surname);
		
		txtE2Telephone = new JTextField(employeeInfo.hrSelectedUser.emerg2Telephone);
		txtE2Telephone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE2Telephone.setColumns(10);
		txtE2Telephone.setBounds(739, 340, 86, 20);
		contentPane.add(txtE2Telephone);
		
		txtE2Email = new JTextField(employeeInfo.hrSelectedUser.emerg2Email);
		txtE2Email.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtE2Email.setColumns(10);
		txtE2Email.setBounds(739, 365, 86, 20);
		contentPane.add(txtE2Email);
		
		txtBank = new JTextField(employeeInfo.hrSelectedUser.bank);
		txtBank.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtBank.setColumns(10);
		txtBank.setBounds(146, 627, 86, 20);
		contentPane.add(txtBank);
		
		txtAccountNo = new JTextField(employeeInfo.hrSelectedUser.accountNo);
		txtAccountNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(146, 652, 86, 20);
		contentPane.add(txtAccountNo);
		
		txtSortCode = new JTextField(employeeInfo.hrSelectedUser.sortCode);
		txtSortCode.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSortCode.setColumns(10);
		txtSortCode.setBounds(146, 677, 86, 20);
		contentPane.add(txtSortCode);
		
		txtAccountHolder = new JTextField(employeeInfo.hrSelectedUser.acctName);
		txtAccountHolder.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAccountHolder.setColumns(10);
		txtAccountHolder.setBounds(146, 702, 86, 20);
		contentPane.add(txtAccountHolder);
		
		txtJobTitle = new JTextField(employeeInfo.hrSelectedUser.jobTitle);
		txtJobTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtJobTitle.setColumns(10);
		txtJobTitle.setBounds(485, 496, 86, 20);
		contentPane.add(txtJobTitle);
		
		txtDept = new JTextField(employeeInfo.hrSelectedUser.dept);
		txtDept.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtDept.setColumns(10);
		txtDept.setBounds(485, 521, 86, 20);
		contentPane.add(txtDept);
		
		txtEmployeeID = new JTextField(employeeInfo.hrSelectedUser.employeeNo);
		txtEmployeeID.setEditable(false);
		txtEmployeeID.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtEmployeeID.setColumns(10);
		txtEmployeeID.setBounds(485, 546, 86, 20);
		contentPane.add(txtEmployeeID);
		
		txtRateOfPay = new JTextField(String.valueOf(df.format(employeeInfo.hrSelectedUser.rateOfPay)));
		txtRateOfPay.setCaretPosition(0);
		txtRateOfPay.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtRateOfPay.setColumns(10);
		txtRateOfPay.setBounds(485, 571, 86, 20);
		contentPane.add(txtRateOfPay);
		
		txtRemainingHolidays = new JTextField(employeeInfo.hrSelectedUser.holidays);
		txtRemainingHolidays.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtRemainingHolidays.setColumns(10);
		txtRemainingHolidays.setBounds(485, 595, 86, 20);
		contentPane.add(txtRemainingHolidays);
		
		txtAvailability = new JTextField(employeeInfo.hrSelectedUser.availability);
		txtAvailability.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAvailability.setColumns(10);
		txtAvailability.setBounds(719, 496, 86, 20);
		contentPane.add(txtAvailability);
		
		txtContractedHours = new JTextField(employeeInfo.hrSelectedUser.hoursWorked);
		txtContractedHours.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtContractedHours.setColumns(10);
		txtContractedHours.setBounds(719, 521, 86, 20);
		contentPane.add(txtContractedHours);
		
		txtPayrollNo = new JTextField(employeeInfo.hrSelectedUser.payrollNo);
		txtPayrollNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtPayrollNo.setColumns(10);
		txtPayrollNo.setBounds(719, 592, 86, 20);
		contentPane.add(txtPayrollNo);
		
		txtHoursWorked = new JTextField(employeeInfo.hrSelectedUser.attendance);
		txtHoursWorked.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtHoursWorked.setColumns(10);
		txtHoursWorked.setBounds(719, 545, 86, 20);
		contentPane.add(txtHoursWorked);
		
		txtAttendance = new JTextField(10);
		txtAttendance.setEditable(false);
		txtAttendance.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtAttendance.setBounds(719, 568, 86, 20);
		contentPane.add(txtAttendance);
		
		txtCurrentPassword = new JPasswordField();
		txtCurrentPassword.setBounds(408, 694, 86, 20);
		contentPane.add(txtCurrentPassword);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setBounds(408, 717, 86, 20);
		contentPane.add(txtNewPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(408, 742, 86, 20);
		contentPane.add(txtConfirmPassword);
		
		//COMBO BOXES
		JComboBox cmbE1Title = new JComboBox();
		cmbE1Title.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbE1Title.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Miss", "Ms", "Dr"}));
		cmbE1Title.setBounds(411, 268, 86, 20);
		contentPane.add(cmbE1Title);
		
		JComboBox cmbE2Title = new JComboBox();
		cmbE2Title.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbE2Title.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Miss", "Ms", "Dr"}));
		cmbE2Title.setBounds(739, 265, 86, 20);
		contentPane.add(cmbE2Title);
		
		JComboBox cmbEmployeeSelect = new JComboBox();
		cmbEmployeeSelect.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbEmployeeSelect.setBounds(394, 112, 356, 20);
		contentPane.add(cmbEmployeeSelect);
		
		JComboBox cmbTitle = new JComboBox();
		cmbTitle.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Miss", "Ms", "Dr"}));
		cmbTitle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTitle.setBounds(146, 232, 86, 20);
		contentPane.add(cmbTitle);
		
		// BUTTONS
		JButton btnPersonalSubmit = new JButton("Submit Changes");
		btnPersonalSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPersonalSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checks if any text boxes are empty before displaying a message
				if(txtForename.getText().isEmpty() || 
						txtSurname.getText().isEmpty() || 
						txtDateOfBirth.getText().isEmpty() ||
						txtGender.getText().isEmpty() ||
						txtAddressLine1.getText().isEmpty() || 
						txtTown.getText().isEmpty() || 
						txtCounty.getText().isEmpty() || 
						txtPostcode.getText().isEmpty() || 
						txtHomePhone.getText().isEmpty() || 
						txtMobilePhone.getText().isEmpty() || 
						txtEmail.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "One or more personal information fields are empty. Please check your data and try again.");
					} else { // If all fields are completed, set variables in object to text in boxes
						employeeInfo.hrSelectedUser.title = cmbTitle.getSelectedItem().toString();
						employeeInfo.hrSelectedUser.forename = txtForename.getText();
						employeeInfo.hrSelectedUser.surname = txtSurname.getText();
						employeeInfo.hrSelectedUser.dateOfBirth = txtDateOfBirth.getText();
						employeeInfo.hrSelectedUser.gender = txtGender.getText();
						employeeInfo.hrSelectedUser.address1 = txtAddressLine1.getText();
						employeeInfo.hrSelectedUser.address2 = txtAddressLine2.getText();
						employeeInfo.hrSelectedUser.town = txtTown.getText();
						employeeInfo.hrSelectedUser.county = txtCounty.getText();
						employeeInfo.hrSelectedUser.postcode = txtPostcode.getText();
						employeeInfo.hrSelectedUser.homePhone = txtHomePhone.getText();
						employeeInfo.hrSelectedUser.mobilePhone = txtMobilePhone.getText();
						employeeInfo.hrSelectedUser.email = txtEmail.getText();
						
						// Create query with new information
						String updateQry =   "UPDATE employeeInfo SET " +
											" EMPLOYEE_TITLE = '" + employeeInfo.hrSelectedUser.title + "'," +
											" EMPLOYEE_FORENAME = '" + employeeInfo.hrSelectedUser.forename + "'," + 
											" EMPLOYEE_SURNAME = '" + employeeInfo.hrSelectedUser.surname + "'," +
											" EMPLOYEE_ADDRESS1 = '" + employeeInfo.hrSelectedUser.address1 + "'," +
											" EMPLOYEE_ADDRESS2 = '" + employeeInfo.hrSelectedUser.address2 + "'," +
											" EMPLOYEE_TOWN = '" + employeeInfo.hrSelectedUser.town + "'," +
											" EMPLOYEE_COUNTY = '" + employeeInfo.hrSelectedUser.county + "'," +
											" EMPLOYEE_POSTCODE = '" + employeeInfo.hrSelectedUser.postcode + "'," +
											" EMPLOYEE_HOMEPHONE = '" + employeeInfo.hrSelectedUser.homePhone + "'," + 
											" EMPLOYEE_MOBILEPHONE = '" + employeeInfo.hrSelectedUser.mobilePhone + "'," +
											" EMPLOYEE_EMAIL = '" + employeeInfo.hrSelectedUser.email + "'" +
											" WHERE EMPLOYEE_ID = " + employeeInfo.hrSelectedUser.employeeNo;
						try {
							updateInfo(updateQry);
							JOptionPane.showMessageDialog(null, "Personal information for this employee has been updated!");
						} catch (Exception exc) {
							
						}
					}
			}
		});
		btnPersonalSubmit.setBounds(70, 560, 143, 23);
		contentPane.add(btnPersonalSubmit);
		
		JButton btnEmergencySubmit = new JButton("Submit Changes");
		btnEmergencySubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnEmergencySubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if any fields are empty before displaying a message
				if(txtE1Forename.getText().isEmpty() || 
					txtE1Surname.getText().isEmpty() || 
					txtE1Telephone.getText().isEmpty() || 
					txtE1Email.getText().isEmpty() || 
					txtE2Forename.getText().isEmpty() || 
					txtE2Surname.getText().isEmpty() || 
					txtE2Telephone.getText().isEmpty() || 
					txtE2Email.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more emergency contact fields are empty. Please check your data and try again.");
				} else { // If all fields are complete, assign text in boxes to object variables
					employeeInfo.hrSelectedUser.emerg1Title = cmbE1Title.getSelectedItem().toString();
					employeeInfo.hrSelectedUser.emerg1Forename = txtE1Forename.getText();
					employeeInfo.hrSelectedUser.emerg1Surname = txtE1Surname.getText();
					employeeInfo.hrSelectedUser.emerg1Telephone = txtE1Telephone.getText();
					employeeInfo.hrSelectedUser.emerg1Email = txtE1Email.getText();
					employeeInfo.hrSelectedUser.emerg2Title = cmbE2Title.getSelectedItem().toString();
					employeeInfo.hrSelectedUser.emerg2Forename = txtE2Forename.getText();
					employeeInfo.hrSelectedUser.emerg2Surname = txtE2Surname.getText();
					employeeInfo.hrSelectedUser.emerg2Telephone = txtE2Telephone.getText();
					employeeInfo.hrSelectedUser.emerg2Email = txtE2Email.getText();
					
					// Create query with new information
					String updateQry =   "UPDATE employeeInfo SET " +
										" EMPLOYEE_EMERG1TITLE = '" + employeeInfo.hrSelectedUser.emerg1Title + "'," + 
										" EMPLOYEE_EMERG1FORENAME = '" + employeeInfo.hrSelectedUser.emerg1Forename + "'," + 
										" EMPLOYEE_EMERG1SURNAME = '" + employeeInfo.hrSelectedUser.emerg1Surname + "'," + 
										" EMPLOYEE_EMERG1TELEPHONE = '" + employeeInfo.hrSelectedUser.emerg1Telephone + "'," + 
										" EMPLOYEE_EMERG1EMAIL = '" + employeeInfo.hrSelectedUser.emerg1Email + "'," + 
										" EMPLOYEE_EMERG2TITLE = '" + employeeInfo.hrSelectedUser.emerg2Title + "'," + 
										" EMPLOYEE_EMERG2FORENAME = '" + employeeInfo.hrSelectedUser.emerg2Forename + "'," + 
										" EMPLOYEE_EMERG2SURNAME = '" + employeeInfo.hrSelectedUser.emerg2Surname + "'," + 
										" EMPLOYEE_EMERG2TELEPHONE = '" + employeeInfo.hrSelectedUser.emerg2Telephone + "'," + 
										" EMPLOYEE_EMERG2EMAIL = '" + employeeInfo.hrSelectedUser.emerg2Email + "'" + 
										" WHERE EMPLOYEE_ID = " + employeeInfo.hrSelectedUser.employeeNo;
					try {
						updateInfo(updateQry);
						JOptionPane.showMessageDialog(null, "Emergency contact information for this employee has been updated!");
					} catch (Exception exc) {
						
					}
				}
			}
		});
		btnEmergencySubmit.setBounds(505, 406, 143, 23);
		contentPane.add(btnEmergencySubmit);
		
		JButton btnPaymentSubmit = new JButton("Submit Changes");
		btnPaymentSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPaymentSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if any fields are empty before displaying a message
				if(txtAccountNo.getText().isEmpty() || 
					txtSortCode.getText().isEmpty() || 
					txtAccountHolder.getText().isEmpty() || 
					txtBank.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more payment information fields are empty. Please check your data and try again.");
				} else { // If all fields are complete, assign text in fields to object variables
					employeeInfo.hrSelectedUser.accountNo = txtAccountNo.getText();
					employeeInfo.hrSelectedUser.sortCode = txtSortCode.getText();
					employeeInfo.hrSelectedUser.bank = txtBank.getText();
					employeeInfo.hrSelectedUser.acctName = txtAccountHolder.getText();
					
					// Create query with updated information
					String updateQry =   "UPDATE employeeInfo SET " +
										" EMPLOYEE_ACCOUNTNO = '" + employeeInfo.hrSelectedUser.accountNo + "'," + 
										" EMPLOYEE_SORTCODE = '" + employeeInfo.hrSelectedUser.sortCode + "'," + 
										" EMPLOYEE_ACCOUNTNAME = '" + employeeInfo.hrSelectedUser.acctName + "'," + 
										" EMPLOYEE_BANK = '" + employeeInfo.hrSelectedUser.bank + "'" + 
										" WHERE EMPLOYEE_ID = " + employeeInfo.hrSelectedUser.employeeNo;
					try {
						updateInfo(updateQry);
						JOptionPane.showMessageDialog(null, "Payment information for this employee has been updated!");
					} catch (Exception exc) {
						
					}
				}
			}
		});
		btnPaymentSubmit.setBounds(70, 730, 143, 23);
		contentPane.add(btnPaymentSubmit);
		
		JButton btnEmploymentSubmit = new JButton("Submit Changes");
		btnEmploymentSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnEmploymentSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if any fields are empty before displaying a message
				if(txtJobTitle.getText().isEmpty() || 
					txtDept.getText().isEmpty() || 
					txtAvailability.getText().isEmpty() || 
					txtPayrollNo.getText().isEmpty() || 
					txtContractedHours.getText().isEmpty() || 
					txtHoursWorked.getText().isEmpty() || 
					txtRemainingHolidays.getText().isEmpty() || 
					txtRateOfPay.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "One or more employment information fields are empty. Please check your data and try again.");
				} else { // If all fields are complete, assign text in fields to object variables
					employeeInfo.hrSelectedUser.availability = txtAvailability.getText();
					employeeInfo.hrSelectedUser.jobTitle = txtJobTitle.getText();
					employeeInfo.hrSelectedUser.dept = txtDept.getText();
					employeeInfo.hrSelectedUser.payrollNo = txtPayrollNo.getText();
					employeeInfo.hrSelectedUser.hoursWorked = (int) Double.parseDouble(txtContractedHours.getText());
					employeeInfo.hrSelectedUser.attendance = (int) Double.parseDouble(txtHoursWorked.getText());
					employeeInfo.hrSelectedUser.holidays = (int) Double.parseDouble(txtRemainingHolidays.getText());
					employeeInfo.hrSelectedUser.rateOfPay = Float.parseFloat(txtRateOfPay.getText());
					
					// Create query with new information
					String updateQry =   "UPDATE employeeInfo SET " +
										" EMPLOYEE_AVAILABILITY = '" + employeeInfo.hrSelectedUser.availability + "'," + 
										" EMPLOYEE_JOBTITLE = '" + employeeInfo.hrSelectedUser.jobTitle + "'," + 
										" EMPLOYEE_DEPARTMENT = '" + employeeInfo.hrSelectedUser.dept + "'," + 
										" EMPLOYEE_PAYROLLNO = " + employeeInfo.hrSelectedUser.payrollNo + "," + 
										" EMPLOYEE_HOURSWORKED = " + employeeInfo.hrSelectedUser.hoursWorked + "," + 
										" EMPLOYEE_ATTENDANCE = " + employeeInfo.hrSelectedUser.attendance + "," + 
										" EMPLOYEE_HOLIDAYS = " + employeeInfo.hrSelectedUser.holidays + "," + 
										" EMPLOYEE_RATEOFPAY = " + employeeInfo.hrSelectedUser.rateOfPay + "" + 
										" WHERE EMPLOYEE_ID = " + employeeInfo.hrSelectedUser.employeeNo;
					try {
						updateInfo(updateQry);
						JOptionPane.showMessageDialog(null, "Employment information for this employee has been updated!");
					} catch (Exception exc) {
						
					}
				}
			}
		});
		btnEmploymentSubmit.setBounds(505, 626, 143, 23);
		contentPane.add(btnEmploymentSubmit);
		
		JButton btnPasswordSubmit = new JButton("Submit Changes");
		btnPasswordSubmit.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPasswordSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Save passwords in character array
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
							// Handle exceptions
						}
					} else { // New password and password confirmation do not match
						JOptionPane.showMessageDialog(null, "New password does not match confirmation. Please try again.");
					}
				} else { // Current password is incorrect
					JOptionPane.showMessageDialog(null, "Your current password is incorrect. Please try again.");
				}
			}
		});
		btnPasswordSubmit.setBounds(330, 775, 143, 23);
		contentPane.add(btnPasswordSubmit);
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedEmployee = cmbEmployeeSelect.getSelectedItem().toString();
				String id[] = selectedEmployee.split(" ");
				
				try {
					employeeInfo.hrSelectedUser.selectEmployeeInfo(id[0]);
					
					// SET PERSONAL INFORMATION
					cmbTitle.setSelectedItem(employeeInfo.hrSelectedUser.title);
					txtForename.setText(employeeInfo.hrSelectedUser.forename);
					txtSurname.setText(employeeInfo.hrSelectedUser.surname);
					txtDateOfBirth.setText(employeeInfo.hrSelectedUser.dateOfBirth);
					txtGender.setText(employeeInfo.hrSelectedUser.gender);
					txtAddressLine1.setText(employeeInfo.hrSelectedUser.address1);
					txtAddressLine2.setText(employeeInfo.hrSelectedUser.address2);
					txtTown.setText(employeeInfo.hrSelectedUser.town);
					txtCounty.setText(employeeInfo.hrSelectedUser.county);
					txtPostcode.setText(employeeInfo.hrSelectedUser.postcode);
					txtHomePhone.setText(employeeInfo.hrSelectedUser.homePhone);
					txtMobilePhone.setText(employeeInfo.hrSelectedUser.mobilePhone);
					txtEmail.setText(employeeInfo.hrSelectedUser.email);
					
					// SET EMERGENCY CONTACT INFORMATION
					txtE1Forename.setText(employeeInfo.hrSelectedUser.emerg1Forename);
					txtE1Surname.setText(employeeInfo.hrSelectedUser.emerg1Surname);
					txtE1Telephone.setText(employeeInfo.hrSelectedUser.emerg1Telephone);
					txtE1Email.setText(employeeInfo.hrSelectedUser.emerg1Email);
					txtE2Forename.setText(employeeInfo.hrSelectedUser.emerg2Forename);
					txtE2Surname.setText(employeeInfo.hrSelectedUser.emerg2Surname);
					txtE2Telephone.setText(employeeInfo.hrSelectedUser.emerg2Telephone);
					txtE2Email.setText(employeeInfo.hrSelectedUser.emerg2Email);
					cmbE1Title.setSelectedItem(employeeInfo.hrSelectedUser.emerg1Title);
					cmbE2Title.setSelectedItem(employeeInfo.hrSelectedUser.emerg2Title);
					
					// SET BANK DETAILS
					txtBank.setText(employeeInfo.hrSelectedUser.bank);
					txtAccountNo.setText(employeeInfo.hrSelectedUser.accountNo);
					txtSortCode.setText(employeeInfo.hrSelectedUser.sortCode);
					txtAccountHolder.setText(employeeInfo.hrSelectedUser.acctName);
					
					// SET EMPLOYMENT INFORMATION
					txtJobTitle.setText(employeeInfo.hrSelectedUser.jobTitle);
					txtDept.setText(employeeInfo.hrSelectedUser.dept);
					txtEmployeeID.setText(String.valueOf(employeeInfo.hrSelectedUser.employeeNo));
					txtRateOfPay.setText(String.valueOf(employeeInfo.hrSelectedUser.rateOfPay));
					txtRemainingHolidays.setText(String.valueOf(employeeInfo.hrSelectedUser.holidays));
					txtAvailability.setText(employeeInfo.hrSelectedUser.availability);
					txtContractedHours.setText(String.valueOf(employeeInfo.hrSelectedUser.hoursWorked));
					txtPayrollNo.setText(employeeInfo.hrSelectedUser.payrollNo);
					txtHoursWorked.setText(String.valueOf(employeeInfo.hrSelectedUser.attendance));
					
					// Calculate attendance - (hours worked divided by contracted hours) * 100
					float attendance = 100*((float)(employeeInfo.hrSelectedUser.attendance)/(float)(employeeInfo.hrSelectedUser.hoursWorked));
					DecimalFormat df = new DecimalFormat("###.##");
					// Set the text of the attendance field to attendance as percentage
					txtAttendance.setText(String.valueOf(df.format(attendance)));

					// Gets the profile picture for the selected user by adding their employee ID to the image path
					ImageIcon icon = new ImageIcon("./img/" + employeeInfo.hrSelectedUser.employeeNo + ".jpg");
					lblImg.setIcon(icon);
					
					// Checks if the selected user is the current user and they are a HR staff member
					if(String.valueOf(employeeInfo.hrSelectedUser.employeeNo).equals(loginCheck.l.sessionUser)
					&& loginCheck.l.sessionMode == "HR") {
						// Disable buttons to edit personal info
						// Enable change password feature
						btnPersonalSubmit.setEnabled(false);
						btnEmergencySubmit.setEnabled(false);
						btnPaymentSubmit.setEnabled(false);
						btnEmploymentSubmit.setEnabled(false);
						txtCurrentPassword.setEnabled(true);
						txtNewPassword.setEnabled(true);
						txtConfirmPassword.setEnabled(true);
						btnPasswordSubmit.setEnabled(true);
					// Checks if the selected user is the current user and they are a manager
					} else if(String.valueOf(employeeInfo.hrSelectedUser.employeeNo).equals(loginCheck.l.sessionUser)
							&& loginCheck.l.sessionMode == "Management") {
						// Enable everything
						btnPersonalSubmit.setEnabled(true);
						btnEmergencySubmit.setEnabled(true);
						btnPaymentSubmit.setEnabled(true);
						btnEmploymentSubmit.setEnabled(true);
						txtCurrentPassword.setEnabled(true);
						txtNewPassword.setEnabled(true);
						txtConfirmPassword.setEnabled(true);
						btnPasswordSubmit.setEnabled(true);
					} else {
						// Enable buttons to change information
						// Disable change password feature
						btnPersonalSubmit.setEnabled(true);
						btnEmergencySubmit.setEnabled(true);
						btnPaymentSubmit.setEnabled(true);
						btnEmploymentSubmit.setEnabled(true);
						txtCurrentPassword.setEnabled(false);
						txtNewPassword.setEnabled(false);
						txtConfirmPassword.setEnabled(false);
						btnPasswordSubmit.setEnabled(false);
					}
				} catch (Exception exc) {
					System.out.println(exc);
				}
			}
		});
		btnGetDetails.setBounds(394, 143, 133, 23);
		contentPane.add(btnGetDetails);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear objects to prevent user information leaking into new sessions
				employeeInfo.loggedInUser.clearObject();
				employeeInfo.hrSelectedUser.clearObject();
				
				login lWindow = new login();	// Create new instance of login window
				uiHR.this.setVisible(false);	// Close the current HR UI session
				JOptionPane.showMessageDialog(null, "You are now logged out.");
				lWindow.setVisible(true);		// Open the login window
			}
		});
		btnLogout.setBounds(827, 11, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnViewSupportTickets = new JButton("View Support Tickets");
		btnViewSupportTickets.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnViewSupportTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewTickets vTicket = new viewTickets();
				vTicket.setVisible(true);
				uiHR.this.setVisible(false);
			}
		});
		btnViewSupportTickets.setBounds(732, 726, 175, 23);
		contentPane.add(btnViewSupportTickets);
		
		JButton btnViewLeaveRequests = new JButton("View Leave Requests");
		btnViewLeaveRequests.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnViewLeaveRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                viewHolidays vHoliday = new viewHolidays();
                vHoliday.setVisible(true);
                uiHR.this.setVisible(false);
			}
		});
		btnViewLeaveRequests.setBounds(732, 701, 175, 23);
		contentPane.add(btnViewLeaveRequests);
		
		JButton btnSubmitTicketTo = new JButton("Submit Ticket");
		btnSubmitTicketTo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSubmitTicketTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitTicket s = new submitTicket();	// Create new instance of ticket submission window
				s.setVisible(true);						// Open the window
				uiHR.this.setVisible(false);		// Close the UI
			}
		});
		btnSubmitTicketTo.setBounds(538, 726, 175, 23);
		contentPane.add(btnSubmitTicketTo);
		
		JButton btnSubmitLeaveRequest = new JButton("Submit Leave Request");
		btnSubmitLeaveRequest.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSubmitLeaveRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holidayRequest h = new holidayRequest();	// Create new instance of holiday request window
				h.setVisible(true);							// Open the window
				uiHR.this.setVisible(false);			// Close the UI
			}
		});
		btnSubmitLeaveRequest.setBounds(538, 701, 175, 23);
		contentPane.add(btnSubmitLeaveRequest);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                addEmployee a = new addEmployee();
                a.setVisible(true);
                uiHR.this.setVisible(false);
			}
		});
		btnAddEmployee.setBounds(538, 751, 175, 23);
		contentPane.add(btnAddEmployee);
		
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                removeEmployee r = new removeEmployee();
                r.setVisible(true);
                uiHR.this.setVisible(false);
			}
		});
		btnRemoveEmployee.setBounds(732, 751, 175, 23);
		contentPane.add(btnRemoveEmployee);
		
		JButton btnViewResponses = new JButton("View Responses");
		btnViewResponses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewResponses v = new viewResponses();
				uiHR.this.setVisible(false);
				v.setVisible(true);
			}
		});
		btnViewResponses.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnViewResponses.setBounds(538, 776, 175, 23);
		contentPane.add(btnViewResponses);
		
		JButton button = new JButton("View Payslip");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payslip p = new payslip();
				uiHR.this.setVisible(false);
				p.setVisible(true);
			}
		});
		button.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		button.setBounds(732, 776, 175, 23);
		contentPane.add(button);
		
		// HR users can select their own information and any lower privilege employee
		if(loginCheck.l.sessionMode == "HR"){
			String selectAll = "SELECT * FROM employeeInfo WHERE EMPLOYEE_PRIVILEGELEVEL = 1 OR EMPLOYEE_ID = " + loginCheck.l.sessionUser + " ORDER BY EMPLOYEE_ID ASC";
			try {
				select(selectAll, cmbEmployeeSelect);
			} catch(Exception exc) {
				System.out.println(exc);
			}
		// Management users can select any employee
		} else if(loginCheck.l.sessionMode == "Management") {
			String selectAll = "SELECT * FROM employeeInfo ORDER BY EMPLOYEE_ID ASC";
			try {
				select(selectAll, cmbEmployeeSelect);
			} catch(Exception exc) {
				System.out.println(exc);
			}
		}
	}
	
	// Gets the query generated per user mode and populates the combo box to select employees
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
			
			// For each result in the results set
			while(rs.next()) {
				// Get the employee ID, forename and surname
				int id = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("EMPLOYEE_FORENAME");
				String sName = rs.getString("EMPLOYEE_SURNAME");
				
				// Add a new item to the combobox using the details gathered
				cmbBox.addItem(id + " - " + fName + " " + sName);
			}
		} catch(Exception exc) {
			System.err.println(exc.getClass().getName() + exc.getMessage());
		} finally {
			statement.close();
			con.close();
		}
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
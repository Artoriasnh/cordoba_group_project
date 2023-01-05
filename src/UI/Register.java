package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Socket.Client;
import util.User;
import util.CommandTransfer;
import util.SwingUtil;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * Create Account UI
 */
public class Register extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField text_Username, text_Email, text_hobby;
	private JPasswordField passwordField, passwordField_1;
	private JLabel lblUsername, lblPassword, lblConfirmPassword, lblEmail, 
	lblGender, lblhobby, lblCreateAccount, lblNewLabel;
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JButton btnRegister;

	//----------------------------------------------------------------
	// Creates registration frame where the user enters their details:
	// username, password, gender, email, hobby
	// ---------------------------------------------------------------
	public Register() {

		// The main window
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		text_Username = new JTextField();
		text_Username.setBounds(186, 87, 242, 33);
		contentPane.add(text_Username);
		text_Username.setColumns(10);

		lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsername.setBounds(35, 91, 109, 23);
		contentPane.add(lblUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(42, 206, 102, 30);
		contentPane.add(lblPassword);

		lblConfirmPassword = new JLabel("confirm password ");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblConfirmPassword.setBounds(35, 264, 141, 23);
		contentPane.add(lblConfirmPassword);

		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmail.setBounds(43, 326, 46, 14);
		contentPane.add(lblEmail);

		text_Email = new JTextField();
		text_Email.setColumns(10);
		text_Email.setBounds(186, 318, 242, 33);
		contentPane.add(text_Email);

		lblGender = new JLabel("gender ");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Arial", Font.BOLD, 15));
		lblGender.setBounds(43, 153, 105, 18);
		contentPane.add(lblGender);

		rdbtnMale = new JRadioButton("male");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnMale.setBounds(186, 152, 109, 23);
		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnFemale.setBounds(315, 152, 109, 23);
		contentPane.add(rdbtnFemale);

		btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegister.setBounds(174, 444, 167, 41);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(this);

		lblCreateAccount = new JLabel("CREATE ACCOUNT");
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Arial", Font.BOLD, 20));
		lblCreateAccount.setBounds(24, 36, 242, 23);
		contentPane.add(lblCreateAccount);

		lblhobby = new JLabel("hobby");
		lblhobby.setForeground(Color.WHITE);
		lblhobby.setFont(new Font("Arial", Font.BOLD, 15));
		lblhobby.setBounds(50, 383, 56, 14);
		contentPane.add(lblhobby);

		text_hobby = new JTextField();
		text_hobby.setColumns(10);
		text_hobby.setBounds(186, 375, 242, 33);
		contentPane.add(text_hobby);

		passwordField = new JPasswordField();
		passwordField.setBounds(186, 206, 242, 33);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(186, 260, 242, 33);
		contentPane.add(passwordField_1);

		lblNewLabel = new JLabel("");
	//	lblNewLabel.setIcon(SwingUtil.createAutoAdjustIcon(ClassLoader.getSystemResource("image/static_login.jpg"), false));
		lblNewLabel.setBounds(0, 0, 1350, 700);
		contentPane.add(lblNewLabel);
	}

	/**
	 * Method initiated once the user enters their details
	 * and clicks the registration button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegister) {
			
			// Gets the input from all the registration fields and saves them
			// to the corresponding variables.
			String username = text_Username.getText().trim();
			String password = new String(passwordField.getPassword()).trim(); // Trim removed write space
			String confirmpassword = new String(passwordField_1.getPassword()).trim();
			String email = text_Email.getText().trim();
			String hobby = text_hobby.getText().trim();
			String sex = "male";

			if (rdbtnMale.isSelected())
				sex = rdbtnMale.getText();
			if (rdbtnFemale.isSelected())
				sex = rdbtnFemale.getText();
			
			// Warning messages for unfilled text fields.
			if ("".equals(username) || username == null) {
				JOptionPane.showMessageDialog(null, "Please enter username");
				return;
			}
			if ("".equals(password) || password == null) {
				JOptionPane.showMessageDialog(this, "Please enter password", "Prompt", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if ("".equals(confirmpassword) || confirmpassword == null) {
				JOptionPane.showMessageDialog(this, "Please enter your password again", "Prompt",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if ("".equals(email) || email == null) {
				JOptionPane.showMessageDialog(this, "Please enter email", "Prompt", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if ("".equals(hobby) || hobby == null) {
				JOptionPane.showMessageDialog(this, "Please enter 1 or 2 hobbies", "Prompt",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (password.equals(confirmpassword)) {
				
				// Instantiates user object with all input.
				User user = new User(username, password, sex, email, hobby);
				CommandTransfer msg = new CommandTransfer();
				
				
				// Set commandTransfer object to check registration.
				msg.setCmd("checkregister");
				msg.setData(user);
				msg.setReceiver(username);
				msg.setSender(username);
				
				Client client = new Client();
				// Sends the first command (check registration) 
				// to the server via the client.
				client.sendData(msg);
				msg = client.getData();
				//System.out.println(msg.isFlag());
				if (msg != null) {
					if (msg.isFlag() == false) { 
						
						
						//System.out.println(msg.isFlag());
						
						// Once check is complete user can be registered to the platform.
						// Do we have to reassign all these variables.
						msg.setCmd("register");
						
						// Sends the next command (registration) 
						client.sendData(msg);
						msg = client.getData();
						if (msg.isFlag() == true) {
							
							// Process is completed and registration window 
							// can now be discarded.
							this.dispose();
							JOptionPane.showMessageDialog(null, "Registration Successful!!", "Prompt",
									JOptionPane.WARNING_MESSAGE);
							
							// Display login interface
							contentPane.setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Login frame = new Login();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});

						}
					} else {
						System.out.println(msg.isFlag());
						JOptionPane.showMessageDialog(null, "The account already exists!", "Prompt",
								JOptionPane.WARNING_MESSAGE);
						this.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Register frame = new Register();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Two different passwords, please re-enter", "Prompt",
						JOptionPane.WARNING_MESSAGE);
				lblConfirmPassword.setText("");
				this.setVisible(false);
			}
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

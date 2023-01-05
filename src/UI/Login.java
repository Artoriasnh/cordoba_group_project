package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import Socket.Client;
import UI.Register;
import util.CommandTransfer;
import util.SwingUtil;
import util.User;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
/**
 * Create login UI
 */
public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField text_name;
	private JPasswordField text_pwd;
	private JLabel lblPassword,lblUsername,lblNewLabel,lblNewLabel_1;
	private JButton regist,login;
	private JCheckBox chckbxNewCheckBox;


	//-------------------------------------
	// Creates the frame for the login box. 
	//-------------------------------------
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/head0.jpg"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Futura", Font.PLAIN, 26));
		lblPassword.setBounds(10, 273, 227, 33);
		contentPane.add(lblPassword);
		
		text_pwd = new JPasswordField();
		text_pwd.setFont(new Font("Futura", Font.PLAIN, 18));
		text_pwd.setForeground(new Color(0, 0, 0));
		text_pwd.setColumns(10);
		text_pwd.setBounds(31, 310, 250, 75);
		contentPane.add(text_pwd);
		
		regist = new JButton("Create Account");
		regist.setForeground(Color.BLACK);
		regist.setFont(new Font("Futura", Font.PLAIN, 15));
		regist.setBounds(70, 439, 179, 33);
		contentPane.add(regist);
		regist.addActionListener(this);
		
		login = new JButton("LOG IN");
		login.setBackground(new Color(51, 204, 0));
		login.setForeground(new Color(0, 0, 255));
		login.setFont(new Font("Futura", Font.PLAIN, 24));
		login.setBounds(49, 495, 222, 75);
		contentPane.add(login);
		login.addActionListener(this);
		
		text_name = new JTextField();
		text_name.setFont(new Font("Futura", Font.PLAIN, 18));
		text_name.setForeground(new Color(0, 0, 0));
		text_name.setColumns(10);
		text_name.setBounds(31, 185, 250, 75);
		contentPane.add(text_name);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Futura", Font.PLAIN, 26));
		lblUsername.setBounds(10, 141, 227, 33);
		contentPane.add(lblUsername);
		
		chckbxNewCheckBox = new JCheckBox("Keep me signed in");
		chckbxNewCheckBox.setBounds(30, 401, 125, 23);
		contentPane.add(chckbxNewCheckBox);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(SwingUtil.createAutoAdjustIcon("resources/images/logof2.png", true));
		
		
		lblNewLabel_1.setBounds(70, 15, 245, 115);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(SwingUtil.createAutoAdjustIcon("resources/images/bg.jpg", false));
		lblNewLabel.setBounds(0, 0, 315, 620);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * Method registers users actions with the interface
	 * and acts accordingly.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// User clicks the login button.
		if (e.getSource() == login) {
			String username = text_name.getText().trim();
			String password = new String(text_pwd.getPassword()).trim();
			if ("".equals(username) || username == null) {
				JOptionPane.showMessageDialog(null, "Please enter Username����");
				return;
			}
			
			// The following two cases handles login attempts with an empty
			// text field (username or password)
			if ("".equals(password) || password == null) {
				JOptionPane.showMessageDialog(null, "Please enter password����");
				return;
			}
			
			// User details are wrapped in a commandTransfer object
			// object and sent to a server thread for processing.
			User user = new User(username, password);
			CommandTransfer loginAttempt = new CommandTransfer();
			loginAttempt.setCmd("login");
			loginAttempt.setData(user);
			loginAttempt.setReceiver(username);
			loginAttempt.setSender(username);
			
			Client client = new Client();
			client.sendData(loginAttempt);
			loginAttempt = client.getData();
			
			if(loginAttempt != null) {
				if (loginAttempt.isFlag()) {
					this.dispose();
					JOptionPane.showMessageDialog(null,  loginAttempt.getResult());
					
					// User login is successful; opens main interface panel.
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MainInterface frame = new MainInterface(username, client);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					JOptionPane.showMessageDialog(null,  loginAttempt.getResult());
				}
			}

		}

		else if(e.getSource() == regist) {
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	
	
	
	
}

package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Map.Entry;
import java.io.*;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import Socket.Client;
import util.CommandTransfer;
import util.SocketList;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.Font;

public class MainInterface extends JFrame implements ActionListener {	
	
	private JPanel contentPane;
	private String owner;
	private Client client;
	private String username;
    //private ArrayList<JButton> friendBtns;
	private JButton chat;
    
    // The users current login session
    private Client user;
	
	// Temporary array storing 'friends' fixed for every user.
    // Friends will be retrieved via a DB query.
	private String[] fakeFriends = {"NormalNorman", "Joe"};

	public MainInterface(String owner,Client user) {
		this.owner = owner;
		this.user = user;
//		new RequestHandler().start();
		buildInterface();
	}
	/**
	 * Create the frame.
	 */
	public void buildInterface() {
		setTitle("Hi, " + owner);
		setSize(1000, 800);
		setLocation(1100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(752, 299, 200, 439);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setForeground(Color.BLACK);
		tabbedPane_1.setBackground(Color.BLACK);
		tabbedPane.addTab("Online", null, tabbedPane_1, null);
		JPanel buttonLayout_1 = new JPanel();
		buttonLayout_1.setBackground(Color.LIGHT_GRAY);
		
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setFont(new Font("Calibri", Font.BOLD, 14));
		tabbedPane_2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Offline", null, tabbedPane_2, null);
		JPanel buttonLayout_2 = new JPanel();
		
//		int x = 852;
//		int y = 299;
//		int width = 130;
//		int height = 33;
//		
		//*********************************
		// To do: database implementation
		//*******************************
		// Just a test, ideally we will check the login status of
		// each friend to determine which tab to add them to.
//		for (int i = 0; i < fakeFriends.length; i++) {
//			friendBtns = new ArrayList<>();
//			final String friend = fakeFriends[i];
//			JButton clicker = new JButton(fakeFriends[i]);
//        	clicker.setForeground(Color.BLACK);
//			clicker.setFont(new Font("Calibri", Font.BOLD, 15));
//			clicker.setBounds(x, y + (height * i), width, height);
//			buttonLayout_1.add(clicker);
//			clicker.addActionListener(
//					new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					EventQueue.invokeLater(new Runnable() {
//						public void run() {
//							try {
//								ChatInterface frame = new ChatInterface(owner, friend, user);
//								frame.setVisible(true);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					});
//				}
//			});
//			friendBtns.add(clicker);
//		}
//		
//		tabbedPane_1.add(buttonLayout_1);

		
		JLabel lblUsername = new JLabel();
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 16));
		lblUsername.setBounds(780, 146, 150, 31);
		contentPane.add(lblUsername);
		
		JLabel lblHobby = new JLabel("gamer & skater.");
		lblHobby.setFont(new Font("Calibri", Font.BOLD, 12));
		lblHobby.setForeground(Color.BLACK);
		lblHobby.setBounds(800, 200, 150, 36);
		contentPane.add(lblHobby);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\workspace\\Chat_Client\\src\\image\\head2.jpg"));
		lblNewLabel.setBounds(700, 11, 66, 63);
		contentPane.add(lblNewLabel);
		
		JLabel arcadia_ = new JLabel("arcadia_");
		arcadia_.setFont(new Font("Calibri", Font.BOLD, 20));
		arcadia_.setBackground(Color.BLACK);
		arcadia_.setForeground(Color.BLACK);
		arcadia_.setBounds(28, 11, 111, 33);
		contentPane.add(arcadia_);
		
		chat = new JButton("Chat");
		chat.setFont(new Font("Calibri", Font.BOLD, 14));
		chat.setBackground(Color.BLACK);
		chat.setForeground(Color.BLACK);
		chat.setBounds(775, 240, 150, 33);
		chat.addActionListener(this);
		contentPane.add(chat);
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon("resources/images/head0.jpg"));
		image.setBounds(780, 40, 150, 150);
		contentPane.add(image);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		for (int i = 0; i < friendBtns.size(); i++) {
//			if (e.getSource() == friendBtns.get(i)) {
//				
//				String friend = friendBtns.get(i).getText();
//					
//					EventQueue.invokeLater(new Runnable() {
//						public void run() {
//							try {
//								ChatInterface frame = new ChatInterface(owner, friend, user);
//								frame.setVisible(true);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					});
//				}
//			}
		if (e.getSource() == chat) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ChatInterface frame = new ChatInterface(owner, user);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}
	
	
//	class MyMouseListener extends MouseAdapter {
//
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			// ���˫�������� �ҵĺ��� ������������ѵ������
//			if (e.getClickCount() == 2) {
//				JLabel label = (JLabel) e.getSource();
//			    //new ChatInterface(owner, label.getText(), client);
//			}
//		}
//
//		// ����������ҵĺ����б� ����ɫ��ɫ
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			JLabel label = (JLabel) e.getSource();
//			label.setOpaque(true);
//			label.setBackground(new Color(255, 240, 230));
//		}
//
//		// �������˳��ҵĺ����б� ����ɫ��ɫ
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			JLabel label = (JLabel) e.getSource();
//			label.setOpaque(false);
//			label.setBackground(Color.WHITE);
//		}
//	}

	// processes incoming requests from other users (initiate chat window)
//	class RequestHandler extends Thread {
//
//		@Override
//		public void run() {
//			while(true) {
//				CommandTransfer incoming = user.getData();
//					if ("message".equals(incoming.getCmd())){
//						EventQueue.invokeLater(new Runnable() {
//							public void run() {
//								try {
//									ChatInterface frame = new ChatInterface(owner, incoming.getSender(), user);
//									frame.setVisible(true);
//								} catch (Exception e) {
//									e.printStackTrace();
//								
//								}
//							}
//						});
//					}
//				}
//			}
//		}
	
				
}


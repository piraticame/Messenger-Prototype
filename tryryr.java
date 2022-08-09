import java.awt.BorderLayout;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class tryryr extends JFrame {
	private JFrame frame;
	ImageIcon image;
	JLabel displayField;
	private JPanel contentPane;
	private JTextField txtEmailOrPhone;
	private JPasswordField passwordField;
	String sqluser, sqlPassword;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tryryr frame = new tryryr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public tryryr() {
		setAlwaysOnTop(false);
		setAutoRequestFocus(false);
		setBackground(new Color(51, 51, 51));
		setTitle("Messenger");
		setIgnoreRepaint(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Download\\test.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(165, 40, 1050, 700);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(15, 10, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					sqluser = "INSERT INTO info(username, password) VALUES (?,?)";
				 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/messenger?useSSL=false&allowPublicKeyRetrieval=true", "root",
				 "lockDOWN11");
					PreparedStatement userInfo = connection.prepareStatement(sqluser);
					userInfo.setString(1, txtEmailOrPhone.getText().toString());
					userInfo.setString(2, passwordField.getText().toString());
					userInfo.executeUpdate();
				}
				catch (Exception i) {
					System.out.println(i);
					System.out.println("failed to send to database");
				};
				}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(387, 400, 260, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create New Account");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop b = Desktop.getDesktop();
				try {
					b.browse(new URI("https://www.facebook.com/reg/?cid=1931350367173590&app_version=151.0.0.5.114"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(102, 102, 102));
		btnNewButton_1.setBounds(387, 610, 260, 35);
		contentPane.add(btnNewButton_1);
		

		image = new ImageIcon(getClass().getResource("testpic.png"));
		displayField = new JLabel();
		displayField.setLocation(480, 120);
		displayField.setIcon(image);
		displayField.setVisible(true);
		displayField.setSize(100,100);
		contentPane.add(displayField);
		
		JLabel lblNewLabel = new JLabel("Sign in to get Started");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setBounds(338, 220, 347, 42);
		contentPane.add(lblNewLabel);
		
		txtEmailOrPhone = new JTextField();
		txtEmailOrPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmailOrPhone.getText().equals(" Email or Phone number")) {
					txtEmailOrPhone.setText("");
				}else {
					txtEmailOrPhone.selectAll();}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmailOrPhone.getText().equals("")) {
					txtEmailOrPhone.setText(" Email or Phone number");
				}
			}
		});
		
		
		
		txtEmailOrPhone.setText(" Email or Phone number");
		txtEmailOrPhone.setForeground(new Color(102, 102, 102));
		txtEmailOrPhone.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		txtEmailOrPhone.setBackground(new Color(51, 51, 51));
		txtEmailOrPhone.setBounds(359, 269, 313, 35);
		contentPane.add(txtEmailOrPhone);
		txtEmailOrPhone.setColumns(10);
		
		passwordField = new JPasswordField();
		((JPasswordField) passwordField).setEchoChar((char)0);
		passwordField.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equals(" Password")) {
					passwordField.setText("");
				}else {
					passwordField.selectAll();}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals("")) {
					passwordField.setText(" Password");
					((JPasswordField)passwordField).setEchoChar((char) 0);
				}
			}
		});
		passwordField = new JPasswordField();
		passwordField.setText(" Password");
		passwordField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBounds(380, 361, 179, 42);
		passwordField.setForeground(new Color(102, 102, 102));
		passwordField.setBackground(new Color(51, 51, 51));
		passwordField.setBounds(359, 315, 313, 35);
		contentPane.add(passwordField);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.setBackground(new Color(102, 102, 102));
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnNewRadioButton.isSelected() && passwordField.getText().equals("Password")){
					((JPasswordField) passwordField).setEchoChar((char)0);
				}else if(rdbtnNewRadioButton.isSelected() && !passwordField.getText().equals("Password")){
					((JPasswordField) passwordField).setEchoChar((char)0);
				}else if(!rdbtnNewRadioButton.isSelected() && !passwordField.getText().equals("Password"))  {
					((JPasswordField) passwordField).setEchoChar('\u25cf');
				}
			}
			
		});
		rdbtnNewRadioButton.setBounds(359, 357, 131, 23);
		contentPane.add(rdbtnNewRadioButton);

	}
}

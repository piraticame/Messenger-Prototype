import java.awt.BorderLayout;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class Messenger extends JFrame {
	private JFrame frame;
	ImageIcon image;
	JLabel displayField;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messenger frame = new Messenger();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Messenger() {
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
		
		JButton btnNewButton = new JButton("Sign In With Facebook");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.facebook.com/login/native_sso?app_id=1931350367173590&token=AbgpVO54r43NyhWWX-nUYUFPoNuqylz1LyEYlvJJnTWCjoE65NYV-PYQHvv0UQBG3gaeALd3JCmtpg"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(380, 470, 260, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign In With Phone or Email");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tryryr n =  new tryryr();
				n.show();
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(102, 102, 102));
		btnNewButton_1.setBounds(380, 525, 260, 35);
		contentPane.add(btnNewButton_1);
		

		image = new ImageIcon(getClass().getResource("testpic.png"));
		displayField = new JLabel();
		displayField.setLocation(480, 120);
		displayField.setIcon(image);
		displayField.setSize(100,100);
		displayField.setVisible(true);
		contentPane.add(displayField);
		
		JLabel lblNewLabel = new JLabel("Welcome to Messenger");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(338, 220, 347, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The simple way to text, call, and video chat right from your desktop.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setBounds(242, 250, 559, 42);
		contentPane.add(lblNewLabel_1);
		contentPane.setVisible(true);
		
	}
}

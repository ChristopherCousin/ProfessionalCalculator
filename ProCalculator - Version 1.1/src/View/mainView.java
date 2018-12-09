package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtUsername;
	public JTextField txtPassword;
	public boolean txtPasswordPlaceHolder= true;
	public JLabel lblWelcome;
	public JButton btnSignUp;
	public JButton btnLogin;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView frame = new mainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public mainView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainView.class.getResource("/resources/mainWindowico.png")));
		contentPane = new JPanel();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(395,318);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(11, 12, 358, 43);
		
		lblWelcome.setFont(new Font("Modern No. 20", Font.PLAIN, 26));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcome);
		txtUsername = new JTextField("Username...");
		txtUsername.setBounds(11, 57, 358, 43);
		
		txtUsername.setToolTipText("");
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		txtPassword = new JPasswordField(10);
		txtPassword.setText("Password...");
		txtPassword.setBounds(11, 98, 358, 43);
		
		txtPassword.setColumns(10);
		contentPane.add(txtPassword);
		btnLogin = new JButton("Login");
		btnLogin.setBounds(70, 152, 224, 57);
		btnLogin.setIcon(new ImageIcon(mainView.class.getResource("/resources/Login.png")));
		btnLogin.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		contentPane.add(btnLogin);
		btnSignUp = new JButton("Sign UP");
		btnSignUp.setBounds(70, 207, 224, 62);
		btnSignUp.setIcon(new ImageIcon(mainView.class.getResource("/resources/SignUp.png")));
		btnSignUp.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		contentPane.add(btnSignUp);
		setLocationRelativeTo(null);
	}
}

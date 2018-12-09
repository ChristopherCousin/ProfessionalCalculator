package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class signUpView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtName;
	public JTextField txtSurnames;
	public JTextField txtEmail;
	public JTextField txtPassword;
	public JTextField txtPassword_1;
	public JButton btnBack;
	public JButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUpView frame = new signUpView();
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
	public signUpView() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(signUpView.class.getResource("/resources/SignUp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[426px,grow]", "[20px][][][][][][]"));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		txtName.setText("Name...");
		contentPane.add(txtName, "cell 0 0,growx,aligny top");
		txtName.setColumns(10);
		
		txtSurnames = new JTextField();
		txtSurnames.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		txtSurnames.setText("Surnames...");
		contentPane.add(txtSurnames, "cell 0 1,growx");
		txtSurnames.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		txtEmail.setText("E-mail...");
		contentPane.add(txtEmail, "cell 0 2,growx");
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		txtPassword.setText("Password...");
		contentPane.add(txtPassword, "cell 0 3,growx");
		txtPassword.setColumns(10);
		
		txtPassword_1 = new JPasswordField();
		txtPassword_1.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		txtPassword_1.setText("Password...");
		contentPane.add(txtPassword_1, "cell 0 4,growx");
		txtPassword_1.setColumns(10);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setIcon(new ImageIcon(signUpView.class.getResource("/resources/SignUp.png")));
		btnSignUp.setFont(new Font("Modern No. 20", Font.PLAIN, 23));
		contentPane.add(btnSignUp, "flowx,cell 0 5,alignx center,aligny center");
		
		btnBack = new JButton("Back");

		btnBack.setIcon(new ImageIcon(signUpView.class.getResource("/resources/back.png")));
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 23));
		contentPane.add(btnBack, "cell 0 6,alignx center");
	}

}

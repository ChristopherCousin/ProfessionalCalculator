package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.usuario;
import Utils.DataConnection;
import View.mainView;

public class mainController {

	mainView main = new mainView();
	
	mainController() {
		//Ponemos visible el mainView y la localizacion al centro
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		
		//Aqui ponemos el password en caracteres para que el texto
		// establecido sea visible.
		crearListeneres();
	}
	
	void crearListeneres(){
		
		// Mouse Listener para que una vez el usuario haga click el texto se vacie
		main.txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.txtUsername.setText("");
			}
		});
		// Key Listener para que una vez el usuario Presione una tecla el texto se vacie
		main.txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				// Comprobamos que el Username tiene el predeterminado y se lo vaciamos
				if(main.txtUsername.getText().equals("Username...")) main.txtUsername.setText("");
			}
		});
		// Mouse Listener para que una vez el usuario haga click el texto se vacie
		main.txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Ponemos el texto oculto con "*" y vacio.
				main.txtPassword.setText("");
			}
		});
		// Key Listener para que una vez el usuario haga Presione una tecla el texto se vacie
		main.txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// Comprobamos que el Username tiene el predeterminado y se lo vaciamos
				// despues activamos el * en el passwordField
				
				if(main.txtUsername.getText().toString().equals(main.txtUsername.getText().toString()) && main.txtPasswordPlaceHolder) {
					main.txtPassword.setText("");
					main.txtPasswordPlaceHolder = false;
				}
			}
		});
		
		
		// Action listener para abrir la ventana de registro
		main.btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Creamos el objecto signUpCon para crear la ventana de registro
				//pasandole el objeto " main " para luego ponerlo a visible true desde la otra ventana
				signUpController signUpCon = new signUpController(main);
				main.setVisible(false);
			}
		});
		
		// action listener para Login
		main.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Recojo el valor que me manda la funcion loginUser para saber si se ha encontrado el usuario con estos parametros
				int x = usuario.loginUser(main.txtUsername.getText(), main.txtPassword.getText());
				
				
				//si se encuentra devuelve 1
				if(x == 1) 
				{
					//Enseñamos un JOptionPane de que el usuario se ha conectado correctamente
					JOptionPane.showMessageDialog(null, "Conectado", "Alert", JOptionPane.INFORMATION_MESSAGE);
					CalculatorController calcu = new CalculatorController();
					
					usuario.setUsername(main.txtUsername.getText());
					main.dispose();
				}
				else if(x == 0)
				{
					//Enseñamos un JOptionPane de que el usuario no existe en la base de datos!
					JOptionPane.showMessageDialog(null, "No existe este usuario", "Alert", JOptionPane.ERROR_MESSAGE);
				} else {
					//Enseñamos un JOptionPane de que el usuario no existe en la base de datos!
					JOptionPane.showMessageDialog(null, "Error en consulta MySQL", "Alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}

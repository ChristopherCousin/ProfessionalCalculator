package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.usuario;
import View.mainView;
import View.signUpView;

public class signUpController {
	signUpView signUp = new signUpView();
	mainView main;
	
	//Booleanos para el password.
	boolean txtPasswordPlaceHolder = true;
	boolean txtPasswordPlaceHolder_1 = true;
	
	//Variables otros
	int checkFields = 0;
	
	signUpController(mainView main){
		
		//Lo hacemos visible y la localizacion al centro.
		this.main = main;
		signUp.setVisible(true);
		signUp.setLocationRelativeTo(null);
		signUp.setAlwaysOnTop(true);
		
		//Creamos los listeners.
		createListeners();
		
	}
	
	void createListeners() {
		//Este ActionListener pondra el frame mainView en visible y hara un dispose al actual.
		signUp.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.setVisible(true);
				signUp.dispose();
			}
		});
		// Actionlistener para hacer registrar
		signUp.btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Llamamos a la funcion check antes de nada
				checkTxtFields();
				
				//Usamos la funcion checkUserExists para comprobar que el name no exista
				if(usuario.checkUserExists(signUp.txtName.getText()) != 1) {
					//comprobamos que los campos esten bien.
					if(checkFields == 0) usuario.createUser(signUp.txtName.getText(), signUp.txtSurnames.getText(),signUp.txtEmail.getText(), signUp.txtPassword.getText());
					checkFields = 0;
				} else {
					JOptionPane.showMessageDialog(signUp, "El Name que usas ya esta en uso!", "Alert", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		// Mouse Listener para que una vez el usuario haga click el texto se vacie
		signUp.txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signUp.txtName.setText("");
			}
		});
		// Key Listener para que una vez el usuario Presione una tecla el texto se vacie
		signUp.txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				// Comprobamos que el Username tiene el predeterminado y se lo vaciamos
				if(signUp.txtName.getText().equals("Name...")) signUp.txtName.setText("");
			}
		});
		// Mouse Listener para que una vez los surnames haga click el texto se vacie
		signUp.txtSurnames.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signUp.txtSurnames.setText("");
			}
		});
		// Key Listener para que una vez el surname Presione una tecla el texto se vacie
		signUp.txtSurnames.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				// Comprobamos que el Username tiene el predeterminado y se lo vaciamos
				if(signUp.txtSurnames.getText().equals("Surnames...")) signUp.txtSurnames.setText("");
			}
		});
		// Mouse Listener para que una vez el usuario haga click el texto se vacie
		signUp.txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signUp.txtEmail.setText("");
			}
		});
		// Key Listener para que una vez el usuario Presione una tecla el texto se vacie
		signUp.txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				// Comprobamos que el E-mail tiene el predeterminado y se lo vaciamos
				if(signUp.txtEmail.getText().equals("E-mail...")) signUp.txtEmail.setText("");
			}
		});
		// Mouse Listener para que una vez el usuario haga click el texto se vacie
		signUp.txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Ponemos el texto oculto con "*" y vacio.
				signUp.txtPassword.setText("");
			}
		});
		// Key Listener para que una vez el usuario haga Presione una tecla el texto se vacie
		signUp.txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// Comprobamos que el Name tiene el mismo que el mismo siempre sera true, le vaciamos el password y le ponemos el bool en false para que no se repita
				// despues activamos el * en el passwordField
				
				if(signUp.txtName.getText().toString().equals(signUp.txtName.getText().toString()) && txtPasswordPlaceHolder) {
					signUp.txtPassword.setText("");
					txtPasswordPlaceHolder = false;
				}
			}
		});
		signUp.txtPassword_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Ponemos el texto oculto con "*" y vacio.
				signUp.txtPassword_1.setText("");
			}
		});
		// Key Listener para que una vez el usuario haga Presione una tecla el texto se vacie
		signUp.txtPassword_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// Comprobamos que el Name tiene el mismo que el mismo siempre sera true, le vaciamos el password y le ponemos el bool en false para que no se repita
				// despues activamos el * en el passwordField
				
				if(signUp.txtName.getText().toString().equals(signUp.txtName.getText().toString()) && txtPasswordPlaceHolder_1) {
					signUp.txtPassword_1.setText("");
					txtPasswordPlaceHolder_1 = false;
				}
			}
		});
		
		
	}
	
	void checkTxtFields() 
	{
		//Hacemos unas comprobaciones antes de dejar que se registre el usuario.
		if (signUp.txtName.getText().equals("")) 		{ JOptionPane.showMessageDialog(signUp, "No puedes dejar el Nombre en blanco", "Alert", JOptionPane.ERROR_MESSAGE); 	 checkFields++; }
		if (signUp.txtEmail.getText().equals("")) 		{ JOptionPane.showMessageDialog(signUp, "No puedes dejar el Email en blanco", "Alert", JOptionPane.ERROR_MESSAGE);		 checkFields++; }
		if (signUp.txtPassword.getText().equals(""))    { JOptionPane.showMessageDialog(signUp, "No puedes dejar el Password en blanco", "Alert", JOptionPane.ERROR_MESSAGE);	 checkFields++; }
		if (signUp.txtSurnames.getText().equals(""))    { JOptionPane.showMessageDialog(signUp, "No puedes dejar el Apellido en blanco", "Alert", JOptionPane.ERROR_MESSAGE); 	 checkFields++; }
		if (signUp.txtPassword_1.getText().equals("")) 	{ JOptionPane.showMessageDialog(signUp, "No puedes dejar el Password2 en blanco", "Alert", JOptionPane.ERROR_MESSAGE); 	 checkFields++; }
		
		//Hacemos una comprobación del password para que sea identico del primero al segundo.
		String password = new String(signUp.txtPassword.getText()); 
		String password1 = new String(signUp.txtPassword_1.getText());
		if (!password.equals(password1))	{ JOptionPane.showMessageDialog(signUp, "El password no es el mismo!", "Alert", JOptionPane.ERROR_MESSAGE); checkFields++; }
	}
	
}

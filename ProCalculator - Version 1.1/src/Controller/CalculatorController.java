package Controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import Model.usuario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Utils.FrameDragListener;
import View.CalculatorView;

public class CalculatorController {

	CalculatorView calcu = new CalculatorView();
	
	double num,ans;
	int calculation;
	
	//esta booleana la usare para calcular cuando el usuario haya pulsado el boton y usarlo en algunas func
	boolean checkBtn = false;
	
	//esta booleana la usare para que cuando el usuario le de al enter el resultado se convierta en un placeHolder y pueda escribir su siguiente operacion
	//sin tener que borrar con el boton C,CE,<-
	boolean checkenter = false;
	
	//Esta variable la usare para cuando vaya a usar el boton historial crear un bucle de llamada respuesta responsivo
	int x = 0;
	
	ArrayList<String> logs;
	
	public void updatetxt(String signo) {
		
		switch(signo){
		case "sumar":
			//Aqui pondre que los numeros se vayan guardando continuamente asi el usuario puede realizar calculos mas funcionalmente como la de windows o linux.
			if(!checkBtn) calcu.lblResultOld.setText(calcu.lblResultOld.getText() + calcu.lblResult.getText() + "+");
			break;
		case "restar":
			if(!checkBtn) calcu.lblResultOld.setText(calcu.lblResultOld.getText() + calcu.lblResult.getText() + "-");
			break;
		case "multiplicar":
			if(!checkBtn) calcu.lblResultOld.setText(calcu.lblResultOld.getText() + calcu.lblResult.getText() + "X");
			break;
		case "dividir":
			if(!checkBtn) calcu.lblResultOld.setText(calcu.lblResultOld.getText() + calcu.lblResult.getText()  + "/");
			break;
		}
	}
	public void arithmetic_operation() 
	{
		switch(calculation) 
		{
		//sumamos
		case 1:
			ans = num + Double.parseDouble(calcu.lblResult.getText());
			calcu.lblResult.setText(Double.toString(ans));
			break;
		//restamos
		case 2:
			ans = num - Double.parseDouble(calcu.lblResult.getText());
			calcu.lblResult.setText(Double.toString(ans));
			break;
		//Multiplicamos
		case 3:
			ans = num * Double.parseDouble(calcu.lblResult.getText());
			calcu.lblResult.setText(Double.toString(ans));
			break;
		//dividimos
		case 4:
			ans = num / Double.parseDouble(calcu.lblResult.getText());
			calcu.lblResult.setText(Double.toString(ans));
			break;
		//Divisor1
		case 5:
			ans = 1 / num;
			calcu.lblResult.setText(Double.toString(ans));
			break;
		//Al cuadrado
		case 6:
			ans = num * num;
			calcu.lblResult.setText(Double.toString(ans));
			break;
		//La raiz cuadrada
		case 7:
			
			//Aqui llamamos a la funcion sqrt de math que nos da la raizcuadrada
			ans = Math.sqrt(num);
			calcu.lblResult.setText(Double.toString(ans));
			break;
		//Porcentaje de un numero, cuando no sabia sacar el porcentaje de memoria hace muchos años, hubiese deseado que la calculadora
		//tuviese esto y actualmente tampoco lo tiene, pero la mia si
		case 8:
			ans = (num * Double.parseDouble(calcu.lblResult.getText()) / 100);
			calcu.lblResult.setText(Double.toString(ans));
			break;
		}
	}
	CalculatorController() {
		//Aqui ponemos la localizacion en null, para que siempre aparezca centrado
		calcu.setLocationRelativeTo(null);
		
		//La visibilidad del JFrame
		calcu.setVisible(true);
		
		//La funcion donde se crean todos los componentes ( a mano ).
		calcu.createButtons();
		calcu.paintButtons(true);
		
		//Aqui creamos un objeto apartir de la clase que he creado y le ponemos como parametro el JFrame.
		//Esta clase la he puesto en Utils <<<-- 
		FrameDragListener frameDragListener = new FrameDragListener(calcu);
        calcu.addMouseListener(frameDragListener);
        calcu.addMouseMotionListener(frameDragListener);
       
        
        //Aqui un action listener para volver atras
    	calcu.backBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			//llamamos al controlador main que se encarga de todo del mainView
    			mainController main = new mainController();
    			//Hacemos dispose a esta ventana.
    			calcu.dispose();
    		}
    	});
    	
    	
		calcu.btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn1.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn2.getText();
					calcu.lblResult.setText(_Number);
					checkenter = false;
				}
			}
		});
		calcu.btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn3.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn4.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn5.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn6.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn7.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn8.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				if (calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if (calcu.lblResult.getText().equals("0 "))
						calcu.lblResult.setText("");
					if (checkBtn || checkenter)
						calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					String _Number = calcu.lblResult.getText() + calcu.btn9.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		calcu.btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamamos a la funcion updatesize
				updateSizeTxt();
				
				//El usuario no podra poner más de 16 caracteres.
				if(calcu.lblResult.getText().length() < 16) {
					//Esto lo pongo para quitar el 0 que sale como placeHolder.
					if(calcu.lblResult.getText().equals("0 ")) calcu.lblResult.setText("");
					
					
					if(checkBtn || checkenter) calcu.lblResult.setText("");
					checkBtn = false;
					checkenter = false;
					
					String _Number = calcu.lblResult.getText() + calcu.btn0.getText();
					calcu.lblResult.setText(_Number);
				}
				
			}
		});
		calcu.btnComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Esto lo pongo para quitar el 0 que sale como placeHolder.
				if(calcu.lblResult.getText().equals("0 ")) calcu.lblResult.setText("");
				
				//para que no puedan introducir 2 puntos a la vez
				if(!calcu.lblResult.getText().contains(".")) {
					String _Number = calcu.lblResult.getText() + calcu.btnComa.getText();
					calcu.lblResult.setText(_Number);
				}
			}
		});
		
		//Aqui borramos el numero actual
		calcu.btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcu.lblResult.setText("");
			}
		});
		
		//Aqui borramos todos los valores
		calcu.btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcu.lblResult.setText("");
				calcu.lblResultOld.setText("");
				calculation = 0;
			}
		});
		
		//Aqui hacemos la funcion para borrar el ultimo caracter
		calcu.btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//la longitud del numero
				int length = calcu.lblResult.getText().length();
				//la longitud menos 1
				int number = calcu.lblResult.getText().length() -1;
				//donde pondremos el resultado final
				String store;
				
				
				//si la longitud es mayor a 0
				if(length > 0) 
				{
					//aqui creamos la clase Stringbuilder, que es una clase que es mutable este objeto siempre
					// se almacena en el heap asi que nos sirve para lo que queremos hacer
					StringBuilder back = new StringBuilder(calcu.lblResult.getText());
					
					//boramos el ultimo caracter con una funcion de la misma clase
					back.deleteCharAt(number);
					
					//almacenamos en la string el resultado
					store = back.toString();
					
					//Ponemos el resultado
					calcu.lblResult.setText(store);
					
					//hacemos updatesize
					updateSizeTxt();
				}
			}
		});
		
		//Aqui sumaremos
		calcu.btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatetxt("sumar");
				//comprobamos antes de hacer el calculo
				if(!checkBtn) {
					arithmetic_operation();
				}
				
				//pongo true la booleana.
				//comprobamos que no sea nulo o contenga 0 espacio, para evitar errores
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// pasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				
				//Ponemos el switch a 1 y lo demas es bastante explicativo
				calculation = 1;
				
				checkBtn = true;
			}
		});
		
		//Aqui restaremos y hacemos lo mismo que en sumar.
		calcu.btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatetxt("restar");
				if(!checkBtn) {
					arithmetic_operation();
				}
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// Pasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				calculation = 2;
				
				//Pongo true la booleana.
				checkBtn = true;
			}
		});
		
		// Lo mismo pero multiplicando
		calcu.btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatetxt("multiplicar");
				
				if(!checkBtn) {
					arithmetic_operation();
				}
				
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// Pasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				calculation = 3;
				
				//pongo true la booleana.
				checkBtn = true;
				
			}
		});
		//Lo mismo pero dividiendo
		calcu.btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatetxt("dividir");
				
				if(!checkBtn) {
					arithmetic_operation();
				}
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// Lasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				calculation = 4;
				
				
				//pongo true la booleana.
				checkBtn = true; 
			}
		});
		
		//Aqui dividimos por 1 el valor puesto en la calculadora
		calcu.btnDivisorbyZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// pasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				calculation = 5;
				calcu.lblResult.setText("");
				calcu.lblResultOld.setText("1" + "/" + "(" + num + ")");
				
				//usamos la funcion directamente para que nos muestre el valor.
				arithmetic_operation();
			}
		});
		
		//Aqui cogemos el numero al cuadrado como arriba sencillo.
		calcu.btnSquared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// pasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				calculation = 6;
				calcu.lblResult.setText("");
				calcu.lblResultOld.setText("sqr" + "(" + num + ")");
				
				//usamos la funcion directamente para que nos muestre el valor.
				arithmetic_operation();
			}
		});
		
		//Raiz cuadrada, como arriba sencillo
		calcu.btnRaizCuadrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// pasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				calculation = 7;
				calcu.lblResult.setText("");
				calcu.lblResultOld.setText(calcu.btnRaizCuadrada.getText() + "(" + num + ")");
				
				//usamos la funcion directamente para que nos muestre el valor.
				arithmetic_operation();
			}
		});
		
		//Porcentaje de X a X
		calcu.btnPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calcu.lblResult.getText().equals("0 ") && !calcu.lblResult.getText().equals("") && !calcu.lblResult.getText().equals(".")) {
					// pasamos el num a double y cogemos el texto
					num = Double.parseDouble(calcu.lblResult.getText());
				}
				calculation = 8;
				calcu.lblResult.setText("");
				calcu.lblResultOld.setText( "El " + num + "%" + " de ?" );
			}
		});
		
		//boton de Equals
		calcu.btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Si el resultado es diferente a ""
				if (!calcu.lblResult.getText().equals("")) {
					//recogemos y almacenamos en la variable local lastNum el numero
					String lastNum = calcu.lblResult.getText();
					
					//si es diferente a "."
					if (!calcu.lblResult.getText().equals(".")) 
					{
						//funcion aritmetica
						arithmetic_operation();
						//ponemos el texto
						calcu.lblResultOld.setText("(" + calcu.lblResultOld.getText() + lastNum + ") = " + calcu.lblResult.getText());
					}
					
					//llamo a la funcion getUsername
					String Username = usuario.getUsername();
					
					//creamos variable local para hacer un check del username y añadir el log
					int x = usuario.checkUserForAddLog(Username);
					if (x == 1) {
						usuario.addLog(Username, calcu.lblResultOld.getText());
					} else if (x == 0) {
						usuario.addLog(Username, calcu.lblResultOld.getText());
					} else {
						System.out.println(
								"Mirar clase CalculatorController linea 474, fallo de conexion base de datos ?");
					}
					calcu.lblResultOld.setText("");
					num = 0;
					//definicion donde creo la variable (arriba)
					checkenter = true;
				}
			}
		});
		
		calcu.btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui ponemos el numero pi
				calcu.lblResultOld.setText("");
				num = 0;
				calcu.lblResult.setText(Double.toString(Math.PI));
				checkenter = true;
			}
		});
		
		calcu.btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x==0) 
				{
					calcu.paintButtons(false);
					x++;
					updateLogs();
				} else {
					calcu.paintButtons(true);
					x--;
					//borramos la arrayList para que no se muestre duplicada y la lista.
					clearLogs();
				}

			}
		});
		calcu.btnDeleteALL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Nos aseguramos que el usuario sabe lo que hace informandole.
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					int x = usuario.deleteAllLogs(usuario.getUsername());
					if(x==1) {
						JOptionPane.showMessageDialog(null, "Successfully deleting all Logs", "Succesfully", JOptionPane.INFORMATION_MESSAGE);
						clearLogs();
						
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error", "There's a problem in DataBase manipulation check usuario class.", JOptionPane.INFORMATION_MESSAGE);
				}
				

			}
		});
		calcu.btnDeleteSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Nos aseguramos que el usuario sabe lo que hace informandole.
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					int x = usuario.deleteSelectedLog(usuario.getUsername(), calcu.list.getSelectedItem().toString());
					if(x==1) {
						JOptionPane.showMessageDialog(null, "Successfully deleting all Logs", "Succesfully", JOptionPane.INFORMATION_MESSAGE);
						clearLogs();
						updateLogs();
						
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error", "There's a problem in DataBase manipulation check usuario class.", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
        
	}
	void updateLogs() 
	{
		logs = usuario.showLog(usuario.getUsername());
		for(int x = 0; x <logs.size() ; x++) {
			calcu.list.add(logs.get(x));
		}
	}
	
	void clearLogs() 
	{
		logs.clear();
		calcu.list.removeAll();
	}
	//Esta funcion sera para poner el texto más pequeño dependiendo de la longitud del texto, tendra un maximo de 16.
	void updateSizeTxt() {
		int longitud = calcu.lblResult.getText().length();
		
		switch (longitud) {
		case 14:
			calcu.lblResult.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
			break;
		case 15:
			calcu.lblResult.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
			break;
		case 16:
			calcu.lblResult.setFont(new Font("Comic Sans MS", Font.PLAIN, 44));
			break;
		default:
			calcu.lblResult.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
			break;
		}
	}
}

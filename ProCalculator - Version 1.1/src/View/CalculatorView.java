package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.List;
import java.awt.Button;

public class CalculatorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnPi;
	public JButton btn1;
	public JButton btn4;
	public JButton btn0;
	public JButton btn2;
	public JButton btn5;
	public JButton btnComa;
	public JButton btn3;
	public JButton btn6;
	public JButton btnEquals;
	public JButton btnSumar;
	public JButton btnResta;
	public JButton btn7;
	public JButton btnMultiplicar;
	public JButton btn9;
	public JButton btn8;
	public JButton btnPorcentaje;
	public JButton btnDivisorbyZero;
	public JButton btnSquared;
	public JButton btnRaizCuadrada;
	public JButton btnCe;
	public JButton btnC;
	public JButton btnBackSpace;
	public JButton btnDividir;
	public JLabel lblResult;
	public JLabel lblEstandar;
	public JButton btnHistorial;
	public JButton backBtn;
	public JLabel lblResultOld;
	public List list;
	public JLabel lblHistory;
	public Button btnDeleteSelected;
	public Button btnDeleteALL;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorView frame = new CalculatorView();
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
	
	public CalculatorView() {
		setResizable(false);
		setMaximumSize(new Dimension(465, 595));
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHistory = new JLabel("Calculations History");
		lblHistory.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setBounds(10, 217, 228, 44);
		contentPane.add(lblHistory);
		
		btnDeleteSelected = new Button("Delete Selected");
		btnDeleteSelected.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnDeleteSelected.setBounds(256, 225, 101, 36);
		contentPane.add(btnDeleteSelected);
		
		btnDeleteALL = new Button("Delete ALL");
		btnDeleteALL.setForeground(Color.RED);
		btnDeleteALL.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnDeleteALL.setBounds(364, 225, 66, 36);
		contentPane.add(btnDeleteALL);
		//Aqui le ponemos la funcion setundecored para quitar la ventana por defecto
		setUndecorated(true);
		//Le ponemos opacidad a la ventana.
		setOpacity(0.9f);
		
		
	}
	public void paintButtons(boolean Paint) 
	{
		if(Paint) 
		{
			//Borramos al lista del historial
			contentPane.remove(list);
			
			
			contentPane.add(btnPi);
			contentPane.add(btn1);
			contentPane.add(btn4);
			contentPane.add(btn0);
			contentPane.add(btn2);
			contentPane.add(btn5);
			contentPane.add(btnComa);
			contentPane.add(btn3);
			contentPane.add(lblResultOld);
			contentPane.add(backBtn);
			contentPane.add(btnHistorial);
			contentPane.add(lblEstandar);
			contentPane.add(lblResult);
			contentPane.add(btnDividir);
			contentPane.add(btnBackSpace);
			contentPane.add(btnC);
			contentPane.add(btnCe);
			contentPane.add(btnRaizCuadrada);
			contentPane.add(btnSquared);
			contentPane.add(btnDivisorbyZero);
			contentPane.add(btnPorcentaje);
			contentPane.add(btn8);
			contentPane.add(btn9);
			contentPane.add(btnMultiplicar);
			contentPane.add(btn7);
			contentPane.add(btnResta);
			contentPane.add(btnSumar);
			contentPane.add(btnEquals);
			contentPane.add(btn6);
			
			contentPane.repaint();
		} else {
			contentPane.remove(btnPi);
			contentPane.remove(btn1);
			contentPane.remove(btn4);
			contentPane.remove(btn0);
			contentPane.remove(btn2);
			contentPane.remove(btn5);
			contentPane.remove(btnComa);
			contentPane.remove(btn3);
			contentPane.remove(btnDividir);
			contentPane.remove(btnBackSpace);
			contentPane.remove(btnC);
			contentPane.remove(btnCe);
			contentPane.remove(btnRaizCuadrada);
			contentPane.remove(btnSquared);
			contentPane.remove(btnDivisorbyZero);
			contentPane.remove(btnPorcentaje);
			contentPane.remove(btn8);
			contentPane.remove(btn9);
			contentPane.remove(btnMultiplicar);
			contentPane.remove(btn7);
			contentPane.remove(btnResta);
			contentPane.remove(btnSumar);
			contentPane.remove(btnEquals);
			contentPane.remove(btn6);
			
			//Aqui añadimos la lista!
			contentPane.add(list);
			
			contentPane.repaint();
			
		}
	}
	
	public void createButtons() {
		
		list = new List();
		list.setBounds(10, 270, 420, 272);
		
		btnPi = new JButton("NumPI");
		btnPi.setBackground(SystemColor.menu);
		btnPi.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnPi.setBounds(0, 490, 110, 62);
		
		btn1 = new JButton("1");
		btn1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn1.setBackground(SystemColor.text);
		btn1.setBounds(0, 428, 110, 62);
		
		
		btn4 = new JButton("4");
		btn4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn4.setBackground(SystemColor.text);
		btn4.setBounds(0, 366, 110, 62);
		
		
		btn0 = new JButton("0");
		btn0.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn0.setBackground(SystemColor.text);
		btn0.setBounds(110, 490, 110, 62);

		
		btn2 = new JButton("2");
		btn2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn2.setBackground(SystemColor.text);
		btn2.setBounds(110, 428, 110, 62);

		
		btn5 = new JButton("5");
		btn5.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn5.setBackground(SystemColor.text);
		btn5.setBounds(110, 366, 110, 62);

		
		btnComa = new JButton(".");
		btnComa.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnComa.setBackground(SystemColor.menu);
		btnComa.setBounds(220, 490, 110, 62);

		
		btn3 = new JButton("3");
		btn3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn3.setBackground(SystemColor.text);
		btn3.setBounds(220, 428, 110, 62);

		
		btn6 = new JButton("6");
		btn6.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn6.setBackground(SystemColor.text);
		btn6.setBounds(220, 366, 110, 62);

		
		btnEquals = new JButton("=");
		btnEquals.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnEquals.setBackground(SystemColor.menu);
		btnEquals.setBounds(330, 490, 110, 62);

		
		btnSumar = new JButton("+");
		btnSumar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSumar.setBackground(SystemColor.menu);
		btnSumar.setBounds(330, 428, 110, 62);

		
		btnResta = new JButton("-");
		btnResta.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnResta.setBackground(SystemColor.menu);
		btnResta.setBounds(330, 366, 110, 62);

		
		btn7 = new JButton("7");
		btn7.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn7.setBackground(SystemColor.text);
		btn7.setBounds(0, 304, 110, 62);

		
		btnMultiplicar = new JButton("X");
		btnMultiplicar.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnMultiplicar.setBackground(SystemColor.menu);
		btnMultiplicar.setBounds(330, 304, 110, 62);

		
		btn9 = new JButton("9");
		btn9.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn9.setBackground(SystemColor.text);
		btn9.setBounds(220, 304, 110, 62);

		
		btn8 = new JButton("8");
		btn8.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btn8.setBackground(SystemColor.text);
		btn8.setBounds(110, 304, 110, 62);

		
		btnPorcentaje = new JButton("%");
		btnPorcentaje.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnPorcentaje.setBackground(SystemColor.menu);
		btnPorcentaje.setBounds(0, 180, 110, 62);

		
		btnDivisorbyZero = new JButton("1/x");
		btnDivisorbyZero.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnDivisorbyZero.setBackground(SystemColor.menu);
		btnDivisorbyZero.setBounds(330, 180, 110, 62);

		
		btnSquared = new JButton("x\u00B2");
		btnSquared.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnSquared.setBackground(SystemColor.menu);
		btnSquared.setBounds(220, 180, 110, 62);

		
		btnRaizCuadrada = new JButton("\u221A");
		btnRaizCuadrada.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnRaizCuadrada.setBackground(SystemColor.menu);
		btnRaizCuadrada.setBounds(110, 180, 110, 62);

		
		btnCe = new JButton("CE");
		btnCe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCe.setBackground(SystemColor.menu);
		btnCe.setBounds(0, 242, 110, 62);

		
		btnC = new JButton("C");
		btnC.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnC.setBackground(SystemColor.menu);
		btnC.setBounds(110, 242, 110, 62);

		
		btnBackSpace = new JButton("");
		btnBackSpace.setIcon(new ImageIcon(CalculatorView.class.getResource("/resources/backspace.png")));
		btnBackSpace.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnBackSpace.setBackground(SystemColor.menu);
		btnBackSpace.setBounds(220, 242, 110, 62);

		
		btnDividir = new JButton("\u00F7");
		btnDividir.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnDividir.setBackground(SystemColor.menu);
		btnDividir.setBounds(330, 242, 110, 62);

		
		lblResult = new JLabel("0 ");
		lblResult.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResult.setBounds(0, 84, 440, 85);

		
		lblEstandar = new JLabel("Est\u00E1ndar");
		lblEstandar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblEstandar.setBounds(181, 11, 84, 28);

		
		btnHistorial = new JButton("");
		btnHistorial.setBounds(385, 3, 45, 28);

		
		backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(CalculatorView.class.getResource("/resources/back.png")));
		backBtn.setBounds(10, 11, 45, 30);

		
		lblResultOld = new JLabel("");
		lblResultOld.setForeground(Color.GRAY);
		lblResultOld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultOld.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultOld.setBounds(0, 59, 440, 28);

	}
}

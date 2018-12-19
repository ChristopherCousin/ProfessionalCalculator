package Controller;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class main {
	
	public static void main(String[] args) {

		mainController mainCon = new mainController();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}

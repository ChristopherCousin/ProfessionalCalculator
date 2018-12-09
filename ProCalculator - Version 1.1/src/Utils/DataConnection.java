package Utils;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import java.sql.Connection;


public class DataConnection {
	
	 public static String bd = "calculadora";
	 public static String login = "root";
	 public static String password = "";
	 public static String url = "jdbc:mysql://localhost/" + bd;

	 
	 public static Connection con = null;
	 
	 
		public static void connect() {
			try {
				if ((con == null) || (con.isClosed())) {
					if (url == null)
						
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection
							(url, login, password);
					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Fallo de conexion MySQL!", "Alert", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
}
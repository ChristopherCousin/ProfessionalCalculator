package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Controller.CalculatorController;
import Utils.DataConnection;

public class usuario {

	//Creamos los campos necesarios en private para que no sean tan accesibles // seguridad.
	private static String name;
	private static String Surnames;
	private static String email;
	private static String password;
	usuario(){
		
		
	}
	
	//funcion para crear usuario
	public static void createUser(String n, String s, String e, String pass) {
		//Cremaos las variables setters para almacenar la informaicon que nos manden de fuera 
		// a nuestras variables privadas
		
		DataConnection.connect();
		PreparedStatement cn;
		name = n;
		Surnames = s;
		email = e;
		password = pass;
		
		String vSQL = "INSERT INTO users(Username , Surname , Email , Password) VALUES (? , ? , ? , ?)";
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					cn.setString(1,name);
					cn.setString(2,Surnames);
					cn.setString(3,email);
					cn.setString(4,password);
					
					 int n1 = cn.executeUpdate();
					 if (n1 > 0)
					 {
					 } 
					 
					 
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
	
	//Aqui hago un get para coger el username cuando lo necesite
	public static String getUsername() { return name; }
	
	//Aqui hago un set para poner el username una vez que se conecte o lo que sea
	public static void setUsername(String username) { name = username; }
	
	
	//Creo una funcion para comprobar si la cuenta pasada en los parametros existe en la base de datos.
	public static int loginUser(String username, String password) 
	{
		
		DataConnection.connect();
		PreparedStatement cn;
		
		//Esta variable sera para comprobar si existe o no
		int result = 0;
		
		
		String vSQL = "SELECT * FROM `users` WHERE Username = '" + username + "' AND Password = '" + password + "'";
		System.out.println(vSQL);
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					
					 ResultSet rs = cn.executeQuery(vSQL);
					 
					 //si devuelve true con el metodo ( next ) significa que ha encontrado algo
					 if (rs.next())
					 {
						 
						 //ponemos la variable result en 1
					 result = 1;
					 } else {
						 //ponemos la variable en 0 para decir que no hemos encontrado usuario.
						 result = 0;
					 }
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//Aqui ha dado un error y devolvemos 2
					result = 2;
				}
				return result;
				 
	}
	/**@param Username will return 1 if the name exists in the DataBase;
	 * @param Username will return 2 if there's an error with the DataBase connection;
	 * @param Username will return 0 if there's no account with that Name in the DatBase
	 *  */
	public static int checkUserExists(String username) 
	{
		
		DataConnection.connect();
		PreparedStatement cn;
		
		//Esta variable sera para comprobar si existe o no
		int result = 0;
		
		
		String vSQL = "SELECT * FROM `users` WHERE Username = '" + username + "'";
		System.out.println(vSQL);
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					
					 ResultSet rs = cn.executeQuery(vSQL);
					 
					 //si devuelve true con el metodo ( next ) significa que ha encontrado algo
					 if (rs.next())
					 {
						 
					 //ponemos la variable result en 1
					 result = 1;
					 } else {
						 //ponemos la variable en 0 para decir que no hemos encontrado usuario.
						 result = 0;
					 }
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//Aqui ha dado un error y devolvemos 2
					result = 2;
				}
				return result;
				 
	}
	
	
	public static int checkUserForAddLog(String username) 
	{
		
		DataConnection.connect();
		PreparedStatement cn;
		
		//Esta variable sera para comprobar si existe o no
		int result = 0;
		
		
		String vSQL = "SELECT * FROM `Log` WHERE Username = '" + username + "'";
		System.out.println(vSQL);
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					
					 ResultSet rs = cn.executeQuery(vSQL);
					 
					 //si devuelve true con el metodo ( next ) significa que ha encontrado algo
					 if (rs.next())
					 {
						 
					 //ponemos la variable result en 1
					 result = 1;
					 } else {
						 //ponemos la variable en 0 para decir que no hemos encontrado usuario.
						 result = 0;
					 }
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//Aqui ha dado un error y devolvemos 2
					result = 2;
				}
				return result;
	}
	
	
	
	public static void addLog(String Username, String Log) {
		
		DataConnection.connect();
		PreparedStatement cn;
		
		String vSQL = "INSERT INTO Log(Username , Log) VALUES (? , ?)";
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					cn.setString(1,Username);
					cn.setString(2,Log);
					 int n1 = cn.executeUpdate();
					 if (n1 > 0)
					 {
					 } 
					 
					 
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
	
	public static ArrayList<String> showLog(String username)
	{
		ArrayList<String> log = new ArrayList<String>();
		DataConnection.connect();
		PreparedStatement cn;
		
		//Esta variable sera para comprobar si existe o no
		int result = 0;
		
		
		String vSQL = "SELECT Log FROM `log` WHERE Username = '" + username + "'";
		System.out.println(vSQL);
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					
					 ResultSet rs = cn.executeQuery(vSQL);
					 //System.out.println(rs.getString("Log"));
					 while(rs.next()) {
						 log.add(rs.getString("Log"));
						 
					 }
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//Aqui ha dado un error y devolvemos 2
					result = 2;
				}
				 return log;
	}
	
	public static int deleteAllLogs(String username) 
	{
		
		DataConnection.connect();
		PreparedStatement cn;
		
		//Esta variable sera para comprobar si existe o no
		int result = 0;
		
		
		String vSQL = "DELETE FROM `log` WHERE Username = '" + username + "'";
		System.out.println(vSQL);
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					
					 int rs = cn.executeUpdate(vSQL);
					 result = 1;
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//Aqui ha dado un error y devolvemos 2
					result = 2;
				}
				return result;
	}
	
	public static int deleteSelectedLog(String username, String Log) 
	{
		
		DataConnection.connect();
		PreparedStatement cn;
		
		//Esta variable sera para comprobar si existe o no
		int result = 0;
		
		
		String vSQL = "DELETE FROM `log` WHERE Username = '" + username + "'";
		System.out.println(vSQL);
				 try {
					cn = (PreparedStatement) DataConnection.con.prepareStatement(vSQL, PreparedStatement.RETURN_GENERATED_KEYS);
					
					 int rs = cn.executeUpdate(vSQL);
					 result = 1;
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//Aqui ha dado un error y devolvemos 2
					result = 2;
				}
				return result;
	}
}

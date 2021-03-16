package co.simplon.biblioDao;

import java.sql.*;

public class DAOContext {

	
	protected static String db_url = "jdbc:mysql://localhost:3306/biblioteque?serverTimezone=Europe/Paris"; 
	
	protected static String db_username = "root";
	protected static String db_password = "root";
	protected static Connection connection;
 
	//static method of Class
	

	public static Connection get_Connection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver"); //driver .cj.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			 connection = DriverManager.getConnection(db_url, db_username, db_password);
			 System.out.println("Ca marche!");
			// System.out.println(db_url);
			 
		}catch(SQLException e) {
			e.printStackTrace();	
		}
		return connection;
	}
	
		//method d'instance
		public BiblioDAO getAdherent() {
			BiblioDAO toto = new BiblioDaoImpl (this);
			return toto;
			}
		
		//return new PaysDaoImpl(this);
		//or in two lines 
		//PaysDAO paysDaoobject = new PaysDaoImpl(this);
		//return paysDaoobject;
	
}
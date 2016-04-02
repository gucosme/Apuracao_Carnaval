package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

	private static Connection con;

	public static Connection getConnection() { 

		try { 
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gusta","root","123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return con; 
	}


	public void fechaConexao(){
		try {
			if(con!=null) con.close();
			con =null;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
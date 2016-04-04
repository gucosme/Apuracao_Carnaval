package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {

		private static Connection con;

		public static Connection getConnection() {

			try {
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=carnaval;namedPipe=true","teste", "123456");
				System.out.println("Conectado");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}

		public void encerraConexao() {
			try {
				if (con != null)
					con.close();
				con = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

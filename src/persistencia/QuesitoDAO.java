package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuesitoDAO implements iQuesitoDAO {
	
	private Connection con = GenericDAO.getConnection();

	@Override
	public List<String> getQuesitos() throws SQLException{
		List<String> quesitos = new ArrayList<>();
		con = GenericDAO.getConnection();

		String sql = "SELECT * FROM quesito";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			quesitos.add(rs.getString(2));
		}
		
		return quesitos;
	}

}

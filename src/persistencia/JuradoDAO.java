package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JuradoDAO implements iJuradoDAO {
	
	private Connection con = GenericDAO.getConnection();
	
	@Override
	public List<String> getJurados() throws SQLException {
		List<String> jurados = new ArrayList<>();
		con = GenericDAO.getConnection();
		String sql = "SELECT * FROM jurado";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			jurados.add(rs.getString(2));
		}
		
		return jurados;
	}

}

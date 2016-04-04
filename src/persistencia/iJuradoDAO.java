package persistencia;

import java.sql.SQLException;
import java.util.List;

public interface iJuradoDAO {
	public List<String> getJurados() throws SQLException;
}

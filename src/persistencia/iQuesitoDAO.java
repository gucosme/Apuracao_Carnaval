package persistencia;

import java.sql.SQLException;
import java.util.List;

public interface iQuesitoDAO {
	public List<String> getQuesitos() throws SQLException;
}

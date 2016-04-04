package persistencia;

import java.sql.SQLException;
import java.util.List;

import entity.Notas;

public interface iNotasDAO {
	public void insertNota(String e, String q, int pos, String n) throws SQLException;
	public List<Notas> selectNotas(String quesito) throws SQLException;
}

package persistencia;

import java.sql.SQLException;
import java.util.List;

import entity.Escola;

public interface iEscolaDAO {
	public List<String> getEscolas() throws SQLException;
	public List<Escola> selectEscola() throws SQLException;
}

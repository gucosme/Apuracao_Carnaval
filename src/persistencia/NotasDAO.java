package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Util;
import entity.Notas;

public class NotasDAO implements iNotasDAO {
	
	private Connection con = GenericDAO.getConnection();
	private ArrayList<Notas> notas;

	@Override
	public void insertNota(String e, String q, int pos, String n) throws SQLException {
		int iEscola = Util.getCtrEscola();
		int iQuesito = Util.getCtrQuesito();
		double nota = Double.parseDouble(n);
		
		String sql = "{call sp_insereNota (?,?,?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		
		cs.setInt(1, iEscola);
		cs.setInt(2, iQuesito);
		cs.setInt(3, pos);
		cs.setDouble(4, nota);
		
		cs.execute();
		cs.close();
		con.close();
	}

	@Override
	public ArrayList<Notas> selectNotas(String quesito) throws SQLException {
		Notas nts;
		notas = new ArrayList<Notas>();
		String sql = "SELECT e.nome, nota1, nota2, nota3, nota4, nota5, nota_total, nota_maior, nota_menor FROM notas n" +
		"\ninner join escola e" +
		"\non e.id_escola = n.id_escola" +
		"\ninner join quesito q" +
		"\non q.id_quesito = n.id_quesito" +
		"\nwhere q.nome = ?" +
		"\norder by e.nome desc";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, quesito);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			nts = new Notas();
			nts.setIdEscola(rs.getString(1));
			nts.setNota1(rs.getDouble(2));
			nts.setNota2(rs.getDouble(3));
			nts.setNota3(rs.getDouble(4));
			nts.setNota4(rs.getDouble(5));
			nts.setNota5(rs.getDouble(6));
			nts.setTotaPontos(rs.getDouble(7));
			nts.setMaior(rs.getDouble(8));
			nts.setMenor(rs.getDouble(9));
			notas.add(nts);
		}
		
		return notas;
	}
}

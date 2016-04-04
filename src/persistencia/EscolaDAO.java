package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Util;
import entity.Escola;

public class EscolaDAO implements iEscolaDAO {
	
	private Connection con = GenericDAO.getConnection();
	private List<Escola> escolas = new ArrayList<>();
	
	@Override
	public List<String> getEscolas() throws SQLException{
		List<String> escolas = new ArrayList<>();
		con = GenericDAO.getConnection();

		String sql = "SELECT * FROM escola";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			escolas.add(rs.getString(2));
		}
		
		return escolas;
	}

	@Override
	public List<Escola> selectEscola() throws SQLException {
		Escola e;
		String sql = "{call sp_somaPontosEscola }";
		CallableStatement cs = con.prepareCall(sql);
		
		ResultSet rs = cs.executeQuery();
		
		while(rs.next()){
			e = new Escola();
			e.setNome(rs.getString(2));
			e.setTotalPontos(rs.getDouble(3));
			escolas.add(e);
		}
		
		cs.close();
		con.close();
		return escolas;
	}

	
}

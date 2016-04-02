package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.MySQLConnector;

public class DBUtil {
	
	private static Connection con;
	public static List<String> jurados;
	public static List<String> escolas;
	public static List<String> quesitos;
	
	private static List<String> getJurados() throws SQLException{
		jurados = new ArrayList<>();
		con = MySQLConnector.getConnection();
		String sql = "SELECT * FROM jurado";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			jurados.add(rs.getString(2));
		}
		
		return jurados;
	}
	
	private static List<String> getEscolas() throws SQLException{
		escolas = new ArrayList<>();
		con = MySQLConnector.getConnection();
		String sql = "SELECT * FROM escola";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			escolas.add(rs.getString(2));
		}
		
		return escolas;
	}
	
	private static List<String> getQuesitos() throws SQLException{
		quesitos = new ArrayList<>();
		con = MySQLConnector.getConnection();
		String sql = "SELECT * FROM quesito";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			quesitos.add(rs.getString(2));
		}
		
		return quesitos;
	}
	
	public static void setLists(boolean flg) throws SQLException{
		if (!flg) {
			jurados = getJurados();
			escolas = getEscolas();
			quesitos = getQuesitos();
		}
		
//		System.out.println("jurados.size() " + jurados.size());
//		System.out.println("escolas.size() " + escolas.size());
//		System.out.println("quesitos.size() " + quesitos.size());
	}
	
	public static void removeStuff(String e, String j, String q){
		int iEscola = escolas.indexOf(e);
		int iJurado = jurados.indexOf(j);
		int iQuesito = quesitos.indexOf(q);
		
		escolas.remove(iEscola);
		jurados.remove(iJurado);
		quesitos.remove(iQuesito);
	}
}

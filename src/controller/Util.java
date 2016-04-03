package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.MySQLConnector;

public class Util {
	
	private static Connection con;
	public static List<String> jurados;
	public static List<String> escolas;
	public static List<String> quesitos;
	private static boolean flg = false;
	private static int cEscola = 0, cJurado = 0, cQuesito = 0, cNJurado = 0;
	
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
	
	public static void setLists() throws SQLException{
		if (!flg) {
			jurados = getJurados();
			escolas = getEscolas();
			quesitos = getQuesitos();
			flg = true;
		}
	}
	
	public static void rfshEscola(String escola){
		int iEscola = escolas.indexOf(escola);
		escolas.remove(iEscola);
		escolas.add(escola);
	}
	
	public static void rfshJurado(String jurado){
		int iJurado = jurados.indexOf(jurado);
		jurados.remove(iJurado);
		jurados.add(jurado);
	}
	
	public static void rfshQuesito(String quesito){
		int iQuesito = quesitos.indexOf(quesito);
		System.out.println(iQuesito);
		quesitos.remove(iQuesito);
		quesitos.add(quesito);
	}
	
	public static void rfshCtrl(String e, String q, String j){
		System.out.println(cEscola+1 + "° escola : " + (cJurado+1) + "° jurado : " + (cQuesito+1) + "° quesito");
		System.out.println(escolas);
		if (cEscola < escolas.size()-1) {
			rfshEscola(e);
			cEscola++;
		} else {
			rfshEscola(e);
			cEscola = 0;
			
			if (cJurado < jurados.size()-1 && cNJurado < 4) {
				rfshJurado(j);
				cJurado++;
				cNJurado++;
			} else {
				rfshJurado(j);
				rfshQuesito(q);
				cNJurado = 0;
				cQuesito++;
			}
		}
	}
}













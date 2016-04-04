package controller;

import java.sql.SQLException;
import java.util.List;

import persistencia.EscolaDAO;
import persistencia.JuradoDAO;
import persistencia.QuesitoDAO;

public class Util {
	
	public static List<String> jurados;
	public static List<String> escolas;
	public static List<String> quesitos;
	private static boolean flg = false;
	private static int cEscola = 0, cJurado = 0, cQuesito = 0;
	private static int ctrEscola = 1, ctrQuesito = 1, ctrJurado = 1;
	public static int cNJurado = 1;
	
	private static JuradoDAO jdao;
	private static EscolaDAO edao;
	private static QuesitoDAO qdao;
	
	public static void setLists() throws SQLException{
		
		jdao = new JuradoDAO();
		edao = new EscolaDAO();
		qdao = new QuesitoDAO();
		
		if (!flg) {
			jurados = jdao.getJurados();
			escolas = edao.getEscolas();
			quesitos = qdao.getQuesitos();
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
		quesitos.remove(iQuesito);
		quesitos.add(quesito);
	}
	
	public static void rfshQuesitoPos(String quesito, int pos){
		int iQuesito = quesitos.indexOf(quesito);
		quesitos.remove(iQuesito);
		quesitos.add(pos, quesito);
	}
	
	public static void rfshCtrl(String e, String q, String j){
		if (cEscola < escolas.size()-1) {
			rfshEscola(e);
			cEscola++;
			ctrEscola++;
		} else {
			rfshEscola(e);
			cEscola = 0;
			ctrEscola = 1;
			if (cJurado < jurados.size()-1 && cNJurado < 5) {
				rfshJurado(j);
				cJurado++;
				cNJurado++;
			} else {
				rfshJurado(j);
				rfshQuesito(q);
				cNJurado = 1;
				cQuesito++;
				ctrQuesito++;
			}
		}
	}
	
	public static int getCtrEscola() {
		return ctrEscola;
	}

	public static int getCtrQuesito() {
		return ctrQuesito;
	}
	
	public static void printa(String x){
		System.out.println(x);
	}
}













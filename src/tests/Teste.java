package tests;

import java.sql.SQLException;

import controller.Util;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stubquesito
		try {
			Util.setLists();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Util.quesitos.indexOf("Comissão de Frente"));
	}

}

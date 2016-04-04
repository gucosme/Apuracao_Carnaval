package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Util;
import persistencia.NotasDAO;

@WebServlet(urlPatterns={"/homectrl"})
public class HomeCtrl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String escola = req.getParameter("escola");
		String jurado = req.getParameter("jurado");
		String quesito = req.getParameter("quesito");
		String nota = req.getParameter("nota");
		
		boolean error = false;
		
		//inserir no banco
		
		NotasDAO ndao = new NotasDAO();
		try {
			ndao.insertNota(escola, quesito, Util.cNJurado, nota);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error = true;
			e.printStackTrace();
		}
		
		//atualizando referencias das listas já cadastradas
		if(!error){
			Util.rfshCtrl(escola, quesito, jurado);
		}
		
		resp.sendRedirect("./");
	}
}

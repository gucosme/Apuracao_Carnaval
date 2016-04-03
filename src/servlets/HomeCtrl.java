package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Util;

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
		
		//inserir no banco
		
		//tirando referencias das listas já cadastradas
		//System.out.println(quesito);
		Util.rfshCtrl(escola, quesito, jurado);
		
		resp.sendRedirect("./");
	}
}

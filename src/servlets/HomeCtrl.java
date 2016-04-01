package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/HomeCtrl"})
public class HomeCtrl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public HomeCtrl() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		String a = "jurado1";
		s.setAttribute("a", a);
		req.setAttribute("teste", "jurado teste");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String escola = req.getParameter("escola");
		String jurado = req.getParameter("Jurado");
		String quesito = req.getParameter("quesito");
		String nota = req.getParameter("nota");
		
		System.out.println(nota);
		
		resp.sendRedirect("./index.jsp");
		
		req.setAttribute("teste", "jurado post");
	}
}

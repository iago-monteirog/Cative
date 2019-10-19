package br.com.cative.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cative.beans.Turma;
import br.com.cative.dao.TurmaDAO;

/**
 * Servlet implementation class NovaTurma
 */
@WebServlet("/NovaTurma")
public class NovaTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nomeTurma = request.getParameter("nome_turma");
		
		try {
			TurmaDAO turmadao = new TurmaDAO();		
			turmadao.addTurma(nomeTurma);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

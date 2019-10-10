package br.com.cative.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cative.beans.Turma;
import br.com.cative.beans.Usuario;
import br.com.cative.dao.TurmaDAO;
import br.com.cative.dao.UsuarioDAO;

/**
 * Servlet implementation class AdicionaAlunoNaTurma
 */
@WebServlet("/AdicionaAlunoNaTurma")
public class AdicionaAlunoNaTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaAlunoNaTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String emailAluno = request.getParameter("email_aluno");
		Usuario usuario = new Usuario();
		usuario.setEmail(emailAluno);
		try {
			UsuarioDAO usuariodao = new UsuarioDAO();
			usuariodao.getAluTurma(emailAluno);
			TurmaDAO turmadao = new TurmaDAO();
			Turma turma = new Turma();
			Integer idTurma = (Integer)request.getAttribute("idTurma");
			turmadao.adicionaAlunoEmTurma(usuario.getIdUsuario(), turma.getIdTurma());
		} catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("missoes.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

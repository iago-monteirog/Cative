package br.com.cative.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import br.com.cative.beans.Turma;
import br.com.cative.beans.Usuario;
import br.com.cative.dao.TurmaDAO;
import br.com.cative.dao.UsuarioDAO;

/**
 * Classe para <b>adicionar</b> um novo aluno numa turma
 * Servlet implementation class NovoAluno
 * @author Cative
 */
@WebServlet("/NovoAluno")
public class NovoAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovoAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int idTurma = Integer.parseInt(request.getParameter("id_turma"));
		
		String nome = request.getParameter("nome_aluno");
		String email = request.getParameter("email_aluno");
		String senha = request.getParameter("senha_aluno");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipoUsuario(2);
		
		Turma turma = new Turma();
		turma.setIdTurma(idTurma);
		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.addUsuTurma(usuario);
			TurmaDAO turmadao = new TurmaDAO();
			turmadao.adicionaAlunoEmTurma(usuario.getIdUsuario(), idTurma);
		} catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("turma.jsp?id=" + idTurma);
	}

}

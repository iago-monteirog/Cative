package br.com.cative.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cative.beans.Usuario;
import br.com.cative.dao.UsuarioDAO;

/**
 * Servlet implementation class CadastraUsuario
 */
@WebServlet("/CadastraUsuario")
public class CadastraUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraUsuario() {
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
		String tipoUsuario = request.getParameter("tipo_usuario");
		String email = request.getParameter("email_usuario");
		String senha = request.getParameter("senha_usuario");
		
		Usuario usuario = new Usuario();
	
		usuario.setTipoUsuario(Integer.parseInt(tipoUsuario));
		usuario.setNome("null");
		usuario.setEmail(email);
		usuario.setSenha(senha);
		if(usuario.getTipoUsuario() == 0) {
			try {
				UsuarioDAO usuariodao = new UsuarioDAO();
				usuariodao.cadastraUsuario(email, tipoUsuario, senha);
			} catch(Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("missoes.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
				UsuarioDAO usuariodao = new UsuarioDAO();
				usuariodao.cadastraUsuario(email, tipoUsuario, senha);
			} catch(Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("turmas.jsp");
			dispatcher.forward(request, response);
		}
	}

}



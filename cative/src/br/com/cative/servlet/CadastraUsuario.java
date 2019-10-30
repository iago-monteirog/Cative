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
		int tipoUsuario = Integer.parseInt(request.getParameter("tipo_usuario"));
		String nome = request.getParameter("nome_usuario");
		String email = request.getParameter("email_usuario");
		String senha = request.getParameter("senha_usuario");
		
		
		Usuario usuario = new Usuario();
		
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		if(usuario.getTipoUsuario() == 2) {
			try {
				UsuarioDAO usuariodao = new UsuarioDAO();
				usuariodao.cadastraUsuario(email, nome, tipoUsuario, senha);
			} catch(Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
				UsuarioDAO usuariodao = new UsuarioDAO();
				usuariodao.cadastraUsuario(email, nome, tipoUsuario, senha);
			} catch(Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}



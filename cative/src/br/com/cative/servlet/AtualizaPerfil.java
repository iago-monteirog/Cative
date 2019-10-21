package br.com.cative.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cative.beans.Usuario;
import br.com.cative.dao.UsuarioDAO;

/**
 * Servlet implementation class AtualizaPerfil
 */
@WebServlet("/AtualizaPerfil")
public class AtualizaPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaPerfil() {
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
		
		String foto = request.getParameter("foto_perfil");
		String tema = request.getParameter("cor");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");

		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setFoto(foto);
		usuario.setTema(tema);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		UsuarioDAO dao;
		try {
			dao = new UsuarioDAO();
			dao.atualizaPerfil(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getHeader("referer"));
	}

}

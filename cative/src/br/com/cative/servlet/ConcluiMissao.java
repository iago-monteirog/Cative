package br.com.cative.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cative.dao.MissaoDAO;

/**
 * Servlet implementation class ConcluiMissao
 */
@WebServlet("/ConcluiMissao")
public class ConcluiMissao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcluiMissao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int idMissao = Integer.parseInt(request.getParameter("id_missao"));
		
		try {
			MissaoDAO dao = new MissaoDAO();
			HttpSession sessionUsuario = request.getSession(true);
			Integer idUsuario = (Integer) sessionUsuario.getAttribute("idUsuario");
			dao.concluiMissao(idMissao, idUsuario);
			int pontos = dao.getPontosById(idMissao);
			System.out.println(dao.getPontosById(idMissao));
			dao.concluiMissaoPontos(pontos, idUsuario);
		} catch (Exception e) {
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

package br.com.cative.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cative.beans.Missao;
import br.com.cative.dao.MissaoDAO;

/**
 * Servlet implementation class AdicionaMissao
 */
@WebServlet("/AdicionaMissao")
public class AdicionaMissao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaMissao() {
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
		int idMissao = Integer.parseInt(request.getParameter("id_missao"));
		String objetivoMissao = request.getParameter("objetivo_missao");
		String descricaoMissao = request.getParameter("descricao_missao");
		int pontosMissao = Integer.parseInt(request.getParameter("pontos_missao"));
		String imgMissao = request.getParameter("img_missao");
		String corMissao = request.getParameter("cor_missao");
		
		Missao missao = new Missao();
		
		missao.setIdMissao(1);
		missao.setDescricao(descricaoMissao);
		missao.setObjetivo(objetivoMissao);
		missao.setPontos(pontosMissao);
		missao.setCorMissao(corMissao);
		missao.setImgMissao(imgMissao);
		
		try {
			MissaoDAO missaodao = new MissaoDAO();
			missaodao.AddMissao(missao);
		} catch (Exception e) {
			e.printStackTrace();
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("nova-missao.jsp");
		dispatcher.forward(request, response);	
	}

}

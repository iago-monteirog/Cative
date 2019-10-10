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
@WebServlet("/CadastraMissao")
public class CadastraMissao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraMissao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String objetivoMissao = request.getParameter("objetivo_missao");  
		String descricaoMissao = request.getParameter("descricao_missao");
		String imgMissao = request.getParameter("imagem_capa");
		int pontosMissao = Integer.parseInt(request.getParameter("pontos"));
		String corMissao = request.getParameter("cor");
		
		Missao missao = new Missao();
		System.out.println(imgMissao);
		System.out.println(pontosMissao);
		System.out.println(corMissao);
		
		missao.setDescricao(descricaoMissao);
		missao.setObjetivo(objetivoMissao);
		missao.setImgMissao(imgMissao);
		missao.setPontos(pontosMissao);
		missao.setCorMissao(corMissao);
		
		try {
		MissaoDAO missaodao = new MissaoDAO();
		missaodao.cadastraMissao(objetivoMissao, descricaoMissao, imgMissao, pontosMissao, corMissao);
		} catch (Exception e) {
		e.printStackTrace();
	}
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	dispatcher.forward(request, response);	
	}

}
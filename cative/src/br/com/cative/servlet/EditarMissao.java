package br.com.cative.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cative.beans.Missao;
import br.com.cative.beans.Turma;
import br.com.cative.dao.MissaoDAO;

/**
 * Servlet implementation class EditarMissao
 */
@WebServlet("/EditarMissao")
public class EditarMissao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarMissao() {
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
		String objetivoMissao = request.getParameter("objetivo_missao");  
		String descricaoMissao = request.getParameter("descricao_missao");
		String imgMissao = request.getParameter("imagem_capa");
		int pontosMissao = Integer.parseInt(request.getParameter("pontos"));
		String corMissao = request.getParameter("cor");
		
		Missao missao = new Missao();
	
		missao.setDescricao(descricaoMissao);
		missao.setObjetivo(objetivoMissao);
		missao.setImgMissao(imgMissao);
		missao.setPontos(pontosMissao);
		missao.setCorMissao(corMissao);
		
		try {
			MissaoDAO missaodao = new MissaoDAO();
			missaodao.editarMissao(missao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

}

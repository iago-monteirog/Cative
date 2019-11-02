package br.com.cative.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cative.beans.Missao;
import br.com.cative.beans.Turma;
import br.com.cative.beans.Usuario;
import br.com.cative.dao.MissaoDAO;
import br.com.cative.dao.UsuarioDAO;

/**
 * Classe para <b>cadastrar</b> uma missão no sistema
 * Servlet implementation class AdicionaMissao
 * @author Cative
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
		int idTurma = Integer.parseInt(request.getParameter("idTurma"));
		
		Missao missao = new Missao();
	
		missao.setDescricao(descricaoMissao);
		missao.setObjetivo(objetivoMissao);
		missao.setImgMissao(imgMissao);
		missao.setPontos(pontosMissao);
		missao.setCorMissao(corMissao);
		
		Turma turma = new Turma();
		turma.setIdTurma(idTurma);
		
		try {
			MissaoDAO missaodao = new MissaoDAO();
			missaodao.adicionaMissao(missao);
			missaodao.adicionaMissaoEmTurma(idTurma, missao.getIdMissao());
			UsuarioDAO usuariodao = new UsuarioDAO();
			int idUsuario = usuariodao.getUsuarioByIdTurma(idTurma);
			while(idUsuario != 0) {
				missaodao.adicionaMissaoEmAluno(idUsuario, missao.getIdMissao());
				idUsuario++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("turma.jsp?id=" + idTurma);
	}

}

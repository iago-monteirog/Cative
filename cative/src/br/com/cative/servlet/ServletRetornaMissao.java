package br.com.cative.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.cative.beans.Missao;
import br.com.cative.conexao.Conexao;

/**
 * Servlet implementation class ServletRetornaMissao
 */
@WebServlet("/ServletRetornaMissao")
public class ServletRetornaMissao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRetornaMissao() {
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
		doGet(request, response);
		int idMissao = Integer.parseInt(request.getParameter("id_missao"));
		try {
			Connection connection = null;
			try {
				connection = (Connection) new Conexao().getConexao();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Missao missao = new Missao();
			PreparedStatement estrutura = connection.prepareStatement
					("select ID_MISSAO, OBJETIVO_MISSAO, DESCRICAO_MISSAO, IMG_MISSAO, PONTOS_MISSAO, COR_MISSAO from TB_MISSAO where id = ?");
		
			estrutura.setInt(1, idMissao);
			ResultSet resultadoDados = estrutura.executeQuery();
		
		if(resultadoDados.next()) {
			missao.setIdMissao(resultadoDados.getInt("id_missao"));
			missao.setDescricao(resultadoDados.getString("descricao_missao"));
			missao.setObjetivo(resultadoDados.getString("objetivo_missao"));
			missao.setImgMissao(resultadoDados.getString("img_missao"));
			missao.setPontos(resultadoDados.getInt("pontos_missao"));
			missao.setCorMissao(resultadoDados.getString("cor_missao"));
			
			request.setAttribute("messageDescricao", missao.getDescricao());
			request.setAttribute("messageObjetivo",  missao.getObjetivo());
			request.setAttribute("messageImg", missao.getImgMissao());
			request.setAttribute("messagePontos", missao.getPontos());
			request.setAttribute("messageCor" , missao.getCorMissao());
			
		}
			resultadoDados.close();
			estrutura.close();
		} catch (SQLException e) {
			System.out.print("Erro: ");
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("selecionar.jsp");
		dispatcher.forward(request, response);
		}
	}
	

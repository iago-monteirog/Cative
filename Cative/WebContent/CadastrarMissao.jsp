
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*"
    %>
    
   <%@ page language="java" import="br.com.cative.conexao.Conexao" %>
   <%
   Connection con = null;
   PreparedStatement stmt = null;
   
   String nomeMissao = request.getParameter("nomeMissao");
   
   try {
	   con = Conexao.getConexao();
	   String sql = "INSERT INTO TB_MISSAO(nome) value(?)";
	   stmt = con.prepareStatement(sql);
	   
	   stmt.setString(1, nomeMissao);
	   stmt.execute();
	   out.print("Missão cadastrada com sucesso");
   } catch(Exception e) {
	   e.printStackTrace();
   }finally {
	   try {
		   stmt.close();
		   con.close();
	   } catch(SQLException e) {
		   e.printStackTrace();
	   }
   }
   %>

   
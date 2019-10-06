<%@
	page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ page import="br.com.cative.beans.*" %>

<% 
	Missao missao = new Missao();
   	missao.setObjetivo("Nome Qualquer");
   	response.getWriter().print(request.getParameter("objetivo_missao"));
	response.getWriter().print(request.getParameter("descricao_missao"));
	response.getWriter().print(request.getParameter("img_missao"));
	response.getWriter().print(request.getParameter("pontos_missao"));
	response.getWriter().print(request.getParameter("cor_missao"));
   	out.println(missao.getObjetivo());
%>
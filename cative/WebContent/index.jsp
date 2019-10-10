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
   	response.getWriter().print(request.getParameter("id_turma"));
;
%>
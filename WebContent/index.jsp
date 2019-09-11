<%@
	page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ page import="br.com.cative.dao.*" %>

<% 
		Missao missao = new Missao();
	   	missao.setNome("Nome Qualquer");
	   
	   	out.println(missao.getNome());
%>
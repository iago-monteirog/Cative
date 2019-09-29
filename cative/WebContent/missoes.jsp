<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="./assets/css/main.min.css">
</head>

<body>
    <nav style="height: 58px;">

    </nav>

    <section class="section">
        <div class="container">
            <div class="section__title">
                <h2>
                    Suas missões
                </h2>
            </div>
            <div class="missoes">
        
                <%@ page import="br.com.cative.dao.*" %>
                <%@ page import="br.com.cative.beans.*" %>
                <%@ page import="java.util.List" %>

                <%
	         		MissaoDAO missaoDAO = new MissaoDAO();
	                List<Missao> missoes = missaoDAO.getMissoes();
	        		
	        		for(Missao m: missoes) {	        	
	        			out.println("<div class='card-missao'>");
		        			out.println("<div class='card-missao__imagem'>");
		        				out.println("<img src='./assets/img/missao-mochila.png' alt='Imagem da missão'>");
		        			out.println("</div>");
		        			out.println("<div class='card-missao__body'>");
			        			out.println("<div class='card-missao__titulo'>");
			        				out.println("<h3>"+m.getObjetivo()+"</h3>");
		        				out.println("</div>");
		        				out.println("<div class='card-missao__pontos'>");
		        					out.println("<i class='icon icon-star'></i>");
		        					out.println("<span>"+m.getPontos()+" estrelas</span>");
		        				out.println("</div>");
		        			out.println("</div>");
	        			out.println("</div>");    			
	        		}
	        		
                %>
            </div>
        </div>
    </section>
</body>

</html>

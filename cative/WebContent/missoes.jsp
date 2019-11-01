<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
	import="br.com.cative.dao.UsuarioDAO"
	import="br.com.cative.beans.Usuario"
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="./assets/css/main.min.css">
</head>

<body>
	<%
		HttpSession sessionUsuario = request.getSession(true);
		Integer idUsuario = (Integer) sessionUsuario.getAttribute("idUsuario");
		String email = (String) sessionUsuario.getAttribute("emailUsuario");
		String nome = (String) sessionUsuario.getAttribute("nomeUsuario");
	%>
	
   <jsp:include page="components/navegacao-aluno.jsp">
   	<jsp:param value="${nome}" name="nome"/>
   </jsp:include>
	
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
	                List<Missao> missoes = missaoDAO.getMissoes(idUsuario);
	        		for(Missao m: missoes) {	        	
	        	%>
                <div class="card-missao jsCardMissao" data-cor="<% out.print(m.getCorMissao()); %>" data-cod="<% out.print(m.getIdMissao()); %>" data-descricao=""
                    data-titulo="<% out.print(m.getObjetivo()); %>" data-estrelas="<% out.print(m.getPontos()); %>">
                    
                    <div class="card-missao__imagem primary">
                        <img src="<% 
			                String foto = m.getImgMissao();
			      	        foto = (foto == "" || foto == null) ? "assets/img/icone-montanha.svg" : foto;
			      	        out.println(foto);
                         %>" alt="Imagem da missão">
                    </div>
                    <div class="card-missao__body">
                        <div class="card-missao__titulo">
                            <h3><% out.print(m.getObjetivo()); %></h3>
                        </div>
                        <div class="card-missao__pontos">
                            <i class="icon icon-star"></i>
                            <span><% out.print(m.getPontos()); %> Estrelas</span>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </section>
    <div class="missao-overlay jsOverlayMissao" data-cod="">
        <div class="modal-missao jsModalMissao">
            <button class="modal-missao__close jsModalClose">
                <svg width="27" height="27" viewBox="0 0 27 27" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M13.5 1.5C6.873 1.5 1.5 6.873 1.5 13.5C1.5 20.127 6.873 25.5 13.5 25.5C20.127 25.5 25.5 20.127 25.5 13.5C25.5 6.873 20.127 1.5 13.5 1.5ZM13.5 22.5C8.5365 22.5 4.5 18.4635 4.5 13.5C4.5 8.5365 8.5365 4.5 13.5 4.5C18.4635 4.5 22.5 8.5365 22.5 13.5C22.5 18.4635 18.4635 22.5 13.5 22.5Z" fill="#2D3436"/>
                    <path d="M17.5829 9.43801L17.5619 9.41701C17.0054 8.86051 16.1024 8.86051 15.5459 9.41701L13.4999 11.463L11.4539 9.41701C10.8974 8.86051 9.99439 8.86051 9.43789 9.41701L9.41689 9.43801C8.86039 9.99451 8.86039 10.8975 9.41689 11.454L11.4629 13.5L9.41689 15.546C8.86039 16.1025 8.86039 17.0055 9.41689 17.562L9.43789 17.583C9.99439 18.1395 10.8974 18.1395 11.4539 17.583L13.4999 15.537L15.5459 17.583C16.1024 18.1395 17.0054 18.1395 17.5619 17.583L17.5829 17.562C18.1394 17.0055 18.1394 16.1025 17.5829 15.546L15.5369 13.5L17.5829 11.454C18.1394 10.8975 18.1394 9.99451 17.5829 9.43801Z" fill="#2D3436"/>
                </svg>                    
            </button>
            <div class="modal-missao__header jsModalCorMissao">
                <div class="modal-missao__header-image">
                    <img class="jsModalImagem" src="./assets/img/missao-escova-dental.png" alt="Imagem da missão">
                </div>
            </div>
            <div class="modal-missao__body">
                <div class="modal-missao__body-container">
                    <div class="missao__body-title">
                        <h2 class="jsModalTitulo"></h2>
                    </div>
                    <div class="missao__body-points">
                        <span class="missao__body-points-icone"></span>
                        <span class="missao__body-points-text">
                            <span class="jsModalEstrelas"></span>
                            <span>estrelas</span>
                        </span>
                    </div>
                    <div class="missao__body-descricao">
                        <article class="jsModalDescricao">
                            <p></p>
                        </article>                        
                    </div>
                </div>
            </div>
            <div class="modal-missao__footer">
                <a href="./ConcluiMissao" class="button button--primary button--xs-small jsConcluiMissao jsModalCorMissao">
                    Concluída
                </a>
            </div>
        </div>
    </div>    
	
	<script src="./assets/js/barra-navegacao.js"></script>
	<script charset="UTF-8" src="./assets/js/main.js?a=1"></script>    
</body>

</html>

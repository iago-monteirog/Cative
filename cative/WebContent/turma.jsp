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

	<jsp:include page="components/navegacao-professor.jsp"></jsp:include>
  <section class="section">
    <div class="section__title">
      <h1>Turma A</h1>
    </div>
    <div class="abas">
      <div class="aba jsAba ativo" data-aba="alunos">
        <span class="aba__nome">
          Alunos
        </span>
      </div>
      <div class="aba jsAba" data-aba="missoes">
        <span class="aba__nome">
          Missões
        </span>
      </div>
    </div>
    <div class="data-aba jsConteudo ativo" data-conteudo="alunos">
      <div class="alunos">
      	<%@ page import="br.com.cative.dao.*" %>
	    <%@ page import="br.com.cative.beans.*" %>
	    <%@ page import="java.util.List" %>
	    <% 
			UsuarioDAO usuariodao = new UsuarioDAO();   
	    	List<Usuario> alunos = usuariodao.getAlunosTurma();
	    	for(Usuario usuario : alunos) {
	    %>
        <div class="aluno jsAluno">
          <div class="aluno__pic">
          <img src="	
          <% 
          	  String foto = usuario.getFoto();
	          foto = (foto == "" || foto == null) ? "assets/img/foto-aluno.png" : foto;
	          out.println(foto);
		   %>" alt="Foto do aluno">
          </div>
          <div title="Abraão Azevedo" class="aluno__nome">
            <%  
	            String nome = usuario.getNome();
	    		String arr[] = nome.split(" ");
	    		out.print(arr[0]);
            %>
          </div>
        </div>
        <% } %>
      </div>
      <div class="section__bottom">
        <button class="button--primary button--xs-small jsModalToggler">
          Novo aluno
        </button>
      </div>
    </div>
    
    <div class="data-aba jsConteudo " data-conteudo="missoes">
      <div class="missoes link-aba ">
      	<%
	    MissaoDAO missaodao = new MissaoDAO();
	    List<Missao> missoes = missaodao.getMissoes();
	    for(Missao missao : missoes) {
	    %>
        <div class="card-missao jsCardMissao" data-cor="#0984E3" data-cod="a1" data-descricao=""
          data-titulo="<% out.print(missao.getObjetivo()); %>" data-estrelas="<% out.print(missao.getPontos()); %>">

          <div class="card-missao__imagem primary">
            <img src="<% 

                String foto = missao.getImgMissao();
      	        foto = (foto == "" || foto == null) ? "assets/img/icone-montanha.svg" : foto;
      	        out.println(foto);
             %>" alt="Imagem da missão">
          </div>
          <div class="card-missao__body">
            <div class="card-missao__titulo">
              <h3><% out.print(missao.getObjetivo()); %></h3>
            </div>
            <div class="card-missao__pontos">
              <i class="icon icon-star"></i>
              <span><% out.print(missao.getPontos()); %> estrelas</span>
            </div>
          </div>
        </div>
        <% } %>
      </div>
      <div class="section__bottom">
        <a href="nova-missao.jsp" class="button--primary button--xs-small">
          Nova missao
        </a>
      </div>
    </div>

  </section>
  <form action="${pageContext.request.contextPath}/NovoAluno" method="POST" class="form">
	  <div class="modal-overlay jsModalOverlay jsModalToggler">
	    <div class="modal">
	      <header class="modal__header">
	        <h3 class="modal__title">
	          Novo aluno
	        </h3>
	      </header>
	      <div class="modal__body">
	
	          <div class="form-control">
	            <label for="nome_aluno" class="form-label">Nome</label>
	            <input tabindex="0" type="text" name="nome_aluno" id="nome_aluno" class="text-input jsFirstInput"
	              placeholder="Ex.: Juliana">
	          </div>
	          <div class="form-control">
	            <label for="email" class="form-label">E-mail</label>
	            <input tabindex="0" type="text" name="email_aluno" id="email" class="text-input jsFirstInput"
	              placeholder="Ex.: juju@email.com">
	          </div>
	          <div class="form-control">
	            <label for="senha" class="form-label">Crie uma senha para</label>
	            <input tabindex="0" type="password" name="senha_aluno" id="senha" class="text-input jsFirstInput"
	              placeholder="Ex.: ********">
	          </div>
	
	      </div>
	      <div class="modal__footer">
	        <button class="button--small button--primary jsModalSubmit">
	          Pronto
	        </button>
	      </div>
	    </div>
	  </div>
  </form>

  <div class="missao-overlay jsOverlayMissao" data-cod="a">
    <div class="modal-missao jsModalMissao">
      <button class="modal-missao__close jsModalClose">
        <svg width="27" height="27" viewBox="0 0 27 27" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path
            d="M13.5 1.5C6.873 1.5 1.5 6.873 1.5 13.5C1.5 20.127 6.873 25.5 13.5 25.5C20.127 25.5 25.5 20.127 25.5 13.5C25.5 6.873 20.127 1.5 13.5 1.5ZM13.5 22.5C8.5365 22.5 4.5 18.4635 4.5 13.5C4.5 8.5365 8.5365 4.5 13.5 4.5C18.4635 4.5 22.5 8.5365 22.5 13.5C22.5 18.4635 18.4635 22.5 13.5 22.5Z"
            fill="#2D3436" />
          <path
            d="M17.5829 9.43801L17.5619 9.41701C17.0054 8.86051 16.1024 8.86051 15.5459 9.41701L13.4999 11.463L11.4539 9.41701C10.8974 8.86051 9.99439 8.86051 9.43789 9.41701L9.41689 9.43801C8.86039 9.99451 8.86039 10.8975 9.41689 11.454L11.4629 13.5L9.41689 15.546C8.86039 16.1025 8.86039 17.0055 9.41689 17.562L9.43789 17.583C9.99439 18.1395 10.8974 18.1395 11.4539 17.583L13.4999 15.537L15.5459 17.583C16.1024 18.1395 17.0054 18.1395 17.5619 17.583L17.5829 17.562C18.1394 17.0055 18.1394 16.1025 17.5829 15.546L15.5369 13.5L17.5829 11.454C18.1394 10.8975 18.1394 9.99451 17.5829 9.43801Z"
            fill="#2D3436" />
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
            <h2 class="jsModalTitulo">
              Escove os dentes
            </h2>
          </div>
          <div class="missao__body-points">
            <span class="missao__body-points-icone"></span>
            <span class="missao__body-points-text">
              <span class="jsModalEstrelas">
                200
              </span>
              <span>
                estrelas
              </span>
            </span>
          </div>
          <div class="missao__body-descricao">
            <article class="jsModalDescricao">
              <p>
                Escove os dentes durante o dia e ganhe pontos
              </p>
            </article>
          </div>
        </div>
      </div>
      <div class="modal-missao__footer">
        <button class="button button--primary button--xs-small jsConcluiMissao jsModalCorMissao">
          Concluída
        </button>
      </div>
    </div>
  </div>

  <script src="./assets/js/main.js"></script>
  <script src="./assets/js/barra-navegacao.js"></script>
  <script src="./assets/js/abas.js"></script>
  <script src="./assets/js/modal.js"></script>


</body>

</html>
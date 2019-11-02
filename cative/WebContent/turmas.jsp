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
	<%
	HttpSession sessionUsuario = request.getSession(true);
	Integer idUsuario = (Integer) sessionUsuario.getAttribute("idUsuario");
	%>
 	<jsp:include page="components/navegacao-professor.jsp">
  		<jsp:param name="titulo" value="Suas turmas"/>
  	</jsp:include>
  <section class="section">
    <div class="section__title titulo-pagina--desktop">
      <h1>
        Suas turmas
      </h1>
    </div>
    <div class="turmas">
      <div class="turmas__container">
      <%@ page import="br.com.cative.dao.*" %>
      <%@ page import="br.com.cative.beans.*" %>
      <%@ page import="java.util.List" %>
      <%
      	TurmaDAO turmadao = new TurmaDAO();
      	Usuario usu = new Usuario();
      	usu.setIdUsuario(idUsuario);
		List<Turma> turmas = turmadao.getListTurmas(idUsuario);
      	for(Turma turma : turmas) {
      %>
        <a href="turma.jsp?id=<%out.print(turma.getIdTurma());%>" class="turma jsTurma primary" tabindex="0">
          <span class="turma__tira"></span>
          <div class="turma__nome">
        
            <% out.print(turma.getNomeTurma()); %>
    
          </div>
        </a>
         <% } %>
      </div>
    </div>
    <div class="section__bottom">
      <button class="button button--primary button--xs-small jsModalToggler">
        Nova turma
      </button>
    </div>
  </section>

  <form action="${pageContext.request.contextPath}/NovaTurma" method="GET" class="form">
	<div class="modal-overlay jsModalOverlay jsModalToggler">
	  <div class="modal">
	  
	    <header class="modal__header">
	      <h3 class="modal__title">
	        Nova turma
	      </h3>
	    </header>
	    <div class="modal__body">
	        <div class="form-control">
	        <%
        	int erro = request.getParameter("erro") != null ? Integer.parseInt(request.getParameter("erro")) : 0;
        	if(erro == 1) {
        %>
	        <div class="form__feedback erro jsBoxFeedback">
	          Nome inválido
	        </div>      
        <%
        	}
        %>
	          <label for="nome_turma" class="form-label">Nova turma</label>
	          <span class="form-control__feedback"></span>
	          <input tabindex="0" type="text" name="nome_turma" id="nome_turma" class="text-input jsInputValidavel"
	            placeholder="Ex.: Classe A">
	        </div>
	    </div>
	    <div class="modal__footer">
	      <button type="submit" class="button--small button--primary jsModalSubmit">
	        Criar turma
	      </button>
	    </div>
	  </div>
	</div>
  </form>
  <script src="./assets/js/main.js"></script>
  <script src="./assets/js/barra-navegacao.js"></script>
  <script src="./assets/js/modal.js"></script>


</body>

</html>
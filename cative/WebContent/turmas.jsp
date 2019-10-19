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
		List<Turma> turmas = turmadao.getListTurmas();
      	for(Turma turma : turmas) {
      %>
        <div class="turma jsTurma primary" tabindex="0">
          <span class="turma__tira"></span>
          <div class="turma__nome">
            <% out.print(turma.getNomeTurma()); %>
          </div>
        </div>
         <% } %>
      </div>
    </div>
    <div class="section__bottom">
      <button class="button button--primary button--xs-small jsModalToggler">
        Nova turma
      </button>
    </div>
  </section>

  <div class="modal-overlay jsModalOverlay jsModalToggler">
    <div class="modal">
      <header class="modal__header">
        <h3 class="modal__title">
          Nova turma
        </h3>
      </header>
      <div class="modal__body">
        <form action="" class="form">
          <div class="form-control">
            <label for="nome_turma" class="form-label">Nova turma</label>
            <input tabindex="0" type="text" name="nome_turma" id="nome_turma" class="text-input jsFirstInput"
              placeholder="Ex.: Classe A">
          </div>
        </form>
      </div>
      <div class="modal__footer">
        <button class="button--small button--primary jsModalSubmit">
          Criar turma
        </button>
      </div>
    </div>
  </div>
  <script src="./assets/js/main.js"></script>
  <script src="./assets/js/barra-navegacao.js"></script>
  <script src="./assets/js/modal.js"></script>


</body>

</html>
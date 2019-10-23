<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Nova missão</title>
  <link rel="stylesheet" href="./assets/css/main.min.css">
</head>

<body>

  <nav class="navegacao">
    <div class="navegacao__top">
      <div class="navegacao__back jsBack">
        <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M11.6803 19.1942L4.83378 
          12.2221H19.8204C20.5344 12.2221 21.1139 11.6319 
          21.1139 10.9048C21.1139 10.1777 20.5344 9.58759 
          19.8204 9.58759H4.83378L11.6803 2.61545C12.1861 
          2.10041 12.1861 1.2666 11.6803 0.752882C11.1746 
          0.23916 10.3558 0.237842 9.85131 0.752882L0.796724 
          9.97354C0.672547 10.1 0.579414 10.2449 0.516032 
          10.4003C0.450063 10.561 0.417725 10.7336 0.417725 
          10.9048C0.417725 11.242 0.544489 11.5792 0.796724 
          11.8361L9.85131 21.0568C10.3571 21.5718 11.1759 
          21.5718 11.6803 21.0568C12.1848 20.5417 12.1861 
          19.7079 11.6803 19.1942V19.1942Z" fill="#2D3436" />
        </svg>
      </div>
      <div class="navegacao__title titulo-pagina--mobile">
        <h1></h1>
      </div>
    </div>
  </nav>
  <nav class="navegacao--desktop">
    <div class="navegacao--desktop__container">
      <a href="turmas.html" tabindex="0">
        <span class="navegacao--desktop__logo"></span>
      </a>
    </div>
  </nav>
  
  <section class="cadastro-inicial">
    <div class="cadastro-inicial__box">
      <div class="cadastro-inicial__box-titulo">
        <h1>Cadastre uma turma</h1>
      </div>
      <form action="${pageContext.request.contextPath}/AdicionaTurma" method="GET" class="form">
        <div class="cadastro-inicial__inputs">
          <div class="form-control">
            <label for="" class="form-label">Nome da turma</label>
            <input type="text" class="text-input" name="nome_turma" placeholder="Ex.: Classe A">
          </div>
        </div>
        <div class="cadastro-inicial__roteamento">
          <button 
            type="submit" 
            class="button button--small button--primary">
            Próxima
          </button>
        </div>        
      </form>
    </div>
  </section>

</body>

<script src="./assets/js/main.js"></script>
</html>
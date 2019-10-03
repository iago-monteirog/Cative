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
  <nav style="height: 58px; background: tomato">
    
  </nav>
  
  <section class="cadastro-inicial">
    <div class="cadastro-inicial__box">
      <div class="cadastro-inicial__box-titulo">
        <h1>Cadastre uma turma</h1>
      </div>
      <form action="" method="GET" class="form">
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
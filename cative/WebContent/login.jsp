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
  <div class="header-fluido">
    <header class="header bg-primary header-fluido__top">
      <div class="header__logo">
        <span class="logotipo no-centro"></span>
      </div>
      <div class="header__titulo">
        <h1>Login</h1>
      </div>
    </header>
    <span class="header-fluido__tarja">
      <span class="tarja bg-primary"></span>
    </span>
    <section class="cadastro-usuario header-fluido__bottom bg-white">
      <form action="${pageContext.request.contextPath}/Login" class="form" method="POST">
        <div class="form-control">
          <label for="" class="form-label">E-mail</label>
          <input type="text" name="email_usuario" placeholder="seu@email.com" class="text-input">
        </div>
        <div class="form-control">
          <label for="" class="form-label">Senha</label>
          <input type="password" name="senha_usuario" placeholder="Ex.: *********" class="text-input">
        </div>
        <div class="form-submit">
          <button type="submit" class="button button--small button--primary">
            Entrar
          </button>
        </div>
      </form>

      <div class="cadastro-usuario__bottom">
        <a href="cadastre-se.jsp" class="cadastro-usuario__bottom-link">Cadastrar-se em vez disso</a>
      </div>
    </section>
  </div>




</body>

<script src="./assets/js/cadastre-se.js"></script>

</html>
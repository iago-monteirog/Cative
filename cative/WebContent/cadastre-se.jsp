<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Cative | Cadastre-se</title>
  <link rel="stylesheet" href="./assets/css/main.min.css">
</head>

<body>
  <div class="header-fluido">
    <header class="header bg-primary header-fluido__top">
      <div class="header__logo">
        <span class="logotipo no-centro"></span>
      </div>
      <div class="header__titulo">
        <h1>Cadastre-se</h1>
      </div>
    </header>
    <span class="header-fluido__tarja">
      <span class="tarja bg-primary"></span>
    </span>
    <section class="cadastro-usuario header-fluido__bottom bg-white">
      <form action="" class="form" method="POST">
        <div class="form-control">
          <label for="" class="form-label">Cadastrar como</label>
          <div class="grupo-opcoes">
            <div class="grupo-opcoes__opcao jsOpcaoTipoUsusario ativo" tabindex="0">
              <input type="radio" name="tipo_usuario" value="professor" class="grupo-opcoes__input jsRadioInput">
              <div class="grupo-opcoes__texto">
                Professor
              </div>
            </div>
            <div class="grupo-opcoes__opcao jsOpcaoTipoUsusario" tabindex="0">
              <input type="radio" name="tipo_usuario" value="aluno" class="grupo-opcoes__input jsRadioInput">
              <div class="grupo-opcoes__texto">
                Aluno
              </div>
            </div>
            <div class="grupo-opcoes__opcao jsOpcaoTipoUsusario" tabindex="0">
              <input type="radio" name="tipo_usuario" value="responsavel" class="grupo-opcoes__input jsRadioInput">
              <div class="grupo-opcoes__texto">
                Responsável
              </div>
            </div>
          </div>
        </div>
        <div class="form-control">
          <label for="" class="form-label">E-mail</label>
          <input type="text" placeholder="seu@email.com" class="text-input">
        </div>
        <div class="form-control">
          <label for="" class="form-label">Senha</label>
          <input type="password" placeholder="Ex.: *********" class="text-input">
        </div>
        <div class="form-submit">
          <button type="submit" class="button button--small button--primary">
            Cadastrar
          </button>
        </div>
      </form>
      
      <div class="cadastro-usuario__bottom">
        <a href="login.html" class="cadastro-usuario__bottom-link">Fazer login em vez disso</a>
      </div>
    </section>
  </div>
  
  
</body>

<script src="./assets/js/cadastre-se.js"></script>
</html>
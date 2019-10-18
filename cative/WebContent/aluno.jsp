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
  <nav class="navegacao bg-danger jsCorPerfil">
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
      <div class="navegacao__hamburguer">
        <div class="hamburguer jsHamburguer">
          <svg width="29" height="20" viewBox="0 0 29 20" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M2.125 11.4166H26.875C27.634 11.4166 28.25 
            10.782 28.25 9.99998C28.25 9.21798 27.634 8.58331 
            26.875 8.58331H2.125C1.366 8.58331 0.75 9.21798 0.75 
            9.99998C0.75 10.782 1.366 11.4166 2.125 
            11.4166ZM2.125 2.91665H26.875C27.634 2.91665 28.25 
            2.28198 28.25 1.49998C28.25 0.71798 27.634 0.083313 
            26.875 0.083313H2.125C1.366 0.083313 0.75 0.71798 
            0.75 1.49998C0.75 2.28198 1.366 2.91665 2.125 
            2.91665ZM2.125 19.9166H26.875C27.634 19.9166 28.25 
            19.282 28.25 18.5C28.25 17.718 27.634 17.0833 26.875 
            17.0833H2.125C1.366 17.0833 0.75 17.718 0.75 
            18.5C0.75 19.282 1.366 19.9166 2.125 19.9166Z" fill="#2D3436" />
          </svg>
        </div>
      </div>
    </div>
    <div class="navegacao__overlay jsMenuMobile">
      <div class="navegacao__items">
        <div class="navegacao__top-items">
          <div class="navegacao__perfil navegacao__item bg-danger jsCorPerfil">
            <div class="navegacao__column-1">
              <div class="navegacao__perfil-pic ">
                <img src="https://placehold.it/1600x600" alt="">
              </div>
            </div>
            <div class="navegacao__column-2">
              <div class="navegacao__nome">
                Geovanne Amorimes
              </div>
              <div class="navegacao__estrelas">
                <div class="navegacao__icon-estrela icon-star"></div>
                <div class="navegacao__quantidade-estrelas">600</div>
              </div>
            </div>
          </div>
          <div class="navegacao__button navegacao__item">
            <a href="" class="cta-nova-missao">
              Nova missão
            </a>
          </div>
          <div class="navegacao__link navegacao__item">
            <a href="turmas.html">Turmas</a>
          </div>
          <div class="navegacao__link navegacao__item">
            <a href="aluno.html">Perfil</a>
          </div>
          <div class="navegacao__link navegacao__item">
            <!-- <a href="">Evolução</a> -->
          </div>
        </div>
        <div class="navegacao__bottom-items navegacao__item">
          <div class="navegacao__get-out">
            <a href="login.html">Sair</a>
          </div>
        </div>
      </div>
    </div>
  </nav>
  <nav class="navegacao--desktop bg-danger jsCorPerfil">
    <div class="navegacao--desktop__container bg-danger jsCorPerfil">
      <a href="turmas.html" tabindex="0">
        <span class="navegacao--desktop__logo"></span>
      </a>
      <div class="navegacao--desktop__items">
        <div class="navegacao--desktop__link navegacao--desktop__item">
          <a href="turmas.html" tabindex="0">Turmas</a>
        </div>
        <div class="navegacao--desktop__botao navegacao--desktop__item">
          <a href="nova-missao.html" tabindex="0" class="cta-nova-missao">
            Nova missão
          </a>
        </div>
        <div class="navegacao--desktop__perfil navegacao--desktop__item tem-dropdown jsDropDownToggler ">
          <div class="navegacao--desktop__perfil-wrap">
            <svg width="29" height="36" viewBox="0 0 29 36" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M29 29.2271C29 32.4857 26.825 35.1428 24.1744 
              35.1428H4.8256C2.175 35.1428 0 32.4871 0 29.2271C0 23.3571 
              1.4732 16.5714 7.40805 16.5714C9.24375 18.3343 11.7349 
              19.4285 14.5 19.4285C17.2652 19.4285 19.7563 18.3343 
              21.592 16.5714C27.5283 16.5714 29 23.3571 29 29.2271ZM23.2 
              9.42855C23.2 14.1614 19.3024 18 14.5 18C9.6976 18 5.8 
              14.16 5.8 9.42855C5.8 4.69712 9.6976 0.857117 14.5 
              0.857117C19.3024 0.857117 23.2 4.69712 23.2 9.42855Z" fill="#636E72" />
            </svg>
          </div>
          <div class="dropdown">
            <div class="dropdown__links">
              <div class="dropdown__link">
                <a href="login.html">Sair</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>

  <div class="perfil jsPerfil">
    <div class="perfil__capa">
      <div class="perfil__cor-capa jsCorPerfil"></div>
      <div class="perfil__regiao-foto">
        <div class="perfil__foto-wrap jsCorPerfil">
          <img src="assets/img/foto-aluno.png" class="jsFotoPerfilArmazenado" alt="foto de perfil">
          <span class="trocar-foto jsTrocarFotoPerfil">
            <input type="file" class="perfil__input-file jsInputFotoPerfil" accept='image/*'>
            <span class="trocar-foto__icone">
            </span>
          </span>
        </div>
        <div class="perfil__nome jsNomePerfil">
          Geovanne Amorimes
        </div>
      </div>
    </div>
    <div class="estrelas">
      <span class="estrelas__numero">
        5000
      </span>
      <span class="estrelas__estrela"></span>
    </div>
    <div class="missoes-concluidas">
      <span class="missoes-concluidas__texto">
        Missões concluídas:
      </span>
      <span class="missoes-concluidas__numero">
        39
      </span>
      <span class="missoes-concluidas__medalha"></span>
    </div>

    <div class="perfil__missoes">
      <div class="perfil-section-title">
        <h3>
          Missões do aluno
        </h3>
      </div>
      <div class="missoes">
        <div class="card-missao jsCardMissao" data-cor="#0984E3" data-cod="a1" data-descricao=""
          data-titulo="Escove seus dentes" data-estrelas="30">

          <div class="card-missao__imagem primary">
            <img src="./assets/img/missao-escova-dental.png" alt="Imagem da missão">
          </div>
          <div class="card-missao__body">
            <div class="card-missao__titulo">
              <h3>Escove seus dentes</h3>
            </div>
            <div class="card-missao__pontos">
              <i class="icon icon-star"></i>
              <span>30 estrelas</span>
            </div>
          </div>
        </div>
        <div class="card-missao jsCardMissao" data-cor="#ff7675" data-cod="a2" data-descricao=""
          data-titulo="Arrume sua mochila" data-estrelas="50">

          <div class="card-missao__imagem">
            <img src="./assets/img/missao-mochila.png" alt="Imagem da missão">
          </div>
          <div class="card-missao__body">
            <div class="card-missao__titulo">
              <h3>Arrume sua mochila</h3>
            </div>
            <div class="card-missao__pontos">
              <i class="icon icon-star"></i>
              <span>50 estrelas</span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="perfil__cores">
      <div class="form-control">
        <label for="" class="form-label">Cor do perfil</label>
        <div class="radio-cores">
          <div class="radio-cores__row">
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-success-dark">
              <input type="radio" value="#00b894" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-success-light ">
              <input type="radio" value="#00cec9" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-success">
              <input type="radio" value="#55efc4" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-primary-light">
              <input type="radio" value="#74b9ff" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-primary">
              <input type="radio" value="#0984e3" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
          </div>
          <div class="radio-cores__row">
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-danger">
              <input type="radio" value="#ff7675" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-pink  
        jsRadioInput ">
              <input type="radio" value="#fd79a8" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-pink-dark">
              <input type="radio" value="#e84393" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-purple">
              <input type="radio" value="#a29bfe" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
            <div tabindex="0" class="radio__cor jsOpcaoCor bg-purple-dark">
              <input type="radio" value="#6c5ce7" class="radio-cores__input jsRadioInput" name="cor" id="">
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="perfil__acessos">
      <div class="form">
        <div class="perfil-section-title">
          <h3>Acessos</h3>
        </div>
        <div class="form-control">
          <label for="" class="form-label">E-mail</label>
          <input type="email" placeholder="Ex.: geo@mail.com" class="text-input completo jsCompletoQuandoSemFoco"
            value="geovane@gmail.com">
        </div>
        <div class="form-control">
          <label for="" class="form-label">Senha</label>
          <input type="password" placeholder="Ex.: ********" class="text-input completo jsCompletoQuandoSemFoco"
            value="************">
        </div>
      </div>
    </div>

    <div class="perfil__footer">
      <div class="perfil__salvar">
        <button class="button--primary button--xs-small jsToggleModoEdicao">
          Salvar
        </button>
      </div>
      <div class="editar-perfil">
        <div class="editar-perfil__icone"></div>
        <div class="editar-perfil__texto jsToggleModoEdicao">
          editar perfil
        </div>
      </div>
    </div>
  </div>


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
  <script src="./assets/js/perfil.js"></script>
  <script src="./assets/js/inputs-de-texto.js"></script>
</body>

</html>
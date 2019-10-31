let cardMissao = {
  init() {
    let cards = document.querySelectorAll('.jsCardMissao');
    cards.forEach(card => card.addEventListener('click', cardMissao.handleClick))
  },
  handleClick() {
    modalMissao.titulo(this.dataset.titulo);
    modalMissao.descricao(this.dataset.descricao);
    modalMissao.estrelas(this.dataset.estrelas);
    modalMissao.codigo(this.dataset.cod);
    modalMissao.cor(this.dataset.cor);
    modalMissao.imagem(this.querySelector('.card-missao__imagem>img').src);
    modalMissao.toggle();
  }
}

let modalMissao = {
  overlay: null,
  btnConcluiMissao: null,
  init() {
    let modal = document.querySelector('.jsOverlayMissao');
    modalMissao.overlay = modal;

    let closeModal = document.querySelector('.jsModalClose');
    closeModal ? closeModal.addEventListener('click', modalMissao.toggle) : null;

    modalMissao.btnConcluiMissao = document.querySelector('.jsConcluiMissao');
    // modalMissao.btnConcluiMissao ? 
    // modalMissao.btnConcluiMissao.addEventListener('click', modalMissao.toggle ) : null;

    modalMissao.btnConcluiMissao ?
      modalMissao.btnConcluiMissao.addEventListener('click', modalMissao.concluiMissao) : null;

    modal ? modal.addEventListener('click', modalMissao.handleOverlayClick) : null;
  },
  concluiMissao() {
    let overlay = document.querySelector('.jsOverlayMissao');
    overlay.classList.add('concluida');
    modalMissao.btnConcluiMissao.textContent = "Parabéns!";
    modalMissao.btnConcluiMissao.style.background = '#00b894';
    document.querySelector('.jsModalCorMissao').style.background = '#00b894';

    setTimeout(function () {
      modalMissao.toggle();
    }, 2000);

    setTimeout(function () {
      modalMissao.btnConcluiMissao.textContent = "Concluída";
      overlay.classList.remove('concluida');
    }, 3000);

    let idMissao = modalMissao.overlay.dataset.cod;
    let cardMissao = document.querySelector(`.jsCardMissao[data-cod=${idMissao}]`);
    cardMissao.remove();


    let wrapMissoes = document.querySelector('.missoes');
    let estaVazio = wrapMissoes.querySelectorAll('.card-missao').length == 0;

    if (estaVazio) {
      wrapMissoes.innerHTML += '<img src="assets/img/sem-missoes.png"/>';
    }

  },
  handleOverlayClick(event) {
    event.target === modalMissao.overlay ? modalMissao.toggle() : null;
  },
  toggle() {
    modalMissao.overlay.classList.toggle('active');
  },
  titulo(titulo) {
    let tituloMissao = document.querySelector('.jsModalTitulo');
    tituloMissao.textContent = titulo;
  },
  descricao(descricao) {
    let descricaoMissao = document.querySelector('.jsModalDescricao');
    descricaoMissao.textContent = descricao;
  },
  estrelas(estrelas) {
    let estrelasMissao = document.querySelector('.jsModalEstrelas');
    estrelasMissao.textContent = estrelas;
  },
  cor(cor) {
    let lugaresComCor = document.querySelectorAll('.jsModalCorMissao');
    lugaresComCor.forEach(lugar => {
      lugar.style.background = cor;
    });
  },
  imagem(imagem) {
    let imagemCapa = document.querySelector('.jsModalImagem');
    imagemCapa.src = imagem;
  },
  codigo(codigo) {
    modalMissao.overlay.dataset.cod = codigo;
  }
}

modalMissao.init();
cardMissao.init();
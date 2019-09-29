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
    modalMissao.toggle();
  }
}

let modalMissao = {
  overlay: null,
  init() {
    let modal = document.querySelector('.jsOverlayMissao');
    modalMissao.overlay = modal;

    let closeModal = document.querySelector('.jsModalClose');
    closeModal.addEventListener('click', modalMissao.toggle);

    modal.addEventListener('click', modalMissao.handleOverlayClick);
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
  codigo(codigo) {
    modalMissao.overlay.dataset.cod = codigo;
  }
}

modalMissao.init();
cardMissao.init();
const estrelas = {
  init() {
    let opcaoEstrelas = document.querySelectorAll('.jsPontuacaoEstrela');
    opcaoEstrelas.forEach(estrela => {
      estrela.addEventListener('click', estrelas.handleEstrelaClique )
    });
  }, 
  handleEstrelaClique() {
    estrelas.removeClassesAtivo();
    this.classList.add('ativo');
    estrelas.selecionaFilhoInputRadio(this);
  },
  removeClassesAtivo() {
    let input = document.querySelector('.jsPontuacaoEstrela.ativo');
    input.classList.remove('ativo');
  },
  selecionaFilhoInputRadio(elementoPai) {
    let radio = elementoPai.querySelector('.jsRadioInput');
    radio.click();
  }
}

const cores = {
  init() {
    let quadradoCores = document.querySelectorAll('.jsOpcaoCor');
    quadradoCores.forEach(cor => {
      cor.addEventListener('keypress', cores.handleCorClique )
    });
    quadradoCores.forEach(cor => {
      cor.addEventListener('click', cores.handleCorClique )
    });
  }, 
  handleCorClique() {
    cores.removeClassesAtivo();
    this.classList.add('ativo');
    cores.selecionaFilhoInputRadio(this);
    let cor = cores.getCorSelecionada(this);
    capa.mudarFundo(cor);
  },
  removeClassesAtivo() {
    let input = document.querySelector('.jsOpcaoCor.ativo');
    !!input ? input.classList.remove('ativo') : null;
  },
  selecionaFilhoInputRadio(elementoPai) {
    let radio = elementoPai.querySelector('.jsRadioInput');
    radio.click();
  },
  getCorSelecionada(elementoPai) {
    let radio = elementoPai.querySelector('.jsRadioInput');
    return radio.value;
  }
}

const capa = {
  mudarFundo(cor) {
    let capa = document.querySelector('.jsCapaMissao');
    capa.style.background = cor;
  }
}

const inputsDeTexto = {
  init() {
    let inputs = document.querySelectorAll('.jsCompletoQuandoSemFoco');
    inputs.forEach(input => {
      input.addEventListener('click', inputsDeTexto.foco );
    });
    inputs.forEach(input => {
      input.addEventListener('blur', inputsDeTexto.perdeFoco );
    });
  },
  foco() {
    this.classList.remove('completo');
  },
  perdeFoco() {
    if(inputsDeTexto.inputEstaVazio(this)) {
      this.classList.add('completo');
    }
  },
  inputEstaVazio(input) {
    return !!input.value;
  }
}

estrelas.init();
cores.init();
inputsDeTexto.init();
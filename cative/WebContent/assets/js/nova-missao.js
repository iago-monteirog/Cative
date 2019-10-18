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

const capaMissao = {
  fileInput: null,
  capa: null,
  init() {
    let input = document.querySelector('.jsInputUploadImagem');
    capaMissao.fileInput = input;
    !!input ? input.addEventListener('change', capaMissao.handleInputTypeFileChange ) : null;
    
    let capa = document.querySelector('.jsCapaMissao');
    capaMissao.capa = capa;
    !!capa ? capa.addEventListener('click', capaMissao.handleCapaClique ) : null;
  },
  handleInputTypeFileChange() {
    var input = this;
    var reader = new FileReader();
    reader.onload = function(){
      let dataURL = reader.result;
      let output = document.querySelector('.jsImagemUpada');
      capaMissao.preparaImagemParaSubmit(dataURL)
      output.src = dataURL;
    };
    reader.readAsDataURL(input.files[0]);
    capaMissao.ativa();
  },
  handleCapaClique() {
    capaMissao.fileInput.click();
  },
  ativa() {
    capaMissao.capa.classList.add('ativo');
  },
  inativa() {
    if(capaMissao.capa.classList.contains('ativo'));
    capaMissao.capa.classList.add('ativo');
  },
  preparaImagemParaSubmit(dataImagem) {
    let textArea = document.querySelector('.jsImagemURLPraSubmit');
    textArea.textContent = dataImagem;
  }
}


capaMissao.init();
estrelas.init();
cores.init();
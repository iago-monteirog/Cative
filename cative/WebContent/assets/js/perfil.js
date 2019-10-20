const capaPerfil = {
  corCapa: null,
  foto: null,
  fotoWrapper: null,
  init() {
    let opcoesCor = document.querySelectorAll('.jsOpcaoCor');
    opcoesCor.forEach(cor => {
      cor.addEventListener('keypress', capaPerfil.handleCorClique )
    });
    opcoesCor.forEach(cor => {
      cor.addEventListener('click', capaPerfil.handleCorClique )
    });
  },
  handleCorClique() {
    capaPerfil.desativaTodasAsCores();
    this.classList.add('ativo');
    capaPerfil.selecionaFilhoInputRadio(this);
    let cor = capaPerfil.getCorSelecionada(this);
    capaPerfil.mudaCor(cor);
  },
  desativaTodasAsCores() {
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
  },
  mudaCor(cor) {
    let lugaresComCor = document.querySelectorAll('.jsCorPerfil');
    lugaresComCor.forEach(lugar => {
      lugar.style.background = cor;
    })
  }
}

const fotoPerfil = {
  fileInput: null,
  init() {    
    let btnTrocaFoto = document.querySelector('.jsTrocarFotoPerfil');
    btnTrocaFoto.addEventListener('click', fotoPerfil.handleTrocarFoto );
    
    fotoPerfil.fileInput = document.querySelector('.jsInputFotoPerfil');
    !!fotoPerfil.fileInput ? 
    fotoPerfil.fileInput.addEventListener('change', fotoPerfil.handleInputTypeFileChange ) : null;
  },
  handleInputTypeFileChange() {
    var input = this;
    var reader = new FileReader();
    reader.onload = function(){
      let dataURL = reader.result;
      let output = document.querySelector('.jsFotoPerfil');
      let textarea = document.querySelector('.jsTextAreaDataFoto');
      output.src = dataURL;
      textarea.textContent = dataURL;
    };
    reader.readAsDataURL(input.files[0]);
  },
  handleTrocarFoto() {
    fotoPerfil.fileInput.click();
  },
  inativa() {
    if(fotoPerfil.capa.classList.contains('ativo'));
    fotoPerfil.capa.classList.add('ativo');
  }
}

const modoDeEdicao = {
  perfil: null,
  init() {
    let btnToggle = document.querySelectorAll('.jsToggleModoEdicao');
    btnToggle.forEach(btn => {
      btn.addEventListener('click', modoDeEdicao.toggleModo );
    });

    modoDeEdicao.perfil = document.querySelector('.jsPerfil');
  },
  toggleModo() {
    modoDeEdicao.perfil.classList.toggle('editar');
  }
}

capaPerfil.init();
fotoPerfil.init();
modoDeEdicao.init();
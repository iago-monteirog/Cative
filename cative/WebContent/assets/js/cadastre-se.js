const cadastreSe = {
  init() {
    let radiosTipoAluno = document.querySelectorAll('.jsOpcaoTipoUsusario');
    radiosTipoAluno.forEach(input => {
      input.addEventListener('click', cadastreSe.handleRadiosTipoAluno);
    })
  },
  handleRadiosTipoAluno() {
    cadastreSe.removeClassesAtivo();
    this.classList.add('ativo');
    cadastreSe.selecionaFilhoInputRadio(this);
  },
  removeClassesAtivo() {
    let input = document.querySelector('.jsOpcaoTipoUsusario.ativo');
    input.classList.remove('ativo');
  },
  selecionaFilhoInputRadio(elementoPai) {
    let radio = elementoPai.querySelector('.jsRadioInput');
    radio.click();
  }
}

cadastreSe.init();
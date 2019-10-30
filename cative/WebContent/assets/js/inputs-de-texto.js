const inputsDeTexto = {
  init() {
    let inputs = document.querySelectorAll('.jsCompletoQuandoSemFoco');
    inputs.forEach(input => {
      input.addEventListener('click', inputsDeTexto.foco );
    });
    inputs.forEach(input => {
      input.addEventListener('keypress', inputsDeTexto.foco );
    });
    inputs.forEach(input => {
      input.addEventListener('blur', inputsDeTexto.perdeFoco );
    });

    let inputsValidaveis = document.querySelectorAll('.jsInputValidavel');
    inputsValidaveis.forEach(input => {
      input.addEventListener('blur', inputsDeTexto.validar );
    })
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
  },
  validar() {
    let formControl = this.parentElement;
    let input = this;
    let inputNaoEstaVazio = input.value != "";
    
    if(inputNaoEstaVazio) {
      formControl.classList.remove('erro');
    }
  }
}

inputsDeTexto.init();
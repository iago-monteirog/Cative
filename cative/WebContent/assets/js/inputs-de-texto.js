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

inputsDeTexto.init();
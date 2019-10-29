const novoAluno = {
  inputNome: null,
  labelReciper: null,
  nome: null,
  init() {
    novoAluno.inputNome = document.querySelector('.jsInputNome');
    novoAluno.labelReciper = document.querySelector('.jsFirstNameReceiver');

    novoAluno.inputNome.addEventListener('keyup', novoAluno.handleNameExibition );
  },
  handleNameExibition() {
    let valueIsValid = !!this.value;
    if(valueIsValid) {
      let firstName = novoAluno.splitName(this.value);

      novoAluno.showNameInLabel(firstName)
    }
  },
  showNameInLabel(name) {
    novoAluno.labelReciper.textContent = name;
  },
  splitName(fullName) {
      return fullName.split(" ")[0];
  }
}

novoAluno.init();
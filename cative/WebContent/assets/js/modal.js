const modal = {
  overlay: null,
  toggler: null,
  btnSubmit: null,
  init() {
    modal.overlay = document.querySelector('.jsModalOverlay');
    
    modal.toggler = document.querySelectorAll('.jsModalToggler');
    modal.toggler ?
    modal.toggler.forEach(item => item.addEventListener('click', this.toggleModal))
    : null;
    
    modal.btnSubmit = document.querySelector('.jsModalSubmit');
    modal.btnSubmit ?
    modal.btnSubmit.addEventListener('click', modal.close)  
    : null;
    modal.btnSubmit ?
    modal.btnSubmit.addEventListener('keypress', modal.close)  
    : null;
  },
  toggleModal(event) {
    modal.focoNoPrimeiroInput(event.target);
    if (modal.isOverlay(event.target)) {
      modal.overlay.classList.toggle('ativo');
    }
    else if (modal.isModalToggler(event.target)) {
      modal.overlay.classList.toggle('ativo');
    }
  },
  isOverlay(element) {
    return modal.overlay === element;
  },
  isModalToggler(element) {
    return element.classList.contains('jsModalToggler');
  },
  close() {
    modal.overlay.classList.remove('ativo');
  },
  focoNoPrimeiroInput(element) {
    let input = document.querySelector('.jsFirstInput');

    window.setTimeout(function() {
      if(modal.isModalToggler(element)) {
        input.focus();
      }
    },0)
  }
}

modal.init();
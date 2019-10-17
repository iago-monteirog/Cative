const barraNavegacao = {
  menuWrapper: null,
  menuHamburguer: null,
  backArrow: null,
  dropDownToggler: null,
  init() {
    this.menuHamburguer = document.querySelector('.jsHamburguer');
    this.menuWrapper = document.querySelector('.jsMenuMobile');
    this.backArrow = document.querySelector('.jsBack');
    this.dropDownToggler = document.querySelector('.jsDropDownToggler');

    !!this.menuHamburguer ? this.menuHamburguer.addEventListener('click', this.toggleMenu ) : null;
    !!this.menuWrapper ? this.menuWrapper.addEventListener('click', this.checkTargetAndToggleMenu ) : null;
    !!this.backArrow ? this.backArrow.addEventListener('click', this.historyBack ) : null;
    !!this.dropDownToggler ? this.dropDownToggler.addEventListener('click', this.toggleDropDown ) : null;
  },
  toggleMenu() {
    barraNavegacao.menuWrapper.classList.toggle('ativo')
  },
  checkTargetAndToggleMenu(event) {
    event.target === barraNavegacao.menuWrapper ? barraNavegacao.toggleMenu() : null;
  },
  historyBack() {
    window.history.back();
  },
  toggleDropDown() {
    this.classList.toggle('ativo');
  }
}

barraNavegacao.init();
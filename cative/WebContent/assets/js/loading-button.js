const btnLoading = {
  init() {
    let btnLoading = document.querySelectorAll('.jsLoading');
    btnLoading.forEach(btn => {
      btn.addEventListener('click', function (e) {
        this.textContent = '';
        this.classList.add('loading');
      });
    });
  }
}

btnLoading.init();
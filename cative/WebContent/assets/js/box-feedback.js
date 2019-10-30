const boxFeedback = {
  box: null,
  init() {
    boxFeedback.box = document.querySelector('.jsBoxFeedback');
    setTimeout(() => {
      boxFeedback.hide();
    },2000);
    
  },
  hide() {
    boxFeedback.box.classList.add('hide');
    setTimeout(() => {
      boxFeedback.box.remove();
    },2000);
  }
}

boxFeedback.init();
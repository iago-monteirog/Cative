const abas = {
  aba: null,
  init() {
    abas.aba = document.querySelectorAll('.jsAba');
    abas.aba.forEach(aba => {
      aba.addEventListener('click', abas.toggleConteudo );
    });
    abas.aba.forEach(aba => {
      aba.addEventListener('click', abas.ativaAba );
    });
  },
  toggleConteudo() {
    let aba = this.dataset.aba;
    let conteudo = document.querySelector(`[data-conteudo=${aba}]`);
    abas.desativaOAtivo();
    conteudo.classList.toggle('ativo');
  },
  desativaOAtivo() {
    let conteudoAtivo = document.querySelector('.jsConteudo.ativo');
    conteudoAtivo.classList.remove('ativo');
  },
  ativaAba() {
    abas.desativaAba();
    this.classList.add('ativo');
  },
  desativaAba() {
    let abaAtiva = document.querySelector('.jsAba.ativo');
    abaAtiva.classList.remove('ativo');
  }
}

abas.init();
let turmas = document.querySelectorAll('.jsTurma');
turmas.forEach(turma => {
  turma.addEventListener('click', function() {
    window.location.href = "turma.html";
  });
});

let alunos = document.querySelectorAll('.jsAluno');
alunos.forEach(turma => {
  turma.addEventListener('click', function() {
    let nomeAluno = this.querySelector('.aluno__nome').textContent;
    let fotoAluno = this.querySelector('.aluno__pic>img').src;
    
    localStorage.setItem("nomeAluno",nomeAluno);
    localStorage.setItem("fotoAluno",fotoAluno);
    window.location.href = "aluno.html";
  });
});

// tela do aluno
let alunoFoto = document.querySelector('.jsFotoPerfilArmazenado');
alunoFoto && !!localStorage.getItem('fotoAluno') ? 
alunoFoto.src = localStorage.getItem('fotoAluno') : null;

let nomePerfil = document.querySelector('.jsNomePerfil');
nomePerfil && !!localStorage.getItem('nomeAluno') ? 
nomePerfil.textContent = localStorage.getItem('nomeAluno') : null;

let opcaoCor = document.querySelectorAll('.jsOpcaoCor');
opcaoCor.forEach(cor => {
  cor.addEventListener('click', function() {
    let cor = this.querySelector('input').value;
    localStorage.setItem('corTema', cor);
  });
});

document.querySelectorAll('.jsCorPerfil').forEach(element => {
  !!localStorage.getItem('corTema') ? 
  element.style.background =  localStorage.getItem('corTema') : null;
});


// loading
let btnLoading = document.querySelectorAll('.jsLoading');
btnLoading.forEach(btn => {
  btn.addEventListener('click', function(e) {
    e.preventDefault();
    this.textContent = '';
    let url = this.href;
    this.classList.add('loading');
    
    !!url ? 
    setTimeout(function() {
      window.location.href = url;
    }, 2000) 
    : null;
  });
});


// Adicionando uma missão

let btnSalvaMissao = document.querySelector('.jsSalvaMissao');
if(!!btnSalvaMissao) {
  btnSalvaMissao.addEventListener('click', function(e) {
    this.textContent = '';
    let url = this.href;
    this.classList.add('loading');
    
    !!url ? 
    setTimeout(function() {
      window.location.href = url;
    }, 2000) 
    : null;

    let objetivo = document.querySelector('.jsObjetivoMissao').value;
    let imagem = document.querySelector('.jsImagemUpada').src;
    let detalhes = document.querySelector('.jsDetalhesMissao').value;
    let estrelas = document.querySelector('.jsPontuacaoEstrela.ativo>input').value;
    let cor = document.querySelector('.jsOpcaoCor.ativo>input').value;
    let turma = document.querySelector('.jsTurmaSelect').value;
    
    if(!!objetivo && !!imagem && !!detalhes && !!cor) {
      localStorage.setItem('missaoObjetivo', objetivo);
      localStorage.setItem('missaoImagem', imagem);
      localStorage.setItem('missaoDetalhes', detalhes);
      localStorage.setItem('missaoCor', cor);
      localStorage.setItem('missaoEstrelas', estrelas);
      localStorage.setItem('temMissaoCadastrada', true);
    }
    
  });  
}


// qualquer lugar com missões
let missoesWrapper = document.querySelector('.missoes');

if(localStorage.getItem('temMissaoCadastrada') === 'true') {
  if(!!missoesWrapper) {
    missoesWrapper.innerHTML += constroiCardMissao();
    let cards = document.querySelectorAll('.jsCardMissao');
    cards.forEach(card => card.addEventListener('click', cardMissao.handleClick))    
  } else {
  }
  console.log('tem missao cadastrada');
} else {
  console.log('não tem missao cadastrada');
}


function constroiCardMissao() {
  let card = `
  <div class="card-missao jsCardMissao" data-cor=${localStorage.getItem('missaoCor')} data-cod="a33" 
  data-descricao="${localStorage.getItem('missaoDetalhes')}" 
  data-titulo="${localStorage.getItem('missaoObjetivo')}"
  data-estrelas=${localStorage.getItem('missaoEstrelas')}>
  
  <div class="card-missao__imagem primary">
  <img src="${localStorage.getItem('missaoImagem')}" alt="Imagem da missão">
  </div>
  <div class="card-missao__body">
  <div class="card-missao__titulo">
  <h3>${localStorage.getItem('missaoObjetivo')}</h3>
  </div>
  <div class="card-missao__pontos">
  <i class="icon icon-star"></i>
  <span>${localStorage.getItem('missaoEstrelas')} estrelas</span>
  </div>
  </div>
  </div> 
  `
  return card;
  ;  
}

function reset() {
  localStorage.removeItem('temMissaoCadastrada');
}
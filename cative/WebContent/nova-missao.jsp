<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Nova missão</title>
  <link rel="stylesheet" href="./assets/css/main.min.css">
</head>

<body>
<jsp:include page="components/navegacao-professor.jsp"></jsp:include>
  
<section class="nova-missao">
  <form action="${pageContext.request.contextPath}/CadastraMissao" class="form" method="post">
    <div class="nova-missao__header">
      <h1>Nova missão</h1>
    </div>
    <div class="nova-missao__cover jsCapaMissao" tabindex="0">
      <input type="file" name="imagem_capa" class="nova-missao__cover-file-input jsInputUploadImagem" id="" accept='image/*'>
      <picture class="nova-missao__cover-image">
        <img src="./assets/img/icon-image.svg" class="jsImagemUpada" alt="Imagem da missão">
      </picture>
      <div class="nova-missao__cover-bottom">
        <p>Adicione uma imagem</p>
      </div>
    </div>
    <div class="nova-missao__form">
      <div class="form-control">
        <label for="" class="form-label">Objetivo</label>
        <input type="text" name="objetivo_missao" class="text-input completo jsCompletoQuandoSemFoco" value="Escovar os dentes">
      </div>
      
      <div class="form-control">
        <label for="" class="form-label">Descrição</label>
        <textarea name="descricao_missao" rows="5" class="textarea jsCompletoQuandoSemFoco">Lorem ipsum dolor sit amet consectetur adipisicing elit. 
        </textarea>
      </div>
      
      <div class="form-control">
        <label for="" class="form-label">Quantidade de estrelas</label>
        <div class="radio-pontuacoes">
          <div class="pontuacao jsPontuacaoEstrela ativo" tabindex="0">
            <input type="radio" class="radio-pontuacoes__input jsRadioInput" value="10" name="pontos" >
            <span class="pontuacao__estrela"></span>
            <span class="pontuacao__numero">10</span>
          </div>
          <div class="pontuacao jsPontuacaoEstrela" tabindex="0">
            <input type="radio" class="radio-pontuacoes__input jsRadioInput" value="30" name="pontos" >
            <span class="pontuacao__estrela"></span>
            <span class="pontuacao__numero">30</span>
          </div>
          <div class="pontuacao jsPontuacaoEstrela" tabindex="0">
            <input type="radio" class="radio-pontuacoes__input jsRadioInput" value="50" name="pontos" >
            <span class="pontuacao__estrela"></span>
            <span class="pontuacao__numero">50</span>
          </div>
        </div>
      </div>
      
      <div class="form-control">
        <label for="" class="form-label">Cor da missão</label>
        <div class="radio-cores">
          <div class="radio-cores__row">
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-success-dark">
              <input type="radio" value="#00b894" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-success-light ">
              <input type="radio" value="#00cec9" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-success">
              <input type="radio" value="#55efc4" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-primary-light">
              <input type="radio" value="#74b9ff" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-primary">
              <input type="radio" value="#0984e3" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
          </div>
          <div class="radio-cores__row">
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-danger">
              <input type="radio" value="#ff7675" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-pink  
            jsRadioInput ">
              <input type="radio" value="#fd79a8" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-pink-dark">
              <input type="radio" value="#e84393" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-purple">
              <input type="radio" value="#a29bfe" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
            <div  tabindex="0" class="radio__cor jsOpcaoCor bg-purple-dark">
              <input type="radio" value="#6c5ce7" class="radio-cores__input jsRadioInput" name="cor" >
            </div>
          </div>
        </div>
      </div>
      
      <div class="form-control">
        <label for="" class="form-label">Turma</label>
        <select name="" class="select-input" id="">
          <option value="classe a">Classe A</option>
          <option value="classe b">Classe B</option>
          <option value="classe c">Classe C</option>
          <option value="classe d">Classe D</option>
        </select>
      </div>
      
      <div class="form-submit">
        <button type="submit" class="button button--primary button--xs-small">
          Salvar
        </button>
      </div>
    </div>
  </form>
</section>
  
</body>

<script src="./assets/js/nova-missao.js"></script>
<script src="./assets/js/barra-navegacao.js"></script>
</html>
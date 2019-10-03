<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Cative | Adicione alunos</title>
  <link rel="stylesheet" href="./assets/css/main.min.css">
</head>

<body>
  <nav style="height: 58px; background: tomato">
    
  </nav>
  
  <section class="nova-missao">
    <div class="nova-missao__header">
      <h1>Nova missão</h1>
    </div>
    <div class="nova-missao__cover" tabindex="0">
      <picture class="nova-missao__cover-image">
        <img src="./assets/img/icon-image.svg" alt="Imagem da missão">
      </picture>
      <div class="nova-missao__cover-bottom">
        <p>Adicione uma imagem</p>
      </div>
    </div>
    <div class="nova-missao__form">
      <form action="" class="form" method="POST">
        <div class="form-control">
          <label for="" class="form-label">Objetivo</label>
          <input type="text" class="text-input completo" value="Escovar os dentes">
        </div>
        
        <div class="form-control">
          <label for="" class="form-label">Descrição</label>
          <textarea name="" id="" rows="5" class="textarea">Lorem ipsum dolor sit amet consectetur adipisicing elit. 
          </textarea>
        </div>
        
        <div class="form-control">
          <label for="" class="form-label">Quantidade de estrelas</label>
          <div class="radio-pontuacoes">
            <div class="pontuacao ativo" tabindex="0">
              <input type="radio" class="radio-pontuacoes__input" value="10" name="pontos" id="">
              <span class="pontuacao__estrela"></span>
              <span class="pontuacao__numero">10</span>
            </div>
            <div class="pontuacao" tabindex="0">
              <input type="radio" class="radio-pontuacoes__input" value="30" name="pontos" id="">
              <span class="pontuacao__estrela"></span>
              <span class="pontuacao__numero">30</span>
            </div>
            <div class="pontuacao" tabindex="0">
              <input type="radio" class="radio-pontuacoes__input" value="50" name="pontos" id="">
              <span class="pontuacao__estrela"></span>
              <span class="pontuacao__numero">50</span>
            </div>
          </div>
        </div>
        
        <div class="form-control">
          <label for="" class="form-label">Cor da missão</label>
          <div class="radio-cores">
            <div class="radio-cores__row">
              <div  tabindex="0" class="radio__cor bg-success-dark">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-success-light ">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-success">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-primary-light">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-primary">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
            </div>
            <div class="radio-cores__row">
              <div  tabindex="0" class="radio__cor bg-danger">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-pink ativo  
              ">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-pink-dark">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-purple">
                <input type="radio" class="radio-cores__input" name="cor" id="">
              </div>
              <div  tabindex="0" class="radio__cor bg-purple-dark">
                <input type="radio" class="radio-cores__input" name="cor" id="">
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
      </form>
    </div>
  </section>
  
</body>

<script src="./assets/js/main.js"></script>
</html>
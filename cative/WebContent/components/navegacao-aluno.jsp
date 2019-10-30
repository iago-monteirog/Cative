<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"

	import="br.com.cative.beans.Usuario"
	import="br.com.cative.dao.UsuarioDAO"
%>
<%
	UsuarioDAO dao = new UsuarioDAO();
	Usuario usuario = dao.getUsuario(1);
	
	String nome = usuario.getNome();
	//nome = nome.split(" ")[0];
	int estrelas = usuario.getPontuacao();
%> 
    
    <nav class="navegacao jsCorPerfil" style="background-color: ${param.cor}">
        <div class="navegacao__top">
            <div class="navegacao__back jsBack">
                <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M11.6803 19.1942L4.83378 
                    12.2221H19.8204C20.5344 12.2221 21.1139 11.6319 
                    21.1139 10.9048C21.1139 10.1777 20.5344 9.58759 
                    19.8204 9.58759H4.83378L11.6803 2.61545C12.1861 
                    2.10041 12.1861 1.2666 11.6803 0.752882C11.1746 
                    0.23916 10.3558 0.237842 9.85131 0.752882L0.796724 
                    9.97354C0.672547 10.1 0.579414 10.2449 0.516032 
                    10.4003C0.450063 10.561 0.417725 10.7336 0.417725 
                    10.9048C0.417725 11.242 0.544489 11.5792 0.796724 
                    11.8361L9.85131 21.0568C10.3571 21.5718 11.1759 
                    21.5718 11.6803 21.0568C12.1848 20.5417 12.1861 
                    19.7079 11.6803 19.1942V19.1942Z" fill="#2D3436" />
                </svg>
            </div>
            <div class="navegacao__title">
                <h1>${param.titulo}</h1>
            </div>
            <div class="navegacao__hamburguer">
                <div class="hamburguer jsHamburguer">
                    <svg width="29" height="20" viewBox="0 0 29 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M2.125 11.4166H26.875C27.634 11.4166 28.25 
                        10.782 28.25 9.99998C28.25 9.21798 27.634 8.58331 
                        26.875 8.58331H2.125C1.366 8.58331 0.75 9.21798 0.75 
                        9.99998C0.75 10.782 1.366 11.4166 2.125 
                        11.4166ZM2.125 2.91665H26.875C27.634 2.91665 28.25 
                        2.28198 28.25 1.49998C28.25 0.71798 27.634 0.083313 
                        26.875 0.083313H2.125C1.366 0.083313 0.75 0.71798 
                        0.75 1.49998C0.75 2.28198 1.366 2.91665 2.125 
                        2.91665ZM2.125 19.9166H26.875C27.634 19.9166 28.25 
                        19.282 28.25 18.5C28.25 17.718 27.634 17.0833 26.875 
                        17.0833H2.125C1.366 17.0833 0.75 17.718 0.75 
                        18.5C0.75 19.282 1.366 19.9166 2.125 19.9166Z" fill="#2D3436" />
                    </svg>
                </div>
            </div>
        </div>
        <div class="navegacao__overlay jsMenuMobile">
            <div class="navegacao__items">
                <div class="navegacao__top-items">
                    <div class="navegacao__perfil navegacao__item">
                        <div class="navegacao__column-1">
                            <div class="navegacao__perfil-pic">
                                <img src="https://placehold.it/1600x600" alt="">
                            </div>
                        </div>
                        <div class="navegacao__column-2">
                            <div class="navegacao__nome">
                                <% out.print(nome); %>
                            </div>
                            <div class="navegacao__estrelas">
                                <div class="navegacao__icon-estrela icon-star"></div>
                                <div class="navegacao__quantidade-estrelas"><% out.print(estrelas); %></div>
                            </div>
                        </div>
                    </div>
                    <div class="navegacao__link navegacao__item">
                        <a href="missoes.jsp">Missões</a>
                    </div>
                    <div class="navegacao__link navegacao__item">
                        <a href="aluno.jsp">Perfil</a>
                    </div>
                    <div class="navegacao__link navegacao__item">
                        <!-- <a href="">Evolução</a> -->
                    </div>
                </div>
                <div class="navegacao__bottom-items navegacao__item">
                    <div class="navegacao__get-out">
                        <a href="logout.jsp">Sair</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <nav class="navegacao--desktop jsCorPerfil" style="background-color: ${param.cor}">
        <div class="navegacao--desktop__container">
            <a href="missoes.jsp" tabindex="0">
                <span class="navegacao--desktop__logo"></span>
            </a>
            <div class="navegacao--desktop__items">
                <div class="navegacao--desktop__botao navegacao--desktop__item">
                </div>
                <div class="navegacao--desktop__link navegacao--desktop__item">
                    <a href="missoes.jsp">Missões</a>
                </div>
                <div class="navegacao--desktop__estrelas navegacao--desktop__item">
                    <div class="navegacao--desktop__icon-estrela"></div>
                    <div class="navegacao--desktop__quantidade-estrelas"><% out.print(estrelas); %></div>
                </div>
                <div class="navegacao--desktop__perfil navegacao--desktop__item tem-dropdown jsDropDownToggler ">
                    <div class="navegacao--desktop__perfil-wrap">
                        <svg width="29" height="36" viewBox="0 0 29 36" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M29 29.2271C29 32.4857 26.825 35.1428 24.1744 
                            35.1428H4.8256C2.175 35.1428 0 32.4871 0 29.2271C0 23.3571 
                            1.4732 16.5714 7.40805 16.5714C9.24375 18.3343 11.7349 
                            19.4285 14.5 19.4285C17.2652 19.4285 19.7563 18.3343 
                            21.592 16.5714C27.5283 16.5714 29 23.3571 29 29.2271ZM23.2 
                            9.42855C23.2 14.1614 19.3024 18 14.5 18C9.6976 18 5.8 
                            14.16 5.8 9.42855C5.8 4.69712 9.6976 0.857117 14.5 
                            0.857117C19.3024 0.857117 23.2 4.69712 23.2 9.42855Z" fill="#636E72" />
                        </svg>
                    </div>
                    <div class="dropdown">
                        <div class="dropdown__links">
                            <div class="dropdown__link">
                                <a href="aluno.jsp">Perfil</a>
                            </div>
                            <div class="dropdown__link">
                                <a href="logout.jsp">Sair</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>


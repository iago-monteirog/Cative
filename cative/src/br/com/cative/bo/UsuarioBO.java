package br.com.cative.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.cative.beans.Usuario;
import br.com.cative.dao.UsuarioDAO;

/**
 * Classe para validar as regras de negócio
 * @author Cative
 *
 */
public class UsuarioBO {
	
		/**
		 * Método para <b>validar<b> a quantidade de caracteres do
		 * nome, senha do usuário, se o e-mail está correto
		 * e verificar se o mesmo já existe no sistema
		 * @param user
		 * @return
		 * @throws Exception
		 */
		public String verificaUsuario(Usuario user) throws Exception{
		if(user.getNome().length()>20) {
			return "Nome inválido";
		}
		if(user.getSenha().length()<5 || user.getSenha().length()>21){
			return "Senha inválida";
		}
		if (user.getNome()==null) {
			return "Nome já cadastrado";
		}
		
		Pattern pattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");  
		Matcher matcher = pattern.matcher(user.getEmail());  

		if (!matcher.find()) {
			return "E-mail inválido";
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usu = dao.retornaEmail(user.getEmail());
	
		if(usu.getEmail() == null) {
			dao.addUsuarioBasic(user);
			return "Usuário Cadastrado!";
		} else {
			return "Usuário já existe!";
		}
	}
	

	
}

package br.com.cative.bo;
import br.com.cative.beans.Usuario;
import br.com.cative.dao.UsuarioDAO;

public class UsuarioBO {
	
	
	public boolean verificaUsuario(Usuario user) throws Exception{
		if (user.getIdUsuario()<=0) {
			System.out.println("Código inválido!");
			return false;
		}
		if(user.getNome().length()>20) {
			System.out.println("Nome inválido");
			return false;
		}
		if(user.getSenha().length()<8 || user.getSenha().length()>10){
			System.out.println("Senha inválida");
			return false;
		}
		
		if (user.getEmail().indexOf("@") > 0 && 
				user.getEmail().indexOf(".") > -1 && user.getEmail().indexOf("@.") == -1) {
			System.out.println("E-mail inválido");
			return false;
		}
	
	UsuarioDAO dao = new UsuarioDAO();
	Usuario usu = dao.getUsuario(user.getIdUsuario());
	if (usu.getIdUsuario()==0) {
		dao.addUsuario(user);
		System.out.println("Usuário Cadastrado!");
		return true;
	}else {
		System.out.println("Usuário já existe!");
		return false;
	}
	
	}
	

	
}

package service;

import java.util.HashMap;

import dao.UsuarioDAO;
import models.Usuario;

public class LoginService {

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	HashMap<String,String> simuladorBancoDeDados = new HashMap<String,String>();
	
	public LoginService() {
		simuladorBancoDeDados.put("FERNANDO", "123456");
		simuladorBancoDeDados.put("XAVIER", "123");
		simuladorBancoDeDados.put("ULISSES", "4");
	}
	
	public Usuario verificaLogin(Usuario usuarioTela) {
		
	
		Usuario usuarioRetornoBanco = usuarioDAO.consultaUsuario(usuarioTela.getLogin(), usuarioTela.getSenha());
		return usuarioRetornoBanco;
	}
}

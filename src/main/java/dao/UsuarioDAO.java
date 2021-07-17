package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Cliente;
import models.Usuario;

public class UsuarioDAO {

	public static void main(String[] args) {
		Usuario usuario = new UsuarioDAO().consultaUsuario("Paschoal", "Paschoal");
		System.out.println(usuario);
	}

	public Usuario consultaUsuario(String login, String senha) {
		
		Connection connection;
		Usuario usuario = null;
		Cliente cliente = null;
		try {
			connection = ConexaoDAO.getInstance().getConnection();
			
			//ConexaoDAO conexao = new ConexaoDAO();
			//connection = conexao.getConnection();
			
			String sql = "SELECT * FROM usuario"
					+ " inner join cliente on cliente.cpf = usuario.cpf"
					+ " WHERE login like '" + login + "'"
					+ " and senha like '" + senha + "';";
			
			Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        String cpf = "";
	        while(rs.next()) {
	        	usuario = new Usuario();
	        	usuario.setIdentificador(rs.getInt(1));
	        	usuario.setLogin(rs.getString(2));
	        	usuario.setSenha(rs.getString(3));
	        	
	        	cliente = new Cliente();
	        	cliente.setNome(rs.getString(5));
	        	cliente.setCpf(rs.getInt(6));
	        	cliente.setTelefone(rs.getInt(7));
	        	
	        	usuario.setCliente(cliente);
	        }
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			return usuario;
		}
	}
}

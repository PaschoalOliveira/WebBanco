package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Conta;
import models.Usuario;

public class ContaDAO {

	public Conta consultaConta(Integer cpf) {
		
		Connection connection;
		Conta conta = null;
		try {
			connection = ConexaoDAO.getInstance().getConnection();
			
			String sql = "SELECT * FROM conta"
					+ " WHERE cpf = " + cpf; 
			
			Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        while(rs.next()) {
	        	conta = new Conta();
	        	conta.setIdentificador(rs.getInt(1));
	        	conta.setSaldo(rs.getDouble(2));
	        }
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			return conta;
		}
	}
}

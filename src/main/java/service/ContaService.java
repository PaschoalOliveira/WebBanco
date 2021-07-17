package service;

import dao.ContaDAO;
import models.Cliente;
import models.Conta;

public class ContaService {

	ContaDAO contaDAO = new ContaDAO();
	
	public Conta consultaConta(Cliente clienteTela) {
		
		Conta contaBanco = contaDAO.consultaConta(clienteTela.getCpf());
		
		return contaBanco;
	}
}

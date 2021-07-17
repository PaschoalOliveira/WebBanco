package com;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Conta;
import models.Usuario;
import service.ContaService;
import service.LoginService;

@ManagedBean(name="entradaBean")	
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String senha;
    private String saldo;

	private String mensagemLogado;

    public String logar() {
    	
    	Usuario usuario = new Usuario();
    	
    	usuario.setLogin(this.getName());
    	usuario.setSenha(this.getSenha());
    	
    	LoginService loginService = new LoginService();
    	Usuario usuarioRetornoBanco = loginService.verificaLogin(usuario);
    	
    	if(usuarioRetornoBanco != null) {
    		this.setMensagemLogado("");
    		
    		Conta conta = new ContaService().consultaConta(usuarioRetornoBanco.getCliente());
    		this.setSaldo(String.valueOf(conta.getSaldo()));
    		return "tela_principal";
    	}else {
    		this.setMensagemLogado("Usuário ou senha inválidos!");
    		return "indexJsf";
    	}
    	
    }

    public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagemLogado() {
		return mensagemLogado;
	}

	public void setMensagemLogado(String mensagemLogado) {
		this.mensagemLogado = mensagemLogado;
	}
}

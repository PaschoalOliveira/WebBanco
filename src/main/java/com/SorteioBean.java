package com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlBody;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

@ManagedBean(name="sorteioBean")	
@SessionScoped
public class SorteioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public void mostarElementos() {
    	List<UIComponent> viewRootChildren = FacesContext.getCurrentInstance().getViewRoot().getChildren();
    	for(UIComponent child : viewRootChildren){
    	    if( child instanceof HtmlBody ){
    	        HtmlOutputText newText = new HtmlOutputText();
    	        newText.setValue("added dynamically");
    	        //child.add(newText);
    	    }
    	}
    }
    
    private String sorteado;
    private Boolean mostraTextoSorteado;

	public void sortear() {
		//1 lugar ganha 100 reais em curso no Udemy ou coursera, ou q outra platforma
		//2 lugar ganha 50 reais em curos
		//3 lugar ganha 28
		
    	ArrayList<String> candidatos = new ArrayList<String>();
    	candidatos.add("Tiago Gomes");
    	candidatos.add("Renato");
    	candidatos.add("Moisés");
    	candidatos.add("Caio Nunes");
    	candidatos.add("Luan");
    	candidatos.add("Alcimar");
    	candidatos.add("Felipe");
    	candidatos.add("Edson");
    	candidatos.add("Guilherme");
    	candidatos.add("Atila");
    	candidatos.add("Elias");
    	candidatos.add("Willian");
    	candidatos.add("Lucas");
    	candidatos.add("João Victor");
		
    	Random random = new Random();
    	Integer posicao = random.nextInt(candidatos.size());
    	
    	
    	try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	this.setSorteado(candidatos.get(posicao));
	 	
    	this.setMostraTextoSorteado(true);
    }
	
    public String getSorteado() {
		return sorteado;
	}

	public void setSorteado(String sorteado) {
		this.sorteado = sorteado;
	}
	
	public Boolean getMostraTextoSorteado() {
		return mostraTextoSorteado;
	}

	public void setMostraTextoSorteado(Boolean mostraTextoSorteado) {
		this.mostraTextoSorteado = mostraTextoSorteado;
	}
}

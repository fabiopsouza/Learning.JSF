package com.algaworks.cursojavaee.textarea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class SobreUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sobre;

	public void atualizar() {
		System.out.println("Sobre: " + this.sobre);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	public List<String> completarTexto(String consulta){
		List<String> resultados = new ArrayList<String>();
		
		if(consulta.startsWith("Fab")){
			resultados.add("Fabio");
			resultados.add("Fabio Pereira");
			resultados.add("Fabio Pereira de Souza");
		}
		
		return resultados;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
}
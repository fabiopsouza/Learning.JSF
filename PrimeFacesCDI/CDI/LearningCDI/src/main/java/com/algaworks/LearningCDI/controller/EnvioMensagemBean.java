package com.algaworks.LearningCDI.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.LearningCDI.service.Mensageiro;
import com.algaworks.LearningCDI.service.Urgente;

@Named
@RequestScoped
public class EnvioMensagemBean {

	@Inject 
	@Urgente  //Qualificador(MensageiroSMS)
	//@Default -> Vai para a implementação que nao tem qualificador
	private Mensageiro mensageiro;
	
	private String texto;
	
	public void enviarMensagem() {
		mensageiro.enviarMensagem(texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
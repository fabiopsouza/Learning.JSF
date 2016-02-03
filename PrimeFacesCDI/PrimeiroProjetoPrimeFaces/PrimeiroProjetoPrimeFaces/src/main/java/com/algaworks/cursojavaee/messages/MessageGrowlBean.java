package com.algaworks.cursojavaee.messages;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MessageGrowlBean {

	public void adicionarMensagemErro() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Resumo da mensagem de erro",
				"Mensagem de erro completa");
		
		context.addMessage("destinoErro", msg);
	}

	public void adicionarAvisoFlutuante() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resumo da mensagem de informação",
				"Mensagem de informação completa");
		
		context.addMessage("destinoAviso", msg);
	}

}

package com.algaworks.cursojsf2.visao;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.sun.prism.impl.BaseMesh.FaceMembers;

@ManagedBean
public class MensagensBean {

	private String nome;

	public void cadastrar(){
//		if(this.getNome() == null);
//			this.adicionarMensagem("frm:nome", FacesMessage.SEVERITY_ERROR, "Nome obrigatorio", "O preenchimento do nome é obrigatório.");
//			
		if(this.getNome().length() < 5)
			this.adicionarMensagem("frm:nome", FacesMessage.SEVERITY_WARN, "Nome incompleto", "O nome deve ter no mínimo 5 caracteres.");
		
		FacesContext context = FacesContext.getCurrentInstance();
		if(!context.getMessages().hasNext())
			this.adicionarMensagem(null, FacesMessage.SEVERITY_INFO, "Usuário cadastrado", "Usuário cadastrado com sucesso!");
	}
	
	private void adicionarMensagem(String clientId, Severity severity, String sumary, String detail){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(severity, sumary, detail);
		
		context.addMessage(clientId, message);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

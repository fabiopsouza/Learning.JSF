package com.algaworks.cursojsf2.visao;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
public class BackingBean {

	private HtmlInputText campo;
	private HtmlCommandButton botao;
	
	public void testar(){
		this.campo.setDisabled(!this.campo.isDisabled());
		this.botao.setStyle("background-color: " + (this.botao.getStyle().contains("red") ? "" : "red"));
	}
	
	public HtmlInputText getCampo() {
		return campo;
	}
	public void setCampo(HtmlInputText campo) {
		this.campo = campo;
	}
	public HtmlCommandButton getBotao() {
		return botao;
	}
	public void setBotao(HtmlCommandButton botao) {
		this.botao = botao;
	}
	
}

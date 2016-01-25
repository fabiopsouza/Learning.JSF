package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.financeiro.exception.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();

	@PostConstruct
	public void init() {
		this.pessoas = repositorios.getPessoas().todas();
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event){
		this.getLancamento().setPago((Boolean)event.getNewValue());
		this.getLancamento().setDataPagamento(null); //Limpa campo
		FacesContext.getCurrentInstance().renderResponse(); //Pula para última fase do JSF (sem validação/formatação)
	}
	
	public void salvar() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.salvar(getLancamento());
			this.setLancamento(new Lancamento());//Limpar tela
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento salvo com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		} catch (CloneNotSupportedException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}
	
	public boolean isEditando(){
		return this.lancamento.getCodigo() != null;
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
		this.lancamento = lancamento;
		
		if(this.lancamento == null){
			this.lancamento = new Lancamento();
		} else{
			this.lancamento = (Lancamento) lancamento.clone(); //clone() para tirar o attached do JPA que salva sózinho alterações no obj.
		}
 	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
}
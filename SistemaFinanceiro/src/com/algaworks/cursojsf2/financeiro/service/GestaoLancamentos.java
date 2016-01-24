package com.algaworks.cursojsf2.financeiro.service;

import javax.persistence.NoResultException;

import com.algaworks.cursojsf2.financeiro.exception.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;

public class GestaoLancamentos {

	private Lancamentos lancamentos;
	
	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException{
		if(existeLancamentoSemelhante(lancamento))
			throw new RegraNegocioException("Já existe uma lançamento iguai a esse");
		
		this.lancamentos.guardar(lancamento);
	}
	
	private boolean existeLancamentoSemelhante(Lancamento lancamento){
		try{
			Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
			return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
		}catch(Exception e){
			return false;
		}
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException{
		if(lancamento.isPago())
			throw new RegraNegocioException("Lancamento paga não pode ser excluído");
		
		this.lancamentos.remover(lancamento);
	}
	
}

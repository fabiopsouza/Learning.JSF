package com.algaworks.cursojsf2.financeiro.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

public class LancamentosHibernate implements Lancamentos{

	private EntityManager em;

	public LancamentosHibernate(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Lancamento> todos() {
		return em.createQuery("FROM Lancamento").getResultList();
	}

	@Override
	public Lancamento guardar(Lancamento lancamento) {
		return (Lancamento)em.merge(lancamento);
	}

	@Override
	public void remover(Lancamento lancamento) {
		lancamento = em.find(Lancamento.class, lancamento.getCodigo()); //attached
		em.remove(lancamento);
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		Query query = em.createQuery("SELECT l FROM Lancamento l "
									+ " WHERE l.tipo =:tipo "
									+ " AND l.pessoa =:pessoa "
									+ " AND l.descricao =:descricao "
									+ "	AND l.valor =:valor "
									+ " AND l.dataVencimento =:dataVencimento");
		
		query.setParameter("tipo", lancamento.getTipo());
		query.setParameter("pessoa", lancamento.getPessoa());
		query.setParameter("descricao", lancamento.getDescricao());
		query.setParameter("valor", lancamento.getValor());
		query.setParameter("dataVencimento", lancamento.getDataVencimento());
		
		Object obj = HibernateUtil.getSingleResultOrNull(query);
		return obj != null ? (Lancamento)obj : null;
	}

	@Override
	public Lancamento porCodigo(Integer codigo) {
		return this.em.find(Lancamento.class, codigo);
	}

}

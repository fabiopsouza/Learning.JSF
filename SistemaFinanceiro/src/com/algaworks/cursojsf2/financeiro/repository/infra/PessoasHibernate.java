package com.algaworks.cursojsf2.financeiro.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;

public class PessoasHibernate implements Pessoas{

	private EntityManager em;
	
	public PessoasHibernate(EntityManager em) {
		 this.em = em;
	}
	
	@Override
	public List<Pessoa> todas() {		
		return em.createQuery("FROM Pessoa").getResultList();
	}

	@Override
	public Pessoa porCodigo(Integer codigo) {
		return em.find(Pessoa.class, new Integer(codigo));
	}

}

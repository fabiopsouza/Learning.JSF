package com.algaworks.venda.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory; //Factory está para @ApplicationScoped e o resto RequestScoped (fabrica nao inicializa toda hora)
	
	public EntityManagerProducer(){
		factory = Persistence.createEntityManagerFactory("PedidoPU");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager em){
		em.close();
	}
}
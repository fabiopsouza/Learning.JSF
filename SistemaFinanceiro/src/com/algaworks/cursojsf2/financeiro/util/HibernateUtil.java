package com.algaworks.cursojsf2.financeiro.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HibernateUtil {
	
	private static EntityManagerFactory entityMenagerFactory = Persistence.createEntityManagerFactory("cursojsf");
	
	public EntityManager getEntityManager() {
		return entityMenagerFactory.createEntityManager();
	}
	
	public static Object getSingleResultOrNull(Query query){
        List results = query.getResultList();
        if (results.isEmpty()) return null;
        else if (results.size() == 1) return results.get(0);
        throw new NonUniqueResultException();
    }
}
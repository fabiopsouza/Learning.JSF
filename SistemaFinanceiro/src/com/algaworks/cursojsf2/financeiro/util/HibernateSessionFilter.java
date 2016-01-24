package com.algaworks.cursojsf2.financeiro.util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = { "Faces Servlet" }) // Servlet que inicia tudo no JSF
public class HibernateSessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HibernateUtil hbnUtil = new HibernateUtil();
		EntityManager em = hbnUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			request.setAttribute("entityManager", em);
			
			//Continua fases do JSF (se não chamar, fica parado nesse filtro)
			chain.doFilter(request, response); 
			
			em.getTransaction().commit();
		}catch(Exception e){
			if(em != null){
				em.getTransaction().rollback();
			}
		}finally{
			em.close();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
